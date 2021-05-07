import java.io.IOException;
import java.util.Scanner;

public class DataBaseManagement {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AccountManagement accountManagement = new AccountManagement();
        do{
            System.out.println("Login Information");
            System.out.println("Enter username");
            System.out.println("Enter password");
        }
        productManagement();

    }

    private static void productManagement() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ProductManagement productManagement = new ProductManagement();
        int choice;
        do {
            System.out.println("Welcome to Manager Software");
            System.out.println("1. Add new Product");
            System.out.println("2. Show all Product");
            System.out.println("3. Search product by ID");
            System.out.println("4. Edit information by ID");
            System.out.println("5. Sort product by price");
            System.out.println("6. Export data to file");
            System.out.println("7. Import data from file");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
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
            }
        }
        while (choice != 0);
    }
}
