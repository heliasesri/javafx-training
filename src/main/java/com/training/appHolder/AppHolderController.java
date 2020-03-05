package com.training.appHolder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AppHolderController implements Initializable {

    @FXML
    private Text txtTitle;
    @FXML
    private StackPane stackPane;

    private AppHolderModel appHolder;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        appHolder = new AppHolderModel();
//        appHolder.setStackPane(stackPane);
        txtTitle.textProperty().bindBidirectional(appHolder.titleProperty());

        appHolder.setStackPane(this.stackPane);

    }

    public void addApplication(String appName, Node node) {

        StackPane myStackPane = appHolder.getStackPane();
        myStackPane.getChildren().add(node);

        appHolder.setTitle(appName);
        //appHolder.addNodeStack(stackPane);
        //txtTitle.setText(appName);
        //this.stackPane.getChildren().add(stackPane);
        //this.stackPane = stackPane;

        //appHolder.setNormalString(test);
        //this.stackPane = stackPane;
    }

    @FXML
    protected void openApp(ActionEvent event) {
        System.out.println("I HAVE BEEN CLICKED");
    }

}
