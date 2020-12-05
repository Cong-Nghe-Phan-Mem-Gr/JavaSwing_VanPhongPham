/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Nam
 */
public class ChangeMainInFo {
    OverallFrame f = new OverallFrame();
    
    public void changeMainInfo(int i) //Đổi Phần hiển thị khi bấm btn trên menu
    {   
        switch(i)
        {
            case 1: //  Quan ly mon an             
                f.content.removeAll();
                JPanel p1=new JPanel();
                p1.setSize(945,650);
                p1.setBackground(Color.CYAN);
                
                f.content.add(p1);
                f.content.repaint();
                //content.revalidate();
                break;
            case 2: // quan ly giam gia
                
                f.content.removeAll();
                //JPanel p2 = giamgia.new QuanLyGiamGia();
                //content.add();
                
                f.content.repaint();
                //content.revalidate();
                break;

            case 3: // quanly hoa don
                f.content.removeAll();
                JPanel p3=new JPanel();
                p3.setSize(500, 500);
                p3.setBackground(Color.blue);
                f.content.add(p3);
                f.content.repaint();
                //content.revalidate();
                break;
                //content.revalidate();
            case 4: // quan ly nhân viên
                f.content.removeAll();
                JPanel p4=new JPanel();
                p4.setSize(500, 500);
                p4.setBackground(Color.red);
                f.content.add(p4);
                f.content.repaint();
                //content.revalidate();
            break;
            case 5: //quanly user
                f.content.removeAll();
                JPanel p5=new JPanel();
                p5.setSize(500, 500);
                p5.setBackground(Color.yellow);
                f.content.add(p5);
                f.content.repaint();
                //content.revalidate();
            break;
            case 6: //quanly phieu nhap
                f.content.removeAll();
                JPanel p6=new JPanel();
                p6.setSize(500, 500);
                p6.setBackground(Color.black);
                f.content.add(p6);
                f.content.repaint();
                //content.revalidate();
            break;
            case 7: //thống kê
                f.content.removeAll();
                JPanel p7=new ThongKeGUI();
                p7.setSize(500, 500);
                p7.setBackground(Color.white);
                f.content.add(p7);
                f.content.repaint();
                //content.revalidate();
            break;
            case 8: //bán hàng
                f.content.removeAll();
                JPanel p8 = new BanhangGUI();
                p8.setSize(500, 500);
                p8.setBackground(Color.pink);
                f.content.add(p8);
                f.content.repaint();
                //content.revalidate();
            break;
            case 9: //nhập hàng
                f.content.removeAll();
                JPanel p9 = new JPanel();
                p9.setSize(500, 500);
                p9.setBackground(Color.black);
                f.content.add(p9);
                f.content.repaint();
                //content.revalidate();
            break;
               
            default:
            break;
        }       
    }
}
