import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year;
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập năm muốn kiểm tra");
        year = sc.nextInt();
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0){
                    check = true;
                }
                else check = false;
            }
            else check = true;
        }
        if (check) {
            System.out.println("Năm "+ year+ " là năm nhuận");
        }
        else System.out.println("Năm "+ year+ " không là năm nhuận");
    }
}
