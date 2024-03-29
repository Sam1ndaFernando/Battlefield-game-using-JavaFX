package org.battlefieldGame.controller;

import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreDisplayController {

    @FXML
    private AnchorPane scoreWindow;

    @FXML
    private AnchorPane scoreDisplay;

    @FXML
    private Label winner;

    @FXML
    private JFXButton playAgain;

    public void initialize(){
        new Pulse(scoreDisplay).play();
        if (PlayerAController.scoreCount()>PlayerBController.scoreCount()){
            winner.setText("Player A Wins!!!!!  Score "+PlayerAController.scoreCount());

        }else{
            winner.setText("Player B Wins!!!!!  Score "+PlayerBController.scoreCount());
        }
    }
    @FXML
    void playAgainOnAction(ActionEvent event) throws IOException {
        PlayerAController.removeScoreCount();
        PlayerBController.removeScoreCount();
        Stage stage = (Stage) scoreWindow.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Navigation.fxml"))));
        stage.centerOnScreen();
    }

}
