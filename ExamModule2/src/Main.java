import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ContactManagement contactManagement = new ContactManagement();
        int choice;
        do {
            System.out.println("Contact Management Program");
            System.out.println("Choose function:");
            System.out.println("1. Show list");
            System.out.println("2. Add new");
            System.out.println("3. Edit");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Import");
            System.out.println("7. Export");
            System.out.println("8. Exit");
            System.out.println("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    contactManagement.showList();
                    break;
                case 2:
                    contactManagement.addNewContact();
                    break;
                case 3:
                    contactManagement.editContact();
                    break;
                case 4:
                    contactManagement.deleteContact();
                    break;
                case 5:
                    contactManagement.searchContact();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
        }
        while (choice != 0);
    }
}
