import java.util.Scanner;

public class Management {
    static int totalEmployee;
    static int lastID;
    Scanner sc = new Scanner(System.in);

    public NhanVien[] initNewList() {
        NhanVien[] employees = new NhanVien[200];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new NhanVien();
        }
        employees[0] = new NhanVienFullTime(1, "Long", 26, "0388332980", "long@gmail.com", 100000, 20000, 5000000);
        employees[1] = new NhanVienFullTime(2, "Phong", 25, "0936813549", "phong@gmail.com", 100000, 10000, 6000000);
        employees[2] = new NhanVienFullTime(3, "Thanh", 24, "0388338980", "thanh@gmail.com", 200000, 50000, 10000000);
        employees[3] = new NhanVienFullTime(4, "Duyet", 27, "0978813549", "duyet@gmail.com", 300000, 60000, 2000000);
        employees[4] = new NhanVienFullTime(5, "Binh", 29, "0936813549", "binh@gmail.com", 50000, 70000, 3000000);
        employees[5] = new NhanVienParttime(6, "Hai", 30, "0962353549", "hai@gmail.com", 4);
        employees[6] = new NhanVienParttime(7, "Thuy", 40, "0316598452", "thuy@gmail.com", 5);
        employees[7] = new NhanVienParttime(8, "Tien", 22, "0936132649", "tien@gmail.com", 6);
        employees[8] = new NhanVienParttime(9, "Nam", 21, "0316987562", "nam@gmail.com", 3);
        employees[9] = new NhanVienParttime(10, "Nga", 18, "0968742635", "nga@gmail.com", 8);
        totalEmployee = 10;
        lastID = 10;
        return employees;
    }

    public void display(NhanVien[] employees) {
        for (NhanVien employee :
                employees) {
            if (employee.getId() != 0) {
                System.out.println(employee);
            }
        }
        System.out.println("Bấm phím bất kì để tiếp tục..");
        sc.nextLine();
    }

    public void addEmployee(NhanVien[] employees) {
        int choice;
        lastID++;
        do {
            System.out.println("Bạn muốn thêm nhân viên gì?");
            System.out.println("1. Nhân viên Full Time");
            System.out.println("2. Nhân viên Part Time");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                NhanVien nhanVien = inputFullTimeInfo();
                employees[totalEmployee] = nhanVien;
            } else if (choice == 2) {
                NhanVien nhanVien = inputPartTimeInfo();
                employees[totalEmployee] = nhanVien;
            }
        }
        while (choice != 1 && choice != 2);
        totalEmployee++;
        System.out.println("Đã thêm thành công, bấm phím bất kỳ để tiếp tục..");
        sc.nextLine();
    }

    private NhanVien inputPartTimeInfo() {
        System.out.println("Nhân viên Partime mới có ID là " + lastID);
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập số điện thoại");
        String phone = sc.nextLine();
        System.out.println("Nhập email");
        String mail = sc.nextLine();
        System.out.println("Nhập thời gian làm thêm");
        double time = sc.nextDouble();
        sc.nextLine();
        NhanVien nhanVien = new NhanVienParttime(lastID, name, age, phone, mail, time);
        return nhanVien;
    }

    private NhanVien inputFullTimeInfo() {
        System.out.println("Nhân viên Fulltime mới có ID là " + lastID);
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập số điện thoại");
        String phone = sc.nextLine();
        System.out.println("Nhập email");
        String mail = sc.nextLine();
        System.out.println("Nhập tiền thưởng");
        double tienThuong = sc.nextDouble();
        System.out.println("Nhập tiền phạt");
        double tienPhat = sc.nextDouble();
        System.out.println("Nhập lương cứng");
        double luongCung = sc.nextDouble();
        sc.nextLine();
        NhanVien nhanVien = new NhanVienFullTime(lastID, name, age, phone, mail, tienThuong, tienPhat, luongCung);
        return nhanVien;
    }

    public void caculateRealSalary(NhanVien[] employees) {
        System.out.println("Chọn ID nhân viên");
        int id = sc.nextInt();
        double salary = -1;
        for (NhanVien employee :
                employees) {
            if (employee.getId() == id) {
                if (employee instanceof NhanVienFullTime) {
                    salary = ((NhanVienFullTime) employee).getLuongThucLinh();
                } else if (employee instanceof NhanVienParttime) {
                    salary = ((NhanVienParttime) employee).getLuongThucLinh();
                }
            }
        }
        if (salary >= 0) {
            System.out.println("Lương thực lĩnh của nhân viên là " + salary);
        } else System.out.println("Không tìm thấy ID nhân viên");
    }

    public void getLowPaidSalary(NhanVien[] employees) {
        System.out.println("Lương trung bình là " + getTotalSalary(employees) / totalEmployee);
        System.out.println("Nhân viên có lương thấp hơn lương trung bình là: ");
        for (NhanVien employee :
                employees) {
            if (employee instanceof NhanVienFullTime) {
                if (((NhanVienFullTime) employee).getLuongThucLinh() <
                        getTotalSalary(employees) / totalEmployee) {
                    System.out.println(employee.toString());
                }
            }
        }
        System.out.println("Bấm phím bất kì để tiếp tục ...");
        sc.nextLine();
    }

    public void getPartTimeSalary(NhanVien[] employees) {
        double sumOfSalary = 0;
        for (NhanVien employee :
                employees) {
            if (employee instanceof NhanVienParttime) {
                sumOfSalary += ((NhanVienParttime) employee).getLuongThucLinh();
            }
        }
        System.out.println("Số tiền phải trả cho tất cả nhân viên Part Time là " + sumOfSalary);
        sc.nextLine();
    }

    public double getTotalSalary(NhanVien[] employees) {
        double totalSalary = 0;
        for (NhanVien employee :
                employees) {
            if (employee instanceof NhanVienFullTime) {
                totalSalary += ((NhanVienFullTime) employee).getLuongThucLinh();
            } else if (employee instanceof NhanVienParttime)
                totalSalary += ((NhanVienParttime) employee).getLuongThucLinh();
        }
        return totalSalary;
    }
}
