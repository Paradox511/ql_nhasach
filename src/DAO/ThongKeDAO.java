    package DAO;

import BUS.sachBUS;
import DTO.sachDTO;
import DTO.ThongKe;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author User
 */
public class ThongKeDAO {
     Connection con = null;
        PreparedStatement ptst = null;
        ResultSet rs = null;
        
    public  ThongKeDAO(){
        if(con == null){
            try{
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhasach","root","");
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, e);
                JOptionPane.showMessageDialog(null, "Chinh xác");
            }
        }            
    }
    public ThongKe getThongKe(int nam) {
        ThongKe thongKe = new ThongKe();
        int[] tongThuQuy = new int[4];
        thongKe.setSoLuongSP(getTongSoLuongSP());
        thongKe.setSoLuongKH(getSoLuongKhachHang());
        thongKe.setSoLuongNV(getSoLuongNhanVien());
        tongThuQuy[0] = getTongThuQuy(nam, 1);
        tongThuQuy[1] = getTongThuQuy(nam, 2);
        tongThuQuy[2] = getTongThuQuy(nam, 3);
        tongThuQuy[3] = getTongThuQuy(nam, 4);
        thongKe.setTongThuQuy(tongThuQuy);
        thongKe.setTopSanPhamBanChay(getTopBanChay());
        return thongKe;
    }

    private ArrayList<sachDTO> getTopBanChay() {
        try {
            String sql = "SELECT MaSach, DaBan FROM (" +
                    "SELECT MaSach, SUM(SoLuong) AS DaBan FROM " +
                    "cthoadon GROUP BY MaSach" +
                    ") temp " +
                    "ORDER BY DaBan " +
                    "DESC LIMIT 5";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<sachDTO> dssp = new ArrayList<>();
            sachBUS spBUS = new sachBUS();
            while (rs.next()) {
                sachDTO sp = new sachDTO();
                sp.setMa(rs.getInt(1));
                sp.setSoLuong(rs.getInt(2));
                sp.setTen(spBUS.getTenSP(sp.getMa()));
                dssp.add(sp);
            }
            return dssp;
        } catch (Exception e) {
        }
        return null;
    }

    private int getTongSoLuongSP() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM sach");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }

    private String[] getDateString(int nam, int quy) {
        int namBatDau = nam;
        int namKetThuc = nam;
        String thangBatDau = "01"; //kiểu String do có số 0 ở phía trước
        String thangKetThuc = "04"; //kiểu String do có số 0 ở phía trước
        String[] kq = new String[2];
        switch (quy) {
            case 1:
                thangBatDau = "01";
                thangKetThuc = "04";
                break;
            case 2:
                thangBatDau = "03";
                thangKetThuc = "07";
                break;
            case 3:
                thangBatDau = "06";
                thangKetThuc = "10";
                break;
            case 4:
                thangBatDau = "09";
                thangKetThuc = "01";
                namKetThuc++;
        }
        String strBatDau = Integer.toString(namBatDau) + thangBatDau + "01";
        String strKetThuc = Integer.toString(namKetThuc) + thangKetThuc + "01";
        kq[0] = strBatDau;
        kq[1] = strKetThuc;
        return kq;
    }

    private int getTongThuQuy(int nam, int quy) {
        String[] dateString = getDateString(nam, quy);
        try {
            PreparedStatement prep = con.prepareStatement("SELECT SUM(TongTien) FROM hoadon "
                    + "WHERE NgayLap >= ? AND NgayLap < ?");
            prep.setString(1, dateString[0]);
            prep.setString(2, dateString[1]);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }

    private int getSoLuongNhanVien() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM nhanvien");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }

    private int getSoLuongKhachHang() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM khachhang");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return -1;
        }
        return 0;
    }

    public double getDoanhThuThang(int thang, int nam) {
        try {
            String thangBD = nam + "-" + thang + "-01";
            String thangKT = nam + "-" + (thang + 1) + "-01";
            String sql = "SELECT SUM(TongTien) FROM HoaDon WHERE NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, thangBD);
            pre.setString(2, thangKT);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return Double.parseDouble(rs.getInt(1) + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nam;
    }

    public double abc(int thang, int nam) {
        try {
            String d1 = nam + "-" + thang + "-01";
            String d2 = nam + "-" + (thang + 1) + "-01";
            String sql = "SELECT SUM(TongTien) FROM HoaDon WHERE NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";

            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, d1);
            pre.setString(2, d2);
            ResultSet rs = pre.executeQuery();

            while (rs.next())
                return rs.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0f;
    }
}
