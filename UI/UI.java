package UI;

import model.Board;

import java.util.Scanner;

/**
 * This class is responsible for taking in user input and starting the game.
 */
public class UI {
    private final Scanner scanner;
    private final boolean cheats;
    private final Board board;
    private final int numEnemies;
    private final BoardPrinter printer;

    public UI(int numOpp, boolean cheat) {
        scanner = new Scanner(System.in);
        cheats = cheat;
        board = new Board(numOpp);
        numEnemies = numOpp;
        printer = new BoardPrinter();
    }

    public String getMoveInput() {
        String pattern = "^[a-jA-J]([1-9]|10)$";
        System.out.print("Enter your move: ");
        String input = scanner.nextLine();

        while (!input.matches(pattern)) {
            System.out.println("Invalid target. Please enter a coordinate such as D10.");
            System.out.print("Enter your move: ");
            input = scanner.nextLine();
        }
        return input;
    }

    public void displayIntro() {
        if (cheats) {
            displayOpenBoard();
        }
        System.out.println("Starting game with " + numEnemies + " forts");
        System.out.println("------------------------");
        System.out.println("Welcome to Fort Defense!");
        System.out.println("------------------------\n");
    }

    public void displayOpenBoard() {
        printer.printOpenBoard(board);
    }

    public void displayFogBoard() {
        printer.printFogBoard(board);
    }

    public void startGame() {
        displayIntro();
        while (!board.gameEnded()) {
            displayFogBoard();
            String move = getMoveInput();
            boolean hitFort = board.hitsTile(move);
            if (hitFort) {
                System.out.println("HIT!");
            } else {
                System.out.println("Miss.");
            }
            printer.printOppShots(board);

            board.nextTurn();
        }
        displayFogBoard();
        if (board.gameWon()) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("I'm sorry, your fort is all wet! They win!");
        }
        // Display the end board result
        displayOpenBoard();
    }
}
