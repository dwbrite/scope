package nodes;

import gui.windows.primary.PrimaryWindow;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nodes.util.EmptyNode;
import nodes.util.INode;
import nodes.util.RealNode;

import java.io.File;

//This represents the root of the project within Scope's interface.

public class RootNode extends RealNode {

    private RootNode(String directory, INode parent) {
        super(directory, parent);
        this.nodePriority = 0;

        Label type = new Label("Root");
        type.getStyleClass().add("real-node-type");
        Label name = new Label(this.name);
        name.getStyleClass().add("real-node-name");

        pane.getChildren().addAll(type, name);
        pane.setOnMouseClicked( (e) -> {
            if (e.getClickCount() == 2)
                PrimaryWindow.getInstance().setSelectedNode(this);
        });
    }

    public static RootNode initFromDirectory(String name, String directory) {
        RootNode nt = new RootNode(directory, new EmptyNode());
        nt.parent.addChild(nt);
        nt.name = name;
        nt.tree = name;

        final File folder = new File(directory);
        try {
            nt.listFilesForFolder(folder, nt);
        } catch (Exception e) {
            // TODO: better error handling.
            System.out.println("Whoops!");
        }

        nt.updateTree();

        return nt;
    }

    private void listFilesForFolder(final File folder, RealNode parent) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                PackageNode pn = new PackageNode(fileEntry.toString(), parent);
                listFilesForFolder(fileEntry, pn);
            } else {
                // TODO: figure out if this is necessary
                ClassNode cn = new ClassNode(fileEntry.toString(), parent);
            }
        }
    }
}
