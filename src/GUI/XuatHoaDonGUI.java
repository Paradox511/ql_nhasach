package GUI;

import DTO.ReaderDTO;
import DTO.giamgiaDTO;
import BUS.CTHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.ReaderBUS;
import BUS.giamgiaBUS;
import DTO.sachDTO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;

public class XuatHoaDonGUI extends JDialog {

    private HoaDonBUS hoadonBUS = new HoaDonBUS();
    private CTHoaDonBUS ctHoaDonBUS = new CTHoaDonBUS();
  //  private DlgTimKhach timKhachUI = new DlgTimKhach();
  //  private DlgTimMaGiam timMaUI;

    public XuatHoaDonGUI() {
        checkBanHang = false;
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("image/ManagerUI/icon-app.png");
        this.setIconImage(icon);
        loadDataCmbKH();
        loadDataCmbVoucher();
        checkKhachMa();
      //  customEvents();
    }

    private ArrayList<sachDTO> dsGioHang;
    private int tongTien;
    private String nhanVien;

    public XuatHoaDonGUI(ArrayList dsGioHang, int tongTien, String nhanVien) {
        this();
        this.tongTien = tongTien;
        this.dsGioHang = dsGioHang;
        this.nhanVien = (String) nhanVien;
        DecimalFormat dcf = new DecimalFormat("###,###");
        txtTongTien.setText(dcf.format(tongTien));
    }

   

    

    private void checkKhachMa() {
        if (!cmbKhachhang.getSelectedItem().equals("") && !cmbvoucher.getSelectedItem().equals("")) {
            btnThanhToan.setEnabled(true);
        } else {
            btnThanhToan.setEnabled(false);
        }
    }
public void loadDataCmbKH (){
        cmbKhachhang.removeAll();
        ReaderBUS tgbus = new ReaderBUS();
        ArrayList<ReaderDTO> tacgiaList = tgbus.getListKH();

        cmbKhachhang.addItem("0 - Chọn khách hàng ");

        for (ReaderDTO DataBox : tacgiaList) {
            cmbKhachhang.addItem(DataBox.getho() + " " + DataBox.getten());
        }
        cmbKhachhang.addItem("Het");
    }
public void loadDataCmbVoucher (){
        cmbvoucher.removeAll();
        giamgiaBUS tgbus = new giamgiaBUS();
        ArrayList<giamgiaDTO> tacgiaList = tgbus.getListgg();

        cmbvoucher.addItem("0");

        for (giamgiaDTO DataBox : tacgiaList) {
            cmbvoucher.addItem(DataBox.getTen());
        }
        cmbvoucher.addItem("Het");
    }
    private void xuLyHienThiHoaDon() {
        txtHoaDon.setContentType("text/html");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,### VND");

        String hd = "<style> "
                + "table {"
                + "border: 1px solid;"
                + "border-bottom: none"
                + "}"
                + "tr {"
                + "border-bottom: 1px solid;"
                + "}"
                + "td {"
                + "padding: 8px;"
                + "} "
                + "th {"
                + "font-size:16pt"
                + "}"
                + "</style>";
        hd += "<h1 style='text-align:center;'>HOÁ ĐƠN THANH TOÁN</h1>";
        hd += "Nhân viên: " + nhanVien + "<br/>";
        hd += "Ngày lập: " + dtf.format(now) + "<br/>";
        hd += "Khách hàng: " + cmbKhachhang.getSelectedItem() + "<br/>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
                + "<th>Mã SP</th>"
                + "<th>Tên SP</th>"
                + "<th>Số lượng</th>"
                + "<th>Đơn giá</th>"
                + "<th>Thành tiền</th>"
                + "</tr>";
        for (sachDTO vec : dsGioHang) {
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" + vec.Ma + "</td>";
            hd += "<td style='text-align:left;'>" + vec.Ten + "</td>";
            hd += "<td style='text-align:center;'>" + vec.soLuong + "</td>";
            hd += "<td style='text-align:center;'>" + vec.Gia + "</td>";
            hd += "<td style='text-align:center;'>" + vec.Gia * vec.soLuong + "</td>";
            hd += "</tr>";
        }
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Tổng cộng</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
        hd += "</tr>";
        if (cmbvoucher.getSelectedItem() != null) {
          
            // lấy phần trăm giảm
            int index = cmbvoucher.getSelectedIndex() -1;
            int percent =0;
             giamgiaBUS tgbus = new giamgiaBUS();
        ArrayList<giamgiaDTO> tacgiaList = tgbus.getListgg();
            giamgiaDTO current =  tgbus.getTenfromMa(cmbvoucher.getSelectedItem().toString());
          
            
             int dieukien = 0;
             if(current !=null){
                dieukien = current.getDk(); 
                String pt = String.valueOf(current.getPhantram());
            pt= pt.replace(".0","");
             percent = Integer.parseInt(pt);
             }else {
                 percent = 0;
                 dieukien = 0;
             }
            
            if (tongTien >= dieukien) {
                tongTien = tongTien - (tongTien * percent/ 100);
            
                JOptionPane.showMessageDialog(null,"Thanh toán thành công");
            } else {
              JOptionPane.showMessageDialog(null,"Không đủ điều kiện nhận ưu đãi!");
              //  btnTimMaGiam.setEnabled(true);
                return;
            }
        }
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Khuyến mãi</td>";
        hd += "<td style='text-align:center;'>" + cmbvoucher.getSelectedItem() + "%" + "</td>";
        hd += "</tr>";
        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold'>Thành tiền</td>";
        hd += "<td style='text-align:center;'>" + dcf.format(tongTien) + "</td>";
        hd += "</tr>";
        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>==========================================</div><br/>";
        txtHoaDon.setText(hd);
        txtTongTien.setText(dcf.format(tongTien));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHoaDon = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cmbKhachhang = new javax.swing.JComboBox();
        cmbvoucher = new javax.swing.JComboBox();

        jLabel5.setText("jLabel5");

        setBackground(new java.awt.Color(130, 195, 65));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(130, 195, 65));
        jLabel1.setText("Chi tiết hoá đơn");
        jPanel1.add(jLabel1);

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setEnabled(false);
        btnThanhToan.setPreferredSize(new java.awt.Dimension(128, 45));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel2.add(btnThanhToan);

        btnInHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInHoaDon.setText("In hoá đơn");
        btnInHoaDon.setEnabled(false);
        btnInHoaDon.setPreferredSize(new java.awt.Dimension(128, 45));
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });
        jPanel2.add(btnInHoaDon);

        txtHoaDon.setEditable(false);
        jScrollPane1.setViewportView(txtHoaDon);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã giảm");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tổng tiền");

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cmbKhachhang.setBackground(new java.awt.Color(255, 255, 255));

        cmbvoucher.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addComponent(cmbKhachhang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbvoucher, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static boolean checkBanHang = false;

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {
        checkBanHang = false;
        if (cmbKhachhang.getSelectedItem().equals("")) {
          JOptionPane.showMessageDialog(null,"Xin chọn khách hàng");
            return;
        }
        if (cmbvoucher.getSelectedItem().equals("")) {
          JOptionPane.showMessageDialog(null,"Xin chọn mã giảm");
            return;
        }
        xuLyHienThiHoaDon();
        btnInHoaDon.setEnabled(true);
        ReaderBUS rbus = new ReaderBUS();
        
        ReaderDTO e = rbus.getMafromTen(cmbKhachhang.getSelectedItem().toString());
        int makh = e.getid();
        hoadonBUS.luuHoaDon(makh, nhanVien,tongTien, "Đã thanh toán");

        for (sachDTO vec : dsGioHang) {
            String maSP = vec.Ma + "";
            String soLuong = vec.soLuong + "";
            String donGia = vec.Gia + "";
            String thanhTien = (vec.Gia * vec.soLuong) + "";
            ctHoaDonBUS.addCTHoaDon(maSP, soLuong, donGia, thanhTien);
        }
        btnThanhToan.setEnabled(false);
       // btnTimMaGiam.setEnabled(false);
       // btnTimKhach.setEnabled(false);
        checkBanHang = true;
        
              
    }

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!txtHoaDon.getText().equals("")) {
                txtHoaDon.print();
                this.dispose();
            }
        } catch (PrinterException ex) {
        }
    }


   /* private void btnTimKhachActionPerformed(java.awt.event.ActionEvent evt) {
        timKhachUI.setVisible(true);
        if (timKhachUI.khachHangTimDuoc != null) {
            txtTenKhach.setText(timKhachUI.khachHangTimDuoc.getMaKH() + " - " + timKhachUI.khachHangTimDuoc.getHo() + " " + timKhachUI.khachHangTimDuoc.getTen());
        }
    }


    private void btnTimMaGiamActionPerformed(java.awt.event.ActionEvent evt) {
        timMaUI = new DlgTimMaGiam(tongTien);
        timMaUI.setVisible(true);
        if (timMaUI.maGiamTimDuoc != null) {
            txtMaGiam.setText(timMaUI.maGiamTimDuoc.getMaGiam() + " - " + timMaUI.maGiamTimDuoc.getTenGiamGia());
        }
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox cmbKhachhang;
    private javax.swing.JComboBox cmbvoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane txtHoaDon;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
