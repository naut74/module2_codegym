package ProductManager;

public class MainUsingArrayList {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(new Product(1, "Laptop", 1500.0));
        productManager.addProduct(new Product(2, "Smartphone", 800.0));
        productManager.addProduct(new Product(3, "Tablet", 500.0));

        productManager.displayProducts();

        productManager.editProduct(2, "Smartphone Pro", 1000.0);
        productManager.displayProducts();

        productManager.deleteProduct(3);
        productManager.displayProducts();

        productManager.searchProduct("Laptop");

        productManager.sortProductsByPrice(true);

        productManager.sortProductsByPrice(false);
    }
}
