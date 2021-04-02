import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chiều dài");
        float height = sc.nextFloat();
        System.out.println("Nhập vào chiều rộng");
        float width = sc.nextFloat();
        System.out.println("Diện tích là: "+ height * width);
    }
}
