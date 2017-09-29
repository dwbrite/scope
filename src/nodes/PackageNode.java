package nodes;

import nodes.util.RealNode;
import nodes.util.SortByNode;

import java.io.File;

public class PackageNode extends RealNode {

    public PackageNode(String directory, RealNode parent) {
        super(directory, parent);
        this.name = directory.substring(directory.lastIndexOf(File.separator)+1);
        parent.addChild(this);

        this.nodePriority = 1;
    }
}