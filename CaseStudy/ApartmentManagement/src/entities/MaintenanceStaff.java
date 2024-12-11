package entities;

public class MaintenanceStaff extends User {
    private String staffName;
    private String staffId;
    private boolean staffStatus;

    public MaintenanceStaff(String username, String password, String role, String staffName, String staffId, boolean staffStatus) {
        super(username, password, role);
        this.staffName = staffName;
        this.staffId = staffId;
        this.staffStatus = staffStatus;
    }

    public MaintenanceStaff(String username, String password, String role, String staffId) {
        super(username, password, role);
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public boolean isStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(boolean staffStatus) {
        this.staffStatus = staffStatus;
    }

    @Override
    public void displayRoleSpecificInfo() {
        System.out.println("Staff Name: " + staffName + ", Staff ID: " + staffId + ", Staff Status: " + (staffStatus ? "Free" : "Busy"));
    }

    @Override
    public String toString() {
        return super.toString() + ", Staff Name='" + staffName + '\'' + ", Staff ID='" + staffId + '\'';
    }
}
