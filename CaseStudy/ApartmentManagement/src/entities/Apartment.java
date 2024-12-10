package entities;

public class Apartment {
    private String roomId;
    private String status;
    private double price;

    public Apartment(String roomId, String status, double price) {
        this.roomId = roomId;
        this.status = status;
        this.price = price;
    }
}
