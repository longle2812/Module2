import java.util.Scanner;

public class StudentManagement {
    public void getAllStudent(Student[] student) {
        System.out.println("**********************************");
        System.out.printf("%2s %13s %10s %4s \n", "id", "Họ và tên", "Ngày sinh", "Điểm");
        for (int i = 0; i < student.length; i++) {
            if (student[i].getId() != 0) {
                System.out.printf("%d %13s %10s %4d \n", student[i].getId(), student[i].getName(), student[i].getDob(), student[i].getMark());
            }
        }
        System.out.println("**********************************");
        System.out.println("Bấm phím bất kỳ để tiếp tục ...");
    }

    public void addNewStudent(Student[] student) {
        Scanner sc = new Scanner(System.in);
        int index = Student.totalStudent;
        Student.totalStudent++;
        Student.lastID++;
        System.out.println("ID của sinh viên mới là " + Student.lastID);
        student[index].setId(Student.lastID);
        System.out.println("1. Nhập tên sinh viên mới:");
        student[index].setName(sc.nextLine());
        System.out.println("2. Nhập ngày tháng năm sinh:");
        student[index].setDob(sc.nextLine());
        System.out.println("3. Nhập điểm thi:");
        student[index].setMark(sc.nextInt());
        getAllStudent(student);
    }

    public void editStudentInfo(Student[] student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên:");
        int editID = sc.nextInt();
        for (int i = 0; i < student.length; i++) {
            if (editID == student[i].getId()) {
                System.out.println("Bạn muốn sửa thông tin nào");
                System.out.println("1. Họ tên");
                System.out.println("2. Ngày tháng năm sinh");
                System.out.println("3. Điểm thi");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Nhập họ tên mới");
                        student[i].setName(sc.nextLine());
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Nhập ngày tháng năm sinh mới");
                        student[i].setDob(sc.nextLine());
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Nhập điểm thi mới");
                        student[i].setMark(sc.nextInt());
                        break;
                }
                break;
            }
        }
        getAllStudent(student);
    }

    public void deleteStudent(Student[] student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên muốn xoá");
        int deleteID = sc.nextInt();
        for (int j = 0; j < Student.totalStudent-1; j++) {
            if (deleteID == student[j].getId()) {
                for (int i = j; i <= Student.totalStudent-1; i++) {
                    student[i] = student[i + 1];
                }
                break;
            }
        }
        Student.totalStudent--;
        for (int i = Student.totalStudent; i < student.length; i++) {
            student[i] = new Student();
        }
        getAllStudent(student);
    }

    public void findMaxMark(Student[] student) {
        int max = student[0].getMark();
        for (int i = 0; i < Student.totalStudent; i++) {
            if (max < student[i].getMark()) {
                max = student[i].getMark();
            }
        }
        System.out.println("Sinh viên có điểm cao nhất là: ");
        for (int i = 0; i < Student.totalStudent; i++) {
            if (max == student[i].getMark()) {
                System.out.printf("%s", student[i].getName());
            }
        }
        System.out.println();
    }

    public void sortStudentMark(Student[] student) {
        for (int i = 0; i < Student.totalStudent - 1; i++) {
            for (int j = i + 1; j < Student.totalStudent; j++) {
                if (student[i].getMark() < student[j].getMark()) {
                    Student temp = new Student();
                    temp = student[i];
                    student[i] = student[j];
                    student[j] = temp;
                }
            }
        }
        getAllStudent(student);
    }
}
