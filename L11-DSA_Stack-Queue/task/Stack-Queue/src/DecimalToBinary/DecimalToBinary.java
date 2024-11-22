package DecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary<T> {
    public DecimalToBinary(int number) {
        Stack<Integer> stack = new Stack<>();

        if (number > 0) {
            while (number > 0) {
                int binary = number % 2;
                number = number / 2;
                stack.push(binary);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(" " + stack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter decimal: ");
        int number = input.nextInt();

        System.out.println("Decimal to Binary of: " + number);
        new DecimalToBinary(number);
    }
}
