public class NhanVienFullTime extends NhanVien{
    private double TienThuong;
    private double TienPhat;
    private double LuongCung;

    public NhanVienFullTime() {
    }

    public NhanVienFullTime(double tienThuong, double tienPhat, double luongCung) {
        TienThuong = tienThuong;
        TienPhat = tienPhat;
        LuongCung = luongCung;
    }

    public NhanVienFullTime(int id, String name, int age, String phone, String mail, double tienThuong, double tienPhat, double luongCung) {
        super(id, name, age, phone, mail);
        TienThuong = tienThuong;
        TienPhat = tienPhat;
        LuongCung = luongCung;
    }

    public double getTienThuong() {
        return TienThuong;
    }

    public void setTienThuong(double tienThuong) {
        TienThuong = tienThuong;
    }

    public double getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(double tienPhat) {
        TienPhat = tienPhat;
    }

    public double getLuongCung() {
        return LuongCung;
    }

    public void setLuongCung(double luongCung) {
        LuongCung = luongCung;
    }

    public double getLuongThucLinh() {
        return this.getLuongCung() + (this.getTienThuong() - this.getTienPhat());
    }
    @Override
    public String toString() {
        return super.toString()+
                "/ " +
                "NhanVienFullTime{" +
                "TienThuong=" + TienThuong +
                ", TienPhat=" + TienPhat +
                ", LuongCung=" + LuongCung +
                '}' ;
    }
}
