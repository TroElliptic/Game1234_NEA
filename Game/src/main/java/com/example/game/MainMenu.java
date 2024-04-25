package com.example.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class MainMenu extends Application {


    @Override
    public void start(Stage primaryStage) {

        Label gameNameLabel = new Label("GravePulse");
        gameNameLabel.setFont(Font.font("Arial", 45)); // Set font size and style
        gameNameLabel.setStyle("-fx-font-weight: bold;");

        //Create the buttons
        Button levelsButton = new Button("Levels");
        Button settingsButton = new Button("Settings");
        Button aboutButton = new Button("About");
        Button exitButton = new Button("Exit");




        // Create a VBox to hold the buttons
        //Create the on Action event when buttons are clicked
        levelsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LevelScene levelScene = new LevelScene();
                levelScene.start(primaryStage);
            }
        });
        settingsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SettingsScene settingsScene = new SettingsScene();
                settingsScene.start(primaryStage);

            }
        });
        aboutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AboutScene aboutScene = new AboutScene();
                aboutScene.start(primaryStage);
            }
        });
        //Exit the game
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        VBox mainMenu = new VBox(gameNameLabel,levelsButton, settingsButton, aboutButton, exitButton);



        //Set full Screen
        primaryStage.setFullScreen(true);
        // Set the spacing between the buttons
        mainMenu.setSpacing(20);
        mainMenu.setAlignment(Pos.CENTER);
        //Create The Main Scene
        Scene scene = new Scene(mainMenu, 800, 600);
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}