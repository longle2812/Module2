public class addElement {
    public static void main(String[] args) {
        int[] arr = {1,2,4,4,5,1,2,1};
        int[] newArr = new int[arr.length+1];
        int number = 9;
        int index = 3;
        int i = 0;
        int j = 0;
        while (j < newArr.length){
            if (i != index) {
                newArr[j] = arr[i];
                i++;
            }
            else {
                newArr[j] = number;
                index = -1;
            }
            j++;
        }
        for (i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+ " ");
        }
    }
}
