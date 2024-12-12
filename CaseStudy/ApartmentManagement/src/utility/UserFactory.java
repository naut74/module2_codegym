package utility;

import entities.MaintenanceStaff;
import entities.Manager;
import entities.Resident;
import entities.User;

public class UserFactory {
    public static User createUser(String username, String password, String role, String residentName, String apartmentId, String rentalTime, String staffName, String staffId, boolean staffStatus, String additionalInfo) {
        return switch (role.toLowerCase()) {
            case "resident" -> new Resident(username, password, role, residentName, apartmentId, rentalTime);
            case "manager" -> new Manager(username, password, role, additionalInfo);
            case "maintenanceStaff" -> new MaintenanceStaff(username, password, role, staffName, staffId, staffStatus);
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };
    }
}
