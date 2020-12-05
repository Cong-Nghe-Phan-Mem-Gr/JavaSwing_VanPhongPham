/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChuongTrinhGiamDAO;
import DTO.ChiTietGiamDTO;
import DTO.ChuongTrinhGiamDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nam
 */
public class ChuongTrinhGiamBUS {
    public static ArrayList<ChuongTrinhGiamDTO> dsgiamgia; 
    
    
    public ChuongTrinhGiamBUS()
    {
    }
    public void docGiamgia()
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
//        if(dsgiamgia == null)//neu array rong thi them moi 
//        {
           dsgiamgia = new ArrayList<ChuongTrinhGiamDTO>();
           
//            dsgiamgia = dao.docGiamgia();//ghi arraylist cua DAO vao arraylist cua BUS
//        }
//        else {
//            dsgiamgia.clear();
//            dsgiamgia = dao.docGiamgia();//ghi arraylist cua DAO vao arraylist cua BUS
//        }
        dsgiamgia = dao.docGiamgia();
    }
    public void themChuongtrinh(ChuongTrinhGiamDTO ct)
    {
//        for(ChuongTrinhGiamDTO a : dsgiamgia)
//        {
//            if(ct.getIdgiam().equals(a.getIdgiam()))
//            {
//                JOptionPane.showMessageDialog(null, "Mã giảm giá trùng");
//            }
//        }
        dsgiamgia.add(ct);// them vao arr cua bus
//        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//            String begin = sp.format(ct.getThoigianbatdau());//format date tu gui r truyen xuong dao
//            String end = sp.format(ct.getThoigianketthuc());
//            ct.setThoigianbatdau(begin);
//            ct.setThoigianketthuc(end);
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        dao.themChuongtrinh(ct);//truyền bien ct xuog lớp dao
        
    }
    
    public void suaChuongtrinh(ChuongTrinhGiamDTO ct)
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        dao.suaChuongTrinh(ct);// truyền ct vào dao để update
        for(ChuongTrinhGiamDTO a : dsgiamgia)//duyet arraylist cua bus
        {
                if (a.getIdgiam().equals(ct.getIdgiam()))//so sanh id trong array vs biến truyền từ gui
                {
                    a.setTenchuongtrinh(ct.getTenchuongtrinh());//gan' bien tu GUI vao arraylist
                    a.setThoigianbatdau(ct.getThoigianbatdau());
                    a.setThoigianketthuc(ct.getThoigianketthuc());
                    a.setNoidung(ct.getNoidung());
                    break;
                }
        }
    }
    
    public void xoaChuongtrinh(ChuongTrinhGiamDTO ct)
    {
        ChuongTrinhGiamDAO dao = new ChuongTrinhGiamDAO();
        dao.xoaChuongTrinh(ct);// truyền ct vào dao để update
        for(ChuongTrinhGiamDTO a : dsgiamgia)//duyet arraylist cua bus
        {
            if(a.getIdgiam().equals(ct.getIdgiam()))//so sanh id trong array vs biến truyền từ gui
            {               
                
                dsgiamgia.remove(a);
                break;
            }
        }
        
    }
    public static void main(String[] args) {
        ChuongTrinhGiamBUS bus = new ChuongTrinhGiamBUS();
    }
    public ArrayList<ChuongTrinhGiamDTO> timtheoMa(String ma)
    {
        docGiamgia();
        ArrayList<ChuongTrinhGiamDTO> kq = new ArrayList<ChuongTrinhGiamDTO>();
        for (ChuongTrinhGiamDTO a : dsgiamgia)
        {
            if(a.getIdgiam().indexOf(ma) >=0)
            {
                kq.add(a);
            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy");
//                break;
//            }
        }
        return kq;
    }
    public ArrayList<ChuongTrinhGiamDTO> timtheoTen(String ma)
    {
        docGiamgia();
        ArrayList<ChuongTrinhGiamDTO> kq = new ArrayList<ChuongTrinhGiamDTO>();
        for (ChuongTrinhGiamDTO a : dsgiamgia)
        {
            if(a.getTenchuongtrinh().indexOf(ma) >=0)
            {
                kq.add(a);
            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy");
//                break;
//            }
        }
        return kq;
    }
    public ArrayList<ChuongTrinhGiamDTO> timtheoBegin(String ma)
    {
        docGiamgia();
        ArrayList<ChuongTrinhGiamDTO> kq = new ArrayList<ChuongTrinhGiamDTO>();
        for (ChuongTrinhGiamDTO a : dsgiamgia)
        {
            if(a.getThoigianbatdau().indexOf(ma) >=0)
            {
                kq.add(a);
            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy");
//                break;
//            }
        }
        return kq;
    }
    public ArrayList<ChuongTrinhGiamDTO> timtheoEnd(String ma)
    {
        docGiamgia();
        ArrayList<ChuongTrinhGiamDTO> kq = new ArrayList<ChuongTrinhGiamDTO>();
        for (ChuongTrinhGiamDTO a : dsgiamgia)
        {
            if(a.getThoigianketthuc().indexOf(ma) >=0)
            {
                kq.add(a);
            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy");
//                break;
//            }
        }
        return kq;
    }
    public ArrayList<ChuongTrinhGiamDTO> timtheoAll(String ma)
    {
        docGiamgia();
        ArrayList<ChuongTrinhGiamDTO> kq = new ArrayList<ChuongTrinhGiamDTO>();
        for (ChuongTrinhGiamDTO a : dsgiamgia)
        {
            if(    a.getIdgiam().indexOf(ma) >=0
                || a.getTenchuongtrinh().indexOf(ma) >=0
                || a.getThoigianbatdau().indexOf(ma) >=0
                || a.getThoigianketthuc().indexOf(ma) >=0
               )
            {
                kq.add(a);
            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy");
//                break;
//            }
        }
        return kq;
    }
}
