package com.training.map.src;


import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {

    @FXML
    private StackPane stackPaneID;
    @FXML
    private Button myButton;
    @FXML
    private MapView mapView;

    private Stage stage;

    private MapAppModel mapAppModel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mapAppModel = new MapAppModel();
        mapAppModel.setupMapView(mapView);

        myButton.toFront();
    }


    public void setupStage(Stage stage) {
        this.stage = stage;
        myButton.setVisible(true);
    }

    public MapView getMapView() {
        return mapView;
    }

    public void openFileDialog(ActionEvent actionEvent) {
        final FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            mapAppModel.openGeopackage(file,stackPaneID);
        }

    }
}
