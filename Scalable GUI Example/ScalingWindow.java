import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class ScalingWindow extends Application
{
   @Override
   public void start(Stage mainStage)
   {
      // root pane
      GridPane rootPane = new GridPane();
      
      // buttons
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            Button button = new Button();
            
            // binding properties
            button.prefWidthProperty().bind(rootPane.widthProperty().divide(3));
            button.prefHeightProperty().bind(rootPane.heightProperty().divide(3));
            
            rootPane.add(button, j, i);
         }
      }
      
      // main scene
      Scene mainScene = new Scene(rootPane);
      
      // main stage
      mainStage.setScene(mainScene);
      mainStage.setMinWidth(300);
      mainStage.setMinHeight(300);
      mainStage.setTitle("Hello Binding");
      mainStage.show();
   }
}
