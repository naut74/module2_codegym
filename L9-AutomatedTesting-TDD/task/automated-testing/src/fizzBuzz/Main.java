package fizzBuzz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = input.nextInt();

        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(FizzBuzz.findFizzBuzz(number));
    }
}
