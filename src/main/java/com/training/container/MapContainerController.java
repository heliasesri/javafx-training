package com.training.container;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MapContainerController implements Initializable {

    @FXML
    private GridPane grdApplications;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getParentPaneSize();
    }

    public void getParentPaneSize() {
        anchorPane.setPrefWidth(stackPane.getPrefWidth() - 5);
        anchorPane.setPrefHeight(stackPane.getPrefHeight() - 5);
    }

    public void addApp(Node gridElement) {
        int size = grdApplications.getChildren().size();
        System.out.println(size);
        int numberOfRow = size / 4;
        int numberOfColumn = size % 4;

        System.out.println(numberOfRow + " " + numberOfColumn);

        grdApplications.add(gridElement, numberOfColumn, numberOfRow);


//        if(grdApplications.getChildren().size() / 3 )
//
//        grdApplications.getChildren().size()
//
//        for (Node node : grdApplications.getChildren()) {
//            System.out.println("HAHAHAHA" + node);
////            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
////                return node;
////            }
//        }
//        System.out.println(gridElement);

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

}
