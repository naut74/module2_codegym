import ProductManager.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ProductManager.ProductManager.*;

public static void main(String[] args) {
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int choice;
    do {
        System.out.println("\n=== Product Management ===");
        System.out.println("1. Add Product");
        System.out.println("2. Display Products");
        System.out.println("3. Search Product");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Product newProduct = addProduct();
                products.add(newProduct);
                break;
            case 2:
                displayProducts(products);
                break;
            case 3:
                System.out.println("Search by:");
                System.out.println("1. ID");
                System.out.println("2. Name");
                System.out.print("Enter your choice: ");
                int searchChoice = Integer.parseInt(scanner.nextLine());

                if (searchChoice == 1) {
                    System.out.print("Enter product ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    searchProduct(products, id);
                } else if (searchChoice == 2) {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    searchProduct(products, name);
                } else {
                    System.out.println("Invalid choice for search.");
                }
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 4);
}

