/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.security.interfaces.DSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.nimbus.NimbusStyle;
import DTO.nhaXuatBanDTO;

/**
 *
 * @author DO THE TUNG
 */
public class nhaXuatBanDAO {

    Connection con = null;
    PreparedStatement ptst = null;
    ResultSet rs = null;

    public nhaXuatBanDAO() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach", "root", "");

            } catch (Exception e) {

            }
        }
    }

    public void insert(nhaXuatBanDTO nxb) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            String qry = "INSERT into nhaxuatban values(";
            qry = qry + "'" + nxb.MaNhaSanXuat + "'";

            qry = qry + "," + "'" + nxb.TenNhaXuatBan + "'";
            qry = qry + "," + "'" + nxb.DiaChi + "'";
            qry = qry + "," + "'" + nxb.soDienThoai + "'";
            qry = qry + "," + "'" + 1 + "'";
            qry = qry + ")";

            ptst = con.prepareCall(qry);
            ptst.executeUpdate();
//
//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach","root","");
//String sql = "INSERT into nhaxuatban(Ma,Ten,DiaChi,SoDienThoai) value (?,?,?,?)";
//statement = connection.prepareCall(sql);
//statement.setInt( 0,nxb.getMaNhaSanXuat() );
//statement.setString(1, nxb.getTenNhaXuatBan());
//statement.setString( 2 , nxb.getDiaChi());
//statement.setInt( 3,nxb.getSoDienThoai());
//statement.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        } finally {

        }
    }

  public  boolean checkExist(int Ma, int soDienThoai) {

        try {
            String qry = " select * from nhaxuatban where Ma='" + Ma + "'" + " OR soDienThoai='" + soDienThoai + "'";
            PreparedStatement ptst = con.prepareCall(qry);
            rs = ptst.executeQuery();
            if (!rs.next()) {
                return false;
            }
            return true;

        } catch (Exception e) {
        }
        return false;
    }

   public  ArrayList ReadData() {
        ArrayList ds = new ArrayList<nhaXuatBanDTO>();
        try {
            String qry = "SELECT * FROM nhaxuatban where trangthai =1 ";
            PreparedStatement ptst = con.prepareCall(qry);
            rs = ptst.executeQuery();
            while (rs.next()) {
                nhaXuatBanDTO newNXB = new nhaXuatBanDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ds.add(newNXB);
            }
        } catch (Exception e) {
        }
        return ds;
    }

    public void xoa(int Ma) {
        try {
            String qry = "update  nhaxuatban set trangthai=0 where Ma='" + Ma + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void sua(nhaXuatBanDTO nxb) {
        try {

            String qry = "UPDATE nhaxuatban set ";
            qry = qry + " Ten=" + "'" + nxb.TenNhaXuatBan + "'";
//               qry = qry+",MaNhaSanXuat"+"'"+nxb.MaNhaSanXuat+"'";
            qry = qry + ",DiaChi=" + "'" + nxb.DiaChi + "'";
            qry = qry + ",SoDienThoai=" + "'" + nxb.soDienThoai + "'";

            qry = qry + "where Ma= '" + nxb.MaNhaSanXuat + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog((null), e);
        }
    }
}
