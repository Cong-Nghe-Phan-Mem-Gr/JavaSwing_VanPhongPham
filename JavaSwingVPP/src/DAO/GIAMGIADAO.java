/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.GIAMGIADTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class GIAMGIADAO {
    public GIAMGIADAO(){};
    public ArrayList Doc(){
        ArrayList lshd=new ArrayList<GIAMGIADTO>();
        try{
            String query="select * from giamgia";
            Connect conn=new Connect();
            ResultSet rs = conn.excuteQuery(query);
            while(rs.next()){
                GIAMGIADTO hd= new GIAMGIADTO();
                hd.setMASP(rs.getString(1));
                hd.setMAGG(rs.getString(2));
                hd.setPHANTRAM(rs.getString(3));
                hd.setNGBD(rs.getString(4));
                hd.setNGKT(rs.getString(5));                
                //hinh anh
                lshd.add(hd);
            }

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return lshd;
    
   
    
}
