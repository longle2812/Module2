import java.util.Scanner;

public class sumOfColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = {{1, 2, 3}, {1, 2, 3}, {1, 3, 4}};
        System.out.println("Enter the column:");
        int column = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][column];
        }
        System.out.println("Total is:" + sum);
    }
}
