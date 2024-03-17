import java.util.*;
import java.io.*;

/**
 * The main class for a dice game that reads game data from a file and outputs the results to another file.
 */
public class DiceGame {
    /**
     * The main method to run the dice game. It reads the players and their dice rolls from an input file
     * and directs the game output to another file.
     *
     * @param args Command line arguments, expects two filenames: the first for input and the second for output.
     * @throws IOException If reading from the input file or writing to the output file fails.
     */
    public static void main(String[] args) throws IOException {   
        PrintStream originalOut = System.out; // Store the original System.out to restore it later
        
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        reader.readLine();
        String line = reader.readLine();
        String[] players = line.split(",");
        GameManager gameManager = new GameManager(Arrays.asList(players));

        // Redirect System.out to write to the file specified as the second argument
        PrintStream fileOut = new PrintStream(new File(args[1]));
        System.setOut(fileOut);

        while ((line = reader.readLine()) != null) {
            String[] dices = line.split("-");            
            int dice1 = Integer.parseInt(dices[0]);
            int dice2 = Integer.parseInt(dices[1]);
            gameManager.playTurn(dice1, dice2);
        }
        reader.close();

        System.out.close();
        System.setOut(originalOut); // Restore the original System.out
    }
}
