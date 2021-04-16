import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagement productManagement = new ProductManagement();
        productManagement.init();
        int choice;
        do {
            System.out.println("Chương trình quản lý sản phẩm");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xoá sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            System.out.println("0. Thoát");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    productManagement.addNewProduct();
                    break;
                case 2:
                    productManagement.editProduct();
                    break;
                case 3:
                    productManagement.deleteProduct();
                    break;
                case 4:
                    productManagement.display();
                    break;
                case 5:
                    sc.nextLine();
                    productManagement.searchByName();
                    break;
                case 6:
                    productManagement.sortByPrice();
                    break;
            }
        }
        while(choice != 0);
    }
}
