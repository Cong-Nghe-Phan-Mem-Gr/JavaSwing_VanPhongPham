
import DTO.PhanQuyenDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class PhanQuyenDAO {
    MyDBConnection conn = new MyDBConnection();
    public static ArrayList<PhanQuyenDTO> dschitietquyen;
    
    public ArrayList docChitiet(String currentUser)
            //ham lay thong in user
    {
        dschitietquyen = new ArrayList<PhanQuyenDTO>();
        try
        {
            String query = "SELECT * FROM `chitietphanquyen` INNER JOIN "
                    + "chitietquyen ON chitietquyen.idquyenhan = chitietphanquyen.idquyenhan "
                    + "WHERE username = '"+currentUser+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                PhanQuyenDTO dto = new PhanQuyenDTO();
                dto.setCurrentUser(rs.getString("username"));//ghi du lieu tu databse vao DTO
                dto.setIdquyenhan(rs.getInt("idquyenhan"));//ghi du lieu tu databse vao DTO
                dto.setTenquyen(rs.getString("tenquyen"));
                
                
                dschitietquyen.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Sai doc phan quyen dao");
        }
        return dschitietquyen;
    }
    
    public void themPhanQuyen(PhanQuyenDTO ct)
    {
        try
        {
        String query = "INSERT INTO `chitietphanquyen` VALUES ("
                + "'" +ct.getIdquyenhan()+ "',"
                + "'" +ct.getCurrentUser()+ "');";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void xoaPhanquyen(PhanQuyenDTO ct)
    {
        try
        {
            String query = "DELETE FROM `chitietphanquyen` WHERE"
                    +" username='"+ct.getCurrentUser()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("L?i x�a phan quyen");
            //JOptionPane.showMessageDialog(null, "M� gi?m gi� c�n chi ti?t gi?m kh�ng th? x�a");
        }
    }
}
