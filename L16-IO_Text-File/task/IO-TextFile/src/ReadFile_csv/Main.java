package ReadFile_csv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePathIn = "src/ReadFile_csv/country.csv";
        String filePathOut = "src/ReadFile_csv/countryOnly.txt";

        List<String> result = Read_csv.readDataFromFile(filePathIn);
        Read_csv.writeFile(filePathOut, result);
    }
}
