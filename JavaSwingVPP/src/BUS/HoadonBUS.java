package BUS;

import static BUS.ChiTietGiamBUS.dschitiet;
import java.util.ArrayList;
import DTO.HoadonDTO;
import DAO.HoadonDAO;
import DTO.ChiTietGiamDTO;
import DTO.SanphamDTO;
import javax.swing.JOptionPane;
import static BUS.SanphamBUS.dssp;
import DAO.SanphamDAO;
import DTO.GioHangDTO;

/**
 *
 * @author USER
 */
public class HoadonBUS {
    public static ArrayList<GioHangDTO> giohang;
    private ArrayList<String> dsidmon;
    public static int tongtien;
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
    public String loadIdhd(){
        HoadonDAO data = new HoadonDAO();
        dsidmon = new ArrayList();
        dsidmon = data.getIdhd();
        
        if(dsidmon.size() == 0)
        {
            idhd = "HD1";
        }
        else
        {
            max = Integer.parseInt(dsidmon.get(0).substring(2));
        for(int i = 0;i<dsidmon.size();i++){
            int idnext = Integer.parseInt(dsidmon.get(i).substring(2));
            if(idnext > max){
                max = idnext;
            }
        }
        idhd = "HD" + Integer.toString(max+1);
        }
        return idhd;
    }
    
    public void dochoadon(String id)
    {
        HoadonDAO dao = new HoadonDAO();
        dao.dochoadon(id);
        dshd = new ArrayList<HoadonDTO>();
        dshd = HoadonDAO.dshd;

    }
    
    public void addCart(String idsp,String tensp,int tonkho,int dongia,int sl){
        if(giohang == null) giohang = new ArrayList<GioHangDTO>();
        Boolean loop = false;
        SanphamBUS spbus = new SanphamBUS();
        SanphamDAO data = new SanphamDAO();
        ChiTietGiamBUS ctgbus = new ChiTietGiamBUS();
        ctgbus.docChitiet();
        /*for(SanphamDTO sp : spbus.dssp){
            if(sp.cogiamgia.equals("1")){
                for(ChiTietGiamDTO ctg : dschitiet){
                    if(sp.idsp.equals(ctg.getIdMon())){
                        sp.dongia -= Float.parseFloat(ctg.getTileGiam());
                        System.out.println(ctg.getTileGiam());
                    }
                }
            }
        }*/
        for(SanphamDTO sp : dssp){
            if(sp.idsp.equals(idsp)){
                if(sp.tonkho >= sl){
                    for(GioHangDTO gh : giohang){
                        if(gh.idsp.equals(idsp)){
                            gh.sl += sl;
                            gh.tonkho -= sl;
                            sp.tonkho -= sl;
                            sp.soluongdaban += sl;
                            gh.sl += sl;
                            gh.thanhtien = gh.sl*gh.dongia;
                            System.out.println("Thành tiền" +gh.thanhtien);
                            tongtien += sl*sp.dongia;  
                            data.update(sp);
                            loop = true;
                        }
                    } 
                    if (loop == false){
                        sp.tonkho -= sl;
                        sp.soluongdaban += sl;
                        thanhtien = sl*sp.dongia;
                        tongtien += sl*sp.dongia;
                        giohang.add(new GioHangDTO(idsp,tensp,tonkho,dongia,sl,sl*dongia));
                        data.update(sp);
                    }            
                }else{
                    JOptionPane.showMessageDialog(null,"Trong kho không đủ",null,JOptionPane.INFORMATION_MESSAGE);
                }
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
}
