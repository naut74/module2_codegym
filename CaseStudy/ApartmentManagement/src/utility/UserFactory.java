package utility;

import entities.MaintenanceStaff;
import entities.Manager;
import entities.Resident;
import entities.User;

public class UserFactory {
    public static User createUser(String username, String password, String role, String additionalInfo) {
        switch (role.toLowerCase()) {
            case "resident":
                return new Resident(username, password, role, additionalInfo);
            case "manager":
                return new Manager(username, password, role, additionalInfo);
            case "maintenanceStaff":
                return new MaintenanceStaff(username, password, role, additionalInfo);
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}
