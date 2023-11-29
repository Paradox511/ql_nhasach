/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class MyConnect {
    public static Connection conn = null;
    private String serverName;
    private String dbName;
    private String userName;
    private String password;

    public MyConnect() {
        //docFileText();
        serverName = "localhost:3306";
        dbName= "nhasach";
        userName = "root";
        String strConnect = "jdbc:mysql://" + serverName + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        Properties pro = new Properties();
        pro.put("user", userName);
        pro.put("password", password);
        try {
            com.mysql.jdbc.Driver driver = new Driver();
            conn = driver.connect(strConnect, pro);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Không kết nối được tới CSDL!");
            System.exit(0);
        }

    }
}
