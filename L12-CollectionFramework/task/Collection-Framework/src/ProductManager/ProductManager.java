package ProductManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product " + product.getId() + " added");
    }

    public void editProduct(int id, String newName, double newPrice) {
        for (Product product : productList) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                System.out.println("Product updated " + product);
                return;
            }
        }
    }

    public void deleteProduct(int id) {
        Product productToRemove = null;
        for (Product product : productList) {
            if (product.getId() == id) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            productList.remove(productToRemove);
            System.out.println("Product deleted " + productToRemove);
        } else {
            System.out.println("Not found product " + id);
        }
    }

    public void displayProducts() {
        System.out.println("\nProduct list:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void searchProduct(String name) {
        System.out.println("\nSearch results for product " + name);
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(product);
            }
        }
    }

    public void sortProductsByPrice(boolean ascending) {
        if (ascending) {
            productList.sort(Comparator.comparingDouble(Product::getPrice));
        } else {
            productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        }
        System.out.println("\nProducts sorted by price " + (ascending ? "ascending" : "decreasing") + ":");
        displayProducts();
    }
}
