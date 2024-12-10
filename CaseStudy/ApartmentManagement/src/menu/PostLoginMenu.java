package menu;

import entities.User;

public class PostLoginMenu {
    public void displayMenu(User user) {
        System.out.println("\n===== MENU =====");
        switch (user.getRole().toLowerCase()) {
            case "manager":
                ManagerMenu managerMenu = new ManagerMenu();
                managerMenu.displayMenu();
                break;

            case "resident":
                ResidentMenu residentMenu = new ResidentMenu();
                residentMenu.displayMenu();
                break;

            case "maintenancestaff":
                MaintenanceStaffMenu maintenanceMenu = new MaintenanceStaffMenu();
                maintenanceMenu.displayMenu();
                break;

            default:
                System.out.println("Unknown role: " + user.getRole());
                break;
        }
    }
}
