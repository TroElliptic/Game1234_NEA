package com.example.game;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class LevelScene extends Application {
    @Override
    public void start(Stage primaryStage) {

        Button Level1 = new Button("Level1");
        Button Level2 = new Button("Level2");
        Button Level3 = new Button("Level3");
        Button Level4 = new Button("Level4");

       Level1.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               GameScene settingsScene = new GameScene();
               settingsScene.start(primaryStage);

           }
       });

        VBox Levels = new VBox(Level1, Level2, Level3, Level4);
        Scene scene = new Scene(Levels, 800, 600);
        Levels.setSpacing(20);
        Levels.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Level Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
