// Obstacle.java
package robot_gui;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents a static obstacle in the robot arena.
 * Obstacles are immovable objects that robots must navigate around.
 */
public class Obstacle implements Serializable{
    private double x, y; // Position of the obstacle
    private static final int SIZE = 60; // Size of the obstacle

    /**
     * Constructs an obstacle with a specified position.
     *
     * @param x The x-coordinate of the obstacle.
     * @param y The y-coordinate of the obstacle.
     */
    public Obstacle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws the obstacle on the canvas.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GRAY); // Obstacle colour
        gc.fillRect(x, y, SIZE, SIZE); // Draw the obstacle as a square
    }

    /**
     * Checks if a robot collides with this obstacle.
     *
     * @param robot The robot to check for collision.
     * @return True if the robot collides with the obstacle; false otherwise.
     */
    public boolean isCollidingWithRobot(Robot robot) {
        double robotX = robot.getX();
        double robotY = robot.getY();
        double robotRadius = robot.getRadius();

        // Check for collision using bounding box overlap
        return robotX + robotRadius > x && robotX - robotRadius < x + SIZE &&
               robotY + robotRadius > y && robotY - robotRadius < y + SIZE;
    }

    /**
     * Gets the x-coordinate of the obstacle.
     *
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the obstacle.
     *
     * @return The y-coordinate.
     */
    public double getY() {
        return y;
    }
// Obstacle.java
package robot_gui;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents a static obstacle in the robot arena.
 * Obstacles are immovable objects that robots must navigate around.
 */
public class Obstacle implements Serializable{
    private double x, y; // Position of the obstacle
    private static final int SIZE = 60; // Size of the obstacle

    /**
     * Constructs an obstacle with a specified position.
     *
     * @param x The x-coordinate of the obstacle.
     * @param y The y-coordinate of the obstacle.
     */
    public Obstacle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws the obstacle on the canvas.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GRAY); // Obstacle colour
        gc.fillRect(x, y, SIZE, SIZE); // Draw the obstacle as a square
    }

    /**
     * Checks if a robot collides with this obstacle.
     *
     * @param robot The robot to check for collision.
     * @return True if the robot collides with the obstacle; false otherwise.
     */
    public boolean isCollidingWithRobot(Robot robot) {
        double robotX = robot.getX();
        double robotY = robot.getY();
        double robotRadius = robot.getRadius();

        // Check for collision using bounding box overlap
        return robotX + robotRadius > x && robotX - robotRadius < x + SIZE &&
               robotY + robotRadius > y && robotY - robotRadius < y + SIZE;
    }

    /**
     * Gets the x-coordinate of the obstacle.
     *
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the obstacle.
     *
     * @return The y-coordinate.
     */
    public double getY() {
        return y;
    }
}

