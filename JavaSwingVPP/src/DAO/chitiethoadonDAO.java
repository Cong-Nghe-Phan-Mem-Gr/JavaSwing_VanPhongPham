/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietGiamDTO;
import DTO.chitiethoadonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class chitiethoadonDAO 
{
     MyDBConnection conn = new MyDBConnection();
     public static ArrayList<chitiethoadonDTO> dschitietDAO;
     public static ArrayList<chitiethoadonDTO> dschitiethdDAO;
    public chitiethoadonDAO() 
    {
        
    }  
    public ArrayList docchitiet(chitiethoadonDTO cthd)
            //ham lay thong in user
    {
        dschitietDAO = new ArrayList<chitiethoadonDTO>();

        try
        {
            String query = "Select * from chitiethoadon where idhd='"+cthd.getIdhd()+"'";
//            String query1 = "SELECT * FROM `chitietgiam` INNER JOIN "
//                    + "monan ON chitietgiam.idmon = monan.idmon WHERE chitietgiam.idgiam ='"+ctg.getIdGiam()+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                chitiethoadonDTO dto = new chitiethoadonDTO();
                dto.setIdhd(rs.getString("idhd"));//ghi du lieu tu databse vao DTO
                dto.setIdmon(rs.getString("idmon"));//ghi du lieu tu databse vao DTO
                dto.setSoluong(rs.getInt("soluong"));
                dto.setDongia(rs.getFloat("dongia"));
                dto.setThanhtien(rs.getFloat("thanhtien"));
                dschitietDAO.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitietDAO;
    }
    public ArrayList docchitiet1(String cthd)
            //ham lay thong in user
    {
        dschitiethdDAO = new ArrayList<chitiethoadonDTO>();

        try
        {
            String query = "Select * from chitiethoadon where idhd='"+cthd+"'";
//            String query1 = "SELECT * FROM `chitietgiam` INNER JOIN "
//                    + "monan ON chitietgiam.idmon = monan.idmon WHERE chitietgiam.idgiam ='"+ctg.getIdGiam()+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                chitiethoadonDTO dto = new chitiethoadonDTO();
                dto.setIdhd(rs.getString("idhd"));//ghi du lieu tu databse vao DTO
                dto.setIdmon(rs.getString("idmon"));//ghi du lieu tu databse vao DTO
                dto.setSoluong(rs.getInt("soluong"));
                dto.setDongia(rs.getFloat("dongia"));
                dto.setThanhtien(rs.getFloat("thanhtien"));
                dschitiethdDAO.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitiethdDAO;
    }

    public ArrayList docChitiet()
            //ham lay thong in user
    {
        ArrayList dschitiet = new ArrayList<chitiethoadonDTO>();
        try
        {
            String query = "Select * from chitiethoadon";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                chitiethoadonDTO dto = new chitiethoadonDTO();
                dto.setIdhd(rs.getString(1));//ghi du lieu tu databse vao DTO
                dto.setIdmon(rs.getString(2));//ghi du lieu tu databse vao DTO
                dto.setSoluong(rs.getInt(3));
                dto.setDongia(rs.getInt(4));
                dto.setThanhtien(rs.getInt(5));
                dschitiet.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitiet;
    }
    
    
}
