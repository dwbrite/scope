package gui.windows.primary.controls;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import lombok.Data;
import nodes.RootNode;

@Data
public class ProjectTree extends TreeView {
    private static ProjectTree projectTreeUI = new ProjectTree();
    public static ProjectTree getInstance() {
        return projectTreeUI;
    }

    private TreeItem treeRoot = RootNode.initFromDirectory("Scope", "src").toTreeItem();

    private ProjectTree() {
        setRoot(treeRoot);
        treeRoot.setExpanded(true);

        setId("project-tree");
    }
}
