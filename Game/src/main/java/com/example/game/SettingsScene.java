package com.example.game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class SettingsScene extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button backButton = new Button("Back");

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenu MainScene = new MainMenu();
                MainScene.start(primaryStage);
            }
        });

        VBox settingsMenu = new VBox(backButton);
        settingsMenu.setSpacing(20);
        settingsMenu.setAlignment(Pos.CENTER);
        Scene scene = new Scene(settingsMenu, 400, 300);
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
