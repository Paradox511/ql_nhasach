/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {
    private String taikhoan,matkhau;
    public int manv;
    public String quyen;

    public TaiKhoan() {
    }

    public TaiKhoan(String taikhoan, String matkhau,int manv, String quyen) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.manv = manv;
        this.quyen = quyen;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
    
    
}

