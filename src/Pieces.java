import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public abstract class Pieces {
    protected String name;
    protected int row;
    protected int col;
    protected int originalRow;
    protected int originalCol;


    public Pieces(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.originalRow = row;  // Guardamos la posición original
        this.originalCol = col;  // Guardamos la posición original
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getOriginalRow() {
        return originalRow;  // Obtener la fila original
    }

    public int getOriginalCol() {
        return originalCol;  // Obtener la columna original
    }

    // Genera una lista de piezas según la configuración del usuario
    public static List<Pieces> listOfPieces() {
        int quantity = Integer.parseInt(User.getPiece());
        String color = User.getOrder();

        int baseRow = color.equalsIgnoreCase("w") ? 0 : 7;
        int pawnRow = color.equalsIgnoreCase("w") ? 1 : 6;

        List<Pieces> pieces = new ArrayList<>();

        // Añadir piezas según la cantidad seleccionada
        if (quantity >= 1) pieces.add(new King(baseRow, 4));
        if (quantity >= 2) pieces.add(new Queen(baseRow, 3));
        if (quantity >= 4) {
            pieces.add(new Bishop(baseRow, 2));
            pieces.add(new Bishop(baseRow, 5));
        }
        if (quantity >= 6) {
            pieces.add(new Knight(baseRow, 1));
            pieces.add(new Knight(baseRow, 6));
        }
        if (quantity >= 8) {
            pieces.add(new Rook(baseRow, 0));
            pieces.add(new Rook(baseRow, 7));
        }
        if (quantity >= 10) {
            pieces.add(new Pawn(pawnRow, 0));
            pieces.add(new Pawn(pawnRow, 1));
        }
        if (quantity > 10) {
            for (int i = 2; i < 8; i++) {
                pieces.add(new Pawn(pawnRow, i));
            }
        }

        // Desordenamos las piezas antes de colocarlas en el tablero
        Collections.shuffle(pieces);
        return pieces;
    }

    // Clases concretas para cada tipo de pieza
    static class King extends Pieces {
        public King(int row, int col) {
            super("KG", row, col);
        }
    }

    static class Queen extends Pieces {
        public Queen(int row, int col) {
            super("QN", row, col);
        }
    }

    static class Rook extends Pieces {
        public Rook(int row, int col) {
            super("RK", row, col);
        }
    }

    static class Bishop extends Pieces {
        public Bishop(int row, int col) {
            super("BP", row, col);
        }
    }

    static class Knight extends Pieces {
        public Knight(int row, int col) {
            super("KT", row, col);
        }
    }

    static class Pawn extends Pieces {
        public Pawn(int row, int col) {
            super("PW", row, col);
        }
    }
}
