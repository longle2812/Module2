import java.util.Scanner;

public class findValue {
    public static void main(String[] args) {
        String[] students = {"Long", "Thanh", "Duyet", "Tri"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a student's name");
        String input_name = sc.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Position of the students in the list " + input_name + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Not found" + input_name + " in the list.");
    }
}
