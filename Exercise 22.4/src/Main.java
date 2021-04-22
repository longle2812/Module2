import java.util.Scanner;

public class Main {

    public static final String DISPLAY_INFO = "1. Display info";
    public static final String ADD_NEW_DOCUMENT = "2. Add new document";
    public static final String FIND_DOCUMENT_BY_TYPE = "3. Find document by type";
    public static final String FIND_DOCUMENT_BY_ID = "4. Find document by ID";
    public static final String SORT_DOCUMENT_BY_AUTHOR = "5. Sort document by Author";
    public static final String EXIT = "0. Exit";

    public static void main(String[] args) {
        DocManagement docManagement = new DocManagement();
        Scanner sc = new Scanner(System.in);
        docManagement.init();
        userChoice(docManagement, sc);
    }

    private static void userChoice(DocManagement docManagement, Scanner sc) {
        int choice = -1;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    docManagement.displayInfo();
                    break;
                case 2:
                    docManagement.addNewDocument();
                    break;
                case 3:
                    docManagement.findDocumentByType();
                    break;
                case 4:
                    docManagement.findDocumentByID();
                    break;
                case 5:
                    docManagement.sortDocument();
                    break;

            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println(DISPLAY_INFO);
        System.out.println(ADD_NEW_DOCUMENT);
        System.out.println(FIND_DOCUMENT_BY_TYPE);
        System.out.println(FIND_DOCUMENT_BY_ID);
        System.out.println(SORT_DOCUMENT_BY_AUTHOR);
        System.out.println(EXIT);
    }
}
