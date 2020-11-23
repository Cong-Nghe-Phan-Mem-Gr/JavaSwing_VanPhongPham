
package GUI;

import BUS.HoadonBUS;
import DTO.HoadonDTO;
import static java.awt.Color.black;
import static java.awt.Color.green;
import static GUI.BanhangGUI.carttable;
import static GUI.BanhangGUI.idhd;
import static BUS.HoadonBUS.giohang;
import static BUS.HoadonBUS.tongtien;
import DTO.GioHangDTO;
import DTO.SanphamDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
//import static GUI.OverallFrame.currentIdnv;

public class SanphamGUI extends JPanel implements MouseListener{
    JLabel namelbl,pricelbl,hinhlbl,tonkholbl;
    String id,name;
    int tonkho,price,km;
    LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DetailGUI detail;
    public static int sl;
    ImageIcon img;
    String[] cartheader = {"IDSP","Tên sản phẩm","Tồn kho","Đơn giá","","Số lượng","","Thành tiền",""};
    ImageIcon increaseicon = new ImageIcon(this.getClass().getResource("/Icons/up.png"));
    ImageIcon decreaseicon = new ImageIcon(this.getClass().getResource("/Icons/down.png"));
    ImageIcon removeicon = new ImageIcon(this.getClass().getResource("/Icons/trashicon1.png"));
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
        //setIcon();
        setPreferredSize(new Dimension(140,130));
        //setBounds(145);
        setBackground(Color.white);
        setBorder(new LineBorder(black,3,true));
        try{
            img = new ImageIcon(this.getClass().getResource("/img/noimg1.jpg"));
        }catch(Exception e){
            //ImageIcon img = new ImageIcon(this.getClass().getResource(source));
            img = new ImageIcon(this.getClass().getResource("/img/noimg.jpg"));
        }
        hinhlbl = new JLabel(img,JLabel.CENTER);
        //hinhlbl.setPreferredSize(new Dimension(140,130));
        hinhlbl.setBounds(0,0,140,100);
        hinhlbl.setBackground(Color.red);
        namelbl = new JLabel(name,JLabel.CENTER);
        namelbl.setBounds(0,100,100,30);
        namelbl.setBackground(Color.BLUE);
        //namelbl.setBorder(new LineBorder(black,1,true));
        //namelbl.setText(id);
        pricelbl = new JLabel(Integer.toString(price),JLabel.CENTER);
        pricelbl.setBounds(100,0,40,40);
        pricelbl.setBackground(new Color(102,178,155));
        pricelbl.setBorder(new LineBorder(black,1,true));
        //pricelbl.setText(price);
        tonkholbl = new JLabel(Integer.toString(tonkho),JLabel.CENTER);
        tonkholbl.setBounds(100,100,40,30);
        tonkholbl.setForeground(Color.RED);
        tonkholbl.setBorder(new LineBorder(black,1,true));
        tonkholbl.setBackground(Color.BLUE);
        
        //hinhlbl.add(namelbl);
        hinhlbl.add(pricelbl);
        add(tonkholbl);
        add(namelbl);
        add(hinhlbl);
        addMouseListener(this);
        //loadDetail();
    }
    
    public void loadDetail(){
        
        //add(detail);
        
    }
    
    public void addCart(){
        this.tonkho -= 1;
        HoadonBUS hdbus = new HoadonBUS();
        hdbus.addCart(id,name,tonkho,price,1);
        loadCart();
    }

    
    public void loadCart(){
        DefaultTableModel cartmodel = new DefaultTableModel(cartheader,0);
        cartmodel = new DefaultTableModel(cartheader,0){
           public boolean isCellEditable(int row, int column) {
                if(column == 3 || column == 4 || column == 6 || column == 8){
                    return true;
                }else return false;
            }     
        }; 
        sl=1;
         for(GioHangDTO sp : giohang){
            Object[] data = {sp.getIdsp(),sp.getTensp(),sp.getTonkho(),sp.getDongia(),decreaseicon,sp.getSl(),increaseicon,sp.thanhTien(),removeicon};
            cartmodel.addRow(data);
        }
        //cartmodel.addRow(data);
        carttable.setModel(cartmodel);
        carttable.getColumnModel().getColumn(4).setCellRenderer(new DecreaseButtonRender());
        carttable.getColumnModel().getColumn(4).setCellEditor(new DecreaseButtonRender());
        carttable.getColumnModel().getColumn(6).setCellRenderer(new IncreaseButtonRender());
        carttable.getColumnModel().getColumn(6).setCellEditor(new IncreaseButtonRender());
        carttable.getColumnModel().getColumn(8).setCellRenderer(new RemoveButtonRender());
        carttable.getColumnModel().getColumn(8).setCellEditor(new RemoveButtonRender());
        carttable.getColumnModel().getColumn(0).setPreferredWidth(50);
        carttable.getColumnModel().getColumn(1).setPreferredWidth(100);
        carttable.getColumnModel().getColumn(2).setPreferredWidth(70);
        carttable.getColumnModel().getColumn(3).setPreferredWidth(100);
        carttable.getColumnModel().getColumn(4).setPreferredWidth(40);
        carttable.getColumnModel().getColumn(5).setPreferredWidth(50);
        carttable.getColumnModel().getColumn(6).setPreferredWidth(40);
        carttable.getColumnModel().getColumn(7).setPreferredWidth(50);
        carttable.getColumnModel().getColumn(8).setPreferredWidth(40);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double thanhTien(){
        return this.price*sl;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        addCart();
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
