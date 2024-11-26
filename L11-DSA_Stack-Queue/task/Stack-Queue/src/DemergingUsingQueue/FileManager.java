package DemergingUsingQueue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Person> readDataFromFile(String fileName) throws IOException {
        List<Person> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[0].trim();
            String gender = parts[1].trim();
            String dayOfBirth = parts[2].trim();
            list.add(new Person(name, gender, dayOfBirth));
        }
        reader.close();
        return list;
    }

    public static void writeDataToFile(String fileName, List<Person> data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Person p : data) {
            writer.write(p.toString());
            writer.newLine();
        }
        writer.close();
    }
}
