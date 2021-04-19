import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        PersonManagement personManagement = new PersonManagement();
        personManagement.init();
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    personManagement.displayInfo();
                    break;
                case 2:
                    personManagement.addNewPerson();
                    break;
                case 3:
                    personManagement.searchByName();
                    break;
            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("---------Chương trình quản lý cán bộ---------");
        System.out.println("1. Hiển thị thông tin ");
        System.out.println("2. Thêm cán bộ mới");
        System.out.println("3. Tìm kiếm theo tên");
        System.out.println("0. Thoát chương trình");
        System.out.println("------------------------");
        System.out.println("Nhập vào lựa chọn của bạn");

    }
}
