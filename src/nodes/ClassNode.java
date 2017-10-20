package nodes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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

    @Override
    public void draw(GraphicsContext gc, int x, int y){
        gc.setFill(Color.GREEN);

        gc.strokeOval(60, 60, 30, 30);
    }

}
