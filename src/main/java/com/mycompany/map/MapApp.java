package com.mycompany.map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MapApp extends Application {

    private MapController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        StackPane root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("My Map App");

        controller = fxmlLoader.getController();
        controller.setupStage(stage);
        stage.show();

    }

    @Override
    public void stop() {
        if (controller.getMapView() != null)
            controller.getMapView().dispose();
    }
}
