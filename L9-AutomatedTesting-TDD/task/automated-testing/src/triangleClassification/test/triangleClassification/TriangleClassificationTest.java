package triangleClassification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassificationTest {

    @Test
    void triangleCheck() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 2;
        String expected = "Equilateral Triangle";
        String result = TriangleClassification.triangleCheck(side1, side2, side3);
        assertEquals(expected, result);
    }

    @Test
    void triangleCheck1() {
        int side1 = 2;
        int side2 = 2;
        int side3 = 3;
        String expected = "Isosceles Triangle";
        String result = TriangleClassification.triangleCheck(side1, side2, side3);
        assertEquals(expected, result);
    }

    @Test
    void triangleCheck2() {
        int side1 = 4;
        int side2 = 5;
        int side3 = 3;
        String expected = "Normal Triangle";
        String result = TriangleClassification.triangleCheck(side1, side2, side3);
        assertEquals(expected, result);
    }

    @Test
    void triangleCheck3() {
        int side1 = 8;
        int side2 = 2;
        int side3 = 3;
        String expected = "Not a Triangle!!!";
        String result = TriangleClassification.triangleCheck(side1, side2, side3);
        assertEquals(expected, result);
    }

    @Test
    void triangleCheck4() {
        int side1 = 0;
        int side2 = 1;
        int side3 = 1;
        String expected = "Not a Triangle!!!";
        String result = TriangleClassification.triangleCheck(side1, side2, side3);
        assertEquals(expected, result);
    }

}