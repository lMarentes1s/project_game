package Algorithms;
import Game.GameTable;
import Interface.SortingAlgorithm;
import Pieces.Pieces;
import java.util.List;

// SortingAlgorithms.java
public class SortingAlgorithms {
    public static void sortAndPrint(List<Pieces> pieces, GameTable gameTable, String algorithm) {
        switch (algorithm) {
            case "q":
                SortingAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
                quickSortAlgorithm.sort(pieces, gameTable);
                break;
            case "s":
                SortingAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();
                selectionSortAlgorithm.sort(pieces, gameTable);
                break;
            case "i":
                SortingAlgorithm insertionSortAlgorithm = new InsertionSortAlgorithm();
                insertionSortAlgorithm.sort(pieces, gameTable);
                break;
            default:
                System.out.println("Algoritmo no soportado.");
                break;
        }

    }
}