package DAO;

import DTO.PhanQuyenDTO;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PhanQuyenDAO {
  Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
    public  PhanQuyenDAO(){
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
    
    public ArrayList<PhanQuyenDTO> getListQuyen() {
        try {
            String sql = "SELECT * FROM PhanQuyen";
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            ArrayList<PhanQuyenDTO> dspq = new ArrayList<>();
            while (rs.next()) {
                PhanQuyenDTO phanQuyen = new PhanQuyenDTO();
                
                phanQuyen.setQuyen(rs.getString(1));
                phanQuyen.setNhapHang(rs.getInt(2));
                phanQuyen.setQlSanPham(rs.getInt(3));
                phanQuyen.setQlNhanVien(rs.getInt(4));
                phanQuyen.setQlKhachHang(rs.getInt(5));
                phanQuyen.setThongKe(rs.getInt(6));
                dspq.add(phanQuyen);
            }
            return dspq;
        } catch (Exception e) {
        }
        return null;
    }

    public PhanQuyenDTO getQuyen(String quyen) {
        try {
            String sql = "SELECT * FROM PhanQuyen WHERE quyen='" + quyen + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                PhanQuyenDTO phanQuyen = new PhanQuyenDTO();
                phanQuyen.setQuyen(quyen);
                phanQuyen.setQlNhanVien(rs.getInt(2));
                phanQuyen.setQlKhachHang(rs.getInt(3));
                phanQuyen.setNhapHang(rs.getInt(4));
                phanQuyen.setQlSanPham(rs.getInt(5));
                phanQuyen.setThongKe(rs.getInt(6));
                return phanQuyen;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean suaQuyen(PhanQuyenDTO phanQuyen) {
        try {
            String sql = "UPDATE phanquyen SET NhapHang=?,QLSach=?,QLNhanVien=?,QLKhachHang=?,ThongKe=? WHERE Quyen=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, phanQuyen.getNhapHang());
            pre.setInt(2, phanQuyen.getQlSanPham());
            pre.setInt(3, phanQuyen.getQlNhanVien());
            pre.setInt(4, phanQuyen.getQlKhachHang());
            pre.setInt(5, phanQuyen.getThongKe());
            pre.setString(6, phanQuyen.getQuyen());
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean themQuyen(PhanQuyenDTO phanQuyen) {
        try {
            String sql = "INSERT INTO phanquyen VALUES (?,?,?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, phanQuyen.getQuyen());
            pre.setInt(2, phanQuyen.getNhapHang());
            pre.setInt(3, phanQuyen.getQlSanPham());
            pre.setInt(4, phanQuyen.getQlNhanVien());
            pre.setInt(5, phanQuyen.getQlKhachHang());
            pre.setInt(6, phanQuyen.getThongKe());
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaQuyen(String phanQuyen) {
        try {
            String sql1 = "UPDATE TaiKhoan SET Quyen='Default' WHERE Quyen='" + phanQuyen + "'";
            Statement st1 = con.createStatement();
            st1.executeUpdate(sql1);
            String sql = "DELETE FROM PhanQuyen WHERE Quyen='" + phanQuyen + "'";
            Statement st = con.createStatement();
            return st.executeUpdate(sql) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
