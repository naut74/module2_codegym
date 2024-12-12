package menu;

import entities.Resident;
import entities.User;
import utility.FileManagement;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static utility.GetValidValue.getValidInteger;

public class ResidentMenu implements RoleMenu {
    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        LoginMenu loginMenu = LoginMenu.getInstance();
        User user = loginMenu.getUserInfo();

        if (!(user instanceof Resident)) {
            System.out.println("Error: User is not a resident.");
            return;
        }

        Resident resident = (Resident) user;
        String filePath = "src/data/requestMaintenance.txt";

        while (!exit) {
            System.out.println("\n====== RESIDENT MENU ======");
            System.out.println("1. View Apartment Details");
            System.out.println("2. Maintenance request");
            System.out.println("3. View Maintenance Status");
            System.out.println("4. Exit");
            System.out.println("===========================");

            try {
                int choice = getValidInteger(scanner, "Enter your choice: ");
                switch (choice) {
                    case 1 -> {
                        System.out.println("\nViewing apartment details...");
                        System.out.println("- Apartment ID: " + resident.getApartmentId() +
                                "\n- Resident Name: " + resident.getResidentName() +
                                "\n- Rental Time: " + resident.getRentalTime());
                    }
                    case 2 -> {
                        System.out.println("\nMaintenance request ...");
                        sendMaintenanceRequest(scanner, resident, filePath);
                    }
                    case 3 -> {
                        System.out.println("\nViewing maintenance status...");
                        String status = checkRequestStatus(filePath, resident.getApartmentId());
                        System.out.println("Maintenance status: " + status);
                    }
                    case 4 -> {
                        System.out.println("Logging out...");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void sendMaintenanceRequest(Scanner scanner, Resident resident, String filePath) {
        int issueChoice = 0;
        while (issueChoice != 1 && issueChoice != 2) {
            System.out.println("1. Maintenance");
            System.out.println("2. Improvement");
            issueChoice = getValidInteger(scanner, "Enter your choice (1 or 2): ");
            if (issueChoice != 1 && issueChoice != 2) {
                System.out.println("Invalid choice. Please enter 1 for Maintenance or 2 for Improvement.");
            }
        }

        String requestType = issueChoice == 1 ? "Maintenance" : "Improvement";
        String apartmentId = resident.getApartmentId();
        String staffId = "staff" + ((int) (Math.random() * 3));
        String request = apartmentId + "," + requestType + ",false," + staffId;

        List<String> lines = new ArrayList<>();
        lines.add(request);
        FileManagement.writeFile(filePath, lines, true);
        System.out.println("Request recorded successfully!");
    }


    private String checkRequestStatus(String filePath, String apartmentId) {
        List<String> lines = FileManagement.readFile(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4 && parts[0].equals(apartmentId)) {
                return parts[2].equalsIgnoreCase("false") ? "Unfinished" : "Finished";
            }
        }
        return "Finished";
    }
}
