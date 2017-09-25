package nodes.util;

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
}
