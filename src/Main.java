import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            Map<String, String> paramMap = new HashMap<>();

            for (String param : args) {
                String[] keyValue = param.split("=");
                paramMap.put(keyValue[0], keyValue[1]);
            }

            String algorithm = paramMap.get("a");
            String listType = paramMap.get("t");
            String order = paramMap.get("o");
            String piece = paramMap.get("r");
            int time = Integer.parseInt(paramMap.get("s"));

            User user = new User(algorithm, listType, order, piece, time);
            System.out.println(user);

            GameTable gameTable = new GameTable(time);
            gameTable.fillTable();
            gameTable.printTable();

            long startTime = System.currentTimeMillis();
            gameTable.sort(algorithm);
            long endTime = System.currentTimeMillis();

            System.out.println("Time elapsed: " + (endTime - startTime) + " ms");
        } else {
            System.out.println("Please provide the parameters in the correct format.");
        }
    }
}