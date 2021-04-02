import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int number;
        String result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số:");
        number = sc.nextInt();
        switch (number) {
            case 0:
                result = "Không";
                break;
            case 1:
                result = "Một";
                break;
            case 2:
                result = "Hai";
                break;
            case 3:
                result = "Ba";
                break;
            case 4:
                result = "Bốn";
                break;
            case 5:
                result = "Năm";
                break;
            case 6:
                result = "Sáu";
                break;
            case 7:
                result = "Bảy";
                break;
            case 8:
                result = "Tám";
                break;
            case 9:
                result = "Chín";
                break;
            case 10:
                result = "Mười";
                break;
            default:
                result = "Không biết";
                break;
        }
        System.out.println(result);
    }
}
