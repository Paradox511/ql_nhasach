/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class NhaCungCapBUS {
    public ArrayList<NhaCungCapDTO> list_PM;
    
    private NhaCungCapDAO pmDAO;
    
    public NhaCungCapBUS() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new NhaCungCapDAO();
        list_PM = pmDAO.docDB();
    }
    public void docDB() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new NhaCungCapDAO();
        list_PM = pmDAO.docDB();
        System.out.println("vào db thành công");
    }
    public ArrayList<NhaCungCapDTO> getList_PM() {
        return list_PM;
    }

    public void setList_PM(ArrayList<NhaCungCapDTO> list_PM) {
        this.list_PM = list_PM;
    }

    
}