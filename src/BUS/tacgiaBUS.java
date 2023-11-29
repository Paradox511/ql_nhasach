/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.tacGiaDAO;
import DTO.tacGiaDTO;
import DTO.tacGiaDTO;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class tacgiaBUS {
    static ArrayList<tacGiaDTO> tgList = new ArrayList<>();
    static tacGiaDAO tgdao = new tacGiaDAO();

    public tacgiaBUS() {
      docDanhSachTacGia();
        
    }

    ;
    public void ReadData_BUS() {
       tacGiaDAO data = new tacGiaDAO();
        if (tgList == null) {
            tgList = new ArrayList<tacGiaDTO>();
        }
        tgList = data.ReadData();

        tgList.addAll(data.ReadData());


    }

    public void insert_BUS(tacGiaDTO tg) {
        tacGiaDAO data = new tacGiaDAO();
        data.them_dao(tg);
        tgList.add(tg);

    }
     public int getMaTacGia(String ma){
        String[] str = ma.split("-");
        int id = Integer.parseInt(str[0]);
        return id;
    }

    public void xoa(int Ma) {
      tacGiaDAO data = new tacGiaDAO();
        data.xoa(Ma);
        tgList.remove(findWithId(Ma));

    }

    public void sua(tacGiaDTO tgdto) {
        tacGiaDAO data = new tacGiaDAO();
        data.sua(tgdto);
    }

    public tacGiaDTO findWithId(int Ma) {
        for (tacGiaDTO x : tgList) {
            if (x.getMa() == Ma) {
                return x;
            }

        }
        return null;

    }

   public boolean checkMaTacGia(int Ma) {


        return tgdao.checkExist(Ma);

    }


    public ArrayList< tacGiaDTO> TimMaTacGia(int Ma) {
        ArrayList<tacGiaDTO> ds = new ArrayList<>();
        
        tgList = tgdao.ReadData();
        for (tacGiaDTO list_filter : tgList) {
            if (list_filter.getMa()==Ma) 
            {
                ds.add(list_filter);
            }

        }
        return ds;
    }

    public int getMafromTen(String ten){
        for(tacGiaDTO tg : tgList){
            String hoten = tg.getTen();
            if(hoten.equalsIgnoreCase(ten))
                return tg.getMa();
        }
        return 0;
    }
    public DefaultTableModel returnTable(ArrayList<tacGiaDTO> ds) {
        Vector header = new Vector();
        header.add(" Ma");
      //  header.add(" Ho");
        header.add(" Ten ");
        header.add(" Gioi Tinh");
     //   header.add(" so Dien Thoai ");
        
        DefaultTableModel tablemodel2 = new DefaultTableModel(header, 0);
        if (tablemodel2.getRowCount() == 0) {

            tablemodel2 = new DefaultTableModel(header, 0);
        }
        for (int i = 0; i < ds.size(); i++) {
            Vector row = new Vector();
            row.add(ds.get(i).getMa());
            
        //    row.add(ds.get(i).getHo());
            row.add(ds.get(i).getTen());
            row.add(ds.get(i).getGioiTinh());
     
            tablemodel2.addRow(row);
        }
        return tablemodel2;

    }
//    xu ly tim kiem
    
    public String getTenTacGia(int ma)
    {
        for( tacGiaDTO tenTacgia : tacgiaBUS.tgList)
        {
            if( tenTacgia.getMa()==ma)
            {
                return tenTacgia.getMa()+"-"+ tenTacgia.getTen();
            }
        
        }
        return "0";
        
    }
       public String getTentg(int ma)
    {
            for( tacGiaDTO tenTacgia : tacgiaBUS.tgList)
        {
            if( tenTacgia.getMa()==ma)
            {
                return tenTacgia.getTen() + "";
            }
        
        }
        return "0";
        
    }
    
//     code them phuc vu cho sach combobox
    public void docDanhSachTacGia()
    {
        this.tgList = tgdao.ReadData();
    }
    
    
 public  ArrayList <tacGiaDTO> getDanhSachTacGia()
 {
     if(tgList== null)
     {
         docDanhSachTacGia();
     }
     return this.tgList;
     
 }
 public void Search(String ma,JComboBox cboxFilter,JLabel jLabel3,JTable tblRsearch){
            tacgiaBUS bus = new tacgiaBUS();
         Vector header = new Vector();
        header.add("Mã");
        header.add("Tên");
        header.add("Họ");
        header.add("Giới tính");
        header.add("Số điện thoại");
        DefaultTableModel dtmtacgia2 = new DefaultTableModel(header,0);
 
        switch(cboxFilter.getSelectedItem().toString()){
            case "Mã":
                tblRsearch.removeAll();
         jLabel3.setText("Tìm kiếm theo mã");
        tacGiaDTO nv = bus.findWithId(Integer.parseInt(ma));
           if(nv == null){
               JOptionPane.showMessageDialog(null,"Khong tim thay tac gia.");
           } 
           else{
        Vector row1 = new Vector();
        row1.add(nv.getMa());
        row1.add(nv.getTen());
       // row1.add(nv.getHo());
        row1.add(nv.getGioiTinh());
        dtmtacgia2.addRow(row1);
        tblRsearch.setModel(dtmtacgia2);
            }
            break;
    /*          case "Họ":
                jLabel3.setText("Tìm kiếm theo họ");
                tblRsearch.removeAll();
              ArrayList<tacGiaDTO> dstim = timkiemtheoHo(ma) ;
            for(tacGiaDTO newnv: dstim){
        Vector row2 = new Vector();
        row2.add(newnv.getMa());
        row2.add(newnv.getTen());
     //   row2.add(newnv.getHo());
        row2.add(newnv.getGioiTinh());
        dtmtacgia2.addRow(row2);
        tblRsearch.setModel(dtmtacgia2);
            }
      if(dstim==null)
          JOptionPane.showMessageDialog(null,"không tìm thấy tác giả.");
      
        break;*/
        case "Tên":
            jLabel3.setText("Tìm kiếm theo tên");
            tblRsearch.removeAll();
            ArrayList<tacGiaDTO> dsten = timkiemtheoTen(ma);
            for(tacGiaDTO newnv:dsten){
                Vector row3=new Vector();
        row3.add(newnv.getMa());
        row3.add(newnv.getTen());
     //   row3.add(newnv.getHo());
        row3.add(newnv.getGioiTinh());
        dtmtacgia2.addRow(row3);
        tblRsearch.setModel(dtmtacgia2);
            }
        }
    }
 
 public ArrayList<tacGiaDTO> timkiemtheoTen(String ten){
     ArrayList dsten = new ArrayList<tacGiaDTO>();
     for(tacGiaDTO nv: tgList){
         if(nv.getTen().contains(ten)){
             dsten.add(nv);
         }
     }
     return dsten;
 }
 public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
  public String thongketheoPhai(){
       ArrayList<tacGiaDTO> male = new ArrayList();
       ArrayList<tacGiaDTO> female = new ArrayList();
       for(tacGiaDTO m: tgList){
           if(m.getGioiTinh().equalsIgnoreCase("Nam"))
               male.add(m);
           else female.add(m);
       }
        return "Tỷ lệ Nam/Nữ: " + male.size()+"/"+female.size();
    }
}
