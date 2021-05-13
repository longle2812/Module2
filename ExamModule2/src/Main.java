import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String CONTACT_MANAGEMENT_PROGRAM = "Contact Management Program";
    public static final String CHOOSE_FUNCTION = "Choose function:";
    public static final String SHOW_LIST = "1. Show list";
    public static final String ADD_NEW = "2. Add new";
    public static final String EDIT = "3. Edit";
    public static final String DELETE = "4. Delete";
    public static final String SEARCH = "5. Search";
    public static final String IMPORT = "6. Import";
    public static final String EXPORT = "7. Export";
    public static final String EXIT = "8. Exit";
    public static final String YOUR_CHOICE = "Your choice: ";
    public static final String GOODBYE = "Goodbye!";
    public static final String IMPORT_SUCCESSFUL = "Import Successful";
    public static final String EXPORT_SUCCESSFUL = "Export Successful";
    public static final String ERROR = "Error!";
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        ContactManagement contactManagement = new ContactManagement();
        int choice = -1;
        do {
            try {
                displayMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
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
                        contactManagement.readContact();
                        System.out.println(IMPORT_SUCCESSFUL);
                        break;
                    case 7:
                        contactManagement.writeContact();
                        System.out.println(EXPORT_SUCCESSFUL);
                        break;
                    case 8:
                        System.out.println(GOODBYE);
                        System.exit(0);
                        break;
                }
            }
            catch (InputMismatchException e){
                System.err.println(ERROR);
                sc.next();
            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println(CONTACT_MANAGEMENT_PROGRAM);
        System.out.println(CHOOSE_FUNCTION);
        System.out.println(SHOW_LIST);
        System.out.println(ADD_NEW);
        System.out.println(EDIT);
        System.out.println(DELETE);
        System.out.println(SEARCH);
        System.out.println(IMPORT);
        System.out.println(EXPORT);
        System.out.println(EXIT);
        System.out.println(YOUR_CHOICE);
    }
}
