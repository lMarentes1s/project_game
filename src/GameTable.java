import java.util.Random;

public class GameTable {
    private final int[][] TABLE = new int[8][8];


    public void FillTable() {
        Random random = new Random();
        int pieceValue = Integer.parseInt(User.getPiece());
        int piecesPlaced = 0;

        while (piecesPlaced < pieceValue) {
            int i = random.nextInt(8);
            int j = random.nextInt(8);
            if (TABLE[i][j] == 0) {
                TABLE[i][j] = 1;
                piecesPlaced++;
            }
        }
    }


    public void PrintTable() {
        FillTable();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(TABLE[i][j] + " ");
            }
            System.out.println();
        }
    }
}
