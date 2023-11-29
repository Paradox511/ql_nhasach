/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.theLoaiDAO;
import DTO.theLoaiDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DO THE TUNG
 */
public class theLoaiiBUS {

    private ArrayList<theLoaiDTO> listTheLoai = null;
    private theLoaiDAO theloaidao = new theLoaiDAO();

    public theLoaiiBUS() {
        docDanhSachTheLoai();

    }

    public void docDanhSachTheLoai() {
        this.listTheLoai = theloaidao.getListTheLoai();

    }

    public ArrayList<theLoaiDTO> getDanhSachLoai() {
        if (listTheLoai == null) {
            docDanhSachTheLoai();
        }
        return this.listTheLoai;

    }

    public void showMess(String s) {
        JOptionPane.showMessageDialog(null, s);

    }

    public String getTenLoai(int ma) {
        for (theLoaiDTO theloai : listTheLoai) {
            if (theloai.getMa() == ma) {
                return theloai.getMa() + "-" + theloai.getTen();

            }
        }
        return "";

    }
        public String getTenloai(int ma) {
        for (theLoaiDTO theloai : listTheLoai) {
            if (theloai.getMa() == ma) {
                return  theloai.getTen();

            }
        }
        return "";

    }
         public int getMafromTen(String ten){
        for(theLoaiDTO tg : listTheLoai){
            String hoten = tg.getTen();
            if(hoten.equalsIgnoreCase(ten))
                return tg.getMa();
        }
        return 0;
    }
  public void insert_BUS(theLoaiDTO tg) {
        theLoaiDAO data = new theLoaiDAO();
        data.themTheLoai(tg);
        listTheLoai.add(tg);

    }
    public boolean themLoai(String Ma, String Tenloai) {
        try {
            int ma = Integer.parseInt(Ma);
            theLoaiDTO theLoai = new theLoaiDTO();
            theLoai.setMa(ma);
            theLoai.setTen(Tenloai);

//           if(theloaidao.themTheLoai(theLoai));
//           {
//               showMess(" them thanh cong");
//               return true;
//           }

if(checkExist(ma))
{
    JOptionPane.showMessageDialog(null, " ma the loai trung");
    return false;
}
            if (theloaidao.themTheLoai(theLoai)) {

                showMess(" them thanh cong");
                return true;

            } else {
                showMess(" them  that bai");
                return false;
            }

        } catch (Exception e) {
            System.out.println(" anh tung dep trai");
        }

        return false;

    }

     public int getMaTheLoai(String ma){
        String[] str = ma.split("-");
        int id = Integer.parseInt(str[0]);
        return id;
    }
    public boolean xoaTheLoai(int ma) {
        if (ma <=0) {
           
            return false;
        }

        if (theloaidao.xoaTheLoai(ma)) {    
               return true;

        }

        showMess(" xoa that bai");
        return false;

    }

    public boolean suaTheLoai(String Ma, String Ten) {
    try{
        if (Ma.trim().equals("")) {
            showMess(" chua chon the loai de xoa");
            return false;

        }
        int maTheLoai = Integer.parseInt(Ma);
        theLoaiDTO  theloai = new theLoaiDTO();
        theloai.setMa(maTheLoai);
        theloai.setTen(Ten);
        if(theloaidao.suaTheLoai(theloai))
        {
            showMess(" sua thanh cong");
            return true;
        }
        else
        {
            showMess("sua that bai");
            return false;
            
                
        }
        
    }      
    catch(Exception e){}
    
    
    return false;
    
    }
//    phuc vu cho viec tim kiem trong gui
    public String getTenTheLoai(int ma)
    {
        for(theLoaiDTO tentheloai : listTheLoai)
        {
            if (tentheloai.getMa()==ma)
            {
                return tentheloai.getMa()+"-"+tentheloai.getTen();
                
            }
        }
        return "";
        
    }
    
    public ArrayList <theLoaiDTO> getTheLoaiTheoTen(String ten)
    {
        ArrayList<theLoaiDTO> dsTheLoai = new
           ArrayList<>();
        for(theLoaiDTO theloai : listTheLoai)
        {
            String tenTheLoai = theloai.getTen().toLowerCase();
            if (tenTheLoai.toLowerCase().contains(ten.toLowerCase()))
            {
                dsTheLoai.add(theloai);
                
            }
        }
        return dsTheLoai;
        
    }
    boolean checkExist(int ma)
    {
        return theloaidao.checkExist(ma);
    }

}
