package management;

import entities.Apartment;
import entities.Resident;
import utility.FileManagement;

import java.util.ArrayList;
import java.util.List;

public class ResidentsManagement {
    public static final String SRC_DATA_USER_INFO = "src/data/loginData.txt";
    private List<Resident> residents = new ArrayList<>();

    public List<Resident> getResidents() {
        List<String> lines = FileManagement.readFile(SRC_DATA_USER_INFO);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 6 && parts[2].equals("resident")) {
                String username = parts[0];
                String password = parts[1];
                String role = parts[2];
                String residentName = parts[3];
                String apartmentId = parts[4];
                String rentalTime = parts[5];
                Resident resident = new Resident(username, password, role, residentName, apartmentId, rentalTime);
                residents.add(resident);
            }
        }
        return residents;
    }

    public void saveResidentsToFile(String fileResidentInfo, boolean statusAppend) {
        List<String> data = new ArrayList<>();

        for (Resident resident : residents) {
            String line = resident.getUsername() + ","
                    + resident.getPassword() + ","
                    + resident.getRole() + ","
                    + resident.getResidentName() + ","
                    + resident.getApartmentId() + ","
                    + resident.getRentalTime();
            data.add(line);
        }

        FileManagement.writeFile(fileResidentInfo, data, statusAppend);
    }

    public void addResident(String username, String password, String role, String residentName, String residentApartment, String rentalTime) {
        Resident newResident = new Resident(username, password, role, residentName, residentApartment, rentalTime);
        residents.add(newResident);
        saveResidentsToFile(SRC_DATA_USER_INFO, true);
        System.out.println("Resident added successfully.");
    }

    public void removeResident(String apartmentId, String filePathDataUser) {
        List<String> lines = FileManagement.readFile(filePathDataUser);
        List<String> updatedLines = new ArrayList<>();

        boolean residentRemoved = false;

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 5 && parts[2].equals("resident")) {
                if (!parts[4].equals(apartmentId)) {
                    updatedLines.add(line);
                } else {
                    residentRemoved = true;
                }
            } else {
                updatedLines.add(line);
            }
        }

        FileManagement.writeFile(filePathDataUser, updatedLines, false);

        if (residentRemoved) {
            System.out.println("Resident with apartmentID " + apartmentId + " removed successfully.");
        } else {
            System.out.println("Resident with apartmentID " + apartmentId + " not found or not a resident.");
        }
    }


    public void viewResidentsList() {
        residents = getResidents();
        System.out.println("===== RESIDENT LIST =====");
        if (residents.isEmpty()) {
            System.out.println("No residents found.");
        } else {
            for (Resident resident : residents) {
                System.out.printf("Apartment ID: %s, Resident Name: %s, Rental Time: %s%n",
                        resident.getApartmentId(),
                        resident.getResidentName(),
                        resident.getRentalTime()
                );
            }
            System.out.println("========================");
        }
    }

    public void setPersonalInfo() {
        System.out.println("Set something");
    }
}
