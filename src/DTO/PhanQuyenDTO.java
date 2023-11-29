package DTO;

public class PhanQuyenDTO {

    private String quyen;
    private int nhapHang;
    private int qlSanPham;
    private int qlNhanVien;
    private int qlKhachHang;
    private int thongKe;

    public PhanQuyenDTO() {
    }

    public PhanQuyenDTO(String quyen, int nhapHang, int qlSanPham, int qlNhanVien, int qlKhachHang, int thongKe) {
        this.quyen = quyen;
        this.nhapHang = nhapHang;
        this.qlSanPham = qlSanPham;
        this.qlNhanVien = qlNhanVien;
        this.qlKhachHang = qlKhachHang;
        this.thongKe = thongKe;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public int getNhapHang() {
        return nhapHang;
    }

    public void setNhapHang(int nhapHang) {
        this.nhapHang = nhapHang;
    }

    public int getQlSanPham() {
        return qlSanPham;
    }

    public void setQlSanPham(int qlSanPham) {
        this.qlSanPham = qlSanPham;
    }

    public int getQlNhanVien() {
        return qlNhanVien;
    }

    public void setQlNhanVien(int qlNhanVien) {
        this.qlNhanVien = qlNhanVien;
    }

    public int getQlKhachHang() {
        return qlKhachHang;
    }

    public void setQlKhachHang(int qlKhachHang) {
        this.qlKhachHang = qlKhachHang;
    }

    public int getThongKe() {
        return thongKe;
    }

    public void setThongKe(int thongKe) {
        this.thongKe = thongKe;
    }

}
