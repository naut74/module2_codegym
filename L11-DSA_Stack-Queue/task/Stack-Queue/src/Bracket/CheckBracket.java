package Bracket;

import java.util.Stack;

public class CheckBracket {
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char sym : str.toCharArray()) {
            if (sym == '[' || sym == '{' || sym == '(') {
                stack.push(sym);
            } else if (sym == ']' || sym == '}' || sym == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (!isMathchingPair(left, sym)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isMathchingPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']');
    }

    public static void main(String[] args) {
        String test1 = "({[]})";
        String test2 = "({[})";
        String test3 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";

        System.out.println(test1 + " : " + isValid(test1));
        System.out.println(test2 + " : " + isValid(test2));
        System.out.println(test3 + " : " + isValid(test3));
    }
}
