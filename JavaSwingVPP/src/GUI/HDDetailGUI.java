/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BUS.HoadonBUS;
import static BUS.HoadonBUS.dshd;
import static GUI.DsHDGUI.table;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DTO.HoadonDTO;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class HDDetailGUI extends JFrame implements MouseListener{
    private JLabel lbl,xoabtn,inbtn,closebtn;
    private Font f = new Font("Arial",Font.BOLD,16);
    private DefaultTableModel model;
    private JScrollPane jsp;
    private String[] header = {"IDSP","Tên sản phẩm","Số lượng","Đơn giá","Thành tiền"};
    public JTable table;
    public HDDetailGUI(String id){
        setSize(500,370);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        lbl = new JLabel(id);
        lbl.setFont(new Font("Arial",Font.BOLD,20));
        lbl.setBounds(150,10,100,30);
        lbl.setForeground(red);
        lbl.setHorizontalAlignment(JLabel.CENTER);
        model = new DefaultTableModel(header,0);
        table = new JTable(model);
        for(HoadonDTO hd : dshd){
            if(hd.idhd.equals(id)){
                Object[] data = {hd.idsp,hd.tensp,hd.soluong,hd.dongia,hd.thanhtien};
                model.addRow(data);
                break;
            }
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        jsp= new JScrollPane(table);
        jsp.setBounds(50,50,400,250);
        xoabtn = new JLabel("Xóa hóa đơn");
        xoabtn.setFont(f);
        xoabtn.setBounds(100,320,150,40);
        xoabtn.setForeground(Color.red);
        xoabtn.setBorder(new LineBorder(Color.red,2));
        xoabtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/trashicon1.png")));
        xoabtn.addMouseListener(this);
        inbtn = new JLabel("In hóa đơn");
        inbtn.setFont(f);
        inbtn.setBounds(300,320,150,40);
        inbtn.setForeground(Color.GREEN);
        inbtn.setBorder(new LineBorder(Color.GREEN,2));
        inbtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/printericon1.png")));
        inbtn.addMouseListener(this);
        
        closebtn = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/closeicon1.png")));
        closebtn.setBounds(465,0,35,35);
        closebtn.setFont(f);
        closebtn.setBorder(new LineBorder(red,3));
        closebtn.addMouseListener(this);
        add(lbl);
        add(jsp);
        add(xoabtn);
        add(closebtn);
        add(inbtn);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == closebtn){
            DsHDGUI a = new DsHDGUI();
            a.setVisible(true);
            this.setVisible(false);
        } if(e.getSource() == xoabtn){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Thông báo",JOptionPane.WARNING_MESSAGE);
            if(answer == JOptionPane.YES_OPTION){
                HoadonBUS bus = new HoadonBUS();
                bus.xoa(lbl.getText());
                JOptionPane.showMessageDialog(null,"Xóa thành công");
                DsHDGUI a = new DsHDGUI();
                a.setVisible(true);
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
