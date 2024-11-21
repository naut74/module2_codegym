package ReverseArrayUsingStack;

import java.util.Stack;

public class ReverseArrayUsingStack<T> {
    public static void reverseIntegerArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            stack.push(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static String reverseWords(String input) {
        Stack<String> stack = new Stack<>();
        String[] words = input.split(" ");

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reversedString = new StringBuilder();

        while (!stack.isEmpty()) {
            String word = stack.pop();
            reversedString.append(word);

            if (!stack.isEmpty()) {
                reversedString.append(" ");
            }
        }
        return reversedString.toString();
    }
}
