/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import java.util.ArrayList;
import DAO.*;
import DTO.*;
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
 * @author ADMIN
 */
public class EmployeeBUS {
  public  static ArrayList<EmployeeDTO> dsnv;
   public EmployeeBUS(){}
  public static void docDSNV(){
        EmployeeDAO data=new EmployeeDAO();
        if(dsnv==null)dsnv=new ArrayList<EmployeeDTO>();
        dsnv=data.docDSNV();
    }
  public static ArrayList<EmployeeDTO> getdsnv(){
      if(dsnv==null){
          docDSNV();
      }
      return EmployeeBUS.dsnv;
  }
   public void them(EmployeeDTO nv){
        EmployeeDAO data = new EmployeeDAO();
        data.them(nv);
        dsnv.add(nv);
    }
    public void xoa(int ma){
        EmployeeDAO data = new EmployeeDAO();
        data.xoa(ma);
        dsnv.remove(timkiemtheoMa(ma));
        
        
    }
    public void sua(EmployeeDTO nv){
        EmployeeDAO data = new EmployeeDAO();
        data.sua(nv);
        
        
    }
    public EmployeeDTO getMafromTen(String hoten){
        for(EmployeeDTO e : dsnv){
            String name = e.getho() + " " + e.getten();
            if(name.equals(hoten)){
                return e;
            }
        }
        return null;
    }
   public boolean checkID(int ma){ 
        for(EmployeeDTO s: dsnv){
            if(ma==s.getid()){

                return false;
            }
        }
        return true;
    }
     public void khoitao(EmployeeDTO nv,DefaultTableModel model,JTable tblNhanvien){
    Vector header = new Vector();
        header.add("Mã ");
        header.add("Họ nhân viên");
        header.add("Tên nhân viên");
        header.add("Giới tính");
        header.add("Phân quyền");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
   if(model.getRowCount()==0){
       model = new DefaultTableModel(header,0);
   }
   Vector row = new Vector();
        row.add(nv.id);
        row.add(nv.ho);
        row.add(nv.ten);
        row.add(nv.gioitinh);
        row.add(nv.phanquyen);
        row.add(nv.diachi);
        row.add(nv.sdt);
  if(checkID(nv.getid())){
      model.addRow(row);
      tblNhanvien.setModel(model);
      them(nv);
      JOptionPane.showMessageDialog(null,"Thêm thành công.");
  }
  else{
      JOptionPane.showMessageDialog(null,"Mã bị trùng khớp");
  }
        
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
  public  EmployeeDTO timkiemtheoMa(int ma){
       // EmployeeDTO nv = new EmployeeDTO();
        for(EmployeeDTO nv: dsnv){
            if(ma == nv.getid()){
                return nv;
            }
            
        }
        return null;
                
    }
    public ArrayList<EmployeeDTO> timlKiemSachLive(String keyword)
    {
        keyword = keyword.toLowerCase();
        ArrayList<EmployeeDTO> dsSach = new ArrayList<>();
        for(EmployeeDTO live_tim_sach :dsnv)
        {
            String tenSach=live_tim_sach.getten().toLowerCase();
            if(tenSach.contains(keyword))
            {
                dsSach.add(live_tim_sach);
            }
        }
        return dsSach;
        
    }

 public   ArrayList<EmployeeDTO> timkiemtheoHo(String ho){
        ArrayList dstim = new ArrayList<EmployeeDTO>();
        for(EmployeeDTO nv: dsnv){
            if(nv.getho().equalsIgnoreCase(ho)){
                dstim.add(nv);
            }
        }
        return dstim;
    }
 public ArrayList<EmployeeDTO> timkiemtheoTen(String ten){
     ArrayList dsten = new ArrayList<EmployeeDTO>();
     for(EmployeeDTO nv: dsnv){
         if(nv.getten().contains(ten)){
             dsten.add(nv);
         }
     }
     return dsten;
 }
    public String thongketheoPhai(){
       ArrayList<EmployeeDTO> male = new ArrayList();
       ArrayList<EmployeeDTO> female = new ArrayList();
       for(EmployeeDTO e: dsnv){
           if(e.getgioitinh().equalsIgnoreCase("Nam"))
               male.add(e);
           else female.add(e);
       }
        return "Tỷ lệ Nam/Nữ: " + male.size()+"/"+female.size();
    }
  /*  public void Search(String ma,JComboBox cboxFilter,JLabel jLabel3,JTable tblRsearch){
            EmployeeBUS bus = new EmployeeBUS();
         Vector header = new Vector();
        header.add("Mã");
        header.add("Họ");
        header.add("Tên");
        header.add("Lương");
        header.add("Địa chỉ");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Số điện thoại");
        DefaultTableModel dtmNhanvien2 = new DefaultTableModel(header,0);
 
        switch(cboxFilter.getSelectedItem().toString()){
            case "Mã":
                tblRsearch.removeAll();
         jLabel3.setText("Tìm kiếm theo mã");
        EmployeeDTO nv = bus.timkiemtheoMa(ma);
           if(nv == null){
               JOptionPane.showMessageDialog(null,"Khong tim thay nhan vien.");
           } 
           else{
        Vector row1 = new Vector();
        row1.add(nv.getid());
        row1.add(nv.getho());
        row1.add(nv.getten());
        row1.add(nv.getPhanquyen());
        row1.add(nv.getDiachi());
        row1.add(nv.getngaysinh());
        row1.add(nv.getgioitinh());
        row1.add(nv.getsdt());
        dtmNhanvien2.addRow(row1);
        tblRsearch.setModel(dtmNhanvien2);
            }
            break;
            case "Họ":
                jLabel3.setText("Tìm kiếm theo họ");
                tblRsearch.removeAll();
                ArrayList<EmployeeDTO> dstim = timkiemtheoHo(ma) ;
            for(EmployeeDTO newnv: dstim){
        Vector row2 = new Vector();
        row2.add(newnv.getid());
        row2.add(newnv.getho());
        row2.add(newnv.getten());
        row2.add(newnv.getluong());
        row2.add(newnv.getDiachi());
        row2.add(newnv.getngaysinh());
        row2.add(newnv.getgioitinh());
        row2.add(newnv.getsdt());
        dtmNhanvien2.addRow(row2);
        tblRsearch.setModel(dtmNhanvien2);
            }
      if(dstim==null)
          JOptionPane.showMessageDialog(null,"không tìm thấy nhân viên.");
      
        break;
        case "Tên":
            jLabel3.setText("Tìm kiếm theo tên");
            tblRsearch.removeAll();
            ArrayList<EmployeeDTO> dsten = timkiemtheoTen(ma);
            for(EmployeeDTO newnv:dsten){
                Vector row3=new Vector();
                row3.add(newnv.getid());
                row3.add(newnv.getho());
                row3.add(newnv.getten());
                row3.add(newnv.getluong());
                row3.add(newnv.getDiachi());
                row3.add(newnv.getngaysinh());
                row3.add(newnv.getgioitinh());
                row3.add(newnv.getsdt());
        dtmNhanvien2.addRow(row3);
        tblRsearch.setModel(dtmNhanvien2);
            }
        }
    }*/
}
