package absoluteNumberCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbsoluteNumberCalculatorTest {

    @Test
    void findAbsolute1() {
        int number = 0;
        int expected = 0;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

    @Test
    void findAbsolute2() {
        int number = -1;
        int expected = 1;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

    @Test
    void findAbsolute3() {
        int number = 1;
        int expected = 1;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

    @Test
    void findAbsolute4() {
        int number = -20;
        int expected = 20;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }
}