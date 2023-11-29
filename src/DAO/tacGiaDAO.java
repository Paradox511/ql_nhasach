/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.nhaXuatBanDTO;
import DTO.tacGiaDTO;

import com.mysql.cj.protocol.Resultset;
import java.util.ArrayList;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author DO THE TUNG
 */
public class tacGiaDAO {

    public static Connection con = null;
    public static PreparedStatement ptst = null;
    public static Resultset rs = null;

    public tacGiaDAO() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach", "root", "");

            } catch (Exception e) {

            }
        }
    }

    public void them_dao(tacGiaDTO tg) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
 String sql = "insert Into tacgia(Ma,Ten,gioitinh)" + "  VALUES (NULL,?,?)";
         
            PreparedStatement ptst = con.prepareStatement(sql);
          //  ptst.setString(1, tg.getHo());
            ptst.setString(1, tg.getTen());
            ptst.setString(2, tg.getGioiTinh());
           
            

      //      ptst = con.prepareStatement(sql);
            ptst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

        }

    }

 public   boolean checkExist(int Ma) {
        try {

            String qry = "select * from tacgia where Ma='" + Ma +"'";
//           ma='Ma' AND soDienThoi='soDienThoai';
            PreparedStatement ptst = con.prepareCall(qry);
            ResultSet rs = ptst.executeQuery();

            if (!rs.next()) {
                return false;

            }
            return true;

        } catch (Exception e) {
        }

        return false;
    }

   public ArrayList ReadData() {
       
        try {
             ArrayList<tacGiaDTO> ds = new ArrayList<>();
            String qry = "SELECT * FROM tacgia ";
            PreparedStatement ptst = con.prepareStatement(qry);
            ResultSet rs = ptst.executeQuery();
            while (rs.next()) {
                tacGiaDTO tgdto = new tacGiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
                ds.add(tgdto);
            }
            return ds;
        } catch (Exception e) {
        }
        return null;
    }

  public  void xoa(int Ma) {
        try {
            String qry = "update tacgia set trangthai=0 where Ma='" + Ma + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {

        }
    }

  public  void sua(tacGiaDTO tgdto) {
        try {

            String qry = "UPDATE tacgia set ";
            qry = qry + " Ten=" + "'" + tgdto.Ten + "'";
//               qry = qry+",MaNhaSanXuat"+"'"+nxb.MaNhaSanXuat+"'";

         //   qry = qry + ",Ho=" + "'" + tgdto.Ho + "'";
            qry = qry + ",GioiTinh=" + "'" + tgdto.GioiTinh + "'";
            qry = qry + "where Ma= '" + tgdto.Ma + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog((null), e);
        }
    }


}
