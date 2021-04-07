import java.util.Scanner;

public class testRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height");
        double height = sc.nextDouble();
        System.out.println("Enter width");
        double width = sc.nextDouble();
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(height);
        rectangle.setWidth(width);
        System.out.println(rectangle.display());
        System.out.println("Area: "+ rectangle.getArea());
        System.out.println("Perimeter:" + rectangle.getPerimeter());
        System.out.println(rectangle);
    }
}
