import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final String VEHICLE_MANAGEMENT = "Vehicle management";
    public static final String ADD_NEW_VEHICLE = "1. Add new vehicle";
    public static final String SHOW_VEHICLE_LIST = "2. Show vehicle list";
    public static final String FIND_VEHICLE_BY_BRAND_AND_COLOR = "3. Find vehicle by brand and color";
    public static final String EXPORT_VEHICLE_LIST = "4. Export vehicle list";
    public static final String IMPORT_VEHICLE_LIST = "5. Import vehicle list";
    public static final String EXIT = "0. Exit";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        VehicleManagement vehicleManagement = new VehicleManagement();
        userChoice(sc, vehicleManagement);
    }

    private static void userChoice(Scanner sc, VehicleManagement vehicleManagement) {
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    vehicleManagement.addNewVehicle();
                    break;
                case 2:
                    vehicleManagement.showVehicleList();
                    break;
                case 3:
                    vehicleManagement.findVehicle();
                    break;
                case 4:
                    vehicleManagement.exportVehicleList();
                    break;
                case 5:
                    vehicleManagement.importVehicleList();
                    break;
            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println(VEHICLE_MANAGEMENT);
        System.out.println(ADD_NEW_VEHICLE);
        System.out.println(SHOW_VEHICLE_LIST);
        System.out.println(FIND_VEHICLE_BY_BRAND_AND_COLOR);
        System.out.println(EXPORT_VEHICLE_LIST);
        System.out.println(IMPORT_VEHICLE_LIST);
        System.out.println(EXIT);
    }
}
