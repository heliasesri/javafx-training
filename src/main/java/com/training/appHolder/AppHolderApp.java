package com.training.appHolder;

import com.training.map.src.MapController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AppHolderApp extends Application {

    private AppHolderController appHolderController;
    private MapController mapController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoaderHolder = new FXMLLoader(getClass().getResource("/fxml/appHolder.fxml"));
        StackPane root = fxmlLoaderHolder.load();

        appHolderController = fxmlLoaderHolder.getController();



        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        Node node = fxmlLoader.load();

        mapController = fxmlLoader.getController();
        mapController.setupStage(stage);

        appHolderController.addApplication("Map Application", node);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("App holder app");

        stage.show();
    }

    @Override
    public void stop() {
        if (mapController.getMapView() != null)
            mapController.getMapView().dispose();
    }
}