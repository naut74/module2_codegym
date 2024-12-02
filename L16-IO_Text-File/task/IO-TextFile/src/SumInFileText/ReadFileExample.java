package SumInFileText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.print(line + " ");
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println("\nSum = " + sum);
        } catch (Exception e) {
            System.err.println("File not found or error!");
        }
    }
}
