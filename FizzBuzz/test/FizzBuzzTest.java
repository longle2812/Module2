import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @org.junit.jupiter.api.Test
    void fizzBuzzTest() {
        int number = 1;
        String expected = "1";
        String result = FizzBuzz.fizzBuzzTest(number);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void fizzBuzzTest1() {
        int number = 3;
        String expected = "Fizz";
        String result = FizzBuzz.fizzBuzzTest(number);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void fizzBuzzTest2() {
        int number = 5;
        String expected = "Buzz";
        String result = FizzBuzz.fizzBuzzTest(number);
        assertEquals(expected, result);
    }
    @org.junit.jupiter.api.Test
    void fizzBuzzTest3() {
        int number = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzz.fizzBuzzTest(number);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void fizzBuzzTest4() {
        int number = 11;
        String expected = "11";
        String result = FizzBuzz.fizzBuzzTest(number);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void fizzBuzzTest5() {
        int number = Integer.MAX_VALUE;
        String expected = "2147483647";
        String result = FizzBuzz.fizzBuzzTest(number);
        assertEquals(expected, result);
    }
}