import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {2,5,7,3,5,7,2,1,3};
        Arrays.sort(array);
        System.out.println(binarySearch(array, 0, array.length-1, 2 ));
    }

    public static int binarySearch(int[] array, int left, int right, int value){
        int middle = (left + right)/2;
        if (right > left) {
            if (array[middle] == value) {
                return middle;
            }
            if (array[middle] < value) {
                left = middle+1;
                binarySearch(array, left, right, value);
            } else if (array[middle] > value) {
                right = middle - 1;
                binarySearch(array, left, right, value);
            }
        }
        return -1;
    }
}
