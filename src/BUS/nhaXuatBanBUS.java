package BUS;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import DTO.nhaXuatBanDTO;
import DAO.nhaXuatBanDAO;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DO THE TUNG
 */
public class nhaXuatBanBUS {

    static ArrayList<nhaXuatBanDTO> nxbList = new ArrayList<>();
    static nhaXuatBanDAO nxbdao = new nhaXuatBanDAO();

    public nhaXuatBanBUS() {
    
        docDanhSachNXB();
    }
    ;
    public void ReadData_BUS() {
        nhaXuatBanDAO data = new nhaXuatBanDAO();
        if (nxbList == null) {
            nxbList = new ArrayList<nhaXuatBanDTO>();
        }
        nxbList = data.ReadData();

        nxbList.addAll(data.ReadData());

    }
    public void docDanhSachNXB()
    {
        this.nxbList = nxbdao.ReadData();
    }
public  ArrayList <nhaXuatBanDTO> getDanhSachNXB()
 {
     if(nxbList== null)
     {
         docDanhSachNXB();
     }
     return this.nxbList;
     
 }
    public void insert_BUS(nhaXuatBanDTO nxb) {
        nhaXuatBanDAO data = new nhaXuatBanDAO();
        data.insert(nxb);
        nxbList.add(nxb);

    }

    public void xoa(int Ma) {
        nhaXuatBanDAO data = new nhaXuatBanDAO();
        data.xoa(Ma);
        nxbList.remove(findWithId(Ma));

    }

    public void sua(nhaXuatBanDTO nxb) {
        nhaXuatBanDAO data = new nhaXuatBanDAO();
        data.sua(nxb);
    }

  public  nhaXuatBanDTO findWithId(int Ma) {
        for (nhaXuatBanDTO x : nxbList) {
            if (x.getMaNhaSanXuat() == Ma) {
                return x;
            }

        }
        return null;

    }

    public boolean checkMaNXB(int Ma, int soDienThoai) {
//      

        return nxbdao.checkExist(Ma, soDienThoai);

    }

// 
//    
    public ArrayList< nhaXuatBanDTO> TimMa(int Ma) {
        ArrayList< nhaXuatBanDTO> ds = new ArrayList<>();

        nxbList = nxbdao.ReadData();
        for (nhaXuatBanDTO list_filter : nxbList) {
            if (list_filter.getMaNhaSanXuat() == Ma) {
                ds.add(list_filter);
            }

        }
        return ds;
    }

    public DefaultTableModel returnTable(ArrayList<nhaXuatBanDTO> ds) {
        Vector header = new Vector();
        header.add(" Ma");
        header.add(" Ten");
        header.add("Dia Chi ");
        header.add(" so dien thoai");
        DefaultTableModel tablemodel2 = new DefaultTableModel(header, 0);
        if (tablemodel2.getRowCount() == 0) {

            tablemodel2 = new DefaultTableModel(header, 0);
        }
        for (int i = 0; i < ds.size(); i++) {
            Vector row = new Vector();
            row.add(ds.get(i).getMaNhaSanXuat());
            row.add(ds.get(i).getTenNhaXuatBan()
            );
            row.add(ds.get(i).getDiaChi());
            row.add(ds.get(i).getSoDienThoai());
            tablemodel2.addRow(row);
        }
        return tablemodel2;

    }
    public  String getTenNhaXuatBan(int ma)
    {
        for( nhaXuatBanDTO nxb : nxbList)
        {
            if(nxb.getMaNhaSanXuat() == ma)
            {
                return nxb.getMaNhaSanXuat()+"-"+nxb.getTenNhaXuatBan();
            }
        }
        return "";
        
    }
    
    
}
