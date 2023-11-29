/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.ReaderDTO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class ReaderDAO {
        Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
    public  ReaderDAO(){
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
    public void them(ReaderDTO dg){
        try{
            String qry = "INSERT into khachhang values(NULL";
             //qry=qry+"NULL";
            qry=qry+","+"'"+dg.ho+"'";
            qry=qry+","+"'"+dg.ten+"'";
                        qry=qry+","+"'"+dg.gioitinh+"'";
            qry=qry+","+"'"+dg.diachi+"'";
            qry=qry+","+"'"+dg.sdt+"'";
            qry=qry+"," + "'" +dg.tongct+"'";
            qry=qry+","+"'1'";
            qry=qry+")";
       
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 
        
    }
 
    public ArrayList<ReaderDTO> docDSDG(){
        ArrayList ds = new ArrayList<ReaderDTO>();
        try{
            String qry = "SELECT * FROM khachhang WHERE trangthai=1";
            PreparedStatement pst = con.prepareStatement(qry);
            rs = pst.executeQuery();
            while(rs.next()){
                ReaderDTO newdg = new ReaderDTO();
                newdg.id = rs.getInt(1);
                newdg.ho = rs.getString(2);
                newdg.ten = rs.getString(3);
                newdg.diachi = rs.getString(4);
                newdg.gioitinh = rs.getString(5);
                newdg.sdt = rs.getInt(6);
                newdg.tongct= rs.getInt(7);
            ds.add(newdg);
            }
             return ds;
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 

    return null;
   }
    public void xoa(String ma){
        try {
            String qry = "update khachhang set trangthai=0 where Ma='" + ma + "'";
            ptst = con.prepareCall(qry);
            ptst.executeUpdate();

        } catch (Exception e) {        }
    
    }
    public void sua(ReaderDTO dg){
        try{
            String qry = "UPDATE khachhang set ";
            qry=qry+" ho="+"'"+dg.ho+"'";
            qry=qry+",ten="+"'"+dg.ten+"'";
            qry=qry+",gioitinh="+"'"+dg.gioitinh+"'";
            qry=qry + ",diachi="+"'"+dg.diachi+"'";
            qry=qry+",sdt="+"'"+dg.sdt+"'";
            qry=qry+" where Ma = '"+dg.id+"'";  
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(SQLException e){JOptionPane.showMessageDialog(null,e);}
        
                         }
        }
     


            



