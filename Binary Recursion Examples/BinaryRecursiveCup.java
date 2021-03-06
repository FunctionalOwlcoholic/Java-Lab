import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class BinaryRecursiveCup extends Application
{
   @Override
   public void start(Stage stage)
   {
      Pane pane = new Pane();
      ImagePattern image = new ImagePattern(new Image("https://i.imgur.com/onXsNMJ.jpg"));
      createBinaryRecursiveRectangle(pane, image, 32, 0, 0, 1024);
      stage.setScene(new Scene(pane));
      stage.setTitle("Hello Binary Recursion");
      stage.show();
   }
   
   public static void createBinaryRecursiveRectangle(Pane pane, ImagePattern image, int height, int top, int left, int right)
   {
      Rectangle rectangle = new Rectangle(left, top, right - left, height);
      rectangle.setFill(image);
      pane.getChildren().add(rectangle);
      if (right - left > 1)
      {
         createBinaryRecursiveRectangle(pane, image, height, top + height, left, (right - left) / 2 + left);
         createBinaryRecursiveRectangle(pane, image, height, top + height, (right - left) / 2 + left, right);
      }
   }
}
