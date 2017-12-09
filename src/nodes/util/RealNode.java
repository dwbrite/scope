package nodes.util;

import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import lombok.Getter;
import nodes.ClassNode;

import java.util.ArrayList;

//RealNode acts as a parent class for Class, Package, and Rootnode.

public abstract class RealNode implements INode {
    protected String name;
    protected String directory;
    protected String tree; // TODO: Rename or remove this.
    protected int nodePriority;
    @Getter protected ArrayList<RealNode> children = new ArrayList<>();
    protected INode parent;
    @Getter protected VBox pane = new VBox();

    public RealNode(String directory, INode parent) {
        this.directory = directory.replace("\\", "/");
        this.parent = parent;

        pane.getStyleClass().add("real-node");
    }

    @Override
    public String toString() {
        return name;
    }

    public void updateTree() {
        // TODO: Remove some features.
        // This method contains mostly archaic features for rendering the node in the terminal.
        // The only things I'd really keep are children.sort(...) and child.updateTree().

        children.sort(new SortByNode());

        StringBuilder sb = new StringBuilder();

        // Adds a pipe where the depth is greater than two.
        int directoryDepth = directory.split("/").length;
        for(int i = 2; i < directoryDepth; i++) {
            sb.append("│  ");
        }
        String space = sb.toString();

        // If this is the last sibling element, render it as if there are no children below it.
        if (this == parent.getLastChild()) {
            sb.append("└──").append(name).append((this instanceof ClassNode?"\n"+space:""));
        } else {
            sb.append("├──").append(name);
        }

        this.tree = sb.toString();

        for(RealNode child : children) {
            child.updateTree();
        }
    }

    private String toTextTree() {
        // Used for rendering the node tree in the terminal.

        StringBuilder s = new StringBuilder();
        s.append(tree).append("\n");
        for (RealNode c : children) {
            s.append(c.toTextTree());
        }

        return s.toString();
    }

    public TreeItem<String> toTreeItem() {
        updateTree();
        TreeItem<String> parent = new TreeItem<>(name);

        for (RealNode child : children) {
            parent.getChildren().add(child.toTreeItem());
        }

        return parent;
    }

    @Override
    public void addChild(RealNode child) {
        updateTree();
        this.children.add(child);
    }

    @Override
    public RealNode getLastChild() {
        return children.get(children.size()-1);
    }

    public RealNode getFromTreeItem(TreeItem item) {
        // This one's a bit of a doozey.
        // NOTE: as of now, this method should only ever be used on the root node. This is poor design at its worst.

        // Search UP the TreeItem tree to the root node
        ArrayList<Object> trace = new ArrayList<>();
        TreeItem treeItem = item;
        while(treeItem != null) {
            trace.add(treeItem.getValue());
            treeItem = treeItem.getParent();
        }

        // Search down the real nodes, following the branches in the trace, to reach the respective RealNode
        RealNode ch = this;
        for (int i = trace.size()-1; i >= 0; i--) {
            for (RealNode child : ch.getChildren()) {
                if(child.toString() == trace.get(i)) {
                    ch = child;
                    break;
                }
            }
        }

        return ch;
    }
}
