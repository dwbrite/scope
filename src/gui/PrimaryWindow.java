package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import nodes.RootNode;
import nodes.util.RealNode;

public class PrimaryWindow extends Application {

    @Override
    public void start(Stage primaryStage) {

        Line ln = new Line();

        Menu file = new Menu("file");
        file.getItems().addAll(new MenuItem("o"), new MenuItem("hej"));

        MenuBar top = new MenuBar();
        top.getMenus().add(file);

        TreeView left = new TreeView();

        // TODO: remove temp line
        TreeItem troot = RootNode.initFromDirectory("Scope", "src").toTreeItem();
        left.setRoot(troot);
        troot.setExpanded(true);

        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setLeft(left);

        StackPane root = new StackPane();
        root.getChildren().add(bp);

        //root.getChildren().add(btn);

        Scene scene = new Scene(root);

        scene.getStylesheets().add("gui/styles/stylesheet.css");

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void createWindow() {
        launch();
    }
}