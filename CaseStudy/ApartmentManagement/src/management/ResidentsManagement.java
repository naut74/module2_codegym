package management;

import entities.Apartment;
import entities.Resident;
import utility.FileManagement;

import java.util.ArrayList;
import java.util.List;

public class ResidentsManagement {
    private static final String ROLE_RESIDENT = "Resident";
    private List<Resident> residents = new ArrayList<>();

    public void loadResidentsFromFile(String filePath) {
        List<String> lines = FileManagement.readFile(filePath);

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length == 4) {
                String residentName = data[0];
                String residentApartmentId = data[1];
                String rentalTime = data[2];
                String username = residentName;
                Resident resident = new Resident(username, ROLE_RESIDENT, residentApartmentId, rentalTime);
                residents.add(resident);
            }
        }
    }

    public List<Resident> getResidents() {
        List<String> lines = FileManagement.readFile("src/data/apartmentInfoData.txt");
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String residentName = parts[0];
                String residentApartmentId = parts[1];
                String rentalTime = parts[2];
                String username = residentName;
                Resident resident = new Resident(username, ROLE_RESIDENT, residentApartmentId, rentalTime);
                residents.add(resident);
            }
        }
        return residents;
    }

    public void saveApartmentsToFile(String filePathApartmentInfo) {
        List<String> data = new ArrayList<>();

        for (Resident resident : residents) {
            String line = resident.getUsername() + "," + resident.getApartmentId() + ","
                    + resident.getRentalTime();
            data.add(line);
        }

        FileManagement.writeFile(filePathApartmentInfo, data, false);
    }

    public void addResident(String residentName, String residentApartment,String rentalTime) {

    }

    public void removeResident() {

    }

    public void viewResidentsList() {

    }

    public void setPersonalInfo() {
        System.out.println("Set something");
    }
}
