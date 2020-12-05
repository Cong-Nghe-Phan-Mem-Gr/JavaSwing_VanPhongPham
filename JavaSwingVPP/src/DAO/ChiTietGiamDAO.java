/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietGiamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class ChiTietGiamDAO {
    MyDBConnection conn = new MyDBConnection();
    public static ArrayList<ChiTietGiamDTO> dschitietDAO;
    public ChiTietGiamDAO() 
    {
        
    }  
    public ArrayList docChitiet(ChiTietGiamDTO ctg)
            //ham lay thong in user
    {
        dschitietDAO = new ArrayList<ChiTietGiamDTO>();
        try
        {
            String query = "Select * from chitietgiam where idgiam='"+ctg.getIdGiam()+"'";
//            String query1 = "SELECT * FROM `chitietgiam` INNER JOIN "
//                    + "monan ON chitietgiam.idmon = monan.idmon WHERE chitietgiam.idgiam ='"+ctg.getIdGiam()+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                ChiTietGiamDTO dto = new ChiTietGiamDTO();
                dto.setIdMon(rs.getString("idmon"));//ghi du lieu tu databse vao DTO
                dto.setIdGiam(rs.getString("idgiam"));//ghi du lieu tu databse vao DTO
                dto.setTileGiam(rs.getString("giam"));
                
                
                dschitietDAO.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitietDAO;
    }
    public ArrayList docChitiet()
            //ham lay thong in user
    {
        ArrayList dschitiet = new ArrayList<ChiTietGiamDTO>();
        try
        {
            String query = "Select * from chitietgiam";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                ChiTietGiamDTO dto = new ChiTietGiamDTO();
                dto.setIdMon(rs.getString(1));//ghi du lieu tu databse vao DTO
                dto.setIdGiam(rs.getString(2));//ghi du lieu tu databse vao DTO
                dto.setTileGiam(rs.getString(3));
                
                
                dschitiet.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitiet;
    }
    
    public void themChitiet(ChiTietGiamDTO ctg)
    {
        try
        {
        String query = "INSERT INTO `chitietgiam` VALUES ("
                + "'" +ctg.getIdMon()+ "',"
                + "'" +ctg.getIdGiam()+ "',"
                + "'" +ctg.getTileGiam()+ "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void deleteChitiet(ChiTietGiamDTO ctg)
    {
        try
        {
            String query = "DELETE FROM `chitietgiam` WHERE idmon = '"+ctg.getIdMon()+"'"
                            +"AND idgiam ='"+ctg.getIdGiam()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Sai xoa chi tiet ở database");
        }
    }
    public void deleteChitietMonan(String ctg)
    {
        try
        {
            String query = "DELETE FROM `chitietgiam` WHERE idmon = '"+ctg+"'";
                            
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Sai xoa chi tiet ở database");
        }
    }
}
