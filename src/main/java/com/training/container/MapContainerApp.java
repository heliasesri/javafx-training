package com.training.container;

import com.training.appHolder.AppHolderController;
import com.training.appHolder.AppHolderModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MapContainerApp extends Application {

    private MapContainerController mapContainerController;
    private AppHolderController appHolderController;
    private StackPane container;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mapContainer.fxml"));

        container = fxmlLoader.load();
        mapContainerController = fxmlLoader.getController();

        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.setTitle("MapContainer");

        stage.show();

        container.widthProperty().addListener((obs, oldVal, newVal) -> {
            container.setPrefWidth((Double) newVal);
            mapContainerController.getParentPaneSize();
        });

        container.heightProperty().addListener((obs, oldVal, newVal) -> {
            container.setPrefHeight((Double) newVal);
            mapContainerController.getParentPaneSize();
        });

        GetApplications();
        
    }

    private void GetApplications() throws IOException {

        FXMLLoader fxmlLoaderHolder = new FXMLLoader(getClass().getResource("/fxml/appHolder.fxml"));
        AppHolderModel appHolderModel = new AppHolderModel();
        fxmlLoaderHolder.setController(appHolderController);
        appHolderController = fxmlLoaderHolder.getController();

        Parent parent = fxmlLoaderHolder.load();

        FXMLLoader fxmlLoaderMap = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        StackPane stackPane = fxmlLoaderMap.load();

        mapContainerController.addApp(stackPane);
        fxmlLoaderMap = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        stackPane = fxmlLoaderMap.load();
        mapContainerController.addApp(stackPane);

        fxmlLoaderMap = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        stackPane = fxmlLoaderMap.load();
        mapContainerController.addApp(stackPane);

        fxmlLoaderMap = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        stackPane = fxmlLoaderMap.load();
        mapContainerController.addApp(stackPane);

        fxmlLoaderMap = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        stackPane = fxmlLoaderMap.load();
        mapContainerController.addApp(stackPane);


        fxmlLoaderMap = new FXMLLoader(getClass().getResource("/fxml/map.fxml"));
        stackPane = fxmlLoaderMap.load();
        mapContainerController.addApp(stackPane);






//        ScrollPane scrollPane = (ScrollPane) root.getChildren().get(0);
//        AnchorPane anchorPane = (AnchorPane) scrollPane.getContent();
//        GridPane gridPane = (GridPane) anchorPane.getChildren().get(0);


        //gridPane.add(stackPane, 2, 0);
        //gridPane.add(parent, 0, 2);


    }


    @Override
    public void stop() throws Exception {
        container.widthProperty().removeListener((obs, oldVal, newVal) -> {
            container.setPrefWidth((Double) newVal);
            mapContainerController.getParentPaneSize();
        });

        container.heightProperty().removeListener((obs, oldVal, newVal) -> {
            container.setPrefHeight((Double) newVal);
            mapContainerController.getParentPaneSize();
        });
    }
}
