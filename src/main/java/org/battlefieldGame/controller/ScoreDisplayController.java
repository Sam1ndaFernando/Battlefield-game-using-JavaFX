package org.battlefieldGame.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Navigation.fxml"))));
        stage.centerOnScreen();
    }

}
