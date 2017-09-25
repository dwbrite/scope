package nodes;

import nodes.util.RealNode;
import nodes.util.SortByNode;

public class ClassNode extends RealNode {
    public static boolean isShowingExtension = true;

    public ClassNode(String directory, RealNode parent) {
        super(directory, parent);

        if(isShowingExtension) {
            this.name =  directory.substring(directory.lastIndexOf('\\')+1);
        } else {
            this.name = directory.substring(directory.lastIndexOf('\\')+1, directory.lastIndexOf('.'));
        }

        parent.addChild(this);

        this.nodePriority = 2;
    }
}
