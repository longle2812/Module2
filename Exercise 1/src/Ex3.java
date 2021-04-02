import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        double a, b, c;
        boolean check = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào số thứ nhất");
        a = sc.nextDouble();
        System.out.println("Nhập vào số thứ hai");
        b = sc.nextDouble();
        System.out.println("Nhập vào số thứ ba");
        c = sc.nextDouble();

        if ((a > 0) && (b > 0) && (c > 0)) {
            if ((a + b > c)
                    && (a + c > b)
                    && (b + c > a)) {
                check = true;
            }
        }

        if (check) {
            System.out.println("3 số là cạnh của tam giác");
        } else System.out.println("3 số không phải cạnh của tam giác");
    }
}
