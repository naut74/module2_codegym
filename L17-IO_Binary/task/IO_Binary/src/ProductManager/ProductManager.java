package ProductManager;

import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static Product addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        return new Product(id, name, price, manufacturer, description);
    }

    public static void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No product available");
        } else {
            for (Product product: products) {
                System.out.println(product);
            }
        }
    }

    public static void searchProduct(List<Product> products, Object keyword) {
        if (products == null || products.isEmpty()) {
            System.out.println("Product list is empty.");
            return;
        }

        boolean found = false;

        for (Product product : products) {
            if (product != null) {
                if (keyword instanceof Integer && product.getId() == (int) keyword) {
                    System.out.println(product);
                    found = true;
                } else if (keyword instanceof String && product.getName().equalsIgnoreCase((String) keyword)) {
                    System.out.println(product);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No product found with keyword: " + keyword);
        }
    }

}
