/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import BUS.tacgiaBUS;
import DAO.sachDAO;
import DTO.sachDTO;
import DTO.tacGiaDTO;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class sachBUS {

    private ArrayList<sachDTO> listSach = null;
    private sachDAO sachdAO = new sachDAO();

    public sachBUS() {
        doclistSach();

    }

    public void showMess(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public void doclistSach() {
        listSach = sachdAO.getListSach();

    }

    public ArrayList<sachDTO> getListSach() {
        if (listSach == null) {
            doclistSach();
        }
        return listSach;
    }
// thuc ra cung khong dung den
   
    public sachDTO getSach(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maSach = Integer.parseInt(ma);
                for (sachDTO sach : listSach) {
                    if (sach.getMa() == maSach) {
                        return sach;

                    }
                }
            } catch (Exception e) {
            }

        }
        return null;

    }
// thuc ra khong dung den

    public ArrayList<sachDTO> getSachtheoMaTacGia(String ma) {
        if (!ma.trim().equals("")) {
            ArrayList<sachDTO> dsSach = new ArrayList<>();
            try {
                int maTacGia = Integer.parseInt(ma);
                for (sachDTO sach : listSach) {
                    if (sach.getMaTacGia() == maTacGia) {
                        dsSach.add(sach);
                    }
                }
                return dsSach;

            } catch (Exception e) {
            }
        }
        return null;

    }

    public String getAnh(String ma) {
        int maSach = Integer.parseInt(ma);
        return sachdAO.getAnh(maSach);

    }

 public void capNhatSoLuongSach(int ma, int soLuongMat) {
        sachdAO.capNhatSoLuongSP(ma, soLuongMat);
    }
    public boolean themSach( String Ten, String MaTacGia, String MaTheLoai, String NamSanXuat, String anh, String Gia) {

        try {
            String[] MaTacGiaTmp = MaTacGia.split("-");

            int maTacGia = Integer.parseInt(MaTacGiaTmp[0]);
            // int maTheLoai = Integer.parseInt(MaTheLoai);

            String[] MaTheLoaiTmp = MaTheLoai.split("-");
            int maTheLoai = Integer.parseInt(MaTheLoaiTmp[0]);
            //      int ma = Integer.parseInt(Ma);

            // int maTheLoai = Integer.parseInt(MaTheLoai);
            int namSanXuat = Integer.parseInt(NamSanXuat);
         //   int soluong = Integer.parseInt(soLuong);
            int gia = Integer.parseInt(Gia);

            sachDTO sach = new sachDTO();
            sach.setTen(Ten);
            //  sach.setMaNhaSanXuat(maNhaSanXuat);
            sach.setMaTacGia(maTacGia);
            sach.setMaTheLoai(maTheLoai);
            sach.setNamSanXuat(namSanXuat);
            sach.setSoLuong(0);
            sach.setAnh(anh);
            sach.setGia(gia);
            System.out.println("sai gon heat");
         
            if (sachdAO.themSach(sach)) {
                showMess("them thanh cong ");

                return true;

            } else {
                showMess("them that bai");
                return false;

            }
        } catch (Exception e) {
        }
        return false;

    }

 public void khoitao(sachDTO rd,DefaultTableModel model,JTable tblReader){
    Vector header = new Vector();
         header.add("Mã sách");
        header.add("Tên sách");
        header.add("Tồn kho");
        header.add("Giá nhập");
        header.add("Trạng thái");
   if(model.getRowCount()==0){
       model = new DefaultTableModel(header,0);
   }
   Vector row = new Vector();
        row.add(rd.Ma);
        row.add(rd.Ten);
       
        row.add(rd.soLuong);
        row.add(rd.Gia);
        row.add(rd.tt);
        row.add(1);
  try{
      model.addRow(row);
      tblReader.setModel(model);
      them(rd);
  //    sachdAO.themSach(rd);
      JOptionPane.showMessageDialog(null,"Thêm thành công.");
  
  }
  catch(Exception e){
      JOptionPane.showMessageDialog(null,"Có lỗi xảy ra");
  }
 }
  public void them(sachDTO rd){
       sachDAO data = new sachDAO();
        data.themSach(rd);
        listSach.add(rd);
    }
    public boolean xoaSanPham(String ma) {
        if (ma.trim().equals("")) {
            showMess("chua chon san pham de xoa ");
            return false;

        }
        int maSach = Integer.parseInt(ma);
        if (sachdAO.xoaSanch(maSach)) {
            showMess(" xoa thanh cong");
            return true;

        }
        showMess(" xoa that bai");
        return false;
    }

    public boolean suaSach(String Ma, String Ten, String MaTacGia, String MaTheLoai, String MaNhaSanXuat, String NamSanXuat, String soLuong, String Anh, String Gia) {
        try {
            if (Ma.trim().equals("")) {
                showMess(" chua chon san pham de sua");
                return false;

            }
            int maSach = Integer.parseInt(Ma);

            String[] MaTacGiaTmp = MaTacGia.split("-");
            int maTacGia = Integer.parseInt(MaTacGiaTmp[0]);

            String[] maNhaSanXuat = MaNhaSanXuat.split("-");
            int maNSX = Integer.parseInt(maNhaSanXuat[0]);
            String[] MaTheLoaiTmp = MaTheLoai.split("-");
            int maTheLoai = Integer.parseInt(MaTheLoaiTmp[0]);

            // int maLoai = Integer.parseInt(Ma);
            int namsanxuat = Integer.parseInt(NamSanXuat);
            int soluong = Integer.parseInt(soLuong);
            int gia = Integer.parseInt(Gia);
            if (maTacGia == 0) {
                showMess("vui long chon loai san pham");
                return false;

            }
            if (Ten.trim().equals("")) {
                showMess(" ten sach khong duoc de trong");
                return false;
            }
            sachDTO sach = new sachDTO();
            sach.setMa(maSach);
            sach.setTen(Ten);
            sach.setMaTacGia(maTacGia);
            sach.setMaTheLoai(maTheLoai);
            sach.setNamSanXuat(namsanxuat);
            sach.setSoLuong(soluong);
            sach.setAnh(Anh);
            sach.setGia(gia);

            if (sachdAO.suaSach(sach)) {
                showMess(" sua thanh cong ");
                return true;
            } else {
                showMess(" sua that bai");
                return false;
            }

        } catch (Exception e) {
        }

        return false;

    }

    public boolean nhapSanPhamTuExel(sachDTO sach) {

        return false;
    }

    public String getTenSP(int maSach) {
        for (sachDTO sach : listSach) {
            if (sach.getMa() == maSach) {
                return sach.getTen();
            }
        }
        return "";
    }

    public ArrayList<sachDTO> getSachTheoTen(String ten) {
        ArrayList<sachDTO> dsSach = new ArrayList<>();
        for (sachDTO sach : listSach) {
            String tenSach = sach.getTen().toLowerCase();
            if (tenSach.toLowerCase().contains(ten.toLowerCase())) {
                dsSach.add(sach);
            }

        }
        return dsSach;

    }

    boolean checkMaExist(int ma) {
        return sachdAO.checkExist(ma);
    }

    public ArrayList<sachDTO> getSachTheoMaTg(int maTacGia) {
        ArrayList<sachDTO> dsSach1 = new ArrayList<>();
        for (sachDTO sach : listSach) {
            
            if (sach.getMaTacGia()==maTacGia) {
                dsSach1.add(sach);
            }

        }
        return dsSach1;

    }
      public ArrayList<sachDTO> getSachTheoMaTheLoai(int ma) {
        ArrayList<sachDTO> dsSach1 = new ArrayList<>();
        for (sachDTO sach : listSach) {
            
            if (sach.getMaTheLoai()==ma) {
                dsSach1.add(sach);
            }

        }
        return dsSach1;

    }
public ArrayList<sachDTO> timlKiemSachLive(String keyword)
    {
        keyword = keyword.toLowerCase();
        ArrayList<sachDTO> dsSach = new ArrayList<>();
        for(sachDTO live_tim_sach :listSach)
        {
            String tenSach=live_tim_sach.getTen().toLowerCase();
            if(tenSach.contains(keyword))
            {
                dsSach.add(live_tim_sach);
            }
        }
        return dsSach;
        
    }
 public boolean nhapSachTuExel( String Ten, String MaTacGia, String MaTheLoai, String MaNhaSanXuat, String NamSanXuat, String soLuong, String anh, String Gia) {

        try {
//            int ma = Integer.parseInt(Ma);
            String[] MaTacGiaTmp = MaTacGia.split("-");

            int maTacGia = Integer.parseInt(MaTacGiaTmp[0]);
            // int maTheLoai = Integer.parseInt(MaTheLoai);

            String[] MaTheLoaiTmp = MaTheLoai.split("-");
            int maTheLoai = Integer.parseInt(MaTheLoaiTmp[0]);
            String[] MaNhaSanXuatTMP = MaNhaSanXuat.split("-");

            int maNhaSanXuat = Integer.parseInt(MaNhaSanXuatTMP[0]);
            //      int ma = Integer.parseInt(Ma);

            // int maTheLoai = Integer.parseInt(MaTheLoai);
            int namSanXuat = Integer.parseInt(NamSanXuat);
            int soluong = Integer.parseInt(soLuong);
            int gia = Integer.parseInt(Gia);

            sachDTO sach = new sachDTO();
//            sach.setMa(ma);
            sach.setTen(Ten);
            //  sach.setMaNhaSanXuat(maNhaSanXuat);
            sach.setMaTacGia(maTacGia);
            sach.setMaTheLoai(maTheLoai);
            sach.setNamSanXuat(namSanXuat);
            sach.setSoLuong(soluong);
            sach.setAnh(anh);
            sach.setGia(gia);
           sachdAO.nhapSanPhamTuExcel(sach);
        }
        
        catch(Exception e){}
        return false;
        
             
    }
 public ArrayList<sachDTO> getlisttheosl(String min,String max){
     ArrayList<sachDTO> ds = sachdAO.timsl(min, max);
     return ds;
 }

}
