import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        double height, weight, bmi;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào cân nặng");
        weight = sc.nextDouble();
        System.out.println("Nhập vào chiều cao");
        height = sc.nextDouble();
        bmi = weight / (height*height);
        if (bmi < 18.5) {
            System.out.println("Bạn quá gầy");
        }
        else if ((18.5 <= bmi) && (bmi < 25.0)) {
            System.out.println("Bạn bình thường");
        }
        else if ((20.5 <= bmi) && (bmi < 30.0)) {
            System.out.println("Bạn hơi mập");
        }
        else if (30.0 <= bmi)  {
            System.out.println("Bạn béo vãi");
        }
    }
}
