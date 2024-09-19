// Import all needed javafx applications
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
// create the class for the main controller
public class FXMLDocumentController{
    // declare the FXML object that have been connected in scene builder
    @FXML private Label label;
    // create the method that opens the reisgter stage
    public void openRegisterStage(){
        // make try incase of any random errors
        try{
            // create the loader that will create the register and connect it to its fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
            Parent root = loader.load();
            // get the scene
            Main.getRegisterStage().setScene(new Scene(root));
            // load the controller
            RegisterController registerController = loader.getController();
            // get the created stage from main and show it
            Main.getRegisterStage().show();
        }
        // Catch any potenital errors
        catch (IOException ex){
            System.out.println(ex);
        }
    }    
    // create the method that opens the SearchByID stage
    public void openSearchByIDStage(){
        // make try incase of any random errors
        try{
            // create the loader that will create the SearchByID and connect it to its fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchByID.fxml"));
            Parent root = loader.load();
            // get the scene
            Main.getSearchByIDStage().setScene(new Scene(root));
            // load the controller
            SearchByIDController searchByIDController = loader.getController();
            // get the created stage from main and show it
            Main.getSearchByIDStage().show();
        }
        // Catch any potenital errors
        catch (IOException ex){
            System.out.println(ex);
        }
    }     
    // create the method that opens the Display stage
    public void openDisplayStage(){
        // make try incase of any random errors
        try{
            // create the loader that will create the display and connect it to its fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Display.fxml"));
            Parent root = loader.load();
            // get the scene
            Main.getDisplayStage().setScene(new Scene(root));
            // load the controller
            DisplayController displayController = loader.getController();
            // get the created stage from main and show it
            Main.getDisplayStage().show(); 
        }
        // Catch any potenital errors
        catch (IOException ex){
            System.out.println(ex);
        }
    }
    // create the method that opens the PerformTimeTrial stage
    public void openPerformTimeTrialStage(){
        // make try incase of any random errors
        try{
            // create the loader that will create the PerformTimeTrial and connect it to its fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PerformTimeTrial.fxml"));
            Parent root = loader.load();
            // get the scene
            Main.getPerformTimeTrialStage().setScene(new Scene(root));
            // load the controller
            PerformTimeTrialController performTimeTrialController = loader.getController();
            // get the created stage from main and show it
            Main.getPerformTimeTrialStage().show();
        }
        // Catch any potenital errors
        catch (IOException ex){
            System.out.println(ex);
        }
    }     
    // Create the onMouseClick mouse event to do actions whenever the mouse is clicked
    public void onMouseClick(MouseEvent mouseEvent){
        // create the buttons that will be clicked on by the mouse
        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();
            // if the button is clicked, open the corresponding stage
            if (buttonText.equals("Register a new competitor")){
                openRegisterStage();
            }
            // if the button is clicked, open the corresponding stage
            else if (buttonText.equals("Search for a competitor by ID number")){
                openSearchByIDStage();
            }
            // if the button is clicked, open the corresponding stage
            else if (buttonText.equals("Perform Time Trial")){
                openPerformTimeTrialStage();
            }
            // if the button is clicked, open the corresponding stage
            else if (buttonText.equals("Display Leaderboard")){
                openDisplayStage();
            }
        }
    }