package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author nngia
 */
public class DetailGUI extends JFrame{
    private JLabel id1,id2,namelbl1,namelbl2,pricelbl1,pricelbl2,tonkho1,tonkho2,km1,km2;
    private Font f = new Font("Arial",Font.BOLD,16);
    public DetailGUI(String id,String name,String price,String tonkho,String km){
        inits(id,name,price,tonkho,km);
    }
    
    public void inits(String id,String name,String price,String tonkho,String km){
        setSize(300,200);
        setResizable(false);
         setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(0,5,5));
        id1 = new JLabel("Mã sản phẩm");
        id1.setFont(f);
        id1.setPreferredSize(new Dimension(150,30));
        id2 = new JLabel(name);
        id2.setFont(f);
        id2.setPreferredSize(new Dimension(150,30));
        namelbl1 = new JLabel("Tên sản phẩm");
        namelbl1.setFont(f);
        namelbl2 = new JLabel(name);
         namelbl2.setFont(f);
        namelbl2.setPreferredSize(new Dimension(150,30));
        pricelbl1 = new JLabel("Đơn giá");
         pricelbl1.setFont(f);
        pricelbl1.setPreferredSize(new Dimension(150,30));
        pricelbl2 = new JLabel(name);
         pricelbl2.setFont(f);
        pricelbl2.setPreferredSize(new Dimension(150,30));
        tonkho1 = new JLabel("Tồn kho");
         tonkho1.setFont(f);
        tonkho1.setPreferredSize(new Dimension(150,30));
        tonkho2 = new JLabel(price);
         tonkho2.setFont(f);
        tonkho2.setPreferredSize(new Dimension(150,30));
        km1 = new JLabel("Khuyến mãi");
        km1.setFont(f);
        km1.setPreferredSize(new Dimension(150,30));
        km2 = new JLabel(name);
        km2.setFont(f);
        km2.setPreferredSize(new Dimension(150,30));
        add(id1);
        add(id2);
        add(namelbl1);
        add(namelbl2);
        add(pricelbl1);
        add(pricelbl2);
        add(tonkho1);
        add(tonkho2);
        add(km1);
        add(km2);
        
    }
    public static void main(String[] args) {
        DetailGUI a = new DetailGUI("fwafwa","10000","fwafwa11","fwafwa22","fwafwa33");
        a.setVisible(true);
    }
}
