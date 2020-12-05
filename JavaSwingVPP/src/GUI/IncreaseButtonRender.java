package GUI;

import BUS.HoadonBUS;
import static BUS.HoadonBUS.tongsl;
import static BUS.HoadonBUS.tongtien;
import static GUI.BanhangGUI.carttable;
import static GUI.BanhangGUI.loadinfo;
import static GUI.BanhangGUI.loadTienthua;
import static GUI.BanhangGUI.mangdisplaysp;
import static GUI.BanhangGUI.loadkm;
import static GUI.BanhangGUI.check;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class IncreaseButtonRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor,ActionListener{
    private JTable table;
    private JButton increasebtn;

    public IncreaseButtonRender(){
        this.table = table;
        increasebtn = new JButton();
        increasebtn.setOpaque(false);
        increasebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HoadonBUS bus = new HoadonBUS();
                DefaultTableModel tablemodel = (DefaultTableModel) carttable.getModel();
                int i = carttable.getSelectedRow();
                String idsp = carttable.getValueAt(i,0).toString();
                int sl = Integer.parseInt(carttable.getValueAt(i,5).toString());
                int tonkho = Integer.parseInt(carttable.getValueAt(i,2).toString());
                int dongia = Integer.parseInt(carttable.getValueAt(i,3).toString());
                if(tonkho != 0){
                    tablemodel.setValueAt(tonkho-1,i,2);
                    tablemodel.setValueAt(sl+1,i,5);
                    carttable.setValueAt((sl+1)*dongia,i,7); 
                    bus.tangsl(idsp,1);
                    for(SanphamGUI sp : mangdisplaysp){
                         if(idsp.equals(sp.getId())){
                             sp.setTonkho(tonkho-1);
                         }
                    }
                    loadkm(tongtien);
                    loadinfo(tongsl,tongtien);
                    loadTienthua();
                }else{
                    JOptionPane.showMessageDialog(null,"Trong kho không đủ");
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
        if(value instanceof Icon) increasebtn.setIcon((Icon)value);
        return increasebtn;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Icon) increasebtn.setIcon((Icon)value);
        return increasebtn;
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
