package Game;

import java.util.Set;

/**
 * Class representing a user with game settings.
 */
public class User {
    private String algorithm;
    private String listType;
    private String order;
    private String piece;
    private int time;

    private static final Set<String> VALID_ALGORITHMS = Set.of("q", "s", "i");  // QuickSort, SelectionSort, InsertionSort
    private static final Set<String> VALID_LIST_TYPES = Set.of("n", "c");  // Numeric, Character
    private static final Set<String> VALID_ORDERS = Set.of("b", "w");  // Black, White
    private static final Set<String> VALID_PIECES = Set.of("1", "2", "4","6", "8", "10", "16");

    /**
     * Constructor for the User class.
     *
     * @param algorithm The sorting algorithm to use.
     * @param listType The type of list (numeric or character).
     * @param order The order of pieces (black or white).
     * @param piece The number of pieces.
     * @param time The delay time for updating the board.
     */
    public User(String algorithm, String listType, String order, String piece, int time) {
        try {
            setAlgorithm(algorithm);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Advertencia: " + e.getMessage() + " Se usará 'q' (QuickSort) por defecto.");
            this.algorithm = "q";
        }

        try {
            setListType(listType);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Advertencia: " + e.getMessage() + " Se usará 'n' (Numérico) por defecto.");
            this.listType = "n";
        }

        try {
            setOrder(order);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Advertencia: " + e.getMessage() + " Se usará 'b' (Blanco) por defecto.");
            this.order = "b";
        }

        try {
            setPiece(piece);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Advertencia: " + e.getMessage() + " Se usará '1' por defecto.");
            this.piece = "1";
        }

        try {
            setTime(time);
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Advertencia: " + e.getMessage() + " Se usará 500ms por defecto.");
            this.time = 500;
        }
    }

    /**
     * Checks if a value is valid based on a set of valid values.
     *
     * @param value The value to check.
     * @param validValues The set of valid values.
     * @return True if the value is valid, false otherwise.
     */
    private boolean isValid(String value, Set<String> validValues) {
        return validValues.contains(value);
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        if (isValid(algorithm, VALID_ALGORITHMS)) {
            this.algorithm = algorithm;
        } else {
            throw new IllegalArgumentException("Algoritmo inválido: '" + algorithm + "'. Opciones válidas: " + VALID_ALGORITHMS);
        }
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        if (isValid(listType, VALID_LIST_TYPES)) {
            this.listType = listType;
        } else {
            throw new IllegalArgumentException("Tipo de lista inválido: " + listType);
        }
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if (isValid(order, VALID_ORDERS)) {
            this.order = order;
        } else {
            throw new IllegalArgumentException("Orden inválido: " + order);
        }
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        if (isValid(piece, VALID_PIECES)) {
            this.piece = piece;
        } else {
            throw new IllegalArgumentException("Número de piezas inválido: " + piece);
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        if (time > 100 && time < 1000) {
            this.time = time;
        } else {
            throw new IllegalArgumentException("Tiempo inválido: " + time + "ms. Debe estar entre 100 y 1000ms.");
        }
    }

    @Override
    public String toString() {
        return "User {" +
                "algorithm='" + algorithm + '\'' +
                ", listType='" + listType + '\'' +
                ", order='" + order + '\'' +
                ", piece='" + piece + '\'' +
                ", time=" + time +
                '}';
    }
}
