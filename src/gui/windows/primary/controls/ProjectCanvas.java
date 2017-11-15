package gui.windows.primary.controls;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import nodes.util.INode;
import nodes.util.RealNode;
import util.MathFunctions;

import static util.MathFunctions.PrimeCheck;

//This class handles the main window the project wherin the various objects are actually rendered. It serves as
//an alternate method of viewing the simple tree; they serve the same purpose and have largely the same functionality.
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


       //Okay so I'm literally retarded and not sure how to do this properly but I guess this works, you can probably
       //optimize it a bit though
       int n = node.getChildren().size();
       int f[] = MathFunctions.Factorize(n);
       int x;
       int x2;
       int y;
       int y2;
       int ix = 1;
       int iy = 1;

       for(RealNode child: node.getChildren()){

           y = ((int)height / (f[0] + 1)) * ix;
           x = ((int)width / (f[1] + 1)) * iy;


           child.draw(gc, x, y);

           System.out.println(ix + " " + iy);
           if (ix == f[0]){
               iy++;
               ix = 0;
           }
           ix++;
       }
   }

}
