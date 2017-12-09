package nodes.util;

import lombok.Getter;

import java.util.ArrayList;


public interface INode {
    ArrayList<RealNode> children = new ArrayList<>();

    String toString();
    RealNode getLastChild();
    void addChild(RealNode child);
    ArrayList<RealNode> getChildren();
}
