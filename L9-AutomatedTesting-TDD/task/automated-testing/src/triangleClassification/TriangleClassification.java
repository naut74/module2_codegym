package triangleClassification;

public class TriangleClassification {
    public static String triangleCheck(int side1, int side2, int side3) {
        if (side1>0&&side2>0&&side3>0){
            if (side1 == side2 && side2 == side3 ) {
                return "Equilateral Triangle";
            } else if (side1 == side2 || side2 == side3 || side1 == side3) {
                return "Isosceles Triangle";
            } else if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
                return "Normal Triangle";
            } else {
                return "Not a Triangle!!!";
            }
        }
        return "Not a Triangle!!!";
    }
}
