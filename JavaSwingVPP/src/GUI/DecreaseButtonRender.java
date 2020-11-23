package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import static GUI.BanhangGUI.carttable;
import javax.swing.table.DefaultTableModel;

public class DecreaseButtonRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JTable table;
    private JButton decreasebtn;

    public DecreaseButtonRender(){
        this.table = table;
        decreasebtn = new JButton();
        decreasebtn.setOpaque(false);
        decreasebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //stopCellEditing();
                DefaultTableModel tablemodel = (DefaultTableModel) carttable.getModel();
                int i = carttable.getSelectedRow();
                //String tenmonan = carttable.getValueAt(i,2).toString();
                int sl = Integer.parseInt(carttable.getValueAt(i,5).toString());
                int tonkho = Integer.parseInt(carttable.getValueAt(i,2).toString());
                //System.out.println(tenmonan);
                //HoadonBUS bus = new HoadonBUS();
              //  bus.removeCart(tenmonan,soluong);
               // tablemodel.removeRow(i);
                tablemodel.setValueAt(tonkho+1,i,2);
                tablemodel.setValueAt(sl-1,i,5);
                stopCellEditing();
            }
        }); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        stopCellEditing();
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Icon) decreasebtn.setIcon((Icon)value);
        return decreasebtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) decreasebtn.setIcon((Icon)value);
        return decreasebtn;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
