// ArenaCanvas.java
package robot_gui;

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents the graphical canvas for the Robot Arena simulation.
 * This class is responsible for rendering the arena, robots, obstacles, and items on the screen.
 */
public class ArenaCanvas extends Application {
    private int canvasWidthSize; // Width of the canvas
    private int canvasHeightSize; // Height of the canvas
    private GraphicsContext gc; // Graphics context for drawing

    public static final int WIDTH = 5; // Default width of the arena grid
    public static final int HEIGHT = 5; // Default height of the arena grid
    public static final int ROBOT_RADIUS = 20; // Default radius for robots

    /**
     * Constructs an ArenaCanvas with a specified size and graphics context.
     *
     * @param g    The graphics context used for rendering.
     * @param xcs  The width of the canvas.
     * @param ycs  The height of the canvas.
     */
    public ArenaCanvas(GraphicsContext g, int xcs, int ycs) {
        gc = g;
        canvasWidthSize = xcs;
        canvasHeightSize = ycs;
    }

    /**
     * Sets the background colour of the canvas and draws a border around it.
     *
     * @param canvasWidth  The width of the canvas.
     * @param canvasHeight The height of the canvas.
     */
    public void setFillArenaColour(int canvasWidth, int canvasHeight) {
        gc.setFill(Color.LIGHTGRAY); // Light grey background
        gc.fillRect(0, 0, canvasWidth, canvasHeight); // Fill the background
        gc.setStroke(Color.BLACK); // Black border
        gc.strokeRect(0, 0, canvasWidth, canvasHeight); // Draw the border
    }

    /**
     * Updates the canvas to reflect the current state of the arena, including robots, obstacles, and items.
     *
     * @param arena The RobotArena object containing the state of the simulation.
     */
    public void changeCanvas(RobotArena arena) {
        gc.clearRect(0, 0, canvasWidthSize, canvasHeightSize); // Clear the canvas
        setFillArenaColour(canvasWidthSize, canvasHeightSize); // Redraw the background
        arena.drawObstacles(gc); // Draw the obstacles from the arena
        drawRobots(arena); // Draw all robots on the canvas
        arena.item.draw(gc); // Draw the interactive item
    }

    /**
     * Draws all robots present in the arena onto the canvas.
     *
     * @param arena The RobotArena object containing the list of robots.
     */
    private void drawRobots(RobotArena arena) {
        for (Robot robot : arena.numRobot) {
            robot.draw(gc); // Use each robot's draw method
        }
    }
// ArenaCanvas.java
package robot_gui;

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents the graphical canvas for the Robot Arena simulation.
 * This class is responsible for rendering the arena, robots, obstacles, and items on the screen.
 */
public class ArenaCanvas extends Application {
    private int canvasWidthSize; // Width of the canvas
    private int canvasHeightSize; // Height of the canvas
    private GraphicsContext gc; // Graphics context for drawing

    public static final int WIDTH = 5; // Default width of the arena grid
    public static final int HEIGHT = 5; // Default height of the arena grid
    public static final int ROBOT_RADIUS = 20; // Default radius for robots

    /**
     * Constructs an ArenaCanvas with a specified size and graphics context.
     *
     * @param g    The graphics context used for rendering.
     * @param xcs  The width of the canvas.
     * @param ycs  The height of the canvas.
     */
    public ArenaCanvas(GraphicsContext g, int xcs, int ycs) {
        gc = g;
        canvasWidthSize = xcs;
        canvasHeightSize = ycs;
    }

    /**
     * Sets the background colour of the canvas and draws a border around it.
     *
     * @param canvasWidth  The width of the canvas.
     * @param canvasHeight The height of the canvas.
     */
    public void setFillArenaColour(int canvasWidth, int canvasHeight) {
        gc.setFill(Color.LIGHTGRAY); // Light grey background
        gc.fillRect(0, 0, canvasWidth, canvasHeight); // Fill the background
        gc.setStroke(Color.BLACK); // Black border
        gc.strokeRect(0, 0, canvasWidth, canvasHeight); // Draw the border
    }

    /**
     * Updates the canvas to reflect the current state of the arena, including robots, obstacles, and items.
     *
     * @param arena The RobotArena object containing the state of the simulation.
     */
    public void changeCanvas(RobotArena arena) {
        gc.clearRect(0, 0, canvasWidthSize, canvasHeightSize); // Clear the canvas
        setFillArenaColour(canvasWidthSize, canvasHeightSize); // Redraw the background
        arena.drawObstacles(gc); // Draw the obstacles from the arena
        drawRobots(arena); // Draw all robots on the canvas
        arena.item.draw(gc); // Draw the interactive item
    }

    /**
     * Draws all robots present in the arena onto the canvas.
     *
     * @param arena The RobotArena object containing the list of robots.
     */
    private void drawRobots(RobotArena arena) {
        for (Robot robot : arena.numRobot) {
            robot.draw(gc); // Use each robot's draw method
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // JavaFX application entry point (not implemented here)
    }
}
