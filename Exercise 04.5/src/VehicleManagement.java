import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleManagement {
    public static final String CAR = "1. Car";
    public static final String MOTORBIKE = "2. Motorbike";
    public static final String TRUCK = "3. Truck";
    public static final String ENTER_WEIGHT = "Enter weight";
    public static final String ENTER_CAPACITY = "Enter capacity";
    public static final String ENTER_SEAT = "Enter seat";
    public static final String ENTER_ENGINE = "Enter engine";
    public static final String ENTER_BRAND_NAME = "Enter brand name";
    public static final String ENTER_YEAR = "Enter year";
    public static final String ENTER_PRICE = "Enter price";
    public static final String ENTER_COLOR = "Enter color";
    public static final String NO_INFORMATION = "No information";
    public static final String VEHICLE_LIST_TXT = "vehicleList.txt";
    public static final String EXPORT_SUCCESS = "Export success!";
    public static final String IMPORT_SUCCESS = "Import success!";
    private List<Vehicle> vehicles = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private String brand;
    private int year;
    private double price;
    private String color;
    private int seat;
    private String engine;
    private double capacity;
    private double weight;


    public void addNewVehicle() {
        int choice = getChoice();
        addBasicInfo();
        addDetailInfo(choice);
    }

    private void addDetailInfo(int choice) {
        switch (choice) {
            case 1:
                addNewCar();
                break;
            case 2:
                addNewMotorbike();
                break;
            case 3:
                addNewTruck();
                break;
        }
    }

    private int getChoice() {
        System.out.println(CAR);
        System.out.println(MOTORBIKE);
        System.out.println(TRUCK);
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    private void addNewTruck() {
        System.out.println(ENTER_WEIGHT);
        weight = sc.nextDouble();
        vehicles.add(new Truck(brand, year, price, color, weight));
    }

    private void addNewMotorbike() {
        System.out.println(ENTER_CAPACITY);
        capacity = sc.nextDouble();
        vehicles.add(new Motorbike(brand, year, price, color, capacity));
    }

    private void addNewCar() {
        System.out.println(ENTER_SEAT);
        seat = sc.nextInt();
        sc.nextLine();
        System.out.println(ENTER_ENGINE);
        engine = sc.nextLine();
        vehicles.add(new Car(brand, year, price, color, seat, engine));
    }

    private void addBasicInfo() {
        System.out.println(ENTER_BRAND_NAME);
        brand = sc.nextLine();
        System.out.println(ENTER_YEAR);
        year = sc.nextInt();
        System.out.println(ENTER_PRICE);
        price = sc.nextDouble();
        sc.nextLine();
        System.out.println(ENTER_COLOR);
        color = sc.nextLine();
    }

    public void showVehicleList() {
        for (Vehicle vehicle :
                vehicles) {
            System.out.println(vehicle);
        }
    }

    public void findVehicle() {
        System.out.println(ENTER_BRAND_NAME);
        String findBrand = sc.nextLine();
        System.out.println(ENTER_COLOR);
        String findColor = sc.nextLine();
        if (findColor(findBrand(findBrand), findColor) != null) {
            for (Vehicle vehicle :
                    findColor(findBrand(findBrand), findColor)) {
                System.out.println(vehicle);
            }
        } else System.out.println(NO_INFORMATION);
    }

    private ArrayList<Vehicle> findColor(ArrayList<Vehicle> brandVehicle, String findColor) {
        List<Vehicle> colorVehicles = new ArrayList<>();
        for (Vehicle vehicle :
                brandVehicle) {
            if (vehicle.getColor().equals(findColor)) {
                colorVehicles.add(vehicle);
            }
        }
        return (ArrayList<Vehicle>) colorVehicles;
    }

    private ArrayList<Vehicle> findBrand(String findBrand) {
        List<Vehicle> brandVehicles = new ArrayList<>();
        for (Vehicle vehicle :
                vehicles) {
            if (vehicle.getBrand().equals(findBrand)) {
                brandVehicles.add(vehicle);
            }
        }
        return (ArrayList<Vehicle>) brandVehicles;
    }

    public void exportVehicleList() {
        try {
            FileOutputStream fos = new FileOutputStream(VEHICLE_LIST_TXT);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vehicles);
            oos.close();
            fos.close();
            System.out.println(EXPORT_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importVehicleList() {
        try {
            FileInputStream fis = new FileInputStream(VEHICLE_LIST_TXT);
            ObjectInputStream ois = new ObjectInputStream(fis);
            vehicles = (List<Vehicle>) ois.readObject();
            fis.close();
            ois.close();
            System.out.println(IMPORT_SUCCESS);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
