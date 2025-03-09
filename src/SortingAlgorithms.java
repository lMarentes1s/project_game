import java.util.List;


public class SortingAlgorithms {
    public static void quickSortAndPrint(List<Pieces> pieces, GameTable gameTable) {
        System.out.println("\nIniciando ordenamiento con Quick Sort...");

        assignRandomPositionsInFirstTwoRows(pieces);
        gameTable.updateBoard();

        quickSort(pieces, 0, pieces.size() - 1, gameTable);

        // Mover todas las piezas a sus posiciones originales
        for (Pieces piece : pieces) {
            if (piece.getRow() != piece.getOriginalRow() || piece.getCol() != piece.getOriginalCol()) {
                piece.setRow(piece.getOriginalRow());
                piece.setCol(piece.getOriginalCol());
                gameTable.updateBoard();
            }
        }

        System.out.println("Ordenamiento completado. Todas las piezas están en su posición original.");
    }

    private static void quickSort(List<Pieces> pieces, int low, int high, GameTable gameTable) {
        if (low < high) {
            int pi = partition(pieces, low, high, gameTable);

            quickSort(pieces, low, pi - 1, gameTable);
            quickSort(pieces, pi + 1, high, gameTable);
        }
    }

    private static int partition(List<Pieces> pieces, int low, int high, GameTable gameTable) {
        Pieces pivot = pieces.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (distanceToOriginal(pieces.get(j)) < distanceToOriginal(pivot)) {
                i++;
                swapPiecesPosition(pieces.get(i), pieces.get(j));
                gameTable.updateBoard();
            }
        }
        swapPiecesPosition(pieces.get(i + 1), pieces.get(high));
        gameTable.updateBoard();
        return i + 1;
    }

    // Existing methods: assignRandomPositionsInFirstTwoRows, distanceToOriginal, swapPiecesPosition


    public static void selectionSortAndPrint(List<Pieces> pieces, GameTable gameTable) {
        System.out.println("\nIniciando ordenamiento con Selection Sort...");

        assignRandomPositionsInFirstTwoRows(pieces);
        gameTable.updateBoard();

        for (int i = 0; i < pieces.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < pieces.size(); j++) {
                if (distanceToOriginal(pieces.get(j)) < distanceToOriginal(pieces.get(minIndex))) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swapPiecesPosition(pieces.get(i), pieces.get(minIndex));
                gameTable.updateBoard();
            }
        }

        // Mover todas las piezas a sus posiciones originales
        for (Pieces piece : pieces) {
            if (piece.getRow() != piece.getOriginalRow() || piece.getCol() != piece.getOriginalCol()) {
                piece.setRow(piece.getOriginalRow());
                piece.setCol(piece.getOriginalCol());
                gameTable.updateBoard();
            }
        }

        System.out.println("Ordenamiento completado. Todas las piezas están en su posición original.");
    }
    public static void insertionSortAndPrint(List<Pieces> pieces, GameTable gameTable) {
        System.out.println("\nIniciando ordenamiento con Insertion Sort...");

        assignRandomPositionsInFirstTwoRows(pieces);
        gameTable.updateBoard();

        // Realizar el insertion sort basado en la distancia a la posición original
        for (int i = 1; i < pieces.size(); i++) {
            Pieces keyPiece = pieces.get(i);
            int j = i - 1;

            // Mover las piezas que están más lejos de su posición original que keyPiece
            while (j >= 0 && distanceToOriginal(pieces.get(j)) > distanceToOriginal(keyPiece)) {
                pieces.set(j + 1, pieces.get(j));
                j = j - 1;
            }
            pieces.set(j + 1, keyPiece);
            gameTable.updateBoard();
        }

        // Mover todas las piezas a sus posiciones originales
        for (Pieces piece : pieces) {
            if (piece.getRow() != piece.getOriginalRow() || piece.getCol() != piece.getOriginalCol()) {
                piece.setRow(piece.getOriginalRow());
                piece.setCol(piece.getOriginalCol());
                gameTable.updateBoard();
            }
        }

        System.out.println("Ordenamiento completado. Todas las piezas están en su posición original.");
    }

    // Método modificado para asignar posiciones aleatorias en las primeras dos filas
    private static void assignRandomPositionsInFirstTwoRows(List<Pieces> pieces) {
        // Crear un array para rastrear posiciones ocupadas
        boolean[][] occupied = new boolean[2][8]; // Solo usamos las primeras 2 filas (filas 0 y 1)

        for (Pieces piece : pieces) {
            int randomRow;
            int randomCol;

            // Encuentra una posición aleatoria no ocupada en las primeras dos filas
            do {
                randomRow = (int) (Math.random() * 2); // Solo filas 0 y 1
                randomCol = (int) (Math.random() * 8); // Todas las columnas
            } while (occupied[randomRow][randomCol]);

            // Marcar la posición como ocupada
            occupied[randomRow][randomCol] = true;

            // Actualizar la posición de la pieza
            piece.setRow(randomRow);
            piece.setCol(randomCol);
        }
    }

    // Método para calcular la distancia euclidiana entre la posición actual y la original
    private static double distanceToOriginal(Pieces piece) {
        int rowDiff = piece.getRow() - piece.getOriginalRow();
        int colDiff = piece.getCol() - piece.getOriginalCol();
        return Math.sqrt(rowDiff * rowDiff + colDiff * colDiff);
    }

    // Método para intercambiar las posiciones de dos piezas
    private static void swapPiecesPosition(Pieces piece1, Pieces piece2) {
        int tempRow = piece1.getRow();
        int tempCol = piece1.getCol();

        piece1.setRow(piece2.getRow());
        piece1.setCol(piece2.getCol());

        piece2.setRow(tempRow);
        piece2.setCol(tempCol);
    }
}