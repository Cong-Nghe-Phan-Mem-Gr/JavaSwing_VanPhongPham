package GUI;

import BUS.HoadonBUS;
import static BUS.HoadonBUS.tongsl;
import static BUS.HoadonBUS.tongtien;
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
import static GUI.BanhangGUI.loadinfo;
import static GUI.BanhangGUI.mangdisplaysp;
import static GUI.BanhangGUI.loadTienthua;
import static GUI.BanhangGUI.carttable;
import static GUI.BanhangGUI.loadTienthua;
import static GUI.BanhangGUI.loadgoiy;
import static GUI.BanhangGUI.loadinfo;
import static GUI.DsHDGUI.table;
import javax.swing.table.DefaultTableModel;


public class InfoButtonRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JButton infobtn;

    public InfoButtonRender(){
        infobtn = new JButton();
        infobtn.setOpaque(false);
        infobtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
                int i = table.getSelectedRow();
                String idhd = table.getValueAt(i,0).toString();
                HoadonBUS bus = new HoadonBUS();
                    //stopCellEditing();
                    HDDetailGUI a = new HDDetailGUI(idhd);
                    a.setVisible(true);
                }
            });
        } 

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Icon) infobtn.setIcon((Icon)value);
        return infobtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) infobtn.setIcon((Icon)value);
        return infobtn;
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

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}