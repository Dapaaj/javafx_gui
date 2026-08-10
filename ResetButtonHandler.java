// ResetButtonHandler.java
package robot_gui;

import javafx.scene.control.ListView;

/**
 * Handles the logic for resetting the robot arena.
 * This includes clearing robots, refreshing the canvas, and updating the robot list.
 */
public class ResetButtonHandler {
    private final RobotArena arena; // Reference to the arena
    private final ArenaCanvas canvas; // Reference to the canvas

    /**
     * Constructs a ResetButtonHandler with references to the arena and canvas.
     *
     * @param arena  The RobotArena object managing the simulation.
     * @param canvas The ArenaCanvas used for rendering.
     */
    public ResetButtonHandler(RobotArena arena, ArenaCanvas canvas) {
        this.arena = arena;
        this.canvas = canvas;
    }

    /**
     * Resets the arena by clearing all robots, resetting the item, and refreshing the canvas.
     *
     * @param vehicles The ListView displaying the list of robots in the arena.
     */
    public void resetArena(ListView<Robot> vehicles) {
        // Call arena reset logic
        arena.resetArena(vehicles);

        // Clear the canvas
        canvas.setFillArenaColour(arena.getWidth(), arena.getHeight());

        // Update the canvas to reflect changes
        canvas.changeCanvas(arena);
    }
}
