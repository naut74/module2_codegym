package CopyFileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateCopyFile {
    public void copyToNewFile(String filePathIn, String filePathOut) {
        try {
            File file = new File(filePathIn);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            FileWriter fileWriter = new FileWriter(filePathOut, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Copy from \"Copyright.txt\"\n");
            bufferedWriter.newLine();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File not found or Error!");
        }
    }
}
