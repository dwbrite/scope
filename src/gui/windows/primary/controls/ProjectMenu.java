package gui.windows.primary.controls;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import lombok.Data;

//This class serves as the main menubar at the top of the window.
@Data
public class ProjectMenu extends Pane {
    private static ProjectMenu projectMenuUI = new ProjectMenu();
    public static ProjectMenu getInstance() {
        return projectMenuUI;
    }


    private Menu fileMenu = new Menu("_File");
    Menu editMenu = new Menu("_Edit");
    private MenuBar menuBar = new MenuBar();

    private ProjectMenu() {
        fileMenu.getItems().addAll(
                new MenuItem("oh"),
                new MenuItem("hey")
        );

        editMenu.getItems().addAll(
                new MenuItem("oops"),
                new MenuItem("no edit yet :(")
        );

        menuBar.getMenus().addAll(fileMenu, editMenu);

        menuBar.prefWidthProperty().bind(this.widthProperty());
        //menuBar.prefHeightProperty().bind(this.heightProperty());
        setId("project-menu");

        getChildren().add(menuBar);
    }
}