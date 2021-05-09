import Account.AccountManagement;
import EmployeeManagement.EmployeeManagement;
import ProductManagement.ProductManagement;

import java.io.IOException;
import java.util.Scanner;

public class DataBaseManagement {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        loginPanel();
        Thread.sleep(1000);
        mainMenu();
    }

    private static void mainMenu() throws IOException, ClassNotFoundException, InterruptedException {
        int choice;
        System.out.println("1. Product Management");
        System.out.println("2. EmployeeManagement.Employee Management");
        System.out.println("3. Logout");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                productManagement();
                break;
            case 2:
                employeeManagement();
                break;
            case 3:
                System.out.println("Logout Successful");
                Thread.sleep(1000);
                main(new String[]{});
        }
    }

    private static void employeeManagement() throws IOException, ClassNotFoundException, InterruptedException {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        int choice;
        do {
            System.out.println("Welcome to EmployeeManagement.Employee Software");
            System.out.println("1. Add new EmployeeManagement.Employee");
            System.out.println("2. Show all EmployeeManagement.Employee");
            System.out.println("3. Search employee by ID");
            System.out.println("4. Edit information by ID");
            System.out.println("5. Delete employee by ID");
            System.out.println("6. Sort employee by wage");
            System.out.println("7. Export data to file");
            System.out.println("8. Import data from file");
            System.out.println("9. Back");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    employeeManagement.addNewEmployee();
                    break;
                case 2:
                    employeeManagement.showEmployeeList();
                    break;
                case 3:
                    employeeManagement.searchByID();
                    break;
                case 4:
                    employeeManagement.editInformation();
                    break;
                case 5:
                    employeeManagement.deleteEmployee();
                    break;
                case 6:
                    employeeManagement.sortByWage();
                    break;
                case 7:
                    employeeManagement.writeToFile();
                    break;
                case 8:
                    employeeManagement.readFromFile();
                    break;
                case 9:
                    mainMenu();
                    break;
            }
        }
        while (choice != 9);
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
            System.out.println("1. Add new Product");
            System.out.println("2. Show all Product");
            System.out.println("3. Search product by ID");
            System.out.println("4. Edit information by ID");
            System.out.println("5. Delete product by ID");
            System.out.println("6. Sort product by price");
            System.out.println("7. Export data to file");
            System.out.println("8. Import data from file");
            System.out.println("9. Back");
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
                    productManagement.deleteProdcutByID();
                    break;
                case 6:
                    productManagement.sortByPrice();
                    break;
                case 7:
                    productManagement.writeToFile();
                    break;
                case 8:
                    productManagement.readFromFile();
                    break;
                case 9:
                    mainMenu();
                    break;
            }
        }
        while (choice != 0);
    }
}
