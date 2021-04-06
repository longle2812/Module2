public class deleteElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 5, 7, 4, 9,5,9,0,5,5,7,8};
        int num = 5;
        boolean check = false;
        int index = 0;
        int temp = 0;
        int count = 0;
        for (int i =0 ; i < array.length-count-1; i ++) {
            if (array[i] == num && array[i+count] == num && (i+count != i)) {
                if (array[i+count+1] == num && array[i] == num) {
                    count++;
                    i--;
                }
                else {
                    temp = array[i];
                    array[i] = array[i + count + 1];
                    array[i + count + 1] = temp;
                }
            }
            if (array[i] == num && array[i+1] != num){
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                count++;
            }
        }
        for (int i:
             array) {
            System.out.print(i+ " ");
        }

//        int[] newArray = new int[array.length];
//        int index = -1;
//        int newIndex = 0;
//        int number = 5;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == number) {
//                index = i;
//                break;
//            }
//        }
//        if (index != -1) {
//            for (int i = 0; i < array.length; i++) {
//                if (array[i] != number) {
//                    newArray[newIndex] = array[i];
//                    newIndex++;
//                }
//            }
//        }
//        for (int i = 0; i < newArray.length; i++) {
//            System.out.print(newArray[i]+ " ");
//        }
    }
}
