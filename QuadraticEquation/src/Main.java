import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao a");
        double a = sc.nextDouble();
        System.out.println("Nhap vao b");
        double b = sc.nextDouble();
        System.out.println("Nhap vao c");
        double c = sc.nextDouble();
        QuadraticEquation test = new QuadraticEquation(a, b, c);
        System.out.println(test.result());
    }
}
