public class Triangle {
    public static String typeOfTriangle(double a, double b, double c) {
        String result = "không phải là tam giác";
        if (isTriangle(a, b, c)) {
            if (isEquilateralTriangle(a, b, c)) {
                result = "tam giác đều";
            } else if (isIsocolesTriangle(a, b, c)) {
                result = "tam giác cân";
            } else result = "tam giác thường";
        }
        return result;
    }

    private static boolean isIsocolesTriangle(double a, double b, double c) {
        if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
            return true;
        } else return false;
    }

    private static boolean isEquilateralTriangle(double a, double b, double c) {
        if (a == b && b == c) {
            return true;
        } else return false;
    }

    private static boolean isTriangle(double a, double b, double c) {
        if (a + b > c && b + c > a && a + c > b) {
            return true;
        } else return false;
    }

}
