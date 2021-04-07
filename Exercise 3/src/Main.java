import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Hai Long", "28/12", 8);
        Student student2 = new Student(2, "Quoc Thanh", "1/1", 9);
        Student student3 = new Student(3, "Minh Tri", "3/3", 10);
        Student student4 = new Student(4, "The Duyet", "2/9", 7);
        Student student5 = new Student();
        Student student6 = new Student();
        Scanner sc = new Scanner(System.in);
        Student[] student = {student1, student2, student3, student4, student5, student6};
        StudentManagement studentManagement = new StudentManagement();
        int choice = 1;
        while (choice != 0) {
            System.out.println("Chương trình quản lý sinh viên ^^");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm một sinh viên mới");
            System.out.println("3. Chỉnh sửa thông tin của một sinh viên khi biết mã sinh viên");
            System.out.println("4. Xóa một sinh viên khỏi danh sách khi biết mã sinh viên");
            System.out.println("5. Tìm sinh viên có điểm cao nhất");
            System.out.println("6. Sắp xếp danh sách sinh viên theo điểm từ cao xuống thấp");
            System.out.println("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Danh sách sinh viên");
                    studentManagement.getAllStudent(student);
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("Thêm một sinh viên mới");
                    studentManagement.addNewStudent(student);
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Chỉnh sửa thông tin sinh viên");
                    studentManagement.editStudentInfo(student);
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Xoá sinh viên khỏi danh sách");
                    studentManagement.deleteStudent(student);
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Tìm sinh viên có điểm cao nhất");
                    studentManagement.findMaxMark(student);
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Sắp xếp danh sách theo điểm");
                    studentManagement.sortStudentMark(student);
                    sc.nextLine();
                    break;
            }
            sc.nextLine();
        }
    }
}
