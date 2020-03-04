package com.mycompany.model.appManaging;

import javafx.fxml.FXMLLoader;

import java.util.List;

public class AppManager {
    private String name;
    private List<FXMLLoader> loaderList;

    public AppManager(String name, List<FXMLLoader> loaderList) {
        this.name = name;
        this.loaderList = loaderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FXMLLoader> getLoaderList() {
        return loaderList;
    }

    public void setLoaderList(List<FXMLLoader> loaderList) {
        this.loaderList = loaderList;
    }

    @Override
    public String toString() {
        return "AppManager{" +
                "name='" + name + '\'' +
                ", loaderList=" + loaderList +
                '}';
    }
}
