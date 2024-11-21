package WordFrequencyCounter;

import java.util.Map;
import java.util.TreeMap;

public class CharacterFrequencyCounter {
    public static void main(String[] args) {
        String input = "Overall, the time complexity of the code is O(n log n), where n is the number of elements in the TreeMap.";

        String normalizedInput = input.toLowerCase().replaceAll("[^a-z]", "");

        TreeMap<Character, Integer> charCountMap = new TreeMap<>();

        for (char c : normalizedInput.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        System.out.println("Character frequency:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
