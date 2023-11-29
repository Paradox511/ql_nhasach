/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package DTO;

import java.lang.*;

/**
 *
 * @author ADMIN
 */
public class ReaderDTO {

    public String  ho, ten;
    public String diachi, gioitinh;
    public int id,sdt,tongct;

    public ReaderDTO(int id, String ho, String ten, String diachi, String gioitinh, int sdt,int tongct) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.tongct = tongct;
    }

    public ReaderDTO() {
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getho() {
        return ho;
    }

    public void setho(String ho) {
        this.ho = ho;
    }

    public String getten() {
        return ten;
    }

    public void setten(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getgioitinh() {
        return gioitinh;
    }

    public void setgioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public int getTongct() {
        return tongct;
    }

    public void setTongct(int tongct) {
        this.tongct = tongct;
    }

}
