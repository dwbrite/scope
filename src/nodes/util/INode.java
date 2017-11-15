package nodes.util;

import lombok.Getter;

import java.util.ArrayList;


public interface INode {
    ArrayList<RealNode> children = new ArrayList<>();

    public String toString();
    public RealNode getLastChild();
    public void addChild(RealNode child);
    public ArrayList<RealNode> getChildren();

}
