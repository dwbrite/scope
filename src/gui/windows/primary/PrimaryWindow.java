package gui.windows.primary;

import gui.windows.primary.controls.ElementView;
import gui.windows.primary.controls.ProjectCanvas;
import gui.windows.primary.controls.ProjectMenu;
import gui.windows.primary.controls.ProjectTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import nodes.util.RealNode;
import util.ScopeConfig;


//This class is the main window of the program. It contains the other various panes.
public class PrimaryWindow extends Application {

    @Getter private static PrimaryWindow instance;

    @Getter private RealNode selectedNode;
    private BorderPane bp = new BorderPane();
    private Pane fp = new Pane();
    private SplitPane sp = new SplitPane();

    @Override
    public void start(Stage primaryStage) {
        instance = this;

        // Populate border pane
        bp.setTop(ProjectMenu.getInstance());
        //bp.setLeft(ProjectTree.getInstance());
        //bp.setRight(ElementView.getInstance());

        fp.setId("center-pane");

        sp.getItems().addAll(
                ProjectTree.getInstance(),
                ProjectCanvas.getInstance(),
                ElementView.getInstance()
        );

        sp.setDividerPosition(0, 0.05);
        bp.setCenter(sp);

        Scene scene = new Scene(bp);

        scene.getStylesheets().add(ScopeConfig.getCss());

        primaryStage.setTitle("Scope!");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1600);
        primaryStage.setHeight(960);
        primaryStage.show();

        PrimaryWindow.getInstance().setSelectedNode(ProjectTree.getInstance().getRootNode());
    }

    public static void createWindow() {
        launch();
    }

    public void setSelectedNode(RealNode node) {
        this.selectedNode = node;
        ProjectCanvas.getInstance().setNode(node);
        ElementView.getInstance().setNode(node);
    }
}