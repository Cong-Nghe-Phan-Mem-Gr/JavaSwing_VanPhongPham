/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.phieunhapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;

/**
 *
 * @author MY PC
 */
public class phieunhapDAO 
{
    MyDBConnection conn = new MyDBConnection();
    public static ArrayList dspn123 ;
    public phieunhapDAO() 
    {
        
    }
    
    public ArrayList<String> getIdphieunhap(){
        ArrayList<String> dsidpn = new ArrayList();
        try{
            String query = "select idpn from phieunhap";
            ResultSet rs = conn.executeQuery(query);
            while(rs.next()){
                String idpn = rs.getString("idpn");
                dsidpn.add(idpn);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Khong doc duoc idpn");
        }
        return dsidpn;
    }
    public ArrayList<phieunhapDTO> DocPhieunhap(){
        ArrayList dspn = new ArrayList<phieunhapDTO>();
        try{
            String query = "select * from phieunhap inner join chitietphieunhap on phieunhap.idpn = chitietphieunhap.idpn";
            ResultSet rs = conn.executeQuery(query);
            while (rs.next()){
                phieunhapDTO pn = new phieunhapDTO();
                pn.setIdncc(rs.getString("idncc"));
                pn.setIdpn(rs.getString("idpn"));
                pn.setIdnv(rs.getString("idnv"));
                pn.setGianhap(rs.getFloat("gianhap"));
                pn.setTrangthai(rs.getString("trangthai"));
                pn.setTongtien(rs.getFloat("tongtien"));
                pn.setSoluong(rs.getInt("soluong"));
                pn.setNgaynhap(rs.getString("ngaynhap"));
                pn.setIdmon(rs.getString("idsanpham"));
                pn.setThanhtien(rs.getFloat("thanhtien"));
                dspn.add(pn);
                System.out.println(dspn);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"khong doc duoc ds sp");
        }
        return dspn;
    }
    public ArrayList docphieunhap()
            //ham lay thong in user
    {
        ArrayList dspn = new ArrayList<phieunhapDTO>();
        try
        {
            String query = "SELECT `idpn`, `idncc`, `idnv`, `ngaynhap`, `tongtien`, `trangthai` FROM `phieunhap`";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                phieunhapDTO pndto = new phieunhapDTO();
                pndto.setIdpn(rs.getString(1));//ghi du lieu tu databse vao DTO
                pndto.setIdncc(rs.getString(2));
                pndto.setIdnv(rs.getString(3));
                pndto.setNgaynhap(rs.getString(4));
                pndto.setTongtien(rs.getFloat(5));
                pndto.setTrangthai(Integer.toString(rs.getInt(6)));
                dspn.add(pndto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dspn;
    }
    public ArrayList docphieunhap(String id)
            //ham lay thong in user
    {
        dspn123 = new ArrayList<phieunhapDTO>();
        try
        {
            String query = "SELECT `idpn`, `idncc`, `idnv`, `ngaynhap`, `tongtien`, `trangthai` FROM `phieunhap` "
                    + "where idnv='"+id+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                phieunhapDTO pndto = new phieunhapDTO();
                pndto.setIdpn(rs.getString(1));//ghi du lieu tu databse vao DTO
                pndto.setIdncc(rs.getString(2));
                pndto.setIdnv(rs.getString(3));
                pndto.setNgaynhap(rs.getString(4));
                pndto.setTongtien(rs.getFloat(5));
                pndto.setTrangthai(Integer.toString(rs.getInt(6)));
                dspn123.add(pndto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dspn123;
    }
    
    public void themphieunhap(phieunhapDTO pn)
    {
        try
        {
        String query = "INSERT INTO `phieunhap` VALUES ("
                + "'" +pn.getIdpn()+ "',"
                + "'" +pn.getIdncc()+ "',"
                + "'" +pn.getIdnv()+ "',"
                + "'" +pn.getNgaynhap()+ "',"
                + "'" +pn.getTongtien()+ "',"
                + "'" +pn.getTrangthai()+ "');";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void suaphieunhap(phieunhapDTO pn)
    {
        try
        {
            String query = "UPDATE `phieunhap` SET "
                    +"idncc="+"'"+pn.getIdncc()+"'"
                    +",idnv="+"'"+pn.getIdnv()+"'"
                    +",ngaynhap="+"'"+pn.getNgaynhap()+"'"
                    +",tongtien="+"'"+pn.getTongtien()+"'"
                    +",trangthai="+"'"+pn.getTrangthai()
                    +"' where idpn='"+pn.getIdpn()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa phiếu nhập");
        }
    }
    
    public void xoaphieunhap(String pn)
    {
        try
        {
            String query = "delete from phieunhap where idpn='"+pn+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa chương trình giảm giá");
        }
    }
    

}
