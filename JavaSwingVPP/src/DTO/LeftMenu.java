/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;


public class LeftMenu extends JPanel implements MouseListener{
    private JLabel lbName,icon;
    private Color hover = new Color(100, 113, 140);
    private Color normal = new Color(255,51,0);
    //private Color normal = new Color(100, 113, 140);
    private boolean active ;
    private String name,img,imgActive,imgHover;
    private Rectangle rec = new Rectangle();
    public LeftMenu(String ten,Rectangle size)
    {
        name = ten;
        lbName = new JLabel(name);
        this.icon = new JLabel();
        rec = size;
        init();
    }
    public LeftMenu(String ten,Rectangle size,String img,String imgActive,String imgHover,Color hover)
    {
        name = ten;
        lbName = new JLabel(name);
        this.img = img;
        this.imgActive = imgActive;
        this.imgHover = imgHover;
        this.icon = new JLabel();
        rec = size;
        this.hover = hover;
        init();
    }
    
    public void setColorNormal(Color color)
    {
        this.normal = color;
        setBackground(normal);
        repaint();   
    }
    
    public JPanel isButton()
    {
        icon.setBounds(new Rectangle(0 , 8, 50, 30));
        normal = null;
        setBackground(normal);
//        repaint();
        return this;
    }
    public JPanel isLogout()
    {
        icon.setBounds(new Rectangle(0 , 6, 50, 34));
        normal = null;
        setBackground(normal);
//        repaint();
        return this;
    }
    public JPanel isLogin()
    {
        icon.setBounds(new Rectangle(0 , 0, 50, 46));
        normal = null;
        setBackground(normal);
//        repaint();
        return this;
    }
    public void init()
    {

        addMouseListener(this);
        Font font = new Font("Arials",Font.BOLD,15);
        setLayout(null);
        setBounds(rec);
        
        icon.setIcon(new ImageIcon("./src/img/"+img));
        //icon.setBackground(Color.white);
        icon.setBounds(new Rectangle(15 , 5, 50, 40));
        
        lbName.setFont(font);
        lbName.setForeground(Color.white);
        lbName.setBounds(new Rectangle(rec.width/4+4, rec.height/4, 140, 30));
           
        if(active)
        {
            setBackground(Color.WHITE);
        }
        else
        {
            setBackground(normal);
            setBorder(new MatteBorder(0, 2, 2, 2, Color.orange));
        } 
        add(icon);
        add(lbName);
        
    }
    
    
    public void doActive()
    {
        active = true;
        lbName.setForeground(new Color(255,51,0));
        setBackground(new Color(0,255,204));
        setBorder(new MatteBorder(0, 2, 2, 2, Color.orange));
    }
    public void noActive()
    {
        active = false;
        lbName.setForeground(Color.WHITE);
        setBackground(normal);
        setBorder(new MatteBorder(0, 2, 2, 2, Color.orange));
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!active)
        {
            setBackground(hover);
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("./src/img/icons8-hand-cursor-48.png").getImage(),
                new Point(0, 0), ""));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(!active)
        {
            setBackground(normal);
        }
    }
}
