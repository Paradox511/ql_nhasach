/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.sachDTO;
import static Others.JConnection.con;
import com.mysql.cj.protocol.Resultset;
import java.util.ArrayList;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class sachDAO {

    public static Connection conn = null;
    public static PreparedStatement ptst = null;
    public static ResultSet rs = null;

    public sachDAO() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach", "root", "");
            } catch (Exception e) {
            }
        }
    }

    public ArrayList<sachDTO> getListSach() {

        try {
            String sql = " select * from  sach";
            PreparedStatement ptst = conn.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            ArrayList<sachDTO> dssp = new ArrayList<>();
            while (rs.next()) {
                sachDTO sach = new sachDTO();
                sach.setMa(rs.getInt(1));
                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));
                sach.setMaTheLoai(rs.getInt(4));
                sach.setNamSanXuat(rs.getInt(5));
                sach.setSoLuong(rs.getInt(6));
                sach.setAnh(rs.getString(7));
                sach.setGia(rs.getDouble(8));
                sach.setTt(rs.getInt(9));
                dssp.add(sach);
            }
            return dssp;

        } catch (Exception e) {
        }
        return null;

    }

    public boolean checkExist(int ma) {
        try {
            String qry = " select * from sach where Ma='" + ma + "'";
            PreparedStatement ptst = conn.prepareCall(qry);
            ResultSet rs = ptst.executeQuery();
            if (!rs.next()) {
                return false;

            }
            return true;
        } catch (Exception e) {

        }
        return false;
    }

     public void capNhatSoLuongSP(int ma, int soLuongMat) {
        sachDTO sp = getSanPham(ma);
        int soLuong = sp.getSoLuong();
        sp.setSoLuong(soLuong + soLuongMat);
        try {
            String sql = "UPDATE sach SET SoLuong=? WHERE Ma=" + ma;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, sp.getSoLuong());
            pre.executeUpdate();
        } catch (SQLException e) {
        }

    }
    public String getAnh(int ma) {
        try {
            String sql = "select Anh from sach where Ma=?";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setInt(1, ma);
            ResultSet rs = ptst.executeQuery();
            if (rs.next()) {
                return rs.getString(" Anh");

            }

        } catch (SQLException e) {

        }
        return "";

    }

    public boolean themSach(sachDTO sach) {

        try {

            String sql = "insert Into sach(Ma,Ten,MaTacGia,MaTheLoai,Namsx,soLuong,Anh,Gia,trangthai)" + "  VALUES (NULL,?,?,?,?,?,?,?,1)";
         
            PreparedStatement ptst = conn.prepareStatement(sql);
            ptst.setString(1, sach.getTen());
            ptst.setInt(2, sach.getMaTacGia());
            ptst.setInt(3, sach.getMaTheLoai());
            ptst.setInt(4, sach.getNamSanXuat());
            ptst.setInt(5, sach.getSoLuong());
            ptst.setString(6, sach.getAnh());
            ptst.setDouble(7, sach.getGia());
           
            ptst.execute();
            return true;

        } catch (SQLException e) {

        }

        return false;

    }

    public boolean xoaSanch(int maSach) {
        try {
            String sql = "update sach set trangthai = 0 where ma='" + maSach + "'";
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;

        } catch (Exception e) {
        }
        return false;

    }

    public boolean suaSach(sachDTO sach) {
        try {
            String sql = " update sach set" + " Ten=?,"
                    + "MaTacGia=?,MaTheLoai=?,MaNhaSanXuat=?,NamSanXuat=?,soLuong= ?,Anh=? ,Gia =? "
                    + "where Ma=? ";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setString(1, sach.getTen());

            ptst.setInt(2, sach.getMaTacGia());
            ptst.setInt(3, sach.getMaTheLoai());
            ptst.setInt(4, sach.getNamSanXuat());
            ptst.setInt(5, sach.getSoLuong());
            ptst.setString(6, sach.getAnh());
            ptst.setDouble(7, sach.getGia());
            ptst.setInt(8, sach.getMa());
            ptst.execute();
            return true;

        } catch (Exception e) {

        }
        return false;

    }
    public boolean nhapSanPhamTuExcel(sachDTO sach)
    {
        try 
        {
            String sql = "Update sach set trangthai=0; "
                    + "Insert into sach (Ten,matacgia,matheloai,manhasanxuat,namsanxuat,soluong,anh,gia,trangthai"
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ptst = conn.prepareStatement(sql);
             ptst.setString(1, sach.getTen());

            ptst.setInt(2, sach.getMaTacGia());
            ptst.setInt(3, sach.getMaTheLoai());
            ptst.setInt(4, sach.getNamSanXuat());
            ptst.setInt(5, sach.getSoLuong());
            ptst.setString(6, sach.getAnh());
            ptst.setDouble(7, sach.getGia());
          
            ptst.setInt(8,1);
            ptst.execute();
                    return true;
                    
                   
        }
        catch (Exception e)
        {
        }
        return false;
        
    }
    public ArrayList<sachDTO> timsl(String min,String max){
        int slmin = Integer.parseInt(min);
        int slmax = Integer.parseInt(max);
        ArrayList<sachDTO> tim = new ArrayList();
        String qry="SELECT * FROM sach WHERE SoLuong BETWEEN ? AND ?";
        PreparedStatement ptst;
        try {
            ptst = conn.prepareCall(qry);
            
           ptst.setInt(1, slmin);
           ptst.setInt(2, slmax);
           ResultSet rs = ptst.executeQuery();
           while(rs.next()){
               sachDTO sach =new sachDTO();
                sach.setMa(rs.getInt(1));
                sach.setTen(rs.getString(2));
                sach.setMaTacGia(rs.getInt(3));

                sach.setMaTheLoai(rs.getInt(4));
                sach.setNamSanXuat(rs.getInt(5));
                sach.setSoLuong(rs.getInt(6));
                sach.setAnh(rs.getString(7));
                sach.setGia(rs.getInt(8));
                tim.add(sach);
           }
        } catch (SQLException ex) {
            Logger.getLogger(sachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return tim;
    }
    public sachDTO getSanPham(int ma) {
        try {
            String sql = "SELECT *FROM Sach WHERE Ma=?";
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                sachDTO sp = new sachDTO();

                sp.setMa(rs.getInt(1));
                sp.setTen(rs.getString(2));
                sp.setMaTacGia(rs.getInt(3));
                sp.setMaTheLoai(rs.getInt(4));
                sp.setNamSanXuat(rs.getInt(5));
                sp.setSoLuong(rs.getInt(6));
                sp.setAnh(rs.getString(7));
                sp.setGia(rs.getInt(8));
                sp.setTt(rs.getInt(9));

                return sp;
            }
        } catch (SQLException e) {
        }

        return null;
    }
    
}
