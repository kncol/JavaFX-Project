public class Competitor {
    // DATA MEMBERS
    private int ID;
    private String firstName;
    private String lastName;
    private String character;
    private String vehicle;
    // create an array called bestTimes of size 4, one for each track
    private int[] bestTimes = new int[4];
    // static variables belong to the class
    private static int numCompetitors = 0;
    // bring in the tracks[] array from Main to use it in the toString method 
    public static String[] tracks = {"Sunshine Airport", "Dolphin Shoals", "Electrodrome", "Mount Wario"};
    // CONSTRUCTORS
    // no argument constructor
    public Competitor() {
    }
    // this constructor takes in ID, firstName, lastName, character, and vehicle
    public Competitor(int ID, String firstName, String lastName, String character, String vehicle) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.vehicle = vehicle;
        // increment numCompetitors once there has been a competitor registered
        numCompetitors++;
        this.bestTimes = new int[4];
    }
    // Getters and Setters
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public static int getNumCompetitors() {
        return numCompetitors;
    }
    // return the best time at a certain track
    // just get the best time
    public int getBestTimes(int track) {
        return bestTimes[track];
    }
    // setting the time that was passed over as a parameter into the bestTimes[] array at the specific track
    // set and save a new bestTime for a particualr track
    public void setBestTimes(int track, int time) {
        bestTimes[track] = time;
    }
    // OTHER METHODS:
    // this takes an int and it turn it into a string with the correct time format
    // we use it for our toString method
    public static String minsAndSecs(int randomTotal) {
        String time;
        // taking the randomTime and calculating how many minutes
        int newMins = randomTotal / 60;
        // saving the minutes as a string
        String mins = "" + newMins;
        // calculating the remainder and getting the seconds
        int newSecs = randomTotal % 60;
        if (newSecs < 10) {
            time = "" + mins + "'" + "0" + newSecs + "\"";
        }
        else {
            time = "" + mins + "'" + newSecs + "\"";
        }
        return time; // return the time in its correct format 
    }
    public String toString() {
        // Create an empty string
        String s = "";
        // Concatonate all the competitor info 
        s += String.format("   %s %s (ID: %d)\n", getFirstName(), getLastName(), getID());
        s += String.format("   Character: %s\n", getCharacter());
        s += String.format("   Vehicle:   %s\n", getVehicle());
        s += ("   ***Best Times***\n");
        // loop over the tracks
        for (int track = 0; track < 4; track++) {
            // save the competitor's best time at that track into the variable individualsBestTime
            int anIndividualsBestTime = getBestTimes(track);
            // if there is no time saved into that track yet, print that there have been to trials yet
            if (getBestTimes(track) == 0) {
                s += String.format("      %-17s %s\n", tracks[track] + ":", "no time recorded");
            }
            else { // else, print the time in the correct format 
                s += String.format("      %-17s %s\n", tracks[track] + ":", minsAndSecs(anIndividualsBestTime));
            }
        } // return the string with all the info 
        return s;
    }
}