package nodes;

import javafx.scene.canvas.GraphicsContext;
import nodes.util.EmptyNode;
import nodes.util.INode;
import nodes.util.RealNode;

import java.io.File;

//This represents the root of the project within Scope's interface.

public class RootNode extends RealNode {

    RootNode(String directory, INode parent) {
        super(directory, parent);
        this.nodePriority = 0;
    }

    public static RootNode initFromDirectory(String name, String directory) {
        RootNode nt = new RootNode(directory, new EmptyNode());
        nt.parent.addChild(nt);
        nt.name = name;
        nt.tree = name;

        final File folder = new File(directory);
        try {
            nt.listFilesForFolder(folder, nt);
        } catch (Exception e) {
            // Todo: create a real error
            System.out.println("Whoops!");
        }

        nt.updateTree();

        return nt;
    }

    public void listFilesForFolder(final File folder, RealNode parent) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                PackageNode pn = new PackageNode(fileEntry.toString(), parent);
                listFilesForFolder(fileEntry, pn);
            } else {
                ClassNode cn = new ClassNode(fileEntry.toString(), parent);
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc, int x, int y){

    }
}
