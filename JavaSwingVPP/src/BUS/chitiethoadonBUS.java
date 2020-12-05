/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.chitiethoadonDTO;
import java.util.ArrayList;
import static BUS.HoadonBUS.dshoadon;
import DAO.chitiethoadonDAO;
/**
 *
 * @author MY PC
 */
public class chitiethoadonBUS 
{
     public static ArrayList<chitiethoadonDTO> dschitiet; 
     public static ArrayList<chitiethoadonDTO> dschitiet1; 

    public chitiethoadonBUS() {
    }
    

    public void docChitiet(chitiethoadonDTO cthd)
    {
        chitiethoadonDAO dao = new chitiethoadonDAO();
        dao.docchitiet(cthd);//truyen mã giam cần lấy chi tiet xuog dao
        dschitiet = new ArrayList<chitiethoadonDTO>();

        dschitiet = chitiethoadonDAO.dschitietDAO;//gán arrbus = arr dao
    }
    public void docChitiet1(String cthd)
    {
        chitiethoadonDAO dao = new chitiethoadonDAO();
        dao.docchitiet1(cthd);//truyen mã giam cần lấy chi tiet xuog dao
        dschitiet1 = new ArrayList<chitiethoadonDTO>();

        dschitiet1 = chitiethoadonDAO.dschitiethdDAO;//gán arrbus = arr dao
    }
    public void docChitiet()
    {
        chitiethoadonDAO dao = new chitiethoadonDAO();
            dschitiet = new ArrayList<chitiethoadonDTO>();
            dschitiet = dao.docChitiet();//ghi arraylist cua DAO vao arraylist cua BUS
    }
}
