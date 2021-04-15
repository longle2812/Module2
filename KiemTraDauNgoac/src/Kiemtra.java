import java.util.Stack;

public class Kiemtra {
    public static void main(String[] args) {
        String string = "s * (s – a) * (s – b * (s – c)   ";
        Stack bStack = new Stack();
        boolean check = true;
        int index = 0;
        while (index < string.length()) {
            char sym = string.charAt(index);
            if (sym == '(') {
                bStack.add(sym);
            } else if (sym == ')') {
                if (bStack.size() == 0) {
                    check = false;
                    break;
                } else {
                    char left = (char) bStack.pop();
                    if (left == sym) {
                        check = false;
                    }
                }
            }
            index++;
        }
        if (check && bStack.size() == 0) {
            System.out.println("well");
        } else System.out.println("failed");
    }
}
