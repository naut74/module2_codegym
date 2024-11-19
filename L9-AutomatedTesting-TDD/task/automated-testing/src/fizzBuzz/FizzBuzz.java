package fizzBuzz;

public class FizzBuzz {
    public static String findFizzBuzz(int number) {
        if (DivisibleBy3(number)) {
            if (DivisibleBy5(number)) {
                return "FizzBuzz";
            }
            return "Fizz";
        } else if (DivisibleBy5(number)) {
            return "Buzz";
        }
        return "" + number;
    }

    private static boolean DivisibleBy5(int number) {
        return number % 5 == 0;
    }

    private static boolean DivisibleBy3(int number) {
        return number % 3 == 0;
    }
}
