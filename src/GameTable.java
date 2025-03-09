import java.util.Collections;
import java.util.List;

public class GameTable {
    protected final String[][] table;
    private final int delay;
    private List<Pieces> pieces;

    public GameTable() {
        this.table = new String[8][8];
        this.delay = User.getTime();
    }

    public void initialize() {
        clearTable();
        this.pieces = Pieces.listOfPieces();

        placePiecesOnBoard();
        printTable();

        // Iniciar el algoritmo de ordenamiento
        SortingAlgorithms.quickSortAndPrintgit(pieces, this);
    }

    private void clearTable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = "."; // Limpiar la tabla (representar celdas vacías)
            }
        }
    }

    private void placePiecesOnBoard() {
        for (Pieces piece : pieces) {
            table[piece.getRow()][piece.getCol()] = piece.getName(); // Colocar piezas en el tablero
        }
    }

    public void updateBoard() {
        clearTable();
        placePiecesOnBoard();
        printTable();
        try {
            Thread.sleep(delay); // Esperar para visualizar los cambios
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

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

    public int getDelay() {
        return delay;
    }
}