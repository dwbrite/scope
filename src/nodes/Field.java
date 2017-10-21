package nodes;

import javafx.scene.control.Label;
import lombok.Data;
import nodes.util.ClassEnums.Visibility;

@Data
public class Field extends Label{

    private Visibility visibility;
    private String type;
    private String name;

    public Field(Visibility visibility, String type, String name) {
        this.visibility = visibility;
        this.type = type;
        this.name = name;
    }

    public Label getLabel() {
        StringBuilder builder = new StringBuilder();
        builder.append(visibility.toString() + " " + name);
        builder.append(": " + type);
        setText(builder.toString());
        return this;
    }
}
