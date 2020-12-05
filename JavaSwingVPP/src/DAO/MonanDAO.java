/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author USER
 */

import DTO.LoaimonanDTO;
import DTO.MonanDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MonanDAO {
    String database = "qlns",idmon;
    ResultSet rs;
    MyDBConnection conn = new MyDBConnection();
    private ArrayList<String> dsidmon;
    
    public MonanDAO(){}
    
    public ArrayList<MonanDTO> DocDsmonan(){
        ArrayList dsmon = new ArrayList<MonanDTO>();
        try{
            String query = "Select * from sanpham inner join loaisanpham on sanpham.idloai = loaisanpham.idloai";
            rs = conn.executeQuery(query);
            while (rs.next()){
                MonanDTO monan = new MonanDTO();
                monan.idmon = rs.getString("idsanpham");
                monan.idloai = rs.getInt("idloai");
                monan.tenmon = rs.getString("tensanpham");
                monan.tonkho = rs.getInt("tonkho");
                monan.trangthai = rs.getString("trangthai");
                monan.cogiamgia = rs.getString("cogiamgia");
                monan.tenloai = rs.getString("tenloai");
                monan.soluongdaban = rs.getInt("soluongdaban");
                monan.dongia = rs.getInt("dongia");
                dsmon.add(monan);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc dsmonan");
        }
        return dsmon;
    }
    
    public ArrayList<LoaimonanDTO> DocDsloaimonan(){
        ArrayList<LoaimonanDTO> dsloai = new ArrayList();
        try{  
            String query = "select * from loaisanpham";
            rs = conn.executeQuery(query);
            while(rs.next()){
                LoaimonanDTO loai = new LoaimonanDTO();
                loai.idloai = rs.getString("idloai");
                loai.tenloai = rs.getString("tenloai");
                dsloai.add(loai);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc dsloaimonan");
        }
        return dsloai;
    }
    public void ThemMonan(MonanDTO monan){
        try{
            String query = "insert into sanpham(idsanpham,tensanpham,idloai,tonkho,soluongdaban,dongia,cogiamgia,trangthai) "
                    + "values ('"+monan.idmon+"','"+monan.tenmon+"','"+monan.idloai+"','"+monan.tonkho+"','"
                    +monan.soluongdaban+"','"+monan.dongia+"','"+monan.cogiamgia+"','"+monan.trangthai+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Khong them duoc");
        }
    }   

    public void XoaMonan(String idmon){
        try{   
            String query = "update sanpham set trangthai='0', cogiamgia='0' where idsanpham='"+idmon+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Khong xoa duoc");
        }
    }
    
    public void SuaMonan(String idmon,String tenmon,int dongia){
        try{
            String query = "update sanpham set tensanpham='"+tenmon+"',dongia='"+dongia+"' where idsanpham='"+idmon+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Khong sua duoc");
        }
    }
    
    public ArrayList<String> GetIdmon(){
        try{
            dsidmon = new ArrayList<String>();
            String query = "select idsanpham from sanpham";
            rs = conn.executeQuery(query);
            while(rs.next()){
                idmon = rs.getString("idsanpham");
                dsidmon.add(idmon);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Không lấy được idmon");
        }
        return dsidmon;
    }
    
    public void update(MonanDTO monan){
        try{
            String query = "update sanpham set soluongdaban='"+monan.getSoluongdaban()+"', tonkho='"+monan.getTonkho()+"' where idsanpham='"+monan.getIdmon()+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Thay đổi thất bại");
            System.out.println(e);
        }
    }
    public ArrayList<MonanDTO> docMonchuagiam(){
        ArrayList dsmon = new ArrayList<MonanDTO>();
        try{
            String query = "Select * from sanpham "
                    + "INNER JOIN loaisanpham ON sanpham.idloai = loaisanpham.idloai "
                    + "where trangthai = '1' and cogiamgia = '0'";
            ResultSet rs = conn.executeQuery(query);
            while (rs.next()){
                MonanDTO monan = new MonanDTO();
                monan.idmon = rs.getString("idsanpham");
                monan.loai = rs.getString("tenloai");
                monan.tenmon = rs.getString("tensanpham");
                monan.tonkho = rs.getInt("tonkho");
                monan.trangthai = rs.getString("trangthai");
                monan.dongia = rs.getInt("dongia");
                monan.cogiamgia = rs.getString("cogiamgia");
                monan.soluongdaban = rs.getInt("soluongdaban");
                dsmon.add(monan);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc dsmonan");
        }
        return dsmon;
    }
    public void suaGiamgia(MonanDTO ct)
    {
        try
        {
            String query = "UPDATE `sanpham` SET "
                    +"cogiamgia="+ct.cogiamgia
                    +" where idsanpham='"+ct.idmon+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa chương trình giảm giá");
        }
    }
    public void congTonkho(int value, String idmon)
    {
        try
        {
            String query = "UPDATE `sanpham` SET tonkho = tonkho + "+value+" WHERE idsanpham = '"+idmon+"'";
            conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi cộng tồn kho");
        }
    }
    public void truTonkho(int value, String idmon)
    {
        try
        {
            String query = "UPDATE `sanpham` SET tonkho = tonkho - "+value+" WHERE idsanpham = '"+idmon+"'";
            conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi trừ tồn kho");
        }
    }
    public void truSoluongdaban(int value, String idmon)
    {
        try
        {
            String query = "UPDATE `sanpham` SET soluongdaban = soluongdaban - "+value+" WHERE idsanpham = '"+idmon+"'";
            conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi trừ tồn kho");
        }
    }
    /*public void RemoveCart(String idmon,int soluong,int tonkho){
        try{
            String query = "update monan set soluong='"+soluong+"',tonkho='"+tonkho+"' where idmon='"+idmon+"'";
            rs = conn.executeQuery(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Thay đổi thất bại");
        }
    }*/
}
