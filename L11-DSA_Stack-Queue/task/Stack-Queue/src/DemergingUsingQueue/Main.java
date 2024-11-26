package DemergingUsingQueue;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src/DemergingUsingQueue/employees.txt";
        String outputFile = "src/DemergingUsingQueue/employees_sorted.txt";

        try {
            List<Person> records = FileManager.readDataFromFile(inputFile);

            DemergingProcessor processor = new DemergingProcessor();
            processor.process(records);
            List<Person> sortedRecord = processor.getSortedData();
            FileManager.writeDataToFile(outputFile, sortedRecord);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
