package com.example.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Rectangle {
    private double x; // X coordinate of the enemy
    private double y; // Y coordinate of the enemy
    private double dx; // Velocity in the x direction
    private double width; // Width of the enemy
    private double height; // Height of the enemy

    public Enemy(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dx = 1; // Initial velocity
    }



    public void move(ArrayList<Rectangle> platforms, double sceneWidth) {
        // Move the enemy horizontally
        x += dx;

        // Check for collisions with platforms
        for (Rectangle platform : platforms) {
            if (platform.getBoundsInParent().intersects(x, y, width, height)) {
                // Collision detected, adjust enemy's position or velocity if needed
                // For example, you might want to stop the enemy from moving or change its direction
                // dx = -dx; // Reverse the direction of the enemy
            }
        }

        // Check bounds to keep the enemy within the scene
        if (x < 0 || x + width > sceneWidth) {
            // Reverse the direction if the enemy reaches the scene bounds
            dx = -dx;
        }
    }

    // Method to move the enemy left
    public void moveLeft() {
        dx = -Math.abs(dx); // Move left by setting velocity to negative
    }

    // Method to move the enemy right
    public void moveRight() {
        dx = Math.abs(dx); // Move right by setting velocity to positive
    }

    // Getters and setters for x, y, width, height properties
    public double getEnemyX() {
        return x;
    }

    public double getEnemyY() {
        return y;
    }

    public void setEnemyX(double x) {
        this.x = x;
    }

    public void setEnemyY(double y) {
        this.y = y;
    }

    public double getWidthEnemy() {
        return width;
    }

    public double getHeightEnemy() {
        return height;
    }

}