/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import static javax.swing.UIManager.getString;
import DTO.nhanvienDTO;
/**
 *
 * @author MY PC
 */
public class nhanvienDAO 
{
    MyDBConnection conn = new MyDBConnection();
    public nhanvienDAO(){};
    
    public ArrayList<String> getIdphieunhap(){
        ArrayList<String> dsidpn = new ArrayList();
        try{
            String query = "select idnv from nhanvien";
            ResultSet rs = conn.executeQuery(query);
            while(rs.next()){
                String idpn = rs.getString("idnv");
                dsidpn.add(idpn);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Khong doc duoc idpn");
        }
        return dsidpn;
    }
    public ArrayList docnhanvien()
            //ham lay thong in user
    {
        ArrayList nvlist = new ArrayList<nhanvienDTO>();
        try
        {
            String query = "SELECT `idnv`, `fname`, `lname`, `phone`, `email`,`ngaysinh`, `address`, `Luong`, `trangthai` FROM `nhanvien`";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                nhanvienDTO nvdto = new nhanvienDTO();
                nvdto.setIdnv(rs.getString(1));//ghi du lieu tu databse vao DTO
                nvdto.setFname(rs.getString(2));
                nvdto.setLname(rs.getString(3));
                nvdto.setPhone(rs.getString(4));
                nvdto.setEmail(rs.getString(5));
                nvdto.setNgaysinh(rs.getString(6));
                nvdto.setAddress(rs.getString(7));               
                nvdto.setLuong(rs.getInt(8));
                nvdto.setTrangthai(Integer.toString(rs.getInt(9)));
                nvlist.add(nvdto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return nvlist;
    }
    
    public void themnhanvien(nhanvienDTO nv)
    {
        try
        {
        String query = "INSERT INTO `nhanvien` VALUES ("
                + "'" +nv.getIdnv()+ "',"
                + "'" +nv.getFname()+ "',"
                + "'" +nv.getLname()+ "',"
                + "'" +nv.getPhone()+ "',"
                + "'" +nv.getEmail()+ "',"
                + "'" +nv.getAddress()+ "',"
                + "'" +nv.getNgaysinh()+ "',"
                + "'" +nv.getLuong()+ "',"
                + "'" +nv.getTrangthai()+ "');";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void suanhanvien(nhanvienDTO nv)
    {
        try
        {
            String query = "UPDATE `nhanvien` SET "
                    +"fname="+"'"+nv.getFname()+"'"
                    +",lname="+"'"+nv.getLname()+"'"
                    +",phone="+"'"+nv.getPhone()+"'"
                    +",email="+"'"+nv.getEmail()+"'"
                    +",address="+"'"+nv.getAddress()+"'"
                    +",ngaysinh="+"'"+nv.getNgaysinh()+"'"
                    +",Luong="+"'"+nv.getLuong()+"'"
                    +",trangthai="+"'"+nv.getTrangthai()
                    +"' where idnv='"+nv.getIdnv()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa nhân viên");
        }
    }
    
    public void xoanhanvien(nhanvienDTO nv)
    {
        try
        {
            String query = "UPDATE `nhanvien` SET "
                    +"trangthai="+"'0"
                    +"' where idnv='"+nv.getIdnv()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa nhân viên");
        }
    }
    public nhanvienDTO docThongtin(String username)
    {
        nhanvienDTO nvdto = new nhanvienDTO();
        try
        {
            String query = "SELECT * FROM `user` INNER JOIN nhanvien ON user.idnv = nhanvien.idnv "
                    +"WHERE username='"+username+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                
                nvdto.setIdnv(rs.getString("idnv"));//ghi du lieu tu databse vao DTO
                nvdto.setFname(rs.getString("fname"));
                nvdto.setLname(rs.getString("lname"));
                nvdto.setPhone(rs.getString("phone"));
                nvdto.setEmail(rs.getString("email"));
                nvdto.setAddress(rs.getString("address"));               
                nvdto.setNgaysinh(rs.getString("ngaysinh"));               
                nvdto.setLuong(rs.getInt("Luong"));
            }
        } catch (Exception e)
        {
            System.out.println("Lỗi đọc thông tin");
        }
        return nvdto;
    }
}
