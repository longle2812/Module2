package ProductManagement;

import ProductFactory.*;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    List<Table> tableList = new ArrayList<>();
    List<Chair> chairList = new ArrayList<>();
    private String id;
    private String color;
    private double price;
    private double weight;
    private String brand;
    private String type;

    public ProductManagement() {
    }


    public void addNewProduct() throws IOException {
        System.out.println("---------------------");
        System.out.println("Choose type:");
        System.out.println("1. Create new table");
        System.out.println("2. Create new chair");
        System.out.println("---------------------");
        System.out.println("Enter your chocie: ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("---------------------");
        System.out.println("Choose material");
        System.out.println("1. Plastic material ");
        System.out.println("2. Wooden material ");
        System.out.println("---------------------");
        System.out.println("Enter your chocie: ");
        int material = sc.nextInt();
        sc.nextLine();
        switch (material) {
            case 1:
                FurnitureAbstractFactory plasticFactory = FurnitureFactory.getFactory(MaterialType.PLASTIC);
                switch (choice) {
                    case 1:
                        System.out.println("Create new Plastic Table");
                        createNewTable(plasticFactory);
                        break;
                    case 2:
                        System.out.println("Create new Plastic Chair");
                        createNewChair(plasticFactory);
                        break;
                }
                break;
            case 2:
                FurnitureAbstractFactory woodenFactory = FurnitureFactory.getFactory(MaterialType.WOOD);
                switch (choice) {
                    case 1:
                        System.out.println("Create new Wooden Table");
                        createNewTable(woodenFactory);
                        break;
                    case 2:
                        System.out.println("Create new Wooden Chair");
                        createNewChair(woodenFactory);
                        break;
                }
                break;
        }
        writeToFile();
    }

    private void createNewChair(FurnitureAbstractFactory furnitureAbstractFactory) {
        createNewProduct("Chair");
        type = typeGenerator("");
        Chair chair = furnitureAbstractFactory.createChair(id, color, price, weight, type);
        chairList.add(chair);
        System.out.println("Created successful");
    }

    private String typeGenerator(String type) {
        while (!type.matches("work") && !type.matches("decoration")) {
            System.out.println("Enter type (work/decoration)");
            type = sc.nextLine();
            if (!type.matches("work") && !type.matches("decoration")){
                System.err.println("Wrong input");
            }
        }
        return type;
    }

    private void createNewProduct(String product) {
        id = idGenerator(product);
        color = colorGenerator();
        price = priceGenerator();
        weight = weightGenerator();
    }

    private double weightGenerator() {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Enter weight (Kg)");
                weight = sc.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.err.println("Error!");
                sc.next();
            }
        }
        sc.nextLine();
        return weight;
    }

    private double priceGenerator() {
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Enter Price (USD)");
                price = sc.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.err.println("Error!");
                sc.next();
            }
        }
        sc.nextLine();
        return price;
    }

    private String colorGenerator() {
        String colorRegex = "\\w{3,}";
        do {
            System.out.println("Enter Color");
            color = sc.nextLine();
        }
        while (!color.matches(colorRegex));
        return color;
    }

    private String idGenerator(String product) {
        String idRegex = "";
        if (product.equals("Chair")) {
            idRegex = "CH\\d{3}";
        } else if (product.equals("Table")) idRegex = "TB\\d{3}";
        do {
            System.out.println("Enter ID (Table - TBxxx, Chair - CHxxx with x is number)");
            id = sc.nextLine();
        }
        while (!id.matches(idRegex));
        return id;
    }

    private void createNewTable(FurnitureAbstractFactory furnitureAbstractFactory) {
        createNewProduct("Table");
        System.out.println("Enter brand");
        brand = sc.nextLine();
        Table table = furnitureAbstractFactory.createTable(id, color, price, weight, brand);
        tableList.add(table);
        System.out.println("Created successful");
    }

    public void showAllProduct() {
        System.out.println("List of Table");
        System.out.println("*******************");
        for (Table table :
                tableList) {
            System.out.println(table);
        }
        System.out.println("*******************");
        System.out.println("List of Chair");
        for (Chair chair :
                chairList) {
            System.out.println(chair);
        }
        System.out.println("*******************");
    }

    public Product searchProductByID() {
        System.out.println("1. Table");
        System.out.println("2. Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ID");
        String findIndex = sc.nextLine();
        Product product = null;
        switch (choice) {
            case 1:
                product = genericSearch(tableList, findIndex);
                if (product != null) {
                    System.out.println(genericSearch(tableList, findIndex));
                } else System.out.println("No information");
                break;
            case 2:
                product = genericSearch(chairList, findIndex);
                if (product != null) {
                    System.out.println(genericSearch(chairList, findIndex));
                } else System.out.println("No information");
                break;
        }
        return product;
    }

    private <E, T> Product genericSearch(List<T> productList, String findIndex) {
        for (T product :
                productList) {
            if (((Product) product).getId().equals(findIndex)) {
                return (Product) product;
            }
        }
        return null;
    }

    public void editInformationByID() throws IOException {
        System.out.println("1. Table");
        System.out.println("2. Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter ID");
        String findIndex = sc.nextLine();
        switch (choice) {
            case 1:
                Table table = (Table) genericSearch(tableList, findIndex);
                if (table != null) {
                    System.out.println("Product is found");
                    createNewProduct("Table");
                    table.setId(id);
                    table.setColor(color);
                    table.setPrice(price);
                    table.setWeight(weight);
                    System.out.println("Enter brand");
                    brand = sc.nextLine();
                    table.setBrand(brand);
                    System.out.println("Edit successful");
                }
                break;
            case 2:
                Chair chair = (Chair) genericSearch(chairList, findIndex);
                if (chair != null) {
                    createNewProduct("Chair");
                    chair.setId(id);
                    chair.setColor(color);
                    chair.setPrice(price);
                    chair.setWeight(weight);
                    type = typeGenerator("");
                    chair.setType(type);
                    System.out.println("Edit successful");
                }
                break;
        }
        writeToFile();
    }

    public void sortByPrice() {
        System.out.println("1. Table");
        System.out.println("2. Chair");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                genericSort(tableList);
                break;
            case 2:
                genericSort(chairList);
                break;
        }
        System.out.println("List of product after sort");
        showAllProduct();
    }

    private <T> void genericSort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (((List<Product>) list).get(i).getPrice() < ((List<Product>) list).get(j).getPrice()) {
                    Product temp = (Product) list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, (T) temp);
                }
            }
        }
    }

    public void writeToFile() throws IOException {
        FileOutputStream fileTable = new FileOutputStream("tableList.txt");
        ObjectOutputStream objectTable = new ObjectOutputStream(fileTable);
        objectTable.writeObject(tableList);
        FileOutputStream fileChair = new FileOutputStream("chairList.txt");
        ObjectOutputStream objectChair = new ObjectOutputStream(fileChair);
        objectChair.writeObject(chairList);
        objectChair.close();
        objectTable.close();
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileTable = new FileInputStream("tableList.txt");
        ObjectInputStream objectTable = new ObjectInputStream(fileTable);
        tableList = (List<Table>) objectTable.readObject();
        FileInputStream fileChair = new FileInputStream("chairList.txt");
        ObjectInputStream objectChair = new ObjectInputStream(fileChair);
        chairList = (List<Chair>) objectChair.readObject();
        objectTable.close();
        objectChair.close();
    }

    public void deleteProdcutByID() throws IOException {
        Product product = searchProductByID();
        if (product != null) {
            if (product instanceof Table) {
                tableList.remove(product);
            }
            if (product instanceof Chair) {
                tableList.remove(product);
            }
            System.out.println("Delete product successful");
        } else System.out.println("No information");
        writeToFile();
    }
}
