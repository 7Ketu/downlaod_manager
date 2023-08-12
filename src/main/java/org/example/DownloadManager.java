package org.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.config.AppConfig;
import org.example.models.FileInfo;

import java.io.File;
import java.text.DecimalFormat;

public class DownloadManager {

    @FXML
    private TableView<FileInfo> tableView;

    @FXML
    private TextField urlTextField;

    public int Index = 0;
    @FXML
    void downloadClicked(ActionEvent event) {

        String url = urlTextField.getText().trim();
        String fileName=url.substring(url.lastIndexOf("/")+1);
        String Status="Starting";
        String action= "Open";
        String path= AppConfig.Download_path+ File.separator+fileName;

        FileInfo file=new FileInfo((Index+1)+"",fileName, url, Status,"0", action, path);
        this.Index=this.Index+1;
        //thread call
        DownloadThread thread = new DownloadThread(file, this);

        this.tableView.getItems().add(Integer.parseInt(file.getIndex())-1,file);
        thread.start();


    }

    public void updateUI(FileInfo metaFile) {
        System.out.println(metaFile);
        FileInfo fileInfo = this.tableView.getItems().get(Integer.parseInt(metaFile.getIndex()) - 1);
        fileInfo.setStatus(metaFile.getStatus());
        DecimalFormat decimalFormat=new DecimalFormat("0.0");
        fileInfo.setPer(decimalFormat.format(Double.parseDouble(metaFile.getPer())));
        this.tableView.refresh();
        System.out.println("___________________");
    }

    public void initialize(){
        System.out.println("view initialized");

        TableColumn<FileInfo, String> sn = (TableColumn<FileInfo,String>)this.tableView.getColumns().get(0);
        sn.setCellValueFactory(p->{
            return p.getValue().indexProperty();
        });

        TableColumn<FileInfo, String> filename = (TableColumn<FileInfo,String>)this.tableView.getColumns().get(1);
        filename.setCellValueFactory(p->{
            return p.getValue().nameProperty();
        });

        TableColumn<FileInfo, String> url  = (TableColumn<FileInfo,String>)this.tableView.getColumns().get(2);
        url.setCellValueFactory(p->{
            return p.getValue().URLProperty();
        });

        TableColumn<FileInfo, String> status = (TableColumn<FileInfo,String>)this.tableView.getColumns().get(3);
        status.setCellValueFactory(p->{
            return p.getValue().statusProperty();
        });

        TableColumn<FileInfo, String> per = (TableColumn<FileInfo,String>)this.tableView.getColumns().get(4);
        per.setCellValueFactory(p->{
            SimpleStringProperty simpleStringProperty=new SimpleStringProperty();
            simpleStringProperty.set(p.getValue().getPer()+" %");
            return simpleStringProperty;
        });

        TableColumn<FileInfo, String> action = (TableColumn<FileInfo,String>)this.tableView.getColumns().get(5);
        action.setCellValueFactory(p->{
            return p.getValue().actionProperty();
        });
    }
}
