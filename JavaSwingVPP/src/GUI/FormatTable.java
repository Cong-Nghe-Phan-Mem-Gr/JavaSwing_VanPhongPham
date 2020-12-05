/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Nam
 */
public class FormatTable extends DefaultTableCellRenderer {
    public static int currentRow = -1;
    public static int i;
    JLabel icon = new JLabel();
    public static int col;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);

        if (row % 2 != 0) {//doi mau hang chan va le
            this.setBackground(new Color(190, 220, 190));
        } else {
            this.setBackground(new Color(230, 255, 250));
        }
        if (row == currentRow) {
            this.setBackground(new Color(250, 250, 150));

        }
        if (isSelected == true)//neu dc click
        {
            this.setBackground(new Color(255, 153, 0));
        }
        this.setOpaque(true);
        return lb;
    }

    public void formatTablenoIcon(JTable nameTable) {
        FormatTable renderer = new FormatTable();
        nameTable.setDefaultRenderer(Object.class, renderer);
        //nameTable.setDefaultRenderer(ImageIcon.class, renderer);
        //dieu chinh jtable
        nameTable.setRowHeight(32);
        nameTable.setShowHorizontalLines(false);
        nameTable.setShowVerticalLines(false);
        //header
        nameTable.getTableHeader().setBackground(new Color(153, 255, 0));
        JTableHeader head = nameTable.getTableHeader();
        head.setFont(new Font("Tahoma", Font.BOLD, 13));
        head.setPreferredSize(new Dimension(head.getWidth(), 40));
        nameTable.setIntercellSpacing(new Dimension(0, 0));
    }
    public void formatTable(JTable nameTable, String iconName, int col)
    {
        FormatTable renderer = new FormatTable();
        nameTable.setDefaultRenderer(Object.class, renderer);
        //nameTable.setDefaultRenderer(ImageIcon.class, renderer);
        //dieu chinh jtable
        nameTable.setRowHeight(32);
        nameTable.setShowHorizontalLines(false);
        nameTable.setShowVerticalLines(false);
        //header
        nameTable.getTableHeader().setBackground(new Color(153, 255, 0));
        JTableHeader head = nameTable.getTableHeader();
        head.setFont(new Font("Tahoma", Font.BOLD, 13));
        head.setPreferredSize(new Dimension(head.getWidth(),40));
        nameTable.setIntercellSpacing(new Dimension(0,0));
        nameTable.setDefaultRenderer(Object.class, new DefaultTableCellHeaderRenderer()
        {
            @Override
                public Component getTableCellRendererComponent(JTable table, Object value, 
                        boolean isSelected, boolean hasFocus, int row, int column) 
                {
                    JLabel lb = (JLabel) super.getTableCellRendererComponent(table, value, 
                            isSelected, hasFocus, row, column);
                    
                      if (row % 2 != 0) {//doi mau hang chan va le
                        this.setBackground(new Color(190, 220, 190));
                    } else {
                        this.setBackground(new Color(230, 255, 250));
                    }
                      if (row == currentRow) 
                    {
                        this.setBackground(new Color(250, 250, 150));
                        
                    }
                      if (column == col) 
                    {
                        //table.getColumnModel().getColumn(6).
//                        icon.setIcon(new ImageIcon("./src/img/" + iconName + ".png"));
//                        icon.setHorizontalAlignment(SwingConstants.CENTER);
//                        return icon;
                        lb.setIcon(new ImageIcon("./src/img/" + iconName + ".png"));
                        table.setIntercellSpacing(new Dimension(0,0));
                    }
                    if (isSelected == true)//neu dc click
                    {
                        this.setBackground(new Color(255, 153, 0));
                    }
                    this.setOpaque(true);
                    return lb;
                }
        });
}
}
