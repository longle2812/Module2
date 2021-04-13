public class FizzBuzzTranslate {
    public static String fizzBuzzTranslate(int number) {
        String result = "";
        boolean isLessThan10 = number > 0 && number < 10;
        boolean isLessThan100 = number < 100;

        if (isLessThan10) {
            result = readSmallNumber(number);
        } else {
            if (isLessThan100) {
                result = readLargeNumber(number);
            }
        }
        return result;
    }

    private static String readLargeNumber(int number) {
        int phanDonVi = number % 10;
        int phanChuc = number / 10;
        String result = "";
        switch (phanChuc) {
            case 1:
                result = "mười";
                break;
            case 2:
                result = "hai mươi";
                break;
            case 3:
                result = "ba mươi";
                break;
            case 4:
                result = "bốn mươi";
                break;
            case 5:
                result = "năm mươi";
                break;
            case 6:
                result = "sáu mươi";
                break;
            case 7:
                result = "bảy mươi";
                break;
            case 8:
                result = "tám mươi";
                break;
            case 9:
                result += "chín mươi";
                break;
        }
        if (phanDonVi == 0) {
            return result;
        } else return result + " " + readSmallNumber(phanDonVi);
    }

    private static String readSmallNumber(int number) {
        String result = "";
        switch (number) {
            case 0:
                break;
            case 1:
                result += "một";
                break;
            case 2:
                result += "hai";
                break;
            case 3:
                result += "ba";
                break;
            case 4:
                result += "bốn";
                break;
            case 5:
                result += "năm";
                break;
            case 6:
                result += "sáu";
                break;
            case 7:
                result += "bảy";
                break;
            case 8:
                result += "tám";
                break;
            case 9:
                result += "chín";
                break;
        }
        return result;
    }
}
