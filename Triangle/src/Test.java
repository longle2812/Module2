import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài cạnh 1");
        double side1 = sc.nextDouble();
        System.out.println("Nhập độ dài cạnh 2");
        double side2 = sc.nextDouble();
        System.out.println("Nhập độ dài cạnh 3");
        double side3 = sc.nextDouble();
        System.out.println("Nhập màu sắc");
        String color = sc.next();
        Triangle triangle1 = new Triangle();
        Triangle triangle = new Triangle(side1, side2, side3, color);
        System.out.println(triangle);
    }
}
