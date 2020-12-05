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
import static GUI.BanhangGUI.carttable;
import static GUI.BanhangGUI.loadinfo;
import static GUI.BanhangGUI.mangdisplaysp;
import static GUI.BanhangGUI.loadTienthua;
import static GUI.BanhangGUI.carttable;
import static GUI.BanhangGUI.loadTienthua;
import static GUI.BanhangGUI.loadgoiy;
import static GUI.BanhangGUI.loadinfo;
import static GUI.BanhangGUI.check;
import static GUI.BanhangGUI.loadkm;
import static GUI.BanhangGUI.mangdisplaysp;
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
                int sl = Integer.parseInt(carttable.getValueAt(i,5).toString());
                int tonkho = Integer.parseInt(carttable.getValueAt(i,2).toString());
                int dongia = Integer.parseInt(carttable.getValueAt(i,3).toString());
                String idsp = carttable.getValueAt(i,0).toString();
                HoadonBUS bus = new HoadonBUS();
                if(sl != 1){
                    tablemodel.setValueAt(tonkho+1,i,2);
                    tablemodel.setValueAt(sl-1,i,5);
                    carttable.setValueAt((sl-1)*dongia,i,7); 
                    bus.giamsl(idsp,1);
                    for(SanphamGUI sp : mangdisplaysp){
                        if(idsp.equals(sp.getId())){
                            sp.setTonkho(tonkho+1);
                        }
                    }
                    loadinfo(tongsl,tongtien);
                    loadTienthua();
                }else{
                    stopCellEditing();
                    int answer = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.WARNING_MESSAGE);
                    if(answer == JOptionPane.YES_OPTION){
                        for(SanphamGUI sp : mangdisplaysp){
                            if(sp.getId().equals(idsp)){
                                sp.setTonkho(tonkho+sl);
                            }
                        }
                        bus.removeCart(idsp);
                        loadkm(tongtien);
                        loadinfo(tongsl,tongtien);
                        loadTienthua();
                        loadgoiy();
                        tablemodel.removeRow(i);
                        JOptionPane.showMessageDialog(null,"Bạn đã xóa thành công");
                        stopCellEditing();
                    }
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
