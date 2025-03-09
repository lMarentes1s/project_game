package Game;

public class User {
    private String Algorithm;
    private String ListType;
    private static String order;
    private static String piece;
    private static int time;


    private String[] validAlgorithm = {"q", "s", "i"};  // Bubble, Merge, Insert
    private String[] validListType = {"n", "c"};  // Numeric, Character
    private String[] validOrder = {"b", "w"};  // Black,white
    private String[] validPiece = {"1", "2", "4", "8", "10", "16"};  // 1,2,4,8,10,16

    public User(String Algorithm, String ListType, String order, String piece, int time) {
        setAlgorithm(Algorithm);
        setListType(ListType);
        setOrder(order);
        setPiece(piece);
        setTime(time);
    }

    private boolean isValid(String value, String[] validValues) {
        for (String valid : validValues) {
            if (valid.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public String getAlgorithm() {
        return Algorithm;
    }

    public void setAlgorithm(String algorithm) {
        if (isValid(algorithm, validAlgorithm)) {
            Algorithm = algorithm;
        } else {
            throw new IllegalArgumentException("Invalid algorithm");
        }

    }

    public String getListType() {
        return ListType;
    }

    public void setListType(String listType) {
        if (isValid(listType, validListType)) {
            ListType = listType;
        } else {
            throw new IllegalArgumentException("Invalid list type");
        }
    }

    public static String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if (isValid(order, validOrder)) {
            this.order = order;
        } else {
            throw new IllegalArgumentException("Invalid order");
        }
    }

    public static String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        if (isValid(piece, validPiece)) {
            this.piece = piece;
        } else {
            throw new IllegalArgumentException("Invalid piece");
        }
    }

    public static int getTime() {
        return time;
    }

    public void setTime(int time) {
        if (time > 100 && time < 1000) {
            this.time = time;
        } else {
            throw new IllegalArgumentException("Invalid time");
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "algoritmo='" + Algorithm + '\'' +
                ", tipo='" + ListType + '\'' +
                ", color='" + order + '\'' +
                ", r=" + piece +
                ", s=" + time +
                '}';
    }
}









