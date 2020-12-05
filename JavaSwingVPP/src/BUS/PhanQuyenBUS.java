/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author chien
 */
public class PhanQuyenBUS {
    public static ArrayList<PhanQuyenDTO> dschitietquyen; 
    public PhanQuyenBUS()
    {
        
    }
    public void docChitiet(String currentUser)
    {
       
        PhanQuyenDAO dao = new PhanQuyenDAO();
        dao.docChitiet(currentUser);//truyen mã giam cần lấy chi tiet xuog dao
        dschitietquyen = new ArrayList<PhanQuyenDTO>();

        dschitietquyen = PhanQuyenDAO.dschitietquyen;//gán arrbus = arr dao
    }
    public void themPhanquyen(PhanQuyenDTO ct)
    {
        docChitiet(ct.currentUser);
        dschitietquyen.add(ct);
        PhanQuyenDAO dao = new PhanQuyenDAO();
        dao.themPhanQuyen(ct);//truyền bien ct xuog lớp dao
    }
    
    public void xoaPhanquyen(PhanQuyenDTO ct)
    {
        PhanQuyenDAO dao = new PhanQuyenDAO();
        dao.xoaPhanquyen(ct);// truyền ct vào dao để update
        for(PhanQuyenDTO a : dschitietquyen)//duyet arraylist cua bus
        {
            if(a.getCurrentUser().equals(ct.getCurrentUser()))//so sanh id trong array vs biến truyền từ gui
            {               
                dschitietquyen.remove(a);
                break;
            }
        }
        
    }
    
}
