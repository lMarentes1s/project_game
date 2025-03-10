import Game.GameTable;
import Game.User;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * Main class to start the game and sorting process.
     */
    public static void main(String[] args) {

        /**
         * Main method to parse arguments and initialize the game.
         *
         * @param args Command line arguments for game settings.
         */
        if (args.length > 1) {

            Map<String, String> paramMap = new HashMap<>();
            for (String param : args) {
                String[] keyValue = param.split("=");
                paramMap.put(keyValue[0].toLowerCase(), keyValue[1].toLowerCase());
            }

            String algorithm = paramMap.get("a");
            String listType = paramMap.get("t");
            String order = paramMap.get("o");
            String piece = paramMap.get("r");
            int time = Integer.parseInt(paramMap.get("s"));

            User user = new User(algorithm, listType, order, piece, time);
            System.out.println(user);

            GameTable gameTable = new GameTable(user);
            gameTable.initialize(user);
        }
    }
}