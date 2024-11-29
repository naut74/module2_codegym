package IllegalTriangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalTriangleExceptionHandle {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter side1: ");
            int side1 = scanner.nextInt();
            System.out.print("Enter side2: ");
            int side2 = scanner.nextInt();
            System.out.print("Enter side3: ");
            int side3 = scanner.nextInt();

            Triangle.checkTriangle(side1, side2, side3);
            System.out.println("Is a Triangle");
        } catch (IllegalTriangleExceptionHandle e) {
            System.err.println("Error! " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown Error!" + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Finished program");
        }
    }
}
