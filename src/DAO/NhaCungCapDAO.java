/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaCungCapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quang
 */
public class NhaCungCapDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<NhaCungCapDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("nhacungcap", condition, orderBy);
        ArrayList<NhaCungCapDTO> pmuons = new ArrayList<>();
        while ( result.next() ) {
            NhaCungCapDTO pmuon = new NhaCungCapDTO();
            pmuon.setMa(result.getInt("Ma"));
            pmuon.setSoDienThoai(result.getInt("SoDienThoai"));
            pmuon.setDiaChi(result.getString("DiaChi"));
            pmuon.setTen(result.getString("Ten"));
            pmuons.add(pmuon);
        }
        connect.Close();
        return pmuons;
    }
    
    public ArrayList<NhaCungCapDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<NhaCungCapDTO> docDB() throws Exception {
        return docDB(null);
    }
    
    /*
     Tạo thêm 1 pmuon dựa theo đã có thông tin trước
     * @return true nếu thành công
     */
    public Boolean them(NhaCungCapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("SoDienThoai", nv.getSoDienThoai());
        insertValues.put("DiaChi", nv.getDiaChi());
        insertValues.put("Ma", nv.getMa());
        insertValues.put("Ten", nv.getTen());
        
        Boolean check = connect.Insert("nhacungcap", insertValues);        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nv chuyền vào dữ liệu tài khoản để xóa
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean xoa(NhaCungCapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        String condition = "Ma = '"+nv.getMa()+"'";
        
        Boolean check = connect.Delete("nhacungcap", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nv truyền vào dữ liệu tài khoản mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 tài khoản
     * @return true nếu thành công
     * @throws java.lang.Exception
     */
    public Boolean sua(NhaCungCapDTO nv) throws Exception {
        connect = new MyConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("DiaChi", nv.getDiaChi());
        insertValues.put("SoDienThoai", nv.getSoDienThoai());
        insertValues.put("Ten", nv.getTen());
        
        String condition = " Ma = '"+nv.getMa()+"'";
        
        Boolean check = connect.Update("nhacungcap", insertValues, condition);
        
        connect.Close();
        return check;
    }
}
