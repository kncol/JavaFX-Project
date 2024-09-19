// Import all needed javafx applications
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
// Create the main class and extend application for JavaFX
public class Main extends Application {
    // Initialize all the stages being made
    private static Stage DisplayStage = null;
    private static Stage PerformTimeTrialStage = null;
    private static Stage SearchByIDStage = null;
    private static Stage RegisterStage = null;
    // Create the main method that will launch the program
    public static void main(String[] args){
        launch(args);
    }
    // make a method that will start/  launch the program
    @Override
    public void start(Stage primaryStage) throws IOException{
        // Make the parent root where you load the main menu
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        // Create the scene of the main menu
        Scene scene = new Scene(root);
        // call primary stage and make sure it shows
        primaryStage.setScene(scene);
        primaryStage.show();
        // call the register Stage that will be initialized
        createRegisterStage();
        // call the display Stage that will be initialized
        createDisplayStage();
        // call the ID Stage that will be initialized
        createSearchByIDStage();
        // call the time trial Stage that will be initialized
        createPerformTimeTrialStage();
    }
   // Create the reister stage
    public void createRegisterStage(){
        // create the stage and set its details
        RegisterStage = new Stage();
        RegisterStage.setTitle("Info Pop-Up");
        RegisterStage.setAlwaysOnTop(true);
        RegisterStage.setResizable(false);
        RegisterStage.initModality(Modality.APPLICATION_MODAL);
    }
    // Create the getter for the stage
    public static Stage getRegisterStage(){ 
        // return the stage
        return RegisterStage;
    }        
    // Create the reister stage
    public void createDisplayStage(){
        // create the stage and set its details
        DisplayStage = new Stage();
        DisplayStage.setTitle("Display Pop-Up");
        DisplayStage.setAlwaysOnTop(true);
        DisplayStage.setResizable(false);
        DisplayStage.initModality(Modality.APPLICATION_MODAL);
    }
    // Create the getter for the stage
    public static Stage getDisplayStage(){ 
        return DisplayStage;
    } 
    // Create the reister stage
    public void createSearchByIDStage(){
        // create the stage and set its details
        SearchByIDStage = new Stage();
        SearchByIDStage.setTitle("SearchByID Pop-Up");
        SearchByIDStage.setAlwaysOnTop(false);
        SearchByIDStage.setResizable(false);
        SearchByIDStage.initModality(Modality.APPLICATION_MODAL);
    }
    // Create the getter for the stage
    public static Stage getSearchByIDStage(){ 
        return SearchByIDStage;
    } 
    // Create the reister stage
    public void createPerformTimeTrialStage(){
        // create the stage and set its details
        PerformTimeTrialStage = new Stage();
        PerformTimeTrialStage.setTitle("Perform Time Trial Pop-Up");
        PerformTimeTrialStage.setAlwaysOnTop(false);
        PerformTimeTrialStage.setResizable(false);
        PerformTimeTrialStage.initModality(Modality.APPLICATION_MODAL);
    }
    // Create the getter for the stage
    public static Stage getPerformTimeTrialStage(){ 
        return PerformTimeTrialStage;
    } 
}