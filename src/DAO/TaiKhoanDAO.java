package DAO;

import BUS.DangNhapBUS;
import DTO.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TaiKhoanDAO {
     Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
    public  TaiKhoanDAO(){
        if(con == null){
            try{
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach","root","");
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
                JOptionPane.showMessageDialog(null, "Chinh xác");
            }
        }            
    }

    public boolean themTaiKhoan(int maNV, String tenDangNhap, String quyen) {
        try {
            String sql = "INSERT INTO taikhoan(Manv, Taikhoan, MatKhau, Quyen,TrangThai) "
                    + "VALUES (?, ?, ?, ?,1)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, maNV);
            pre.setString(2, tenDangNhap);
            pre.setString(3, tenDangNhap);
            pre.setString(4, quyen);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE Taikhoan = '" + tenDangNhap + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getTenDangNhapTheoMa(int maNV) {
        try {
            String sql = "SELECT Taikhoan FROM TaiKhoan WHERE MaNV=" + maNV;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public boolean datLaiMatKhau(int maNV, String tenDangNhap) {
        try {
            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNV=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, tenDangNhap);
            pre.setInt(2, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean datLaiQuyen(int maNV, String quyen) {
        try {
            String sql = "UPDATE TaiKhoan SET Quyen=? WHERE MaNV=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, quyen);
            pre.setInt(2, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public String getQuyenTheoMa(int maNV) {
        try {
            String sql = "SELECT Quyen FROM TaiKhoan WHERE MaNV=" + maNV;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public boolean khoaTaiKhoan(int maNV) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThai=0 WHERE Manv=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean moKhoaTaiKhoan(int maNV) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThai=1 WHERE MaNV=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean doiMatKhau(String matKhauCu, String matKhauMoi) {
        try {
            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNV=? AND MatKhau=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, matKhauMoi);
          //  pre.setInt(2, DangNhapBUS.taiKhoanLogin.getMaNhanVien());
            pre.setString(3, matKhauCu);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public int getTrangThai(int ma) {
        try {
            String sql = "SELECT TrangThai FROM TaiKhoan WHERE MaNV=" + ma;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }
}
