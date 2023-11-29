
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import GUI.*;
import DTO.EmployeeDTO;
import BUS.EmployeeBUS;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class EmployeeDAO {
        Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
     public  EmployeeDAO(){
        if(con == null){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach","root","");
            }
        catch(ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, e);}
        }            
       }
    public void them(EmployeeDTO nv){
        try{
            String qry = "INSERT into nhanvien values(NULL";
            qry=qry+","+"'"+nv.ho+"'";
            qry=qry+","+"'"+nv.ten+"'";
            qry=qry+","+"'"+nv.gioitinh+"'";

            qry=qry+","+"'"+nv.phanquyen+"'";
            qry=qry+","+"'"+nv.diachi+"'";
            qry=qry+","+"'"+nv.sdt+"'";
            qry=qry+","+"'1'";
            qry=qry+")";
       
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 
        
    }

   public ArrayList docDSNV(){
        ArrayList ds = new ArrayList<EmployeeDTO>();
        try{
            String qry = "SELECT * FROM nhanvien";
            PreparedStatement pst = con.prepareCall(qry);
            rs = pst.executeQuery();
            while(rs.next()){
                EmployeeDTO newnv = new EmployeeDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
            ds.add(newnv);
            }
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);} 

     return ds;
    }
    public void xoa(int ma){
        try{
            String qry = "DELETE from nhanvien where Ma = '" + ma + "'";
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        }
    public void sua(EmployeeDTO nv){
        try{
            String qry = "UPDATE nhanvien set ";
            qry=qry+" ho="+"'"+nv.ho+"'";
            qry=qry+",ten="+"'"+nv.ten+"'";
            qry=qry+",phanquyen="+"'"+nv.phanquyen+"'";
            qry=qry+",diachi="+"'"+nv.diachi+"'";
            qry=qry+",gioitinh="+"'"+nv.gioitinh+"'";
            qry=qry+",sdt="+"'"+nv.sdt+"'";
            qry=qry+" where Ma = '"+nv.id+"'";
            ptst = con.prepareStatement(qry);
            ptst.executeUpdate();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        
                         }
        }
     


            




