/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.chitietphieunhapDTO;

import static javax.swing.UIManager.getString;
/**
 *
 * @author MY PC
 */
public class chitietphieunhapDAO 
{
    MyDBConnection conn = new MyDBConnection();
    public static ArrayList<chitietphieunhapDTO> dschitietDAO;
    public chitietphieunhapDAO() 
    {
        
    }  
    public ArrayList docChitiet(String ctpn)
            //ham lay thong in user
    {
        dschitietDAO = new ArrayList<chitietphieunhapDTO>();
        try
        {
            String query = "Select * from chitietphieunhap where idpn='"+ctpn+"'";
//            String query1 = "SELECT * FROM `chitietgiam` INNER JOIN "
//                    + "monan ON chitietgiam.idmon = monan.idmon WHERE chitietgiam.idgiam ='"+ctg.getIdGiam()+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                chitietphieunhapDTO dto = new chitietphieunhapDTO();
                dto.setIdpn(rs.getString("idpn"));//ghi du lieu tu databse vao DTO
                dto.setIdmon(rs.getString("idsanpham"));//ghi du lieu tu databse vao DTO
                dto.setSoluong(rs.getInt("soluong"));
                dto.setGianhap(rs.getFloat("gianhap"));
                dto.setThanhtien(rs.getFloat("thanhtien"));
                
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
        ArrayList dschitiet = new ArrayList<chitietphieunhapDTO>();
        try
        {
            String query = "Select * from chitietphieunhap";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                chitietphieunhapDTO dto = new chitietphieunhapDTO();
                dto.setIdpn(rs.getString(1));//ghi du lieu tu databse vao DTO
                dto.setIdmon(rs.getString(2));//ghi du lieu tu databse vao DTO
                dto.setSoluong(rs.getInt(3));
                dto.setGianhap(rs.getFloat(4));
                dto.setThanhtien(rs.getFloat(5));
                
                dschitiet.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitiet;
    }
    
    public void themchitiet(chitietphieunhapDTO ctg)
    {
        try
        {
        String query = "INSERT INTO `chitietphieunhap` VALUES ("
                + "'" +ctg.getIdpn()+ "',"
                + "'" +ctg.getIdmon()+ "',"
                + "'" +ctg.getSoluong()+ "',"
                + "'" +ctg.getGianhap()+ "',"
                + "'" +ctg.getThanhtien()+ "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
