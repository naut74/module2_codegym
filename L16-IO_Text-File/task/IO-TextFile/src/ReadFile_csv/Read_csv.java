package ReadFile_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Read_csv {
    public static List<String> readDataFromFile(String filePathIn) {
        List<String> list = new ArrayList<>();
        try {
            File fileData = new File(filePathIn);

            if (!fileData.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileData));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                list.add(parts[2]);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File not found or Error!");
        }
        return list;
    }

    public static void writeFile(String filePathOut, List<String> list) {
        try {
            FileWriter writer = new FileWriter(filePathOut, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("List of country in file \"country.csv\" is:\n" + list);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
