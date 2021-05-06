import java.util.Scanner;

public class DataBaseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagement productManagement = new ProductManagement();
        FurnitureAbstractFactory furnitureAbstractFactory = FurnitureFactory.getFactory(MaterialType.PLASTIC);
        int choice;
        do {
            System.out.println("Welcome to Manager Software");
            System.out.println("1. Add new Product");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    productManagement.addNewProduct();
                    break;
                case 2:
                    productManagement.showAllProduct();
            }
        }
        while (choice != 0);
    }
}
