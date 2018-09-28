import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class BindingExample extends Application
{
   @Override
   public void start(Stage mainStage)
   {
      // root pane
      GridPane rootPane = new GridPane();
      rootPane.setMinSize(150, 150);
      
      // buttons
      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            Button button = new Button();
            button.setMinSize(50, 50);
            
            // bindings
            button.prefWidthProperty().bind(rootPane.widthProperty());
            button.prefHeightProperty().bind(rootPane.heightProperty());
            
            rootPane.add(button, j, i);
         }
      }
      
      // main scene
      Scene mainScene = new Scene(rootPane);
      
      // main stage
      mainStage.setScene(mainScene);
      mainStage.setTitle("Hello Binding");
      mainStage.show();
   }
}
