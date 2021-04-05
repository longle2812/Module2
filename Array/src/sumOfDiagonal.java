import java.util.Scanner;

public class sumOfDiagonal {
    public static void main(String[] args) {
        int row;
        int column;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row");
        row = sc.nextInt();
        column = row;
        int[][] array = new int[row][column];
        for (int i = 0;i < array.length;i++){
            for (int j = 0; j < array.length; j++){
                System.out.println("Enter "+i+","+j);
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i< array.length; i++) {
            sum += array[i][i];
        }
        System.out.println("Sum is: "+sum);
    }
}
