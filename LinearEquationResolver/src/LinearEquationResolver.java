import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        double a, b;
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số a ");
        a = sc.nextDouble();
        System.out.println("Nhập vào số b");
        b = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm");
            }
            else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
        else {
            double result = -b/a;
            System.out.println("Phương trình có nghiệm "+result );
        }

    }
}
