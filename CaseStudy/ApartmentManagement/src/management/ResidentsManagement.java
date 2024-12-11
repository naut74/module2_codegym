package management;

import entities.Apartment;
import entities.Resident;
import utility.FileManagement;

import java.util.ArrayList;
import java.util.List;

public class ResidentsManagement {
    public static final String SRC_DATA_USER_INFO = "src/data/test.txt";
    private List<Resident> residents = new ArrayList<>();

    public List<Resident> getResidents() {
        List<String> lines = FileManagement.readFile(SRC_DATA_USER_INFO);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
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

    public void saveResidentsToFile(String fileResidentInfo) {
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

        FileManagement.writeFile(fileResidentInfo, data, true);
    }

    public void addResident(String username, String password, String role, String residentName, String residentApartment, String rentalTime) {
        Resident newResident = new Resident(username, password, role, residentName, residentApartment, rentalTime);
        residents.add(newResident);
        saveResidentsToFile(SRC_DATA_USER_INFO);
        System.out.println("Resident added successfully.");
    }

    public void removeResident(String apartmentId, String filePathDataUser) {
        residents = getResidents();
        Resident targetResident = null;
        for (Resident resident : residents) {
            if (resident.getApartmentId().equals(apartmentId)) {
                targetResident = resident;
                break;
            }
        }

        if (targetResident != null) {
            residents.remove(targetResident);
            saveResidentsToFile(filePathDataUser);
            System.out.println("Resident with apartmentID " + apartmentId + " removed successfully");
        } else {
            System.out.println("Apartment with apartmentID " + apartmentId + " not found.");
        }
    }

    public void viewResidentsList() {

    }

    public void setPersonalInfo() {
        System.out.println("Set something");
    }
}
