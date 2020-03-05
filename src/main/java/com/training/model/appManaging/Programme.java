package com.training.model.appManaging;

import javafx.stage.Stage;

public class Programme  {

    protected String appName;
    protected Stage appStage;

    public Programme(String appName, Stage appStage) {
        this.appName = appName;
        this.appStage = appStage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Stage getAppStage() {
        return appStage;
    }

    public void setAppStage(Stage appStage) {
        this.appStage = appStage;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "appName='" + appName + '\'' +
                ", appStage=" + appStage +
                '}';
    }
}
