package gui.windows.primary.controls;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import lombok.Data;
import nodes.RootNode;

@Data
public class ProjectTree {
    private static ProjectTree projectTreeUI = new ProjectTree();
    public static ProjectTree getInstance() {
        return projectTreeUI;
    }


    private TreeView treeView = new TreeView();
    private TreeItem treeRoot = RootNode.initFromDirectory("Scope", "src").toTreeItem();

    private ProjectTree() {
        treeView.setRoot(treeRoot);
        treeRoot.setExpanded(true);
    }
}
