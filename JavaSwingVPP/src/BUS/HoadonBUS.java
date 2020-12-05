package BUS;

import static BUS.ChiTietGiamBUS.dschitiet;
import java.util.ArrayList;
import DTO.HoadonDTO;
import DAO.HoadonDAO;
import DTO.ChiTietGiamDTO;
import DTO.SanphamDTO;
import javax.swing.JOptionPane;
import static BUS.SanphamBUS.dsspSelling;
import DAO.SanphamDAO;
import DTO.GioHangDTO;

/**
 *
 * @author USER
 */
public class HoadonBUS {
    public static ArrayList<GioHangDTO> giohang;
    private ArrayList<String> dsidmon;
    public static int tongtien=0,tongsl=0;
    public int max;
    private int thanhtien;
    private String idhd;
    public static ArrayList<HoadonDTO> dshoadon; 
    public static ArrayList<HoadonDTO> dshd; 
    public static ArrayList<HoadonDTO> dshd2; 
    //public static String idhd;
    
    public HoadonBUS(){};
    
    public void docDshoadon(String id){
        HoadonDAO data = new HoadonDAO();
        dshd = new ArrayList<HoadonDTO>();
        dshd = data.DocDshoadon(id);
    }
    
    public void docDshoadon(){
        HoadonDAO data = new HoadonDAO();
        dshd2 = new ArrayList<HoadonDTO>();
        dshd2 = data.dochoadon();
    }
  
    public void addCart(String idsp,String tensp,int tonkho,int dongia){
        if(giohang == null) giohang = new ArrayList<GioHangDTO>();
        Boolean loop = false;
        for(GioHangDTO gh : giohang){
            if(gh.getIdsp().equals(idsp)){
               gh.setSl(gh.getSl()+1);
               gh.setTonkho(gh.getTonkho()-1);
               tongtien += gh.dongia;
               tongsl++;
               loop = true;
               break;
            }
        }
        if(loop == false){
            giohang.add(new GioHangDTO(idsp,tensp,tonkho,dongia,1,tongtien += dongia));
            tongsl++;
        }
        for(SanphamDTO sp : dsspSelling){
            if(sp.getIdsp().equals(idsp)){
                sp.setSoluongdaban(sp.getSoluongdaban()+1);
                sp.setTonkho(sp.getTonkho()-1);
                break;
            }
        }
    }

    public void removeCart(String idsp){
        //int i=0;
        GioHangDTO spxoa = new GioHangDTO();
        for(int i=0;i<giohang.size();i++){
            spxoa = giohang.get(i);
            if(idsp.equals(giohang.get(i).idsp)){
                for(SanphamDTO sp : dsspSelling){
                    if(sp.getIdsp().equals(idsp)){
                        sp.setSoluongdaban(sp.getSoluongdaban()-giohang.get(i).sl);
                        sp.setTonkho(sp.getTonkho()+giohang.get(i).sl);
                        break;
                    }
                }
                tongtien -= spxoa.thanhtien;
                tongsl -= spxoa.sl;
                System.out.println("tong sau"+tongtien);
                break;
            }
        }
        giohang.remove(spxoa);
    }
    
    public void giamsl(String idsp,int sl){
        for(GioHangDTO gh : giohang){
            if(gh.getIdsp().equals(idsp)){
                gh.setSl(gh.getSl()-sl);
                gh.setTonkho(gh.getTonkho()+sl);
                gh.thanhTien();
                tongtien -= sl*gh.dongia;
                tongsl -= sl;;
                break;
            }
        }
        for(SanphamDTO sp : dsspSelling){
            if(sp.getIdsp().equals(idsp)){
                sp.setSoluongdaban(sp.getSoluongdaban()-sl);
                sp.setTonkho(sp.getTonkho()+sl);
                break;
            }
        }
    }

    public void tangsl(String idsp,int sl){
         for(GioHangDTO gh : giohang){
            if(gh.getIdsp().equals(idsp)){
                gh.setSl(gh.getSl()+sl);
                gh.setTonkho(gh.getTonkho()-sl);
                gh.thanhTien();
                tongtien += sl*gh.dongia;
                tongsl += sl;
                break;
            }
        }
        for(SanphamDTO sp : dsspSelling){
            if(sp.getIdsp().equals(idsp)){
                sp.setSoluongdaban(sp.getSoluongdaban()+sl);
                sp.setTonkho(sp.getTonkho()-sl);
                break;
            }
        }
    }
    public void removeAll(){
        for(GioHangDTO gh : giohang){
            for(SanphamDTO sp : dsspSelling){
                if(sp.getIdsp().equals(gh.idsp)){
                    sp.setSoluongdaban(sp.getSoluongdaban()-gh.sl);
                    sp.setTonkho(sp.getTonkho()+gh.sl);
                    break;
                }
            }
        }
        giohang.clear();
        tongtien=0;
        tongsl=0;
    }
    
    public ArrayList<HoadonDTO> search(String strsearch){
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for(HoadonDTO hd : dshd){
            if(hd.idhd.equals(strsearch) || hd.idhd.equals(strsearch ) || hd.ngaylap.equals(strsearch)){
                kq.add(hd);
            }
        }
        return kq;
    }
    public String loadIDHD(){
        HoadonDAO data = new HoadonDAO();
        return "HD"+(data.getIdhd()+1);
    }
    
    public int tongtien(){
        int tong=0;
        for(HoadonDTO hd: dshd2){
            tong+=hd.tongtien;
        }
        return tong;
    }
    
    public int tongsp(){
        int tong=0;
        for(HoadonDTO hd: dshd2){
            tong+=hd.soluong;
        }
        return tong;
    }
    
    public void checkOut(String idkh,String idnv,String date){
        if (dshoadon == null) dshoadon = new ArrayList<HoadonDTO>();
        HoadonDAO data = new HoadonDAO();
        SanphamDAO data1 = new SanphamDAO();
        int a = data.getIdhd()+1;
        data.ThemHoadon("HD"+a,idkh,idnv,date,tongtien);
        for(GioHangDTO sp : giohang){
            data.ThemChitietHoadon("HD"+a,sp.idsp,sp.sl,sp.dongia,sp.thanhtien);
            for(SanphamDTO sp1 : dsspSelling){
                if(sp1.getIdsp().equals(sp.getIdsp())){
                    data1.update(sp1);
                    break;
                }
            }
            dshoadon.add(new HoadonDTO("HD"+a,idkh,idnv,sp.idsp,sp.tensp,sp.dongia,sp.sl,sp.thanhtien,tongtien,date,1));
        }
        tongtien=0;
        giohang.clear();
    }
    
    public void xoa(String id){
        HoadonDAO dao = new HoadonDAO();
        for(HoadonDTO a : dshd)
        {
            if(a.getIdhd().equals(id)){               
                dshd.remove(a);   
                break;
            }
        }
        dao.Xoa(id);
    }
}
