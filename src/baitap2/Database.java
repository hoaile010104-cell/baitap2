package baitap2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;encrypt=false";
    private static final String USER = "sa";       // đổi theo SQL Server của bạn
    private static final String PASSWORD = "123";  // đổi theo mật khẩu SQL Server

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Thêm sinh viên
    public void themSinhVien(SinhVien sv) {
        String sql = "INSERT INTO SinhVien(MaSV, HoTen, NgaySinh, Nganh, Diem, Lop) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sv.getMaSV());
            stmt.setString(2, sv.getHoTen());
            stmt.setDate(3, Date.valueOf(sv.getNgaySinh()));
            stmt.setString(4, sv.getNganh());
            stmt.setDouble(5, sv.getDiem());
            stmt.setString(6, sv.getLop());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sinh viên
    public void xoaSinhVien(String ma) {
        String sql = "DELETE FROM SinhVien WHERE MaSV = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ma);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Sửa điểm sinh viên
    public void suaDiem(String ma, double diem) {
        String sql = "UPDATE SinhVien SET Diem = ? WHERE MaSV = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, diem);
            stmt.setString(2, ma);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả sinh viên
    public List<String> layTatCa() {
        List<String> ds = new ArrayList<>();
        String sql = "SELECT MaSV, HoTen, NgaySinh, Nganh, Diem, Lop FROM SinhVien";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String s = rs.getString("MaSV") + " - "
                         + rs.getString("HoTen") + " - "
                         + rs.getDate("NgaySinh") + " - "
                         + rs.getString("Nganh") + " - "
                         + rs.getDouble("Diem") + " - "
                         + rs.getString("Lop");
                ds.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

}
