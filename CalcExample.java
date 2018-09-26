
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.VBox; // i choose these two panes but there are other options available
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.TilePane;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.HBox;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/* this class should be able to run, no main method or additional classes are needed
   since this is just an example for a calculator, it lacks some functionality and error checking
   this was all done in a single method but i don't recommend doing that for your actual program
*/
public class CalcExample extends Application // all javafx programs will start with a class that extends Application
{
   @Override // optionally use the @Override annotation as it provides better compiler error messages when overriding methods
   public void start(Stage mainStage) // this start method from the Application class will replace the main method
   {                                  // or you could have a main method and call launch(args)
      
      // The most basic javafx window requires at least the following components in this hierarchy:
      // Stage -> Scene -> Root Pane -> (optional) Additional Pane(s) -> Buttons/TextFields/etc.
      
      // there must be at least one pane to hold the gui elements, the initial pane is often referred to as the "root" pane
      // the root pane usually contains other panes, althrough it is not required
      // there are several types of panes in javafx, see https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
      
      
      // root pane - this will contain a text field for the calculator screen and another pane for holding the numpad buttons
      VBox rootPane = new VBox(); // we are using a vbox pane because we want to stack 2 elements vertically
      
      
      // screen text field - a text field will act as the screen by displaying the current math expression
      TextField screenTextField = new TextField();
      screenTextField.setPrefSize(200, 50);
      rootPane.getChildren().add(screenTextField); // add the screen text field to the root pane
      
      
      // numpad pane - this sub pane will hold a 4 by 4 grid of buttons
      GridPane numpadGridPane = new GridPane(); // we are using a "grid" pane for convenience
      numpadGridPane.setPrefSize(200, 200);
      rootPane.getChildren().add(numpadGridPane); // add the numpad pane to the root pane
      
      
      String[][] numpadStr = { // 2d array of strings for convenience when creating the buttons
         {"7", "8", "9", "+"},
         {"4", "5", "6", "-"},
         {"1", "2", "3", "*"},
         {".", "0", "=", "/"}
      };
      
      
      // numpad buttons - now we loop through the previous array and create a button for each type
      for (int i = 0; i < 4; i++)
      {
         for (int j = 0; j < 4; j++)
         {
            Button numpadButton = new Button(numpadStr[i][j]);
            numpadButton.setPrefSize(50, 50);
            numpadGridPane.add(numpadButton, j, i); // grid pane coordinates are based on (x, y)
                                                    // so in otherwords (column, row)
                                                    // typically "i" is row, and "j" is columns
                                                    // so remember to order them correctly for this method
            
            
            // button event - each button will have an event that either appends text or solves the math expression
            if (numpadStr[i][j].equals("="))
            {
               // action event for the "equal" button
               numpadButton.setOnAction(new EventHandler<ActionEvent>() {
                  @Override public void handle(ActionEvent e) {
                     // anything inside this method will be executed when the button is pressed
                     
                     // ...here we would put code that solves the current math expression and updates the screen
                     System.out.println("Hello Equal Button");
                     
                     // to access the current text on the screen you can call screenTextField.getText()
                     // to update the text on the screen you can call screenTextField.setText(String)
                     // to convert a string into a double you can call Double.parseDouble(String)
                  }
               });
            }
            else
            {
               String buttonText = numpadStr[i][j]; // we use another string because we can only reference local variables in-
                                                    // the event method body if they are final, and i and j are not final
               
               // action event for the other buttons
               numpadButton.setOnAction(new EventHandler<ActionEvent>() {
                  @Override public void handle(ActionEvent e) {
                     // anything inside this method will be executed when the button is pressed
                     
                     screenTextField.setText(screenTextField.getText() + buttonText); // notice that we use buttonText here
                                                                                      // instead of numpadStr[i][j]
                                                                                      // as explained above
                  }
               });
            }
         }
      }
      
      
      // scene - a scene can only have one pane which is why we refer to the first pane as the "root"
      Scene mainScene = new Scene(rootPane);
      
      
      // stage - the stage is basically our window
      mainStage.setScene(mainScene); // add the scene to the stage
      mainStage.setTitle("Hello Calculator");
      mainStage.show(); // finally you show the window to the user, this should be called after you finish making a usable window
   }   
}
