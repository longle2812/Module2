import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    public static final String INPUT_DATA = "Nhập vào từ cần tìm";
    public static final String CANNOT_FIND = "Không tìm thấy từ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String[] englishWord = {"dog", "cat", "book"};
//        String[] vietnameseWord = {"chó", "mèo", "sách"};
        System.out.println(INPUT_DATA);
        String wordToFind = sc.nextLine();
//        boolean isWordExist = false;
//        for (int i = 0; i < englishWord.length; i++) {
//            if (englishWord[i].equals(wordToFind)) {
//                System.out.println(vietnameseWord[i]);
//                isWordExist = true;
//                break;
//            }
//        }
//        if (!isWordExist) {
//            System.out.println(CANNOT_FIND);
//        }
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("dog","chó");
        dictionary.put("cat","mèo");
        dictionary.put("chicken","gà");
        for (Map.Entry<String,String> x: dictionary.entrySet()) {


        }
    }
}
