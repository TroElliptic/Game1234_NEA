package com.example.game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;



public class GameScene extends Application {

    private List<Rectangle> platforms;

    private Pane root;
    private Rectangle character;

    private double dx = 0;
    private double dy = 0;
    private boolean isJumping = false;
    private double enemySpeed = 2;
    private boolean isSwitched = false;
    private Enemy enemy;
    private double sceneWidth = 1920;
    private List<Enemy> enemies = new ArrayList<>();
    private boolean side = true;
    private int gx = 300, gy = 500;
    ArrayList<Bullet> Bullet = new ArrayList();


    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Character Platform Game");
        // Creating the character
        character = new Rectangle(100, 100, Color.BLUE);
        character.setTranslateX(300);
        character.setTranslateY(540);
        root.getChildren().add(character);

        //create the platform
        platforms = new ArrayList<>();
        createPlatform(0, 540, 500, 25, Color.BLACK);
        createPlatform(300, 300, 300, 25, Color.BLACK);
        createPlatform(800, 560, 400, 25, Color.BLACK);


        //create enemy
        enemy = new Enemy(1000, 510, 50, 50);
        root.getChildren().add(enemy);

        // Create a graphical representation of the enemy
        Rectangle enemyRectangle = new Rectangle(enemy.getEnemyX(), enemy.getEnemyY(), enemy.getWidthEnemy(), enemy.getHeightEnemy());
        enemyRectangle.setFill(Color.RED); // Set color
        root.getChildren().add(enemyRectangle);



        // Handling keyboard input for character movement
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                dx = -10;
            } else if (event.getCode() == KeyCode.RIGHT) {
                dx = 10;
            } else if (event.getCode() == KeyCode.UP && !isJumping) {
                dy = -15;
                isJumping = true;
            } else if (event.getCode() == KeyCode.G) {
                dy -= 1;
            }

            if (event.getCode() == KeyCode.SPACE)
            {
                if (side)
                {
                    Bullet bult = new Bullet(gx, gy);
                    Bullet.add(bult);
                    root.getChildren().add(bult.blt);

                }


            }

        });
        // Handling key release to stop character movement
        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
                dx = 0;
            }
        });
        // AnimationTimer to continuously update the game state
        AnimationTimer timer1 = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                moveEnemy();
                checkCollisions();

                for (Bullet l : Bullet)
                {
                    l.move();
                }
            }

        };
        timer1.start();


        primaryStage.show();
    }
    //creates the platforms
    private void createPlatform(double x, double y, double width, double height, Color color) {
        Rectangle platform = new Rectangle(width, height, color);
        platform.setTranslateX(x);
        platform.setTranslateY(y);
        root.getChildren().add(platform);
        platforms.add(platform);
    }

    private void update() {
        // Apply gravity
        dy += 1;

        // Update character position
        character.setTranslateX(character.getTranslateX() + dx);
        character.setTranslateY(character.getTranslateY() + dy);

        // Collision detection with the platform
        for (Rectangle platform : platforms) {
            if (character.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                isJumping = false;
                dy = 0;
                character.setTranslateY(platform.getTranslateY() - character.getHeight());
            }
        }

        // Update enemy behaviors


    }
    private void checkCollisions() {
        // Iterate through enemies to check collision with player
        for (Rectangle Enemy : enemies) {
            if (character.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
                // Collision detected between player and enemy
                // Remove the player from the scene
                root.getChildren().remove(character);
                // Optionally, you can also remove the player from the game or reset its position
            }
        }
    }


    private void moveEnemy() {
        if (enemy != null) {
            enemy.move((ArrayList<Rectangle>) platforms, sceneWidth); // Pass platforms and scene width if needed
        }
    }

    public static void main (String[]args){
        launch(args);
    }
}
