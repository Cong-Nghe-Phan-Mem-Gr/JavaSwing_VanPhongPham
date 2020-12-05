/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.nhacungcapDAO;
import DTO.nhacungcapDTO;
import java.util.ArrayList;
/**
 *
 * @author MY PC
 */
public class nhacungcapBUS 
{
    public static ArrayList<nhacungcapDTO> dsncc; 
    private ArrayList<String> dsidpn;
         public int max;
        private String idpn;
    public nhacungcapBUS()
    {
    }
    public String loadIdpn(){
        nhacungcapDAO data = new nhacungcapDAO();
        dsidpn = new ArrayList();
        dsidpn = data.getIdphieunhap();
        if(dsidpn.size() == 0)
        {
            idpn = "NCC1";
        }
        else
        {
            max = Integer.parseInt(dsidpn.get(0).substring(3));
        for(int i = 0;i<dsidpn.size();i++){
            int idnext = Integer.parseInt(dsidpn.get(i).substring(3));
            if(idnext > max){
                max = idnext;
            }
        }
        idpn = "NCC" + Integer.toString(max+1);
        }
        return idpn;
    }
    public void docnhacungcap()
    {
        nhacungcapDAO nccdao = new nhacungcapDAO();
        //neu array rong thi them moi 
           dsncc = new ArrayList<nhacungcapDTO>();
            dsncc = nccdao.docnhacungcap();//ghi arraylist cua DAO vao arraylist cua BUS
        
    }
    
    public void themnhacungcap(nhacungcapDTO ncc)
    {

        dsncc.add(ncc);// them vao arr cua bus

        nhacungcapDAO nccdao = new nhacungcapDAO();
        nccdao.themnhacungcap(ncc);//truyền bien ct xuog lớp dao
        
    }
    
    public void suanhacungcap(nhacungcapDTO ncc)
    {
        nhacungcapDAO nccdao = new nhacungcapDAO();
        nccdao.suanhacungcap(ncc);// truyền ct vào dao để update
        for(nhacungcapDTO a : dsncc)//duyet arraylist cua bus
        {
                if (a.getIdncc().equals(ncc.getIdncc()))//so sanh id trong array vs biến truyền từ gui
                {
                    a.setTenncc(ncc.getTenncc());//gan' bien tu GUI vao arraylist
                    a.setEmail(ncc.getEmail());
                    a.setPhone(ncc.getPhone());
                    break;
                }
        }
    }
    
    public void xoanhacungcap(nhacungcapDTO ncc)
    {
        nhacungcapDAO nccdao = new nhacungcapDAO();
        nccdao.xoanhacungcap(ncc);// truyền ct vào dao để update
        for(nhacungcapDTO a : dsncc)//duyet arraylist cua bus
        {
            if(a.getIdncc().equals(ncc.getIdncc()))//so sanh id trong array vs biến truyền từ gui
            {               
                
                dsncc.remove(a);
                break;
            }
        }
        
    }

    public static void main(String[] args) {
        nhacungcapBUS bus = new nhacungcapBUS();
        bus.docnhacungcap();
    }
    
    public ArrayList<nhacungcapDTO> timtheoMa(String ma)
    {
        docnhacungcap();
        ArrayList<nhacungcapDTO> kq = new ArrayList<nhacungcapDTO>();
        for (nhacungcapDTO a : dsncc)
        {
            if(a.getIdncc().indexOf(ma) >=0)
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
    
    
    
    public ArrayList<nhacungcapDTO> timtheoTen(String ten)
    {
        docnhacungcap();
        ArrayList<nhacungcapDTO> kq = new ArrayList<nhacungcapDTO>();
        for (nhacungcapDTO a : dsncc)
        {
            if(a.getTenncc().indexOf(ten) >=0)
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
    
    public ArrayList<nhacungcapDTO> timtheoAll(String ma)
    {
        docnhacungcap();
        ArrayList<nhacungcapDTO> kq = new ArrayList<nhacungcapDTO>();
        for (nhacungcapDTO a : dsncc)
        {
            if(    
                    a.getIdncc().indexOf(ma) >=0
                || a.getTenncc().indexOf(ma) >=0

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
