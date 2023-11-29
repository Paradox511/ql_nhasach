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
public class giamgiaDTO {
    public int ma;
    public String ten;
    public double phantram;
    public int dk;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getPhantram() {
        return phantram;
    }

    public void setPhantram(double phantram) {
        this.phantram = phantram;
    }

    public int getDk() {
        return dk;
    }

    public void setDk(int dk) {
        this.dk = dk;
    }

    public giamgiaDTO(int ma, String ten, double phantram, int dk) {
        this.ma = ma;
        this.ten = ten;
        this.phantram = phantram;
        this.dk = dk;
    }
    
    public giamgiaDTO(){
    }
}
