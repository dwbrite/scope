package gui.windows.primary.controls;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.Data;
import nodes.Field;
import nodes.Function;
import nodes.util.ClassEnums;

import java.util.ArrayList;

@Data
public class ElementView extends SplitPane {
    private static ElementView elementView = new ElementView();
    public static ElementView getInstance() {
        return elementView;
    }

    private ElementView() {
        getItems().addAll(
                ElementSummary.getInstance(),
                ElementElaboration.getInstance()
        );
        setOrientation(Orientation.VERTICAL);

        setId("element-view");
    }
}

@Data
class ElementSummary extends VBox {
    private static ElementSummary overview = new ElementSummary();
    public static ElementSummary getInstance() { return overview; }

    private Label title = new Label();
    RigidListView list = new RigidListView();
    //private ListView<Label> fields = new ListView<>();
    //private ListView<Label> functions = new ListView<>();

    ElementSummary() {
        Separator listSeparator = new Separator();
        title.setText("ClassTitle");
        title.setId("summary-title");
        listSeparator.setId("list-separator");

        //*/
        list.addChildren(
                new Field(ClassEnums.Visibility.PUBLIC, "String", "idkSomeField").getLabel(),
                new Field(ClassEnums.Visibility.PUBLIC, "String", "idkSomeField1").getLabel(),
                new Field(ClassEnums.Visibility.PUBLIC, "String", "idkSomeField2").getLabel(),
                new Field(ClassEnums.Visibility.PUBLIC, "String", "idkSomeField3").getLabel(),
                new Field(ClassEnums.Visibility.PUBLIC, "String", "idkSomeField4").getLabel(),
                new Field(ClassEnums.Visibility.PUBLIC, "String", "idkSomeField5").getLabel(),
                new Separator(),
                new Function(ClassEnums.Visibility.PUBLIC, "idkSomeFn", new String[]{"String", "int", "int"}, "String").getLabel()
                );
        //*/

        //sp.setContent(alist);

        getChildren().addAll(title,
                new Separator(),
                list
        );

        VBox.setVgrow(list, Priority.ALWAYS);

        this.setSpacing(0);
        //setAlignment(Pos.TOP_LEFT);

        setId("element-summary");
    }
}

@Data
class ElementElaboration extends Pane {
    private static ElementElaboration elementElaboration = new ElementElaboration();
    public static ElementElaboration getInstance() { return elementElaboration; }

    //etc
    ElementElaboration() {

        //.prefWidthProperty().bind(this.widthProperty());
        //.prefHeightProperty().bind(this.heightProperty());
        setId("element-elaboration");

        //getChildren().add()
    }
}