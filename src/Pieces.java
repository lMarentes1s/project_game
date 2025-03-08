public abstract class Pieces {
    protected String nombre;
    protected String color;
    protected String name;

    public Pieces(String name) {
        this.nombre = name;
    }

    public String getName() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public static String[] listOfNumbers() {

        int Quantity = Integer.parseInt(User.getPiece());
        String[][] pieceByQuantity = {
                {new King().getName()},
                {new King().getName(),new Queen().getName()},
                {new King().getName(),new Queen().getName(), new Bishop().getName(), new Bishop().getName()},
                {new King().getName(),new Queen().getName(), new Bishop().getName(), new Bishop().getName(), new Knight().getName(), new Knight().getName()},
                {new King().getName(),new Queen().getName(), new Bishop().getName(), new Bishop().getName(), new Knight().getName(), new Knight().getName(), new Rook().getName(),new Rook().getName()},
                {new King().getName(),new Queen().getName(), new Bishop().getName(), new Bishop().getName(), new Knight().getName(), new Knight().getName(), new Rook().getName(),new Rook().getName(), new Pawn().getName(), new Pawn().getName()},
                {new King().getName(),new Queen().getName(), new Bishop().getName(), new Bishop().getName(), new Knight().getName(), new Knight().getName(), new Rook().getName(),new Rook().getName(), new Pawn().getName(), new Pawn().getName(), new Pawn().getName(),new Pawn().getName(),new Pawn().getName(),new Pawn().getName(),new Pawn().getName(),new Pawn().getName()}
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

    static class King extends Pieces {
        public King() {
            super("KG");
        }
    }

    static class Queen extends Pieces {
        public Queen() {
            super("QN");
        }
    }

    static class Rook extends Pieces {
        public Rook() {
            super("RK");
        }
    }

    static class Bishop extends Pieces {
        public Bishop() {
            super("BP");
        }
    }

    static class Knight extends Pieces {
        public Knight() {
            super("KT");
        }
    }

    static class Pawn extends Pieces {
        public Pawn() {
            super("PW");
        }
    }
}