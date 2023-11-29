/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.giamgiaDAO.conn;
import DTO.giamgiaDTO;
import DTO.giamgiaDTO;
import DTO.giamgiaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class giamgiaDAO {
      public static Connection conn = null;
    public static PreparedStatement ptst = null;
    public static ResultSet rs = null;

    public giamgiaDAO() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach", "root", "");
            } catch (Exception e) {
            }
        }
    }

    public ArrayList<giamgiaDTO> getListgg() {

        try {
            String sql = " select * from  giamgia where trangthai =1";
            PreparedStatement ptst = conn.prepareStatement(sql);
            ResultSet rs = ptst.executeQuery();
            ArrayList<giamgiaDTO> dssp = new ArrayList<>();
            while (rs.next()) {
                giamgiaDTO gg = new giamgiaDTO();
                gg.setMa(rs.getInt(1));
                gg.setTen(rs.getString(2));
                gg.setDk(rs.getInt(4));
                gg.setPhantram(rs.getDouble(3));
                
                dssp.add(gg);
            }
            return dssp;

        } catch (Exception e) {
        }
        return null;

    }

    public ArrayList docdsgg(){
        ArrayList ds = new ArrayList<giamgiaDTO>();
        try{
            String qry = "SELECT * FROM giamgia WHERE Trangthai=1";
            PreparedStatement pst = conn.prepareCall(qry);
            rs = pst.executeQuery();
            while(rs.next()){
                giamgiaDTO newgg = new giamgiaDTO(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
            ds.add(newgg);
            }
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 

     return ds;
    }
    public boolean checkExist(int ma) {
        try {
            String qry = " select * from giamgia where Ma='" + ma + "'";
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
    
    public boolean themkm(giamgiaDTO giamgia) {

        try {

            String sql = "insert Into giamgia(Magg,Tengg,Phantramgg,Dieukien,trangthai)" + "  VALUES (NULL,?,?,?,?)";
         
            PreparedStatement ptst = conn.prepareStatement(sql);
            ptst.setString(1, giamgia.getTen());
            ptst.setDouble(2, giamgia.getPhantram());
            ptst.setInt(3,giamgia.getDk());
            ptst.setInt(4, 1);
            ptst.execute();
            return true;

        } catch (SQLException e) {

        }

        return false;

    }

     public boolean xoakm(int makm) {
        try {
            String sql = "update giamgia set trangthai = 0 where ma='" + makm + "'";
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;

        } catch (Exception e) {
        }
        return false;

    }

    public boolean suaSach(giamgiaDTO giamgia) {
        try {
            String sql = " update giamgia set" + " Teng=?,"
                    + "PhanTramgg=?,Dieukien=?,"
                    + "where Magg=? ";
            PreparedStatement ptst = conn.prepareCall(sql);
            ptst.setString(1, giamgia.getTen());

            ptst.setDouble(2, giamgia.getPhantram());
            ptst.setInt(3, giamgia.getDk());

            ptst.setInt(4, giamgia.getMa());
            ptst.execute();
            return true;

        } catch (Exception e) {

        }
        return false;

    }
}
