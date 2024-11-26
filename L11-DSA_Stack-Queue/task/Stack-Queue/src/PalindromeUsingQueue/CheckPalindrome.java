package PalindromeUsingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindrome {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            queue.add(ch);
            stack.add(ch);
        }

        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
}
