package Resizeable;

public class ResizeableTest {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Square square = new Square(4);

        System.out.println("Before resizing:");
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

        circle.resize(50); // Tăng bán kính lên 50%
        rectangle.resize(25); // Tăng kích thước lên 25%
        square.resize(10); // Tăng cạnh lên 10%

        System.out.println("\nAfter resizing:");
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);
    }
}
