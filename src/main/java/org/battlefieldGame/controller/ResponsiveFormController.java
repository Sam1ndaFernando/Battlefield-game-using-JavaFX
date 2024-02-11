package org.battlefieldGame.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ResponsiveFormController {

    @FXML
    private AnchorPane startWindow;

    @FXML
    private JFXButton start;

    @FXML
    void startOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) startWindow.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Navigation.fxml"))));

        stage.centerOnScreen();
    }

}
