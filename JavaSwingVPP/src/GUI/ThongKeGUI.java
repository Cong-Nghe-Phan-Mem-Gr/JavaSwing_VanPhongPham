package GUI;

import java.awt.Color;
import static java.awt.Color.black;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ThongKeGUI extends JFrame implements ItemListener,MouseListener{
    private JPanel tongquat,topsp,chart;
    public ThongKeGUI(){
        inits();
    }
    
    public void inits(){
        setSize(945,650);
        setLayout(null);
        setBackground(new Color(0, 255, 204));
        //panel tong quat
       // tongquat = new JPanel(new FlowLayout(0,5,5));
        tongquat.setBounds(600,0,300,500);
        tongquat.setBorder(new LineBorder(black,3,true));
        
        //panel ban chay
        topsp = new JPanel(new FlowLayout(0,5,5));
        tongquat.setBounds(600,0,300,500);
        tongquat.setBorder(new LineBorder(black,3,true));
        
        //panel chart
        chart = new JPanel(new FlowLayout(0,5,5));
        tongquat.setBounds(600,0,300,500);
        tongquat.setBorder(new LineBorder(black,3,true));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
