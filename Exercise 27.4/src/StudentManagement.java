import netscape.security.UserTarget;

import java.io.*;
import java.util.*;

public class StudentManagement {
    public static final String SUCCESS = "Success!";
    public static final String ENTER_NAME = "Enter name";
    public static final String ENTER_HOMETOWN = "Enter hometown";
    public static final String ENTER_GRADE = "Enter grade";
    public static final String ENTER_MARK = "Enter mark";
    public static final String ENTER_ID = "Enter ID";
    public static final String NO_INFORMATION = "No information";
    public static final String STUDENT_LIST_CSV = "studentList.csv";
    Scanner sc = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();
    List<Integer> idList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    private int id;
    private String name;
    private String hometown;
    private String grade;
    private double mark;

    // initiate new random student list
    public void init() {
        for (int i = 0; i < 10; i++) {
            int id = getUniqueID();
            String name = getUniqueName();
            String hometown = getHomeTown();
            String grade = String.valueOf(getRandomNumber(10, 12));
            double mark = getRandomNumber(1, 10);
            studentList.add(new Student(id, name, hometown, grade, mark));
        }
    }

    //random information
    private int getUniqueID() {
        int uniqueID = getRandomNumber(1, 100);
        if (idList.contains(uniqueID)) return getUniqueID();
        else {
            idList.add(uniqueID);
            return uniqueID;
        }
    }

    private String getUniqueName() {
        String uniqueName = getRandomName();
        if (nameList.contains(uniqueName)) return getUniqueName();
        else {
            nameList.add(uniqueName);
            return uniqueName;
        }
    }

    private String getHomeTown() {
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

    //show student list
    public void showList() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    //add new student
    public void addNewStudent() {
        newInfo();
        studentList.add(new Student(id, name, hometown, grade, mark));
        System.out.println(SUCCESS);
    }

    private void newInfo() {
        id = getUniqueID();
        System.out.println(ENTER_NAME);
        name = sc.nextLine();
        System.out.println(ENTER_HOMETOWN);
        hometown = sc.nextLine();
        System.out.println(ENTER_GRADE);
        grade = sc.nextLine();
        System.out.println(ENTER_MARK);
        mark = sc.nextDouble();
    }

    //edit student information
    public void editStudentInfo() {
        System.out.println(ENTER_ID);
        int findId = sc.nextInt();
        sc.nextLine();
        Student student = binarySearch(findId);
        if (student == null) {
            System.out.println(NO_INFORMATION);
        } else {
            newInfo();
            student.setName(name);
            student.setHometown(hometown);
            student.setGrade(grade);
            student.setMark(mark);
        }
    }

    //sort student
    public void sortByID() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                boolean isIdBefore = studentList.get(j).getId() < studentList.get(min).getId();
                if (isIdBefore) {
                    min = j;
                }
            }
            if (min != i) {
                Student temp = studentList.get(i);
                studentList.set(i, studentList.get(min));
                studentList.set(min, temp);
            }
        }
    }

    public void sortByMark() {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = studentList.size() - 1; j > i; j--) {
                if (studentList.get(j).getMark() > studentList.get(j - 1).getMark()) {
                    Student temp = studentList.get(j - 1);
                    studentList.set(j - 1, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }
    }

    public void listStudentByClass() {
        Map<String, Integer> numberByClass = new LinkedHashMap<>();
        for (Student student : studentList) {
            if (!numberByClass.containsKey(student.getGrade())) {
                numberByClass.put(student.getGrade(), 1);
            } else {
                numberByClass.replace(student.getGrade(), numberByClass.get(student.getGrade()) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : numberByClass.entrySet()) {
            System.out.println("Class " + entry.getKey() + " has " + entry.getValue() + " students");
        }
    }

    //search student
    public void searchStudent() {
        System.out.println(ENTER_ID);
        int searchID = sc.nextInt();
        Student student = binarySearch(searchID);
        if (student == null) {
            System.out.println(NO_INFORMATION);
        } else {
            System.out.println(student);
        }
    }

    private Student binarySearch(int findID) {
        int low = 0;
        int high = studentList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean midValueEqualFindID = studentList.get(mid).getId() == findID;
            if (midValueEqualFindID) {
                return studentList.get(mid);
            } else {
                boolean isMidValueSmallerThanFindID = studentList.get(mid).getId() < findID;
                if (isMidValueSmallerThanFindID) {
                    low = mid + 1;
                } else {
                    boolean isMidValueLargerThanFindID = studentList.get(mid).getId() > findID;
                    if (isMidValueLargerThanFindID) {
                        high = mid - 1;
                    }
                }
            }
        }
        return null;
    }

    //delete student information
    public void deleteStudentInfo() {
        System.out.println(ENTER_ID);
        int deleteId = sc.nextInt();
        Student student = binarySearch(deleteId);
        if (student == null) {
            System.out.println(NO_INFORMATION);
        } else {
            studentList.remove(student);
        }
    }

    //find student with highest mark
    public void findHighestMark() {
        double highestMark = studentList.get(0).getMark();
        for (Student student : studentList
        ) {
            if (student.getMark() > highestMark) {
                highestMark = student.getMark();
            }
        }
        for (Student student :
                studentList) {
            if (student.getMark() == highestMark) {
                System.out.println(student);
            }
        }
    }

    //import & export
    public void readFile() {
        try {
            FileInputStream fis = new FileInputStream(STUDENT_LIST_CSV);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
            for (Student student :
                    studentList) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(SUCCESS);
    }

    public void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream(STUDENT_LIST_CSV);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(SUCCESS);
    }
}