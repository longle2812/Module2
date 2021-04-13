public class FizzBuzz implements ConstStorage {
    public static String fizzBuzzTest(int number) {
        String result;
//        boolean isDivisibleBy3 = number % 3 == 0;
//        boolean isDivisibleBy5 = number % 5 == 0;
//        boolean isDivisibleBy3And5 = isDivisibleBy3 && isDivisibleBy5;

        if (isDivisibleBy3And5(number)) {
            result = fizzBuzz;
        } else if (isDivisibleBy3(number)) {
            result = fizz;
        } else if (isDivisibleBy5(number)) {
            result = buzz;
        } else result = String.valueOf(number);
        return result;
    }

    private static boolean isDivisibleBy5(int number) {
        return number % 5 == 0;
    }

    private static boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    private static boolean isDivisibleBy3And5(int number) {
        return number % 3 == 0 && number % 5 == 0;
    }
}
