import Account.AccountManagement;
import Account.User;
import EmployeeManagement.EmployeeManagement;
import ProductManagement.ProductManagement;
import UserManagement.UserManagement;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataBaseManagement {
    public static Scanner sc = new Scanner(System.in);
    public static User user = new User();

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        loginPanel();
    }


    private static void adminMenu() throws IOException, ClassNotFoundException, InterruptedException {
        int choice;
        System.out.println("**************************");
        System.out.println("WELCOME TO MANAGER PROGRAM");
        System.out.println("1. Product Management Panel");
        System.out.println("2. Employee Management Panel");
        System.out.println("3. Logout");
        System.out.println("**************************");
        System.out.println("Enter your choice: ");
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
                System.out.println("**************************");
                Thread.sleep(500);
                main(new String[]{});
        }
    }

    private static void employeeManagement() throws IOException, ClassNotFoundException, InterruptedException {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        int choice;
        do {
            System.out.println("**************************");
            System.out.println("WELCOME TO EMPLOYEE PANEL");
            System.out.println("1. Add new Employee");
            System.out.println("2. Show all Employee");
            System.out.println("3. Search employee by ID");
            System.out.println("4. Edit information by ID");
            System.out.println("5. Delete employee by ID");
            System.out.println("6. Sort employee by wage");
            System.out.println("7. Export data to file");
            System.out.println("8. Import data from file");
            System.out.println("9. Back");
            System.out.println("**************************");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
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
                    adminMenu();
                    break;
            }
        }
        while (choice != 9);
    }

    private static void loginPanel() throws IOException, ClassNotFoundException, InterruptedException {
        AccountManagement accountManagement = new AccountManagement();
        int choice = -1;
        do {
            try {
                accountManagement.readFromFile();
                displayLoginMenu();
                choice = sc.nextInt();
                if (choice < 0 || choice > 4) {
                    System.err.println("Wrong input");
                }
                switch (choice) {
                    case 1:
                        accountManagement.createNewAccount();
                        continue;
                    case 2:
                        user = accountManagement.login();
                        boolean isAdminValid = !user.getUsername().equals("null") && user.getRole().equals("admin");
                        if (isAdminValid) {
                            loadingMenu();
                            adminMenu();
                        } else if (!user.getUsername().equals("null") && !user.getRole().equals("admin")) {
                            loadingMenu();
                            userMenu();
                        }
                        else System.err.println("Wrong username or password");
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    case 3:
                        accountManagement.showList();
                        break;
                    case 4:
                        accountManagement.deleteAccount();
                }
            } catch (InputMismatchException e) {
                System.err.println("Error!");
                sc.next();
            }
        }
//        while (user.getUsername().equals("null") && choice != 0);
        while ( choice != 0);
    }

    private static void userMenu() throws IOException, ClassNotFoundException, InterruptedException {
        UserManagement userManagement = new UserManagement();
        int choice;
        do{
            System.out.println("**************************");
            System.out.println("WELCOME TO THE STORE");
            System.out.println("1. Add items to cart");
            System.out.println("2. Show cart");
            System.out.println("3. Delete items in cart");
            System.out.println("4. Check out");
            System.out.println("0. Back");
            System.out.println("**************************");
            choice = sc.nextInt();
            sc.nextLine();
            userManagement.readFromFile();
            userManagement.importShopingCart(user);
            switch (choice){
                case 1:
                    userManagement.addNewItems(user);
                    break;
                case 2:
                    userManagement.showCart(user);
                    break;
                case 3:
                    userManagement.deleteItems(user);
                    break;
                case 4:
                    userManagement.checkOut(user);
                    break;
                case 0:
                    loginPanel();
                    break;
            }
        }
        while(choice!=0);
    }

    private static void loadingMenu() throws InterruptedException {
        System.out.println("Login successful");
        Thread.sleep(500);
        System.out.println("*****--------------------- 30%");
        Thread.sleep(500);
        System.out.println("*************------------- 60%");
        Thread.sleep(500);
        System.out.println("************************** 100%");
        Thread.sleep(500);
        System.out.println("Loading Completed");
        Thread.sleep(500);
    }

    private static void displayLoginMenu() {
        System.out.println("**************************");
        System.out.println("WELCOME TO ACCOUNT PANEL");
        System.out.println("1. Create new account");
        System.out.println("2. Login");
        System.out.println("3. Show all account");
        System.out.println("0. Exit");
        System.out.println("**************************");
        System.out.println("Enter your choice:");
    }

    private static void productManagement() throws IOException, ClassNotFoundException, InterruptedException {
        ProductManagement productManagement = new ProductManagement();
        int choice;
        do {
            System.out.println("**************************");
            System.out.println("WELCOME TO PRODUCT PANEL");
            System.out.println("1. Add new Product");
            System.out.println("2. Show all Product");
            System.out.println("3. Search product by ID");
            System.out.println("4. Edit information by ID");
            System.out.println("5. Delete product by ID");
            System.out.println("6. Sort product by price");
            System.out.println("7. Export data to file");
            System.out.println("8. Import data from file");
            System.out.println("9. Back");
            System.out.println("**************************");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            productManagement.readFromFile();
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
                    adminMenu();
                    break;
            }
        }
        while (choice != 0);
    }
}
