import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String test = "abcdselaksmf";
        System.out.println("Enter character");
        char input = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < test.length(); i++){
            if (test.charAt(i) == input  ) {
                count++;
            }
        }
        System.out.println(count);
    }
}
