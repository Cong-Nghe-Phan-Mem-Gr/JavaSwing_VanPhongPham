/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.MonanBUS;
import java.awt.*;
import java.awt.Color.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.*;
import static GUI.QuanlimonanGUI.idloai;
import static GUI.QuanlimonanGUI.tenmon;
import static GUI.QuanlimonanGUI.idmon;
import static GUI.QuanlimonanGUI.dongia;
import static GUI.QuanlimonanGUI.giamgia;
import static GUI.QuanlimonanGUI.sldaban;
import static GUI.QuanlimonanGUI.tonkho;


/**
 *
 * @author USER
 */
public class Editformdialog extends JDialog implements MouseListener{
    OverallFrame root;
    private JLabel idloailbl,idmonlbl,dongialbl,sldabanlbl,tonkholbl,confirmbtn,closebtn,infolbl,tenlbl,
            giamgialbl;
    private JTextField idloaitxt,idmontxt,dongiatxt,sldabantxt,tonkhotxt,tentxt,giamgiatxt;
    //public static String tenmon="",dongia="";
    private Font f2 = new Font("Arial",Font.PLAIN,18);
    private JPanel panel;
    CheckLoi cl = new CheckLoi();
    public Editformdialog(JFrame parrent,boolean modal){
        super(parrent,modal);
        setResizable(false);
        setSize(450,500);
        parrent = (OverallFrame)root;
        setLocationRelativeTo(null);
        setUndecorated(true);
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(null);
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout(1,0,15));
        panel.setBounds(50,70,350,350);
        panel.setBorder(new LineBorder(Color.black,3,true));
        infolbl = new JLabel("Vui lòng điền thông tin vào");
        infolbl.setBounds(100,20,250,40);
        infolbl.setFont(new Font("Arial",Font.PLAIN,23));
        idmonlbl = new JLabel("ID món ăn");
        idmonlbl.setPreferredSize(new Dimension(180,30));
        idmontxt = new JTextField(10);
        idmontxt.setPreferredSize(new Dimension(50,30));
        idmonlbl.setFont(f2);
        idmontxt.setEditable(false);
        idmontxt.setText(idmon);
        idmontxt.setHorizontalAlignment(JLabel.CENTER);
        idloailbl = new JLabel("ID loại");
        idloailbl.setPreferredSize(new Dimension(180,30));
        idloailbl.setFont(f2);
        idloaitxt = new JTextField(10);
        idloaitxt.setPreferredSize(new Dimension(50,30));
        idloaitxt.setEditable(false);
        idloaitxt.setText(idloai);
        idloaitxt.setHorizontalAlignment(JLabel.CENTER);
        tenlbl = new JLabel("Tên món ăn");
        tenlbl.setPreferredSize(new Dimension(180,30));
        tenlbl.setFont(f2);
        tentxt = new JTextField(10);
        tentxt.setPreferredSize(new Dimension(50,30));
        tentxt.setText(tenmon);
        tentxt.setHorizontalAlignment(JLabel.CENTER);
        dongialbl = new JLabel("Đơn giá món ăn");
        dongialbl.setPreferredSize(new Dimension(180,30));
        dongialbl.setFont(f2);
        dongiatxt = new JTextField(10);
        dongiatxt.setPreferredSize(new Dimension(50,30));
        dongiatxt.setText(dongia);
        dongiatxt.setHorizontalAlignment(JLabel.CENTER);
        tonkholbl = new JLabel("Tồn kho");
        tonkholbl.setPreferredSize(new Dimension(180,30));
        tonkholbl.setFont(f2);
        tonkhotxt = new JTextField(10);
        tonkhotxt.setPreferredSize(new Dimension(50,30));
        tonkhotxt.setEditable(false);
        tonkhotxt.setText(tonkho);
        tonkhotxt.setHorizontalAlignment(JLabel.CENTER);
        sldabanlbl = new JLabel("S.Lượng đã bán");
        sldabanlbl.setPreferredSize(new Dimension(180,30));
        sldabanlbl.setFont(f2);
        sldabantxt = new JTextField(10);
        sldabantxt.setPreferredSize(new Dimension(50,30));
        sldabantxt.setEditable(false);
        sldabantxt.setText(sldaban);
        sldabantxt.setHorizontalAlignment(JLabel.CENTER);
        giamgialbl = new JLabel("Có giảm giá");
        giamgialbl.setPreferredSize(new Dimension(180,30));
        giamgialbl.setFont(f2);
        giamgiatxt = new JTextField(10);
        giamgiatxt.setPreferredSize(new Dimension(50,30));
        giamgiatxt.setEditable(false);
        giamgiatxt.setText(giamgia);
        giamgiatxt.setHorizontalAlignment(JLabel.CENTER);
        
        confirmbtn = new JLabel("Xác nhận");
        ImageIcon confirmicon = new ImageIcon(this.getClass().getResource("/Icons/Ok1.png"));
        confirmbtn.setFont(f2);
        confirmbtn.setIcon(confirmicon);
        confirmbtn.setBounds(100,430,150,40);
        confirmbtn.addMouseListener(this);
        closebtn = new JLabel("Đóng");
        ImageIcon closeicon = new ImageIcon(this.getClass().getResource("/Icons/closeicon1.png"));
        closebtn.setFont(f2);
        closebtn.setIcon(closeicon);
        closebtn.setBounds(250,430,150,40);
        closebtn.addMouseListener(this);
        
        
        panel.add(idmonlbl);
        panel.add(idmontxt);
        panel.add(idloailbl);
        panel.add(idloaitxt);
        panel.add(tenlbl);
        panel.add(tentxt);
        panel.add(dongialbl);
        panel.add(dongiatxt);
        panel.add(tonkholbl);
        panel.add(tonkhotxt);
        panel.add(sldabanlbl);
        panel.add(sldabantxt);
        panel.add(giamgialbl);
        panel.add(giamgiatxt);
        panel.add(confirmbtn);
        panel.add(closebtn);
        
        add(confirmbtn);
        add(closebtn);
        add(infolbl);
        add(panel);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==confirmbtn){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có chắc không",null,JOptionPane.WARNING_MESSAGE);
            if(answer == JOptionPane.YES_OPTION){
                tenmon = tentxt.getText();
                dongia = dongiatxt.getText();
                if(tenmon.equals("") || (dongia.equals(""))){
                    JOptionPane.showMessageDialog(null,"Không được để trống");
                }else if(cl.kiemtraSophay(dongiatxt.getText()) == false){
                        JOptionPane.showMessageDialog(null,"Vui long nhap so nguyen",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }
                        else if(cl.kiemtraSokitu(dongiatxt.getText(), 11) == false){
                        JOptionPane.showMessageDialog(null,"Gia khong duoc vuot qua 11 so",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }else{
                    MonanBUS bus = new MonanBUS();
                    bus.editMonan(idmon, tenmon,Integer.parseInt(dongia));
                    JOptionPane.showMessageDialog(null,"Sửa thành công");
                    this.setVisible(false);
                }
            } 
        }else if(e.getSource()==closebtn){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có chắc không",null,JOptionPane.WARNING_MESSAGE);
            if(answer == JOptionPane.YES_OPTION){
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
        if(e.getSource()==confirmbtn){
            ImageIcon confirmicon2 = new ImageIcon(this.getClass().getResource("/Icons/Ok2.png"));
            confirmbtn.setIcon(confirmicon2);
        }else if(e.getSource()==closebtn){
            ImageIcon closeicon2 = new ImageIcon(this.getClass().getResource("/Icons/closeicon2.png"));
            closebtn.setIcon(closeicon2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==confirmbtn){
            ImageIcon confirmicon1 = new ImageIcon(this.getClass().getResource("/Icons/Ok1.png"));
            confirmbtn.setIcon(confirmicon1);
        }else if(e.getSource()==closebtn){
            ImageIcon closeicon1 = new ImageIcon(this.getClass().getResource("/Icons/closeicon1.png"));
            closebtn.setIcon(closeicon1);
        }
    }
}
