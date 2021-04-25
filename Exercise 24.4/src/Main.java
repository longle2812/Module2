import java.util.Scanner;

public class Main {

    public static final String ENTER_CHOICE = "Enter choice";
    public static final String SHOW_STUDENT_LIST = "1. Show student list";
    public static final String ADD_NEW_STUDENT = "2. Add new student";
    public static final String SORT_LIST_BY_SELECTION_SORT = "3. Sort list by selection sort";
    public static final String FIND_STUDENT_BY_ID = "4. Find student by ID";
    public static final String EDIT_STUDENT_INFO_BY_ID = "5. Edit student info by id";
    public static final String DELETE_STUDENT_INFO_BY_ID = "6. Delete student info by id";
    public static final String EXIT = "0. Exit";
    public static final String YOUR_CHOICE = "Your choice:";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        manager.init();

        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    manager.displayList();
                    break;
                case 2:
                    manager.addNewStudent();
                    manager.displayList();
                    break;
                case 3:
                    manager.sortByName();
                    manager.displayList();
                    break;

                case 4:
                    manager.findByID();
                    break;
                case 5:
                    manager.editInfo();
                    manager.displayList();
                    break;
                case 6:
                    manager.deleteByID();
                    manager.displayList();
            }

        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println(ENTER_CHOICE);
        System.out.println(SHOW_STUDENT_LIST);
        System.out.println(ADD_NEW_STUDENT);
        System.out.println(SORT_LIST_BY_SELECTION_SORT);
        System.out.println(FIND_STUDENT_BY_ID);
        System.out.println(EDIT_STUDENT_INFO_BY_ID);
        System.out.println(DELETE_STUDENT_INFO_BY_ID);
        System.out.println(EXIT);
        System.out.println(YOUR_CHOICE);
    }
}
