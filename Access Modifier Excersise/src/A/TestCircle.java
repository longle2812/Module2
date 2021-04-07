package A;

import A.Circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 10;
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
    }
}
