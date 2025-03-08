import java.util.Random;

public class GameTable {
    private final String[][] TABLE = new String[8][8];
    private int delay;

    public GameTable(int delay) {
        this.delay = delay;
    }

    public void fillTable() {
        Random random = new Random();
        String[] pieces = Pieces.listOfNumbers();
        int piecesPlaced = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                TABLE[i][j] = ".";
            }
        }

        while (piecesPlaced < pieces.length) {
            int i = random.nextInt(8);
            int j = random.nextInt(8);
            if (TABLE[i][j].equals(".")) {
                TABLE[i][j] = pieces[piecesPlaced];
                piecesPlaced++;
            }
        }
    }

    public void sort(String algorithm) {
        for (int i = 0; i < TABLE.length; i++) {
            switch (algorithm) {
                case "b":
                    SortingAlgorithms.bubbleSort(TABLE[i], delay, this);
                    break;
                case "m":
                    SortingAlgorithms.mergeSort(TABLE[i], delay, this);
                    break;
                case "i":
                    SortingAlgorithms.insertionSort(TABLE[i], delay, this);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid algorithm");
            }
        }
    }

    public void printTable() {
        System.out.println("  ╔" + "════╦".repeat(7) + "════╗");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d ║", 8 - i);
            for (int j = 0; j < 8; j++) {
                System.out.printf(" %-2s ║", TABLE[i][j]);
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