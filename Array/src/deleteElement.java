public class deleteElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] newArray = new int[array.length];
        int index = -1;
        int newIndex = 0;
        int number = 5;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != number) {
                    newArray[newIndex] = array[i];
                    newIndex++;
                }
            }
        }
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]+ " ");
        }
    }
}
