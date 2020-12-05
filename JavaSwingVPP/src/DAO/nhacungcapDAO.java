/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.nhacungcapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
/**
 *
 * @author MY PC
 */
public class nhacungcapDAO 
{
    MyDBConnection conn = new MyDBConnection();
    public void laydulieu()
    {
    
    }
    public nhacungcapDAO() 
    {
        
    }  
    public ArrayList<String> getIdphieunhap(){
        ArrayList<String> dsidpn = new ArrayList();
        try{
            String query = "select idncc from nhacungcap";
            ResultSet rs = conn.executeQuery(query);
            while(rs.next()){
                String idpn = rs.getString("idncc");
                dsidpn.add(idpn);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Khong doc duoc idpn");
        }
        return dsidpn;
    }
    public ArrayList docnhacungcap()
            //ham lay thong in user
    {
        ArrayList dsncc = new ArrayList<nhacungcapDTO>();
        try
        {
            String query = "SELECT `idncc`, `tenncc`,`email`,`phone` FROM `nhacungcap` where trangthai = 1";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                nhacungcapDTO nccdto = new nhacungcapDTO();
                nccdto.setIdncc(rs.getString(1));//ghi du lieu tu databse vao DTO
                nccdto.setTenncc(rs.getString(2));
                nccdto.setEmail(rs.getString(3));
                nccdto.setPhone(rs.getString(4));
                dsncc.add(nccdto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dsncc;
    }
    
    
    
    public void themnhacungcap(nhacungcapDTO tncc)
    {
        try
        {
        String query = "INSERT INTO `nhacungcap` VALUES ("
                + "'" +tncc.getIdncc()+ "',"
                + "'" +tncc.getTenncc()+ "',"
                + "'" +tncc.getEmail()+ "',"
                + "'" +tncc.getPhone()+ "',"
                +"'1')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void suanhacungcap(nhacungcapDTO sncc)
    {
        try
        {
            String query = "UPDATE `nhacungcap` SET "
                    +"tenncc="+"'"+sncc.getTenncc()+"',"
                    +"email="+"'"+sncc.getEmail()+"',"
                    +"phone="+"'"+sncc.getPhone()+"'"
                    +" where idncc='"+sncc.getIdncc()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa  nhà cung cấp");
        }
    }
    
    public void xoanhacungcap(nhacungcapDTO xncc)
    {
        try
        {
            String query = "UPDATE `nhacungcap` SET "
                    +"trangthai="+"'0"
                    +"' where idncc='"+xncc.getIdncc()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi xóa nhà cung cấp giá");
        }
    }
    
    public static void main(String[] args) 
    {
        nhacungcapDAO q = new nhacungcapDAO();
        q.docnhacungcap();
    }
}
