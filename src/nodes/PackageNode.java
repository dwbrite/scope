package nodes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import nodes.util.RealNode;
import nodes.util.SortByNode;

import java.io.File;

//This represents a package within Scope's interface.

public class PackageNode extends RealNode {

    public PackageNode(String directory, RealNode parent) {
        super(directory, parent);
        this.name = this.directory.substring(this.directory.lastIndexOf("/")+1);
        parent.addChild(this);

        this.nodePriority = 1;
    }

    @Override
    public void draw(GraphicsContext gc, int x, int y){
        //TODO: Make this proper
        gc.setStroke(Color.BLUE);
        int wh = 30;
        gc.strokeRoundRect(x - (wh/2), y - (wh/2), wh, wh, 10, 10);
    }
}