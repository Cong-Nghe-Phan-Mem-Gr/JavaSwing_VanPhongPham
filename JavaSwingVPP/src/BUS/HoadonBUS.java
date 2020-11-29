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
    //public static String idhd;
    
    public HoadonBUS(){};
    
    public void docDshoadon(){
        HoadonDAO data = new HoadonDAO();
        dshoadon = new ArrayList<HoadonDTO>();
        dshoadon = data.DocDshoadon();
    }
    
    public void dochoadon(String id)
    {
        HoadonDAO dao = new HoadonDAO();
        dao.dochoadon(id);
        dshd = new ArrayList<HoadonDTO>();
        dshd = HoadonDAO.dshd;

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
            System.out.println(tongtien);
        }
    }

    public void removeCart(String idsp){
        int i=0;
        GioHangDTO spxoa = new GioHangDTO();
        for(GioHangDTO gh : giohang){
            if(idsp.equals(gh.idsp)){
                spxoa=giohang.get(i);
                tongtien -= spxoa.thanhtien;
                tongsl -= spxoa.sl;
            }
            i++;
        }
        giohang.remove(spxoa);
    }
    
    public void giamsl(String idsp,int sl){
        for(GioHangDTO gh : giohang){
            if(gh.getIdsp().equals(idsp)){
                gh.setSl(gh.getSl()-sl);
                gh.setTonkho(gh.getTonkho()+sl);
                tongtien -= sl*gh.dongia;
                tongsl -= sl;;
                break;
            }
        }
    }
    
    public void tangsl(String idsp,int sl){
         for(GioHangDTO gh : giohang){
            if(gh.getIdsp().equals(idsp)){
                gh.setSl(gh.getSl()+sl);
                gh.setTonkho(gh.getTonkho()-sl);
                tongtien += sl*gh.dongia;
                tongsl += sl;
                break;
            }
        }
    }
    
    public ArrayList<HoadonDTO> search(String strsearch){
        docDshoadon();
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for(HoadonDTO hd : dshoadon){
            if(hd.idhd.equals(strsearch) || hd.idhd.equals(strsearch )){
                kq.add(hd);
            }
        }
        return kq;
    }
    
    public void checkOut(String idkh,String idnv,String date){
        HoadonDAO data = new HoadonDAO();
        data.getIdhd();
        data.ThemHoadon("HD"+data.getIdhd()+1,idkh,idnv,date, tongtien);
        for(GioHangDTO sp : giohang){
            data.ThemChitietHoadon("HD"+data.getIdhd()+1,sp.tensp,sp.sl,sp.dongia,sp.thanhtien);
            dshoadon.add(new HoadonDTO("HD"+data.getIdhd()+1,idkh,idnv,sp.idsp,sp.tensp,sp.dongia,sp.sl,sp.thanhtien,tongtien,date,1));
        }
    }
    
   /*public void checkOut(ArrayList<GioHangDTO> giohang){
        HoadonDAO data = new HoadonDAO();
        GioHangDTO hd = new GioHangDTO();
        data.ThemHoadon(giohang.get(0));
        for(int i=0;i<giohang.size();i++){
            hd = giohang.get(i);
            data.ThemChitietHoadon(hd);
        }
        tongtien=0;
        giohang.clear();
    }
    
    
    public ArrayList<HoadonDTO> timtheoAll(String ma)
    {
        docDshoadon();
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for (HoadonDTO a : dshoadon)
        {
            if(    a.getIdhd().indexOf(ma) >=0
                || a.getIdnv().indexOf(ma) >=0
                || a.getNgaylap().indexOf(ma) >=0
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
        
        public ArrayList<HoadonDTO> timtheoMa(String ma)
    {
        docDshoadon();
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for (HoadonDTO a : dshoadon)
        {
            if(a.getIdhd().indexOf(ma) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
        
        public ArrayList<HoadonDTO> timtheongaylap(String ma)
    {
        docDshoadon();
        ArrayList<HoadonDTO> kq = new ArrayList<HoadonDTO>();
        for (HoadonDTO a : dshoadon)
        {
            if(a.getNgaylap().indexOf(ma) >=0)
            {
                kq.add(a);
            }

        }
        return kq;
    }
        
     public void xoaHoadon(String hd)
    {
        HoadonDAO dao = new HoadonDAO();
        
        for(HoadonDTO a : dshd)//duyet arraylist cua bus
        {
            if(a.getIdhd().equals(hd))//so sanh id trong array vs biến truyền từ gui
            {               
                dshd.remove(a);   
                break;
            }
        }
        dao.xoaHoadon(hd);// truyền ct vào dao để update
    }*/
}
