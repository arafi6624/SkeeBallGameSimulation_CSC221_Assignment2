import java.util.Random;
import java.util.Scanner;

/**
 * The SkeeBallSimulation class simulates the classic arcade game of Skee Ball. The main method takes in
 * an integer input from the user and runs the game for that amount of plays. The results for the score
 * after each play and the total score is displayed.
 *
 * @author Abdul Rafi
 * @version 1.0
 */
public class SkeeBallSimulation {
    /**
     * Stores the maximum number of plays allowed per game.
     */
    private static final int MAX_PLAYS = 10; // MAX_PLAYS is initialized to 10

    /**
     * Uses the Random class and preset probability to simulate the ball landing in one of the six holes.
     * @return The hole number in which the ball landed.
     */
    public int holeNumber(){
        Random rand = new Random(); // Initializes a new Random class object.
        int randNum = rand.nextInt(1,101); // A random number between 1 and 100 inclusive is generated using the nextInt method of the rand object.
        if (randNum <= 30){
            return 0; // If randNum is less than 30, which has a probability of 30%, then hole number 0 is returned.
        }else if (randNum > 30 && randNum <= 50){
            return 1; // If randNum is between 30 and 50, which has a probability of 20%, then hole number 1 is returned.
        }else if (randNum > 50 && randNum <= 70){
            return 2; // If randNum is between 50 and 70, which has a probability of 20%, then hole number 2 is returned.
        }else if (randNum > 70 && randNum <= 88){
            return 3; // If randNum is between 70 and 88, which has a probability of 18%, then hole number 3 is returned.
        }else if (randNum > 88 && randNum <= 97){
            return 4; // If randNum is between 88 and 97, which has a probability of 9%, then hole number 4 is returned.
        }else{
            return 5; // If randNum is between 97 and 100, which has a probability of 3%, then hole number 5 is returned.
        }
    }

    /**
     * Take the holeNumber and returns the points associated with landing in that hole.
     * @return Returns the points scored per play for landing in a particular hole.
     */
    public int hallValue(){
        int holeNum = holeNumber(); // A hole number for the play is generated using the holeNumber method.
        int hallVal = -1; // The hall value is initialized to -1.
        switch (holeNum){
            case 0: // If the hole number is 0, then hallVal is set to 0.
                hallVal = 0;
                break;
            case 1: // If the hole number is 1, then hallVal is set to 10.
                hallVal = 10;
                break;
            case 2: // If the hole number is 2, then hallVal is set to 20.
                hallVal = 20;
                break;
            case 3: // If the hole number is 3, then hallVal is set to 40.
                hallVal = 40;
                break;
            case 4: // If the hole number is 4, then hallVal is set to 60.
                hallVal = 60;
                break;
            case 5: // If the hole number is 5, then hallVal is set to 80.
                hallVal = 80;
                break;
        }
        return hallVal; // The hall value hallVal is returned.
    }

    /**
     * Simulates the game for numPlays times and prints the points scored for each play.
     * @param numPlays int parameter for the number of plays.
     * @return Returns the int[] hallValues which stores all the points scored for every play.
     */
    public int[] simulatePlay(int numPlays){
        int []hallValues = new int[numPlays]; // A new int[] hallValues is initialized with the number of plays numPlays as the array capacity.
        for (int i = 0; i < numPlays; ++i){ // Simulates the game numPlays number of times.
            int hallVal = hallValue(); // A new hall value hallVal is generated for the current play.
            hallValues[i] = hallVal; // The hall value is stored in the hallValues[] at the current play index.
            System.out.printf("Rolling ball #%d. Landed in %d%n",i+1,hallVal); // The play number and the hall value is printed.
        }
        return hallValues; // The hall values are returned.
    }

    /**
     * Prints the results of the game, play by play, in a table with two columns: Play # and Score.
     * @param hallValues int[] parameter which stores the points scored for each play.
     */
    public void displayResults(int []hallValues){
        System.out.println(); // Creates a space between the user input prompt and the displayed results.
        int total = 0; // The total score is set to 0.
        System.out.println("+----------+----------+");
        System.out.println("|  Play #  |   Score  |");
        System.out.println("+----------+----------+");
        for (int i = 0; i < hallValues.length; ++i){ // The for loop is run for each index of hallValues which correspond with the play number.
            System.out.printf("%6d     ",i+1); // The play number is printed.
            System.out.printf("%7d%n", hallValues[i]); // The score for that play is printed.
            total += hallValues[i]; // The score for the current play is added to the total score.
        }
        System.out.println("+----------+----------+");
        System.out.printf("Total: %d", total); // The total score is printed.
    }

    /**
     * The main method that executes when the class is compiled. It takes in user input, sets it to the number
     * of plays, and simulates the Skee Ball game using the SkeeBallSimulation class and its methods.
     * @param args Any command-line arguments passed in when the class is run.
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // A Scanner class object is created to take in user input from the command line.

        System.out.print("Enter the number of plays (1-10): "); // Prints the prompt for the user to enter the number of plays for the game.
        int numPlays = keyboard.nextInt(); // Sets numPlays equal to the user input.

        while (numPlays < 0 || numPlays > MAX_PLAYS){ // The user is prompted repeatedly for another input if numPlays is less than 0 or greater than 10.
            System.out.println("Invalid input. Please enter a number between 1 and 10."); // Prints the invalid input prompt.
            System.out.print("Enter the number of plays (1-10): "); // Prints the prompt for the user to enter the number of plays for the game.
            numPlays = keyboard.nextInt(); // Sets numPlays equal to the user input.
        }
        keyboard.close(); // The Scanner object keyboard is closed.

        System.out.println(); // Creates an empty space between the user prompts and the simulated game displays.

        SkeeBallSimulation skeeBall = new SkeeBallSimulation(); // A new SkeeBallSimulation class object is created.

        int[] hallValues = skeeBall.simulatePlay(numPlays); // numPlays is passed into the simulatePlay method of skeeBall and the output is set to the hallValues[].

        skeeBall.displayResults(hallValues); // hallValues is passed into the displayResults method of skeeBall.
    }
}
