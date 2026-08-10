package robot_gui;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.Random;

/**
 * Abstract base class representing an interactive item in the robot arena.
 */
public abstract class Item implements Serializable {
    protected double x, y; // Position of the item
    protected boolean isActive; // Whether the item is active
    protected static final int ITEM_RADIUS = 10; // Default size of the item
    protected Random random; // Random number generator for spawning

    /**
     * Constructs an Item and spawns it at a random position in the arena.
     *
     * @param arenaWidth  The width of the arena.
     * @param arenaHeight The height of the arena.
     */
    public Item(int arenaWidth, int arenaHeight) {
        random = new Random();
        spawnItem(arenaWidth, arenaHeight);
    }

    /**
     * Spawns the item at a random position within the arena bounds.
     *
     * @param arenaWidth  The width of the arena.
     * @param arenaHeight The height of the arena.
     */
    public void spawnItem(int arenaWidth, int arenaHeight) {
        x = random.nextInt(arenaWidth - ITEM_RADIUS * 2) + ITEM_RADIUS;
        y = random.nextInt(arenaHeight - ITEM_RADIUS * 2) + ITEM_RADIUS;
        isActive = true;
    }

    /**
     * Draws the item on the canvas if it is active.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public abstract void draw(GraphicsContext gc);

    /**
     * Applies the item's effect to the interacting robot.
     *
     * @param robot The robot interacting with the item.
     */
    public abstract void applyEffect(Robot robot);

    /**
     * Checks if a robot is colliding with this item.
     *
     * @param robot The robot to check for collision.
     * @return True if the robot is colliding with the item; false otherwise.
     */
    public boolean isCollidingWith(Robot robot) {
        double distance = Math.hypot(robot.getX() - x, robot.getY() - y);
        boolean colliding = distance < ITEM_RADIUS + robot.getRadius();
        if (colliding) {
            System.out.println(robot.getName() + " is colliding with item at (" + x + ", " + y + ").");
        }
        return colliding;
    }

	protected void checkInteraction(Robot r, int width, int height) {
		// TODO Auto-generated method stub
package robot_gui;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.Random;

/**
 * Abstract base class representing an interactive item in the robot arena.
 */
public abstract class Item implements Serializable {
    protected double x, y; // Position of the item
    protected boolean isActive; // Whether the item is active
    protected static final int ITEM_RADIUS = 10; // Default size of the item
    protected Random random; // Random number generator for spawning

    /**
     * Constructs an Item and spawns it at a random position in the arena.
     *
     * @param arenaWidth  The width of the arena.
     * @param arenaHeight The height of the arena.
     */
    public Item(int arenaWidth, int arenaHeight) {
        random = new Random();
        spawnItem(arenaWidth, arenaHeight);
    }

    /**
     * Spawns the item at a random position within the arena bounds.
     *
     * @param arenaWidth  The width of the arena.
     * @param arenaHeight The height of the arena.
     */
    public void spawnItem(int arenaWidth, int arenaHeight) {
        x = random.nextInt(arenaWidth - ITEM_RADIUS * 2) + ITEM_RADIUS;
        y = random.nextInt(arenaHeight - ITEM_RADIUS * 2) + ITEM_RADIUS;
        isActive = true;
    }

    /**
     * Draws the item on the canvas if it is active.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public abstract void draw(GraphicsContext gc);

    /**
     * Applies the item's effect to the interacting robot.
     *
     * @param robot The robot interacting with the item.
     */
    public abstract void applyEffect(Robot robot);

    /**
     * Checks if a robot is colliding with this item.
     *
     * @param robot The robot to check for collision.
     * @return True if the robot is colliding with the item; false otherwise.
     */
    public boolean isCollidingWith(Robot robot) {
        double distance = Math.hypot(robot.getX() - x, robot.getY() - y);
        boolean colliding = distance < ITEM_RADIUS + robot.getRadius();
        if (colliding) {
            System.out.println(robot.getName() + " is colliding with item at (" + x + ", " + y + ").");
        }
        return colliding;
    }

	protected void checkInteraction(Robot r, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	protected void checkInteraction(Robot r) {
		// TODO Auto-generated method stub
		
	}
}
