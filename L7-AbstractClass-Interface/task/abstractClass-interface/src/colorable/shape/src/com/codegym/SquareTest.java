package colorable.shape.src.com.codegym;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square(2.0);

        System.out.println("before: ");
        System.out.println(square);

        System.out.println("\nAfter: ");
        System.out.println(square);
        square.howToColor();
    }
}
