package management;

import entities.Apartment;
import utility.FileManagement;

import java.util.ArrayList;
import java.util.List;

public class ApartmentManagement {

    private List<Apartment> apartments = new ArrayList<>();

    public void loadApartmentsFromFile(String filePath) {
        List<String> lines = FileManagement.readFile(filePath);

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length == 4) {
                String apartmentId = data[0];
                String nameBuilding = data[1];
                int floor = Integer.parseInt(data[2]);
                boolean status = Boolean.parseBoolean(data[3]);

                Apartment apartment = new Apartment(apartmentId, nameBuilding, floor, status);
                apartments.add(apartment);
            }
        }
    }

    public List<Apartment> getApartments() {
        List<String> lines = FileManagement.readFile("src/data/apartmentInfoData.txt");
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String apartmentId = parts[0].trim();
                String nameBuilding = parts[1].trim();
                int floor = Integer.parseInt(parts[2].trim());
                boolean status = Boolean.parseBoolean(parts[3].trim());
                Apartment apartment = new Apartment(apartmentId, nameBuilding, floor, status);
                apartments.add(apartment);
            }
        }
        return apartments;
    }

    public void saveApartmentsToFile(String filePathApartmentInfo) {
        List<String> data = new ArrayList<>();

        for (Apartment apartment : apartments) {
            String line = apartment.getApartmentId() + "," + apartment.getNameBuilding() + ","
                    + apartment.getFloor() + "," + apartment.isStatus();
            data.add(line);
        }

        FileManagement.writeFile(filePathApartmentInfo, data, false);
    }

    public void addApartment(String apartmentId, String nameBuilding, int floor, boolean status, String filePath) {
        Apartment newApartment = new Apartment(apartmentId, nameBuilding, floor, status);
        apartments.add(newApartment);
        saveApartmentsToFile(filePath);
        System.out.println("Apartment added successfully.");
    }

    public void updateApartmentStatus(String apartmentId, boolean newStatus, String filePath) {
        apartments = getApartments();
        for (Apartment apartment : apartments) {
            if (apartment.getApartmentId().equals(apartmentId)) {
                apartment.setStatus(newStatus);
                saveApartmentsToFile(filePath);
                System.out.println("Apartment status updated successfully.");
                return;
            }
        }
        System.out.println("Apartment not found.");
    }

    public void removeApartment(String apartmentId, String filePath) {
        apartments = getApartments();
        Apartment targetApartment = null;
        System.out.println("Removing apartment with ID: " + apartmentId);
        for (Apartment apartment : apartments) {
            System.out.println("Checking apartment with ID: " + apartment.getApartmentId().trim());
            if (apartment.getApartmentId().trim().equals(apartmentId.trim())) {
                targetApartment = apartment;
                break;
            }
        }

        if (targetApartment != null) {
            apartments.remove(targetApartment);
            saveApartmentsToFile(filePath);
            System.out.println("Apartment with ID " + apartmentId + " removed successfully.");
        } else {
            System.out.println("Apartment with ID " + apartmentId + " not found.");
        }
    }



    public void viewAllApartments() {
        apartments = getApartments();
        if (apartments.isEmpty()) {
            System.out.println("No apartments available.");
        } else {
            System.out.println("=== Apartment List ===");
            for (Apartment apartment : apartments) {
                System.out.printf("ID: %s, Building: %s, Floor: %d, Status: %s%n",
                        apartment.getApartmentId(),
                        apartment.getNameBuilding(),
                        apartment.getFloor(),
                        apartment.isStatus() ? "Available" : "Occupied");
            }
            System.out.println("======================");
        }
    }

}
