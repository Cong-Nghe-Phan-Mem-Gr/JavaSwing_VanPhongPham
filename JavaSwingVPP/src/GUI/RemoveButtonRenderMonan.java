/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietGiamBUS;
import BUS.MonanBUS;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static BUS.MonanBUS.dsmonan;
/**
 *
 * @author USER
 */
public class RemoveButtonRenderMonan extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton removebtn;
    private JTable table;
    public RemoveButtonRenderMonan(JTable table){
        removebtn = new JButton();
        this.table = table;
        removebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try
                {
                int answer = JOptionPane.showConfirmDialog(null,"Bạn có chắc không",null,JOptionPane.WARNING_MESSAGE);
                if(answer == JOptionPane.YES_OPTION){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int i = table.getSelectedRow();
                    String idmon = table.getValueAt(i,0).toString();
                    MonanBUS bus = new MonanBUS();
                    bus.removeMonan(idmon);
                    ChiTietGiamBUS ctbus = new ChiTietGiamBUS();
                    ctbus.deleteChitietMonan(idmon);
                    model.removeRow(i);
                    JOptionPane.showMessageDialog(null,"Bạn đã xóa thành công");
                    stopCellEditing();
                }
                } catch(Exception err)
                {
                    System.out.println(err);
                    System.out.println("no");
                }
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
    
    @Override 
    public boolean stopCellEditing(){
        return super.stopCellEditing();
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }
    
    @Override
    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
