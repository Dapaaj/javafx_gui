// EngulfRobot.java
package robot_gui;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents a specialised robot that can "engulf" other robots upon collision.
 * The EngulfRobot removes other robots from the arena when it collides with them.
 */
public class EngulfRobot extends Robot implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an EngulfRobot with a specified initial position and direction.
     *
     * @param x The initial x-coordinate of the robot.
     * @param y The initial y-coordinate of the robot.
     * @param f The initial direction the robot is facing.
     */
    public EngulfRobot(int x, int y, Direction.selectDirection f) {
        super(x, y, f); // Call the parent class constructor
    }

    /**
     * Attempts to move the EngulfRobot within the arena and handles collisions.
     * If a collision with another robot occurs, the collided robot is removed from the arena.
     *
     * @param arena The RobotArena containing the EngulfRobot and other robots.
     */
    @Override
    public void tryToMove(RobotArena arena) {
        double horizontal = getX(), vertical = getY();

        // Calculate movement based on direction
        switch (facing) {
            case North:
                vertical += 1.5;
                break;
            case NorthNorthEast:
                horizontal += 0.75;
                vertical += 1.5;
                break;
            case EastNorthEast:
                horizontal += 1.5;
                vertical += 0.75;
                break;
            case NorthEast:
                horizontal += 1.5;
                vertical += 1.5;
                break;
            case NorthNorthWest:
                horizontal -= 0.75;
                vertical += 1.5;
                break;
            case WestNorthWest:
                horizontal -= 1.5;
                vertical += 0.75;
                break;
            case NorthWest:
                horizontal -= 1.5;
                vertical += 1.5;
                break;
            case East:
                horizontal += 1.5;
                break;
            case EastSouthEast:
                horizontal += 1.5;
// EngulfRobot.java
package robot_gui;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents a specialised robot that can "engulf" other robots upon collision.
 * The EngulfRobot removes other robots from the arena when it collides with them.
 */
public class EngulfRobot extends Robot implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an EngulfRobot with a specified initial position and direction.
     *
     * @param x The initial x-coordinate of the robot.
     * @param y The initial y-coordinate of the robot.
     * @param f The initial direction the robot is facing.
     */
    public EngulfRobot(int x, int y, Direction.selectDirection f) {
        super(x, y, f); // Call the parent class constructor
    }

    /**
     * Attempts to move the EngulfRobot within the arena and handles collisions.
     * If a collision with another robot occurs, the collided robot is removed from the arena.
     *
     * @param arena The RobotArena containing the EngulfRobot and other robots.
     */
    @Override
    public void tryToMove(RobotArena arena) {
        double horizontal = getX(), vertical = getY();

        // Calculate movement based on direction
        switch (facing) {
            case North:
                vertical += 1.5;
                break;
            case NorthNorthEast:
                horizontal += 0.75;
                vertical += 1.5;
                break;
            case EastNorthEast:
                horizontal += 1.5;
                vertical += 0.75;
                break;
            case NorthEast:
                horizontal += 1.5;
                vertical += 1.5;
                break;
            case NorthNorthWest:
                horizontal -= 0.75;
                vertical += 1.5;
                break;
            case WestNorthWest:
                horizontal -= 1.5;
                vertical += 0.75;
                break;
            case NorthWest:
                horizontal -= 1.5;
                vertical += 1.5;
                break;
            case East:
                horizontal += 1.5;
                break;
            case EastSouthEast:
                horizontal += 1.5;
                vertical -= 0.75;
                break;
            case SouthSouthEast:
                horizontal += 0.75;
                vertical -= 1.5;
                break;
            case South:
                vertical -= 1.5;
                break;
            case SouthEast:
                horizontal += 1.5;
                vertical -= 1.5;
                break;
            case WestSouthWest:
                horizontal -= 1.5;
                vertical -= 0.75;
                break;
            case SouthSouthWest:
                horizontal -= 0.75;
                vertical -= 1.5;
                break;
            case SouthWest:
                horizontal -= 1.5;
                vertical -= 1.5;
                break;
            case West:
                horizontal -= 1.5;
                break;
        }

        // Check if the EngulfRobot can move to the new position
        if (arena.canMoveHere(horizontal, vertical)) {
            dx = horizontal;
            dy = vertical;

            // Check for collisions and remove robots
            for (int i = 0; i < arena.numRobot.size(); i++) {
                Robot other = arena.numRobot.get(i);
                if (this != other && isCollidingWith(other)) {
                    arena.numRobot.remove(other); // Remove the collided robot
                    i--; // Adjust index after removal
                }
            }
        } else {
            reverseDirection(); // Reverse direction if movement is blocked
        }
    }

    /**
     * Checks if this robot is colliding with another robot.
     *
     * @param other The other robot to check for collision.
     * @return True if the robots are colliding; false otherwise.
     */
    private boolean isCollidingWith(Robot other) {
        double dx = getX() - other.getX();
        double dy = getY() - other.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < getRadius() + other.getRadius();
    }

    /**
     * Draws the EngulfRobot on the canvas, including its unique appearance and features.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    @Override
    public void draw(GraphicsContext gc) {
        // Draw the EngulfRobot's body in blue
        gc.setFill(Color.BLUE);
                vertical -= 0.75;
                break;
            case SouthSouthEast:
                horizontal += 0.75;
                vertical -= 1.5;
                break;
            case South:
                vertical -= 1.5;
                break;
            case SouthEast:
                horizontal += 1.5;
                vertical -= 1.5;
                break;
            case WestSouthWest:
                horizontal -= 1.5;
                vertical -= 0.75;
                break;
            case SouthSouthWest:
                horizontal -= 0.75;
                vertical -= 1.5;
                break;
            case SouthWest:
                horizontal -= 1.5;
                vertical -= 1.5;
                break;
            case West:
                horizontal -= 1.5;
                break;
        }

        // Check if the EngulfRobot can move to the new position
        if (arena.canMoveHere(horizontal, vertical)) {
            dx = horizontal;
            dy = vertical;

            // Check for collisions and remove robots
            for (int i = 0; i < arena.numRobot.size(); i++) {
                Robot other = arena.numRobot.get(i);
                if (this != other && isCollidingWith(other)) {
                    arena.numRobot.remove(other); // Remove the collided robot
                    i--; // Adjust index after removal
                }
            }
        } else {
            reverseDirection(); // Reverse direction if movement is blocked
        }
    }

    /**
     * Checks if this robot is colliding with another robot.
     *
     * @param other The other robot to check for collision.
     * @return True if the robots are colliding; false otherwise.
     */
    private boolean isCollidingWith(Robot other) {
        double dx = getX() - other.getX();
        double dy = getY() - other.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < getRadius() + other.getRadius();
    }

    /**
     * Draws the EngulfRobot on the canvas, including its unique appearance and features.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    @Override
    public void draw(GraphicsContext gc) {
        // Draw the EngulfRobot's body in blue
        gc.setFill(Color.BLUE);
        gc.fillOval(dx - robotRadius, dy - robotRadius, robotRadius * 2, robotRadius * 2);

        // Draw wheels as black rectangles
        gc.setFill(Color.BLACK);
        double wheelWidth = robotRadius * 0.6;
        double wheelHeight = robotRadius * 0.2;

        // Top wheel
        gc.fillRect(dx - wheelWidth / 2, dy - robotRadius - wheelHeight, wheelWidth, wheelHeight);
        // Bottom wheel
        gc.fillRect(dx - wheelWidth / 2, dy + robotRadius, wheelWidth, wheelHeight);

        // Draw whiskers aligned with movement direction
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2);
        double whiskerLength = robotRadius * 1.5;
        double whiskerAngle = Math.PI / 4; // 45 degrees for whiskers

        double whiskerX1 = dx + Math.cos(getAngle(facing) - whiskerAngle) * whiskerLength;
        double whiskerY1 = dy + Math.sin(getAngle(facing) - whiskerAngle) * whiskerLength;
        double whiskerX2 = dx + Math.cos(getAngle(facing) + whiskerAngle) * whiskerLength;
        double whiskerY2 = dy + Math.sin(getAngle(facing) + whiskerAngle) * whiskerLength;

        gc.strokeLine(dx, dy, whiskerX1, whiskerY1); // Left whisker
        gc.strokeLine(dx, dy, whiskerX2, whiskerY2); // Right whisker

        // Draw beam sensors aligned with movement direction
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        double beamLength = robotRadius * 2;

        double beamX = dx + Math.cos(getAngle(facing)) * beamLength;
        double beamY = dy + Math.sin(getAngle(facing)) * beamLength;
        gc.strokeLine(dx, dy, beamX, beamY); // Beam sensor

        // Draw the title "Predator" above the EngulfRobot
        gc.setFill(Color.BLACK);
        gc.fillText("Predator", dx - robotRadius, dy - robotRadius - 15);
    }

    /**
     * Helper method to get the angle based on the robot's direction.
     *
     * @param direction The direction the robot is facing.
     * @return The angle in radians corresponding to the direction.
     */
    private double getAngle(Direction.selectDirection direction) {
        switch (direction) {
            case North:
                return -Math.PI / 2;
            case South:
                return Math.PI / 2;
            case East:
                return 0;
            case West:
                return Math.PI;
            case NorthEast:
                return -Math.PI / 4;
            case NorthWest:
                return -3 * Math.PI / 4;
            case SouthEast:
                return Math.PI / 4;
            case SouthWest:
                return 3 * Math.PI / 4;
            default:
                return 0; // Default to East
        }
    }
}

        gc.fillOval(dx - robotRadius, dy - robotRadius, robotRadius * 2, robotRadius * 2);

        // Draw wheels as black rectangles
        gc.setFill(Color.BLACK);
        double wheelWidth = robotRadius * 0.6;
        double wheelHeight = robotRadius * 0.2;

        // Top wheel
        gc.fillRect(dx - wheelWidth / 2, dy - robotRadius - wheelHeight, wheelWidth, wheelHeight);
        // Bottom wheel
        gc.fillRect(dx - wheelWidth / 2, dy + robotRadius, wheelWidth, wheelHeight);

        // Draw whiskers aligned with movement direction
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2);
        double whiskerLength = robotRadius * 1.5;
        double whiskerAngle = Math.PI / 4; // 45 degrees for whiskers

        double whiskerX1 = dx + Math.cos(getAngle(facing) - whiskerAngle) * whiskerLength;
        double whiskerY1 = dy + Math.sin(getAngle(facing) - whiskerAngle) * whiskerLength;
        double whiskerX2 = dx + Math.cos(getAngle(facing) + whiskerAngle) * whiskerLength;
        double whiskerY2 = dy + Math.sin(getAngle(facing) + whiskerAngle) * whiskerLength;

        gc.strokeLine(dx, dy, whiskerX1, whiskerY1); // Left whisker
        gc.strokeLine(dx, dy, whiskerX2, whiskerY2); // Right whisker

        // Draw beam sensors aligned with movement direction
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        double beamLength = robotRadius * 2;

        double beamX = dx + Math.cos(getAngle(facing)) * beamLength;
        double beamY = dy + Math.sin(getAngle(facing)) * beamLength;
        gc.strokeLine(dx, dy, beamX, beamY); // Beam sensor

        // Draw the title "Predator" above the EngulfRobot
        gc.setFill(Color.BLACK);
        gc.fillText("Predator", dx - robotRadius, dy - robotRadius - 15);
    }

    /**
     * Helper method to get the angle based on the robot's direction.
     *
     * @param direction The direction the robot is facing.
     * @return The angle in radians corresponding to the direction.
     */
    private double getAngle(Direction.selectDirection direction) {
        switch (direction) {
            case North:
                return -Math.PI / 2;
            case South:
                return Math.PI / 2;
            case East:
                return 0;
            case West:
                return Math.PI;
            case NorthEast:
                return -Math.PI / 4;
            case NorthWest:
                return -3 * Math.PI / 4;
            case SouthEast:
                return Math.PI / 4;
            case SouthWest:
                return 3 * Math.PI / 4;
            default:
                return 0; // Default to East
        }
    }
}


