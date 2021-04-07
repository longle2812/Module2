import java.util.Scanner;

public class StudentManagement {
    public void getAllStudent(Student[] student) {
        System.out.printf("%2s %20s %10s %4s","id","Họ và tên","Ngày sinh","Điểm");
        for (int i = 0; i < student.length; i++) {
            if (student[i].getId() != 0) {
                System.out.printf("%d %6s %6s %2d \n",student[i].getId(),student[i].getName(),student[i].getDob(),student[i].getMark());
            }
        }
    }

    public void addNewStudent(Student[] student) {
        Scanner sc = new Scanner(System.in);
        int index = Student.lastID;
        Student.lastID++;
        System.out.println("ID của sinh viên mới là " + Student.lastID);
        student[index].setId(Student.lastID);
        System.out.println("1. Nhập tên sinh viên mới:");
        student[index].setName(sc.nextLine());
        System.out.println("2. Nhập ngày tháng năm sinh:");
        student[index].setDob(sc.nextLine());
        System.out.println("3. Nhập điểm thi:");
        student[index].setMark(sc.nextInt());
    }

    public void editStudentInfo(Student[] student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên:");
        int editID = sc.nextInt();
        for (int i = 0; i < student.length; i++) {
            if (editID == student[i].getId() + 1) {
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

    }

    public void deleteStudent(Student[] student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sinh viên muốn xoá");
        int deleteID = sc.nextInt();
        for (int i = deleteID - 1; i < Student.totalStudent -1; i++) {
            int tempid;
            String tempName;
            String tempDOB;
            int tempMark;

            tempid = student[i].getId();
            student[i].setId(student[i + 1].getId());
            student[i + 1].setId(tempid);

            tempName = student[i].getName();
            student[i].setName(student[i + 1].getName());
            student[i + 1].setName(tempName);

            tempDOB = student[i].getDob();
            student[i].setDob(student[i + 1].getDob());
            student[i + 1].setDob(tempDOB);

            tempMark = student[i].getMark();
            student[i].setMark(student[i + 1].getMark());
            student[i + 1].setMark(tempMark);
        }
        Student.totalStudent--;
        student[Student.totalStudent].setMark(0);
        student[Student.totalStudent].setId(0);
        student[Student.totalStudent].setName("");
        student[Student.totalStudent].setDob("");
    }

    public void findMaxMark(Student[] student) {
        int max = student[0].getMark();
        for (int i  = 0; i < Student.totalStudent;i++){
            if (max < student[i].getMark()){
                max = student[i].getMark();
            }
        }
        System.out.println("Sinh viên có điểm cao nhất là: ");
        for (int i  = 0; i < Student.totalStudent;i++){
            if (max == student[i].getMark()){
                System.out.printf("%s",student[i].getName());
            }
        }
        System.out.println();
    }

    public void sortStudentMark(Student[] student){
        for (int i = 0; i < Student.totalStudent-1;i++) {
            for(int j = i+1; j < Student.totalStudent; j++){
                if (student[i].getMark() < student[j].getMark()) {
                    int tempid;
                    String tempName;
                    String tempDOB;
                    int tempMark;

                    tempid = student[i].getId();
                    student[i].setId(student[j].getId());
                    student[j].setId(tempid);

                    tempName = student[i].getName();
                    student[i].setName(student[j].getName());
                    student[j].setName(tempName);

                    tempDOB = student[i].getDob();
                    student[i].setDob(student[j].getDob());
                    student[j].setDob(tempDOB);

                    tempMark = student[i].getMark();
                    student[i].setMark(student[j].getMark());
                    student[j].setMark(tempMark);
                }
            }
        }
    }
}
