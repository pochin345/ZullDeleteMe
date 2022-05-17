package zuul;

import pchengzuul.PChengGame;
import zuulbetter.ZuulBetterGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is the Main class of Zuul game for Winter 2022.  By running the main
 * method of this class, a player is able to play the zuul-better version of
 * Zuul game from the Objects First with Java by Michael Kölling and David J.
 * Barnes.
 *
 * @author PoChin Cheng
 * @version 12.25.2021
 *
 */

public class ZuulMain {

    private static HashMap<String, Game> games = new HashMap<>();
    private static ArrayList<String> gameChoices = new ArrayList<>();

    /**
     * Displays all Zuul Games.
     */
    private static void displaySelection()
    {
        System.out.println("Welcome to Winter CIS 233J Zuul Collection!");
        int i=0;
        for (String game:gameChoices) {
            System.out.println(i++ + ") " + game);
        }
        System.out.println("Choose one of the above and press enter to play a game scenario created by");
        System.out.println("the textbook authors, your instructor, or your classmates.");
    }

    /**
     * Scans player game choice.  If choice is not valid, the Zuul better is selected
     * @return player's choice
     */
    private static String getChoice() {
        String returnString = "";
        Scanner reader = new Scanner(System.in);
        displaySelection();
        System.out.print("--> ");     // print prompt
        String readString = reader.nextLine();
        if (readString.isEmpty()) {
            returnString = "The Zuul better";
        }
        else {
            try {
                int choice = Integer.parseInt(readString);
                if (choice >= gameChoices.size() || choice < 0) {
                    returnString = "The Zuul better";
                }
                else {
                    returnString = gameChoices.get(choice);
                }
            }
            catch (NumberFormatException e) {
                returnString = "The Zuul better";
            }
        }
        System.out.println(returnString);
        return returnString;
    }

    /**
     * Add different game scenarios to the collection
     */
    private static void addGames() {
        games.put("The Zuul better", new ZuulBetterGame());
        games.put("PoChin's Zuul better with items", new PChengGame());
        // add your game here v
        // add your game here ^

        for (String key:games.keySet()) {
            gameChoices.add(key);
        }
    }

    /**
     * main entry to collection of Zuul games.
     * @param args are ignored
     */
    public static void main(String[] args) {
        addGames();
        String choice = getChoice();
        Game game = games.get(choice);
        game.play();

    }
}
