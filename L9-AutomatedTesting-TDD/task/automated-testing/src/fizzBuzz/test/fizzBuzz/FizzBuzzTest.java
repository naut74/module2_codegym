package fizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void fizzBuzz() {
        int number = 3;
        String expected = "Fizz";
        String result = FizzBuzz.findFizzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    void fizzBuzz1() {
        int number = 5;
        String expected = "Buzz";
        String result = FizzBuzz.findFizzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    void fizzBuzz2() {
        int number = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzz.findFizzBuzz(number);
        assertEquals(expected, result);
    }
}