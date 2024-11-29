package IllegalTriangle;

public class Triangle {
    public static void checkTriangle(int side1, int side2, int side3) throws IllegalTriangleExceptionHandle {
        if ( side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleExceptionHandle("Not is a Triangle!");
        }
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalTriangleExceptionHandle("Side must greater than 0");
        }
    }
}
