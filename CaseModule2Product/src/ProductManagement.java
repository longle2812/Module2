import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    List<Table> tables = new ArrayList<>();
    private String id;
    private String color;
    private double price;
    private double weight;
    private String brand;

    public ProductManagement() {
    }


    public void addNewProduct() {
        System.out.println("1. Table");
        System.out.println("2. Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("1. Plastic");
        System.out.println("2. Wooden");
        int material = sc.nextInt();
        sc.nextLine();
        switch (material){
            case 1:
                FurnitureAbstractFactory furnitureAbstractFactory = FurnitureFactory.getFactory(MaterialType.PLASTIC);
                switch (choice){
                    case 1:
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
                        PlasticTable plasticTable = (PlasticTable) furnitureAbstractFactory.createTable(id, color, price, weight, brand);
                        tables.add(plasticTable);
                        System.out.println(plasticTable);
                        break;
                    case 2:
                        break;
                }
                break;
            case 2:
                break;
        }
    }
}
