package org.battlefieldGame.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationController {

    @FXML
    private AnchorPane startWindow;

    @FXML
    private Label labelTitle;

    @FXML
    private AnchorPane anchorMainA;

    @FXML
    private JFXButton selectA;

    @FXML
    private AnchorPane playerAWindow;

    @FXML
    private AnchorPane anchorMainB;

    @FXML
    private JFXButton selectB;

    @FXML
    private AnchorPane playerBWindow;

    @FXML
    private JFXButton BattleStart;

    @FXML
    void BattleStartOnAction(ActionEvent event) throws IOException {
        PlayerAController.scoreCount();
        PlayerBController.scoreCount();
        Stage stage = (Stage) startWindow.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ScoreDisplay.fxml"))));
        stage.centerOnScreen();
    }

    @FXML
    void SelectBOnAction(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/PlayerB.fxml"));
        playerBWindow.getChildren().add(load);
    }

    @FXML
    void selectAOnAction(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/PlayerA.fxml"));
        playerAWindow.getChildren().add(load);
    }

}
