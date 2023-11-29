/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.util.*;
import java.lang.*;

/**
 *
 * @author ADMIN
 */
public class EmployeeDTO {
    public int id,sdt;
   public String ho,ten,diachi;
   public String gioitinh;
   public String phanquyen;
   public int tt =1;

    public EmployeeDTO(){
        
    }
    public EmployeeDTO(int id, String ho,  String ten,String gioitinh,String phanquyen,String diachi,  int sdt,int tt) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.phanquyen = phanquyen;
        this.tt =1;
        
    }
    
  public int getid(){
      return id;
  }
  public void setid(int id){
      this.id = id;
  }
    public String getho(){
      return ho;
  }
  public void setho(String ho){
      this.ho = ho;
  }
    public String getten(){
      return ten;
  }
  public void setten(String ten){
      this.ten = ten;
  }
    public String getgioitinh(){
      return gioitinh;
  }
  public void setgioitinh(String gioitinh){
      this.gioitinh = gioitinh;
  }
    public int getsdt(){
      return sdt;
  }
  public void setsdt(int sdt){
      this.sdt = sdt;
  }

    public String getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(String phanquyen) {
        this.phanquyen = phanquyen;
    }
 

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }
  
}

