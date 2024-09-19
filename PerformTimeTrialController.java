// Import all needed javafx applications
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
// create the class for the conroller that implements intitalzable
public class PerformTimeTrialController implements Initializable {
    // declare all the FXML objects that have been connected in scene builder
    @FXML private Label label1;
    @FXML private Label label2;
    @FXML private TextField textField;
    @FXML private Button submit1;
    @FXML private Button submitButton;
    @FXML private ChoiceBox<String> choiceBox;
    // Create the record times with an array
    public static int[] recordTimes = {115, 117, 115, 100};
    // Create the tracks in an array
    private static String[] tracks = {"Sunshine Airport", "Dolphin Shoals", "Electrodrome", "Mount Wario"};
    // Create the time trial performed array with false values
    public static boolean[] timeTrialPerformed = new boolean[4];
    // initialize the setTrack
    String setTrack = "";
    //create seed
    int seed;
    //create getter method
    public static String[] getTracks(){
        return tracks;
    }
    // create another getter method
    public static boolean getTimeTrialPerformed(int trackIdx){
        return timeTrialPerformed[trackIdx];
    }
    // create the getTrack method
    public void getTrack(ActionEvent event) {
        //String track = choiceBox.getValue();
        //label.setText(track);
        setTrack = choiceBox.getValue();
    }
    // create the static method that takes in a string and returns a boolean based on whether it contains only digits
    public static boolean containsOnlyDigits(String s) {
        // loop throught the length of the string
        for (int i = 0; i < s.length(); i++) {
            // return false if any of the characters are not a digit
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        // return true if it does not return false for any of the characters
        return true;
    }
    // make a method for the first button event
    public void submit1(ActionEvent event) {
        // make it a try catch to account for any potential mistakes
        try {
            // get what i sput in the textField
            String tempSeed = textField.getText();
            if (containsOnlyDigits(tempSeed) == true) {
                //set the seed 
                seed = Integer.parseInt(textField.getText());
                // make it know the seed has been submitted
                label1.setText("Submitted");
            }
            // return X if it isnt a possible seed
            else {
                label1.setText("X");
            }
            // catch any exceptions that may go through and set X
        } catch (Exception e) {
            label1.setText("X");
        }
    }
    // create the method that gets the track number
    private int getTrackNumber(String selectedTrack) {
        // loop throught the tracks
        for (int i = 0; i < tracks.length; i++) {
            if (selectedTrack.equals(tracks[i])) {
                return i + 1; // Return the track number (1-based index)
            }
        }
        return -1; // Return -1 if the selected track is not found
    }
    // create the submit for the action event
    public void submitButton(ActionEvent event) {
        // get the set seed
        Random rng = new Random(seed);
        // if not comptitors have been set, set the text that none have been registered
        if (Competitor.getNumCompetitors() == 0) {
            label2.setText("No competitors registered.");
        }
        else {
            try {
                // else make sure the seed and setTrach have been set
                if (seed != 0 && !setTrack.equals("")) {
                    // create variables for the trackNumber and its index
                    int trackNumber = getTrackNumber(setTrack);
                    int trackIndex = trackNumber - 1;
                    // loop through the number of comeptitors
                    for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                        // Create a new Competitor instance
                        Competitor competitor = RegisterController.getCompetitorList().get(i);
                        // Generate a random time for the current track
                        int newTime = recordTimes[trackIndex] + rng.nextInt(30);
                        competitor.setBestTimes(trackIndex, newTime);
                    }
                    // set the text that it has been performed
                    label2.setText("Time trial performed.");
                }
                // else the information was not valid and set as such
                else {
                    label2.setText("Enter valid information.");
                }
            // catch in case an error occured
            } catch (Exception e) {
                label2.setText("Enter valid information.");
            }
        }
    }
    // override the initialize method
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // create the tracks in a dropdown box
        choiceBox.getItems().addAll(tracks);
        choiceBox.setOnAction(this::getTrack);
    }
}