/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class category {
    private String kind;
    private JPanel jpn;

    public category(String kind, JPanel jpn) {
        this.kind = kind;
        this.jpn = jpn;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }    
}