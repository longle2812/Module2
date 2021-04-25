import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    Scanner sc = new Scanner(System.in);
    private final List<Student> students = new ArrayList<>();
    private final List<Integer> uniqueIDs = new ArrayList<>();
    private final List<String> uniqueNames = new ArrayList<>();

    public void init() {
        for (int i = 1; i < 4; i++) {
            students.add(getRandomGradeA());
            students.add(getRandomGradeB());
            students.add(getRandomGradeC());
        }
    }

    private GradeC getRandomGradeC() {
        int id = getUniqueID();
        String name = getUniqueName();
        String address = getRandomAddress();
        int priority = getRandomNumber(1, 5);
        int literature = getRandomNumber(1, 10);
        int history = getRandomNumber(1, 10);
        int geography = getRandomNumber(1, 10);
        return new GradeC(id, name, address, priority, literature, geography, history);
    }

    private String getUniqueName() {
        String uniqueName = getRandomName();
        if (uniqueNames.contains(uniqueName)) return getUniqueName();
        else {
            uniqueNames.add(uniqueName);
            return uniqueName;
        }
    }

    private int getUniqueID() {
        int uniqueID = getRandomNumber(1, 50);
        if (uniqueIDs.contains(uniqueID)) return getUniqueID();
        else {
            uniqueIDs.add(uniqueID);
            return uniqueID;
        }
    }

    private GradeB getRandomGradeB() {
        int id = getUniqueID();
        String name = getUniqueName();
        String address = getRandomAddress();
        int priority = getRandomNumber(1, 5);
        int math = getRandomNumber(1, 10);
        int chemistry = getRandomNumber(1, 10);
        int biology = getRandomNumber(1, 10);
        return new GradeB(id, name, address, priority, math, biology, chemistry);
    }

    private GradeA getRandomGradeA() {
        int id = getUniqueID();
        String name = getUniqueName();
        String address = getRandomAddress();
        int priority = getRandomNumber(1, 5);
        int math = getRandomNumber(1, 10);
        int physic = getRandomNumber(1, 10);
        int chemistry = getRandomNumber(1, 10);
        return new GradeA(id, name, address, priority, math, physic, chemistry);
    }

    private String getRandomAddress() {
        String[] address = {"Hà Giang", "Hà Nội", "Đà Nẵng", "Hải Phòng",
                "Điện Biên", "Lai Châu", "Huế", "Cần Thơ", "Cao Bằng", "Quảng Bình"};
        return address[getRandomNumber(1, address.length)];
    }

    private String getRandomName() {
        String[] name = {"Nguyễn Thùy Vân", "Nguyễn Gia An", "Nguyễn Bảo Ngọc",
                "Nguyễn Linh Lan", "Nguyễn Trúc Quỳnh", "Nguyễn Ngọc Mai", "Nguyễn Mai Anh",
                "Lê Ngọc Hân", "Lê Uyển Nhi", "Lê Vân Anh", "Lê Ngọc Lan Chi", "Lê Nhật Minh",
                "Lê Quốc Bình", "Lê Tuấn Anh"};
        return name[getRandomNumber(1, name.length)];
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void displayList() {
        for (Student student :
                students) {
            if (student instanceof GradeA) System.out.println(student);
            if (student instanceof GradeB) System.out.println(student);
            if (student instanceof GradeC) System.out.println(student);
        }
    }

    public void addNewStudent() {
        System.out.println("Which Grade?");
        System.out.println("1. Grade A");
        System.out.println("1. Grade B");
        System.out.println("1. Grade C");
        int choice = sc.nextInt();
        sc.nextLine();
        int id = getUniqueID();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter address");
        String address = sc.nextLine();
        System.out.println("Enter priority (1-5)");
        int priority = sc.nextInt();
        switch (choice) {
            case 1:
                addNewGradeA(id, name, address, priority);
                break;
            case 2:
                addNewGradeB(id, name, address, priority);
                break;
            case 3:
                addNewGradeC(id, name, address, priority);
                break;
        }
    }

    private void addNewGradeC(int id, String name, String address, int priority) {
        System.out.println("Enter Literature");
        int literature = sc.nextInt();
        System.out.println("Enter History");
        int history = sc.nextInt();
        System.out.println("Enter Geography");
        int geography = sc.nextInt();
        students.add(new GradeC(id, name, address, priority, literature, history, geography));
    }

    private void addNewGradeB(int id, String name, String address, int priority) {
        System.out.println("Enter Math");
        int math = sc.nextInt();
        System.out.println("Enter Chemistry");
        int chemistry = sc.nextInt();
        System.out.println("Enter Biology");
        int biology = sc.nextInt();
        students.add(new GradeB(id, name, address, priority, math, chemistry, biology));
    }

    private void addNewGradeA(int id, String name, String address, int priority) {
        System.out.println("Enter Math");
        int math = sc.nextInt();
        System.out.println("Enter Physic");
        int physic = sc.nextInt();
        System.out.println("Enter Chemistry");
        int chemistry = sc.nextInt();
        students.add(new GradeA(id, name, address, priority, math, physic, chemistry));
    }

    public void sortByName() {
        for (int i = 0; i < students.size()-1; i++) {
            int min = i;
            for (int j = i+1; j < students.size(); j++) {
                boolean isNameBefore = students.get(j).getName().compareTo(students.get(min).getName()) < 0;
                if (isNameBefore){
                    min = j;
                }
            }
            if (min != i) {
                Student temp = students.get(i);
                students.set(i, students.get(min));
                students.set(min, temp);
            }
        }
        displayList();
    }

    public void findByID() {
        sortByID();

        
    }

    private void sortByID() {
        for (int i = 0; i < students.size()-1; i++) {
            int min = i;
            for (int j = i+1; j < students.size(); j++) {
                boolean isIdBefore = students.get(j).getId() < students.get(min).getId();
                if (isIdBefore){
                    min = j;
                }
            }
            if (min != i) {
                Student temp = students.get(i);
                students.set(i, students.get(min));
                students.set(min, temp);
            }
        }
    }
}
