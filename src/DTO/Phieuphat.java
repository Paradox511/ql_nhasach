/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class Phieuphat {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String Maphieuphat;
    String Ngayphat;
    String Mavipham;

    public Phieuphat() {
    }

    public Phieuphat(String Maphieuphat, String Ngayphat, String Mavipham) {
        this.Maphieuphat = Maphieuphat;
        this.Ngayphat = Ngayphat;
        this.Mavipham = Mavipham;
    }

    public String getMaphieuphat() {
        return Maphieuphat;
    }

    public void setMaphieuphat(String Maphieuphat) {
        this.Maphieuphat = Maphieuphat;
    }

    public String getNgayphat() {
        return Ngayphat;
    }

    public void setNgayphat(String Ngayphat) {
        this.Ngayphat = Ngayphat;
    }

    public String getMavipham() {
        return Mavipham;
    }

    public void setMavipham(String Mavipham) {
        this.Mavipham = Mavipham;
    }
    
    
    
}

