/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Nam
 */
public class NewClass {
    public static void them(){
//        File f1 = new File("C:\\Users\\Nam\\Desktop\\anh\\khachhang.png");
//        File f2 = new File("C:\\Users\\Nam\\Desktop\\anh\\New folder\\khachhang1.png");
//
//        f1.renameTo(f2);
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                String chinhViethoa = file.getName().split("\\.")[1].toLowerCase();//chỉnh lại kieu ko viet hoa
                if(!chinhViethoa.equals("png") 
                        && !chinhViethoa.equals("jpg"))//check dinh dang file
                {
                    System.out.println("Đây không phải là ảnh");
                } 
                else {
                System.out.println(file);
                System.out.println(file.getName());
//                File rm = new File("C:\\Users\\Nam\\Desktop\\anh\\New folder\\a.png");
//                file.renameTo(rm);
                }
            } catch(Exception e)
            {}
        }
//        ImageIcon icon = new ImageIcon(UrlToPngFile);
//        Image scaleImage = icon.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT);
    }
    public static void main(String[] args) {
        them();
    }
}
