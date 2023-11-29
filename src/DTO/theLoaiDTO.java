/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DO THE TUNG
 */
public class theLoaiDTO {
    int Ma;
    String Ten;

    public theLoaiDTO(int Ma, String Ten) {
        this.Ma = Ma;
        this.Ten = Ten;
    }
    public theLoaiDTO()
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

    @Override
    public String toString() {
        return "theLoaiDTO{" + "Ma=" + Ma + ", Ten=" + Ten + '}';
    }
    
   
}
