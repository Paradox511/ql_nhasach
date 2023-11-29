package BUS;

import DAO.HoaDonDAO;
import DTO.EmployeeDTO;
import DTO.HoaDon;
//import MyDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class HoaDonBUS {
    
    private EmployeeBUS ebus = new EmployeeBUS();
    private ArrayList<HoaDon> listHoaDon;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon = hoaDonDAO.getListHoaDon();
        return listHoaDon;
    }

    public void luuHoaDon(int maKH, String nhanVien, int tongTien, String ghiChu) {
        HoaDon hd = new HoaDon();
        EmployeeDTO e = ebus.getMafromTen(nhanVien);
        int manv = e.getid();
        hd.setMaNV(manv);
        hd.setMaKH(maKH);
        hd.setGhiChu(ghiChu);
        hd.setTongTien(tongTien);

        hoaDonDAO.addHoaDon(hd);
    }

    public int getMaHoaDonMoiNhat() {
        return hoaDonDAO.getMaHoaDonMoiNhat();
    }

    public HoaDon getHoaDon(String maHD) {
        int ma = Integer.parseInt(maHD);
        for (HoaDon hd : listHoaDon) {
            if (hd.getMaHD() == ma)
                return hd;
        }
        return null;
    }

    public ArrayList<HoaDon> getListHoaDonTheoGia(String min, String max) {
        try {
            int minPrice = Integer.parseInt(min);
            int maxPrice = Integer.parseInt(max);
            ArrayList<HoaDon> dshd = new ArrayList<>();
            for (HoaDon hd : listHoaDon) {
                if (hd.getTongTien() > minPrice && hd.getTongTien() < maxPrice)
                    dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hãy nhập khoảng giá hợp lệ");
        }
        return null;
    }

    public ArrayList<HoaDon> getListHoaDonTheoNgay(String min, String max) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date minDate = sdf.parse(min);
            Date maxDate = sdf.parse(max);

            java.sql.Date dateMin = new java.sql.Date(minDate.getTime());
            java.sql.Date dateMax = new java.sql.Date(maxDate.getTime());

            ArrayList<HoaDon> dshd = hoaDonDAO.getListHoaDon(dateMin, dateMax);
            return dshd;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hãy nhập khoảng ngày hợp lệ");
        }
        return null;
    }
}
