/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietGiamDTO;
import DTO.ChuongTrinhGiamDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nam
 */
public class ChuongTrinhGiamDAO {
    MyDBConnection conn = new MyDBConnection();
    public ChuongTrinhGiamDAO() 
    {
        
    }  
    public ArrayList docGiamgia()
            //ham lay thong in user
    {
        ArrayList dsgiamgia = new ArrayList<ChuongTrinhGiamDTO>();
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
    
    public void suaChuongTrinh(ChuongTrinhGiamDTO ct)
    {
        try
        {
            String query = "UPDATE `chuongtrinhgiam` SET "
                    +"tenchuongtrinh="+"'"+ct.getTenchuongtrinh()+"'"
                    +",thoigianbatdau="+"'"+ct.getThoigianbatdau()+"'"
                    +",thoigianketthuc="+"'"+ct.getThoigianketthuc()+"'"
                    +",noidunggiam="+"'"+ct.getNoidung()+"'"
                    +" where idgiam='"+ct.getIdgiam()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa chương trình giảm giá");
        }
    }
    public void xoaChuongTrinh(ChuongTrinhGiamDTO ct)
    {
        try
        {
            String query = "DELETE FROM `chuongtrinhgiam` WHERE"
                    +" idgiam='"+ct.getIdgiam()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa chương trình giảm giá");
            //JOptionPane.showMessageDialog(null, "Mã giảm giá còn chi tiết giảm không thể xóa");
        }
    }
    
}
