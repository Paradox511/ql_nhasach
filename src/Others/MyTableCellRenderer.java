/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ADMIN
 */
public class MyTableCellRenderer extends DefaultTableCellRenderer {
      private int colIndex;
  
  // A constructor that takes the column index as a parameter
  public MyTableCellRenderer (int colIndex) {
    this.colIndex = colIndex;
  }
    @Override
  public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Component c = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
    Object val = table.getValueAt (row, colIndex); // get the value of the 5th column
    if (val instanceof String) { // check if it is an integer
        String i = (String) val; // cast it to int
      if (i.equals("Ngưng xuất bản")) { // if it is 0
        c.setBackground (Color.RED); // set the background to red
        c.setForeground(Color.WHITE);
      } else if (i.equals("Còn xuất bản")) { // if it is 1
        c.setBackground (Color.WHITE); // set the background to white
        c.setForeground(Color.BLACK);
      } else { // otherwise
        c.setBackground (Color.GRAY); // set the background to gray
      }
    }
    return c;
  }
}
    

