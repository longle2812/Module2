import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Management management = new Management();
        NhanVien[] employees = management.initNewList();
        int choices;
        do {
            displayMenu();
            choices = sc.nextInt();
            switch (choices) {
                case 1:
                    management.display(employees);
                    break;
                case 2:
                    management.addEmployee(employees);
                    management.display(employees);
                    break;
                case 3:
                    management.caculateRealSalary(employees);
                    break;
                case 4:
                    management.getLowPaidSalary(employees);
                    break;
                case 5:
                    management.getPartTimeSalary(employees);
                    break;
            }
        }
        while (choices != 0);
    }

    private static void displayMenu() {
        System.out.println("Chương trình quản lý nhân viên toàn thời gian và bán thời gian");
        System.out.println("1. Hiển thị danh sách nhân viên");
        System.out.println("2. Thêm nhân viên mới");
        System.out.println("3. Tính lương thực lĩnh của nhân viên");
        System.out.println("4. Liệt kê danh sách nhân viên toàn thời gian có mức lương thấp");
        System.out.println("5. Tổng số lương phải trả cho nhân viên Part time");
        System.out.println("0. Thoát chương trình");
        System.out.println("Nhập lựa chọn của bạn: ");
    }
}
