/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.ChiTietGiamDTO;
import DTO.chuongtrinhgiamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Asus
 */
st<ChuongTrinhGiamDTO>();
        try
        {
            String query = "Select * from chuongtrinhgiam";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                ChuongTrinhGiamDTO dto = new ChuongTrinhGiamDTO();
                dto.setIdgiam(rs.getString(1));//ghi du lieu tu databse vao DTO
                dto.setTenchuongtrinh(rs.getString(2));//ghi du lieu tu databse vao DTO
                dto.setThoigianbatdau(rs.getString(3));
                dto.setThoigianketthuc(rs.getString(4));
                dto.setNoidung(rs.getString(5));
                
                dsgiamgia.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dsgiamgia;
    }
    
    public void themChuongtrinh(ChuongTrinhGiamDTO ct)
    {
        try
        {
        String query = "INSERT INTO `chuongtrinhgiam` VALUES ("
                + "'" +ct.getIdgiam()+ "',"
                + "'" +ct.getTenchuongtrinh()+ "',"
                + "'" +ct.getThoigianbatdau()+ "',"
                + "'" +ct.getThoigianketthuc()+ "',"
                + "'" +ct.getNoidung()+ "');";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
}