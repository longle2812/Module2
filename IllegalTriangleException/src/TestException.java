import java.util.Scanner;

public class TestException {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner sc = new Scanner(System.in);
        double side1, side2, side3;
            System.out.println("Nhập cạnh 1");
            side1 = sc.nextDouble();
            if (side1 < 0) {
                throw new IllegalTriangleException(side1);
            }
            System.out.println("Nhập cạnh 2");
            side2 = sc.nextDouble();
            if (side2 < 0) {
                throw new IllegalTriangleException(side1);
            }
            System.out.println("Nhập cạnh 3");
            side3 = sc.nextDouble();
            if (side3 < 0) {
                throw new IllegalTriangleException(side1);
            }
        Triangle triangle = new Triangle(side1, side2, side3);
    }
}
