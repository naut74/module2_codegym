package entities;

public class Resident extends User {
    private String residentName;
    private String apartmentId;
    private String rentalTime;

    public Resident(String username, String password, String role, String residentName, String apartmentId, String rentalTime) {
        super(username, password, role);
        this.residentName = residentName;
        this.apartmentId = apartmentId;
        this.rentalTime = rentalTime;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getRentalTime() {
        return rentalTime;
    }

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
