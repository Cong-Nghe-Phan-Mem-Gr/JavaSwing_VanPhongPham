/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.ChuongTrinhGiamBUS.dsgiamgia;
import DAO.ChiTietGiamDAO;
import DTO.ChiTietGiamDTO;
import DTO.ChuongTrinhGiamDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class ChiTietGiamBUS {
    public static ArrayList<ChiTietGiamDTO> dschitiet; 

    public ChiTietGiamBUS() {
    }
    
    public void themChitiet(ChiTietGiamDTO ctg)
    {
        ChiTietGiamDAO dao = new ChiTietGiamDAO();
        dao.themChitiet(ctg);
        dschitiet.add(ctg);
    }
    public void docChitiet(ChiTietGiamDTO ctg)
    {
        ChiTietGiamDAO dao = new ChiTietGiamDAO();
        dao.docChitiet(ctg);//truyen mã giam cần lấy chi tiet xuog dao
        dschitiet = new ArrayList<ChiTietGiamDTO>();

        dschitiet = ChiTietGiamDAO.dschitietDAO;//gán arrbus = arr dao
    }
    public void docChitiet()
    {
        ChiTietGiamDAO dao = new ChiTietGiamDAO();
            dschitiet = new ArrayList<ChiTietGiamDTO>();
            dschitiet = dao.docChitiet();//ghi arraylist cua DAO vao arraylist cua BUS
    }
    public void deleteChitiet(ChiTietGiamDTO ctg)
    {
        ChiTietGiamDAO dao = new ChiTietGiamDAO();
        dao.deleteChitiet(ctg);
        for(ChiTietGiamDTO a : dschitiet)//duyet arraylist cua bus
        {
            if(a.getIdGiam().equals(ctg.getIdGiam()) 
                    && a.getIdMon().equals(ctg.getIdMon()))//so sanh id trong array vs biến truyền từ gui
            {                            
                dschitiet.remove(a);
                break;
            }
        }
    }
    public void deleteChitietMonan(String ctg)
    {
        docChitiet();
        ChiTietGiamDAO dao = new ChiTietGiamDAO();
        dao.deleteChitietMonan(ctg);
        for(ChiTietGiamDTO a : dschitiet)//duyet arraylist cua bus
        {
            if(a.getIdMon().equals(ctg))//so sanh id trong array vs biến truyền từ gui
            {                            
                dschitiet.remove(a);
                break;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(dschitiet);
    }
}
