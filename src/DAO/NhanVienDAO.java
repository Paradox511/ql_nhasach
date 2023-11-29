/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class NhanVienDAO {
    MyConnectUnit connect;
    
    //Lấy thông tin từ db
    public ArrayList<NhanVienDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new MyConnectUnit();
        
        ResultSet result = this.connect.Select("nhanvien", condition, orderBy);
        ArrayList<NhanVienDTO> pmuons = new ArrayList<>();
        while ( result.next() ) {
            NhanVienDTO pmuon = new NhanVienDTO();
            pmuon.setMa(result.getInt("Ma"));
            pmuon.setLuong(result.getInt("Luong"));
            pmuon.setSoDienThoai(result.getInt("SoDienThoai"));
            pmuon.setDiaChi(result.getString("DiaChi"));
            pmuon.setGioiTinh(result.getString("GioiTinh"));
            pmuon.setTen(result.getString("Ten"));
            pmuon.setHo(result.getString("Ho"));
            pmuon.setNgaySinh(result.getString("NgaySinh"));
            pmuons.add(pmuon);
        }
        connect.Close();
        return pmuons;
    }
    
    public ArrayList<NhanVienDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }
    
    public ArrayList<NhanVienDTO> docDB() throws Exception {
        System.out.println("đã docdb");
        return docDB(null);
    }
}

    