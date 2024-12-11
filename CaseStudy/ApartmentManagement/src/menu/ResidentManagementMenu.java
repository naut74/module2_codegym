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
                        residentsManagement.removeResident();
                        break;
                    case 3:
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
        String role = "Resident";
        System.out.print("Resident name: ");
        String residentName = scanner.nextLine();
        System.out.println("Resident Apartment ID: ");
        String residentApartmentId = scanner.nextLine();
        System.out.println("Rental Time: ");
        String rentalTime = scanner.nextLine();
        residentsManagement.addResident(residentName, residentApartmentId, rentalTime);
    }
}