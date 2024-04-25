package com.example.game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.TextFlow;


public class AboutScene extends Application {
    @Override
    public void start(Stage primaryStage) {
        String aboutText = "Welcome to GravePulse, a high-octane journey where players face off against relentless enemies armed with projectiles. In this fast-paced adventure, players wield the power to switch gravity at will, unleashing bursts of firepower to overcome obstacles and adversaries alike. Navigate through hazardous environments, dodge enemy attacks, and strategically use gravity manipulation to emerge victorious.\n" +
                "\n" +
                "Your mission in GravePulse is clear: recover a key hidden within the chaos to unlock the door to victory. Master the art of gravity manipulation using the arrow keys to move, 'G' to switch gravity, and 'B' to unleash bursts of firepower. Are you prepared to confront the challenges that await and emerge as the ultimate champion in GravePulse? The fate of the game world rests in your hands.";
        Text aboutTextArea = new Text(aboutText);  Button backButton = new Button("Back");
        backButton.setAlignment(Pos.BOTTOM_RIGHT);
        aboutTextArea.setFont(Font.font(16));

        //Makes the text stay in the screen by slicing them automatically
        TextFlow textFlow = new TextFlow();
        textFlow.getChildren().add(aboutTextArea);

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.getChildren().add(textFlow);


        Label aboutLabel = new Label(aboutText);


        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainMenu mainScene = new MainMenu();
                mainScene.start(primaryStage);
            }
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("About Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);
    }
}
