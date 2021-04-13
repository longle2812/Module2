import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    void fizzBuzzTranslate() {
        int number = 1;
        String expected = "một";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected,result);
    }

    @Test
    void fizzBuzzTranslate1() {
        int number = 11;
        String expected = "mười một";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected,result);
    }
    @Test
    void fizzBuzzTranslate2() {
        int number = 99;
        String expected = "chín mươi chín";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected,result);
    }

    @Test
    void fizzBuzzTranslate3() {
        int number = 30;
        String expected = "ba mươi";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected,result);
    }
    @Test
    void fizzBuzzTranslate4() {
        int number = 10;
        String expected = "mười";
        String result = FizzBuzzTranslate.fizzBuzzTranslate(number);
        assertEquals(expected,result);
    }
}