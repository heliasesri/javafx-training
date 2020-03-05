package com.training.appHolder;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class AppHolderModel {
    private StringProperty title = new SimpleStringProperty("Title");
    private StackPane stackPane;

    public AppHolderModel() {
    }


    public final String getTitle() {
        return title.get();
    }

    public final void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StackPane getStackPane() {
        return stackPane;
    }


    public void setStackPane(StackPane stackPane) {
        this.stackPane = stackPane;
    }
}
