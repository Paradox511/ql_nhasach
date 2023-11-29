package BUS;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDon;
import DTO.HoaDon;

import java.util.ArrayList;

public class CTHoaDonBUS {

    private ArrayList<CTHoaDon> listCTHoaDon;
    private CTHoaDonDAO ctHDDAO = new CTHoaDonDAO();
    private HoaDonBUS hdBUS = new HoaDonBUS();

    public CTHoaDonBUS() {
        docListCTHoaDon();
    }

    public void docListCTHoaDon() {
        this.listCTHoaDon = ctHDDAO.getListCTHoaDon();
    }

    public ArrayList<CTHoaDon> getListCTHoaDon() {
        return listCTHoaDon;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaHD(String maHD) {
        int ma = Integer.parseInt(maHD);
        ArrayList<CTHoaDon> dsct = new ArrayList<>();

        for (CTHoaDon cthd : listCTHoaDon) {
            if (cthd.getMaHD() == ma)
                dsct.add(cthd);
        }

        return dsct;
    }

    public void addCTHoaDon(String maSP, String soLuong, String donGia, String thanhTien) {
        int ma = hdBUS.getMaHoaDonMoiNhat();

        donGia = donGia.replace(",","");
        donGia=donGia.replace(".0", "");
        thanhTien = thanhTien.replace(",", "");
        thanhTien = thanhTien.replace(".0", "");
        double gia = Double.parseDouble(donGia);
        double thanhtien = Double.parseDouble(thanhTien);
        CTHoaDon cthd = new CTHoaDon();
        cthd.setMaHD(ma);
        cthd.setMaSP(Integer.parseInt(maSP));
        cthd.setDonGia(gia);
        cthd.setSoLuong(Integer.parseInt(soLuong));
        cthd.setThanhTien(thanhtien);

        ctHDDAO.addCTHoaDon(cthd);
    }
}
