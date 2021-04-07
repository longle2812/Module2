package A;

public class Circle {
    public static double radius = 1.0;
    public static String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        radius = radius;
    }

    protected static double getArea() {
        return Math.pow(radius, 2) * 3.14;
    }

    public static double getRadius() {
        return radius;
    }

    protected static void setRadius(){
        radius = 20;
    }
}
