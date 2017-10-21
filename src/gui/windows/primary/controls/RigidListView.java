package gui.windows.primary.controls;

import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lombok.Getter;
import nodes.Field;
import nodes.Function;

import java.util.Comparator;

import static javafx.css.PseudoClass.*;

public class RigidListView extends ScrollPane {

    VBox list = new VBox();

    public RigidListView() {
        getStyleClass().add("rigid-list-container");
        list.getStyleClass().add("rigid-list-view");
        setContent(list);
        widthProperty().addListener(evt -> resize());
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
    }

    public void resize() {
        double width = this.getWidth();
        for (Node item: list.getChildren()) {
            if(item instanceof Label) {
                Label lbl = (Label)item;
                lbl.setPrefWidth(width);
            }
        }
    }

    private void updateStyleClasses() {
        for (Node item: list.getChildren()) {
            String cellClass = (item instanceof Field || item instanceof Function)?"rigid-list-cell":
                    (item instanceof Separator)?"rigid-list-separator":"rigid-list-bad";
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        if (item instanceof Field || item instanceof Function) {
                            for (Node child : list.getChildren()) {
                                child.pseudoClassStateChanged(getPseudoClass("selected"), false);
                            }
                            item.pseudoClassStateChanged(getPseudoClass("selected"), true);
                        }

                        if (mouseEvent.getClickCount() == 2) {
                            //TODO: Edit item
                        }
                    }
                }
            });
            item.getStyleClass().add(cellClass);
        }
    }

    public void sort() {
        Comparator<Node> cmp = new Comparator<Node>() {
            @Override
            public int compare(Node child, Node next) {
                return Integer.compare(getValue(child), getValue(next));
            }

            private int getValue(Node node) {
                if(node instanceof Field) { return 0; }
                else if (node instanceof Separator) { return 1; }
                else if (node instanceof Function) { return 2; }
                //TODO: prevent improper data entry
                else { return 3; }
            }
        };
        list.getChildren().sort(cmp);
    }


    // TODO: Decide whether or not this is a bad design pattern; having two ways to do the same thing.
    public void addChildren(Node... n) {
        for(Node node:n) {
            if(node instanceof Field || node instanceof Separator || node instanceof Function) {
                list.getChildren().add(node);
            } else {
                //TODO: error handling
                System.out.println("Please don't do that :/");
            }
        }
        sort();
        updateStyleClasses();
    }
}
