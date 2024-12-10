package menu;

public class MaintenanceStaffMenu implements RoleMenu {
    @Override
    public void displayMenu() {
        System.out.println("Maintenance Staff Menu:");
        System.out.println("1. View Tasks");
        System.out.println("2. Update Task Status");
    }
}