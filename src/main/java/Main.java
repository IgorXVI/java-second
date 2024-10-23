import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        String inputPath = "C:\\Users\\inazu\\Projects\\ws-intellij\\java-second\\src\\main\\java\\input.csv";

        ArrayList<String> inputLines = readInput(inputPath);

        Map<String, Integer> cadidateMap = getCadidateMap(inputLines);

        for(Map.Entry<String, Integer> entry : cadidateMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
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
