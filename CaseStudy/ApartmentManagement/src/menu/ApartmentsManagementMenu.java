package menu;

import management.ApartmentManagement;

import java.util.Scanner;

import static utility.GetValidValue.getValidBoolean;
import static utility.GetValidValue.getValidInteger;

public class ApartmentsManagementMenu {
    private static final String FILE_PATH_APARTMENT_INFO = "src/data/apartmentInfoData.txt";

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n====== APARTMENTS MANAGEMENT MENU ======");
            System.out.println("1. Add Apartment");
            System.out.println("2. Update Apartment");
            System.out.println("3. Remove Apartment");
            System.out.println("4. View All Apartments");
            System.out.println("5. Back");
            System.out.println("========================================");

            ApartmentManagement apartmentsManagement = new ApartmentManagement();
            try {
                int choice = getValidInteger(scanner, "Enter your choice: ");
                switch (choice) {
                    case 1:
                        System.out.println("\nAdding a new apartment...");
                        addApartmentInfo(scanner, apartmentsManagement);
                        break;
                    case 2:
                        System.out.println("Updating status an apartment...");
                        updateApartmentInfo(scanner, apartmentsManagement);
                        break;
                    case 3:
                        System.out.println("Removing an apartment...");
                        removeApartmentInfo(scanner, apartmentsManagement);
                        break;
                    case 4:
                        System.out.println("Viewing all apartments...");
                        apartmentsManagement.viewAllApartments();
                        break;
                    case 5:
                        System.out.println("Returning to Manager Menu...");
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

    private static void removeApartmentInfo(Scanner scanner, ApartmentManagement apartmentsManagement) {
        System.out.print("Apartment ID: ");
        String apartmentIdRemove = scanner.nextLine();
        apartmentsManagement.removeApartment(apartmentIdRemove, FILE_PATH_APARTMENT_INFO);
    }

    private static void updateApartmentInfo(Scanner scanner, ApartmentManagement apartmentsManagement) {
        System.out.print("Apartment ID: ");
        String apartmentIdUpdate = scanner.nextLine();

        boolean newStatus = getValidBoolean(scanner, "Status (true/false): ");

        apartmentsManagement.updateApartmentStatus(apartmentIdUpdate, newStatus, FILE_PATH_APARTMENT_INFO);
    }

    private static void addApartmentInfo(Scanner scanner, ApartmentManagement apartmentsManagement) {
        System.out.println("=== Adding a New Apartment ===");

        System.out.print("Apartment ID: ");
        String apartmentId = scanner.nextLine();

        System.out.print("Building Name: ");
        String nameBuilding = scanner.nextLine();

        int floor = getValidInteger(scanner, "Floor (number): ");

        boolean status = getValidBoolean(scanner, "Status (true/false): ");

        apartmentsManagement.addApartment(apartmentId, nameBuilding, floor, status, FILE_PATH_APARTMENT_INFO);
        System.out.println("Apartment information added successfully!");
    }

}
