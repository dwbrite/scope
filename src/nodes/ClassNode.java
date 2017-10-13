package nodes;

import nodes.util.RealNode;

import java.util.ArrayList;

public class ClassNode extends RealNode {

    public ArrayList<Field> fields;
    public ArrayList<Function> functions;

    public static boolean isShowingExtension = true;

    public ClassNode(String directory, RealNode parent) {
        super(directory, parent);

        if (isShowingExtension) {
            this.name = this.directory.substring(this.directory.lastIndexOf("/") + 1);
        } else {
            this.name = this.directory.substring(this.directory.lastIndexOf("/") + 1, this.directory.lastIndexOf('.'));
        }

        parent.addChild(this);

        this.nodePriority = 2;
    }


}
