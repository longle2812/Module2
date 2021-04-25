import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        manager.init();

        int choice;
        do {
            System.out.println("Enter choice");
            System.out.println("1. Show student list");
            System.out.println("2. Add new student");
            System.out.println("3. Sort list by selection sort");
            System.out.println("4. Find student by ID");
            System.out.println("5. Edit student info by id");
            System.out.println("6. Delete student info by id");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    manager.displayList();
                    break;
                case 2:
                    manager.addNewStudent();
                    break;
                case 3:
                    manager.sortByName();
                    break;

                case 4:
                    manager.findByID();
            }

        }
        while (choice != 0);
    }
}
