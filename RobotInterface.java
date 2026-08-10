// RobotInterface.java
package robot_gui;

import javafx.stage.FileChooser;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import java.io.File;
import javafx.scene.control.ListView;

/**
 * The RobotInterface class serves as the main entry point for the Robot Arena GUI application.
 * It provides a graphical interface for users to interact with the robot simulation, including
 * adding, controlling, and resetting robots in the arena.
 */
public class RobotInterface extends Application {
    private int CanvasWidth = 900, CanvasHeight = 600; // Dimensions of the canvas
    private ArenaCanvas mc; // The canvas for rendering
    private static RobotArena Arena; // The robot arena managing the simulation
    private AnimationTimer time; // Animation timer for robot movement
    private long startTime; // Tracks the simulation start time
    private Robot selectedRobot = null; // Currently selected robot for interaction

    /**
     * Starts the JavaFX application, setting up the stage and UI components.
     *
     * @param stagePrimary The primary stage for the application.
     */
    @Override
    public void start(Stage stagePrimary) {
        stagePrimary.setTitle("Robot Simulator");

        Group root = new Group();
        Canvas canvas = new Canvas(CanvasWidth, CanvasHeight);
        root.getChildren().add(canvas);

        mc = new ArenaCanvas(canvas.getGraphicsContext2D(), CanvasWidth, CanvasHeight);
        Arena = new RobotArena(CanvasWidth, CanvasHeight);
        mc.setFillArenaColour(CanvasWidth, CanvasHeight);

        ResetButtonHandler resetHandler = new ResetButtonHandler(Arena, mc);

        ListView<Robot> Vehicles = new ListView<>();
        Vehicles.setStyle("-fx-control-inner-background: lightgray; -fx-border-color: black; -fx-text-fill: white;");

        Text text = new Text("Active robots: ");
        text.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 27));
        text.setFill(Color.WHITE);
        text.setStrokeWidth(1.25);
        text.setStroke(Color.GOLD);

        VBox vbList = new VBox(text);
        vbList.getChildren().addAll(Vehicles);
        vbList.setAlignment(Pos.CENTER);
        vbList.setPadding(new Insets(0, 0, 0, 50));
        vbList.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-background-color: white;");

// RobotInterface.java
package robot_gui;

import javafx.stage.FileChooser;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import java.io.File;
import javafx.scene.control.ListView;

/**
 * The RobotInterface class serves as the main entry point for the Robot Arena GUI application.
 * It provides a graphical interface for users to interact with the robot simulation, including
 * adding, controlling, and resetting robots in the arena.
 */
public class RobotInterface extends Application {
    private int CanvasWidth = 900, CanvasHeight = 600; // Dimensions of the canvas
    private ArenaCanvas mc; // The canvas for rendering
    private static RobotArena Arena; // The robot arena managing the simulation
    private AnimationTimer time; // Animation timer for robot movement
    private long startTime; // Tracks the simulation start time
    private Robot selectedRobot = null; // Currently selected robot for interaction

    /**
     * Starts the JavaFX application, setting up the stage and UI components.
     *
     * @param stagePrimary The primary stage for the application.
     */
    @Override
    public void start(Stage stagePrimary) {
        stagePrimary.setTitle("Robot Simulator");

        Group root = new Group();
        Canvas canvas = new Canvas(CanvasWidth, CanvasHeight);
        root.getChildren().add(canvas);

        mc = new ArenaCanvas(canvas.getGraphicsContext2D(), CanvasWidth, CanvasHeight);
        Arena = new RobotArena(CanvasWidth, CanvasHeight);
        mc.setFillArenaColour(CanvasWidth, CanvasHeight);

        ResetButtonHandler resetHandler = new ResetButtonHandler(Arena, mc);

        ListView<Robot> Vehicles = new ListView<>();
        Vehicles.setStyle("-fx-control-inner-background: lightgray; -fx-border-color: black; -fx-text-fill: white;");

        Text text = new Text("Active robots: ");
        text.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 27));
        text.setFill(Color.WHITE);
        text.setStrokeWidth(1.25);
        text.setStroke(Color.GOLD);

        VBox vbList = new VBox(text);
        vbList.getChildren().addAll(Vehicles);
        vbList.setAlignment(Pos.CENTER);
        vbList.setPadding(new Insets(0, 0, 0, 50));
        vbList.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-background-color: white;");

        time = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Arena.moveAllRobots(mc, Vehicles); // Pass ListView to update robot positions
                Arena.checkAndSpawnEngulfRobot(mc, Vehicles, startTime);
            }
        };

        // Buttons
        Button AddRobotButton = new Button("Add Robot");
        AddRobotButton.setOnAction(e -> Arena.addRobot(mc, Vehicles));

        Button AddFreezeRobotButton = new Button("Add FreezeRobot");
        AddFreezeRobotButton.setOnAction(e -> Arena.addFreezeRobot(mc, Vehicles));

        Button AddEngulfRobotButton = new Button("Add EngulfRobot");
        AddEngulfRobotButton.setOnAction(e -> Arena.addEngulfRobot(mc, Vehicles));

        Button DeleteRobotButton = new Button("Delete Robot");
        DeleteRobotButton.setOnAction(e -> deleteRobot(mc, Vehicles));

        Button ResetArenaButton = new Button("Reset Arena");
        ResetArenaButton.setOnAction(e -> resetHandler.resetArena(Vehicles));

        Button StartButton = new Button("Start");
        StartButton.setOnAction(e -> {
            startTime = System.currentTimeMillis();
            time.start();
        });

        Button StopButton = new Button("Stop");
        StopButton.setOnAction(e -> time.stop());

        // Style buttons
        styleButton(AddRobotButton, "#000dff");
        styleButton(AddFreezeRobotButton, "#00ff00");
        styleButton(AddEngulfRobotButton, "#ff8800");
        styleButton(DeleteRobotButton, "#ff0000");
        styleButton(ResetArenaButton, "#ff9900");
        styleButton(StartButton, "#15c218");
        styleButton(StopButton, "#ff0000");

        HBox hbButtons = new HBox(20);
        hbButtons.setAlignment(Pos.CENTER_RIGHT);
        hbButtons.setPadding(new Insets(0, 160, 50, 0));
        hbButtons.getChildren().addAll(AddRobotButton, AddFreezeRobotButton, AddEngulfRobotButton, DeleteRobotButton, ResetArenaButton, StartButton, StopButton);

        // Menu handler for menu bar
        MenuHandler menuHandler = new MenuHandler(Arena, mc);
        MenuBar menuBar = menuHandler.createMenuBar();

        // Add "Help" functionality
        menuHandler.setHelpContent("""
            In this console:
            - Add Robot: Adds a regular red robot to the canvas. You can select a specific robot and click a location to change its starting position.
            - Add Freeze Robot: Adds a green robot that stops regular robots for 3 seconds upon collision. The freeze robot itself is collision-free.
            - Add Engulf Robot: Adds a blue robot that deletes any other robot it touches one automatically spawns after 15 seconds.
            - Delete Robot: Deletes the last robot added to the canvas.
            - Reset Arena: Clears the canvas, removing all robots and items.
            - Start/Stop Buttons: Control when all robots can move.
            - Yellow Dot: Represents an item that increases a robot's size for 15 seconds.
        """);

        BorderPane bp = new BorderPane();
        bp.setTop(menuBar);
        bp.setCenter(root);
        bp.setBottom(hbButtons);
        bp.setLeft(vbList);

        // Mouse event for selecting and moving robots
        time = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Arena.moveAllRobots(mc, Vehicles); // Pass ListView to update robot positions
                Arena.checkAndSpawnEngulfRobot(mc, Vehicles, startTime);
            }
        };

        // Buttons
        Button AddRobotButton = new Button("Add Robot");
        AddRobotButton.setOnAction(e -> Arena.addRobot(mc, Vehicles));

        Button AddFreezeRobotButton = new Button("Add FreezeRobot");
        AddFreezeRobotButton.setOnAction(e -> Arena.addFreezeRobot(mc, Vehicles));

        Button AddEngulfRobotButton = new Button("Add EngulfRobot");
        AddEngulfRobotButton.setOnAction(e -> Arena.addEngulfRobot(mc, Vehicles));

        Button DeleteRobotButton = new Button("Delete Robot");
        DeleteRobotButton.setOnAction(e -> deleteRobot(mc, Vehicles));

        Button ResetArenaButton = new Button("Reset Arena");
        ResetArenaButton.setOnAction(e -> resetHandler.resetArena(Vehicles));

        Button StartButton = new Button("Start");
        StartButton.setOnAction(e -> {
            startTime = System.currentTimeMillis();
            time.start();
        });

        Button StopButton = new Button("Stop");
        StopButton.setOnAction(e -> time.stop());

        // Style buttons
        styleButton(AddRobotButton, "#000dff");
        styleButton(AddFreezeRobotButton, "#00ff00");
        styleButton(AddEngulfRobotButton, "#ff8800");
        styleButton(DeleteRobotButton, "#ff0000");
        styleButton(ResetArenaButton, "#ff9900");
        styleButton(StartButton, "#15c218");
        styleButton(StopButton, "#ff0000");

        HBox hbButtons = new HBox(20);
        hbButtons.setAlignment(Pos.CENTER_RIGHT);
        hbButtons.setPadding(new Insets(0, 160, 50, 0));
        hbButtons.getChildren().addAll(AddRobotButton, AddFreezeRobotButton, AddEngulfRobotButton, DeleteRobotButton, ResetArenaButton, StartButton, StopButton);

        // Menu handler for menu bar
        MenuHandler menuHandler = new MenuHandler(Arena, mc);
        MenuBar menuBar = menuHandler.createMenuBar();

        // Add "Help" functionality
        menuHandler.setHelpContent("""
            In this console:
            - Add Robot: Adds a regular red robot to the canvas. You can select a specific robot and click a location to change its starting position.
            - Add Freeze Robot: Adds a green robot that stops regular robots for 3 seconds upon collision. The freeze robot itself is collision-free.
            - Add Engulf Robot: Adds a blue robot that deletes any other robot it touches one automatically spawns after 15 seconds.
            - Delete Robot: Deletes the last robot added to the canvas.
            - Reset Arena: Clears the canvas, removing all robots and items.
            - Start/Stop Buttons: Control when all robots can move.
            - Yellow Dot: Represents an item that increases a robot's size for 15 seconds.
        """);

        BorderPane bp = new BorderPane();
        bp.setTop(menuBar);
        bp.setCenter(root);
        bp.setBottom(hbButtons);
        bp.setLeft(vbList);

        // Mouse event for selecting and moving robots
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> handleMouseClick(e));

        Scene scene = new Scene(bp, 1400, 700);
        stagePrimary.setScene(scene);
        stagePrimary.show();
    }

    /**
     * Styles a button with a specified colour and consistent formatting.
     *
     * @param button The button to style.
     * @param color  The colour to apply to the button's border and text.
     */
    private void styleButton(Button button, String color) {
        button.setStyle(String.format("-fx-border-color: %s; -fx-border-width: 3px; -fx-font-size: 2em; -fx-text-fill: %s;", color, color));
    }

    /**
     * Handles mouse clicks for selecting and moving robots on the canvas.
     *
     * @param e The MouseEvent representing the click.
     */
    private void handleMouseClick(MouseEvent e) {
        double mouseX = e.getX();
        double mouseY = e.getY();

        if (selectedRobot == null) {
            for (Robot robot : Arena.numRobot) {
                if (Math.hypot(robot.getX() - mouseX, robot.getY() - mouseY) <= robot.getRadius()) {
                    selectedRobot = robot;
                    System.out.println("Robot selected: " + robot.getName());
                    break;
                }
            }
        } else {
            selectedRobot.dx = mouseX;
            selectedRobot.dy = mouseY;
            System.out.println("Robot moved to: " + mouseX + ", " + mouseY);
            selectedRobot = null;
        }

        mc.changeCanvas(Arena);
    }

    /**
     * Deletes the last robot added to the arena and updates the display.
     *
     * @param mc       The ArenaCanvas used for rendering.
     * @param Vehicles The ListView displaying the list of robots.
     */
    private void deleteRobot(ArenaCanvas mc, ListView<Robot> Vehicles) {
        if (!Arena.numRobot.isEmpty()) {
            Arena.numRobot.remove(Arena.numRobot.size() - 1);
            mc.changeCanvas(Arena);
            listRobots(Vehicles);
        } else {
            showMessage("No Robots", "There are no robots to delete.");
        }
    }

    private void showMessage(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Updates the ListView with the current list of robots in the arena.
     *
     * @param RobotGroup The ListView to update.
     */
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> handleMouseClick(e));

        Scene scene = new Scene(bp, 1400, 700);
        stagePrimary.setScene(scene);
        stagePrimary.show();
    }

    /**
     * Styles a button with a specified colour and consistent formatting.
     *
     * @param button The button to style.
     * @param color  The colour to apply to the button's border and text.
     */
    private void styleButton(Button button, String color) {
        button.setStyle(String.format("-fx-border-color: %s; -fx-border-width: 3px; -fx-font-size: 2em; -fx-text-fill: %s;", color, color));
    }

    /**
     * Handles mouse clicks for selecting and moving robots on the canvas.
     *
     * @param e The MouseEvent representing the click.
     */
    private void handleMouseClick(MouseEvent e) {
        double mouseX = e.getX();
        double mouseY = e.getY();

        if (selectedRobot == null) {
            for (Robot robot : Arena.numRobot) {
                if (Math.hypot(robot.getX() - mouseX, robot.getY() - mouseY) <= robot.getRadius()) {
                    selectedRobot = robot;
                    System.out.println("Robot selected: " + robot.getName());
                    break;
                }
            }
        } else {
            selectedRobot.dx = mouseX;
            selectedRobot.dy = mouseY;
            System.out.println("Robot moved to: " + mouseX + ", " + mouseY);
            selectedRobot = null;
        }

        mc.changeCanvas(Arena);
    }

    /**
     * Deletes the last robot added to the arena and updates the display.
     *
     * @param mc       The ArenaCanvas used for rendering.
     * @param Vehicles The ListView displaying the list of robots.
     */
    private void deleteRobot(ArenaCanvas mc, ListView<Robot> Vehicles) {
        if (!Arena.numRobot.isEmpty()) {
            Arena.numRobot.remove(Arena.numRobot.size() - 1);
            mc.changeCanvas(Arena);
            listRobots(Vehicles);
        } else {
            showMessage("No Robots", "There are no robots to delete.");
        }
    }

    private void showMessage(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Updates the ListView with the current list of robots in the arena.
     *
     * @param RobotGroup The ListView to update.
     */
    public static void listRobots(ListView<Robot> RobotGroup) {
        RobotGroup.getItems().clear();
        for (Robot r : Arena.numRobot) RobotGroup.getItems().add(r);
    }

}
