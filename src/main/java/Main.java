import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String inputPath = "C:\\Users\\inazu\\Projects\\ws-intellij\\java-second\\src\\main\\java\\input.csv";

        ArrayList<String> inputLines = readInput(inputPath);

        Map<String, Integer> cadidateMap = getCadidateMap(inputLines);

        for(Map.Entry<String, Integer> entry : cadidateMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        interface Fun {
            int apply(int a, int b);
        }

        Fun fun = (int a, int b) -> {
            return a + b;
        };

        int result = fun.apply(1, 2);

        System.out.println(result);

        Supplier<List<Integer>> xs = LinkedList::new;

        List<Integer> cart = xs.get();
        cart.add(1);
        cart.add(2);

        System.out.println(cart);
    }

    private static ArrayList<String> readInput(String inputPath) {
        ArrayList<String> inputLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line = br.readLine();
            while (line != null) {
                inputLines.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return inputLines;
    }

    private static Map<String, Integer> getCadidateMap(ArrayList<String> inputLines) {
        Map<String, Integer> cadidateMap = new HashMap<>();

        for(String inputLine : inputLines) {
            String[] split = inputLine.split(",");

            String name = split[0];
            int amount = Integer.parseInt(split[1]);

            Integer caditateMapAmount = cadidateMap.get(name);
            if(caditateMapAmount == null) {
                caditateMapAmount = amount;
            }
            else {
                caditateMapAmount += amount;
            }

            cadidateMap.put(name, caditateMapAmount);
        }

        return cadidateMap;
    }
}
