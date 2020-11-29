
package GUI;

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

public class DsHDGUI extends JFrame implements MouseListener{
    private JLabel lbl,xoabtn,inbtn,closebtn;
    private Font f = new Font("Arial",Font.BOLD,16);
    private DefaultTableModel model;
    private JScrollPane jsp;
    private String[] header = {"IDHD","IDKH","Ngày lập","Tổng tiền",""};
    public static JTable table;
    public DsHDGUI(){
        setSize(600,400);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        lbl = new JLabel("Danh sách hóa đơn");
        lbl.setBounds(80,30,250,35);
        lbl.setFont(f);
        
        model = new DefaultTableModel(header,0);
        table = new JTable(model);
        /*for(GioHangDTO sp : giohang){
            Object[] data = {sp.getIdsp(),sp.getTensp(),sp.getTonkho(),sp.getDongia(),decreaseicon,sp.getSl(),increaseicon,sp.thanhTien(),removeicon};
            tongsl += sp.sl;
            tongtien += sp.thanhTien();
            cartmodel.addRow(data);
        }*/
        jsp= new JScrollPane(table);
        
        jsp.setBounds(50,70,500,300);
        closebtn = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/closeicon1.png")));
        closebtn.setBounds(370,0,35,35);
        closebtn.setFont(f);
        closebtn.addMouseListener(this);
        
        add(lbl);
        add(xoabtn);
        add(inbtn);
        add(lbl);
        add(closebtn);
        add(jsp);
        
    }
    public void load(){
        
    }
    
    public static void main(String[] args) {
        DsHDGUI a = new DsHDGUI();
        a.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
