 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DO THE TUNG
 */
public class tacGiaDTO {
    public String Ten;
    public int Ma;
   // public String Ho;
    public String GioiTinh;
    
    public  tacGiaDTO(){}
    public  tacGiaDTO(int Ma, String Ten, String GioiTinh)
    {
        this.Ma=Ma;
        this.Ten=Ten;
        this.GioiTinh=GioiTinh;
        
      
        
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int Ma) {
        this.Ma = Ma;
    }

   

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

}
