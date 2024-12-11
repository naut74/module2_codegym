package entities;

public class Apartment {
    private String apartmentId;
    private String nameBuilding;
    private int floor;
    private boolean status;

    public Apartment(String apartmentId, String nameBuilding, int floor, boolean status) {
        this.apartmentId = apartmentId;
        this.nameBuilding = nameBuilding;
        this.floor = floor;
        this.status = status;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public String getNameBuilding() {
        return nameBuilding;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Apartment ID: " + apartmentId + ", Building: " + nameBuilding + ", Floor: " + floor + ", Status: " + (status ? "Rented" : "Available");
    }
}
