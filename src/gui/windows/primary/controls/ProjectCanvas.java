package gui.windows.primary.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import nodes.util.INode;
import nodes.util.RealNode;

//This class handles the main window the project wherin the various objects are actually rendered. It serves as
//an alternate method of viewing the simple tree; they serve the same purpose and have largely the same functionality.
public class ProjectCanvas extends FlowPane {
   private static ProjectCanvas ourInstance = new ProjectCanvas();
   public static ProjectCanvas getInstance(){ return ourInstance; }

   private INode node;

   private ProjectCanvas() {
       node = ProjectTree.getInstance().getRootNode();

       widthProperty().addListener(evt -> draw());
       heightProperty().addListener(evt -> draw());

       setId("center-pane");
       setVgap(32);
       setHgap(32);
       setPadding(new Insets(16));
       setAlignment(Pos.CENTER);
   }

   private void draw() {
       double width = getWidth();
       double height = getHeight();
   }

   public void setNode(RealNode e) {
       //add children, basically
       getChildren().clear();
       for (RealNode child : e.getChildren()) {
           getChildren().add(child.getPane());
       }
   }
}
