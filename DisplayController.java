
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class DisplayController implements Initializable {

    @FXML
    private TextArea myTextArea;

    public String displayLeaderBoard(ArrayList<Competitor> competitorsList) {
        String s = "\nLeaderboard:\n";

        // loop over all 4 tracks 
        for (int i = 0; i < PerformTimeTrialController.getTracks().length; i++) {
            // initialize variables to ensure the best time and the location of the best time are found 
            int bestTime = Integer.MAX_VALUE;
            int indexOfBestTime = -1; 

            // loop over the num of competitors 
            for (int user = 0; user < competitorsList.size(); user++) {
                // get the best time of the user 
                int time = competitorsList.get(user).getBestTimes(i);
                // if the there has been a time trial performed and if if better than the previous time, save it into best time and save the user into indexOfBestTime
                if (time != 0 && time < bestTime) {
                    bestTime = time;
                    indexOfBestTime = user;
                }
            }

            // print the name of the track
            s += String.format("\n   %s:\n", PerformTimeTrialController.getTracks()[i]);

            // if there has been a trial performed 
            if (indexOfBestTime != -1) {
                // save whoever has the best time for that track into the variable bestCompetitor
                Competitor bestCompetitor = competitorsList.get(indexOfBestTime);
                // print their details
                s += String.format("      %s %s (ID: %d)\n", bestCompetitor.getFirstName(), bestCompetitor.getLastName(), bestCompetitor.getID());
                s += String.format("      %-10s %s\n", "Character:", bestCompetitor.getCharacter());
                s += String.format("      %-10s %s\n", "Vehicle:", bestCompetitor.getVehicle());
                s += String.format("      %-10s %s\n", "Time:", minsAndSecs(bestTime));
            }
            else { // if there has been no trial performed 
                s += "      No time trials recorded\n";
            }
        }

        return s;
    }

    // this takes an int, randomTotal, and turn it into a string with the correct time format 
    public static String minsAndSecs(int randomTotal) {
        String time;
        // divide the randomTotal by 60 to get the minutes 
        int newMins = randomTotal / 60;
        // save the minutes as a string
        String mins = "" + newMins;
        // get the remainder to find the leftover seconds
        int newSecs = randomTotal % 60;
        if (newSecs < 10) { // if the seconds are less than 10, than you have to add a zero in front to take up the two digit space, so create a string in the correct time format 
            time = "" + mins + "'" + "0" + newSecs + "\"";
        }
        else { // if the seconds remainder is larger than 10, it already takes up two digits, so create a string in the correct time format 
            time = "" + mins + "'" + newSecs + "\"";
        }
        return time;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Competitor> competitorsList = RegisterController.getCompetitorList();
        String textToDisplay = displayLeaderBoard(competitorsList);
        myTextArea.setText(textToDisplay);
    }
}