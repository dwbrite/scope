package gui.windows.primary.controls;

import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.Data;
import lombok.EqualsAndHashCode;
import nodes.ClassNode;
import nodes.Field;
import nodes.Function;
import nodes.util.RealNode;

@Data @EqualsAndHashCode(callSuper=false)
public class ElementView extends SplitPane {
    private static ElementView elementView = new ElementView();
    public static ElementView getInstance() {
        return elementView;
    }

    private ElementView() {
        getItems().addAll(
                ElementSummary.getInstance()
        );
        setOrientation(Orientation.VERTICAL);

        setId("element-view");
    }

    public void setNode(RealNode node) {
        ElementSummary.getInstance().setNode(node);
    }
}

@Data @EqualsAndHashCode(callSuper=false)
class ElementSummary extends VBox {
    private static ElementSummary overview = new ElementSummary();
    public static ElementSummary getInstance() { return overview; }

    private Label title = new Label();
    ListView list = new ListView();

    private ElementSummary() {
        Separator listSeparator = new Separator();
        title.setText("");
        title.setId("summary-title");
        listSeparator.setId("list-separator");

        getChildren().addAll(title,
                new Separator(),
                list
        );

        VBox.setVgrow(list, Priority.ALWAYS);
        this.setSpacing(0);

        setId("element-summary");
    }

    public void setNode(RealNode node) {
        list.getItems().clear();
        if (node instanceof ClassNode) {
            title.setText(node.toString());
            for (Field field : ((ClassNode) node).fields) {
                list.getItems().add(field.getLabel());
            }
            list.getItems().add(new Separator());
            for (Function function : ((ClassNode) node).functions) {
                list.getItems().add(function.getLabel());
            }
        } else {
            title.setText("");
        }
    }
}

@Data @EqualsAndHashCode(callSuper=false)
class ElementElaboration extends Pane {
    private static ElementElaboration elementElaboration = new ElementElaboration();
    public static ElementElaboration getInstance() { return elementElaboration; }

    //etc
    private ElementElaboration() {

        //.prefWidthProperty().bind(this.widthProperty());
        //.prefHeightProperty().bind(this.heightProperty());
        setId("element-elaboration");

        //getChildren().add()
    }
}