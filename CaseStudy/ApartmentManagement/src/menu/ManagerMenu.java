package menu;

public class ManagerMenu implements RoleMenu {
    @Override
    public void displayMenu() {
        System.out.println("Manager Menu:");
        System.out.println("1. Manage Apartments");
        System.out.println("2. Manage Residents");
        System.out.println("3. Manage Maintenance Staff");
    }
}