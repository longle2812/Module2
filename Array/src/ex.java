public class ex {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 8, 6, 5},
                {3, 4, 1, 2},
                {2, 4, 7, 4}
        };
        int count = 0;
        for (int j = 0; j < arr[0].length; j++, count = 0) {
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i][j]) % 2 == 0) {
                    count++;
                }
            }
            System.out.println("Cot " + j + " co " + count + " so chan");
        }
    }
}
