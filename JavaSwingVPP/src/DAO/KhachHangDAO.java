/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class KhachHangDAO {
    MyDBConnection conn = new MyDBConnection();
    public KhachHangDAO(){};
    
    public ArrayList<String> getIdKhachHang(){
        ArrayList<String> dsidpn = new ArrayList();
        try{
            String query = "select idkh from khachhang";
            ResultSet rs = conn.executeQuery(query);
            while(rs.next()){
                String idpn = rs.getString("idkh");
                dsidpn.add(idpn);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Khong doc duoc idpn");
        }
        return dsidpn;
    }
    public ArrayList docKhachHang()
            //ham lay thong in user
    {
        ArrayList nvlist = new ArrayList<KhachHang>();
        try
        {
            String query = "SELECT `idkh`, `ho`, `ten`, `email`, `sodienthoai`, `gioitinh`, `tongtiendamua` FROM `khachhang`";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                KhachHang nvdto = new KhachHang();
                nvdto.setIdKh(rs.getString(1));//ghi du lieu tu databse vao DTO
                nvdto.setHo(rs.getString(2));
                nvdto.setTen(rs.getString(3));
                nvdto.setEmail(rs.getString(4));
                nvdto.setSdt(rs.getString(5));
                nvdto.setGioitinh(rs.getString(6));               
                nvdto.setTongtiendamua(rs.getDouble(7));
                nvlist.add(nvdto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return nvlist;
    }
    
    public void themKhachHang(KhachHang nv)
    {
        try
        {
        String query = "INSERT INTO `khachhang` VALUES ("
                + "'" +nv.getIdKh()+ "',"
                + "'" +nv.getHo()+ "',"
                + "'" +nv.getTen()+ "',"
                + "'" +nv.getEmail()+ "',"
                + "'" +nv.getSdt()+ "',"
                + "'" +nv.getGioitinh()+ "',"
                + "'" +nv.getTongtiendamua()+ "');";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void suaKhachHang(KhachHang nv)
    {
        try
        {
            String query = "UPDATE `khachhang` SET "
                    +"ho="+"'"+nv.getHo()+"'"
                    +",ten="+"'"+nv.getTen()+"'"
                    +",email="+"'"+nv.getEmail()+"'"
                    +",sodienthoai="+"'"+nv.getSdt()+"'"
                    +",gioitinh="+"'"+nv.getGioitinh()+"'"
                    +" where idkh='"+nv.getIdKh()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa KhachHang");
        }
    }
}
