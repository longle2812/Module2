import Account.AccountManagement;
import ProductManagement.ProductManagement;

import java.io.IOException;
import java.util.Scanner;

public class DataBaseManagement {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        while (true) {
            loginPanel();
            Thread.sleep(1000);
            do {
                mainMenu();
            }
            while (true);
        }
    }

    private static void mainMenu() throws IOException, ClassNotFoundException, InterruptedException {
        int choice;
        System.out.println("1. Product Management");
        System.out.println("2. Employee Management");
        System.out.println("3. Logout");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                productManagement();
                break;
            case 2:

                break;
            case 3:
                System.out.println("Logout Successful");
                Thread.sleep(1000);
                main(new String[]{});
        }
    }


    private static void loginPanel() {
        AccountManagement accountManagement = new AccountManagement();
        int choice;
        boolean isLoginSuccess = false;
        do {
            displayLoginMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    accountManagement.createNewAccount();
                    continue;
                case 2:
                    isLoginSuccess = accountManagement.login();
                    if (isLoginSuccess) {
                        System.out.println("Login successful");
                    } else System.err.println("Username or password is wrong");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
            }
        }
        while (!isLoginSuccess);
    }

    private static void displayLoginMenu() {
        System.out.println("Account Pannel");
        System.out.println("1. Create new account");
        System.out.println("2. Login");
        System.out.println("0. Exit");
    }

    private static void productManagement() throws IOException, ClassNotFoundException, InterruptedException {
        ProductManagement productManagement = new ProductManagement();
        int choice;
        do {
            System.out.println("Welcome to Manager Software");
            System.out.println("1. Add new ProductFactory.Product");
            System.out.println("2. Show all ProductFactory.Product");
            System.out.println("3. Search product by ID");
            System.out.println("4. Edit information by ID");
            System.out.println("5. Sort product by price");
            System.out.println("6. Export data to file");
            System.out.println("7. Import data from file");
            System.out.println("8. Back");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    productManagement.addNewProduct();
                    break;
                case 2:
                    productManagement.showAllProduct();
                    break;
                case 3:
                    productManagement.searchProductByID();
                    break;
                case 4:
                    productManagement.editInformationByID();
                    break;
                case 5:
                    productManagement.sortByPrice();
                    break;
                case 6:
                    productManagement.writeToFile();
                    break;
                case 7:
                    productManagement.readFromFile();
                    break;
                case 8:
                    mainMenu();
                    break;
            }
        }
        while (choice != 0);
    }
}
