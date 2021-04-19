import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonManagement {
    List persons = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private String name;
    private String dob;
    private String sex;
    private String address;

    public void displayInfo() {
        System.out.println("Danh sách cán bộ");
        for (Object person :
                persons) {
            System.out.println(person);
        }
    }

    public void init() {
        persons.add((Person) new Employee("chuoi", "28/12", "male", "Kim Ma", "developer"));
        persons.add((Person) new Engineer("thanh", "20/10", "male", "Doi Can", "electrical"));
    }

    public void addNewPerson() {
        System.out.println("Chọn loại nhân viên");
        System.out.println("1. Công nhân");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addNewWorker();
                break;
            case 2:
                addNewEngineer();
                break;
            case 3:
                addNewEmployee();
                break;
        }
    }

    private void addNewEmployee() {
        System.out.println("Nhập thông tin Nhân Viên");
        addNewInfo();
        System.out.println("Nhập vào công việc của Nhân viên");
        String work =sc.nextLine();
        Employee employee = new Employee(name, dob, sex, address, work);
        persons.add(employee);
    }

    private void addNewEngineer() {
        System.out.println("Nhập thông tin Kỹ Sư");
        addNewInfo();
        System.out.println("Nhập vào ngành kỹ sư");
        String branch =sc.nextLine();
        Engineer engineer = new Engineer(name, dob, sex, address, branch);
        persons.add(engineer);
    }

    private void addNewWorker() {
        System.out.println("Nhập thông tin Công nhân");
        addNewInfo();
        System.out.println("Nhập vào bậc thợ");
        String level = sc.nextLine();
        Worker worker = new Worker(name,dob, sex, address, level);
        persons.add(worker);
    }

    private void addNewInfo() {
        System.out.println("Nhập tên");
        name = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        dob = sc.nextLine();
        System.out.println("Nhập giới tính");
        sex = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        address = sc.nextLine();
    }

    public void searchByName() {
        System.out.println("Nhập vào tên cần tìm");
        String searchName = sc.nextLine();
        boolean isNameExsist = false;
        for (Object person :
                persons) {
            if (checkNameEmployee(searchName, person)) {
                isNameExsist = true;
                break;
            }
            if (checkNameWorker(searchName, person))  {
                isNameExsist = true;
                break;
            }
            if (checkNameEngineer(searchName, person)) {
                isNameExsist = true;
                break;
            }
        }
        if (!isNameExsist) {
            System.out.println("Không thấy ID");
        }
    }

    private boolean checkNameEngineer(String searchName, Object person) {
        if (person instanceof Engineer) {
            if (((Engineer) person).getName().equals(searchName)) {
                System.out.println(person);
                return true;
            }
        }
        return false;
    }

    private boolean checkNameWorker(String searchName, Object person) {
        if (person instanceof Worker) {
            if (((Worker) person).getName().equals(searchName)) {
                System.out.println(person);
                return true;
            }
        }
        return false;
    }

    private boolean checkNameEmployee(String searchName, Object person) {
        if (person instanceof Employee) {
            if (((Employee) person).getName().equals(searchName)) {
                System.out.println(person);
                return true;
            }
        }
        return false;
    }


}
