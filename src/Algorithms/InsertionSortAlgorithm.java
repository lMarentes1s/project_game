package Algorithms;
import Game.GameTable;
import Interface.SortingAlgorithm;
import Pieces.Pieces;
import Pieces.PieceUtils;
import java.util.List;


// InsertionSortAlgorithm.java
public class InsertionSortAlgorithm implements SortingAlgorithm {
    @Override
    public void sort(List<Pieces> pieces, GameTable gameTable) {
        System.out.println("\nIniciando ordenamiento con Insertion Sort...");
        PieceUtils.assignRandomPositionsInFirstTwoRows(pieces);
        gameTable.updateBoard();

        for (int i = 1; i < pieces.size(); i++) {
            Pieces keyPiece = pieces.get(i);
            int j = i - 1;
            while (j >= 0 && PieceUtils.distanceToOriginal(pieces.get(j)) > PieceUtils.distanceToOriginal(keyPiece)) {
                pieces.set(j + 1, pieces.get(j));
                j = j - 1;
            }
            pieces.set(j + 1, keyPiece);
            gameTable.updateBoard();
        }

        PieceUtils.movePiecesToOriginalPositions(pieces, gameTable);
        System.out.println("Ordenamiento completado.");
    }
}
