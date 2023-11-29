/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class NhanVienBUS {
    public ArrayList<NhanVienDTO> list_PM;
    
    private NhanVienDAO pmDAO;
    
    public NhanVienBUS() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new NhanVienDAO();
        list_PM = pmDAO.docDB();
    }
    public void docDB() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new NhanVienDAO();
        list_PM = pmDAO.docDB();
        System.out.println("vào db thành công");
    }
    public ArrayList<NhanVienDTO> getList_PM() {
        return list_PM;
    }

    public void setList_PM(ArrayList<NhanVienDTO> list_PM) {
        this.list_PM = list_PM;
    }

    
}