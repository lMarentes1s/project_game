package Pieces;

import Game.GameTable;

import java.util.List;

public class PieceUtils {
    public static void assignRandomPositionsInFirstTwoRows(List<Pieces> pieces) {
        boolean[][] occupied = new boolean[2][8];
        for (Pieces piece : pieces) {
            int randomRow;
            int randomCol;
            do {
                randomRow = (int) (Math.random() * 2);
                randomCol = (int) (Math.random() * 8);
            } while (occupied[randomRow][randomCol]);
            occupied[randomRow][randomCol] = true;
            piece.setRow(randomRow);
            piece.setCol(randomCol);
        }
    }

    public static double distanceToOriginal(Pieces piece) {
        int rowDiff = piece.getRow() - piece.getOriginalRow();
        int colDiff = piece.getCol() - piece.getOriginalCol();
        return Math.sqrt(rowDiff * rowDiff + colDiff * colDiff);
    }

    public static void swapPiecesPosition(Pieces piece1, Pieces piece2) {
        int tempRow = piece1.getRow();
        int tempCol = piece1.getCol();
        piece1.setRow(piece2.getRow());
        piece1.setCol(piece2.getCol());
        piece2.setRow(tempRow);
        piece2.setCol(tempCol);
    }

    public static void movePiecesToOriginalPositions(List<Pieces> pieces, GameTable gameTable) {
        for (Pieces piece : pieces) {
            if (piece.getRow() != piece.getOriginalRow() || piece.getCol() != piece.getOriginalCol()) {
                piece.setRow(piece.getOriginalRow());
                piece.setCol(piece.getOriginalCol());
                gameTable.updateBoard();
            }
        }
    }
}
