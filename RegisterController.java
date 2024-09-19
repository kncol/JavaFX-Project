// Import all needed javafx applications
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
// create the public class for teh register controller and implement initializable
public class RegisterController implements Initializable {
    // declare all the FXML Labels that have been connected in scene builder
    @FXML private Label myLabel1;
    @FXML private Label myLabel2;
    @FXML private Label myLabel3;
    @FXML private Label myLabel4;
    // declare all the FXML TextFields that have been connected in scene builder
    @FXML private TextField myTextField1;
    @FXML private TextField myTextField2;
    @FXML private TextField myTextField3;    
    // declare all the FXML Buttons that have been connected in scene builder
    @FXML private Button myButton1;
    @FXML private Button myButton2;
    @FXML private Button myButton3;
    @FXML private Button myButton4;
    // declare all the FXML ChoiceBoxes that have been connected in scene builder
    @FXML private ChoiceBox<String> myChoiceBox1;
    @FXML private ChoiceBox<String> myChoiceBox2;
    // create the string array of vehicles
    private String[] vehicles = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser",
        "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "BiddyBuggy", "Landship", "Sneeker", "Sports Coupe",
        "Gold Standard","Standard Bike", "Comet", "Sports Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty",
        "Jet Bike", "Yoshi Bike","Standard ATV", "Wild Wiggler", "Teddy Buggy"};
    // create the string array of characters
    private String[] characters = {"Mario", "Luigi", "Peach", "Yoshi", "Bowser", "Donkey Kong", "Toad", "Koopa Troopa", "Daisy", "Shy Guy",
         "Wario", "Waluigi", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy"};
    // Changed this to private static
    private static ArrayList<Competitor> competitorList = new ArrayList<>();
    // Initialize all the variables
    int setId = 0;
    String setFirstName = "";
    String setLastName = "";
    String setVehicle = "";
    String setCharacter = "";
    // make the getter method that can send the arraylist to other methods
    public static ArrayList<Competitor> getCompetitorList(){
        return competitorList;
    }
    // make the vehicle getter method
    public void getVehicle(ActionEvent event){
        setVehicle = myChoiceBox1.getValue(); 
    }
    // make the character getter method
    public void getCharacter(ActionEvent event){
        setCharacter = myChoiceBox2.getValue();
    }
    // make the method checking whether the String contains digits only
    public static boolean containsOnlyDigits(String s) {
        // loop throught the string length
	for (int i = 0; i < s.length(); i++) {
            // if any of the charactes contain digits, return false
            if (!Character.isDigit(s.charAt(i))) {
		return false;
	}
            }
        // return true, that there are only digits, if false is never returned
	return true;
    }
// Creates a method that checks if the string only has the correct characters
    public static boolean containsOnlyNameChars(String s) {
        // initialize the char
		char c;
                // loop throught the String
		for (int i = 0; i < s.length(); i++) {
                    c = s.charAt(i);
                        // if the character at the specific index isnt a name character, return false
                        if (!(Character.isLetter(c) || c == ' ' || c == '-')) {
                            return false;
                    }
		}
                // return true, that there are only characters, if false is never returned
		return true;
	}
    // create the button one's submit event
    public void submit1(ActionEvent event) {
        // make it a try/ catch in case their are any errors
        try{
            // create a temporary variable based on the user's typed in info
            String tempId = myTextField1.getText();
            // check if the input matches the requirements
            if (tempId.length() == 7 && containsOnlyDigits(tempId) == true){
                // parse the temporoary variable into a Integer if all requirements are met
                setId = Integer.parseInt(myTextField1.getText());
                // set the text to submitted
                myLabel1.setText("Submitted");
            }
            // if the requirements aren't met, set the text to X
            else{
                myLabel1.setText("X");
            }
        }
        // make the text X if an error occurred
        catch(Exception e){
            myLabel1.setText("X");
        }
    }
    // make the button two's submit event
    public void submit2(ActionEvent event) {
        // make it a try/ catch in case their are any errors
        try{
            // create a temporary variable based on the user's typed in info
            String tempFirstName = myTextField2.getText();
            // check if the input matches the requirements
            if (tempFirstName.length() > 1 && tempFirstName.length() < 21 && containsOnlyNameChars(tempFirstName)) {
                // set the first name to the temporary variable if all requirement are met
                setFirstName = tempFirstName;
                // set the text to submitted
                myLabel2.setText("Submitted");
            }
            else{
                // if the requirements aren't met, set the text to X
                myLabel2.setText("X");
            }
        }
        // make the text X if an error occurred
        catch(Exception e){
            myLabel2.setText("X");
        }
    }
    // make the button three's submit event
    public void submit3(ActionEvent event) {
        // make it a try/ catch in case their are any errors
        try{
            // create a temporary variable based on the user's typed in info
            String tempLastName = myTextField3.getText();
            // check if the input matches the requirements
            if (tempLastName.length() > 1 && tempLastName.length() < 21 && containsOnlyNameChars(tempLastName)) {
                // set the last name to the temporary variable if all requirement are met
                setLastName = tempLastName;
                // set the text to submitted
                myLabel3.setText("Submitted");
            }
            // if the requirements aren't met, set the text to X
            else{
                myLabel3.setText("X");
            }
        }
        // make the text X if an error occurred
        catch(Exception e){
            myLabel3.setText("X");
        }
    }    
    // make the button four's action event
    public void submit4(ActionEvent event){
        // make it a try/ catch in case their are any errors
        try{
            // check if all the variables have been set
            if (setId != 0 && !setFirstName.equals("") && !setLastName.equals("") && !setVehicle.equals("") && !setCharacter.equals("")){
                // create a new competitor if all the variables have been set
                competitorList.add(new Competitor(setId,setFirstName,setLastName, setCharacter,setVehicle));
                // set the text to registered
                myLabel4.setText("Registered");
                // reset all the other texts
                myLabel1.setText("");
                myLabel2.setText("");
                myLabel3.setText("");
                setId = 0;
                // make all the variables reset
                setFirstName = setLastName = setCharacter = setVehicle = "";
                myTextField1.setText("");
                myTextField2.setText("");
                myTextField3.setText("");   
            }
            // if the variables weren't set, set the text to not registered
            else{
                myLabel4.setText("Not Registered");
            }
        }
        // make the text not registered if an error occurred
        catch (Exception e){
            myLabel4.setText("Not Registered");
        }
    }
    // Override the intitialize method
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // make a choice boxes for vehicles
        myChoiceBox1.getItems().addAll(vehicles);
        myChoiceBox1.setOnAction(this::getVehicle);
        // make a choice box for vehicles
        myChoiceBox2.getItems().addAll(characters);
        myChoiceBox2.setOnAction(this::getCharacter);
    }    
}