package Game;
import Pieces.Pieces;
import java.util.List;
import Algorithms.SortingAlgorithms;

/**
 * Class representing the game table.
 */
public class GameTable {
    private final String[][] table;
    private final int delay;
    private List<Pieces> pieces;
    /**
     * Constructor for the GameTable class.
     *
     * @param user The user object containing game settings.
     */
    public GameTable(User user) {
        this.table = new String[8][8];
        this.delay = user.getTime();
    }
    /**
     * Initializes the game table with pieces and starts the sorting process.
     *
     * @param user The user object containing game settings.
     */
    public void initialize(User user) {
        clearTable();
        this.pieces = Pieces.createPiecesList(user);
        placePiecesOnBoard();
        printTable();
        SortingAlgorithms sort = new SortingAlgorithms();
        sort.sortAndPrint(pieces, this, user.getAlgorithm());
    }

    /**
     * Clears the game table.
     */

    private void clearTable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = ".";
            }
        }
    }
    /**
     * Places the pieces on the game table.
     */
    private void placePiecesOnBoard() {
        for (Pieces piece : pieces) {
            table[piece.getRow()][piece.getCol()] = piece.getName();
        }
    }
    /**
     * Updates the game table and prints the current state.
     */
    public void updateBoard() {
        clearTable();
        placePiecesOnBoard();
        printTable();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    /**
     * Prints the current state of the game table.
     */
    public void printTable() {
        System.out.println("  ╔" + "════╦".repeat(7) + "════╗");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d ║", 8 - i);
            for (int j = 0; j < 8; j++) {
                System.out.printf(" %-2s ║", table[i][j]);
            }
            System.out.println();
            if (i < 7) {
                System.out.println("  ╠" + "════╬".repeat(7) + "════╣");
            } else {
                System.out.println("  ╚" + "════╩".repeat(7) + "════╝");
            }
        }
        System.out.println("    A    B    C    D    E    F    G    H");
    }
}