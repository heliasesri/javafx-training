package com.mycompany.controller;

import com.mycompany.model.AppHolderModel;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AppHolderController implements Initializable {

    @FXML
    private Text txtTitle;
    @FXML
    private StackPane paneApp;


    private final AppHolderModel appHolder;

    public AppHolderController(AppHolderModel appHolder) {
        this.appHolder = appHolder;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtTitle.textProperty().bindBidirectional(appHolder.titleProperty());
    }

    public void setupAppholder(String title, Node app)
    {
        txtTitle.setText(title);
        paneApp = (StackPane) app;
    }

    @FXML
    protected void openApp(ActionEvent event) {
        System.out.println("I HAVE BEEN CLICKED");
    }





}
