import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    public static final String INPUT_GROSS_SALARY = "Nhập lương cứng";
    public static final String INPUT_BONUS = "Nhập tiền thưởng";
    public static final String INPUT_PENALTY = "Nhập tiền phạt";
    public static final String INPUT_NAME = "Nhập tên";
    public static final String INPUT_DATE_OF_BIRTH = "Nhập ngày sinh";
    public static final String INPUT_HOMETOWN = "Nhập quê quán";
    ArrayList<CBGV> cbgvs = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private double gross_Salary;
    private double bonus;
    private double penalty;
    private String name;
    private String dob;
    private String homeTown;

    public void init() {
        cbgvs.add(new CBGV(1000000, 200000, 50000, new CanBo("Long", "28/12", "hanoi")));
        cbgvs.add(new CBGV(2000000, 150000, 50000, new CanBo("Thanh", "10/10", "hanoi")));
    }

    public void display() {
        for (CBGV cbgv :
                cbgvs) {
            System.out.println(cbgv);
        }
    }

    public void addNew() {
        addCanBoInfo();
        addCbgvInfo();
        cbgvs.add(new CBGV(gross_Salary, bonus, penalty, new CanBo(name, dob, homeTown)));
    }

    private void addCbgvInfo() {
        System.out.println(INPUT_GROSS_SALARY);
        gross_Salary = sc.nextDouble();
        System.out.println(INPUT_BONUS);
        bonus = sc.nextDouble();
        System.out.println(INPUT_PENALTY);
        penalty = sc.nextDouble();
    }

    private void addCanBoInfo() {
        System.out.println(INPUT_NAME);
        name = sc.nextLine();
        System.out.println(INPUT_DATE_OF_BIRTH);
        dob = sc.nextLine();
        System.out.println(INPUT_HOMETOWN);
        homeTown = sc.nextLine();
    }


    public void calculateSalary() {
        for (CBGV cbgv :
                cbgvs) {
            System.out.print(cbgv + " ");
            cbgv.setNet_salary(cbgv.getGross_salary() + cbgv.getBonus() - cbgv.getPenalty());
            System.out.println("Net Salary: " + cbgv.getNet_salary());
        }
    }

    public void findHighSalary() {
        boolean isEmpty = true;
        System.out.println("Những cán bộ có lương thực lĩnh lớn hơn bằng 8 triệu");
        for (CBGV cbgv
                : cbgvs) {
            if (cbgv.getNet_salary() >= 8000000) {
                System.out.println(cbgv);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Không có cán bộ lương hơn 8 triệu");
        }
    }
}
