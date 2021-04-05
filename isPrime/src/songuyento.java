import java.util.Scanner;

public class songuyento {
    public static void main(String[] args) {
        int count = 0;
        int i = 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần tìm");
        int numbers = sc.nextInt();
        while (count < numbers) {
            //check
            boolean isPrime = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                System.out.print(i + " ");
            }
            i++;
        }
    }
}
