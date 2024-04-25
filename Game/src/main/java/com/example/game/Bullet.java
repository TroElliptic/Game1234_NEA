package com.example.game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Bullet {
    ImageView blt;
    double x, y;



    Bullet(double startX, double startY){
        blt = new ImageView(new Image(getClass().getResourceAsStream("bullet.png")));
        blt.setPreserveRatio(true);
        blt.setFitHeight(40);
        blt.setFitWidth(20);
        blt.setRotate(180);
        x = startX+10;
        y = startY+100;
        blt.setLayoutX(x);
        blt.setLayoutY(y);
    }
    public void move(){
        x = x-10;
        blt.setLayoutX(x);
        blt.setLayoutY(y);

    }
}
