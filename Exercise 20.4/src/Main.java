import java.util.Scanner;

public class Main {
    public static final String WELCOME_MESSAGE = "Chương trình quản lý tiền lương CBGV";
    public static final String ADD_NEW = "1. Nhập cán bộ mới";
    public static final String DISPLAY_LIST = "2. Hiển thị danh sách cán bộ";
    public static final String CALCULATE_NET_SALARY = "3. Tính lương thực lĩnh cho mỗi cán bộ";
    public static final String FIND_HIGH_SALARY = "4. Xuất danh sách cán bộ lương >= 8 triệu";
    public static final String EXIT = "0. Thoát chương trình";
    public static final String INPUT_YOUR_CHOICE = "Nhập lựa chọn của bạn";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Management management = new Management();
        management.init();
        displayMenu();
        choices(management);
    }

    private static void choices(Management management) {
        int choice;
        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    management.addNew();
                    break;
                case 2:
                    management.display();
                    break;
                case 3:
                    management.calculateSalary();
                    break;
                case 4:
                    management.findHighSalary();
                    break;
            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(ADD_NEW);
        System.out.println(DISPLAY_LIST);
        System.out.println(CALCULATE_NET_SALARY);
        System.out.println(FIND_HIGH_SALARY);
        System.out.println(EXIT);
        System.out.println(INPUT_YOUR_CHOICE);
    }
}
