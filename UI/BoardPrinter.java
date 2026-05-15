package UI;

import model.*;

import java.util.List;

/**
 * BoardPrinter class takes in a Board and prints the game board out onto the screen.
 * It can print a normal board or a board with fog
 */
public class BoardPrinter {
    public void printOpenBoard(Board board) {
        boardHeader(board);
        char rowLabel = 'A';
        for (List<Cell> row : board.getBoard()) {
            System.out.printf("%3c", rowLabel);
            for (Cell cell : row) {
                if (cell.getContent() == ' ') {
                    System.out.printf("%3c", '.');
                } else {
                    System.out.printf("%3c", cell.getContent());
                }
            }
            System.out.println();
            rowLabel++;
        }

        System.out.println("Opponents points: " + board.getCurrentScore() + " / 2500.");
        System.out.println("(Lower case fort letters are where you shot.)\n");
    }

    public void printFogBoard(Board board) {
        boardHeader(board);
        char rowLabel = 'A';
        for (List<Cell> row : board.getBoard()) {
            System.out.printf("%3c", rowLabel);
            for (Cell cell : row) {
                printCellState(cell);
            }
            System.out.println();
            rowLabel++;
        }

        System.out.println("Opponents points: " + board.getCurrentScore() + " / 2500.");
    }

    public void printOppShots(Board board) {
        int opponentIdx = 1;
        for (List<int[]> fort : board.oppList()) {
            int pointsWorth = board.getScoreTable()[fort.size()];
            if (!fort.isEmpty()) {
                System.out.printf("Opponent #%s of %s shot you for %s points!\n",
                        opponentIdx, board.oppList().size(), pointsWorth);
            }
            opponentIdx++;
        }
    }

    private void boardHeader(Board board) {
        System.out.println("\nGame Board:");
        System.out.print("   ");
        for (int col = 1; col <= board.boardSize(); col++) {
            System.out.printf("%3d", col);
        }
        System.out.println();
    }

    private void printCellState(Cell cell) {
        if (cell.isHit()) {
            if (cell.getContent() == ' ') {
                System.out.printf("%3c", ' ');
            } else {
                System.out.printf("%3c", 'X');
            }
        } else {
            System.out.printf("%3c", '~');
        }
    }
}
