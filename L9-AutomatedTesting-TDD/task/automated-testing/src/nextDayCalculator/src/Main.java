package nextDayCalculator.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter day: ");
        int day = input.nextInt();
        System.out.print("Enter month: ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();
        System.out.printf("Input year is: %d/%d/%d", day, month, year);

        NextDayCalculator calculate = new NextDayCalculator();
        System.out.println("\nNext day is: " + NextDayCalculator.calculateNextDay(day, month, year));

    }
}

