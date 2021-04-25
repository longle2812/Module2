import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static final String WHICH_GRADE = "Which Grade?";
    public static final String GRADE_A = "1. Grade A";
    public static final String GRADE_B = "1. Grade B";
    public static final String GRADE_C = "1. Grade C";
    public static final String SUCCESS = "Success!";
    public static final String ENTER_NAME = "Enter name";
    public static final String ENTER_ADDRESS = "Enter address";
    public static final String ENTER_PRIORITY_1_5 = "Enter priority (1-5)";
    public static final String ENTER_LITERATURE = "Enter Literature";
    public static final String ENTER_HISTORY = "Enter History";
    public static final String ENTER_GEOGRAPHY = "Enter Geography";
    public static final String ENTER_MATH = "Enter Math";
    public static final String ENTER_CHEMISTRY = "Enter Chemistry";
    public static final String ENTER_BIOLOGY = "Enter Biology";
    public static final String ENTER_PHYSIC = "Enter Physic";
    public static final String ENTER_ID = "Enter ID";
    public static final String ID_CAN_NOT_BE_FOUND = "ID can not be found";
    public static final String WHICH_FIELD = "Which field?";
    public static final String BASIC_INFORMATION = "1. Basic Information";
    public static final String MARK = "2. Mark";
    Scanner sc = new Scanner(System.in);
    private final List<Student> students = new ArrayList<>();
    private final List<Integer> uniqueIDs = new ArrayList<>();
    private final List<String> uniqueNames = new ArrayList<>();
    private int id;
    private String name;
    private String address;
    private int priority;
    private int math;
    private int physic;
    private int literature;
    private int chemistry;
    private int history;
    private int biology;
    private int geography;

    public void init() {
        for (int i = 1; i < 5; i++) {
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
        System.out.println(WHICH_GRADE);
        System.out.println(GRADE_A);
        System.out.println(GRADE_B);
        System.out.println(GRADE_C);
        int choice = sc.nextInt();
        sc.nextLine();
        newBasicInfo();
        switch (choice) {
            case 1:
                newGradeAMark();
                students.add(new GradeA(id, name, address, priority, math, physic, chemistry));
                System.out.println(SUCCESS);
                break;
            case 2:
                newGradeBMark();
                students.add(new GradeB(id, name, address, priority, math, chemistry, biology));
                System.out.println(SUCCESS);
                break;
            case 3:
                newGradeCMark();
                students.add(new GradeC(id, name, address, priority, literature, history, geography));
                System.out.println(SUCCESS);
                break;
        }
    }

    private void newBasicInfo() {
        id = getUniqueID();
        System.out.println(ENTER_NAME);
        name = sc.nextLine();
        System.out.println(ENTER_ADDRESS);
        address = sc.nextLine();
        System.out.println(ENTER_PRIORITY_1_5);
        priority = sc.nextInt();
    }

    private void newGradeCMark() {
        System.out.println(ENTER_LITERATURE);
        literature = sc.nextInt();
        System.out.println(ENTER_HISTORY);
        history = sc.nextInt();
        System.out.println(ENTER_GEOGRAPHY);
        geography = sc.nextInt();
    }

    private void newGradeBMark() {
        System.out.println(ENTER_MATH);
        math = sc.nextInt();
        System.out.println(ENTER_CHEMISTRY);
        chemistry = sc.nextInt();
        System.out.println(ENTER_BIOLOGY);
        biology = sc.nextInt();
    }

    private void newGradeAMark() {
        System.out.println(ENTER_MATH);
        math = sc.nextInt();
        System.out.println(ENTER_PHYSIC);
        physic = sc.nextInt();
        System.out.println(ENTER_CHEMISTRY);
        chemistry = sc.nextInt();
    }

    public void sortByName() {
        for (int i = 0; i < students.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < students.size(); j++) {
                boolean isNameBefore = students.get(j).getName().compareTo(students.get(min).getName()) < 0;
                if (isNameBefore) {
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
        System.out.println(SUCCESS);
    }

    public void findByID() {
        sortByID();
        System.out.println(ENTER_ID);
        int findID = sc.nextInt();
        Student student = binarySearch(findID);
        if (student == null) {
            System.out.println(ID_CAN_NOT_BE_FOUND);
        } else {
            System.out.println(student);
            System.out.println(SUCCESS);
        }
    }

    private Student binarySearch(int findID) {
        int low = 0;
        int high = students.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean midValueEqualFindID = students.get(mid).getId() == findID;
            if (midValueEqualFindID) {
                return students.get(mid);
            } else {
                boolean isMidValueSmallerThanFindID = students.get(mid).getId() < findID;
                if (isMidValueSmallerThanFindID) {
                    low = mid + 1;
                } else {
                    boolean isMidValueLargerThanFindID = students.get(mid).getId() > findID;
                    if (isMidValueLargerThanFindID) {
                        high = mid - 1;
                    }
                }
            }
        }
        return null;
    }

    private void sortByID() {
        for (int i = 0; i < students.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < students.size(); j++) {
                boolean isIdBefore = students.get(j).getId() < students.get(min).getId();
                if (isIdBefore) {
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

    public void editInfo() {
        System.out.println(ENTER_ID);
        int editID = sc.nextInt();
        sortByID();
        Student student = binarySearch(editID);
        if (student == null) {
            System.out.println(ID_CAN_NOT_BE_FOUND);
        } else {
            System.out.println(student);
            System.out.println(WHICH_FIELD);
            System.out.println(BASIC_INFORMATION);
            System.out.println(MARK);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    newBasicInfo();
                    student.setAddress(address);
                    student.setName(name);
                    student.setPriority(priority);
                    System.out.println(SUCCESS);
                    break;
                case 2:
                    editMarkInformation(student);
                    System.out.println(SUCCESS);
                    break;
            }
        }
    }

    private void editMarkInformation(Student student) {
        if (student instanceof GradeA) {
            newGradeAMark();
            ((GradeA) student).setMath(math);
            ((GradeA) student).setPhysic(physic);
            ((GradeA) student).setChemistry(chemistry);
        }

        if (student instanceof GradeB) {
            newGradeBMark();
            ((GradeB) student).setMath(math);
            ((GradeB) student).setChemistry(chemistry);
            ((GradeB) student).setBiology(biology);
        }
        if (student instanceof GradeC) {
            newGradeCMark();
            ((GradeC) student).setLiterature(literature);
            ((GradeC) student).setHistory(history);
            ((GradeC) student).setGeography(geography);
        }
    }

    public void deleteByID() {
        System.out.println(ENTER_ID);
        int editID = sc.nextInt();
        sortByID();
        Student student = binarySearch(editID);
        if (student == null) {
            System.out.println(ID_CAN_NOT_BE_FOUND);
        } else {
            students.remove(student);
            System.out.println(SUCCESS);
        }
    }
}
