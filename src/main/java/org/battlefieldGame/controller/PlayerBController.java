package org.battlefieldGame.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PlayerBController {

    @FXML
    private AnchorPane second;

    @FXML
    private CheckBox bT56;

    @FXML
    private CheckBox bBomb;

    @FXML
    private CheckBox bPistol;

    @FXML
    private CheckBox bMulti;

    @FXML
    private CheckBox bTank;

    @FXML
    private Label playB;

    static int score1 = 0;
    static int score2 =0;
    static int score3=0;
    static int score4=0;
    static int score5=0;

    PlayerBWeaponStore playerBWeaponStore = new PlayerBWeaponStore();

    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();

    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();

    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

    private final int maxNumSelected =  3;

    public void initialize(){
        configureCheckBox(bT56);
        configureCheckBox(bTank);
        configureCheckBox(bMulti);
        configureCheckBox(bPistol);
        configureCheckBox(bBomb);

        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
            if (newSelectedCount.intValue() >= maxNumSelected) {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(true));

            } else {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(false));

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
    void bBombAction(ActionEvent event) {
        if (bBomb.isSelected()){
            this.score5 = score5;
            score5= playerBWeaponStore.scoreBCalculateBomb();
            playB.setText(""+(score2+score1+score3+score4+score5));
        }else{
            score5 = 0;
            playB.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    @FXML
    void bMultiAction(ActionEvent event) {
        if (bMulti.isSelected()){
            this.score3 = score3;
            score3= playerBWeaponStore.scoreBCalculateMulti();
            playB.setText(""+(score2+score1+score3+score4+score5));
        }else{
            score3 = 0;
            playB.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    @FXML
    void bPistolAction(ActionEvent event) {
        if (bPistol.isSelected()){
            this.score4 = score4;
            score4= playerBWeaponStore.scoreBCalculatePistol();
            playB.setText(""+(score2+score1+score3+score4+score5));
        }else{
            score4 = 0;
            playB.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    @FXML
    void bT56Action(ActionEvent event) {
        if (bT56.isSelected()){
            this.score1 = score1;
            score1= playerBWeaponStore.scoreBCalculateT56();
            playB.setText(""+(score2+score1+score3+score4+score5));
        }else{
            score1 = 0;
            playB.setText(""+(score1+score2+score3+score4+score5));
        }
    }

    @FXML
    void bTankAction(ActionEvent event) {
        if (bTank.isSelected()){
            this.score2 = score2;
            score2= playerBWeaponStore.scoreBCalculateTank();
            playB.setText(""+(score2+score1+score3+score4+score5));
        }else{
            score2 = 0;
            playB.setText(""+(score1+score2+score3+score4+score5));
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

}
