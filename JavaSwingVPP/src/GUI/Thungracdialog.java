/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import static BUS.MonanBUS.dsmonan;
import DTO.MonanDTO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Thungracdialog extends JFrame implements MouseListener{
    private QuanlimonanGUI home;
    private JTable table;
    private JLabel infolbl,closebtn;
    private DefaultTableModel model;
    private JScrollPane jsp;
    private String[] header = {"ID món","ID loại","Tên món ăn","Đơn giá"};
    
    public Thungracdialog(){
        setSize(400,250);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        infolbl = new JLabel("Danh sách món ăn đã xóa");
        infolbl.setBounds(80,30,250,35);
        infolbl.setFont(new Font("Arial",Font.BOLD,18));
        model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int col,int row){
                return false;
            }
        };
        table = new JTable(model);
        for(MonanDTO monan : dsmonan){
            if(monan.trangthai.equals("0")){
                Object[] data = {monan.getIdmon(),monan.getIdloai(),monan.getTenmon(),monan.getDongia()};
                model.addRow(data);
            }
        }
        jsp = new JScrollPane(table);
        jsp.setBounds(50,70,300,150);
        closebtn = new JLabel();
        ImageIcon closeicon1 = new ImageIcon(this.getClass().getResource("/Icons/closeicon3.png"));
        closebtn.setBounds(370,0,35,35);
        closebtn.setFont(new Font("Arial",Font.PLAIN,18));
        closebtn.setIcon(closeicon1);
        closebtn.addMouseListener(this);
        
        add(infolbl);
        add(closebtn);
        add(jsp);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==closebtn){
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
        if(e.getSource()== closebtn){
            ImageIcon closeicon2 = new ImageIcon(this.getClass().getResource("/Icons/closeicon4.png"));
            closebtn.setIcon(closeicon2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()== closebtn){
            ImageIcon closeicon1 = new ImageIcon(this.getClass().getResource("/Icons/closeicon3.png"));
            closebtn.setIcon(closeicon1);   
        }
    }
}
