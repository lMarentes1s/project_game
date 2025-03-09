package Algorithms;
import Game.GameTable;
import Pieces.Pieces;
import Pieces.PieceUtils;
import Interface.SortingAlgorithm;

import java.util.List;

// QuickSortAlgorithm.java
public class QuickSortAlgorithm implements SortingAlgorithm {
    @Override
    public void sort(List<Pieces> pieces, GameTable gameTable) {
        System.out.println("\nIniciando ordenamiento con Quick Sort...");
        PieceUtils.assignRandomPositionsInFirstTwoRows(pieces);
        gameTable.updateBoard();
        quickSort(pieces, 0, pieces.size() - 1, gameTable);
        PieceUtils.movePiecesToOriginalPositions(pieces, gameTable);
        System.out.println("Ordenamiento completado.");
    }

    private void quickSort(List<Pieces> pieces, int low, int high, GameTable gameTable) {
        if (low < high) {
            int pi = partition(pieces, low, high, gameTable);
            quickSort(pieces, low, pi - 1, gameTable);
            quickSort(pieces, pi + 1, high, gameTable);
        }
    }

    private int partition(List<Pieces> pieces, int low, int high, GameTable gameTable) {
        Pieces pivot = pieces.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (PieceUtils.distanceToOriginal(pieces.get(j)) < PieceUtils.distanceToOriginal(pivot)) {
                i++;
                PieceUtils.swapPiecesPosition(pieces.get(i), pieces.get(j));
                gameTable.updateBoard();
            }
        }
        PieceUtils.swapPiecesPosition(pieces.get(i + 1), pieces.get(high));
        gameTable.updateBoard();
        return i + 1;
    }
}
