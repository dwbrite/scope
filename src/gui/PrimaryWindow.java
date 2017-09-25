package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nodes.util.RealNode;

public class PrimaryWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeView<RealNode> tvw = new TreeView<>();
        Accordion acc = new Accordion();
        acc.getPanes().add(new TitledPane());
        Button btn = new Button(":)");

        VBox vb1 = new VBox(tvw);
        VBox vb2 = new VBox(btn);
        VBox vb3 = new VBox(acc);

        HBox hbx = new HBox(200, vb1,vb2,vb3);

        StackPane root = new StackPane();
        root.getChildren().add(hbx);

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