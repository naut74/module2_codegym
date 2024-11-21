package ReverseArrayUsingStack;

import static ReverseArrayUsingStack.ReverseArrayUsingStack.reverseIntegerArray;
import static ReverseArrayUsingStack.ReverseArrayUsingStack.reverseWords;

public class Main {
    public static void main(String[] args) {
        /* Reverse Integer */
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Original Integer Array");

        for (int num : array) {
            System.out.print(num + " ");
        }

        reverseIntegerArray(array);

        System.out.println("\nReverse Integer Array");
        for (int num : array) {
            System.out.print(num + " ");
        }

        /* Reverse String */
        String sentence = "Hello world from Stack";
        System.out.println("\n\nOriginal Sentence:");
        System.out.println(sentence);

        String reversedSentence = reverseWords(sentence);
        System.out.println("Reversed Sentence:");
        System.out.println(reversedSentence);
    }
}
