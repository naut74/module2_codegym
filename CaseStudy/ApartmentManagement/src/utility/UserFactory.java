package utility;

import entities.MaintenanceStaff;
import entities.Manager;
import entities.Resident;
import entities.User;

public class UserFactory {
    public static User createUser(String username, String password, String role, String additionalInfo) {
        switch (role.toLowerCase()) {
            case "resident":
                return new Resident(username, password, role, additionalInfo); // additionalInfo: Apartment ID
            case "manager":
                return new Manager(username, password, role, additionalInfo); // additionalInfo: Contact Info
            case "maintenancestaff":
                return new MaintenanceStaff(username, password, role, additionalInfo); // additionalInfo: Skill Set
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}
