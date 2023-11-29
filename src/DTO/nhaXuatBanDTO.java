/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DO THE TUNG
 */
public class nhaXuatBanDTO {
    
    
    public int MaNhaSanXuat;
     public String TenNhaXuatBan;
    public String DiaChi;
    public int soDienThoai;
    public nhaXuatBanDTO(){}

    public nhaXuatBanDTO( int MaNhaSanXuat, String TenNhaXuatBan,String DiaChi,int soDienThoai) {
        
        this.MaNhaSanXuat = MaNhaSanXuat;
        this.TenNhaXuatBan = TenNhaXuatBan;
        this.DiaChi = DiaChi;
        this.soDienThoai = soDienThoai;
        
    }

    public int getMaNhaSanXuat() {
        return MaNhaSanXuat;
    }

    public void setMaNhaSanXuat(int  MaNhaSanXuat) {
        this.MaNhaSanXuat = MaNhaSanXuat;
    }

     public String getTenNhaXuatBan() {
        return TenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String TenNhaXuatBan) {
        this.TenNhaXuatBan = TenNhaXuatBan;
    }
    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
   public int getSoDienThoai()
   {
       return soDienThoai;
   }
   public void setSoDienThoai(int soDienThoai)
   {
       this.soDienThoai = soDienThoai;
   }

    @Override
    public String toString() {
        return "nhaXuatBanDTO{" + "MaNhaSanXuat=" + MaNhaSanXuat + ", TenNhaXuatBan=" + TenNhaXuatBan + ", DiaChi=" + DiaChi + ", soDienThoai=" + soDienThoai + '}';
    }
   
   
   
}

