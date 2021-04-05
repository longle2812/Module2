import java.util.Scanner;

public class Max2dimensionArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row");
        int row = sc.nextInt();
        System.out.println("Enter column");
        int column = sc.nextInt();
        int arr[][] = new int[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.println("Enter "+i+","+j+" value");
                arr[i][j] = sc.nextInt();
            }
        }
        int max = arr[0][0];
        row = 0;
        column = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j =0 ; j <arr[0].length; j++){
                if (arr[i][j] > max ) {
                    max = arr[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        System.out.println("Max number is: " +max+ " at row "+row+", column "+column);
    }
}
