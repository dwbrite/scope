package gui.controls.labels;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ProjectLabel extends Control{
    Label name, directory;
    VBox layout;

    public ProjectLabel(Label name, Label directory) {
        this.getStyleClass().add("project-label");
        this.name = name;
        this.directory = directory;

        //name.getStyleClass().add()
    }
}
