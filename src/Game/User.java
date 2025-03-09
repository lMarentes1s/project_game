package Game;

import java.util.Set;

public class User {
    private String algorithm;
    private String listType;
    private String order;
    private String piece;
    private int time;

    private static final Set<String> VALID_ALGORITHMS = Set.of("q", "s", "i");  // QuickSort, SelectionSort, InsertionSort
    private static final Set<String> VALID_LIST_TYPES = Set.of("n", "c");  // Numeric, Character
    private static final Set<String> VALID_ORDERS = Set.of("b", "w");  // Black, White
    private static final Set<String> VALID_PIECES = Set.of("1", "2", "4", "8", "10", "16");

    public User(String algorithm, String listType, String order, String piece, int time) {
        setAlgorithm(algorithm);
        setListType(listType);
        setOrder(order);
        setPiece(piece);
        setTime(time);
    }

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
            throw new IllegalArgumentException("Invalid algorithm: " + algorithm);
        }
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        if (isValid(listType, VALID_LIST_TYPES)) {
            this.listType = listType;
        } else {
            throw new IllegalArgumentException("Invalid list type: " + listType);
        }
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if (isValid(order, VALID_ORDERS)) {
            this.order = order;
        } else {
            throw new IllegalArgumentException("Invalid order: " + order);
        }
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        if (isValid(piece, VALID_PIECES)) {
            this.piece = piece;
        } else {
            throw new IllegalArgumentException("Invalid piece: " + piece);
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        if (time > 100 && time < 1000) {
            this.time = time;
        } else {
            throw new IllegalArgumentException("Invalid time: " + time);
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
