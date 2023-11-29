/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;
import GUI.*;
import java.awt.*;
import DTO.PhanQuyenDTO;
import DAO.PhanQuyenDAO;
import BUS.PhanQuyenBUS;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Object;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Controller {
    private JPanel root;
    private String Selected = "";
    private List<category> cate = null;
    

   public Controller(JPanel jpnRoot){
       this.root = jpnRoot;
       
   }
    public void setView(JPanel jpnItem){
        Selected = "Default";
        jpnItem.setBackground(new Color(130,195,65));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new JPnDefault());
        root.validate();
        root.repaint();
        }
    public void setEvent(List<category> cate){
        this.cate = cate;
        for(category item: cate){
            item.getJpn().addMouseListener(new PanelEvent(item.getKind(),item.getJpn()));
        }
    }
    

class PanelEvent implements MouseListener{
    JPanel node;
    String kind;
    JPanel jpnItem;
    JLabel jlbitem;
    public PanelEvent(String kind, JPanel jpnItem) {
        this.kind = kind;
        this.jpnItem = jpnItem;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(kind){
            case "Default":
                node = new JPnDefault();
                break;
            case "Bán hàng":
                node = new JPnService();
                break;
            case "Sách":
                node = new JPnBooks();
                break;
            case "Khuyến mãi":
                node = new JPnVoucher();
                break;
            case "Nhân viên":
                node = new JPnEmployee();
                break;
            case "Khách hàng":
                node = new JPnCustomer();
                break;
            case "Nhập hàng":
                node = new JPnImport();
                break;
            case "Thống kê":
                node = new JPnAnalyze();
                break;
            default:
                node = new JPnDefault();
                break;
                
        }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
        setChangeBackground(kind);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Selected = kind;
        jpnItem.setBackground(new Color(130,195,65));
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!Selected.equalsIgnoreCase(kind)){
       jpnItem.setBackground(new Color(130,165,95));
       jpnItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!Selected.equalsIgnoreCase(kind)){
            jpnItem.setBackground(new Color(255,255,255));
        }
    }
    private void setChangeBackground(String kind){
        for(category item: cate){
            if(item.getKind().equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(255,255,255));
            }
            else{
                jpnItem.setBackground(new Color(130,195,65));
            }
            
        }
    }
    
}

}