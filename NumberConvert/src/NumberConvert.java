import java.util.Scanner;
import java.util.Stack;

public class NumberConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.println("Nhập number");
        int number = sc.nextInt();
        int phanDu;
        while (number != 0) {
            phanDu = number % 2;
            number = number / 2;
            stack.push(phanDu);
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}
