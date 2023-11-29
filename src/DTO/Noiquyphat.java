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
public class Noiquyphat {
    String MaPhat;
    int Tienphat;
    public Noiquyphat(){
        
    }

    public Noiquyphat(String MaPhat, int Tienphat) {
        this.MaPhat = MaPhat;
        this.Tienphat = Tienphat;
    }

    public String getMaPhat() {
        return MaPhat;
    }

    public void setMaPhat(String MaPhat) {
        this.MaPhat = MaPhat;
    }

    public int getTienphat() {
        return Tienphat;
    }

    public void setTienphat(int Tienphat) {
        this.Tienphat = Tienphat;
    }
    
}

