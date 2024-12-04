package BinaryFileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinaryFileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source file path: ");
        String sourceFile = scanner.nextLine();

        System.out.print("Enter target file path: ");
        String targetFile = scanner.nextLine();

        File source = new File(sourceFile);
        File target = new File(targetFile);

        if (!source.exists()) {
            System.out.println("File not found!");
            return;
        }

        if (target.exists()) {
            System.out.print("The target file already exists! Please choose a different name or delete the existing file");
            return;
        }

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("copy completed! number of bytes copied " + totalBytes);
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
}
