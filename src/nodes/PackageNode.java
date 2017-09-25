package nodes;

import nodes.util.RealNode;
import nodes.util.SortByNode;

public class PackageNode extends RealNode {

    public PackageNode(String directory, RealNode parent) {
        super(directory, parent);
        this.name = directory.substring(directory.lastIndexOf('\\')+1);
        parent.addChild(this);

        this.nodePriority = 1;
    }
}