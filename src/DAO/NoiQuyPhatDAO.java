/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NoiQuyPhatDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quang
 */
public class NoiQuyPhatDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<NoiQuyPhatDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("noiquyphat", condition, orderBy);
        ArrayList<NoiQuyPhatDTO> pmuons = new ArrayList<>();
        while ( result.next() ) {
            NoiQuyPhatDTO pmuon = new NoiQuyPhatDTO();
            pmuon.setMa(result.getInt("Ma"));
            pmuon.setCongThuc(result.getString("CongThuc"));
            pmuon.setNoiDung(result.getString("Noidung"));
            pmuons.add(pmuon);
        }
        connect.Close();
        return pmuons;
    }
    
    public ArrayList<NoiQuyPhatDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<NoiQuyPhatDTO> docDB() throws Exception {
        return docDB(null);
    }
    public Boolean them(NoiQuyPhatDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("Ma", nv.getMa());
        insertValues.put("CongThuc", nv.getCongThuc());
        insertValues.put("NoiDung", nv.getNoiDung());
        
        Boolean check = connect.Insert("noiquyphat", insertValues);        
        connect.Close();
        return check;
    }
    public Boolean xoa(NoiQuyPhatDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = "Ma = '"+nv.getMa()+"'";
        
        Boolean check = connect.Delete("noiquyphat", condition);
        
        connect.Close();
        return check;
    }

    
}
