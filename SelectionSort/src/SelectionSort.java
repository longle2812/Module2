public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        System.out.println("Before");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        selectionSort(list);
        System.out.println();
        System.out.println("After");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    private static void selectionSort(double[] list) {
        for (int i = 0; i < list.length-1; i++) {
            for (int j = i+1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    double temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
