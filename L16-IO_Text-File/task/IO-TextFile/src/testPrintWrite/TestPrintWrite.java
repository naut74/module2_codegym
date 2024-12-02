package testPrintWrite;

import java.io.File;
import java.io.FileNotFoundException;

public class TestPrintWrite {
    public static void main(String[] args) throws FileNotFoundException {
        java.io.File file = new java.io.File("scores.txt");

        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        try (
            java.io.PrintWriter output = new java.io.PrintWriter(file);
        ) {
            output.print("Nguyen Van A ");
            output.println(23);
            output.print("Tran Thi B ");
            output.println(21);
        }
    }
}
