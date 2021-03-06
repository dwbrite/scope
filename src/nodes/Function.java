package nodes;

import javafx.scene.control.Label;
import lombok.Data;
import lombok.EqualsAndHashCode;
import nodes.util.ClassEnums.*;

import java.util.ArrayList;
import java.util.Arrays;

@Data @EqualsAndHashCode(callSuper=false)
public class Function extends Label{

    private Visibility visibility;
    private String name;
    private ArrayList<String> parameters;
    private String type;

    public Function(Visibility visibility, String name, String[] parameters, String type) {
        this(visibility, name, new ArrayList<>(), type);
        this.parameters.addAll(Arrays.asList(parameters));
    }

    Function(Visibility visibility, String name, ArrayList<String> parameters, String type) {
        this.visibility = visibility;
        this.parameters = parameters;
        this.type = type;
        this.name = name;
    }

    public Label getLabel() {
        StringBuilder builder = new StringBuilder();
        builder.append(visibility.toString()).append(" ").append(name);
        builder.append("(");
        for(int i = 0; i < parameters.size(); i++) {
            builder.append(parameters.get(i));
            if (i < parameters.size() - 1) { builder.append(", "); }
        }
        builder.append(")");
        builder.append(": ").append(type);
        setText(builder.toString());
        return this;
    }
}
