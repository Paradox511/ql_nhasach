/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DTO.giamgiaDTO;
import DAO.giamgiaDAO;
import BUS.giamgiaBUS;
import DTO.ReaderDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class JPnVoucher extends javax.swing.JPanel {
    ArrayList<giamgiaDTO> listgg = new ArrayList();
    giamgiaDAO dao = new giamgiaDAO();
    giamgiaBUS bus = new giamgiaBUS();
    DefaultTableModel dtmgg = new DefaultTableModel();
    /**
     * Creates new form JPnVoucher
     */
    public JPnVoucher() {
      
        initComponents();
        loadtblgg();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 public void loadtblgg(){
     dtmgg.setRowCount(0);
       listgg = bus.getListgg();
     Vector header = new Vector();
        header.add("Mã");
        header.add("Tên");
        header.add("Phần trăm");
        header.add("Điều kiện");
        if(dtmgg.getRowCount()==0){
            dtmgg = new DefaultTableModel(header,0);
            
        }
        for (giamgiaDTO dg : listgg) {
            Vector vec = new Vector();
            vec.add(dg.getMa());
            vec.add(dg.getTen());
            vec.add(dg.getPhantram());
            vec.add(dg.getDk());
          
            dtmgg.addRow(vec);
        }
        tblKM.setModel(dtmgg);
           

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKM = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtdieukien = new javax.swing.JTextField();
        txtma = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtphantram = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(130, 195, 65));
        setMinimumSize(new java.awt.Dimension(1000, 649));
        setPreferredSize(new java.awt.Dimension(1000, 649));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKM.setGridColor(new java.awt.Color(255, 51, 0));
        tblKM.setRowHeight(20);
        tblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKM);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 288, 1010, 400));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý mã khuyến mãi");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1000, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã Khuyến mãi");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên Khuyến mãi");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phần trăm giảm giá");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Điều kiện");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Desktop\\Java\\ql_nhasach\\image\\icons\\Delete.png")); // NOI18N
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 110, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Desktop\\Java\\ql_nhasach\\image\\icons\\Add.png")); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 110, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Desktop\\Java\\ql_nhasach\\image\\icons\\Edit.png")); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 110, 30));
        add(txtdieukien, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 330, -1));

        txtma.setEditable(false);
        txtma.setBackground(new java.awt.Color(139, 195, 65));
        add(txtma, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 330, -1));
        add(txtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 330, -1));
        add(txtphantram, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 330, -1));

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 40, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Desktop\\Java\\ql_nhasach\\image\\icons\\Refresh.png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(txtten.getText().length()<=0 || txtphantram.getText().length()<=0 || txtdieukien.getText().length()<= 0){
            JOptionPane.showMessageDialog(null,"Vui lòng điền đầy đủ thông tin");
            return;
        }
          giamgiaBUS bus = new giamgiaBUS();
        giamgiaDTO rd = new giamgiaDTO();
        rd.ten=txtten.getText();
        rd.phantram =Integer.parseInt( txtphantram.getText());
        rd.dk=Integer.parseInt(txtdieukien.getText());
     //   bus.khoitao(rd, dtmDocgia, tblReader);
        Vector header = new Vector();
        header.add("Mã giảm giá");
        header.add("Tên  giảm giá");
        header.add("Phần trăm giảm giá");
        header.add("Điều kiện giảm giá");
       
   if(dtmgg.getRowCount()==0){
       dtmgg = new DefaultTableModel(header,0);
   }
   bus.khoitao(rd,dtmgg,tblKM);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        loadtblgg();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void tblKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKMMouseClicked
        // TODO add your handling code here:
        int i = tblKM.getSelectedRow();
        txtma.setText(tblKM.getValueAt(i,0).toString());
        txtten.setText(tblKM.getValueAt(i,1).toString());
        txtphantram.setText(tblKM.getValueAt(i,2).toString());
        txtdieukien.setText(tblKM.getValueAt(i,3).toString());
        
    }//GEN-LAST:event_tblKMMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(tblKM.getSelectedRow()<0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn khuyến mãi muốn sửa");
            return;
        } else if(txtten.getText().length()<=0 || txtphantram.getText().length()<=0 || txtdieukien.getText().length()<= 0){
            JOptionPane.showMessageDialog(null,"Vui lòng điền đầy đủ thông tin");
            return;
        }
        giamgiaDTO gg = new giamgiaDTO();
        gg.setMa(Integer.parseInt(txtma.getText()));
        gg.setTen(txtten.getText());
        gg.setPhantram(Double.parseDouble(txtphantram.getText()));
        gg.setDk(Integer.parseInt(txtdieukien.getText()));
        bus.sua(gg);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           if(tblKM.getSelectedRow()<0){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn khuyến mãi muốn xóa");
            return;
        }
        int ma = Integer.parseInt(txtma.getText());
        bus.xoa(ma);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        loadtblgg();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblKM;
    public javax.swing.JTextField txtdieukien;
    public javax.swing.JTextField txtma;
    public javax.swing.JTextField txtphantram;
    public javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}