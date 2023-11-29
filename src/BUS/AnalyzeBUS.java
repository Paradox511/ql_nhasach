/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DAO.AnalyzeDAO;

/**
 *
 * @author ADMIN
 */
public class AnalyzeBUS {
    AnalyzeDAO dao = new AnalyzeDAO();
    public int getsoluongSach(){
        return dao.getSoLuongSach();
    }
    public int getsoluongDocgia(){
        return dao.getSoLuongDocgia();
    }
    public int getsoluongNhanvien(){
        return dao.getSoLuongNhanVien();
    }
    public int getsoluongMuon(){
        return dao.getsoluongMuon();
    }
}
