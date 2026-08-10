// ItemYellow.java
package robot_gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents a yellow pellet item that increases the size of all robots that interact with it.
 */
public class ItemYellow extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an ItemYellow and spawns it at a random position in the arena.
     *
     * @param arenaWidth  The width of the arena.
     * @param arenaHeight The height of the arena.
     */
	
	
    public ItemYellow(int arenaWidth, int arenaHeight) {
        super(arenaWidth, arenaHeight);
    }

    /**
     * Draws the yellow pellet on the canvas if it is active.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    @Override
    public void draw(GraphicsContext gc) {
        if (isActive) {
            gc.setFill(Color.YELLOW);
            gc.fillOval(x - ITEM_RADIUS, y - ITEM_RADIUS, ITEM_RADIUS * 2, ITEM_RADIUS * 2);
        }
    }

    /**
     * Applies the effect of the item to the interacting robot, increasing its size temporarily.
     *
     * @param robot The robot interacting with the item.
     */
    @Override
    public void applyEffect(Robot robot) {
        if (isCollidingWith(robot)) { // Check for collision
            isActive = false; // Deactivate the item
            robot.setRadius(robot.getRadius() * 2); // Double the robot's size
            System.out.println(robot.getName() + " collided with Yellow Item and size increased!");

            // Reset the robot's size after 15 seconds
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    robot.setRadius(ArenaCanvas.ROBOT_RADIUS); // Reset to default radius
                    System.out.println(robot.getName() + " size reset.");
                }
            }, 15000);
        }
    }


	@Override
	protected void checkInteraction(Robot r, int width, int height) {
		// TODO Auto-generated method stub
		
// ItemYellow.java
package robot_gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents a yellow pellet item that increases the size of all robots that interact with it.
 */
public class ItemYellow extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an ItemYellow and spawns it at a random position in the arena.
     *
     * @param arenaWidth  The width of the arena.
     * @param arenaHeight The height of the arena.
     */
	
	
    public ItemYellow(int arenaWidth, int arenaHeight) {
        super(arenaWidth, arenaHeight);
    }

    /**
     * Draws the yellow pellet on the canvas if it is active.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    @Override
    public void draw(GraphicsContext gc) {
        if (isActive) {
            gc.setFill(Color.YELLOW);
            gc.fillOval(x - ITEM_RADIUS, y - ITEM_RADIUS, ITEM_RADIUS * 2, ITEM_RADIUS * 2);
        }
    }

    /**
     * Applies the effect of the item to the interacting robot, increasing its size temporarily.
     *
     * @param robot The robot interacting with the item.
     */
    @Override
    public void applyEffect(Robot robot) {
        if (isCollidingWith(robot)) { // Check for collision
            isActive = false; // Deactivate the item
            robot.setRadius(robot.getRadius() * 2); // Double the robot's size
            System.out.println(robot.getName() + " collided with Yellow Item and size increased!");

            // Reset the robot's size after 15 seconds
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    robot.setRadius(ArenaCanvas.ROBOT_RADIUS); // Reset to default radius
                    System.out.println(robot.getName() + " size reset.");
                }
            }, 15000);
        }
    }


	@Override
	protected void checkInteraction(Robot r, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkInteraction(Robot r) {
		// TODO Auto-generated method stub
		
	}
}
