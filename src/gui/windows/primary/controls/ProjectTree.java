package gui.windows.primary.controls;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import lombok.Data;
import nodes.RootNode;
import nodes.util.INode;

//This class serves as the tree on the left of the window. It provides largely the same functionality as the canvas
//to the left of the window.
@Data
public class ProjectTree extends TreeView {
    private static ProjectTree projectTreeUI = new ProjectTree();
    public static ProjectTree getInstance() {
        return projectTreeUI;
    }

    private TreeItem treeRoot;
    private RootNode rootNode = RootNode.initFromDirectory("Scope", "src");

    private ProjectTree() {
        treeRoot = rootNode.toTreeItem();
        setRoot(treeRoot);
        treeRoot.setExpanded(true);

        setId("project-tree");
    }


}


