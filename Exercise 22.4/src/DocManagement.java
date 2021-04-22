import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocManagement {
    public static final String ENTER_ID = "Enter id";
    public static final String ENTER_PUBLISHER = "Enter publisher";
    public static final String ENTER_EDITION_NUMBER = "Enter edition number";
    public static final String WHAT_S_TYPE = "What's type";
    public static final String BOOK = "1. Book";
    public static final String MAGAZINE = "2. Magazine";
    public static final String NEWSPAPER = "3. Newspaper";
    public static final String ENTER_DATE_PUBLISH_ = "Enter datePublish ";
    public static final String ENTER_NUMBER_EDITION = "Enter number Edition";
    public static final String ENTER_MONTH_EDITION = "Enter month Edition";
    public static final String ENTER_AUTHOR = "Enter author";
    public static final String ENTER_NUMBER_OF_PAGE = "Enter number of page";
    public static final String NO_INFORMATION = "No Information";
    List<Document> documents = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private int id;
    private String publisher;
    private int editionNumber;
    private String author;
    private int page;
    private String datePublish;
    private int numberEdition;
    private String monthEdition;

    public void init() {
        documents.add(new Book(1, "Long", 2, "banana", 200));
        documents.add(new Book(2, "Thanh", 5, "thanhdq", 150));
        documents.add(new Magazine(3, "Duyet", 3, 2, "09/2020"));
        documents.add(new Magazine(4, "Thao", 9, 4, "10/2021"));
        documents.add(new Newspaper(5, "Tri", 10, "04/03/2020"));
        documents.add(new Newspaper(6, "Ngoc Anh", 11, "08/06/2000"));
    }

    public void displayInfo() {
        for (Document document :
                documents) {
            displayByType(document);
        }
    }

    private void displayByType(Document document) {
        if (document instanceof Book) {
            document.printBook((Book) document);
        }
        if (document instanceof Magazine) {
            document.printMagazine((Magazine) document);
        }
        if (document instanceof Newspaper) {
            document.printNewspaper((Newspaper) document);
        }
    }

    public void addNewDocument() {
        int choice;
        chooseTypeMenu();
        choice = sc.nextInt();
        inputDocumentInfo();
        switch (choice) {
            case 1:
                inputBookInfo();
                break;
            case 2:
                inputMagazineInfo();
                break;
            case 3:
                inputNewspaperInfo();
                break;
        }
    }

    private void inputDocumentInfo() {
        System.out.println(ENTER_ID);
        id = sc.nextInt();
        System.out.println(ENTER_PUBLISHER);
        publisher = sc.nextLine();
        System.out.println(ENTER_EDITION_NUMBER);
        editionNumber = sc.nextInt();
    }

    private void chooseTypeMenu() {
        System.out.println(WHAT_S_TYPE);
        System.out.println(BOOK);
        System.out.println(MAGAZINE);
        System.out.println(NEWSPAPER);
    }

    private void inputNewspaperInfo() {
        System.out.println(ENTER_DATE_PUBLISH_);
        datePublish = sc.nextLine();
        documents.add(new Document(id, publisher, editionNumber, new Newspaper(datePublish)));
    }

    private void inputMagazineInfo() {
        System.out.println(ENTER_NUMBER_EDITION);
        numberEdition = sc.nextInt();
        System.out.println(ENTER_MONTH_EDITION);
        monthEdition = sc.nextLine();
        documents.add(new Document(id, publisher, editionNumber, new Magazine(numberEdition, monthEdition)));
    }

    private void inputBookInfo() {
        System.out.println(ENTER_AUTHOR);
        author = sc.nextLine();
        System.out.println(ENTER_NUMBER_OF_PAGE);
        page = sc.nextInt();
        documents.add(new Document(id, publisher, editionNumber, new Book(author, page)));
    }

    public void findDocumentByType() {
        chooseTypeMenu();
        int choice;
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                for (Document document :
                        documents) {
                    if (document instanceof Book)
                        displayByType((Book) document);
                }
                break;
            case 2:
                for (Document document :
                        documents) {
                    if (document instanceof Magazine)
                        displayByType((Magazine) document);
                }
                break;
            case 3:
                for (Document document :
                        documents) {
                    if (document instanceof Newspaper)
                        displayByType((Newspaper) document);
                }
                break;
        }
    }

    public void findDocumentByID() {
        System.out.println(ENTER_ID);
        int findID = sc.nextInt();
        Document result = binarySearch(findID);
        if (result != null) {
            displayByType(result);
        } else System.out.println(NO_INFORMATION);
    }

    private Document binarySearch(int findID) {
        int low = 0;
        int high = documents.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean midValueEqualFindID = documents.get(mid).getId() == findID;
            if (midValueEqualFindID) {
                return documents.get(mid);
            } else {
                boolean midValueSmallerThanFindID = documents.get(mid).getId() < findID;
                if (midValueSmallerThanFindID) {
                    low = mid + 1;
                } else {
                    boolean midValueLargerThanFindID = documents.get(mid).getId() > findID;
                    if (midValueLargerThanFindID) {
                        high = mid - 1;
                    }
                }
            }
        }
        return null;
    }

    public void sortDocument() {
        for (int i = 1; i < documents.size(); i++) {
            int position = i;
            Document temp = documents.get(i);
            while (position > 0) {
                boolean isTempSmallerThanCurrentPosition = (temp.getPublisher().compareTo(documents.get(position - 1).getPublisher())) < 0;
                if (!isTempSmallerThanCurrentPosition) break;
                documents.set(position, documents.get(position - 1));
                position--;
            }
            documents.set(position, temp);
        }
        displayInfo();
    }
}
