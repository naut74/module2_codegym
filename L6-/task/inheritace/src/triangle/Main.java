package triangle;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Triangle triangle = new Triangle(3, 3, 3, "blue", true);

        System.out.println(triangle);
    }
}
