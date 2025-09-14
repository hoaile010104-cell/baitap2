package baitap2;

import java.time.LocalDate;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private LocalDate ngaySinh;
    private String nganh;
    private double diem;
    private String lop;

    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String nganh, double diem, String lop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.nganh = nganh;
        this.diem = diem;
        this.lop = lop;
    }

    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getNganh() { return nganh; }
    public double getDiem() { return diem; }
    public String getLop() { return lop; }
}
