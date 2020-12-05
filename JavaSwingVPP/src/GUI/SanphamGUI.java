
package GUI;

import BUS.HoadonBUS;
import DTO.HoadonDTO;
import static java.awt.Color.black;
import static java.awt.Color.green;
import static GUI.BanhangGUI.carttable;
import static GUI.BanhangGUI.loadinfo;
import static BUS.HoadonBUS.giohang;
import static BUS.HoadonBUS.tongsl;
import static BUS.HoadonBUS.tongtien;
import DTO.GioHangDTO;
import DTO.SanphamDTO;
import static GUI.BanhangGUI.loadTienthua;
import static GUI.BanhangGUI.loadgoiy;
import static GUI.BanhangGUI.loadinfo;
import static GUI.BanhangGUI.mangdisplaysp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static BUS.HoadonBUS.tongsl;
import static BUS.HoadonBUS.tongtien;
//import static GUI.OverallFrame.currentIdnv;

public class SanphamGUI extends JPanel implements MouseListener{
    JLabel namelbl,pricelbl,hinhlbl,tonkholbl;
    String id,name;
    int tonkho,price,km;
    LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DetailGUI detail;
    public int sl;
    ImageIcon img;
    String[] cartheader = {"IDSP","Tên sản phẩm","Tồn kho","Đơn giá","","Số lượng","","Thành tiền",""};
    ImageIcon increaseicon = new ImageIcon(this.getClass().getResource("/Icons/up.png"));
    ImageIcon decreaseicon = new ImageIcon(this.getClass().getResource("/Icons/down.png"));
    ImageIcon removeicon = new ImageIcon(this.getClass().getResource("/Icons/trashicon1.png"));
    DefaultTableModel cartmodel;
    
    public SanphamGUI(String id,String name,int tonkho,int price,int km){
        this.id = id;
        this.name = name;
        this.tonkho = tonkho;
        this.price = price;
        this.km = km;
        inits();
    }
    
    public void inits(){
        setLayout(null);
        setPreferredSize(new Dimension(140,130));
        setBackground(Color.white);
        setBorder(new LineBorder(Color.BLUE,1,true));
        try{
            Image a = new ImageIcon(this.getClass().getResource("/img/"+id+".jpg")).getImage().getScaledInstance(135,125,Image.SCALE_SMOOTH);
            img = new ImageIcon(a);
        }catch(Exception e){
            img = new ImageIcon(this.getClass().getResource("/img/noimg.jpg"));
        }
        hinhlbl = new JLabel(img,JLabel.CENTER);
        hinhlbl.setBounds(0,0,140,100);
        hinhlbl.setBackground(Color.red);
        namelbl = new JLabel(name,JLabel.CENTER);
        namelbl.setBounds(0,100,100,30);
        namelbl.setBackground(Color.BLUE);
        pricelbl = new JLabel(Integer.toString(price),JLabel.CENTER);
        pricelbl.setBounds(100,0,40,40);
        pricelbl.setBackground(new Color(102,178,155));
        pricelbl.setFont(new Font("Arial",Font.BOLD,11));
        pricelbl.setBorder(new LineBorder(Color.RED,1,true));
        pricelbl.setForeground(Color.RED);
        hinhlbl.add(pricelbl);
        add(namelbl);
        add(hinhlbl);
        addMouseListener(this);
    }
    
    public void addCart(){
        this.tonkho -= 1;
        HoadonBUS hdbus = new HoadonBUS();
        hdbus.addCart(id,name,tonkho,price);
        loadCart();
    }

    
    public void loadCart(){
        int tongsl1=0,tongtien1=0;
        cartmodel = new DefaultTableModel(cartheader,0){
           public boolean isCellEditable(int row, int column) {
                if(column == 4 || column == 5 || column == 6 || column == 8){
                    return true;
                }else return false;
            }     
        }; 
        for(GioHangDTO sp : giohang){
            Object[] data = {sp.getIdsp(),sp.getTensp(),sp.getTonkho(),sp.getDongia(),decreaseicon,sp.getSl(),increaseicon,sp.thanhTien(),removeicon};
            tongsl1 += sp.sl;
            tongtien1 += sp.thanhTien();
            cartmodel.addRow(data);
        }
        carttable.setModel(cartmodel);
        carttable.getColumnModel().getColumn(4).setCellRenderer(new DecreaseButtonRender());
        carttable.getColumnModel().getColumn(4).setCellEditor(new DecreaseButtonRender());
        carttable.getColumnModel().getColumn(6).setCellRenderer(new IncreaseButtonRender());
        carttable.getColumnModel().getColumn(6).setCellEditor(new IncreaseButtonRender());
        carttable.getColumnModel().getColumn(8).setCellRenderer(new RemoveButtonRender());
        carttable.getColumnModel().getColumn(8).setCellEditor(new RemoveButtonRender());
        carttable.getColumnModel().getColumn(0).setPreferredWidth(70);
        carttable.getColumnModel().getColumn(1).setPreferredWidth(250);
        carttable.getColumnModel().getColumn(2).setPreferredWidth(70);
        carttable.getColumnModel().getColumn(3).setPreferredWidth(100);
        carttable.getColumnModel().getColumn(4).setPreferredWidth(30);
        carttable.getColumnModel().getColumn(5).setPreferredWidth(70);
        carttable.getColumnModel().getColumn(6).setPreferredWidth(30);
        carttable.getColumnModel().getColumn(7).setPreferredWidth(70);
        carttable.getColumnModel().getColumn(8).setPreferredWidth(30);
        carttable.setRowHeight(30);
        carttable.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int sl=0;
                if(carttable.getSelectedColumn() == 5){
                    try{
                        String sl1 = JOptionPane.showInputDialog("Nhập số lượng");
                        sl = Integer.parseInt(sl1);     
                        if(sl < 1){
                            JOptionPane.showMessageDialog(null,"Số lượng phải lớn hơn 1",null,JOptionPane.ERROR_MESSAGE); 
                        }else{ 
                            int i = carttable.getSelectedRow();
                            String idsp = carttable.getValueAt(i,0).toString();
                            int tk = Integer.parseInt(carttable.getValueAt(i,2).toString()); 
                            int slold = Integer.parseInt(carttable.getValueAt(i,5).toString()); 
                            int dongia = Integer.parseInt(carttable.getValueAt(i,3).toString());
                            if((tk+slold) < sl){
                                JOptionPane.showMessageDialog(null,"Trong kho không đủ",null,JOptionPane.ERROR_MESSAGE); 
                            }else{
                                HoadonBUS bus = new HoadonBUS();
                                if(sl > slold){
                                    bus.tangsl(idsp,sl-slold);  
                                }else{
                                    bus.giamsl(idsp,slold-sl);  
                                }
                                carttable.setValueAt(sl,i,5);
                                carttable.setValueAt((tk+slold)-sl,i,2); 
                                carttable.setValueAt(sl*dongia,i,7); 
                                for(SanphamGUI sp : mangdisplaysp){
                                    if(sp.getId().equals(idsp)){
                                        sp.setTonkho((tk+slold)-sl);
                                    }
                                }
                                loadinfo(tongsl,tongtien);
                                loadTienthua();
                                loadgoiy();
                                JOptionPane.showMessageDialog(null,"Thay đổi thành công",null,JOptionPane.ERROR_MESSAGE); 
                            }
                        }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null,"Số lượng không hợp lệ",null,JOptionPane.ERROR_MESSAGE); 
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
            
        });
       
        loadinfo(tongsl,tongtien);
    }

    
    
    public JLabel getNamelbl() {
        return namelbl;
    }

    public void setNamelbl(JLabel namelbl) {
        this.namelbl = namelbl;
    }

    public JLabel getPricelbl() {
        return pricelbl;
    }

    public void setPricelbl(JLabel pricelbl) {
        this.pricelbl = pricelbl;
    }

    public JLabel getHinhlbl() {
        return hinhlbl;
    }

    public void setHinhlbl(JLabel hinhlbl) {
        this.hinhlbl = hinhlbl;
    }

    public JLabel getTonkholbl() {
        return tonkholbl;
    }

    public void setTonkholbl(JLabel tonkholbl) {
        this.tonkholbl = tonkholbl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.tonkho > 0){
            addCart();
        }else{
            JOptionPane.showMessageDialog(null,"Trong kho không đủ",null,JOptionPane.ERROR_MESSAGE); 
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("cc");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        detail = new DetailGUI(id,name,price,tonkho,km,e.getLocationOnScreen());
        detail.setVisible(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        detail.setVisible(false);
    }
}
