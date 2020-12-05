/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.MonanDAO;
import DTO.LoaimonanDTO;
import DTO.MonanDTO;
import GUI.PhieuNhapGUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MonanBUS {
    public static ArrayList<MonanDTO> dsmonan;
    public static ArrayList<LoaimonanDTO> dsloaimonan;
    private ArrayList<String> dsidmon;
    public static ArrayList<MonanDTO> dsmonanKogiamgia;
    public static ArrayList<MonanDTO> dsmonanconban;
    private int max;
    private String idmon;
    
    public MonanBUS(){}
    public void docDsmonan(){
        MonanDAO data = new MonanDAO();
        dsmonan = new ArrayList<MonanDTO>();
        dsmonan = data.DocDsmonan();
    } 
    public void docDsmonanconban(){
        MonanDAO data = new MonanDAO();
        dsmonan = new ArrayList<MonanDTO>();
        dsmonanconban = new ArrayList<MonanDTO>();
        dsmonan = data.DocDsmonan();
        for(MonanDTO a : dsmonan)
        {
            if(a.trangthai.equals("1"))
            {
                dsmonanconban.add(a);
            }
        }
    } 
    
    public void docDsloaimonan(){
        MonanDAO data = new MonanDAO();
        dsloaimonan = new ArrayList<LoaimonanDTO>();
        dsloaimonan = data.DocDsloaimonan();
    }
    
    public String getIDmon(){
        MonanDAO data = new MonanDAO();
        dsidmon = new ArrayList<String>();
        dsidmon = data.GetIdmon();
        boolean ok = false;
        ArrayList<String> arr = new ArrayList<>();
        for(String a : dsidmon)
        {
            if(a.indexOf(PhieuNhapGUI.idNcc) >= 0)
            {
                arr.add(a);
            } 
        }
        if(arr.isEmpty())
        {
            idmon = PhieuNhapGUI.idNcc + "-SP1";
        } else
        {
            max = Integer.parseInt(arr.get(0).split("P")[1]);
            for(int i = 1;i<arr.size();i++)
            {
                int idnext = Integer.parseInt(arr.get(i).split("P")[1]);
                if(idnext > max)
                {
                    max = idnext;
                }
            }
            idmon = PhieuNhapGUI.idNcc + "-SP" +Integer.toString(max+1);
        }
        return idmon;
    }
    
    
    public ArrayList<MonanDTO> search1(String strsearch,String loaimon,int gia1,int gia2,String dkkm,String dkhot){
        ArrayList<MonanDTO> dstimkiem = new ArrayList();
        System.out.println(loaimon);
        if(dkhot.equals("Có")){
            Collections.sort(dsmonan,new Comparator<MonanDTO>(){
                @Override
                public int compare(MonanDTO mon1, MonanDTO mon2){
                        return mon1.soluongdaban - mon2.soluongdaban;
                }
            }); 
            
            for(int i=dsmonan.size()-1;i>(dsmonan.size()-5);i--){
                MonanDTO monan = dsmonan.get(i);
                if(strsearch.equals("")){
                    /*if(loaimon.equals("")){
                        if(monan.cogiamgia.equals(dkkm) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }else{
                        if((monan.tenloai.equals(loaimon)) && (monan.cogiamgia.equals(dkkm))
                                 && ((gia2 >= monan.dongia) && (monan.dongia >= gia1))){      
                            dstimkiem.add(monan);
                        }
                    }*/
                    if(gia2 > 0){
                        if(loaimon.equals("Tất cả")){
                            if((monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                                    && (monan.dongia >= gia1))){
                                dstimkiem.add(monan);
                            }
                        }else{
                            if((monan.tenloai.equals(loaimon))
                                && (monan.cogiamgia.equals(dkkm)) 
                                && ((gia2 >= monan.dongia) && (monan.dongia >= gia1))){
                                dstimkiem.add(monan);
                            }
                        }
                         if(monan.cogiamgia.equals(dkkm) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }else{
                        dstimkiem.add(monan);
                    }
                }else{
                    if(loaimon.equals("Tất cả")){
                        if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0) 
                                && (monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }else{
                        if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0) 
                                && (monan.tenloai.equals(loaimon)) 
                                && (monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }
                }
            }
        /*} else{  
            for(MonanDTO monan : dsmonan){
                if(strsearch.equals("")){
                    if(loaimon.equals("Tất cả")){
                        if((monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                                dstimkiem.add(monan);
                        }
                    }else{
                        if((monan.tenloai.equals(loaimon)) && (monan.cogiamgia.equals(dkkm)) 
                                && ((gia2 >= monan.dongia)
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }
                }else{
                    if(loaimon.equals("Tất cả")){
                        if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0) 
                            && (monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                            && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }else{
                        if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0) 
                            && (monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                            && (monan.dongia >= gia1)) && (monan.tenloai.equals(loaimon))){
                            dstimkiem.add(monan);
                        }   
                    }
                }
            }
        }*/  
    }else{
        for(MonanDTO monan : dsmonan){
            System.out.println("---Danh sách loại----");
            System.out.println(monan.tenloai);
            System.out.println("---------------------");
            if(strsearch.equals("")){
                if(!loaimon.equals("") && gia2 > 0){
                    if(loaimon.equals("Tất cả")){
                        if((monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                                dstimkiem.add(monan);
                        }
                    }else{
                        if((monan.tenloai.equals(loaimon)) && (monan.cogiamgia.equals(dkkm)) 
                                && ((gia2 >= monan.dongia)
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }
                }else if(gia2 > 0){
                     if ((gia2 >= monan.dongia) && (monan.dongia >= gia1)){
                        dstimkiem.add(monan);
                    }
                }else if(!loaimon.equals("") && gia2 == 0){
                    System.out.println("Loại cần lấy: "+loaimon);
                    if(monan.tenloai.equals(loaimon)){
                        System.out.println("tên loại"+monan.tenloai);
                        dstimkiem.add(monan);
                        System.out.println(dstimkiem);
                    }
                /*}else{
                    if(monan.cogiamgia.equals(dkkm)){
                        dstimkiem.add(monan);
                    }*/
                }
            }else{
                if(strsearch.length()>2){
                    if(strsearch.substring(0,2).equals("SP")){
                         if(monan.idmon.equals(monan)){
                             dstimkiem.add(monan);
                        }
                    } 
                }
                if(loaimon.equals("")){
                    if(monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0){
                        dstimkiem.add(monan);
                    }
                }else{
                    if(loaimon.equals("Tất cả")){
                        if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0) 
                                && (monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }else{
                        if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0) 
                                && (monan.tenloai.equals(loaimon)) 
                                && (monan.cogiamgia.equals(dkkm)) && ((gia2 >= monan.dongia) 
                                && (monan.dongia >= gia1))){
                            dstimkiem.add(monan);
                        }
                    }  
                }
            }
        }
    }
    return dstimkiem;
    }
    
    public ArrayList<MonanDTO> search2(String strsearch,String loaimon,int gia1,
            int gia2,int sold1,int sold2,int tonkho1,int tonkho2,String dkkm){
        ArrayList<MonanDTO> dstimkiem = new ArrayList();
        for(MonanDTO monan : dsmonan){
            if(strsearch.equals("")){
                if(loaimon.equals("Tất cả")){
                    if ((monan.cogiamgia.equals(dkkm) && ((gia2 >= monan.dongia) && (monan.dongia >= gia1)) 
                            && ((sold2 >= monan.soluongdaban) && (monan.soluongdaban >= sold1)) 
                            && ((tonkho2 >= monan.tonkho) && (monan.tonkho >= tonkho1)))){
                        dstimkiem.add(monan);
                    }
                }else{
                    if(monan.tenloai.equals(loaimon)){
                        if((monan.tenloai.equals(loaimon)) && (monan.cogiamgia.equals(dkkm)) 
                            && ((gia2 >= monan.dongia) && (monan.dongia >= gia1)) 
                            && ((sold2 >= monan.soluongdaban) && (monan.soluongdaban >= sold1)) 
                            && ((tonkho2 >= monan.tonkho) && (monan.tonkho >= tonkho1))){
                            dstimkiem.add(monan);
                        }
                    }
                }     
            }else{  
                if(loaimon.equals("Tất cả")){
                    if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0) 
                            && (monan.cogiamgia.equals(dkkm)) 
                            && ((gia2 >= monan.dongia) && (monan.dongia >= gia1)) 
                            && ((sold2 >= monan.soluongdaban) && (monan.soluongdaban >= sold1)) 
                            && ((tonkho2 >= monan.tonkho) && (monan.tonkho >= tonkho1))){
                        dstimkiem.add(monan);
                    }
                }else{
                    if((monan.tenmon.toLowerCase().indexOf(strsearch.toLowerCase()) >= 0)
                            && (monan.tenloai.equals(loaimon)) && (monan.cogiamgia.equals(dkkm)) 
                            && ((gia2 >= monan.dongia) && (monan.dongia >= gia1)) 
                            && ((sold2 >= monan.soluongdaban) && (monan.soluongdaban >= sold1)) 
                            && ((tonkho2 >= monan.tonkho) && (monan.tonkho >= tonkho1))){
                        dstimkiem.add(monan);
                    }
                }
            }
        }
        return dstimkiem;
    }
    
    public void addMonan(MonanDTO monan){
        MonanDAO data = new MonanDAO();
        data.ThemMonan(monan);
    }
    
    public void removeMonan(String idmon){
        int i=0;
        MonanDAO data = new MonanDAO();
        data.XoaMonan(idmon);
        MonanDTO monanxoa = new MonanDTO();
        for (MonanDTO monan : dsmonan){
            if(monan.idmon.equals(idmon)){
                monan.trangthai="0";
            }
            i++;
        }
    }
 
    public void editMonan(String idmon,String tenmon,int dongia){
        int i=0;
        MonanDAO data = new MonanDAO();
        data.SuaMonan(idmon,tenmon,dongia);
        for(MonanDTO monan : dsmonan){
            if(monan.idmon.equals(monan.idmon)){
                monan.tenmon=tenmon;
                monan.dongia=dongia;
            }
        }
    }
    public void docMonanchuagiam(){
        MonanDAO data = new MonanDAO();     
            dsmonanKogiamgia = new ArrayList<MonanDTO>();
            dsmonanKogiamgia = data.docMonchuagiam();
    }   
    public void suaGiamgia(MonanDTO ct)
    {
        MonanDAO dao = new MonanDAO();
        dao.suaGiamgia(ct);// truyền ct vào dao để update
        for(MonanDTO a : dsmonanKogiamgia)//duyet arraylist cua bus
        {
            if(a.idmon.equals(ct.idmon))
            {
                a.cogiamgia = ct.cogiamgia;
            }
            
        }
    }
    public void congTonkho(int value, String idmon)
    {
        MonanDAO dao = new MonanDAO();
        dao.congTonkho(value, idmon);// truyền ct vào dao để update
        
    }
    public void truTonkho(int value, String idmon)
    {
        MonanDAO dao = new MonanDAO();
        dao.truTonkho(value, idmon);// truyền ct vào dao để update
        
    }
    public void truSoluongdaban(int value, String idmon)
    {
        MonanDAO dao = new MonanDAO();
        dao.truSoluongdaban(value, idmon);// truyền ct vào dao để update
        
    }
    public ArrayList<MonanDTO> timtheoAll(String ma)
    {
        docDsmonanconban();
        ArrayList<MonanDTO> kq = new ArrayList<MonanDTO>();
        for (MonanDTO a : dsmonanconban)
        {
            if(a.getTenmon().indexOf(ma) >=0)
            {
                kq.add(a);
            }
        }
        return kq;
    }
}
        
