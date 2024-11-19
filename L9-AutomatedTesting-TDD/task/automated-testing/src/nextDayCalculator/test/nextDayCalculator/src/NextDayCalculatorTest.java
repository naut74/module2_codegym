package nextDayCalculator.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void nextDay1() {
        int day = 1;
        int month = 1;
        int year = 2018;
        int expectedDay = 2;
        int expectedMonth = 1;
        int expectedYear = 2018;
        String expected = expectedDay + "/" + expectedMonth + "/" + expectedYear;

        String result = NextDayCalculator.calculateNextDay(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    void nextDay2() {
        int day = 31;
        int month = 1;
        int year = 2018;
        int expectedDay = 1;
        int expectedMonth = 2;
        int expectedYear = 2018;
        String expected = expectedDay + "/" + expectedMonth + "/" + expectedYear;

        String result = NextDayCalculator.calculateNextDay(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    void nextDay3() {
        int day = 28;
        int month = 2;
        int year = 2018;
        int expectedDay = 1;
        int expectedMonth = 3;
        int expectedYear = 2018;
        String expected = expectedDay + "/" + expectedMonth + "/" + expectedYear;

        String result = NextDayCalculator.calculateNextDay(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    void nextDay4() {
        int day = 30;
        int month = 4;
        int year = 2018;
        int expectedDay = 1;
        int expectedMonth = 5;
        int expectedYear = 2018;
        String expected = expectedDay + "/" + expectedMonth + "/" + expectedYear;

        String result = NextDayCalculator.calculateNextDay(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    void nextDay5() {
        int day = 29;
        int month = 2;
        int year = 2020;
        int expectedDay = 1;
        int expectedMonth = 3;
        int expectedYear = 2020;
        String expected = expectedDay + "/" + expectedMonth + "/" + expectedYear;

        String result = NextDayCalculator.calculateNextDay(day, month, year);
        assertEquals(expected, result);
    }

    @Test
    void nextDay6() {
        int day = 31;
        int month = 12;
        int year = 2018;
        int expectedDay = 1;
        int expectedMonth = 1;
        int expectedYear = 2019;
        String expected = expectedDay + "/" + expectedMonth + "/" + expectedYear;

        String result = NextDayCalculator.calculateNextDay(day, month, year);
        assertEquals(expected, result);
    }
}