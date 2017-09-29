package nodes;

import nodes.util.RealNode;
import nodes.util.SortByNode;

import java.io.File;

public class ClassNode extends RealNode {
    public static boolean isShowingExtension = true;

    public ClassNode(String directory, RealNode parent) {
        super(directory, parent);

        if(isShowingExtension) {
            this.name =  this.directory.substring(this.directory.lastIndexOf("/")+1);
        } else {
            this.name = this.directory.substring(this.directory.lastIndexOf("/")+1, this.directory.lastIndexOf('.'));
        }

        parent.addChild(this);

        this.nodePriority = 2;
    }
}
