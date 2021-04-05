public class addArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        for (int j = 0; j < arr1.length; j++) {
            arr3[i] = arr1[j];
            i++;
        }
        for (int j = 0; j < arr2.length; j++) {
            arr3[i] = arr2[j];
            i++;
        }
        for (int j = 0; j < arr3.length; j++) {
            System.out.print(arr3[j] + " ");
        }
    }
}
