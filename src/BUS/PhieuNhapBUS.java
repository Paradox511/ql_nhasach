package BUS;

import DAO.PhieuNhapDAO;
import DTO.EmployeeDTO;
import DTO.PhieuNhap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class PhieuNhapBUS {
    private EmployeeBUS ebus = new EmployeeBUS();
    private PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    private ArrayList<PhieuNhap> listPhieuNhap = null;

    public PhieuNhapBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listPhieuNhap = phieuNhapDAO.getListPhieuNhap();
    }

    public ArrayList<PhieuNhap> getListPhieuNhap() {
        if (listPhieuNhap == null) {
            docDanhSach();
        }
        return listPhieuNhap;
    }

    public boolean themPhieuNhap(String nhanVien, double tongTien) {
        EmployeeDTO e = ebus.getMafromTen(nhanVien);
        int manv = e.getid();
        PhieuNhap pn = new PhieuNhap();
        pn.setMaNV(manv);
        pn.setTongTien(tongTien);

        return phieuNhapDAO.themPhieuNhap(pn);
    }

    public int getLastID() {
        return phieuNhapDAO.getLastID();
    }

    public PhieuNhap timPhieuNhap(String maPN) {
        int ma = Integer.parseInt(maPN);
        for (PhieuNhap pn : listPhieuNhap) {
            if (pn.getMaPN() == ma) {
                return pn;
            }
        }
        return null;
    }

    public ArrayList<PhieuNhap> getListPhieuNhapTheoGia(String giaThap, String giaCao) {
        try {
            int min = Integer.parseInt(giaThap);
            int max = Integer.parseInt(giaCao);
            if (max < min) {
                JOptionPane.showMessageDialog(null,"Hãy nhập khoảng giá phù hợp!");
                return null;
            }
            ArrayList<PhieuNhap> result = new ArrayList<>();
            for (PhieuNhap pn : listPhieuNhap) {
                if (pn.getTongTien() <= max && pn.getTongTien() >= min) {
                    result.add(pn);
                }
            }
            return result;
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Hãy nhập số nguyên cho khoảng giá!");
        }
        return null;
    }

    public ArrayList<PhieuNhap> getListPhieuNhapTheoNgay(String tuNgay, String denNgay) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            
            Date min = sdf.parse(tuNgay);
            Date max = sdf.parse(denNgay);
            if (max.before(min)) {
               JOptionPane.showMessageDialog(null,"Hãy nhập khoảng ngày phù hợp!");
                return null;
            }
            ArrayList<PhieuNhap> result = new ArrayList<>();
            for (PhieuNhap pn : listPhieuNhap) {
                if (pn.getNgayLap().after(min) && pn.getNgayLap().before(max)) {
                    result.add(pn);
                }
            }
            return result;
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Hãy nhập ngày hợp lệ (dd/MM/yyy)!");
        }
        return null;
    }

}
