package baitap2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        try {
            Database db = new Database();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n===== MENU QUẢN LÝ SINH VIÊN =====");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Xóa sinh viên");
                System.out.println("3. Sửa điểm sinh viên");
                System.out.println("4. In danh sách tất cả sinh viên");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: {
                        System.out.print("Nhập mã SV: ");
                        String ma = sc.nextLine();
                        System.out.print("Nhập họ tên: ");
                        String ten = sc.nextLine();
                        System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
                        LocalDate ns = LocalDate.parse(sc.nextLine());
                        System.out.print("Ngành (CNTT/KTPM): ");
                        String nganh = sc.nextLine();
                        System.out.print("Điểm TB: ");
                        double diem = Double.parseDouble(sc.nextLine());
                        System.out.print("Lớp sinh hoạt: ");
                        String lop = sc.nextLine();

                        SinhVien sv = new SinhVien(ma, ten, ns, nganh, diem, lop);
                        db.themSinhVien(sv);
                        System.out.println("Thêm thành công!");
                        break;
                    }
                    case 2: {
                        System.out.print("Nhập mã SV cần xóa: ");
                        String ma = sc.nextLine();
                        db.xoaSinhVien(ma);
                        System.out.println("Xóa thành công!");
                        break;
                    }
                    case 3: {
                        System.out.print("Nhập mã SV cần sửa: ");
                        String ma = sc.nextLine();
                        System.out.print("Nhập điểm mới: ");
                        double diem = Double.parseDouble(sc.nextLine());
                        db.suaDiem(ma, diem);
                        System.out.println("Sửa thành công!");
                        break;
                    }
                    case 4: {
                        List<String> ds = db.layTatCa();
                        System.out.println("===== DANH SÁCH SINH VIÊN =====");
                        for (String s : ds) {
                            System.out.println(s);
                        }
                        break;
                    }
                    case 0:
                        System.out.println("Thoát chương trình.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
