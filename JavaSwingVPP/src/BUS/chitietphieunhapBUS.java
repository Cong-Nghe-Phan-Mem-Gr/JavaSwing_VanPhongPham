/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.chitietphieunhapDAO;
import DTO.chitietphieunhapDTO;
import DTO.phieunhapDTO;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class chitietphieunhapBUS 
{ 
    public static ArrayList<chitietphieunhapDTO> dschitiet; 

    public chitietphieunhapBUS() {
    }
    
    public void themchitiet(chitietphieunhapDTO ctpn)
    {
        docChitiet();
        chitietphieunhapDAO dao = new chitietphieunhapDAO();
        dao.themchitiet(ctpn);
        dschitiet.add(ctpn);
    }
    public void docChitiet(String ctpn)
    {
        chitietphieunhapDAO dao = new chitietphieunhapDAO();
        dao.docChitiet(ctpn);//truyen mã giam cần lấy chi tiet xuog dao
        dschitiet = new ArrayList<chitietphieunhapDTO>();

        dschitiet = chitietphieunhapDAO.dschitietDAO;//gán arrbus = arr dao
    }
    public void docChitiet()
    {
        chitietphieunhapDAO dao = new chitietphieunhapDAO();
            dschitiet = new ArrayList<chitietphieunhapDTO>();
            dschitiet = dao.docChitiet();//ghi arraylist cua DAO vao arraylist cua BUS
    }
    
    
   
    public static void main(String[] args) {
        System.out.println(dschitiet);
    }


}
