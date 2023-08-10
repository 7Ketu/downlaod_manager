package org.example.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.DownloadManager;

public class FileInfo {
    private SimpleStringProperty Index= new SimpleStringProperty();
    private SimpleStringProperty name=new SimpleStringProperty();
    private SimpleStringProperty URL=new SimpleStringProperty();
    private SimpleStringProperty Status=new SimpleStringProperty();
    private SimpleStringProperty path=new SimpleStringProperty();
//    private DownloadManager downloadManagerController;
// action

    private SimpleStringProperty action;

    public FileInfo(String Index, String name, String URL, String Status, String action, String path) {
        this.Index.set(Index);
        this.name.set(name);
        this.URL.set(URL);
        this.Status.set(Status);
        this.path.set(path);

    }

    public String getIndex() {
        return Index.get();
    }

    public SimpleStringProperty indexProperty() {
        return Index;
    }

    public void setIndex(String index) {
        this.Index.set(index);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getURL() {
        return URL.get();
    }

    public SimpleStringProperty URLProperty() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL.set(URL);
    }

    public String getStatus() {
        return Status.get();
    }

    public SimpleStringProperty statusProperty() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "Index=" + Index +
                ", name=" + name +
                ", URL=" + URL +
                ", Status=" + Status +
                ", path=" + path +
                ", action=" + action +
                '}';
    }
}
