package HotelManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManagement {
    public static final String NAME_INPUT = "Nhập tên";
    public static final String DATE_OF_BIRTH_INPUT = "Nhập ngày tháng năm sinh";
    public static final String ID_NUMBER_INPUT = "Nhập ID number";
    public static final String RENT_DAY_INPUT = "Nhập số ngày trọ";
    public static final String TYPE_OF_ROOM_INPUT = "Nhập loại phòng trọ";
    public static final String PRICE_OF_ROOM_INPUT = "Nhập giá phòng";
    public static final String PAY_ID_INPUT = "Nhập ID cần tính tiền";
    public static final String CANNOT_FIND_ID = "Không thấy ID khách hàng";
    public static final String MONEY_TO_PAY_MESSAGE = "Cần phải trả ";
    public static final String DELETE_ID_INPUT = "Nhập ID cần xoá";
    private int numberOfCustomer = 5;
    public List<Hotel> hotels = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void displayInfo() {
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println(hotels.get(i));
        }
    }

    public void init() {
        Person person1 = new Person("Long", "28/12", "012938202");
        Person person2 = new Person("Thanh", "28/12", "03165432");
        Person person3 = new Person("Duyet", "28/12", "036815132");
        Person person4 = new Person("Thao", "28/12", "185433531");
        Person person5 = new Person("Tri", "28/12", "095612313");
        hotels.add(new Hotel(10, "Basic", 1000, person1));
        hotels.add(new Hotel(11, "VIP1", 1500, person2));
        hotels.add(new Hotel(104, "Basic", 1000, person3));
        hotels.add(new Hotel(30, "VIP2", 2000, person4));
        hotels.add(new Hotel(50, "Basic", 1000, person5));
    }

    public void addNewCustomer() {
        System.out.println(NAME_INPUT);
        String nameInput = sc.nextLine();
        System.out.println(DATE_OF_BIRTH_INPUT);
        String dobInput = sc.nextLine();
        System.out.println(ID_NUMBER_INPUT);
        String idNumberInput = sc.nextLine();
        Person person = new Person(nameInput, dobInput, idNumberInput);
        System.out.println(RENT_DAY_INPUT);
        int days = sc.nextInt();
        sc.nextLine();
        System.out.println(TYPE_OF_ROOM_INPUT);
        String typeOfRoomInput = sc.nextLine();
        System.out.println(PRICE_OF_ROOM_INPUT);
        Long priceOfRoomInput = sc.nextLong();
        hotels.add(new Hotel(days, typeOfRoomInput, priceOfRoomInput, person));
    }

    public void deleteInfo() {
        System.out.println(DELETE_ID_INPUT);
        String deleteID = sc.nextLine();
        boolean isTrueID = false;
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getPerson().getIdNumber().equals(deleteID)) {
                hotels.remove(i);
                isTrueID = false;
            }
        }
        if (!isTrueID) {
            System.out.println(CANNOT_FIND_ID);
        }
    }


    public void caculateMoney() {
        System.out.println(PAY_ID_INPUT);
        String payID = sc.nextLine();
        double moneyToPay = -1;
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getPerson().getIdNumber().equals(payID)) {
                moneyToPay = hotels.get(i).getPriceOfRoom() * hotels.get(i).getRentDay();
            }
        }
        if (moneyToPay == -1) {
            System.out.println(CANNOT_FIND_ID);
        } else {
            System.out.println(MONEY_TO_PAY_MESSAGE + moneyToPay);
        }
    }
}