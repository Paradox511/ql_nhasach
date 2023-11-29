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
public class AnalyzeDTO {
    public int soluongDG,soluongSach,soluongSachdangmuon;

    public AnalyzeDTO(){
        
    }
    public AnalyzeDTO(int soluongDG, int soluongSach, int soluongSachdangmuon) {
        this.soluongDG = soluongDG;
        this.soluongSach = soluongSach;
        this.soluongSachdangmuon = soluongSachdangmuon;
    }
    
}

