package ProductManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void writeProductsToFile(String path, List<Product> products) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.err.println("Error while writing products to files: " + e.getMessage());
        }
    }

    public static List<Product> readProductsFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while reading products from file: " + e.getMessage());
        }
        return products;
    }
}
