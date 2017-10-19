package gui.windows.primary;

import gui.windows.primary.controls.ElementView;
import gui.windows.primary.controls.ProjectMenu;
import gui.windows.primary.controls.ProjectTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import util.ScopeConfig;

public class PrimaryWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();

        // Populate border pane
        bp.setTop(ProjectMenu.getInstance());
        //bp.setLeft(ProjectTree.getInstance());
        //bp.setRight(ElementView.getInstance());

        Pane fp = new Pane();
        fp.setId("center-pane");

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(
                ProjectTree.getInstance(),
                fp,
                ElementView.getInstance()
        );

        sp.setDividerPosition(0, 0.05);
        bp.setCenter(sp);


        Scene scene = new Scene(bp);

        scene.getStylesheets().add(ScopeConfig.getCss());

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