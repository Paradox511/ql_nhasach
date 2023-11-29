/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTHoaDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CTHoaDonDAO {

        Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
    public  CTHoaDonDAO(){
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
    public ArrayList<CTHoaDon> getListCTHoaDon() {
        ArrayList<CTHoaDon> dscthd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cthoadon";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTHoaDon cthd = new CTHoaDon();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getDouble(4));
                cthd.setThanhTien(rs.getDouble(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
        }
        return dscthd;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaHD(int maHD) {
        ArrayList<CTHoaDon> dscthd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cthoadon WHERE MaHD="+maHD;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTHoaDon cthd = new CTHoaDon();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getDouble(4));
                cthd.setThanhTien(rs.getDouble(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dscthd;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaSP(int maSP) {
        ArrayList<CTHoaDon> dscthd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cthoadon WHERE MaSP="+maSP;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTHoaDon cthd = new CTHoaDon();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getDouble(4));
                cthd.setThanhTien(rs.getDouble(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dscthd;
    }

    public boolean addCTHoaDon(CTHoaDon cthd) {
        boolean result = false;
        try {
            String sql = "INSERT INTO cthoadon VALUES(?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, cthd.getMaHD());
            prep.setInt(2, cthd.getMaSP());
            prep.setInt(3, cthd.getSoLuong());
            prep.setDouble(4, cthd.getDonGia());
            prep.setDouble(5, cthd.getThanhTien());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    public boolean deleteCTHoaDon(int maHD, int maSP) {
        boolean result = false;
        try {
            String sql = "DELETE FROM cthoadon WHERE MaHD="+maHD+" AND MaSP="+maSP;
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean deleteCTHoaDon(int maHD) {
        boolean result = false;
        try {
            String sql = "DELETE FROM cthoadon WHERE MaHD="+maHD;
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateCTHoaDon(int maHD, int maSP, CTHoaDon cthd) {
        boolean result = false;
        try {
            String sql = "UPDATE cthoadon SET MaHD=?, MaSP=?, SoLuong=?, DonGia=? ThanhTien=? "
                    + "WHERE MaHD=? AND MaSP=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1, cthd.getMaHD());
            prep.setInt(2, cthd.getMaSP());
            prep.setInt(3, cthd.getSoLuong());
            prep.setDouble(4, cthd.getDonGia());
            prep.setDouble(5, cthd.getThanhTien());
            prep.setInt(6, maHD);
            prep.setInt(7, maSP);
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
}
