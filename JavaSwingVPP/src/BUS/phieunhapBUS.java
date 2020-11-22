/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.phieunhapDAO;
import DTO.nhacungcapDTO;
import DTO.nhanvienDTO;
import DTO.phieunhapDTO;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class phieunhapBUS 
{
         public static ArrayList<phieunhapDTO> dspn; 
         public static ArrayList<nhanvienDTO> dsnv; 
         public static ArrayList<nhacungcapDTO> dsncc; 
         public static ArrayList<phieunhapDTO> dsphieunhapxoa; 
         public static ArrayList<phieunhapDTO> dstongpn; 
         public static ArrayList<phieunhapDTO> dspn1;
         public static ArrayList<phieunhapDTO> dspn123;
         private ArrayList<String> dsidpn;
          public int max;
        private String idpn;
    public phieunhapBUS()
    {
    }
    
    public String loadIdpn(){
        phieunhapDAO data = new phieunhapDAO();
        dsidpn = new ArrayList();
        dsidpn = data.getIdphieunhap();
        
        if(dsidpn.size() == 0)
        {
            idpn = "PN1";
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
        idpn = "PN" + Integer.toString(max+1);
        }
        return idpn;
    }
    public void docphieunhap()
    {
        phieunhapDAO dao = new phieunhapDAO();

           dstongpn = new ArrayList<phieunhapDTO>();
           dspn = new ArrayList<phieunhapDTO>();
           dsphieunhapxoa = new ArrayList<phieunhapDTO>();

        dstongpn = dao.docphieunhap();
        for (phieunhapDTO a : dstongpn)//chia 2 arr trang thai 1,trang thai 0
        {
            if(a.getTrangthai().equals("1"))
            {
                dspn.add(a);//chua ma con ton tai
            }
            else if(a.getTrangthai().equals("0"))
            {
                dsphieunhapxoa.add(a);//chua ma da xoa
            }
        }
    }
    public void docphieunhap(String id)
    {
        phieunhapDAO dao = new phieunhapDAO();
        dao.docphieunhap(id);
        dspn123 = new ArrayList<phieunhapDTO>();
        dspn123 = phieunhapDAO.dspn123;

    }
    public void docPhieunhap(){
        phieunhapDAO dao = new phieunhapDAO();
        dstongpn = new ArrayList<phieunhapDTO>();
           dspn1 = new ArrayList<phieunhapDTO>();

        dstongpn = dao.DocPhieunhap();
        for (phieunhapDTO a : dstongpn)//chia 2 arr trang thai 1,trang thai 0
        {
            if(a.getTrangthai().equals("1"))
            {
                dspn1.add(a);//chua ma con ton tai
            }
        }
    }
    public void themphieunhap(phieunhapDTO pn)
    {

        dspn.add(pn);// them vao arr cua bus

        phieunhapDAO dao = new phieunhapDAO();
        dao.themphieunhap(pn);//truyền bien ct xuog lớp dao
        
    }
    
    public void suaphieunhap(phieunhapDTO pn)
    {
        phieunhapDAO pndao = new phieunhapDAO();
        pndao.suaphieunhap(pn);// truyền ct vào dao để update
        for(phieunhapDTO a : dspn)//duyet arraylist cua bus
        {
            if(a.getTrangthai().equals("1"))
            {
                if (a.getIdpn().equals(pn.getIdpn()))//so sanh id trong array vs biến truyền từ gui
                {
                    a.setIdncc(pn.getIdncc());//gan' bien tu GUI vao arraylist
                    a.setIdnv(pn.getIdnv());
                    a.setNgaynhap(pn.getNgaynhap());
                    a.setTongtien(pn.getTongtien());
                    a.setTrangthai(pn.getTrangthai());
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        phieunhapBUS bus = new phieunhapBUS();
        bus.docphieunhap();
    }
    
    public void xoaphieunhap(String pn)
    {
        phieunhapDAO dao = new phieunhapDAO();
        for(phieunhapDTO a : dspn123)//duyet arraylist cua bus
        {
            if(a.getIdpn().equals(pn))//so sanh id trong array vs biến truyền từ gui
            {               
               dspn123.remove(a);
               break;
            }
        }
        dao.xoaphieunhap(pn);// truyền ct vào dao để update
    }
    
    public ArrayList<phieunhapDTO> timtheoMa(String ma)
    {
        docphieunhap();
        ArrayList<phieunhapDTO> kq = new ArrayList<phieunhapDTO>();
        for (phieunhapDTO a : dspn)
        {
            if(a.getIdpn().indexOf(ma) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
    
    public ArrayList<phieunhapDTO> search(String strsearch,String dateStart,String dateEnd,int gia1,int gia2){
        ArrayList<phieunhapDTO> dstimkim = new ArrayList();
        for(phieunhapDTO pn : dspn1){
            if(strsearch.equals("")){
                if(dateStart.equals("")){
                    if((pn.getTongtien() >= gia1) && (pn.getTongtien() <= gia2)){
                        dstimkim.add(pn);
                    } 
                }else if(gia1==0){
                    if(((pn.getNgaynhap().compareTo(dateStart) >= 0) && (pn.getNgaynhap().compareTo(dateEnd) <= 0))){
                        dstimkim.add(pn);
                    } 
                }else {
                    if(((pn.getNgaynhap().compareTo(dateStart) >= 0) && (pn.getNgaynhap().compareTo(dateEnd) <= 0))
                        && ((pn.getTongtien() >= gia1) && (pn.getTongtien() <= gia2))){
                        dstimkim.add(pn);
                   }
                }
            }else{
                String first = strsearch.substring(0,2);
                System.out.println(first);
                if(first.equals("PN")){
                    if(pn.getIdpn().equals(strsearch)) dstimkim.add(pn);
                }else if(first.equals("NV")){
                    if(pn.getIdnv().equals(strsearch)) dstimkim.add(pn);
                }else{
                    if(pn.getIdncc().equals(strsearch)) dstimkim.add(pn);
                }
            }
        }
        return dstimkim;
    }
}
