import javax.swing.*;

public class MineSweeper {
    public static void main(String[] args) {
        String[][] arr = {{"*", ".", ".", "."}, {".", ".", ".", "."}, {".", "*", ".", "."}, {".", ".", ".", "."}};
        int[][] arr1 = new int[arr.length - 1][arr.length - 1];
        int row;
        int col;
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                int count = 0;
                int[][] check = {{row - 1,col - 1},
                        {row - 1,col},
                        {row - 1,col + 1},
                        {row,col - 1},
                        {row,col + 1},
                        {row + 1,col - 1},
                        {row + 1,col},
                        {row + 1,col + 1}};
                for (int i = 0; i < check.length;i++){
                    int checkRow = check[i][0];
                    int checkCol = check[i][1];
                    if ((checkRow >= 0)
                            && (checkRow < arr[row].length)
                            && (checkCol>= 0)
                            && (checkCol < arr.length)) {
                        if (arr[checkRow][checkCol].equals("*")) {
                            count++;
                        }
                    }
                }
                if (!arr[row][col].equals("*")){
                    System.out.print(count);
                }
                else System.out.print("*");

            }
            System.out.println();
        }
    }
}
