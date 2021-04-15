package Customer;

import java.util.Scanner;

public class Main {
    public static final String WELCOME_MESSAGE = "Chương trình quản lý biên lai";
    public static final String DISPLAY_LIST = "1. Hiển thị danh sách";
    public static final String ADD_NEW_CUSTOMER = "2. Thêm khách hàng";
    public static final String CACULATE_MONEY = "3. Tính tiền điện phải trả";
    public static final String EXIT = "0. Thoát chương trình";
    public static final String PATTERN = "-----------------------------";
    public static final String YOUR_CHOICE = "Nhập vào lựa chọn của bạn: ";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BillManagement billManagement = new BillManagement();
        billManagement.init();
        makechoice(billManagement);
    }

    private static void makechoice(BillManagement billManagement) {
        int choice;
        do {
            System.out.println(WELCOME_MESSAGE);
            System.out.println(DISPLAY_LIST);
            System.out.println(ADD_NEW_CUSTOMER);
            System.out.println(CACULATE_MONEY);
            System.out.println(EXIT);
            System.out.println(PATTERN);
            System.out.println(YOUR_CHOICE);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    billManagement.displayList();
                    break;
                case 2:
                    billManagement.addNewCustomer();
                    break;
                case 3:
                    billManagement.caculateMoney();
                    break;
            }
        }
        while (choice != 0);
    }
}
