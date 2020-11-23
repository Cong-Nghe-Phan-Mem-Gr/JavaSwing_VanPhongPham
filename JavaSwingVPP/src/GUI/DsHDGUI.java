
package GUI;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
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
import static sun.misc.ClassFileTransformer.add;

public class DsHDGUI extends JFrame implements MouseListener{
    private JLabel lbl,xoabtn,inbtn,closebtn;
    private Font f = new Font("Arial",Font.BOLD,16);
    private DefaultTableModel model;
    private JScrollPane jsp;
    private String[] header = {"IDHD","IDKH","Ngày lập","Tổng tiền",""};
    public DsHDGUI(){
        setSize(400,250);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        lbl = new JLabel("Danh sách hóa đơn");
        lbl.setBounds(80,30,250,35);
        lbl.setFont(f);
        xoabtn = new JLabel("Xóa hóa đơn");
        xoabtn.setFont(f);
        xoabtn.setPreferredSize(new Dimension(170,30));
        inbtn = new JLabel("In hóa đơn");
        inbtn.setFont(f);
        inbtn.setPreferredSize(new Dimension(170,30));
        jsp= new JScrollPane();
        jsp.setBounds(50,70,300,150);
        closebtn = new JLabel();
        ImageIcon closeicon1 = new ImageIcon(this.getClass().getResource("/Icons/closeicon3.png"));
        closebtn.setBounds(370,0,35,35);
        closebtn.setFont(f);
        closebtn.setIcon(closeicon1);
        closebtn.addMouseListener(this);
        
        add(lbl);
        add(xoabtn);
        add(inbtn);
        add(lbl);
        add(closebtn);
        add(jsp);
        
    }
    
    public static void main(String[] args) {
        
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
