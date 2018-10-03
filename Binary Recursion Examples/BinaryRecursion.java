import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Random;

public class BinaryRecursion extends Application
{
   @Override
   public void start(Stage stage)
   {
      Pane pane = new Pane();
      createBinaryRecursiveRectangle(pane, new Random(), 32, 0, 0, 1024);
      stage.setScene(new Scene(pane));
      stage.setTitle("Hello Binary Recursion");
      stage.show();
   }
   
   public static void createBinaryRecursiveRectangle(Pane pane, Random random, int height, int top, int left, int right)
   {
      Rectangle rectangle = new Rectangle(left, top, right - left, height);
      rectangle.setFill(Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
      pane.getChildren().add(rectangle);
      if (right - left > 1)
      {
         createBinaryRecursiveRectangle(pane, random, height, top + height, left, (right - left) / 2 + left);
         createBinaryRecursiveRectangle(pane, random, height, top + height, (right - left) / 2 + left, right);
      }
   }
}
