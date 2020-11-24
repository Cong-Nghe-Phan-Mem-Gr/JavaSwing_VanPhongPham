/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.HoadonBUS;
//import DTO.HoadonDTO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.Icon;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.*;
import static GUI.BanhangGUI.carttable;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
/**
 *
 * @author USER
 */
public class RemoveButtonRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JTable table;
    private JButton removebtn;

    public RemoveButtonRender(){
        this.table = table;
        removebtn = new JButton();
        removebtn.setOpaque(false);
        removebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                stopCellEditing();
                int answer = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.WARNING_MESSAGE);
                if(answer == JOptionPane.YES_OPTION){
                DefaultTableModel tablemodel = (DefaultTableModel) carttable.getModel();
                    int i = carttable.getSelectedRow();
                    tablemodel.removeRow(i);
                    JOptionPane.showMessageDialog(null,"Bạn đã xóa thành công");
                    stopCellEditing();
                }
            }   
        }); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        stopCellEditing();
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) removebtn.setIcon((Icon)value);
        return removebtn;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    public void cancelCellEditing() {
        
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
    }
    
    @Override
    public void fireEditingStopped(){
    }
    
}
