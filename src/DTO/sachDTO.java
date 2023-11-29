/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DO THE TUNG
 */
public class sachDTO {
    
    public int Ma;
    public String Ten;
     public int MaTacGia;
     public int MaTheLoai;
     public int NamSanXuat;
      public int soLuong;
      public String Anh;
      public double Gia;
      public int tt = 1;

    public sachDTO(int Ma, String Ten, int MaTacGia, int MaTheLoai, int NamSanXuat, int soLuong, String Anh, int Gia,int tt) {
        this.Ma = Ma;
        this.Ten = Ten;
        this.MaTacGia = MaTacGia;
        this.MaTheLoai = MaTheLoai;
        this.NamSanXuat = NamSanXuat;
        this.soLuong = soLuong;
        this.Anh = Anh;
        this.Gia = Gia;
        this.tt = tt;
    }
    public sachDTO()
    {
        
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getMaTacGia() {
        return MaTacGia;
    }

    public void setMaTacGia(int MaTacGia) {
        this.MaTacGia = MaTacGia;
    }

    public int getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(int MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public int getNamSanXuat() {
        return NamSanXuat;
    }

    public void setNamSanXuat(int NamSanXuat) {
        this.NamSanXuat = NamSanXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

   
    @Override
    public String toString() {
        return "sachDTO{" + "Ma=" + Ma + ", Ten=" + Ten + ", MaTacGia=" + MaTacGia + ", MaTheLoai=" + MaTheLoai + ", NamSanXuat=" + NamSanXuat + ", soLuong=" + soLuong + ", Anh=" + Anh + ", Gia=" + Gia + '}';
    }
    
    
      
}
