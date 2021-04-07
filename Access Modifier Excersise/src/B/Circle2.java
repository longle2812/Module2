package B;

import A.Circle;

public class Circle2 extends Circle {
    public static void main(String[] args) {
        Circle2 circle2 = new Circle2();
        System.out.println(circle2.color);
        circle2.setRadius();
        System.out.println(circle2.getRadius());
        System.out.println(circle2.getArea());
    }
}
