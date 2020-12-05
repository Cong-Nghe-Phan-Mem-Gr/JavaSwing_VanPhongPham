/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.UserDAO;
import DAO.nhanvienDAO;
import DTO.UserDTO;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class UserBUS {
    public static ArrayList<UserDTO> dsuser; 
    public UserBUS()
    {
    }
    public void docUserInfo()
    {
        UserDAO dao = new UserDAO();
            dsuser = new ArrayList<UserDTO>();
            dsuser = dao.docUserInfo();//ghi arraylist cua DAO vao arraylist cua BUS
    }
    public void themUser(UserDTO ct)
    {
        dsuser.add(ct);// them vao arr cua bus
        UserDAO dao = new UserDAO();
        dao.themUser(ct);//truyền bien ct xuog lớp dao
        
    }
    
    public void suaUser(UserDTO ct)
    {
        UserDAO dao = new UserDAO();
        dao.suaUser(ct);// truyền ct vào dao để update
        for(UserDTO a : dsuser)//duyet arraylist cua bus
        {
                if (a.getUsername().equals(ct.getUsername()))//so sanh id trong array vs biến truyền từ gui
                {
                    a.setPass(ct.getPass());//gan' bien tu GUI vao arraylist
                    a.setIdnv(ct.getIdnv());//gan' bien tu GUI vao arraylist
                    break;
                }
        }
    }
    public void xoaUser(UserDTO ct)
    {
        UserDAO dao = new UserDAO();
        dao.xoaUser(ct);// truyền ct vào dao để update
        for(UserDTO a : dsuser)//duyet arraylist cua bus
        {
            if(a.getUsername().equals(ct.getUsername()))//so sanh id trong array vs biến truyền từ gui
            {               
                dsuser.remove(a);
                break;
            }
        }
        
    }
    public void xoaUsertheonhanvien(String id)
    {
        UserDAO dao = new UserDAO();
        dao.xoaUsertheonhanvien(id);// truyền ct vào dao để update
        for(UserDTO a : dsuser)//duyet arraylist cua bus
        {
            if(a.getIdnv().equals(id))//so sanh id trong array vs biến truyền từ gui
            {               
                dsuser.remove(a);
                break;
            }
        }
        
    }
    public ArrayList<UserDTO> timtheoMa(String ma)
    {
        docUserInfo();
        ArrayList<UserDTO> kq = new ArrayList<UserDTO>();
        for (UserDTO a : dsuser)
        {
            if(a.getIdnv().indexOf(ma) >=0)
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
    public ArrayList<UserDTO> timtheoUsername(String user)
    {
        docUserInfo();
        ArrayList<UserDTO> kq = new ArrayList<UserDTO>();
        for (UserDTO a : dsuser)
        {
            if(a.getUsername().indexOf(user) >=0)
            {
                kq.add(a);
            }
        }
        return kq;
    }
    public ArrayList<UserDTO> timtheoAll(String ma)
    {
        docUserInfo();
        ArrayList<UserDTO> kq = new ArrayList<UserDTO>();
        for (UserDTO a : dsuser)
        {
            if(    a.getUsername().indexOf(ma) >=0
                || a.getIdnv().indexOf(ma) >=0)
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
