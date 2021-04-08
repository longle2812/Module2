public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        Circle circle1 = new Circle(2.0,"green");
        System.out.println(circle1);
        System.out.println("Area: "+circle1.getArea());

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        Cylinder cylinder1 = new Cylinder(3.0,"blue", 2.0);
        System.out.println(cylinder1);
        System.out.println("Area: " +cylinder1.getArea());
        System.out.println("Volume: "+cylinder1.getVolume());
    }

}
