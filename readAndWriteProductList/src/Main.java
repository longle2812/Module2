import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ENTER_ID = "Enter ID";
    public static final String NO_INFORMATION = "No information";
    public static final String ENTER_NAME = "Enter name";
    public static final String ENTER_COMPANY = "Enter company";
    public static final String ENTER_PRICE = "Enter price";
    public static final String ENTER_DESCRIPTION = "Enter description";
    public static final String SHOW_INFO = "1. Show info";
    public static final String ADD_NEW_PRODUCT = "2. Add new product";
    public static final String FIND_DETAIL = "3. Find detail";
    public static final String EXIT = "0. Exit";
    public static final String ENTER_YOUR_CHOICE = "Enter your choice";
    private static List<Product> products = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int id;
    private static String name;
    private static String company;
    private static double price;
    private static String description;
    final static String path = "products.txt";

    public static void main(String[] args) throws IOException {
        int choice;
        init();
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayList();
                    readFile();
                    break;
                case 2:
                    addNewProduct();
                    readFile();
                    break;
                case 3:
                    findDetail();
                    readFile();
                    break;
            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println(SHOW_INFO);
        System.out.println(ADD_NEW_PRODUCT);
        System.out.println(FIND_DETAIL);
        System.out.println(EXIT);
        System.out.println(ENTER_YOUR_CHOICE);
    }

    private static void init() throws IOException {
        products.add(new Product(1, "banana", "codegym", 2.00, "favourite"));
        products.add(new Product(2, "iphone", "apple", 1000, "best seller"));
        writeToFile(path, products);
    }

    private static void findDetail() {
        System.out.println(ENTER_ID);
        id = sc.nextInt();
        boolean isExist = false;
        for (Product product:
             products) {
            if (product.getId() == id) {
                isExist = true;
                System.out.println(product);
            }
        }
        if (!isExist) {
            System.out.println(NO_INFORMATION);
        }
    }

    private static void displayList() {
        for (Product product :
                products) {
            System.out.println(product);
        }
    }

    private static void addNewProduct() throws IOException {
        System.out.println(ENTER_ID);
        id = sc.nextInt();
        sc.nextLine();
        System.out.println(ENTER_NAME);
        name = sc.nextLine();
        System.out.println(ENTER_COMPANY);
        company = sc.nextLine();
        System.out.println(ENTER_PRICE);
        price = sc.nextDouble();
        sc.nextLine();
        System.out.println(ENTER_DESCRIPTION);
        description = sc.nextLine();
        products.add(new Product(id, name, company, price, description));
        writeToFile(path, products);
    }

    private static void writeToFile(String path, List<Product> products) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            fos.close();
            oos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static List<Product> readFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
