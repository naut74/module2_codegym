package management;

import entities.MaintenanceStaff;
import entities.Manager;
import entities.Resident;
import entities.User;
import utility.FileManagement;
import utility.UserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authentication {
    private static Authentication instance; // Singleton instance
    private Map<String, String[]> loginData; // [username -> [password, role, additionalInfo]]

    private Authentication() {
        loginData = new HashMap<>();
        loadLoginData();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void loadLoginData() {
        String filePath = "src/data/loginData.txt";
        List<String> lines = FileManagement.readFile(filePath);

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 3 && parts[2].equals("manager")) {
                String username = parts[0].trim();
                String password = parts[1].trim();
                String role = parts[2].trim();
                loginData.put(username, new String[]{password, role, ""});
            } else if (parts.length == 6 && parts[2].equals("resident")) {
                String username = parts[0].trim();
                String password = parts[1].trim();
                String role = parts[2].trim();
                String residentName = parts[3].trim();
                String apartmentId = parts[4].trim();
                String rentalTime = parts[5].trim();
                String additionalInfo = residentName + "," + apartmentId + "," + rentalTime;
                loginData.put(username, new String[]{password, role, residentName, apartmentId, rentalTime,additionalInfo});
            } else if (parts.length == 6 && parts[2].equals("maintenanceStaff")) {
                String username = parts[0].trim();
                String password = parts[1].trim();
                String role = parts[2].trim();
                String staffName = parts[3].trim();
                String staffId = parts[4].trim();
                String staffStatus = parts[5].trim();
                String additionalInfo = staffName + "," + staffId + "," + staffStatus;
                loginData.put(username, new String[]{password, role, staffName, staffId, staffStatus});
            }
        }
    }

    public User login(String username, String password) {
        if (loginData.containsKey(username)) {
            String[] data = loginData.get(username);
            if (data[0].equals(password) && data[1].equals("manager")) {
                return new Manager(username, password, data[1], data[2]);
            } else if (data[0].equals(password) && data[1].equals("resident")) {
                return new Resident(username, password, data[1], data[2], data[3], data[4]);
            } else if (data[0].equals(password) && data[1].equals("maintenanceStaff")) {
                boolean value = Boolean.parseBoolean(data[4]);
                return new MaintenanceStaff(username, password, data[1], data[2], data[3], value);
            }
        }
        return null;
    }
}
