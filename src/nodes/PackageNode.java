package nodes;

import gui.windows.primary.PrimaryWindow;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import nodes.util.RealNode;
import nodes.util.SortByNode;

import java.io.File;

//This represents a package within Scope's interface.

class PackageNode extends RealNode {

    PackageNode(String directory, RealNode parent) {
        super(directory, parent);
        this.name = this.directory.substring(this.directory.lastIndexOf("/")+1);
        parent.addChild(this);

        this.nodePriority = 1;

        Label type = new Label("Package");
        type.getStyleClass().add("real-node-type");
        Label name = new Label(this.name);
        name.getStyleClass().add("real-node-name");

        pane.getChildren().addAll(type, name);
        pane.setOnMouseClicked( (e) -> {
            if (e.getClickCount() == 2)
                PrimaryWindow.getInstance().setSelectedNode(this);
        });
    }
}