package Algorithms;
import Game.GameTable;
import Interface.SortingAlgorithm;
import Pieces.Pieces;
import Pieces.PieceUtils;

import java.util.List;

// SelectionSortAlgorithm.java
public class SelectionSortAlgorithm implements SortingAlgorithm {
    @Override
    public void sort(List<Pieces> pieces, GameTable gameTable) {
        System.out.println("\nIniciando ordenamiento con Selection Sort...");
        PieceUtils.assignRandomPositionsInFirstTwoRows(pieces);
        gameTable.updateBoard();

        for (int i = 0; i < pieces.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < pieces.size(); j++) {
                if (PieceUtils.distanceToOriginal(pieces.get(j)) < PieceUtils.distanceToOriginal(pieces.get(minIndex))) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                PieceUtils.swapPiecesPosition(pieces.get(i), pieces.get(minIndex));
                gameTable.updateBoard();
            }
        }

        PieceUtils.movePiecesToOriginalPositions(pieces, gameTable);
        System.out.println("Ordenamiento completado.");
    }
}
