public class NhanVienParttime extends NhanVien{
    private double time;

    public NhanVienParttime() {
    }

    public NhanVienParttime(double time) {
        this.time = time;
    }

    public NhanVienParttime(int id, String name, int age, String phone, String mail, double time) {
        super(id, name, age, phone, mail);
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getLuongThucLinh() {
        return this.time* 100000;
    }

    @Override
    public String toString() {
        return super.toString()+
                "/ " +
                "NhanVienParttime{" +
                "time=" + time +
                '}';
    }
}
