package menu;

import java.util.Scanner;

import static utility.GetValidValue.getValidInteger;

public class ManagerMenu implements RoleMenu {
    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n========== MANAGER MENU ==========");
            System.out.println("1. Manage Apartments");
            System.out.println("2. Manage Residents");
            System.out.println("3. Manage Maintenance Staff");
            System.out.println("4. Exit");
            System.out.println("==================================");

            try {
                int choice = getValidInteger(scanner, "Enter your choice: ");
                switch (choice) {
                    case 1:
                        ApartmentsManagementMenu apartmentsMenu = new ApartmentsManagementMenu();
                        apartmentsMenu.displayMenu();
                        break;
                    case 2:
                        ResidentManagementMenu residentManagementMenu = new ResidentManagementMenu();
                        residentManagementMenu.displayMenu();
                        break;
                    case 3:
                        MaintenanceStaffManagementMenu maintenanceMenu = new MaintenanceStaffManagementMenu();
                        maintenanceMenu.displayMenu();
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
                scanner.nextLine();
            }
        }
    }
}
