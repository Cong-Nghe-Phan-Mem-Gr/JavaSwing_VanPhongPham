/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.GIAMGIADAO;
import DTO.GIAMGIADTO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class GIAMGIABUS {
    public static ArrayList<GIAMGIADTO> dsgg=new ArrayList<>();
    public boolean them(GIAMGIADTO ggdto) throws SQLException{
        GIAMGIADAO ggdao1=new GIAMGIADAO();
        if(dsgg==null)
            dsgg=ggdao1.Doc();
        
        for(int i=0;i<dsgg.size();i++){
          
            if(ggdto.getMASP().equals(dsgg.get(i).getMASP())){
                JOptionPane.showMessageDialog(null,"MASP đã tồn tại");
                return false;    
            }
        }
        if(ggdto.getMAGG().equals("") || ggdto.getMASP().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Không được để MASP hoặc MAGG rỗng");
            return false;
        }
        
        GIAMGIADAO ggdao=new GIAMGIADAO();
         int ktngay=0;
        try{
            Date s=Date.valueOf(ggdto.getNGBD());
            Date s1=Date.valueOf(ggdto.getNGKT());
            ktngay=1;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Định dạng ngày bắt đầu hoặc ngày kết thúc không hợp lệ");
            return false;
        }
        if(ggdto.getNGBD().compareTo(ggdto.getNGKT())>0)
        {
            JOptionPane.showMessageDialog(null,"Ngày bắt đầu phải trước ngày kết thúc");
            return false;
        }
        if(ggdao.Them(ggdto)==false)
            return false;
        dsgg.add(ggdto);
        return true;
    }
 
    }
}
