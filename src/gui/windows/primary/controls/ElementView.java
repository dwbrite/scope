package gui.windows.primary.controls;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import lombok.Data;

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
    private ListView<Label> fields = new ListView<>();
    private ListView<Label> functions = new ListView<>();

    ElementSummary() {
        Separator listSeparator = new Separator();

        title.setText("ClassTitle");
        title.setId("summary-title");
        listSeparator.setId("list-separator");
        fields.setId("fields-list");
        functions.setId("functions-list");

        fields.getItems().addAll(
                new Label("+ tempField"),
                new Label("+ tempField"),
                new Label("+ tempField"),
                new Label("+ tempField")
        );


        functions.getItems().addAll(
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()"),
                new Label("+ tempFunction()")
        );

        getChildren().addAll(title,
                new Separator(),
                fields,
                listSeparator,
                functions
        );

        this.setSpacing(0);
        setAlignment(Pos.TOP_LEFT);

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