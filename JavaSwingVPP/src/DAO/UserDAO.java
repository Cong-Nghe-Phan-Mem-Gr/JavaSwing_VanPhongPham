/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.UserDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Nam
 */
public class UserDAO {
    MyDBConnection conn = new MyDBConnection();

    public UserDAO() 
    {
        
    }  
    public ArrayList docUserInfo()
            //ham lay thong in user
    {
        ArrayList dsuser = new ArrayList<UserDTO>();
        try
        {
            String query = "SELECT * FROM `user`";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                UserDTO dto = new UserDTO();
                dto.setUsername(rs.getString("username"));//ghi du lieu tu databse vao DTO
                dto.setPass(rs.getString("pass"));
                dto.setIdnv(rs.getString("idnv"));
                dsuser.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dsuser;
    }
    
    public void themUser(UserDTO ct)
    {
        try
        {
        String query = "INSERT INTO `user` VALUES ("
                + "'" +ct.getUsername()+ "',"
                + "'" +ct.getPass()+ "',"
                + "'" +ct.getIdnv()+"');";
                
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void suaUser(UserDTO ct)
    {
        try
        {
            String query = "UPDATE `user` SET "
                    +"pass="+"'"+ct.getPass()+"'"
                    +",idnv="+"'"+ct.getIdnv()+"'"
                    +" where username='"+ct.getUsername()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa user");
        }
    }
    
    public void xoaUser(UserDTO ct)
    {
        try
        {
            String query = "DELETE FROM `user` WHERE"
                    +" username='"+ct.getUsername()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi xóa user");
            //JOptionPane.showMessageDialog(null, "Mã giảm giá còn chi tiết giảm không thể xóa");
        }
    }
    
    public void xoaUsertheonhanvien(String id)
    {
        try
        {
            String query = "DELETE FROM `user` where idnv='"+id+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi xóa user");
            //JOptionPane.showMessageDialog(null, "Mã giảm giá còn chi tiết giảm không thể xóa");
        }
    }
}

