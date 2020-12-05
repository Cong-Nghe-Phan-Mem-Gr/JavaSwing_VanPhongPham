/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.*;
import static GUI.QuanlimonanGUI.idloai;
import static GUI.QuanlimonanGUI.tenmon;
import static GUI.QuanlimonanGUI.idmon;
import static GUI.QuanlimonanGUI.dongia;
import static GUI.QuanlimonanGUI.giamgia;
import static GUI.QuanlimonanGUI.sldaban;
import static GUI.QuanlimonanGUI.tonkho;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author USER
 */
public class EditButtonRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JTable table;
    private JButton editbtn;
    private OverallFrame home;
    public EditButtonRender(JTable table){
        editbtn = new JButton();
        editbtn.setOpaque(true);
        this.table = table;
        editbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int i = table.getSelectedRow();
                idmon = table.getValueAt(i,0).toString();
                idloai = table.getValueAt(i,1).toString();
                tenmon = table.getValueAt(i,2).toString();   
                dongia = table.getValueAt(i,3).toString();
                tonkho = table.getValueAt(i,4).toString();
                sldaban = table.getValueAt(i,5).toString();
                giamgia = table.getValueAt(i,6).toString();
                Editformdialog a = new Editformdialog(home,true);
                a.setVisible(true);
                if(!a.isVisible()){
                    Edit(table);
                }
            }
        });     
    }    
    
    public void Edit(JTable table){
        int i = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(tenmon,i,2);
        model.setValueAt(dongia,i,4);
    }
    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Icon) editbtn.setIcon((Icon)value);
        return editbtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) editbtn.setIcon((Icon)value);
        return editbtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
