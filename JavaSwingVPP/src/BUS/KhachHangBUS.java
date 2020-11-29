/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class KhachHangBUS {
         public static ArrayList<KhachHang> dstongnv; 
         public KhachHang nvdto;
         private ArrayList<String> dsidpn;
         public int max;
        private String idpn;
    public KhachHangBUS()
    {
    }
    public String loadIdKhachHang(){
        KhachHangDAO data = new KhachHangDAO();
        dsidpn = new ArrayList();
        dsidpn = data.getIdKhachHang();
        
        if(dsidpn.size() == 0)
        {
            idpn = "KH1";
        }
        else
        {
            max = Integer.parseInt(dsidpn.get(0).substring(2));
        for(int i = 0;i<dsidpn.size();i++){
            int idnext = Integer.parseInt(dsidpn.get(i).substring(2));
            if(idnext > max){
                max = idnext;
            }
        }
        idpn = "KH" + Integer.toString(max+1);
        }
        return idpn;
    }
    public void docKhachHang()
    {
        KhachHangDAO dao = new KhachHangDAO();
        dstongnv = new ArrayList<KhachHang>();
        dstongnv = dao.docKhachHang();      
    }
    
    public void themKhachHang(KhachHang nv)
    {

        dstongnv.add(nv);// them vao arr cua bus

        KhachHangDAO dao = new KhachHangDAO();
        dao.themKhachHang(nv);//truyền bien ct xuog lớp dao
        
    }
    
    public void suaKhachHang(KhachHang nv)
    {
        KhachHangDAO nvdao = new KhachHangDAO();
        nvdao.suaKhachHang(nv);// truyền ct vào dao để update
        for(KhachHang a : dstongnv)//duyet arraylist cua bus
        {
                if (a.getIdKh().equals(nv.getIdKh()))//so sanh id trong array vs  gui
                {
                    a.setIdKh(nv.getIdKh());//gan bien tu GUI vao arraylist
                    a.setHo(nv.getHo());
                    a.setTen(nv.getTen());
                    a.setSdt(nv.getSdt());
                    a.setEmail(nv.getEmail());
                    a.setGioitinh(nv.getGioitinh());                                    
                    break;
                }
        }
    }
    public ArrayList<KhachHang> timtheoFname(String fname)
    {
        docKhachHang();
        ArrayList<KhachHang> kq = new ArrayList<KhachHang>();
        for (KhachHang a : dstongnv)
        {
            if(a.getHo().indexOf(fname) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
    
        public ArrayList<KhachHang> timtheoLname(String lname)
    {
        docKhachHang();
        ArrayList<KhachHang> kq = new ArrayList<KhachHang>();
        for (KhachHang a : dstongnv)
        {
            if(a.getTen().indexOf(lname) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
    
    public ArrayList<KhachHang> timtheoAll(String ma)
    {
        docKhachHang();
        ArrayList<KhachHang> kq = new ArrayList<KhachHang>();
        for (KhachHang a : dstongnv)
        {
            if(    
                    a.getIdKh().indexOf(ma) >=0
                || a.getHo().indexOf(ma) >=0
                || a.getTen().indexOf(ma) >=0
               )
            {
                kq.add(a);
            }

        }
        return kq;
    }
}
