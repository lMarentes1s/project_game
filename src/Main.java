
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
                String order = paramMap.get("c");
                String piece = paramMap.get("r");
                StringBuilder time = new StringBuilder(paramMap.get("s"));
                int newTime = Integer.parseInt(time.toString());

                User user = new User(algorithm, listType, order, piece, newTime);

                System.out.println(user);
            } else {
                System.out.println("Please provide the parameters in the correct format.");
            }

           //GameTable gameTable = new GameTable();
             // gameTable.PrintTable();

            Pieces.printList();


        }
    }



