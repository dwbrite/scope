package gui.windows.primary;

import gui.windows.primary.controls.ProjectMenu;
import gui.windows.primary.controls.ProjectTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PrimaryWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();

        // Populate border pane
        bp.setTop(ProjectMenu.getInstance().getMenuBar());
        bp.setLeft(ProjectTree.getInstance().getTreeView());

        //TODO: Decide whether or not we want to use a stack pane.
        StackPane root = new StackPane();
        root.getChildren().add(bp);

        Scene scene = new Scene(root);

        scene.getStylesheets().add("gui/styles/stylesheet.css");

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(640);
        primaryStage.show();
    }

    public static void createWindow() {
        launch();
    }
}