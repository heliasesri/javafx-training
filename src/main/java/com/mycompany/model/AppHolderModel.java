package com.mycompany.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class AppHolderModel {
    private  StringProperty title = new SimpleStringProperty("Title");
    private  ObjectProperty<Node> sceneView = new SimpleObjectProperty<Node>(new StackPane());

    public final String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public final void setTitle(String title) {
        this.title.set(title);
    }

    public final Node getSceneView() {
        return sceneView.get();
    }

    public ObjectProperty<Node> sceneViewProperty() {
        return sceneView;
    }

    public final void setSceneView(Node sceneView) {
        this.sceneView.set(sceneView);
    }
}
