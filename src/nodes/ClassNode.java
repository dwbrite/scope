package nodes;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import gui.windows.primary.PrimaryWindow;
import javafx.scene.control.Label;
import nodes.util.ClassEnums;
import nodes.util.RealNode;

import java.io.File;
import java.util.ArrayList;

public class ClassNode extends RealNode {

    public ArrayList<Field> fields = new ArrayList<>();
    public ArrayList<Function> functions = new ArrayList<>();
    private JavaClass javaClass;

    private static boolean isShowingExtension = true;

    ClassNode(String directory, RealNode parent) {
        super(directory, parent);

        JavaProjectBuilder builder = new JavaProjectBuilder();

        try {
            if(directory.endsWith(".java")) {
                javaClass = builder.addSource(new File(directory)).getClasses().get(0);
                for(JavaField f : javaClass.getFields()) {
                    ClassEnums.Visibility v;
                    if(f.isPrivate()) v = ClassEnums.Visibility.PRIVATE;
                    else if (f.isPublic()) v = ClassEnums.Visibility.PUBLIC;
                    else if (f.isProtected()) v = ClassEnums.Visibility.PROTECTED;
                    else v = ClassEnums.Visibility.PACKAGE;

                    fields.add(new Field(v, f.getType().getSimpleName(), f.getName()));
                }
                for(JavaMethod f : javaClass.getMethods()) {
                    ClassEnums.Visibility v;
                    if(f.isPrivate()) v = ClassEnums.Visibility.PRIVATE;
                    else if (f.isPublic()) v = ClassEnums.Visibility.PUBLIC;
                    else if (f.isProtected()) v = ClassEnums.Visibility.PROTECTED;
                    else v = ClassEnums.Visibility.PACKAGE;

                    ArrayList<String> params = new ArrayList<>();
                    for(JavaParameter p : f.getParameters()) {
                        params.add(p.getName());
                    }
                    functions.add(new Function(v, f.getName(), params, f.getReturnType().toGenericString()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isShowingExtension) {
            this.name = this.directory.substring(this.directory.lastIndexOf("/") + 1);
        } else {
            this.name = this.directory.substring(this.directory.lastIndexOf("/") + 1, this.directory.lastIndexOf('.'));
        }

        parent.addChild(this);

        this.nodePriority = 2;


        Label type = new Label("Class");
        type.getStyleClass().add("real-node-type");
        Label name = new Label(this.name);
        name.getStyleClass().add("real-node-name");

        pane.getChildren().addAll(type, name);
        pane.setOnMouseClicked( (e) -> {
            if (e.getClickCount() == 2)
                PrimaryWindow.getInstance().setSelectedNode(this);
        });
    }
}
