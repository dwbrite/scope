package gui.windows.primary.controls;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import nodes.util.INode;
import nodes.util.RealNode;

public class ProjectCanvas extends Pane {
   private static ProjectCanvas ourInstance = new ProjectCanvas();
   public static ProjectCanvas getInstance(){ return ourInstance; }

   Canvas canvas = new Canvas();
   INode node;

   private ProjectCanvas() {
       node = ProjectTree.getInstance().getRootNode();
       widthProperty().addListener(evt -> draw());
       heightProperty().addListener(evt -> draw());
       getChildren().add(canvas);

   }

   private void draw() {
       double width = getWidth();
       double height = getHeight();

       canvas.setWidth(width);
       canvas.setHeight(height);

       GraphicsContext gc = canvas.getGraphicsContext2D();
       gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
       gc.setFill(Color.color(0.1686,0.1686,0.1686));
       gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

       int n = node.getChildren().size();
       for(RealNode child: node.getChildren()){


           child.draw(gc, 86, 47);
       }
   }

}
