/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


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

public class HDDetailGUI extends JFrame implements ActionListener{
    private JLabel lbl,xoabtn,inbtn,closebtn;
    private Font f = new Font("Arial",Font.BOLD,16);
    private DefaultTableModel model;
    private JScrollPane jsp;
    private String[] header = {"IDSP","Tên sản phẩm","Số lượng","Đơn giá","Thành tiền"};
    public static JTable table;
    public HDDetailGUI(){
        setSize(500,400);
        setUndecorated(true);
        setLayout(new FlowLayout(1,5,5));
        setLocationRelativeTo(null);
        
        lbl = new JLabel("HD10");
        lbl.setFont(f);
        lbl.setPreferredSize(new Dimension(300,30));
        lbl.setHorizontalAlignment(JLabel.RIGHT);
        model = new DefaultTableModel(header,0);
        table = new JTable(model);
        jsp= new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(400,250));
        xoabtn = new JLabel("Xóa hóa đơn");
        xoabtn.setFont(f);
        xoabtn.setPreferredSize(new Dimension(170,30));
        inbtn = new JLabel("In hóa đơn");
        inbtn.setFont(f);
        inbtn.setPreferredSize(new Dimension(170,30));
       
        add(lbl);
        add(jsp);
        add(xoabtn);
        add(inbtn);
    }
   
    public static void main(String[] args) {
        HDDetailGUI a = new HDDetailGUI();
        a.setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
