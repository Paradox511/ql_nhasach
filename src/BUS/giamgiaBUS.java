/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.giamgiaDAO;
import DAO.giamgiaDAO;
import DTO.giamgiaDTO;
import DTO.giamgiaDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ADMIN
 */
public class giamgiaBUS {
       public static ArrayList<giamgiaDTO> listgg ;
    public static giamgiaDAO giamgiadAO = new giamgiaDAO();

    public giamgiaBUS() {
        docdsgg();

    }
    public static void docdsgg(){
        giamgiaDAO data=new giamgiaDAO();
        if(listgg==null)listgg=new ArrayList<giamgiaDTO>();
        listgg=data.docdsgg();
    }
    public static void doclistgg(){
        listgg = giamgiadAO.getListgg();
    }
    
     public static ArrayList<giamgiaDTO> getListgg() {
        if(listgg==null)
          docdsgg();
      return giamgiaBUS.listgg;
    }
      public void insert_BUS(giamgiaDTO nxb) {
        giamgiaDAO data = new giamgiaDAO();
        data.themkm(nxb);
        listgg.add(nxb);

    }

    public void xoa(int Ma) {
        giamgiaDAO data = new giamgiaDAO();
        data.xoakm(Ma);
        listgg.remove(findWithId(Ma));

    }

    public void sua(giamgiaDTO gg) {
        giamgiaDAO data = new giamgiaDAO();
        data.suaSach(gg);
    }

    public  giamgiaDTO findWithId(int Ma) {
        for (giamgiaDTO x : listgg) {
            if (x.getMa() == Ma) {
                return x;
            }

        }
        return null;

    }
    public void khoitao(giamgiaDTO rd,DefaultTableModel model,JTable tblReader){
    Vector header = new Vector();
        header.add("Mã giảm giá");
        header.add("Tên  giảm giá");
        header.add("Phần trăm giảm giá");
        header.add("Điều kiện giảm giá");
   if(model.getRowCount()==0){
       model = new DefaultTableModel(header,0);
   }
   Vector row = new Vector();
        row.add(rd.ma);
        row.add(rd.ten);
        row.add(rd.phantram);
        row.add(rd.dk);
        row.add(1);
 
      model.addRow(row);
      tblReader.setModel(model);
      giamgiadAO.themkm(rd);
      JOptionPane.showMessageDialog(null,"Thêm thành công.");
  }
    public giamgiaDTO getTenfromMa(String ten){
        for(giamgiaDTO x: listgg){
            if(x.getTen().equalsIgnoreCase(ten)){
                return x;
            }
        }
        return null;
    }
}
