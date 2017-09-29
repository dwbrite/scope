package nodes.util;

import javafx.scene.control.TreeItem;
import nodes.ClassNode;

import java.io.File;
import java.util.ArrayList;

public abstract class RealNode implements INode {
    protected String name;
    protected String directory;
    protected String tree;
    protected int nodePriority;
    protected ArrayList<RealNode> children = new ArrayList<>();
    protected INode parent;

    public RealNode(String directory, INode parent) {
        this.directory = directory;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name;
    }

    public void updateTree() {
        /*
        children.sort(new SortByNode());
        for(RealNode child : children) {
            child.updateTree();
        }*/

        children.sort(new SortByNode());

        StringBuilder sb = new StringBuilder();

        int n = directory.split(File.separator).length;
        for(int i = 2; i < n; i++) {
            sb.append("│  ");
        }
        String space = sb.toString();

        // If this is the last sibling element
        if (this == parent.getLastChild()) {
            sb.append("└──" + name + (this instanceof ClassNode?"\n"+space:""));
        } else {
            sb.append("├──" + name);
        }

        this.tree = sb.toString();

        for(RealNode child : children) {
            child.updateTree();
        }
    }

    public String toTextTree() {
        StringBuilder s = new StringBuilder();
        s.append(tree+"\n");
        for (RealNode c : children) {
            s.append(c.toTextTree());
        }

        return s.toString();
    }

    public TreeItem toTreeItem() {
        updateTree();
        TreeItem parent = new TreeItem(name);

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
}
