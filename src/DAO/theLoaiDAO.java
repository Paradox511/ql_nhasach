/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.theLoaiDTO;
import java.util.ArrayList;
import java.sql.*;
import java.sql.ResultSet;

/**
 *
 * @author DO THE TUNG
 */
public class theLoaiDAO {

    public static Connection conn = null;
    public static PreparedStatement ptst = null;
    public static ResultSet rs = null;

    public theLoaiDAO() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach", "root", "");

            } catch (Exception e) {

            }
        }
    }

    public ArrayList<theLoaiDTO> getListTheLoai() {
        try {
            String sql = " select * from theloai where trangthai=1";
            PreparedStatement ptst = conn.prepareStatement(sql);

            ResultSet rs = ptst.executeQuery();
            ArrayList<theLoaiDTO> dsTheLoai = new ArrayList<>();
            while (rs.next()) {
                theLoaiDTO theloai = new theLoaiDTO();

                theloai.setMa(rs.getInt(1));
                theloai.setTen(rs.getString(2));
                dsTheLoai.add(theloai);

            }

            return dsTheLoai;
        } catch (Exception e) {

        }
        return null;

    }

    public boolean themTheLoai(theLoaiDTO theloai) {
        try {
            String sql = "insert into theloai(Ma,Ten,TrangThai) values(?,?,?)";
            PreparedStatement ptst = conn.prepareStatement(sql);
            ptst.setInt(1, theloai.getMa());
            ptst.setString(2, theloai.getTen());
            ptst.setInt(3, 1);
            
            ptst.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("test them dao");
        }
        return false;

    }

    public boolean xoaTheLoai(int maTheLoai) {
        try {
            String sql = "update theloai set trangthai=0 where ma='" + maTheLoai + "'";
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {

        }
        return false;

    }

    public boolean suaTheLoai(theLoaiDTO theloai) {
        try {
            String sql = " update theloai set "
                    + " Ten =? where Ma=? ";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setString(1, theloai.getTen());
            ptst.setInt(2, theloai.getMa());
            ptst.execute();
            return true;

        } catch (Exception e) {
        }

        return false;

    }

    public boolean checkExist(int Ma) {
        try {
            String qry = " select *from theloai where Ma='" + Ma + "'";
            PreparedStatement ptst = conn.prepareCall(qry);
            ResultSet rs = ptst.executeQuery();
            if (!rs.next()) {
                return false;
                

            }
            return true;
            
        } catch ( Exception e) {

        }
        return false;
    }

}
