package ProductManagement;

import ProductFactory.*;

import java.io.*;
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
        System.out.println("1. ProductFactory.Table");
        System.out.println("2. ProductFactory.Chair");
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
                        System.out.println("Add new Plastic ProductFactory.Table");
                        createNewTable(plasticFactory);
                        break;
                    case 2:
                        System.out.println("Add new Plastic ProductFactory.Chair");
                        createNewChair(plasticFactory);
                        break;
                }
                break;
            case 2:
                FurnitureAbstractFactory woodenFactory = FurnitureFactory.getFactory(MaterialType.WOOD);
                switch (choice){
                    case 1:
                        System.out.println("Add new Wooden ProductFactory.Table");
                        createNewTable(woodenFactory);
                        break;
                    case 2:
                        System.out.println("Add new Wooden ProductFactory.Chair");
                        createNewChair(woodenFactory);
                        break;
                }
                break;
        }
    }

    private void createNewChair(FurnitureAbstractFactory furnitureAbstractFactory) {
        createNewProduct();
        System.out.println("Enter type");
        type = sc.nextLine();
        Chair chair = furnitureAbstractFactory.createChair(id, color, price, weight, type);
        chairs.add(chair);
    }

    private void createNewProduct() {
        System.out.println("Enter ID");
        id = sc.nextLine();
        System.out.println("Enter Color");
        color = sc.nextLine();
        System.out.println("Enter Price");
        price = sc.nextDouble();
        System.out.println("Enter weight");
        weight = sc.nextDouble();
        sc.nextLine();
    }

    private void createNewTable(FurnitureAbstractFactory furnitureAbstractFactory) {
        createNewProduct();
        System.out.println("Enter brand");
        brand = sc.nextLine();
        Table table = furnitureAbstractFactory.createTable(id, color, price, weight, brand);
        tables.add(table);
    }

    public void showAllProduct() {
        System.out.println("List of ProductFactory.Table");
        for (Table table :
                tables) {
            System.out.println(table);
        }
        System.out.println("List of ProductFactory.Chair");
        for (Chair chair :
                chairs) {
            System.out.println(chair);
        }
    }

    public void searchProductByID() {
        System.out.println("1. ProductFactory.Table");
        System.out.println("2. ProductFactory.Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ID");
        String findIndex = sc.nextLine();
        switch (choice){
            case 1:
                if (genericSearch(tables, findIndex) != null){
                    System.out.println(genericSearch(tables, findIndex));
                }
                else System.out.println("No information");
                break;
            case 2:
                if (genericSearch(chairs, findIndex) != null){
                    System.out.println(genericSearch(chairs, findIndex));
                }
                else System.out.println("No information");
                break;
        }
    }

    private <E,T> Product genericSearch(List<T> productList, String findIndex) {
        for (T product :
                productList) {
            if (((Product) product).getId().equals(findIndex) ) {
                return (Product) product;
            }
        }
        return null;
    }

    public void editInformationByID() {
        System.out.println("1. ProductFactory.Table");
        System.out.println("2. ProductFactory.Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ID");
        String findIndex = sc.nextLine();
        switch (choice){
            case 1:
                Table table = (Table) genericSearch(tables, findIndex);
                if (table != null){
                    System.out.println("ProductFactory.Product is found");
                    createNewProduct();
                    table.setId(id);
                    table.setColor(color);
                    table.setPrice(price);
                    table.setWeight(weight);
                    System.out.println("Enter brand");
                    brand = sc.nextLine();
                    table.setBrand(brand);
                }
                break;
            case 2:
                Chair chair = (Chair) genericSearch(chairs, findIndex);
                if (chair != null){
                    createNewProduct();
                    chair.setId(id);
                    chair.setColor(color);
                    chair.setPrice(price);
                    chair.setWeight(weight);
                    System.out.println("Enter type");
                    type = sc.nextLine();
                    chair.setType(type);
                }
                break;
        }
    }

    public void sortByPrice() {
        System.out.println("1. ProductFactory.Table");
        System.out.println("2. ProductFactory.Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                for (int i = 0; i < tables.size()-1; i++) {
                    for (int j = i+1; j < tables.size(); j++) {
                        if (tables.get(i).getPrice() < tables.get(j).getPrice()){
                            Table temp = tables.get(i);
                            tables.set(i, tables.get(j));
                            tables.set(j, temp);
                        }
                    }
                }
                break;
            case 2:
                break;
        }
        showAllProduct();
    }

    public void writeToFile() throws IOException {
        FileOutputStream fileTable = new FileOutputStream("tableList.txt");
        ObjectOutputStream objectTable = new ObjectOutputStream(fileTable);
        objectTable.writeObject(tables);
        FileOutputStream fileChair = new FileOutputStream("chairList.txt");
        ObjectOutputStream objectChair = new ObjectOutputStream(fileChair);
        objectChair.writeObject(chairs);
        objectChair.close();
        objectTable.close();
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileTable = new FileInputStream("tableList.txt");
        ObjectInputStream objectTable = new ObjectInputStream(fileTable);
        tables = (List<Table>) objectTable.readObject();
        FileInputStream fileChair = new FileInputStream("chairList.txt");
        ObjectInputStream objectChair = new ObjectInputStream(fileChair);
        chairs = (List<Chair>) objectChair.readObject();
        objectTable.close();
        objectChair.close();
    }
}
