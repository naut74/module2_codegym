package menu;

import entities.Resident;
import entities.User;
import management.Authentication;

import java.util.Scanner;

public class LoginMenu {
    private User userInfo;
    private static LoginMenu loginMenu = null;

    private LoginMenu() {}

    public static LoginMenu getInstance() {
        if (loginMenu == null) {
            loginMenu = new LoginMenu();
        }
        return loginMenu;
    }

    public User login() {
        Authentication auth = Authentication.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-----WELCOME TO APARTMENT MANAGEMENT SYSTEM-----");
        System.out.println();
        System.out.println("============== Login ============");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println("---------------------------------");

        User user = auth.login(username, password);
        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getUsername());
            System.out.println("Role: " + user.getRole());
            this.userInfo = user;
            return user;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }
    }

    public User getUserInfo() {
        return this.userInfo;
    }
}
