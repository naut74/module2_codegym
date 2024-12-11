package management;

import entities.MaintenanceStaff;
import utility.FileManagement;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceStaffManagement {
    public static final String SRC_DATA_USER_INFO = "src/data/test.txt";
    private List<MaintenanceStaff> staffs = new ArrayList<>();

    public List<MaintenanceStaff> getStaffs() {
        staffs.clear();
        List<String> lines = FileManagement.readFile(SRC_DATA_USER_INFO);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 6 && parts[2].equals("maintenanceStaff")) {
                String username = parts[0];
                String password = parts[1];
                String role = parts[2];
                String staffName = parts[3];
                String staffId = parts[4];
                boolean staffStatus = Boolean.parseBoolean(parts[5]);
                MaintenanceStaff staff = new MaintenanceStaff(username, password, role, staffName, staffId, staffStatus);
                staffs.add(staff);
            }
        }
        return staffs;
    }

    public void saveStaffsToFile(String filePath, boolean statusAppend) {
        List<String> data = new ArrayList<>();

        for (MaintenanceStaff staff : staffs) {
            String line = staff.getUsername() + ","
                    + staff.getPassword() + ","
                    + staff.getRole() + ","
                    + staff.getStaffName() + ","
                    + staff.getStaffId() + ","
                    + staff.isStaffStatus();
            data.add(line);
        }

        FileManagement.writeFile(filePath, data, statusAppend);
    }

    public void viewStaffList() {
        staffs = getStaffs();
        if (staffs.isEmpty()) {
            System.out.println("No maintenance staff found.");
        } else {
            System.out.println("\n========= MAINTENANCE STAFF LIST ========");
            for (MaintenanceStaff staff : staffs) {
                System.out.printf("ID: %s | Name: %s | Status: %s%n",
                        staff.getStaffId(),
                        staff.getStaffName(),
                        staff.isStaffStatus() ? "Active" : "Inactive");
            }
            System.out.println("=========================================");
        }
    }

    public void addStaff(String username, String password, String role, String staffName, String staffId, boolean staffStatus) {
        MaintenanceStaff newStaff = new MaintenanceStaff(username, password, role, staffName, staffId, staffStatus);
        staffs.add(newStaff);
        saveStaffsToFile(SRC_DATA_USER_INFO, true);
        System.out.println("Maintenance staff added successfully.");
    }

    public void removeStaff(String staffIdToRemove, String filePath) {
        List<String> lines = FileManagement.readFile(filePath);
        List<String> updatedLines = new ArrayList<>();

        boolean staffRemoved = false;

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 6 && parts[2].equals("maintenanceStaff")) {
                if (!parts[4].equals(staffIdToRemove)) {
                    updatedLines.add(line);
                } else {
                    staffRemoved = true;
                }
            } else {
                updatedLines.add(line);
            }
        }

        FileManagement.writeFile(filePath, updatedLines, false);

        if (staffRemoved) {
            System.out.println("Maintenance staff with ID " + staffIdToRemove + " removed successfully.");
        } else {
            System.out.println("Maintenance staff with ID " + staffIdToRemove + " not found.");
        }
    }
}
