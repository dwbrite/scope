package nodes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import nodes.util.RealNode;
import nodes.util.SortByNode;

import java.io.File;

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
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
    }
}