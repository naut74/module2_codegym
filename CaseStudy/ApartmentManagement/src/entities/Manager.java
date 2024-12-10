package entities;

public class Manager extends User {
    private String contactInfo;

    public Manager(String username, String password, String role, String contactInfo) {
        super(username, password, role);
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public void displayRoleSpecificInfo() {
        System.out.println("Manager Contact Info: " + contactInfo);
    }

    @Override
    public String toString() {
        return super.toString() + ", Contact Info='" + contactInfo + '\'';
    }
}
