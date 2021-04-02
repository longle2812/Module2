import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên:");
        number = sc.nextInt();
        if ((number % 3 == 0) && (number % 5 == 0)) {
            System.out.println("FIZZBUZZ");
        }
        else if (number % 3 == 0) {
            System.out.println("FIZZ");
        }
        else if (number % 5 == 0) {
            System.out.println("BUZZ");
        }
    }
}
