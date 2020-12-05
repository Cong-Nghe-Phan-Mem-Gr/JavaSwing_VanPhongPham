/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.MonanBUS;
import static BUS.MonanBUS.dsmonan;
import DTO.MonanDTO;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.border.*;
import static GUI.QuanlimonanGUI.idloai;
import static GUI.QuanlimonanGUI.tenmon;
import static GUI.QuanlimonanGUI.idmon;
import static GUI.QuanlimonanGUI.dongia;
import static GUI.QuanlimonanGUI.giamgia;
import static GUI.QuanlimonanGUI.sldaban;
import static GUI.QuanlimonanGUI.tenloai;



/**
 *
 * @author USER
 */
public class Addformdialog extends JDialog implements MouseListener{
    private JTable table;
    private JLabel idloailbl,idmonlbl,dongialbl,sldabanlbl,tonkholbl,confirmbtn,closebtn,infolbl,tenlbl,
            giamgialbl,extendsionbtn;
    private JTextField idloaitxt,idmontxt,dongiatxt,sldabantxt,tonkhotxt,tentxt,giamgiatxt;
    private Font f2 = new Font("Arial",Font.PLAIN,18);
    private JPanel panel;
    private OverallFrame home;
   CheckLoi cl = new CheckLoi();
    
    
    public Addformdialog(JFrame parent,boolean modal){
        super(parent,modal);
        setSize(460,500);
        setLayout(new FlowLayout(1,10,10));
        parent = (OverallFrame) home;
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);
        
        idloai="";
        panel = new JPanel();
        panel.setLayout(new FlowLayout(1,0,15));
        panel.setBounds(50,70,350,350);
        panel.setBorder(new LineBorder(Color.black,3,true));
        infolbl = new JLabel("Vui lòng điền thông tin vào");
        infolbl.setBounds(100,20,300,40);
        infolbl.setFont(new Font("Arial",Font.PLAIN,23));
        idmonlbl = new JLabel("ID món ăn");
        idmonlbl.setPreferredSize(new Dimension(160,30));
        idmontxt = new JTextField(10);
        idmontxt.setPreferredSize(new Dimension(40,30));
        idmonlbl.setFont(f2);
        idmontxt.setEditable(false);
        idmontxt.setHorizontalAlignment(JLabel.CENTER);
        idloailbl = new JLabel("ID loại");
        idloailbl.setPreferredSize(new Dimension(160,30));
        idloailbl.setFont(f2);
        extendsionbtn = new JLabel();
        extendsionbtn.setPreferredSize(new Dimension(40,30));
        ImageIcon extendsionicon1 = new ImageIcon(this.getClass().getResource("/Icons/extendsion1.png"));
        extendsionbtn.setIcon(extendsionicon1);
        extendsionbtn.addMouseListener(this);
        idloaitxt = new JTextField(6);
        idloaitxt.setPreferredSize(new Dimension(40,30));
        idloaitxt.setEditable(false);
        idloaitxt.setHorizontalAlignment(JLabel.CENTER);
        tenlbl = new JLabel("Tên món ăn");
        tenlbl.setPreferredSize(new Dimension(160,30));
        tenlbl.setFont(f2);
        tentxt = new JTextField(10);
        tentxt.setPreferredSize(new Dimension(40,30));
        tentxt.setHorizontalAlignment(JLabel.CENTER);
        dongialbl = new JLabel("Đơn giá món ăn");
        dongialbl.setPreferredSize(new Dimension(160,30));
        dongialbl.setFont(f2);
        dongiatxt = new JTextField(10);
        dongiatxt.setPreferredSize(new Dimension(40,30));
        dongiatxt.setHorizontalAlignment(JLabel.CENTER);
        tonkholbl = new JLabel("Tồn kho");
        tonkholbl.setPreferredSize(new Dimension(160,30));
        tonkholbl.setFont(f2);
        tonkhotxt = new JTextField(10);
        tonkhotxt.setPreferredSize(new Dimension(40,30));
        tonkhotxt.setEditable(false);
        tonkhotxt.setHorizontalAlignment(JLabel.CENTER);
        tonkhotxt.setText("0");
        sldabanlbl = new JLabel("S.Lượng đã bán");
        sldabanlbl.setPreferredSize(new Dimension(160,30));
        sldabanlbl.setFont(f2);
        sldabantxt = new JTextField(10);
        sldabantxt.setPreferredSize(new Dimension(40,30));
        sldabantxt.setEditable(false);
        sldabantxt.setText("0");
        sldabantxt.setHorizontalAlignment(JLabel.CENTER);
        giamgialbl = new JLabel("Có giảm giá");
        giamgialbl.setPreferredSize(new Dimension(160,30));
        giamgialbl.setFont(f2);
        giamgiatxt = new JTextField(10);
        giamgiatxt.setPreferredSize(new Dimension(40,30));
        giamgiatxt.setEditable(false);
        giamgiatxt.setText("Không");
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
        panel.add(extendsionbtn);
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
        loadIDmon();
    }
    
    public void loadIDmon(){
        MonanBUS bus = new MonanBUS();
        idmon = bus.getIDmon();
        idmontxt.setText(idmon);
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==extendsionbtn){
            Dsloaimonandialog dialog = new Dsloaimonandialog(home,true);
            dialog.setVisible(true);
            if(!dialog.isVisible()){
                /*if(!idloai.equals("")){
                    idloaitxt.setText(idloai);
                }*/
                 idloaitxt.setText(idloai);
            }
        }else if(e.getSource()==confirmbtn){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có chắc không",null,JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION){
                dongia = dongiatxt.getText();
                tenmon = tentxt.getText();
                if((tenmon.equals("")) || (dongia.equals("")) || (idloai.equals(""))){
                    JOptionPane.showMessageDialog(null,"Không được để trống");
                }
                else if(Integer.parseInt(dongia) < 1000){
                    JOptionPane.showMessageDialog(null,"Đơn giá không đúng định dạng");
                    dongiatxt.requestFocus();
                }
                else if(cl.kiemtraSophay(dongiatxt.getText()) == false){
                        JOptionPane.showMessageDialog(null,"Vui long nhap so nguyen",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                        dongiatxt.requestFocus();
                }
                        else if(cl.kiemtraSokitu(dongiatxt.getText(), 11) == false){
                        JOptionPane.showMessageDialog(null,"Gia khong duoc vuot qua 11 so",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                        dongiatxt.requestFocus();
                        }
                else{
                    MonanBUS bus = new MonanBUS();
                    //MonanDTO monan = new Monan
                    bus.addMonan(new MonanDTO(idmon,tenmon,Integer.parseInt(idloai),tenloai,Integer.parseInt(dongia),0,"1","0",0));
                    JOptionPane.showMessageDialog(null,"Thêm thành công");
                    this.setVisible(false);
                }
            }
        }else if(e.getSource()==closebtn){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có chắc không",null,JOptionPane.WARNING_MESSAGE);
            if(answer == JOptionPane.YES_OPTION){
                this.setVisible(false);
                tenmon="";
                dongia="";
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
        }else if(e.getSource()==extendsionbtn){
            ImageIcon extendsionicon2 = new ImageIcon(this.getClass().getResource("/Icons/extendsion2.png"));
            extendsionbtn.setIcon(extendsionicon2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(e.getSource()==confirmbtn){
            ImageIcon confirmicon1 = new ImageIcon(this.getClass().getResource("/Icons/Ok1.png"));
            confirmbtn.setIcon(confirmicon1);
        }else if(e.getSource()==closebtn){
            ImageIcon closeicon1 = new ImageIcon(this.getClass().getResource("/Icons/closeicon1.png"));
            closebtn.setIcon(closeicon1);
        }else if(e.getSource()==extendsionbtn){
            ImageIcon extendsionicon1 = new ImageIcon(this.getClass().getResource("/Icons/extendsion1.png"));
            extendsionbtn.setIcon(extendsionicon1);
        }
    }
}
