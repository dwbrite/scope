package nodes.util;

import java.util.ArrayList;


public class EmptyNode implements INode {

    @Override
    public void addChild(RealNode child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public RealNode getLastChild() {
        return children.get(children.size()-1);
    }
    @Override
    public ArrayList<RealNode> getChildren() { return children; }
}
