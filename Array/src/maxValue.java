import java.util.Scanner;

public class maxValue {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter size of array");
            size = sc.nextInt();
        }
        while (size > 20);
        array = new int[20];
        int i = 0;
        while (i < size) {
            System.out.println("Enter value of element " + (i + 1) + " :");
            array[i] = sc.nextInt();
            i++;
        }
        System.out.println("The Array is: ");
        for (i = 0; i < size; i++) {
            System.out.printf(" "+ array[i]);
        }
        int max = array[0];
        for (i = 0; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println();
        System.out.println("Max value is: "+max);
    }
}
