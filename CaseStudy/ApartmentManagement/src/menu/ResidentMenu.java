package menu;

public class ResidentMenu implements RoleMenu {
    @Override
    public void displayMenu() {
        System.out.println("Resident Menu:");
        System.out.println("1. View Apartment Details");
        System.out.println("2. Request Maintenance");
    }
}