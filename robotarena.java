// RobotArena.java
package robot_gui;

import java.io.*;
import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.scene.canvas.GraphicsContext;

/**
 * Manages the simulation of the robot arena.
 * This includes handling the robots, obstacles, items, and their interactions within the arena.
 */
public class RobotArena implements Serializable {
    private static final long serialVersionUID = 1L;
    private int width, height; // Dimensions of the arena
    public ArrayList<Robot> numRobot; // List of robots in the arena
    public Item item; // Interactive item in the arena
    private Obstacle[] obstacles; // Array of obstacles
    private boolean engulfRobotSpawned = false; // Tracks if EngulfRobot has been spawned

    /**
     * Constructs a RobotArena with specified dimensions.
     * Initialises robots, items, and obstacles.
     *
     * @param w The width of the arena.
     * @param h The height of the arena.
     */
    public RobotArena(int w, int h) {
        width = w;
        height = h;
        numRobot = new ArrayList<>();
        item = new ItemYellow(width, height); // Initialize with ItemYellow
        // Initialise two obstacles
        obstacles = new Obstacle[] {
            new Obstacle(width / 4 - 30, height / 3 - 30),
            new Obstacle(3 * width / 4 - 30, 2 * height / 3 - 30)
        };
    }

    /**
     * Adds a regular robot to the arena.
     *
     * @param mc       The canvas for rendering the arena.
     * @param vehicles The ListView displaying the list of robots.
     */
    public void addRobot(ArenaCanvas mc, ListView<Robot> vehicles) {
        Robot r = new Robot((int) (Math.random() * width), (int) (Math.random() * height), Direction.selectDirection.getRandomDirection());
        numRobot.add(r);
        RobotInterface.listRobots(vehicles); // Update ListView in RobotInterface
        mc.changeCanvas(this); // Update the canvas
    }

    /**
     * Adds an EngulfRobot to the arena.
     *
     * @param mc       The canvas for rendering the arena.
     * @param vehicles The ListView displaying the list of robots.
     */
    public void addEngulfRobot(ArenaCanvas mc, ListView<Robot> vehicles) {
        EngulfRobot er = new EngulfRobot((int) (Math.random() * width), (int) (Math.random() * height), Direction.selectDirection.getRandomDirection());
        numRobot.add(er);
        RobotInterface.listRobots(vehicles); // Update ListView in RobotInterface
        mc.changeCanvas(this); // Update the canvas
    }

    /**
     * Adds a FreezeRobot to the arena.
     *
     * @param mc       The canvas for rendering the arena.
     * @param vehicles The ListView displaying the list of robots.
// RobotArena.java
package robot_gui;

import java.io.*;
import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.scene.canvas.GraphicsContext;

/**
 * Manages the simulation of the robot arena.
 * This includes handling the robots, obstacles, items, and their interactions within the arena.
 */
public class RobotArena implements Serializable {
    private static final long serialVersionUID = 1L;
    private int width, height; // Dimensions of the arena
    public ArrayList<Robot> numRobot; // List of robots in the arena
    public Item item; // Interactive item in the arena
    private Obstacle[] obstacles; // Array of obstacles
    private boolean engulfRobotSpawned = false; // Tracks if EngulfRobot has been spawned

    /**
     * Constructs a RobotArena with specified dimensions.
     * Initialises robots, items, and obstacles.
     *
     * @param w The width of the arena.
     * @param h The height of the arena.
     */
    public RobotArena(int w, int h) {
        width = w;
        height = h;
        numRobot = new ArrayList<>();
        item = new ItemYellow(width, height); // Initialize with ItemYellow
        // Initialise two obstacles
        obstacles = new Obstacle[] {
            new Obstacle(width / 4 - 30, height / 3 - 30),
            new Obstacle(3 * width / 4 - 30, 2 * height / 3 - 30)
        };
    }

    /**
     * Adds a regular robot to the arena.
     *
     * @param mc       The canvas for rendering the arena.
     * @param vehicles The ListView displaying the list of robots.
     */
    public void addRobot(ArenaCanvas mc, ListView<Robot> vehicles) {
        Robot r = new Robot((int) (Math.random() * width), (int) (Math.random() * height), Direction.selectDirection.getRandomDirection());
        numRobot.add(r);
        RobotInterface.listRobots(vehicles); // Update ListView in RobotInterface
        mc.changeCanvas(this); // Update the canvas
    }

    /**
     * Adds an EngulfRobot to the arena.
     *
     * @param mc       The canvas for rendering the arena.
     * @param vehicles The ListView displaying the list of robots.
     */
    public void addEngulfRobot(ArenaCanvas mc, ListView<Robot> vehicles) {
        EngulfRobot er = new EngulfRobot((int) (Math.random() * width), (int) (Math.random() * height), Direction.selectDirection.getRandomDirection());
        numRobot.add(er);
        RobotInterface.listRobots(vehicles); // Update ListView in RobotInterface
        mc.changeCanvas(this); // Update the canvas
    }

    /**
     * Adds a FreezeRobot to the arena.
     *
     * @param mc       The canvas for rendering the arena.
     * @param vehicles The ListView displaying the list of robots.
     */
    public void addFreezeRobot(ArenaCanvas mc, ListView<Robot> vehicles) {
        FreezeRobot fr = new FreezeRobot((int) (Math.random() * width), (int) (Math.random() * height), Direction.selectDirection.getRandomDirection());
        numRobot.add(fr);
        RobotInterface.listRobots(vehicles); // Update ListView in RobotInterface
        mc.changeCanvas(this); // Refresh the canvas
    }

    /**
     * Moves all robots in the arena and checks for collisions.
     * This includes collisions with obstacles, items, and other robots.
     *
     * @param mc The canvas for rendering the arena.
     */
    public void moveAllRobots(ArenaCanvas mc, ListView<Robot> vehicles) {
        for (Robot r : numRobot) {
            r.tryToMove(this); // Move each robot
            if (item.isActive) { // Check if the item is active
                item.applyEffect(r); // Apply the item's effect if a collision occurs
            }
            for (Obstacle obstacle : obstacles) {
                if (obstacle.isCollidingWithRobot(r)) {
                    r.reverseDirection(); // Reverse direction on obstacle collision
                }
            }
        }
        checkCollisions(); // Handle robot-robot collisions
        updateRobotList(vehicles); // Refresh the ListView
        mc.changeCanvas(this); // Refresh the canvas
    }

    
    /**
     * Updates the ListView with the current robot information.
     *
     * @param vehicles The ListView to update.
     */
    private void updateRobotList(ListView<Robot> vehicles) {
        if (vehicles != null) {
            vehicles.getItems().clear();
            for (Robot r : numRobot) {
                vehicles.getItems().add(r); // Add the updated robot info
            }
        }
    }


    /**
     * Spawns an EngulfRobot after a specific delay.
     *
     * @param mc        The canvas for rendering the arena.
     * @param vehicles  The ListView displaying the list of robots.
     * @param startTime The start time of the simulation.
     */
    public void checkAndSpawnEngulfRobot(ArenaCanvas mc, ListView<Robot> vehicles, long startTime) {
        if (!engulfRobotSpawned && (System.currentTimeMillis() - startTime) >= 15000) {
            addEngulfRobot(mc, vehicles);
            engulfRobotSpawned = true; // Ensure only one EngulfRobot is spawned
        }
    }

    /**
     * Resets the arena by clearing all robots and resetting the item.
     */
    public void resetArena(ListView<Robot> vehicles) {
        numRobot.clear(); // Remove all robots
        item = new ItemYellow(width, height); // Reset the item using a specific subclass
        RobotInterface.listRobots(vehicles); // Clear the ListView
        engulfRobotSpawned = false; // Allow spawning EngulfRobot again
    }
     */
    public void addFreezeRobot(ArenaCanvas mc, ListView<Robot> vehicles) {
        FreezeRobot fr = new FreezeRobot((int) (Math.random() * width), (int) (Math.random() * height), Direction.selectDirection.getRandomDirection());
        numRobot.add(fr);
        RobotInterface.listRobots(vehicles); // Update ListView in RobotInterface
        mc.changeCanvas(this); // Refresh the canvas
    }

    /**
     * Moves all robots in the arena and checks for collisions.
     * This includes collisions with obstacles, items, and other robots.
     *
     * @param mc The canvas for rendering the arena.
     */
    public void moveAllRobots(ArenaCanvas mc, ListView<Robot> vehicles) {
        for (Robot r : numRobot) {
            r.tryToMove(this); // Move each robot
            if (item.isActive) { // Check if the item is active
                item.applyEffect(r); // Apply the item's effect if a collision occurs
            }
            for (Obstacle obstacle : obstacles) {
                if (obstacle.isCollidingWithRobot(r)) {
                    r.reverseDirection(); // Reverse direction on obstacle collision
                }
            }
        }
        checkCollisions(); // Handle robot-robot collisions
        updateRobotList(vehicles); // Refresh the ListView
        mc.changeCanvas(this); // Refresh the canvas
    }

    
    /**
     * Updates the ListView with the current robot information.
     *
     * @param vehicles The ListView to update.
     */
    private void updateRobotList(ListView<Robot> vehicles) {
        if (vehicles != null) {
            vehicles.getItems().clear();
            for (Robot r : numRobot) {
                vehicles.getItems().add(r); // Add the updated robot info
            }
        }
    }


    /**
     * Spawns an EngulfRobot after a specific delay.
     *
     * @param mc        The canvas for rendering the arena.
     * @param vehicles  The ListView displaying the list of robots.
     * @param startTime The start time of the simulation.
     */
    public void checkAndSpawnEngulfRobot(ArenaCanvas mc, ListView<Robot> vehicles, long startTime) {
        if (!engulfRobotSpawned && (System.currentTimeMillis() - startTime) >= 15000) {
            addEngulfRobot(mc, vehicles);
            engulfRobotSpawned = true; // Ensure only one EngulfRobot is spawned
        }
    }

    /**
     * Resets the arena by clearing all robots and resetting the item.
     */
    public void resetArena(ListView<Robot> vehicles) {
        numRobot.clear(); // Remove all robots
        item = new ItemYellow(width, height); // Reset the item using a specific subclass
        RobotInterface.listRobots(vehicles); // Clear the ListView
        engulfRobotSpawned = false; // Allow spawning EngulfRobot again
    }

    /**
     * Checks if a position is valid for robot movement.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the position is valid; false otherwise.
     */
    public boolean canMoveHere(double x, double y) {
        return x >= 0 && y >= 0 && x <= width && y <= height;
    }

   
    /**
     * Checks for collisions between all robots and handles them.
     */
    public void checkCollisions() {
        for (int i = 0; i < numRobot.size(); i++) {
            for (int j = i + 1; j < numRobot.size(); j++) {
                Robot r1 = numRobot.get(i);
                Robot r2 = numRobot.get(j);

                // Only handle collisions for regular robots
                if (!(r1 instanceof FreezeRobot || r1 instanceof EngulfRobot) &&
                    !(r2 instanceof FreezeRobot || r2 instanceof EngulfRobot)) {
                    if (isColliding(r1, r2)) {
                        handleCollision(r1, r2);
                    }
                }
            }
        }
    }

    /**
     * Checks if two robots are colliding.
     *
     * @param r1 The first robot.
     * @param r2 The second robot.
     * @return True if the robots are colliding; false otherwise.
     */
    private boolean isColliding(Robot r1, Robot r2) {
        double dx = r1.getX() - r2.getX();
        double dy = r1.getY() - r2.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < r1.getRadius() + r2.getRadius();
    }

    /**
     * Handles the collision between two robots by reversing their directions.
     *
     * @param r1 The first robot.
     * @param r2 The second robot.
     */
    private void handleCollision(Robot r1, Robot r2) {
        r1.reverseDirection();
        r2.reverseDirection();
    }

    /**
     * Draws all obstacles on the canvas.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public void drawObstacles(GraphicsContext gc) {
        for (Obstacle obstacle : obstacles) {
            obstacle.draw(gc);
        }
    }

    /**

    /**
     * Checks if a position is valid for robot movement.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the position is valid; false otherwise.
     */
    public boolean canMoveHere(double x, double y) {
        return x >= 0 && y >= 0 && x <= width && y <= height;
    }

   
    /**
     * Checks for collisions between all robots and handles them.
     */
    public void checkCollisions() {
        for (int i = 0; i < numRobot.size(); i++) {
            for (int j = i + 1; j < numRobot.size(); j++) {
                Robot r1 = numRobot.get(i);
                Robot r2 = numRobot.get(j);

                // Only handle collisions for regular robots
                if (!(r1 instanceof FreezeRobot || r1 instanceof EngulfRobot) &&
                    !(r2 instanceof FreezeRobot || r2 instanceof EngulfRobot)) {
                    if (isColliding(r1, r2)) {
                        handleCollision(r1, r2);
                    }
                }
            }
        }
    }

    /**
     * Checks if two robots are colliding.
     *
     * @param r1 The first robot.
     * @param r2 The second robot.
     * @return True if the robots are colliding; false otherwise.
     */
    private boolean isColliding(Robot r1, Robot r2) {
        double dx = r1.getX() - r2.getX();
        double dy = r1.getY() - r2.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < r1.getRadius() + r2.getRadius();
    }

    /**
     * Handles the collision between two robots by reversing their directions.
     *
     * @param r1 The first robot.
     * @param r2 The second robot.
     */
    private void handleCollision(Robot r1, Robot r2) {
        r1.reverseDirection();
        r2.reverseDirection();
    }

    /**
     * Draws all obstacles on the canvas.
     *
     * @param gc The GraphicsContext used for rendering.
     */
    public void drawObstacles(GraphicsContext gc) {
        for (Obstacle obstacle : obstacles) {
            obstacle.draw(gc);
        }
    }

    /**
     * Gets the width of the arena.
     *
     * @return The width of the arena.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the arena.
     *
     * @return The height of the arena.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns a string representation of the arena's state.
     *
     * @return A string describing the arena.
     */
    @Override
    public String toString() {
        return "Arena: Width = " + width + ", Height = " + height + ", Robots = " + numRobot.size();
    }

    /**
     * Saves the current state of the arena to a file.
     *
     * @param fileName The name of the file to save the arena.
     * @return True if the save was successful, false otherwise.
     */
    public boolean saveArena(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Arena successfully saved to " + fileName);
            return true;
        } catch (IOException e) {
            System.err.println("Failed to save arena: " + e.getMessage());
            return false;
        }
    }

    /**
     * Loads a saved arena configuration from a file.
     *
     * @param fileName The name of the file to load the arena from.
     * @return The loaded RobotArena object, or a default arena if loading fails.
     */
    public static RobotArena loadArena(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object loaded = ois.readObject();
            if (loaded instanceof RobotArena) {
                RobotArena arena = (RobotArena) loaded;

                // Reinitialize transient fields or any post-deserialization logic
                arena.reinitializeAfterLoad();

                System.out.println("Arena successfully loaded from " + fileName);
                return arena;
            } else {
                System.err.println("The file does not contain a valid RobotArena object.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load arena: " + e.getMessage());
        }

        // Return a default arena configuration if loading fails
        System.out.println("Loading failed. Returning a default arena.");
     * Gets the width of the arena.
     *
     * @return The width of the arena.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the arena.
     *
     * @return The height of the arena.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns a string representation of the arena's state.
     *
     * @return A string describing the arena.
     */
    @Override
    public String toString() {
        return "Arena: Width = " + width + ", Height = " + height + ", Robots = " + numRobot.size();
    }

    /**
     * Saves the current state of the arena to a file.
     *
     * @param fileName The name of the file to save the arena.
     * @return True if the save was successful, false otherwise.
     */
    public boolean saveArena(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Arena successfully saved to " + fileName);
            return true;
        } catch (IOException e) {
            System.err.println("Failed to save arena: " + e.getMessage());
            return false;
        }
    }

    /**
     * Loads a saved arena configuration from a file.
     *
     * @param fileName The name of the file to load the arena from.
     * @return The loaded RobotArena object, or a default arena if loading fails.
     */
    public static RobotArena loadArena(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object loaded = ois.readObject();
            if (loaded instanceof RobotArena) {
                RobotArena arena = (RobotArena) loaded;

                // Reinitialize transient fields or any post-deserialization logic
                arena.reinitializeAfterLoad();

                System.out.println("Arena successfully loaded from " + fileName);
                return arena;
            } else {
                System.err.println("The file does not contain a valid RobotArena object.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load arena: " + e.getMessage());
        }

        // Return a default arena configuration if loading fails
        System.out.println("Loading failed. Returning a default arena.");
        return new RobotArena(800, 600); // Adjust dimensions as needed
    }

    /**
     * Reinitializes transient fields or any necessary logic post-loading.
     */
    private void reinitializeAfterLoad() {
        // Example: Reinitialize any transient or custom fields
        System.out.println("Reinitializing transient fields...");
        // Add specific reinitialization logic if needed
    }


	public void resetArena() {
		// TODO Auto-generated method stub
		
	}
}
