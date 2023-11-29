/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author quang
 */
public class HamPhu {
    public String chuyenDoiChuoiTien(int soTien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(soTien);
    }
    public int chuyenDoiSoTien(String soTien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        Number number = null;
            try {
                number = decimalFormat.parse(soTien);
            } catch (ParseException ex) {
                Logger.getLogger(HamPhu.class.getName()).log(Level.SEVERE, null, ex);
            }
        return number.intValue();
    }
     public JFrame chuyenJPanelSangJFrame(JPanel panel, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        return frame;
    }
     public JPanel chuyenJFrameSangJPanel(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(frame.getContentPane().getSize());
        panel.add(frame.getContentPane());
        return panel;
    }

}
