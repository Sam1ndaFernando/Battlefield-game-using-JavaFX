package org.battlefieldGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Appinitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Battle Field");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ResponsiveForm.fxml"))));

        // primaryStage.centerOnScreen();

        primaryStage.show();


    }
}