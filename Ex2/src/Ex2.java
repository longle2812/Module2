import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int number;
        do {
            System.out.println("Welcome!");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số chẵn lẻ");
            System.out.println("3. Kiểm ra số chính phương");
            System.out.println("4. Thoát chương trình");
            System.out.print("Chọn chương trình số: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào số cần kiểm tra");
                    number = sc.nextInt();
                    if (isPrime(number)) {
                        System.out.println(number + " là số nguyên tố");
                    } else System.out.println(number + " không phải số nguyên tố");
                    break;
                case 2:
                    System.out.println("Nhập vào số cần kiểm tra");
                    number = sc.nextInt();
                    if (isOdd(number)) {
                        System.out.println(number + " là số lẻ");
                    } else System.out.println(number + " là số chẵn");
                    break;
                case 3:
                    System.out.println("Nhập vào số cần kiểm tra");
                    number = sc.nextInt();
                    if (isSquareNumber(number)) {
                        System.out.println(number + " là số chính phương");
                    } else System.out.println(number + " không là số chính phương");
                    break;
            }
        }
        while (choice != 4);
    }

    public static boolean isPrime(int number) {
        boolean check = true;
        if (number < 2) {
            check = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    public static boolean isOdd(int number) {
        if (number % 2 == 0) {
            return false;
        } else return true;
    }

    public static boolean isSquareNumber(int number) {
        boolean check = false;
        for (int i = 0; i < Math.sqrt(number) + 1; i++) {
            if (i * i == number) {
                check = true;
                break;
            }
        }
        return check;
    }

}
