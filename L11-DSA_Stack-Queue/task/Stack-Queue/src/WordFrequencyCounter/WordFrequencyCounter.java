package WordFrequencyCounter;

import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String input = "Let us start with a simple Java code snippet that demonstrates how to create and use a TreeMap in Java.";

        String[] words = input.toLowerCase().split("\\W+");

        TreeMap<String, Integer> wordCountMap = new TreeMap<>();

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
