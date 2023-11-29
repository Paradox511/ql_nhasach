/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.AnalyzeBUS;
import DTO.ThongKe;
import BUS.ThongKeBUS;
import DAO.ThongKeDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.Calendar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ADMIN
 */
public class JPnAnalyze extends javax.swing.JPanel {
    ThongKeBUS tkbus = new ThongKeBUS();
    AnalyzeBUS bus = new AnalyzeBUS();
    private ChartPanel chartPanel;
    /**        AnalyzeBUS bus = new AnalyzeBUS();

     * Creates new form JPnAnalyze
     */
    public JPnAnalyze() {
        
        initComponents();
        jlabelSach.setText("Số lượng sách: " + bus.getsoluongSach());
        jLabelDocgia.setText("Số lượng độc giả: " + bus.getsoluongDocgia());
        jLabelMuon.setText("" + bus.getsoluongMuon());
        jLabelNhanvien.setText("Số lượng nhân viên: " + bus.getsoluongNhanvien());
        hienThiThongKe();
      
    }
        private DecimalFormat dcf = new DecimalFormat("###,###");

 private void hienThiThongKe() {
        ThongKe thongKe = tkbus.thongKe(Integer.parseInt(cmbNam.getSelectedItem() + ""));
     //   lblThongKeThucDon.setText(dcf.format(thongKe.getSoLuongSP()));
     //   lblThongKeKhachHang.setText(dcf.format(thongKe.getSoLuongKH()));
     //   lblThongKeNhanVien.setText(dcf.format(thongKe.getSoLuongNV()));
       // lblThongKeDoanhThu.setText(dcf.format(thongKe.getTongDoanhThu()));
        lbdt1.setText(dcf.format(thongKe.getTongThuQuy(1)));
        lbdt2.setText(dcf.format(thongKe.getTongThuQuy(2)));
        lbdt3.setText(dcf.format(thongKe.getTongThuQuy(3)));
        lbdt4.setText(dcf.format(thongKe.getTongThuQuy(4)));
        lbsum.setText(dcf.format(thongKe.getTongDoanhThu()));
        lbMon1.setText(thongKe.getTopSanPhamBanChay().get(0).getTen());
        lbMon2.setText(thongKe.getTopSanPhamBanChay().get(1).getTen());
        lbMon3.setText(thongKe.getTopSanPhamBanChay().get(2).getTen());
        lbMon4.setText(thongKe.getTopSanPhamBanChay().get(3).getTen());
        lbMon5.setText(thongKe.getTopSanPhamBanChay().get(4).getTen());
        lblSoLuong1.setText("" + thongKe.getTopSanPhamBanChay().get(0).getSoLuong());
        lblSoLuong2.setText("" + thongKe.getTopSanPhamBanChay().get(1).getSoLuong());
        lblSoLuong3.setText("" + thongKe.getTopSanPhamBanChay().get(2).getSoLuong());
        lblSoLuong4.setText("" + thongKe.getTopSanPhamBanChay().get(3).getSoLuong());
        lblSoLuong5.setText("" + thongKe.getTopSanPhamBanChay().get(4).getSoLuong());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        pnchitiet = new javax.swing.JPanel();
        lbtop = new javax.swing.JLabel();
        lbtop2 = new javax.swing.JLabel();
        lbtop4 = new javax.swing.JLabel();
        lbtop3 = new javax.swing.JLabel();
        pnChart = new javax.swing.JPanel();
        lbtop5 = new javax.swing.JLabel();
        lbtop6 = new javax.swing.JLabel();
        lbtop7 = new javax.swing.JLabel();
        lbtop8 = new javax.swing.JLabel();
        lbtop9 = new javax.swing.JLabel();
        lbMon1 = new javax.swing.JLabel();
        lbMon5 = new javax.swing.JLabel();
        lbMon2 = new javax.swing.JLabel();
        lbMon3 = new javax.swing.JLabel();
        lbMon4 = new javax.swing.JLabel();
        lblSoLuong5 = new javax.swing.JLabel();
        lblSoLuong1 = new javax.swing.JLabel();
        lblSoLuong2 = new javax.swing.JLabel();
        lblSoLuong3 = new javax.swing.JLabel();
        lblSoLuong4 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        intSach = new javax.swing.JPanel();
        jlabelSach = new javax.swing.JLabel();
        intDocgia = new javax.swing.JPanel();
        jLabelDocgia = new javax.swing.JLabel();
        intNhanvien = new javax.swing.JPanel();
        jLabelNhanvien = new javax.swing.JLabel();
        intNhanvien1 = new javax.swing.JPanel();
        jLabelMuon = new javax.swing.JLabel();
        jLabelservice = new javax.swing.JLabel();
        cmbNam = new javax.swing.JComboBox();
        pnDT = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbquy = new javax.swing.JLabel();
        lbquy1 = new javax.swing.JLabel();
        lbquy2 = new javax.swing.JLabel();
        lbquy3 = new javax.swing.JLabel();
        lbquy4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbdt = new javax.swing.JLabel();
        lbdt1 = new javax.swing.JLabel();
        lbdt2 = new javax.swing.JLabel();
        lbdt3 = new javax.swing.JLabel();
        lbdt4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbsum1 = new javax.swing.JLabel();
        lbsum = new javax.swing.JLabel();
        jLabelDocgia2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        pnchitiet.setBackground(new java.awt.Color(130, 195, 65));
        pnchitiet.setMaximumSize(new java.awt.Dimension(1000, 649));
        pnchitiet.setMinimumSize(new java.awt.Dimension(1000, 649));
        pnchitiet.setPreferredSize(new java.awt.Dimension(1000, 649));
        pnchitiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbtop.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbtop.setForeground(new java.awt.Color(255, 255, 255));
        lbtop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop.setText("Tên sản phẩm");
        pnchitiet.add(lbtop, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 390, 50));

        lbtop2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbtop2.setForeground(new java.awt.Color(255, 255, 255));
        lbtop2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop2.setText("Số lượng");
        pnchitiet.add(lbtop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 160, 50));

        lbtop4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbtop4.setForeground(new java.awt.Color(255, 255, 255));
        lbtop4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop4.setText("5");
        lbtop4.setToolTipText("");
        pnchitiet.add(lbtop4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 120, 30));

        lbtop3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbtop3.setForeground(new java.awt.Color(255, 255, 255));
        lbtop3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop3.setText("Top bán chạy");
        pnchitiet.add(lbtop3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 50));

        pnChart.setBackground(new java.awt.Color(130, 195, 65));
        pnChart.setPreferredSize(new java.awt.Dimension(1000, 300));
        pnchitiet.add(pnChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, -1, 150));

        lbtop5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbtop5.setForeground(new java.awt.Color(255, 255, 255));
        lbtop5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop5.setText("Top");
        pnchitiet.add(lbtop5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 120, 50));

        lbtop6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbtop6.setForeground(new java.awt.Color(255, 255, 255));
        lbtop6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop6.setText("1");
        lbtop6.setToolTipText("");
        pnchitiet.add(lbtop6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, 30));

        lbtop7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbtop7.setForeground(new java.awt.Color(255, 255, 255));
        lbtop7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop7.setText("2");
        lbtop7.setToolTipText("");
        pnchitiet.add(lbtop7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 120, 30));

        lbtop8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbtop8.setForeground(new java.awt.Color(255, 255, 255));
        lbtop8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop8.setText("3");
        lbtop8.setToolTipText("");
        pnchitiet.add(lbtop8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 120, 30));

        lbtop9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbtop9.setForeground(new java.awt.Color(255, 255, 255));
        lbtop9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtop9.setText("4");
        lbtop9.setToolTipText("");
        pnchitiet.add(lbtop9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 120, 30));

        lbMon1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbMon1.setForeground(new java.awt.Color(255, 255, 255));
        lbMon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMon1.setText("jLabel1");
        pnchitiet.add(lbMon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 390, 30));

        lbMon5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbMon5.setForeground(new java.awt.Color(255, 255, 255));
        lbMon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMon5.setText("jLabel1");
        pnchitiet.add(lbMon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 390, 30));

        lbMon2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbMon2.setForeground(new java.awt.Color(255, 255, 255));
        lbMon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMon2.setText("jLabel1");
        pnchitiet.add(lbMon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 390, 30));

        lbMon3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbMon3.setForeground(new java.awt.Color(255, 255, 255));
        lbMon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMon3.setText("jLabel1");
        pnchitiet.add(lbMon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 390, 30));

        lbMon4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbMon4.setForeground(new java.awt.Color(255, 255, 255));
        lbMon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMon4.setText("jLabel1");
        pnchitiet.add(lbMon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 390, 30));

        lblSoLuong5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSoLuong5.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoLuong5.setText("jLabel1");
        pnchitiet.add(lblSoLuong5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 160, 30));

        lblSoLuong1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSoLuong1.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoLuong1.setText("jLabel1");
        pnchitiet.add(lblSoLuong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 160, 30));

        lblSoLuong2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSoLuong2.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoLuong2.setText("jLabel1");
        pnchitiet.add(lblSoLuong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 160, 30));

        lblSoLuong3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSoLuong3.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoLuong3.setText("jLabel1");
        pnchitiet.add(lblSoLuong3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 160, 30));

        lblSoLuong4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSoLuong4.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoLuong4.setText("jLabel1");
        pnchitiet.add(lblSoLuong4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 160, 30));

        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnchitiet.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 670, 200));

        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnchitiet.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 390, 200));

        jSeparator8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnchitiet.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 670, 30));

        jSeparator9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnchitiet.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 670, 30));

        jSeparator10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnchitiet.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 670, 30));

        jSeparator11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnchitiet.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 670, 30));

        jFrame1.getContentPane().add(pnchitiet, java.awt.BorderLayout.CENTER);

        setBackground(new java.awt.Color(130, 195, 65));
        setMinimumSize(new java.awt.Dimension(1000, 649));
        setPreferredSize(new java.awt.Dimension(1000, 649));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(130, 195, 65));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 649));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 649));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        intSach.setBackground(new java.awt.Color(120, 122, 124));
        intSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        intSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlabelSach.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jlabelSach.setForeground(new java.awt.Color(255, 255, 255));
        jlabelSach.setText("Số lượng sách");
        intSach.add(jlabelSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, 70));

        jPanel1.add(intSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 300, 120));

        intDocgia.setBackground(new java.awt.Color(6, 107, 208));
        intDocgia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        intDocgia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDocgia.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jLabelDocgia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDocgia.setText("Số lượng khách hàng");
        intDocgia.add(jLabelDocgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 70));

        jPanel1.add(intDocgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 300, 120));

        intNhanvien.setBackground(new java.awt.Color(56, 107, 158));
        intNhanvien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        intNhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNhanvien.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jLabelNhanvien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNhanvien.setText("Số lượng nhân viên");
        intNhanvien.add(jLabelNhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 230, 70));

        jPanel1.add(intNhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 300, 120));

        intNhanvien1.setBackground(new java.awt.Color(89, 107, 125));
        intNhanvien1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        intNhanvien1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMuon.setBackground(new java.awt.Color(224, 224, 224));
        jLabelMuon.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jLabelMuon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMuon.setText("đã bán");
        intNhanvien1.add(jLabelMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 230, 70));

        jLabelservice.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        jLabelservice.setForeground(new java.awt.Color(255, 255, 255));
        jLabelservice.setText("Tổng doanh thu");
        intNhanvien1.add(jLabelservice, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 230, 70));

        jPanel1.add(intNhanvien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 300, 120));

        cmbNam.setBackground(new java.awt.Color(130, 195, 65));
        cmbNam.setForeground(new java.awt.Color(255, 255, 255));
        cmbNam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2023", "2022", "2021", "2020" }));
        jPanel1.add(cmbNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 90, 40));

        pnDT.setBackground(new java.awt.Color(153, 153, 153));
        pnDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDT.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 202, 130));

        lbquy.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbquy.setForeground(new java.awt.Color(255, 255, 255));
        lbquy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbquy.setText("Qúy");
        pnDT.add(lbquy, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        lbquy1.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbquy1.setForeground(new java.awt.Color(255, 255, 255));
        lbquy1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbquy1.setText("Qúy 1");
        pnDT.add(lbquy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 200, 60));

        lbquy2.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbquy2.setForeground(new java.awt.Color(255, 255, 255));
        lbquy2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbquy2.setText("Qúy 3");
        pnDT.add(lbquy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 200, 60));

        lbquy3.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbquy3.setForeground(new java.awt.Color(255, 255, 255));
        lbquy3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbquy3.setText("Qúy 2");
        pnDT.add(lbquy3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 200, 60));

        lbquy4.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbquy4.setForeground(new java.awt.Color(255, 255, 255));
        lbquy4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbquy4.setText("Qúy 4");
        pnDT.add(lbquy4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 210, 60));

        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDT.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 202, 130));

        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDT.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 202, 130));

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDT.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 70));

        lbdt.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbdt.setForeground(new java.awt.Color(255, 255, 255));
        lbdt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdt.setText("Doanh thu");
        pnDT.add(lbdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 70));

        lbdt1.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbdt1.setForeground(new java.awt.Color(255, 255, 255));
        lbdt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdt1.setText("0");
        pnDT.add(lbdt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 200, 70));

        lbdt2.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbdt2.setForeground(new java.awt.Color(255, 255, 255));
        lbdt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdt2.setText("0");
        pnDT.add(lbdt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 200, 70));

        lbdt3.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbdt3.setForeground(new java.awt.Color(255, 255, 255));
        lbdt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdt3.setText("0");
        pnDT.add(lbdt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 200, 70));

        lbdt4.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbdt4.setForeground(new java.awt.Color(255, 255, 255));
        lbdt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdt4.setText("0");
        pnDT.add(lbdt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 210, 70));

        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnDT.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, 70));

        lbsum1.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbsum1.setForeground(new java.awt.Color(255, 255, 255));
        lbsum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbsum1.setText("Tổng cộng");
        pnDT.add(lbsum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 190, 70));

        lbsum.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        lbsum.setForeground(new java.awt.Color(255, 255, 255));
        lbsum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbsum.setText("0");
        pnDT.add(lbsum, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 810, 70));

        jPanel1.add(pnDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1000, 200));

        jLabelDocgia2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabelDocgia2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDocgia2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDocgia2.setText("Thống kê tổng quát");
        jPanel1.add(jLabelDocgia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 760, 80));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Desktop\\Java\\ql_nhasach\\image\\TKCT.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 70));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jFrame1.setVisible(true);
        jFrame1.setSize(1000, 649);
        jFrame1.setTitle("Thống kê chi tiết");
        veLaiChart();
        pnChart.setSize(1000,300);
    }//GEN-LAST:event_jButton1ActionPerformed
   private void veLaiChart() {
        pnChart.removeAll();

        chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new Dimension(1030, 441));
        chartPanel.setBackground(new Color(130,195,65));

        pnChart.add(chartPanel);
    }

    private JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh thu năm " + Calendar.getInstance().get(Calendar.YEAR),
                "Tháng", "Doanh thu",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        barChart.setBackgroundPaint(new Color(135,195,65));
        
        return barChart;
    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 1; i <= 12; i++) {
            
            double value = tkbus.getDoanhThuThang(i, Calendar.getInstance().get(Calendar.YEAR));
            dataset.addValue(value, "Doanh thu", i + "");
        }
        return dataset;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox cmbNam;
    public javax.swing.JPanel intDocgia;
    public javax.swing.JPanel intNhanvien;
    public javax.swing.JPanel intNhanvien1;
    public javax.swing.JPanel intSach;
    public javax.swing.JButton jButton1;
    public javax.swing.JFrame jFrame1;
    public javax.swing.JLabel jLabelDocgia;
    public javax.swing.JLabel jLabelDocgia2;
    public javax.swing.JLabel jLabelMuon;
    public javax.swing.JLabel jLabelNhanvien;
    public javax.swing.JLabel jLabelservice;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator10;
    public javax.swing.JSeparator jSeparator11;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator3;
    public javax.swing.JSeparator jSeparator4;
    public javax.swing.JSeparator jSeparator5;
    public javax.swing.JSeparator jSeparator6;
    public javax.swing.JSeparator jSeparator7;
    public javax.swing.JSeparator jSeparator8;
    public javax.swing.JSeparator jSeparator9;
    public javax.swing.JLabel jlabelSach;
    public javax.swing.JLabel lbMon1;
    public javax.swing.JLabel lbMon2;
    public javax.swing.JLabel lbMon3;
    public javax.swing.JLabel lbMon4;
    public javax.swing.JLabel lbMon5;
    public javax.swing.JLabel lbdt;
    public javax.swing.JLabel lbdt1;
    public javax.swing.JLabel lbdt2;
    public javax.swing.JLabel lbdt3;
    public javax.swing.JLabel lbdt4;
    public javax.swing.JLabel lblSoLuong1;
    public javax.swing.JLabel lblSoLuong2;
    public javax.swing.JLabel lblSoLuong3;
    public javax.swing.JLabel lblSoLuong4;
    public javax.swing.JLabel lblSoLuong5;
    public javax.swing.JLabel lbquy;
    public javax.swing.JLabel lbquy1;
    public javax.swing.JLabel lbquy2;
    public javax.swing.JLabel lbquy3;
    public javax.swing.JLabel lbquy4;
    public javax.swing.JLabel lbsum;
    public javax.swing.JLabel lbsum1;
    public javax.swing.JLabel lbtop;
    public javax.swing.JLabel lbtop2;
    public javax.swing.JLabel lbtop3;
    public javax.swing.JLabel lbtop4;
    public javax.swing.JLabel lbtop5;
    public javax.swing.JLabel lbtop6;
    public javax.swing.JLabel lbtop7;
    public javax.swing.JLabel lbtop8;
    public javax.swing.JLabel lbtop9;
    public javax.swing.JPanel pnChart;
    public javax.swing.JPanel pnDT;
    public javax.swing.JPanel pnchitiet;
    // End of variables declaration//GEN-END:variables
}
