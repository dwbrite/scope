package nodes;

import lombok.Data;
import nodes.util.ClassEnums.*;

import java.util.ArrayList;

public @Data class Function {
    private Visibility visibility;
    private String name;
    private ArrayList<String> parameters;
    private String output;

    Function(Visibility visibility, String name, ArrayList<String> parameters, String output) {
        this.visibility = visibility;
        this.parameters = parameters;
        this.output = output;
        this.name = name;
    }



}
