import java.util.Arrays;

public class InsertionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void main(String[] args) {
        System.out.println("Before");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        insertionSort(list);
        System.out.println();
        System.out.println("After");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

    }

    private static void insertionSort(double[] list) {
        for (int i = 1; i < list.length; i++) {
            int pos = i;
            double x = list[i];
            while (pos > 0 && x < list[pos-1]){
                list[pos] = list[pos-1];
                pos--;
            }
            list[pos] = x;
            System.out.println(Arrays.toString(list));
        }
    }

}
