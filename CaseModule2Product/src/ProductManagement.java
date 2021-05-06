import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    List<Table> tables = new ArrayList<>();
    List<Chair> chairs = new ArrayList<>();
    private String id;
    private String color;
    private double price;
    private double weight;
    private String brand;
    private String type;

    public ProductManagement() {
    }


    public void addNewProduct() {
        System.out.println("Choose type:");
        System.out.println("1. Table");
        System.out.println("2. Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Choose material");
        System.out.println("1. Plastic");
        System.out.println("2. Wooden");
        int material = sc.nextInt();
        sc.nextLine();
        switch (material){
            case 1:
                FurnitureAbstractFactory plasticFactory = FurnitureFactory.getFactory(MaterialType.PLASTIC);
                switch (choice){
                    case 1:
                        System.out.println("Add new Plastic Table");
                        createNewTable(plasticFactory);
                        break;
                    case 2:
                        System.out.println("Add new Plastic Chair");
                        createNewChair(plasticFactory);
                        break;
                }
                break;
            case 2:
                FurnitureAbstractFactory woodenFactory = FurnitureFactory.getFactory(MaterialType.WOOD);
                switch (choice){
                    case 1:
                        System.out.println("Add new Wooden Table");
                        createNewTable(woodenFactory);
                        break;
                    case 2:
                        System.out.println("Add new Wooden Chair");
                        createNewChair(woodenFactory);
                        break;
                }
                break;
        }
    }

    private void createNewChair(FurnitureAbstractFactory furnitureAbstractFactory) {
        System.out.println("Enter ID");
        id = sc.nextLine();
        System.out.println("Enter Color");
        color = sc.nextLine();
        System.out.println("Enter Price");
        price = sc.nextDouble();
        System.out.println("Enter weight");
        weight = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter type");
        type = sc.nextLine();
        Chair chair = furnitureAbstractFactory.createChair(id, color, price, weight, type);
        chairs.add(chair);
    }

    private void createNewTable(FurnitureAbstractFactory furnitureAbstractFactory) {
        System.out.println("Enter ID");
        id = sc.nextLine();
        System.out.println("Enter Color");
        color = sc.nextLine();
        System.out.println("Enter Price");
        price = sc.nextDouble();
        System.out.println("Enter weight");
        weight = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter brand");
        brand = sc.nextLine();
        Table table = furnitureAbstractFactory.createTable(id, color, price, weight, brand);
        tables.add(table);
    }

    public void showAllProduct() {
        System.out.println("List of Table");
        for (Table table :
                tables) {
            System.out.println(table);
        }
        System.out.println("List of Chair");
        for (Chair chair :
                chairs) {
            System.out.println(chair);
        }
    }
}
