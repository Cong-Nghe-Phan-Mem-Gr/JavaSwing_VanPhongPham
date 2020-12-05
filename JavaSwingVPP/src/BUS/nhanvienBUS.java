/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.nhanvienDAO;
import DTO.nhanvienDTO;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class nhanvienBUS 
{
    public static ArrayList<nhanvienDTO> dsnv; 
         public static ArrayList<nhanvienDTO> dsnhanvienxoa; 
         public static ArrayList<nhanvienDTO> dstongnv; 
         public nhanvienDTO nvdto;
         private ArrayList<String> dsidpn;
         public int max;
        private String idpn;
    public nhanvienBUS()
    {
    }
    public String loadIdpn(){
        nhanvienDAO data = new nhanvienDAO();
        dsidpn = new ArrayList();
        dsidpn = data.getIdphieunhap();
        
        if(dsidpn.size() == 0)
        {
            idpn = "NV1";
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
        idpn = "NV" + Integer.toString(max+1);
        }
        return idpn;
    }
    public void docnhanvien()
    {
        nhanvienDAO dao = new nhanvienDAO();

           dstongnv = new ArrayList<nhanvienDTO>();
           dsnv = new ArrayList<nhanvienDTO>();
           dsnhanvienxoa = new ArrayList<nhanvienDTO>();

        dstongnv = dao.docnhanvien();
        for (nhanvienDTO a : dstongnv)//chia 2 arr trang thai 1,trang thai 0
        {
            if(a.getTrangthai().equals("1"))
            {
                dsnv.add(a);//chua ma con ton tai
            }
            else if(a.getTrangthai().equals("0"))
            {
                dsnhanvienxoa.add(a);//chua ma da xoa
            }
        }
    }
    
    public void themnhanvien(nhanvienDTO nv)
    {

        dsnv.add(nv);// them vao arr cua bus

        nhanvienDAO dao = new nhanvienDAO();
        dao.themnhanvien(nv);//truyền bien ct xuog lớp dao
        
    }
    
    public void suanhanvien(nhanvienDTO nv)
    {
        nhanvienDAO nvdao = new nhanvienDAO();
        nvdao.suanhanvien(nv);// truyền ct vào dao để update
        for(nhanvienDTO a : dsnv)//duyet arraylist cua bus
        {
            if(a.getTrangthai().equals("1"))
            {
                if (a.getIdnv().equals(nv.getIdnv()))//so sanh id trong array vs  gui
                {
                    a.setIdnv(nv.getIdnv());//gan bien tu GUI vao arraylist
                    a.setFname(nv.getFname());
                    a.setLname(nv.getLname());
                    a.setPhone(nv.getPhone());
                    a.setEmail(nv.getEmail());
                    a.setAddress(nv.getAddress());                                    
                    a.setNgaysinh(nv.getNgaysinh());                                    
                    a.setLuong(nv.getLuong());
                    break;
                }
            }
        }
    }
    
    
    public void xoanhanvien(nhanvienDTO nv)
    {
        nhanvienDAO nvdao = new nhanvienDAO();
        for(nhanvienDTO a : dsnv)//duyet arraylist cua bus
        {
            if(a.getIdnv().equals(nv.getIdnv()))//so sanh id trong array vs biến truyền từ gui
            {               
                a.setTrangthai("0");
                
                break;
            }
        }
        nvdao.xoanhanvien(nv);// truyền ct vào dao để update
    }
    public static void main(String[] args) {
        nhanvienBUS bus = new nhanvienBUS();
        bus.docnhanvien();
    }
    public ArrayList<nhanvienDTO> timtheoMa(String ma)
    {
        docnhanvien();
        ArrayList<nhanvienDTO> kq = new ArrayList<nhanvienDTO>();
        for (nhanvienDTO a : dsnv)
        {
            if(a.getIdnv().indexOf(ma) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
    
    public ArrayList<nhanvienDTO> timtheoFname(String fname)
    {
        docnhanvien();
        ArrayList<nhanvienDTO> kq = new ArrayList<nhanvienDTO>();
        for (nhanvienDTO a : dsnv)
        {
            if(a.getFname().indexOf(fname) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
    
        public ArrayList<nhanvienDTO> timtheoLname(String lname)
    {
        docnhanvien();
        ArrayList<nhanvienDTO> kq = new ArrayList<nhanvienDTO>();
        for (nhanvienDTO a : dsnv)
        {
            if(a.getLname().indexOf(lname) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
    
    public ArrayList<nhanvienDTO> timtheoAll(String ma)
    {
        docnhanvien();
        ArrayList<nhanvienDTO> kq = new ArrayList<nhanvienDTO>();
        for (nhanvienDTO a : dsnv)
        {
            if(    
                    a.getIdnv().indexOf(ma) >=0
                || a.getFname().indexOf(ma) >=0
                || a.getLname().indexOf(ma) >=0
               )
            {
                kq.add(a);
            }

        }
        return kq;
    }
    public void docThongtin(String username)
    {
        nhanvienDAO dao = new nhanvienDAO();
        dao.docThongtin(username);
        
        nvdto = dao.docThongtin(username);
    }
}
