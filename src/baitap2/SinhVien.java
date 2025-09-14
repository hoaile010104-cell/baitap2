package baitap2;

import java.time.LocalDate;


public class SinhVien {
	private String maSV;
    private String hoTen;
    private LocalDate ngaySinh;
    private String nganhDaoTao;
    private double diemTB;
    private String lopSinhHoat;

    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String nganhDaoTao, double diemTB, String lopSinhHoat) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.nganhDaoTao = nganhDaoTao;
        this.diemTB = diemTB;
        this.lopSinhHoat = lopSinhHoat;
    }

    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getNganhDaoTao() { return nganhDaoTao; }
    public double getDiemTB() { return diemTB; }
    public String getLopSinhHoat() { return lopSinhHoat; }

    public void setDiemTB(double diemTB) { this.diemTB = diemTB; }
}
