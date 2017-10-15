package gui.windows.primary.controls;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import lombok.Data;

@Data
public class ProjectMenu {
    private static ProjectMenu projectMenuUI = new ProjectMenu();
    public static ProjectMenu getInstance() {
        return projectMenuUI;
    }


    private Menu fileMenu = new Menu("File");
    private MenuBar menuBar = new MenuBar();

    private ProjectMenu() {
        fileMenu.getItems().addAll(new MenuItem("oh"), new MenuItem("hey"));
        menuBar.getMenus().add(fileMenu);
        fileMenu.setMnemonicParsing(true);
    }
}