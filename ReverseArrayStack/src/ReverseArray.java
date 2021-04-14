import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        int[] array1 = new int[array.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = stack.pop();
        }

        for (int element :
                array1) {
            System.out.print(element + " ");
        }
    }
}
