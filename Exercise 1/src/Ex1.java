import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên");
        input = sc.nextInt();
        if (input <= 0) {
            System.out.println("Đây là số nguyên âm");
        }
        else System.out.println("Đây là số nguyên dương");
    }
}
