public class Main {
    public static void main(String[] args) {
        doSomething();
    }
    public static void doSomething(){
        NhanVien[] nhanViens = Management.init();
        Management.display(nhanViens);
        Management.caculateSalary(nhanViens);
    }

}
