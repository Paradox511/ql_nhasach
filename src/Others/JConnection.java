/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class JConnection {
     public static Connection con = null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thuvien","root","");
            return con;
            
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);
                               return null;}
    }
}
