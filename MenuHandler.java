// MenuHandler.java
package robot_gui;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;

public class MenuHandler {
    private final RobotArena arena; // Reference to the arena
    private final ArenaCanvas canvas; // Reference to the canvas
    private String helpContent = ""; // Stores help menu content

    public MenuHandler(RobotArena arena, ArenaCanvas canvas) {
        this.arena = arena;
        this.canvas = canvas;
    }

    public MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        // File menu
        Menu mFile = new Menu("File");
        MenuItem mSave = new MenuItem("Save Arena");
        mSave.setOnAction(e -> saveArena()); // Link updated saveArena method here
        MenuItem mLoad = new MenuItem("Load Arena");
        mLoad.setOnAction(e -> loadArena()); // Placeholder or actual load logic
        MenuItem mExit = new MenuItem("Exit");
        mExit.setOnAction(e -> System.exit(0));
        mFile.getItems().addAll(mSave, mLoad, mExit);

        // Info menu
        Menu mInfo = new Menu("Info");
        MenuItem mAbout = new MenuItem("About");
        mAbout.setOnAction(e -> showMessage("About", "Robot Arena GUI.\n This is a robot simulation that uses JavaFX to visualise robot movement."));
        MenuItem mHelp = new MenuItem("Help");
        mHelp.setOnAction(e -> showMessage("Help", helpContent));
        MenuItem mCredits = new MenuItem("Credits");
        mCredits.setOnAction(e -> showMessage("Credits", "This program was made by James Duodu-Dapaa, 32017435."));
        mInfo.getItems().addAll(mAbout, mHelp, mCredits);

        menuBar.getMenus().addAll(mFile, mInfo);
        return menuBar;
    }

    /**
     * Updates the placeholder saveArena() method with actual logic.
     */
    private void saveArena() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Arena");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arena Files", "*.dat"));

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            boolean success = arena.saveArena(file.getAbsolutePath());
            if (success) {
                showMessage("Save Arena", "Arena successfully saved to " + file.getName());
            } else {
                showMessage("Save Arena", "Failed to save the arena. Please try again.");
            }
        }
    }

    private void loadArena() {
        showMessage("Load Arena", "Loading the arena feature is not yet implemented.");
    }

    public void setHelpContent(String content) {
        helpContent = content;
    }
// MenuHandler.java
package robot_gui;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;

public class MenuHandler {
    private final RobotArena arena; // Reference to the arena
    private final ArenaCanvas canvas; // Reference to the canvas
    private String helpContent = ""; // Stores help menu content

    public MenuHandler(RobotArena arena, ArenaCanvas canvas) {
        this.arena = arena;
        this.canvas = canvas;
    }

    public MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        // File menu
        Menu mFile = new Menu("File");
        MenuItem mSave = new MenuItem("Save Arena");
        mSave.setOnAction(e -> saveArena()); // Link updated saveArena method here
        MenuItem mLoad = new MenuItem("Load Arena");
        mLoad.setOnAction(e -> loadArena()); // Placeholder or actual load logic
        MenuItem mExit = new MenuItem("Exit");
        mExit.setOnAction(e -> System.exit(0));
        mFile.getItems().addAll(mSave, mLoad, mExit);

        // Info menu
        Menu mInfo = new Menu("Info");
        MenuItem mAbout = new MenuItem("About");
        mAbout.setOnAction(e -> showMessage("About", "Robot Arena GUI.\n This is a robot simulation that uses JavaFX to visualise robot movement."));
        MenuItem mHelp = new MenuItem("Help");
        mHelp.setOnAction(e -> showMessage("Help", helpContent));
        MenuItem mCredits = new MenuItem("Credits");
        mCredits.setOnAction(e -> showMessage("Credits", "This program was made by James Duodu-Dapaa, 32017435."));
        mInfo.getItems().addAll(mAbout, mHelp, mCredits);

        menuBar.getMenus().addAll(mFile, mInfo);
        return menuBar;
    }

    /**
     * Updates the placeholder saveArena() method with actual logic.
     */
    private void saveArena() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Arena");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arena Files", "*.dat"));

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            boolean success = arena.saveArena(file.getAbsolutePath());
            if (success) {
                showMessage("Save Arena", "Arena successfully saved to " + file.getName());
            } else {
                showMessage("Save Arena", "Failed to save the arena. Please try again.");
            }
        }
    }

    private void loadArena() {
        showMessage("Load Arena", "Loading the arena feature is not yet implemented.");
    }

    public void setHelpContent(String content) {
        helpContent = content;
    }

    private void showMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
