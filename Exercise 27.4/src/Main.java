import java.util.Scanner;

public class Main {

    public static final String STUDENT_MANAGEMENT = "Student Management";
    public static final String SHOW_STUDENT_LIST = "1. Show student list";
    public static final String ADD_NEW_STUDENT = "2. Add new student";
    public static final String EDIT_STUDENT_INFORMATION = "3. Edit student information";
    public static final String DELETE_A_STUDENT = "4. Delete a student";
    public static final String SORT_BY_MARK = "5. Sort by mark";
    public static final String FIND_BY_ID = "6. Find by ID";
    public static final String LIST_STUDENT_BY_CLASS = "7. List student by Class";
    public static final String IMPORT_FILE = "8. Import file";
    public static final String EXPORT_FILE = "9. Export file";
    public static final String FIND_HIGHEST_MARK_STUDENT = "10. Find highest mark student";
    public static final String EXIT = "0. Exit";
    public static final String ENTER_YOUR_CHOICE = "Enter your choice:";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.init();
        studentManagement.sortByID();
        userChoice(sc, studentManagement);
    }

    private static void userChoice(Scanner sc, StudentManagement studentManagement) {
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    studentManagement.showList();
                    break;
                case 2:
                    studentManagement.addNewStudent();
                    studentManagement.sortByID();
                    break;
                case 3:
                    studentManagement.editStudentInfo();
                    break;
                case 4:
                    studentManagement.deleteStudentInfo();
                    break;
                case 5:
                    studentManagement.sortByMark();
                    break;
                case 6:
                    studentManagement.searchStudent();
                    break;
                case 7:
                    studentManagement.listStudentByClass();
                    break;
                case 8:
                    studentManagement.readFile();
                    break;
                case 9:
                    studentManagement.writeFile();
                    break;
                case 10:
                    studentManagement.findHighestMark();
                    break;
            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println(STUDENT_MANAGEMENT);
        System.out.println(SHOW_STUDENT_LIST);
        System.out.println(ADD_NEW_STUDENT);
        System.out.println(EDIT_STUDENT_INFORMATION);
        System.out.println(DELETE_A_STUDENT);
        System.out.println(SORT_BY_MARK);
        System.out.println(FIND_BY_ID);
        System.out.println(LIST_STUDENT_BY_CLASS);
        System.out.println(IMPORT_FILE);
        System.out.println(EXPORT_FILE);
        System.out.println(FIND_HIGHEST_MARK_STUDENT);
        System.out.println(EXIT);
        System.out.println(ENTER_YOUR_CHOICE);
    }
}
