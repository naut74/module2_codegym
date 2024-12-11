package menu;

import management.MaintenanceStaffManagement;

import java.io.IOException;
import java.util.Scanner;

import static utility.GetValidValue.getValidInteger;

public class MaintenanceStaffManagementMenu {
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MAINTENANCE STAFF MANAGEMENT MENU =====");
            System.out.println("1. View Staff List");
            System.out.println("2. Add Staff");
            System.out.println("3. Remove Staff");
            System.out.println("4. Back");
            System.out.println("==============================================");

            MaintenanceStaffManagement maintenanceStaffManagement = new MaintenanceStaffManagement();
            try {
                int choice = getValidInteger(scanner, "Enter your choice: ");
                switch (choice) {
                    case 1:
                        System.out.println("\nViewing Staff List...");
                        maintenanceStaffManagement.viewStaffList();
                        break;
                    case 2:
                        System.out.println("Adding a Staff...");
                        addStaffInfo(scanner, maintenanceStaffManagement);
                        break;
                    case 3:
                        System.out.println("Removing a Staff...");
                        removeStaffInfo(scanner, maintenanceStaffManagement);
                        break;
                    case 4:
                        System.out.println("Returning to main menu...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    private static void removeStaffInfo(Scanner scanner, MaintenanceStaffManagement maintenanceStaffManagement) {
        System.out.print("Enter Staff ID: ");
        String staffIdToRemove = scanner.nextLine();
        String filePathDataUser = "src/data/test.txt";
        maintenanceStaffManagement.removeStaff(staffIdToRemove, filePathDataUser);
    }

    private static void addStaffInfo(Scanner scanner, MaintenanceStaffManagement maintenanceStaffManagement) {
        System.out.print("Enter Staff Name: ");
        String staffName = scanner.nextLine();
        System.out.print("Enter Staff ID: ");
        String staffId = scanner.nextLine();
        boolean staffStatus = true; // True -> Free, False -> Busy
        System.out.println("Create Account for " + staffName);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String role = "maintenanceStaff";
        maintenanceStaffManagement.addStaff(username, password, role, staffName, staffId, staffStatus);
    }
}
