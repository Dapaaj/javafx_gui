// Robot.java
package robot_gui;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents a base class for all types of robots in the arena.
 * Provides common properties and behaviours such as movement, drawing, and collision handling.
 */
public class Robot implements Serializable{
    protected double dx, dy; // Robot's position
    protected int robotID; // Unique ID for the robot
    protected Direction.selectDirection facing; // Robot's direction
    protected String name; // Name of the robot
    protected int robotRadius; // Individual radius for each robot
    public static int robotCount = 1; // Static counter for assigning robot IDs
    public boolean isFrozen = false; // Tracks if the robot is frozen

    /**
     * Constructs a Robot with a specified position and direction.
     *
     * @param x The initial x-coordinate of the robot.
     * @param y The initial y-coordinate of the robot.
     * @param f The initial direction the robot is facing.
     */
    public Robot(int x, int y, Direction.selectDirection f) {
        dx = x;
        dy = y;
        robotID = robotCount++;
        facing = f;
        name = "Robot" + robotID;
        robotRadius = ArenaCanvas.ROBOT_RADIUS; // Default radius
    }

    /**
     * Gets the x-coordinate of the robot.
     *
     * @return The x-coordinate of the robot.
     */
    public double getX() {
        return dx;
    }

    /**
     * Gets the y-coordinate of the robot.
     *
     * @return The y-coordinate of the robot.
     */
    public double getY() {
        return dy;
    }

    /**
     * Gets the name of the robot.
     *
     * @return The name of the robot.
     */
    public String getName() {
        return name;
    }
    /**
     * Provides a string representation of the robot's state.
     * This is used for display in the ListView.
     *
     * @return A string with the robot's name, position, and direction.
     */
    public String toString1() {
// Robot.java
package robot_gui;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents a base class for all types of robots in the arena.
 * Provides common properties and behaviours such as movement, drawing, and collision handling.
 */
public class Robot implements Serializable{
    protected double dx, dy; // Robot's position
    protected int robotID; // Unique ID for the robot
    protected Direction.selectDirection facing; // Robot's direction
    protected String name; // Name of the robot
    protected int robotRadius; // Individual radius for each robot
    public static int robotCount = 1; // Static counter for assigning robot IDs
    public boolean isFrozen = false; // Tracks if the robot is frozen

    /**
     * Constructs a Robot with a specified position and direction.
     *
     * @param x The initial x-coordinate of the robot.
     * @param y The initial y-coordinate of the robot.
     * @param f The initial direction the robot is facing.
     */
    public Robot(int x, int y, Direction.selectDirection f) {
        dx = x;
        dy = y;
        robotID = robotCount++;
        facing = f;
        name = "Robot" + robotID;
        robotRadius = ArenaCanvas.ROBOT_RADIUS; // Default radius
    }

    /**
     * Gets the x-coordinate of the robot.
     *
     * @return The x-coordinate of the robot.
     */
    public double getX() {
        return dx;
    }

    /**
     * Gets the y-coordinate of the robot.
     *
     * @return The y-coordinate of the robot.
     */
    public double getY() {
        return dy;
    }

    /**
     * Gets the name of the robot.
     *
     * @return The name of the robot.
     */
    public String getName() {
        return name;
    }
    /**
     * Provides a string representation of the robot's state.
     * This is used for display in the ListView.
     *
     * @return A string with the robot's name, position, and direction.
     */
    public String toString1() {
        return name + " at (" + Math.round(dx) + ", " + Math.round(dy) + ") facing " + facing;
    }
    /**
     * Gets the radius of the robot.
     *
     * @return The radius of the robot.
     */
    public int getRadius() {
        return robotRadius;
    }

    /**
     * Sets the radius of the robot.
     *
     * @param radius The new radius of the robot.
     */
    public void setRadius(int radius) {
        this.robotRadius = radius;
    }

    /**
     * Reverses the direction of the robot.
     * This is used when the robot encounters obstacles or collisions.
     */
    public void reverseDirection() {
        facing = facing.getNextDirection(
            facing.getNextDirection(
                facing.getNextDirection(
                    facing.getNextDirection(facing)
                )
            )
        );
    }

    /**
     * Draws the robot on the canvas.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public void draw(GraphicsContext gc) {
        // Draw the robot's body
        gc.setFill(Color.RED);
        gc.fillOval(dx - robotRadius, dy - robotRadius, robotRadius * 2, robotRadius * 2);

        // Draw wheels as black rectangles
        gc.setFill(Color.BLACK);
        double wheelWidth = robotRadius * 0.6;
        double wheelHeight = robotRadius * 0.2;

        // Top wheel
        gc.fillRect(dx - wheelWidth / 2, dy - robotRadius - wheelHeight, wheelWidth, wheelHeight);
        // Bottom wheel
        gc.fillRect(dx - wheelWidth / 2, dy + robotRadius, wheelWidth, wheelHeight);

        // Draw the robot's name (ID) above the robot
        gc.setFill(Color.BLACK);
        gc.fillText(getName(), dx - robotRadius, dy - robotRadius - 10);
    }

    /**
     * Handles the movement logic of the robot within the arena.
     * If the robot is frozen, it does not move.
     *
     * @param arena The RobotArena containing the robot.
     */
    public void tryToMove(RobotArena arena) {
        if (isFrozen) {
            return; // Skip movement if the robot is frozen
        }

        return name + " at (" + Math.round(dx) + ", " + Math.round(dy) + ") facing " + facing;
    }
    /**
     * Gets the radius of the robot.
     *
     * @return The radius of the robot.
     */
    public int getRadius() {
        return robotRadius;
    }

    /**
     * Sets the radius of the robot.
     *
     * @param radius The new radius of the robot.
     */
    public void setRadius(int radius) {
        this.robotRadius = radius;
    }

    /**
     * Reverses the direction of the robot.
     * This is used when the robot encounters obstacles or collisions.
     */
    public void reverseDirection() {
        facing = facing.getNextDirection(
            facing.getNextDirection(
                facing.getNextDirection(
                    facing.getNextDirection(facing)
                )
            )
        );
    }

    /**
     * Draws the robot on the canvas.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public void draw(GraphicsContext gc) {
        // Draw the robot's body
        gc.setFill(Color.RED);
        gc.fillOval(dx - robotRadius, dy - robotRadius, robotRadius * 2, robotRadius * 2);

        // Draw wheels as black rectangles
        gc.setFill(Color.BLACK);
        double wheelWidth = robotRadius * 0.6;
        double wheelHeight = robotRadius * 0.2;

        // Top wheel
        gc.fillRect(dx - wheelWidth / 2, dy - robotRadius - wheelHeight, wheelWidth, wheelHeight);
        // Bottom wheel
        gc.fillRect(dx - wheelWidth / 2, dy + robotRadius, wheelWidth, wheelHeight);

        // Draw the robot's name (ID) above the robot
        gc.setFill(Color.BLACK);
        gc.fillText(getName(), dx - robotRadius, dy - robotRadius - 10);
    }

    /**
     * Handles the movement logic of the robot within the arena.
     * If the robot is frozen, it does not move.
     *
     * @param arena The RobotArena containing the robot.
     */
    public void tryToMove(RobotArena arena) {
        if (isFrozen) {
            return; // Skip movement if the robot is frozen
        }

        double horizontal = dx, vertical = dy;
        switch (facing) {
            case North:
                vertical += 1;
                break;
            case NorthNorthEast:
                horizontal += 0.5;
                vertical += 1;
                break;
            case EastNorthEast:
                horizontal += 1;
                vertical += 0.5;
                break;
            case NorthEast:
                horizontal += 1;
                vertical += 1;
                break;
            case NorthNorthWest:
                horizontal -= 0.5;
                vertical += 1;
                break;
            case WestNorthWest:
                horizontal -= 1;
                vertical += 0.5;
                break;
            case NorthWest:
                horizontal -= 1;
                vertical += 1;
                break;
            case East:
                horizontal += 1;
                break;
            case EastSouthEast:
                horizontal += 1;
                vertical -= 0.5;
                break;
            case SouthSouthEast:
                horizontal += 0.5;
                vertical -= 1;
                break;
            case South:
                vertical -= 1;
                break;
            case SouthEast:
                horizontal += 1;
                vertical -= 1;
                break;
            case WestSouthWest:
                horizontal -= 1;
                vertical -= 0.5;
                break;
            case SouthSouthWest:
                horizontal -= 0.5;
                vertical -= 1;
                break;
            case SouthWest:
                horizontal -= 1;
                vertical -= 1;
                break;
            case West:
                horizontal -= 1;
                break;
        }

        if (arena.canMoveHere(horizontal, vertical)) {
            dx = horizontal;
            dy = vertical;
            System.out.println(toString1());
        } else {
            reverseDirection(); // Reverse direction if movement is blocked
        double horizontal = dx, vertical = dy;
        switch (facing) {
            case North:
                vertical += 1;
                break;
            case NorthNorthEast:
                horizontal += 0.5;
                vertical += 1;
                break;
            case EastNorthEast:
                horizontal += 1;
                vertical += 0.5;
                break;
            case NorthEast:
                horizontal += 1;
                vertical += 1;
                break;
            case NorthNorthWest:
                horizontal -= 0.5;
                vertical += 1;
                break;
            case WestNorthWest:
                horizontal -= 1;
                vertical += 0.5;
                break;
            case NorthWest:
                horizontal -= 1;
                vertical += 1;
                break;
            case East:
                horizontal += 1;
                break;
            case EastSouthEast:
                horizontal += 1;
                vertical -= 0.5;
                break;
            case SouthSouthEast:
                horizontal += 0.5;
                vertical -= 1;
                break;
            case South:
                vertical -= 1;
                break;
            case SouthEast:
                horizontal += 1;
                vertical -= 1;
                break;
            case WestSouthWest:
                horizontal -= 1;
                vertical -= 0.5;
                break;
            case SouthSouthWest:
                horizontal -= 0.5;
                vertical -= 1;
                break;
            case SouthWest:
                horizontal -= 1;
                vertical -= 1;
                break;
            case West:
                horizontal -= 1;
                break;
        }

        if (arena.canMoveHere(horizontal, vertical)) {
            dx = horizontal;
            dy = vertical;
            System.out.println(toString1());
        } else {
            reverseDirection(); // Reverse direction if movement is blocked
        }
    }

    /**
     * Returns a string representation of the robot, including its ID, position, and direction.
     *
     * @return A string representing the robot's state.
     */
    @Override
    public String toString() {
        return "Robot " + robotID + " at " + Math.round(dx) + "," + Math.round(dy) + " facing " + facing + ".";
    }
}
