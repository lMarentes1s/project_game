public abstract class Pieces {
    protected String nombre;
    protected String color;
    protected String name;

    public Pieces(String name, String color) {
        this.nombre = name;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public static String[] listOfNumbers() {

        int Quantity = Integer.parseInt(User.getPiece());
        String[][] pieceByQuantity = {
                {"01"},
                {"01", "02"},
                {"01", "02", "03", "04"},
                {"01", "02", "03", "04", "05", "06"},
                {"01", "02", "03", "04", "05", "06", "07", "08"},
                {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"},
                {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16"}
        };
        int index = (Quantity == 1) ? 0 : (Quantity == 2) ? 1 : (Quantity == 4) ? 2 : (Quantity == 6) ? 3 : (Quantity == 8) ? 4 : (Quantity == 10) ? 5 : 6;
        return pieceByQuantity[index];
    }

    public static void printList() {
        String[] list = listOfNumbers();
        for (String number : list) {
            System.out.println(number);
        }

    }

    class King extends Pieces {
        public King(String color) {
            super("King", color);
        }
    }

    class Queen extends Pieces {
        public Queen(String color) {
            super("Queen", color);
        }
    }

    class Rook extends Pieces {
        public Rook(String color) {
            super("Rook", color);
        }
    }

    class Bishop extends Pieces {
        public Bishop(String color) {
            super("Bishop", color);
        }
    }

    class Knight extends Pieces {
        public Knight(String color) {
            super("Knight", color);
        }
    }

    class Pawn extends Pieces {
        public Pawn(String color) {
            super("Pawn", color);
        }
    }
}