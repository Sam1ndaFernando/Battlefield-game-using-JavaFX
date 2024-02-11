package org.battlefieldGame.controller;

import animatefx.animation.Pulse;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerAController implements Initializable {

    @FXML
    private AnchorPane first;

    @FXML
    private CheckBox aT56;

    @FXML
    private CheckBox aTank;

    @FXML
    private CheckBox aMulti;

    @FXML
    private CheckBox aPistol;

    @FXML
    private CheckBox aBomb;

    @FXML
    private Label playA;

    static int score1 = 0;
    static int score2 =0;
    static int score3=0;
    static int score4=0;
    static int score5=0;



    PlayerAWeaponStore playerAWeaponStore = new PlayerAWeaponStore();

    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();

    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();

    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

    private final int maxNumSelected =  3;

    public void initialize(){
        configureCheckBox(aT56);
        configureCheckBox(aTank);
        configureCheckBox(aMulti);
        configureCheckBox(aPistol);
        configureCheckBox(aBomb);

        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
            if (newSelectedCount.intValue() >= maxNumSelected) {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(true));
                // submitButton.setDisable(false);
            } else {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(false));
                // submitButton.setDisable(true);
            }
        });

    }

    public void configureCheckBox(CheckBox checkBox){
        if (checkBox.isSelected()) {
            selectedCheckBoxes.add(checkBox);
        } else {
            unselectedCheckBoxes.add(checkBox);
        }

        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }

        });

    }

    @FXML
    void aBombAction(ActionEvent event) {
        if (aBomb.isSelected()){
            this.score5 = score5;
            score5= playerAWeaponStore.scoreACalculateBomb();
            playA.setText(""+(score1+score2+score3+score4+score5));
        }else{
            score5 = 0;
            playA.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    @FXML
    void aMultiAction(ActionEvent event) {
        if (aMulti.isSelected()){
            this.score3 = score3;
            score3= playerAWeaponStore.scoreACalculateMulti();
            playA.setText(""+(score1+score2+score3+score4+score5));
        }else{
            score3 = 0;
            playA.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    @FXML
    void aPistolAction(ActionEvent event) {
        if (aPistol.isSelected()){
            this.score4 = score4;
            score4= playerAWeaponStore.scoreACalculatePistol();
            playA.setText(""+(score1+score2+score3+score4+score5));
        }else{
            score4 = 0;
            playA.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    @FXML
    void aT56Action(ActionEvent event) {
        if (aT56.isSelected()){
            this.score1 = score1;
            score1= playerAWeaponStore.scoreACalculateT56();
            playA.setText(""+(score1+score2+score3+score4+score5));

        }else{
            score1 = 0;
            playA.setText(""+(score1+score2+score3+score4+score5));
        }

    }

    @FXML
    void aTankAction(ActionEvent event) {
        if (aTank.isSelected()){
            this.score2 = score2;
            score2= playerAWeaponStore.scoreACalculateTank();
            playA.setText(""+(score1+score2+score3+score4+score5));
        }else{
            score2 = 0;
            playA.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    public static int scoreCount(){
        int score = score1+score2+score3+score4+score5;
        System.out.println(score);
        return score;
    }

    public static int removeScoreCount(){
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 =0;
        score5 =0;
        int removeCount = score1+score2+score3+score4+score5;
        return removeCount;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            new Pulse(first).play();
    }
}
