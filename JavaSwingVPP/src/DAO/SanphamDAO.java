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

//import DTO.LoaimonanDTO;
import DTO.SanphamDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.HashSet;


public class SanphamDAO {
    String database = "qlns",idmon;
    ResultSet rs;
    MyDBConnection conn = new MyDBConnection();
    private ArrayList<String> dsidmon;
    private HashSet<String> dsloai;
    
    public SanphamDAO(){}
    
    public ArrayList<SanphamDTO> DocDsspSelling(){
        ArrayList dssp = new ArrayList<SanphamDTO>();
        HashSet dsloai = new HashSet<String>();
        try{
            String query = "Select * from sanpham inner join loaisanpham on sanpham.idloai = loaisanpham.idloai join thamso where sanpham.trangthai = 1";
            rs = conn.executeQuery(query);
            while (rs.next()){
                SanphamDTO monan = new SanphamDTO();
                monan.idsp = rs.getString("idsanpham");
                monan.idloai = rs.getInt("idloai");
                monan.tensp = rs.getString("tensanpham");
                monan.tonkho = rs.getInt("tonkho");
                monan.trangthai = rs.getString("trangthai");
                monan.cogiamgia = rs.getString("cogiamgia");
                monan.tenloai = rs.getString("tenloai");
                monan.soluongdaban = rs.getInt("soluongdaban");
                monan.dongia = rs.getInt("dongia")+rs.getInt("dongia")*rs.getInt("lai_xuat")/100;
                dssp.add(monan);
                dsloai.add(rs.getString("tenloai"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc dsmonan");
        }
        return dssp;
    }
    
    public ArrayList<SanphamDTO> DocDssp(){
        ArrayList dssp = new ArrayList<SanphamDTO>();
        try{
            String query = "Select * from sanpham inner join loaisanpham on sanpham.idloai = loaisanpham.idloai join thamso where sanpham.trangthai = 1";
            rs = conn.executeQuery(query);
            while (rs.next()){
                SanphamDTO monan = new SanphamDTO();
                monan.idsp = rs.getString("idsanpham");
                monan.idloai = rs.getInt("idloai");
                monan.tensp = rs.getString("tensanpham");
                monan.tonkho = rs.getInt("tonkho");
                monan.trangthai = rs.getString("trangthai");
                monan.cogiamgia = rs.getString("cogiamgia");
                monan.tenloai = rs.getString("tenloai");
                monan.soluongdaban = rs.getInt("soluongdaban");
                monan.dongia = rs.getInt("dongia");
                dssp.add(monan);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc dsmonan");
        }
        return dssp;
    }
    public ArrayList<String> Docloai(){
        ArrayList<String> dsloai = new ArrayList();
        try{  
            String query = "select * from loaisanpham";
            rs = conn.executeQuery(query);
            while(rs.next()){
                dsloai.add(rs.getString("tenloai"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc dsloai");
        }
        return dsloai;
    }
   /* public ArrayList<LoaimonanDTO> DocDsloaimonan(){
        ArrayList<LoaimonanDTO> dsloai = new ArrayList();
        try{  
            String query = "select * from loaimonan";
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
            String query = "insert into monan(idmon,tenmon,idloai,tonkho,soluongdaban,dongia,cogiamgia,trangthai) "
                    + "values ('"+monan.idmon+"','"+monan.tenmon+"','"+monan.idloai+"','"+monan.tonkho+"','"
                    +monan.soluongdaban+"','"+monan.dongia+"','"+monan.cogiamgia+"','"+monan.trangthai+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Khong them duoc");
        }
    }   */

    public void XoaMonan(String idmon){
        try{   
            String query = "update monan set trangthai='0', cogiamgia='0' where idmon='"+idmon+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Khong xoa duoc");
        }
    }
    
    public void SuaMonan(String idmon,String tenmon,int dongia){
        try{
            String query = "update monan set tenmon='"+tenmon+"',dongia='"+dongia+"' where idmon='"+idmon+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Khong sua duoc");
        }
    }
    
    public ArrayList<String> GetIdmon(){
        try{
            dsidmon = new ArrayList<String>();
            String query = "select idmon from monan";
            rs = conn.executeQuery(query);
            while(rs.next()){
                idmon = rs.getString("idmon");
                dsidmon.add(idmon);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Không lấy được idmon");
        }
        return dsidmon;
    }
    
    public void update(SanphamDTO sp){
        try{
            String query = "update sanpham set soluongdaban='"+sp.getSoluongdaban()+"', tonkho='"+sp.getTonkho()+"' where idsanpham='"+sp.getIdsp()+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Thay đổi thất bại");
            System.out.println(e);
        }
    }
    
    public ArrayList<SanphamDTO> docMonchuagiam(){
        ArrayList dsmon = new ArrayList<SanphamDTO>();
        try{
            String query = "Select * from sanpham "
                    + "INNER JOIN loaisanpham ON monan.idloai = loaimonan.idloai "
                    + "where trangthai = '1' and cogiamgia = '0'";
            ResultSet rs = conn.executeQuery(query);
            while (rs.next()){
                SanphamDTO monan = new SanphamDTO();
                monan.idsp = rs.getString("idsanpham");
                monan.loai = rs.getString("tenloai");
                monan.tensp = rs.getString("tensanpham");
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
    public void suaGiamgia(SanphamDTO ct)
    {
        try
        {
            String query = "UPDATE `monan` SET "
                    +"cogiamgia="+ct.cogiamgia
                    +" where idmon='"+ct.idsp+"'";
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
            String query = "UPDATE `monan` SET tonkho = tonkho + "+value+" WHERE idmon = '"+idmon+"'";
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
            String query = "UPDATE `monan` SET tonkho = tonkho - "+value+" WHERE idmon = '"+idmon+"'";
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
            String query = "UPDATE `monan` SET soluongdaban = soluongdaban - "+value+" WHERE idmon = '"+idmon+"'";
            conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi trừ tồn kho");
        }
    }
    
    public void RemoveCart(String idmon,int soluong,int tonkho){
        try{
            String query = "update monan set soluong='"+soluong+"',tonkho='"+tonkho+"' where idmon='"+idmon+"'";
            rs = conn.executeQuery(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Thay đổi thất bại");
        }
    }
}
