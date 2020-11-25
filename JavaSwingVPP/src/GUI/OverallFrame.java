/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.PhanQuyenBUS;
import BUS.nhanvienBUS;
import DTO.LeftMenu;
import DTO.PhanQuyenDTO;
import static GUI.loginForm.currentPass;
import static GUI.loginForm.currentUser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Nam
 */
    public class OverallFrame extends JFrame implements MouseListener {
    public JPanel header, leftmenu;
    public static JPanel content;
    
    private ArrayList<LeftMenu> navObj = new ArrayList<>();
     ArrayList<String> arrTen;
    private final int DEFAULT_HEIGHT = 700,DEFAULT_WIDTH = 1200 ;
    ArrayList<String> arrQuyen = new ArrayList<>();//arr chua quyen cần hiển thị
    public static String currentIdnv;
    public OverallFrame()
    {
        init();
        changeMainInfo(5);
    }
    public void init()
    {   
        //thay doi con tro chuot
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("./src/img/icons8-cursor-48.png").getImage(),
                new Point(0, 0), ""));
        //logo
        ImageIcon logo = new ImageIcon("./src/img/icons8-shop-50.png");
        setIconImage(logo.getImage());
        //setCursor(Cursor.HAND_CURSOR);//thay doi con tro chuot
        //border layout
        setLayout(new BorderLayout());
        header = CreateJpanelHeader(); //tao tieu de cho frame
        header.setBackground(Color.cyan);
        header.setPreferredSize(new Dimension(0,46));
        add(header, BorderLayout.NORTH); //HƯỚNG BẮC
        //menu left
        leftmenu = CreateJpanel_Leftmenu();
        leftmenu.setPreferredSize(new Dimension(250, 0));
        leftmenu.setBackground(new Color(0, 153, 255));
        add(leftmenu, BorderLayout.WEST); // HƯỚNG TÂY
        //content
        content=new JPanel(null);
        content.setBackground(Color.gray);
        add(content,BorderLayout.CENTER);// CENTER
        //chinh jframe
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);// xoa thanh mac dinh cua jframe
        setLocationRelativeTo(null);//cho ra giua man hinh
        setVisible(true);
        //setResizable(false);//ko cho phep thu nhỏ frame
    }
    //ham dispose jframe
    public void disposeF()
    {
        this.dispose();
    }
//    public static void main(String[] args) {
//        OverallFrame f =new OverallFrame();
//    }

    private JPanel CreateJpanelHeader() {
        JPanel header=new JPanel();
        Border border = new LineBorder(Color.orange, 3, true);//set border
        header.setBorder(border);
        header.setLayout(null);
        //content
        JLabel logo = new JLabel(new ImageIcon("./src/img/icons8-shop-50.png"),JLabel.CENTER);
        logo.setBounds(new Rectangle(20,10, 25, 25));
        Font font = new Font("Segoe Print",Font.BOLD,16);
        JLabel name = new JLabel("FAST FOOD STORE");
        name.setFont(font);
        name.setForeground(Color.blue);
        name.setBounds(new Rectangle(55, 0, 300, 50));
        //add vao header
        header.add(logo);
        header.add(name);
        //tao nút 
        //tao login
        LeftMenu loginIcon = new LeftMenu("", new Rectangle(DEFAULT_WIDTH-500, 0, 250, 44)
                , "icons8-user-50.png", "icons8-user-50.png", "icons8-user-50.png", new Color(239,239,239));
        loginIcon.setBorder(new MatteBorder(3, 0, 1, 0, Color.orange));
        //hihen thi nguoi dang log in
        nhanvienBUS nvbus = new nhanvienBUS();
        nvbus.docThongtin(currentUser);
        currentIdnv = nvbus.nvdto.getIdnv();
        JLabel lblogin = new JLabel("Hello: "+nvbus.nvdto.getLname()+" "+nvbus.nvdto.getFname());//lay username dang login
        lblogin.setFont( new Font("Arials",Font.BOLD,14));
        lblogin.setForeground(Color.blue);
        lblogin.setBounds(50, 3, 200, 40);
        //nut logout
        LeftMenu logout = new LeftMenu("", new Rectangle(DEFAULT_WIDTH-250, 0, 50, 43)
                , "icons8-exit-50.png", "icons8-exit-50.png", "icons8-exit-50.png", new Color(80,80,80));
        logout.setBorder(new MatteBorder(3, 0, 0, 0, Color.orange));
        header.add(logout.isLogout());
        loginIcon.add(lblogin);
        header.add(loginIcon.isLogin());
        //log in
        ImageIcon icon1 = new ImageIcon("./src/img/icons8-user-50.png");
        loginIcon.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e)
           {
                System.out.println("day ne");
                JOptionPane.showMessageDialog(null, "FirstName: "+nvbus.nvdto.getFname()+"\n"
                                                    +"LastName: "+nvbus.nvdto.getLname()+"\n"
                                                    +"UserName: "+currentUser+"\n"
                                                    +"PassWord: "+currentPass+"\n"
                                                    +"Email: "   +nvbus.nvdto.getEmail()+"\n"
                                                    +"Phone: "   +nvbus.nvdto.getPhone()+"\n"
                                                    +"Address: " +nvbus.nvdto.getAddress()+"\n"
                        , "Thông tin", JOptionPane.PLAIN_MESSAGE,icon1);
           }
        });
        //logout
        logout.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e)
           {
                disposeF();
                loginForm log = new loginForm();
                log.setVisible(true);
           }
        });
        //Tạo btn EXIT & MINIMIZE
        LeftMenu exit = new LeftMenu("", new Rectangle(DEFAULT_WIDTH-50, 0, 50, 43)
                , "icons8-close-window-50.png", "icons8-close-window-50.png", "icons8-close-window-50.png", new Color(240, 71, 74));
        LeftMenu minimize = new LeftMenu("", new Rectangle(DEFAULT_WIDTH-100, 0, 50, 43)
                , "icons8-minimize-window-50.png", "icons8-minimize-window-50.png", "icons8-minimize-window-50.png" ,new Color(80,80,80));
        exit.setBorder(new MatteBorder(3, 0, 0, 3, Color.orange));
        minimize.setBorder(new MatteBorder(3, 0, 0, 0, Color.orange));
        header.add(exit.isButton());
        header.add(minimize.isButton());

        exit.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e)
           {
              System.exit(0);
           }
        });
        
        minimize.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e)
           {
                setState(Frame.ICONIFIED);
           }
        });
        return header;
    }
    
    
    private JPanel CreateJpanel_Leftmenu() {
        JPanel nav = new JPanel(null);
        nav.setBackground(Color.GREEN);
        
        int y = 220;
        arrTen = new ArrayList<>();//arr chua tên quyen hạn
        for (PhanQuyenDTO a : PhanQuyenBUS.dschitietquyen) 
        {   
            arrTen.add(a.tenquyen);//ten 
            arrQuyen.add(Integer.toString(a.idquyenhan));//arr cua quyen can hien thị
        }
        
        navObj.clear();
        for(int i = 0; i< arrTen.size(); i++)
        {  
            String ten = arrTen.get(i);
            navObj.add(new LeftMenu(ten, new Rectangle(0, y, 250, 50)));
            navObj.get(i).addMouseListener(this);
            y = y +50;
            nav.removeAll();
            //duyet mang menu
            for (LeftMenu n : navObj) 
            {
                nav.add(n);//add vao thanh menu
            }
            JLabel profile = new JLabel(new ImageIcon("./src/img/avatar.png"));
            profile.setBounds(0, 0, 250, 220);
            profile.setBorder(new MatteBorder(0, 2, 2, 2, Color.orange));
            nav.add(profile);
            nav.repaint();
            nav.revalidate();
        }
        return nav;
        
    }
 public static void changeMainInfo(int i) //Đổi Phần hiển thị khi bấm btn trên menu
    { 
switch(i)
{
       case 1: break;	
       case 2: break;
       case 3: break;
       case 4: break;
       case 5: break;
       case 6: break;
       case 7: break;
       case 8: break;
       case 9: break; 
       default:break;
}
}
    @Override
    public void mouseClicked(MouseEvent e) {
            for(int i = 0; i< navObj.size(); i++)
            {
                LeftMenu item = navObj.get(i); // lấy vị trí item trong menu
                if(e.getSource().equals(item))
                    {
                        item.doActive(); // Active NavItem đc chọn 
                        System.out.println(arrQuyen.get(i));
                        changeMainInfo(Integer.parseInt(arrQuyen.get(i)));//truyền xuong de thay doi content
                    }
                else
                    {
                        item.noActive();
                    }
            }
        }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
