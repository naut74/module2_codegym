package MaxInTextFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File not found or Error!");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Max is: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i : numbers) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src/MaxInTextFile/numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src/MaxInTextFile/result.txt", maxValue);
    }
}
