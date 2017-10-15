package gui.windows.primary.controls;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import lombok.Data;

@Data
public class ElementView {
    private static ElementView elementView = new ElementView();
    public static ElementView getInstance() {
        return elementView;
    }

    private VBox viewContainer = new VBox();

    private ElementView() {
        
    }
}

class ElementSummary { 
    private static ElementSummary overview = new ElementSummary();
    public static ElementSummary getInstance() { return overview; }

    private Label title = new Label();
    private ScrollPane topRight = new ScrollPane();
    private ListView<Label> contents = new ListView<>();

    //etc
    
    ElementSummary() {
        
    }
}

class Elaboration {
    private static Elaboration elaboration = new Elaboration();
    public static Elaboration getInstance() { return elaboration; }

    //etc

    Elaboration() {

    }
}