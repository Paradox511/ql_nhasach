package DAO;

import DTO.PhieuNhap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PhieuNhapDAO {
  Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
    public  PhieuNhapDAO(){
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
    public ArrayList<PhieuNhap> getListPhieuNhap() {
        ArrayList<PhieuNhap> dspn = new ArrayList<>();
        try {
            String sql = "SELECT * FROM phieunhap";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(rs.getInt(1));
               // pn.setMaNCC(rs.getInt(2));
                pn.setMaNV(rs.getInt(2));
                pn.setNgayLap(rs.getDate(3));
                pn.setTongTien(rs.getInt(4));
                dspn.add(pn);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dspn;
    }

    public boolean themPhieuNhap(PhieuNhap pn) {
        boolean result = false;
        try {
            String sql = "INSERT INTO phieunhap(Mapn, MaNV, NgayLap, TongTien) "
                    + "VALUES(NULL,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
          //  prep.setInt(1, pn.getMaNCC());
           
            prep.setInt(1, pn.getMaNV());
            prep.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setDouble(3, pn.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public PhieuNhap getPhieuNhap(int maPN) {
        PhieuNhap pn = null;
        try {
            String sql = "SELECT * FROM phieunhap WHERE MaPN=" + maPN;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pn = new PhieuNhap();
                pn.setMaPN(rs.getInt(1));
         //       pn.setMaNCC(rs.getInt(2));
                pn.setMaNV(rs.getInt(2));
                pn.setNgayLap(rs.getDate(3));
                pn.setTongTien(rs.getInt(4));
            }
        } catch (SQLException ex) {
            return null;
        }
        return pn;
    }

    public boolean deletePhieuNhap(int maPN) {
        boolean result = false;
        try {
            String sql = "DELETE FROM phieunhap WHERE MaPN=" + maPN;
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updatePhieuNhap(int maPN, PhieuNhap pn) {
        boolean result = false;
        try {
            String sql = "UPDATE phieunhap SET MaPN=?, MaNV=?, NgayLap=?, TongTien=? "
                    + "WHERE MaPN=" + maPN;
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, pn.getMaPN());
        //    prep.setInt(2, pn.getMaNCC());
            prep.setInt(2,pn.getMaNV());
            prep.setDate(3, new java.sql.Date(pn.getNgayLap().getTime()));
            prep.setDouble(4, pn.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public int getLastID() {
        try {
            String sql = "SELECT MAX(maPN) FROM phieunhap";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getInt(1);
        } catch (Exception e) {
            
            
            e.printStackTrace();
        }
        return -1;
    }
}
