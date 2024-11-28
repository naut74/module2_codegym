package IncreasingSubstring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        String result = IncreasingSubstring.findLongestIncreasingSubstring(input);

        System.out.println("Increasing Substring is: " + result);
    }
}
