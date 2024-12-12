import entities.User;
import management.Authentication;
import menu.LoginMenu;
import menu.PostLoginMenu;

import static utility.GetValidValue.getValidInteger;

public class ApplicationMenu {
    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n========= APARTMENT MANAGEMENT SYSTEM =========");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.println("===============================================");
//            System.out.print("Choose an option: ");

            int choice = readChoice();
            switch (choice) {
                case 1:
                    Authentication auth = Authentication.getInstance();
                    LoginMenu loginMenu = LoginMenu.getInstance();

                    User user = loginMenu.login();
                    if (user != null) {
                        PostLoginMenu postLoginMenu = new PostLoginMenu();
                        postLoginMenu.displayMenu(user);
                        exit = true;
                    }
                    break;

                case 2:
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    private static int readChoice() {
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            return getValidInteger(scanner, "Enter your choice: ");
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
            return -1;
        }
    }
}
