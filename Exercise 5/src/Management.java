public class Management {
    static int lastID;
    public void caculateSalary(NhanVien[] nhanViens) {
        double[] salaries = new double[10];
        for (int i = 0; i < 10; i++) {
            if (nhanViens[i] instanceof NhanVienFullTime) {
                salaries[i] = ((NhanVienFullTime) nhanViens[i]).getLuongCung() +
                        ((((NhanVienFullTime) nhanViens[i]).getTienThuong()) - ((NhanVienFullTime) nhanViens[i]).getTienPhat());
            }
            else if (nhanViens[i] instanceof NhanVienParttime)
            {
                salaries[i] = ((NhanVienParttime) nhanViens[i]).getTime() *10000;
            }
        }
        for (double salary:
                salaries) {
            System.out.println(salary);
        }
    }

    public void display(NhanVien[] nhanViens) {
        for (NhanVien nhanVien:
                nhanViens) {
            System.out.println(nhanVien);
        }
    }

    public NhanVien[] init() {
        NhanVien[] nhanViens = new NhanVien[15];
        nhanViens[0] = new NhanVienFullTime(1, "Long", 26, "0388332980", "long@gmail.com", 100000, 20000, 5000000);
        nhanViens[1] = new NhanVienFullTime(2, "Phong", 25, "0936813549", "phong@gmail.com", 100000, 10000, 6000000);
        nhanViens[2] = new NhanVienFullTime(3, "Thanh", 24, "0388338980", "thanh@gmail.com", 200000, 50000, 10000000);
        nhanViens[3] = new NhanVienFullTime(4, "Duyet", 27, "0978813549", "duyet@gmail.com", 300000, 60000, 2000000);
        nhanViens[4] = new NhanVienFullTime(5, "Binh", 29, "0936813549", "binh@gmail.com", 50000, 70000, 3000000);
        nhanViens[5] = new NhanVienParttime(6, "Hai", 30, "0962353549","hai@gmail.com",4);
        nhanViens[6] = new NhanVienParttime(7, "Thuy", 40, "0316598452","thuy@gmail.com",5);
        nhanViens[7] = new NhanVienParttime(8, "Tien", 22, "0936132649","tien@gmail.com",6);
        nhanViens[8] = new NhanVienParttime(9, "Nam", 21, "0316987562","nam@gmail.com",3);
        nhanViens[9] = new NhanVienParttime(10, "Nga", 18, "0968742635","nga@gmail.com",8);
        lastID = 10;
        return nhanViens;
    }
}
