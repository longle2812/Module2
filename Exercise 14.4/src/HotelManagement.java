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
    public Hotel[] hotels = new Hotel[numberOfCustomer];
    Scanner sc = new Scanner(System.in);

    public void displayInfo() {
        for (int i = 0; i < numberOfCustomer; i++) {
            System.out.println(hotels[i]);
        }
    }

    public void init() {
        Person person1 = new Person("Long", "28/12", "012938202");
        Person person2 = new Person("Thanh", "28/12", "03165432");
        Person person3 = new Person("Duyet", "28/12", "036815132");
        Person person4 = new Person("Thao", "28/12", "185433531");
        Person person5 = new Person("Tri", "28/12", "095612313");
        hotels[0] = new Hotel(10, "Basic", 1000, person1);
        hotels[1] = new Hotel(11, "VIP1", 1500, person2);
        hotels[2] = new Hotel(104, "Basic", 1000, person3);
        hotels[3] = new Hotel(30, "VIP2", 2000, person4);
        hotels[4] = new Hotel(50, "Basic", 1000, person5);
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
        long price = sc.nextLong();
        numberOfCustomer++;
        Hotel[] hotels1 = new Hotel[numberOfCustomer];
        for (int i = 0; i < hotels.length; i++) {
            hotels1[i] = hotels[i];
        }
        hotels1[hotels1.length - 1] = new Hotel(days, typeOfRoomInput, price, person);
        hotels = hotels1;
    }

    public void deleteInfo() {
        System.out.println(DELETE_ID_INPUT);
        String deleteID = sc.nextLine();
        int deleteIdNumber = -1;
        for (int i = 0; i < numberOfCustomer; i++) {
            if (hotels[i].getHuman().getIdNumber().equals(deleteID)) {
                deleteIdNumber = i;
                break;
            }
        }
        if (deleteIdNumber == -1) {
            System.out.println(CANNOT_FIND_ID);
        } else {
            Hotel[] hotels1 = new Hotel[numberOfCustomer - 1];
            for (int i = 0; i < deleteIdNumber; i++) {
                hotels1[i] = hotels[i];
            }
            for (int i = deleteIdNumber; i < numberOfCustomer - 1; i++) {
                hotels1[i] = hotels[i + 1];
            }
            hotels = hotels1;
            numberOfCustomer--;
        }
    }


    public void caculateMoney() {
        System.out.println(PAY_ID_INPUT);
        String payID = sc.nextLine();
        int payIdNumber = -1;
        for (int i = 0; i < numberOfCustomer; i++) {
            if (hotels[i].getHuman().getIdNumber().equals(payID)) {
                payIdNumber = i;
            }
        }
        if (payIdNumber == -1) {
            System.out.println(CANNOT_FIND_ID);
        } else {
            double priceOfRoom = hotels[payIdNumber].getPriceOfRoom();
            double numberOfLodging = hotels[payIdNumber].getRentDay();
            double moneyToPay = priceOfRoom * numberOfLodging;
            System.out.println(MONEY_TO_PAY_MESSAGE + moneyToPay);
        }
    }
}
