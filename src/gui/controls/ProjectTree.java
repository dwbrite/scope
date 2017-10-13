package gui.controls;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import lombok.Data;
import nodes.RootNode;

public @Data class ProjectTree {
    private static ProjectTree ourInstance = new ProjectTree();

    public static ProjectTree getInstance() {
        return ourInstance;
    }
    private TreeView left = new TreeView();
    private TreeItem troot = RootNode.initFromDirectory("Scope", "src").toTreeItem();


    private ProjectTree() {
        left.setRoot(troot);
        troot.setExpanded(true);
    }
}
