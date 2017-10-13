package gui.windows;

import gui.controls.ProjectTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PrimaryWindow extends Application {

    @Override
    public void start(Stage primaryStage) {

        Menu file = new Menu("file");
        file.getItems().addAll(new MenuItem("oh"), new MenuItem("hey"));

        MenuBar top = new MenuBar();
        top.getMenus().add(file);


        Label title = new Label();
        ListView<Label> contents = new ListView<>();
        ScrollPane topRight = new ScrollPane();
        VBox right = new VBox();

        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setLeft(ProjectTree.getInstance().getLeft());

        StackPane root = new StackPane();
        root.getChildren().add(bp);

        //root.getChildren().add(btn);

        Scene scene = new Scene(root);

        scene.getStylesheets().add("gui/styles/stylesheet.css");

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(640);
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void createWindow() {
        launch();
    }
}