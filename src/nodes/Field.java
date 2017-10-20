package nodes;

import lombok.Data;
import nodes.util.ClassEnums.Visibility;

public @Data class Field {
    private Visibility visibility;
    private String datatype;
    private String name;

    Field(Visibility visibility, String datatype, String name) {
        this.visibility = visibility;
        this.datatype = datatype;
        this.name = name;
    }
}
