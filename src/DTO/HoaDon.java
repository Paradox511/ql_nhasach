package DTO;

import java.util.Date;

public class HoaDon {
    private int maHD;
    private int maKH;
    private int maNV;
    private Date ngayLap;
    private int tongTien;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(int maHD, int maKH, int maNV, Date ngayLap, int tongTien, String ghiChu) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
