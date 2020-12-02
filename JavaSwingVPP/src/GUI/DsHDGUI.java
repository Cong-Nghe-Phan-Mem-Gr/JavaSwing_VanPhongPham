
package GUI;

import BUS.HoadonBUS;
import static BUS.HoadonBUS.giohang;
import DTO.GioHangDTO;
import static GUI.BanhangGUI.carttable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static BUS.HoadonBUS.dshd;
import DTO.HoadonDTO;
import DTO.SanphamDTO;
import static java.awt.Color.red;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
//import static GUI.OverallFrame.currentIdnv;

public class DsHDGUI extends JFrame implements MouseListener{
    private JLabel lbl,xoabtn,inbtn,closebtn,searchbtn;
    private Font f = new Font("Arial",Font.BOLD,18);
    JTextField searchtxt;
    private DefaultTableModel model;
    private JScrollPane jsp;
    private String[] header = {"IDHD","IDKH","Ngày lập","Tổng tiền",""};
    private ImageIcon info = new ImageIcon(this.getClass().getResource("/Icons/info.png"));
    public static JTable table;
    public DsHDGUI(){
        load();
        setSize(400,350);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        lbl = new JLabel("Lịch sử bán hàng");
        lbl.setBounds(120,5,250,35);
        lbl.setForeground(red);
        lbl.setFont(f);
        searchtxt = new JTextField(18);
        searchtxt.setBounds(120,50,150,25);
        searchbtn = new JLabel();
        searchbtn.setBounds(270,40,30,40);
        searchbtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png")));
        searchbtn.addMouseListener(this);
        model = new DefaultTableModel(header,0);
        table = new JTable(model);
        jsp= new JScrollPane(table);
        
        jsp.setBounds(50,90,300,200);
        closebtn = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/closeicon1.png")));
        closebtn.setBounds(365,0,35,35);
        closebtn.setFont(f);
        closebtn.setBorder(new LineBorder(red,3,true));
        closebtn.addMouseListener(this);
        
        add(lbl);
        add(lbl);
        add(closebtn);
        add(jsp);
        add(searchbtn);
        add(searchtxt);
        loaddata(dshd);
    }
    public void load(){
        HoadonBUS bus = new HoadonBUS();
        if(dshd == null) bus.docDshoadon("NV1");
    }
    
    public static void main(String[] args) {
        DsHDGUI a = new DsHDGUI();
        a.setVisible(true);
    }
    public void loaddata(ArrayList<HoadonDTO> ds){
        model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row,int col){
                if(col == 4){
                    return true;
                }else return false;
            }
        };
        for(HoadonDTO hd : ds){
            Object[] data = {hd.idhd,hd.idkh,hd.ngaylap,hd.tongtien,info};
            model.addRow(data);
        }
        table.setModel(model);
        table.getColumnModel().getColumn(4).setCellRenderer(new InfoButtonRender());
        table.getColumnModel().getColumn(4).setCellEditor(new InfoButtonRender());
        table.getColumnModel().setColumnSelectionAllowed(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(35);
        table.setRowHeight(35);
        table.setShowVerticalLines(false);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == searchbtn){
            HoadonBUS bus = new HoadonBUS();
            ArrayList<HoadonDTO> dstimkiem = new ArrayList();
            dstimkiem = bus.search(searchtxt.getText());
            if(dstimkiem.size()==0){ 
                JOptionPane.showMessageDialog(null,"Không tìm thấy kết quả phù hợp");
            }else{
                loaddata(dstimkiem);
            }
        } if(e.getSource() == searchbtn){
            this.setVisible(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
