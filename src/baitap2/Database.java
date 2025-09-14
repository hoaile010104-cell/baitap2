package baitap2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	 private static final String URL = "jdbc:sqlserver://LAPTOP-60GAL49V:1433;databaseName=QuanLySinhVien;integratedSecurity=true;encrypt=false;";

	    private Connection conn;

	    public Database() throws SQLException {
	        conn = DriverManager.getConnection(URL);
	    }

	    // Thêm sinh viên
	    public void themSinhVien(SinhVien sv) throws SQLException {
	        String sql = "INSERT INTO SinhVien(MaSV,HoTen,NgaySinh,NganhDaoTao,DiemTB,LopSinhHoat) VALUES (?,?,?,?,?,?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, sv.getMaSV());
	        ps.setNString(2, sv.getHoTen());
	        ps.setDate(3, Date.valueOf(sv.getNgaySinh()));
	        ps.setString(4, sv.getNganhDaoTao());
	        ps.setDouble(5, sv.getDiemTB());
	        ps.setNString(6, sv.getLopSinhHoat());
	        ps.executeUpdate();
	        ps.close();
	    }

	    // Lấy danh sách tất cả sinh viên
	    public List<String> layTatCa() throws SQLException {
	        List<String> list = new ArrayList<>();
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM SinhVien");
	        while (rs.next()) {
	            list.add(rs.getString("MaSV") + " | " +
	                     rs.getNString("HoTen") + " | " +
	                     rs.getDate("NgaySinh") + " | " +
	                     rs.getString("NganhDaoTao") + " | " +
	                     rs.getDouble("DiemTB") + " | " +
	                     rs.getNString("LopSinhHoat"));
	        }
	        rs.close();
	        st.close();
	        return list;
	    }

}
