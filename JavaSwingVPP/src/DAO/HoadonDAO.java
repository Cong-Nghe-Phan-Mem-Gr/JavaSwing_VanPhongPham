/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoadonDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HoadonDAO {
    String database = "qlns";
    String idhd;
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
    public static ArrayList<HoadonDTO> dshd;
    public static ArrayList<HoadonDTO> dshd2;
    public HoadonDAO(){};
    
    public int getIdhd(){
        int count=0;
        try{
            String query = "select idhd from hoadon";
            rs = conn.executeQuery(query);
            while(rs.next()){
                count++;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc idhd");
        }
        System.out.println(count);
        return count;
    }
    
    public ArrayList dochoadon(){
       ArrayList<HoadonDTO> dshoadon = new ArrayList();
        try{
            String query = "select * from hoadon inner join chitiethoadon on hoadon.idhd = chitiethoadon.idhd inner join sanpham on chitiethoadon.idsanpham = sanpham.idsanpham where hoadon.trangthai='1'";
            rs = conn.executeQuery(query);
            while(rs.next()){
                HoadonDTO hoadon = new HoadonDTO(rs.getString("idhd"),rs.getString("idkh"),rs.getString("idnv"),
                            rs.getString("idsanpham"),rs.getString("tensanpham"),rs.getInt("dongia"),rs.getInt("soluong"),rs.getInt("thanhtien"),
                            rs.getInt("tongtien"),rs.getString("ngaylap"),rs.getInt("trangthai"));
                dshoadon.add(hoadon);
            } 
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null,"Không thể đọc được dshoadon");
            System.out.println(e);
        }
        return dshoadon;
    }
    public ArrayList<HoadonDTO> DocDshoadon(String id){
        ArrayList<HoadonDTO> dshoadon = new ArrayList();
        try{
            String query = "select * from hoadon inner join chitiethoadon on hoadon.idhd = chitiethoadon.idhd inner join sanpham on chitiethoadon.idsanpham = sanpham.idsanpham where idnv='"+id+"'";
            rs = conn.executeQuery(query);
            while(rs.next()){
                HoadonDTO hoadon = new HoadonDTO(rs.getString("idhd"),rs.getString("idkh"),rs.getString("idnv"),
                            rs.getString("idsanpham"),rs.getString("tensanpham"),rs.getInt("dongia"),rs.getInt("soluong"),rs.getInt("thanhtien"),
                            rs.getInt("tongtien"),rs.getString("ngaylap"),rs.getInt("trangthai"));
                dshoadon.add(hoadon);
            } 
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null,"Không thể đọc được dshoadon");
            System.out.println(e);
        }
        return dshoadon;
    }
    public void ThemHoadon(String idhd,String idkh,String idnv,String ngaylap,int tongtien){
        
        try{
            String query = "insert into hoadon(idhd,idkh,idnv,ngaylap,tongtien,trangthai) values ('"
                        +idhd+"','"+idkh+"','"+idnv+"','"+ngaylap+"','"+tongtien+"','"+1+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Không thêm được hóa đơn");
        }
    }
    
    public void ThemChitietHoadon(String idhd,String idsp,int sl,int dongia,int thanhtien){ 
        try{
            String query = "insert into chitiethoadon(idhd,idsanpham,soluong,dongia,thanhtien) values ('"
                    +idhd+"','"+idsp+"','"+sl+"','"+dongia+"','"+thanhtien+"')";
            MyDBConnection a = new MyDBConnection();
            a.executeUpdate(query); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Không thêm được chi tiết hóa đơn");
        }
        
    }
    
    public void Xoa(String id){
        try{   
            String query = "update hoadon set trangthai='0' where idhd='"+id+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Khong xoa duoc");
        }
    }
}
