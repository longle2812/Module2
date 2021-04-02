import java.util.Scanner;

public class Exchange {
    public static void main(String[] args) {
        int rate = 23000;
        int USD = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập USD");
        USD = sc.nextInt();
        int result = USD * rate;
        System.out.println(result);
    }
}
