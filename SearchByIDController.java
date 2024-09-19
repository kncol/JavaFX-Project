// Import all needed javafx applications
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
// make the class for the SearchByID controller
public class SearchByIDController implements Initializable {
    // declare all the FXML Labels that have been connected in scene builder
    @FXML private Label ifFoundLabel;
    @FXML private Label detailsLabel;
    // declare all the FXML objects that have been connected in scene builder
    @FXML private TextField myTextField1;
    @FXML private Button submitButton;
    // make the method checking whether the String contains digits only
    public static boolean containsOnlyDigits(String s) {
        // loop throught the string
	for (int i = 0; i < s.length(); i++) {
            // if any of the charactes contain digits, return false
            if (!Character.isDigit(s.charAt(i))) {
		return false;
	}
            }
        // return true, that there are only digits, if false is never returned
	return true;
    }

    // performed when SUBMIT button is clicked
    public void submit1(ActionEvent event) {
        if (containsOnlyDigits(myTextField1.getText()) == true && myTextField1.getText().length() == 7){
            
            // Get the ID entered by the user 
            int tempId = Integer.parseInt(myTextField1.getText());
            // check the temporary variable in the searchByID method 
            searchByID(tempId); 
        }
        // if ID is an invalid ID
        else {
            ifFoundLabel.setText("Invalid entry. Please try again.");
        }
    }
    // create the method that loops through the competitor arraylist and prints whether it was found
    private void searchByID(int tempID){
        // initialize the boolean found variable
        boolean found = false;
        // loop over all the competitors to see if the ID that the user entered matches an already existing ID
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            // create a variable with the competitor at the speicific index
            Competitor competitor = RegisterController.getCompetitorList().get(i);
            // if the User entered ID matches an ID of a competitor at index i
            if (competitor.getID() == tempID) {
                // print the message that the ID was found 
                ifFoundLabel.setText("\nCompetitor was successfully found!\n");
                // print the object and call the toString method to print all the competitor's specs
                detailsLabel.setText(competitor.toString());
                // update the flag indicating that the ID was found
                found = true;
                // break out of the loop after the ID has been successfully found 
                break;
            }
        }
        // if the ID was still not found after looping, it means the ID has not been registered in the system, and print the message
        if (found == false) {
            ifFoundLabel.setText("Competitor ID #" + tempID + " was not found in the system.");
        }
    }
    // Override the initialize method
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        submitButton.setOnAction(this::submit1);
    }
}