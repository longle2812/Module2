public class minValue {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, -1, 1, 6, 9};
        System.out.println("The smallest element in the array is: " + minValue(arr));
    }

    public static int minValue(int array[]) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

}
