package entities;

public class Resident extends User {
    private String apartmentId;

    public Resident(String username, String password, String role, String apartmentId) {
        super(username, password, role);
        this.apartmentId = apartmentId;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public void displayRoleSpecificInfo() {
        System.out.println("Resident of Apartment ID: " + apartmentId);
    }

    @Override
    public String toString() {
        return super.toString() + ", Apartment ID='" + apartmentId + '\'';
    }
}
