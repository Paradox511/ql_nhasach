package BUS;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyenDTO;


import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PhanQuyenBUS {

    public static PhanQuyenDTO quyenTK = null;
    private PhanQuyenDAO phanQuyenDAO = new PhanQuyenDAO();
    private ArrayList<PhanQuyenDTO> listPhanQuyen = null;

    public void docDanhSachQuyen() {
        this.listPhanQuyen = phanQuyenDAO.getListQuyen();
    }

    public void kiemTraQuyen(String quyen) {
        quyenTK = phanQuyenDAO.getQuyen(quyen);
    }

    public ArrayList<PhanQuyenDTO> getListQuyen() {
        if (listPhanQuyen == null)
            docDanhSachQuyen();
        return this.listPhanQuyen;
    }

    public boolean suaQuyen(String tenQuyen, int nhapHang, int sanPham, int nhanVien, int khachHang, int thongKe) {
        PhanQuyenDTO phanQuyen = new PhanQuyenDTO(tenQuyen, nhapHang, sanPham, nhanVien, khachHang, thongKe);
        boolean flag = phanQuyenDAO.suaQuyen(phanQuyen);
        if (flag) {
            JOptionPane.showMessageDialog(null,"Sửa thành công!");
        } else {
            JOptionPane.showMessageDialog(null,"Sửa thất bại!");
        }
        return flag;
    }

    public boolean themQuyen(String tenQuyen) {
        if (tenQuyen == null || tenQuyen.trim().equals("")) {
            return false;
        }

        if (kiemTonTaiTraQuyen(tenQuyen)) {
            JOptionPane.showMessageDialog(null,"Thêm thất bại! Quyền đã tồn tại");
            return false;
        }

        PhanQuyenDTO phanQuyen = new PhanQuyenDTO(tenQuyen, 0, 0, 0, 0, 0);
        boolean flag = phanQuyenDAO.themQuyen(phanQuyen);
        if (flag) {
            JOptionPane.showMessageDialog(null,"Thêm thành công! Hãy hiệu chỉnh quyền");
        } else {
            JOptionPane.showMessageDialog(null,"Thêm thất bại! Quyền đã tồn tại");
        }
        return flag;
    }

    private boolean kiemTonTaiTraQuyen(String tenQuyen) {
        docDanhSachQuyen();
        for (PhanQuyenDTO q : listPhanQuyen) {
            if (q.getQuyen().equalsIgnoreCase(tenQuyen))
                return true;
        }
        return false;
    }

    public boolean xoaQuyen(String tenQuyen) {
        boolean flag = phanQuyenDAO.xoaQuyen(tenQuyen);
        if (flag) {
            JOptionPane.showMessageDialog(null,"Xoá thành công!");
        } else {
           JOptionPane.showMessageDialog(null,"Xoá thất bại!");
        }
        return flag;
    }
}
