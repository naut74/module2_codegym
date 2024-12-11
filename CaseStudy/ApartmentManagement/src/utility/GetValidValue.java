package utility;

import java.util.Scanner;

public class GetValidValue {
    private Scanner scanner = new Scanner(System.in);
    private static GetValidValue getValidValue = null;
    private GetValidValue() {
    }

    public static GetValidValue getInstance() {
        if (getValidValue == null) {
            getValidValue = new GetValidValue();
        }
        return getValidValue;
    }

    public static int getValidInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public static boolean getValidBoolean(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.println("Invalid input! Please enter 'true' or 'false'.");
            }
        }
    }
}
