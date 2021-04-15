package HotelManagement;

import HotelManagement.HotelManagement;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HotelManagement hotelManagement = new HotelManagement();
        hotelManagement.init();
        makeChoice(hotelManagement);
    }

    private static void makeChoice(HotelManagement hotelManagement) {
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    hotelManagement.displayInfo();
                    break;
                case 2:
                    hotelManagement.addNewCustomer();
                    break;
                case 3:
                    hotelManagement.deleteInfo();
                    break;
                case 4:
                    hotelManagement.caculateMoney();
                    break;
            }
        }
        while (choice != 0);

    }

    private static void displayMenu() {
        System.out.println("----------Chương trình quản lý khách trọ----------");
        System.out.println("1. Hiển thị danh sách khách trọ");
        System.out.println("2. Thêm khách trọ");
        System.out.println("3. Xoá khách trọ");
        System.out.println("4. Tính tiền khách trọ");
        System.out.println("0. Thoát chương trình");
        System.out.println("Nhập vào lựa chọn của bạn");
    }
}
