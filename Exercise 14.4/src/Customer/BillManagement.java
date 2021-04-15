package Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillManagement {
    public static final String PRESS_ENTER_TO_CONTINUE = "Bấm phím ENTER để tiếp tục";
    public static final String INPUT_MESSAGE = "Nhập thông tin khách hàng mới";
    public static final String NAME_INPUT = "Nhập vào tên";
    public static final String HOMEID_INPUT = "Nhập vào số nhà";
    public static final String METERID_INPUT = "Nhập vào mã công tơ điện";
    public static final String BILL_INFORMATION = "Nhập thông tin biên lai";
    public static final String OLD_INDEX = "Chỉ số cũ";
    public static final String NEW_INDEX = "Chỉ số mới";
    public static final String CANNOT_FIND_ID = "Không tìm thấy ID";
    public static final String MONEY_NEED_TO_PAY = "Số tiền điện phải trả là ";
    List<Bill> bills = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void init() {
        Customer customer1 = new Customer("Long", "1", "101");
        Customer customer2 = new Customer("Thanh", "2", "102");
        Customer customer3 = new Customer("Tri", "3", "103");
        Customer customer4 = new Customer("Duyet", "4", "104");
        Customer customer5 = new Customer("Thao", "5", "105");
        bills.add(new Bill(customer1, 102, 202, 0));
        bills.add(new Bill(customer2, 532, 632, 0));
        bills.add(new Bill(customer3, 842, 1004, 0));
        bills.add(new Bill(customer4, 742, 834, 0));
        bills.add(new Bill(customer5, 105, 354, 0));
    }

    public void displayList() {
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        System.out.println(PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }


    public void addNewCustomer() {
        System.out.println(INPUT_MESSAGE);
        System.out.println(NAME_INPUT);
        String nameInput = sc.nextLine();
        System.out.println(HOMEID_INPUT);
        String homeIDInput = sc.nextLine();
        System.out.println(METERID_INPUT);
        String meterIDInput = sc.nextLine();
        System.out.println(BILL_INFORMATION);
        System.out.println(OLD_INDEX);
        double oldIndex = sc.nextDouble();
        System.out.println(NEW_INDEX);
        double newIndex = sc.nextDouble();
        double moneyToPay = 0;
        sc.nextLine();

        Customer customer = new Customer(nameInput, homeIDInput, meterIDInput);
        bills.add(new Bill(customer, oldIndex, newIndex, moneyToPay));
        System.out.println(PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }

    public void caculateMoney() {
        System.out.println(HOMEID_INPUT);
        String homeIDInput = sc.nextLine();
        double moneyToPay = -1;
        for (Bill bill : bills) {
            boolean isBillIDTrue = bill.getCustomer().getHomeID().equals(homeIDInput);
            if (isBillIDTrue) {
                moneyToPay = (bill.getNewIndex() - bill.getOldIndex()) * 750;
            }
        }
        if (moneyToPay == -1) {
            System.out.println(CANNOT_FIND_ID);
        } else System.out.println(MONEY_NEED_TO_PAY + moneyToPay);
        System.out.println(PRESS_ENTER_TO_CONTINUE);
        sc.nextLine();
    }
}
