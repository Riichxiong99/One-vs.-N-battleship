import UI.UI;

/**
 * The start of Assignment 3: Blanket Fort Water Fight
 * The program runs from main and takes in command line arguments to specify the number of forts and whether cheats enabled or not.
 */
public class Main {
    public static void main(String[] args) {
        int numberOfOpponents = 5;
        boolean cheats = false;

        if (args.length >= 1) {
            numberOfOpponents = Integer.parseInt(args[0]);
            if (args.length == 2) {
                cheats = true;
            }
        }

        UI textUI = new UI(numberOfOpponents, cheats);
        textUI.startGame();
    }
}
