public class FizzBuzz {
    public static String fizzBuzzTest(int number) {
        String result = "";
        if (isDivisibleBy35(number)) {
            result = "FizzBuzz";
        } else if (isDivisibleBy3(number)) {
            result = "Fizz";
        } else if (isDivisibleBy5(number)) {
            result = "Buzz";
        } else result = String.valueOf(number);
        return result;
    }

    private static boolean isDivisibleBy5(int number) {
        if (number % 5 == 0) {
            return true;
        } else return false;
    }

    private static boolean isDivisibleBy3(int number) {
        if (number % 3 == 0) {
            return true;
        } else return false;
    }

    private static boolean isDivisibleBy35(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return true;
        } else return false;
    }
}
