/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BUS.MonanBUS;
import static BUS.MonanBUS.dsloaimonan;
import DTO.MonanDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import DTO.LoaimonanDTO;
import javax.swing.table.DefaultTableModel;
import static GUI.QuanlimonanGUI.idloai;
import static GUI.QuanlimonanGUI.tenloai;
        
/**
 *
 * @author USER
 */
public class Dsloaimonandialog extends JDialog implements MouseListener{
    OverallFrame root;
    private JLabel infolbl,addbtn,closebtn;
    private JTable table;
    private String[] header = {"ID Loại","Tên loại"};
    private JScrollPane jsp;
    private DefaultTableModel model;

    
    public Dsloaimonandialog(JFrame parent,boolean modal){
        super(parent,modal);
        parent = (OverallFrame) root;
        setSize(250,300);
        setUndecorated(true);
        setLayout(new FlowLayout(1,20,15));
        setLocationRelativeTo(null);
        
        infolbl = new JLabel("Danh sách loại món ăn");
        infolbl.setPreferredSize(new Dimension(200,40));
        infolbl.setFont(new Font("Arial",Font.BOLD,18));
        model = new DefaultTableModel(header,0);
        table = new JTable(model);
        table.addMouseListener(this);
        jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(200,150));
        closebtn = new JLabel();
        ImageIcon closeicon1 = new ImageIcon(this.getClass().getResource("/Icons/closeicon3.png"));
        closebtn.setPreferredSize(new Dimension(40,35));
        closebtn.setFont(new Font("Arial",Font.PLAIN,18));
        closebtn.setIcon(closeicon1);
        closebtn.addMouseListener(this);
        
        add(infolbl);
        add(closebtn);
        add(jsp);
        
        
        loadDsloaimon();
    } 

    public void loadDsloaimon(){
        MonanBUS bus = new MonanBUS();
        if(dsloaimonan == null) bus.docDsloaimonan();
        model = new DefaultTableModel(header,0);
        table.setModel(model);
        for(LoaimonanDTO loai : dsloaimonan){
            Object[] data = {loai.getIdloai(),loai.getLoaimon()};
            model.addRow(data);
        }
    }
    
    public void tableMouseClicked(MouseEvent e){
        int answer = JOptionPane.showConfirmDialog(null,"Bạn có chắc chứ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(answer == JOptionPane.YES_OPTION){
            int i = table.getSelectedRow();
            idloai = model.getValueAt(i,0).toString();
            tenloai = model.getValueAt(i,1).toString();
            this.setVisible(false);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==closebtn){
            this.setVisible(false);
            idloai="";
            tenloai="";
        }else if(e.getSource()==table){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có chắc chứ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(answer == JOptionPane.YES_OPTION){
                int i = table.getSelectedRow();
            //model = table.getModel();
                idloai = model.getValueAt(i,0).toString();
                tenloai = model.getValueAt(i,1).toString();
                this.setVisible(false);
            }
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
        if(e.getSource()==closebtn){
            ImageIcon closeicon2 = new ImageIcon(this.getClass().getResource("/Icons/closeicon2.png"));
            closebtn.setIcon(closeicon2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==closebtn){
            ImageIcon closeicon1 = new ImageIcon(this.getClass().getResource("/Icons/closeicon1.png"));
            closebtn.setIcon(closeicon1);
        }
    }
}
