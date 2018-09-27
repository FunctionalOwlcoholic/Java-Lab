
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
      createBinaryRecursiveRectangle(pane, new Random(), 10, 40, 0, 1000);
      stage.setScene(new Scene(pane));
      stage.setTitle("Hello Binary Recursion");
      stage.setResizable(false);
      stage.show();
   }
   
   public static void createBinaryRecursiveRectangle()
   
   private static void createBinaryRecursiveRectangle(Pane pane, Random random, int repeat, int height, int begin, int end)
   {
      Rectangle rectangle = new Rectangle(begin, repeat * height, end - begin, height);
      rectangle.setFill(Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
      pane.getChildren().add(rectangle);
      
      if (--repeat > 0)
      {
         createBinaryRecursiveRectangle(pane, random, repeat, height, begin, (end - begin) / 2 + begin);
         createBinaryRecursiveRectangle(pane, random, repeat, height, (end - begin) / 2 + begin, end);
      }
   }
}
