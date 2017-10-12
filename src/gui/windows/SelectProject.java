package gui.windows;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import nodes.RootNode;

public class SelectProject extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btnNew = new Button("New Project");

        DirectoryChooser directory = new DirectoryChooser();

        Hyperlink lnNew = new Hyperlink();
        lnNew.setText("New Project");
        lnNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                directory.showDialog(primaryStage);
            }
        });

        Hyperlink lnOpen = new Hyperlink();
        lnOpen.setText("Open Project");
        lnOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                directory.showDialog(primaryStage);
            }
        });


        VBox center = new VBox(lnNew, lnOpen);
        center.getStyleClass().add("scope-welcome");

        Label lbl = new Label("No Projects");
        Label lbl2 = new Label("Still no Projects");
        lbl.getStyleClass().add("project-label");
        lbl2.getStyleClass().add("project-label");

        ListView<Label> left = new ListView<Label>();
        left.getItems().addAll(lbl, lbl2);
        left.getStyleClass().add("project-list");


        BorderPane bp = new BorderPane();
        bp.setLeft(left);
        bp.setCenter(center);

        StackPane root = new StackPane(bp);
        Scene scene = new Scene(root);

        scene.getStylesheets().add("gui/styles/stylesheet.css");

        primaryStage.setTitle("Welcome to Scope!");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(640);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void createWindow() {
        launch();
    }
}