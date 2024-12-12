package menu;

import entities.MaintenanceStaff;
import entities.Resident;
import entities.User;
import utility.FileManagement;

import java.util.List;
import java.util.Scanner;

import static utility.GetValidValue.getValidInteger;

public class MaintenanceStaffMenu implements RoleMenu {

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        LoginMenu loginMenu = LoginMenu.getInstance();
        User user = loginMenu.getUserInfo();

        if (!(user instanceof MaintenanceStaff)) {
            System.out.println("Error: User is not a maintenance staff.");
            return;
        }

        MaintenanceStaff maintenanceStaff = (MaintenanceStaff) user;
        String staffId = maintenanceStaff.getStaffId();

        while (!exit) {
            System.out.println("\n====== MAINTENANCE STAFF MENU ======");
            System.out.println("1. View Tasks");
            System.out.println("2. Update Task Status");
            System.out.println("3. Exit");
            System.out.println("===========================");

            try {
                int choice = getValidInteger(scanner, "Enter your choice: ");
                switch (choice) {
                    case 1 -> {
                        System.out.println("\nViewing Tasks...");
                        viewTasks(staffId);
                    }
                    case 2 -> {
                        System.out.println("\nUpdating Task Status...");
                        updateTaskStatus(scanner, staffId);
                    }
                    case 3 -> {
                        System.out.println("Logging out...");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.close();
    }

    private void viewTasks(String staffId) {
        String filePath = "src/data/requestMaintenance.txt";
        List<String> lines = FileManagement.readFile(filePath);

        if (lines.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("===== TASK LIST =====");
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts[3].equals(staffId)) {
                    System.out.println("Apartment ID: " + parts[0] +
                            ", Request Type: " + parts[1] +
                            ", Status: " + (parts[2].equals("false") ? "Incomplete" : "Completed") +
                            ", Staff ID: " + parts[3]);
                }
            }
            System.out.println("=====================");
        }
    }

    private void updateTaskStatus(Scanner scanner, String staffId) {
        String filePath = "src/data/requestMaintenance.txt";
        List<String> lines = FileManagement.readFile(filePath);

        if (lines.isEmpty()) {
            System.out.println("No tasks available to update.");
            return;
        }

        System.out.println("Select a task to update:");
        int index = 1;
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[3].equals(staffId)) {
                System.out.println(index + ". Apartment ID: " + parts[0] +
                        ", Request Type: " + parts[1] +
                        ", Status: " + (parts[2].equals("false") ? "Incomplete" : "Completed"));
                index++;
            }
        }

        if (index == 1) {
            System.out.println("No tasks available for your Staff ID.");
            return;
        }

        int taskChoice = getValidInteger(scanner, "Enter the task number to update: ");
        if (taskChoice < 1 || taskChoice >= index) {
            System.out.println("Invalid task number. Please try again.");
            return;
        }

        String[] selectedTask = lines.get(taskChoice - 1).split(",");
        if (selectedTask[2].equals("false")) {
            selectedTask[2] = "true";
            lines.set(taskChoice - 1, String.join(",", selectedTask));

            lines.remove(taskChoice - 1); 

            FileManagement.writeFile(filePath, lines, false); // Ghi lại danh sách đã cập nhật vào file
            System.out.println("Task marked as 'Completed' and removed from the task list.");
        } else {
            System.out.println("This task is already marked as 'Completed'.");
        }
    }

}
