package menu;

import management.ResidentsManagement;

import java.util.Scanner;

import static utility.GetValidValue.getValidInteger;

public class ResidentManagementMenu {

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;


        while (!exit) {
            System.out.println("======RESIDENT MANAGEMENT MENU======");
            System.out.println("1. Add Resident");
            System.out.println("2. Remove Residents");
            System.out.println("3. Resident List");
            System.out.println("4. Back");
            System.out.println("=====================================");

            ResidentsManagement residentsManagement = new ResidentsManagement();
            try {
                int choice = getValidInteger(scanner, "Enter your choice: ");
                switch (choice) {
                    case 1:
                        System.out.println("\nAdding a new resident...");
                        addResidentInfo(scanner, residentsManagement);
                        break;
                    case 2:
                        System.out.println("Removing a resident...");
                        System.out.println("Enter the apartment ID of the resident you want to remove: ");
                        String apartmentId = scanner.nextLine();
                        residentsManagement.removeResident(apartmentId, ResidentsManagement.SRC_DATA_USER_INFO);
                        break;
                    case 3:
                        System.out.println("Viewing residents list...");
                        residentsManagement.viewResidentsList();
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

    private static void addResidentInfo(Scanner scanner, ResidentsManagement residentsManagement) {
        System.out.print("Resident name: ");
        String residentName = scanner.nextLine();
        System.out.print("Resident Apartment ID: ");
        String residentApartmentId = scanner.nextLine();
        System.out.print("Rental Time (month): ");
        String rentalTime = scanner.nextLine();
        System.out.println("Create Account for " + residentName);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String role = "Resident";
        residentsManagement.addResident(username, password, role, residentName, residentApartmentId, rentalTime);
    }
}