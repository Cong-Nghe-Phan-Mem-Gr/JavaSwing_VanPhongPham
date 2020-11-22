
package GUI;

import static java.awt.Color.black;
import static java.awt.Color.green;
import static GUI.BanhangGUI.carttable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class SanphamGUI extends JPanel implements MouseListener{
    JLabel namelbl,pricelbl,hinhlbl,tonkholbl;
    String id,name,tonkho,price,km;
    public static int sl;
    ImageIcon img;
    JDialog detail;
    String[] cartheader = {"IDSP","Tên sản phẩm","Tồn kho","Đơn giá","","Số lượng","","Thành tiền",""};
    ImageIcon increaseicon = new ImageIcon(this.getClass().getResource("/Icons/up.png"));
    ImageIcon decreaseicon = new ImageIcon(this.getClass().getResource("/Icons/down.png"));
    ImageIcon removeicon = new ImageIcon(this.getClass().getResource("/Icons/trashicon1.png"));
    public SanphamGUI(String id,String name,String tonkho,String price,String km){
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
        setBorder(new LineBorder(black,3,true));
        try{
            img = new ImageIcon(this.getClass().getResource("/img/noimg1.jpg"));
        }catch(Exception e){
            //ImageIcon img = new ImageIcon(this.getClass().getResource(source));
            img = new ImageIcon(this.getClass().getResource("/img/noimg.jpg"));
        }
        hinhlbl = new JLabel(img,JLabel.CENTER);
        hinhlbl.setPreferredSize(new Dimension(140,130));
        hinhlbl.setBounds(0,0,140,130);
        namelbl = new JLabel(name,JLabel.CENTER);
        namelbl.setBounds(0,100,130,30);
        namelbl.setBackground(Color.red);
        namelbl.setBorder(new LineBorder(black,1,true));
        //namelbl.setText(id);
        pricelbl = new JLabel(price,JLabel.CENTER);
        pricelbl.setBounds(100,0,40,40);
        pricelbl.setBackground(new Color(102,178,155));
        pricelbl.setBorder(new LineBorder(black,1,true));
        //pricelbl.setText(price);
        tonkholbl = new JLabel(tonkho,JLabel.CENTER);
        tonkholbl.setBounds(100,100,40,30);
        tonkholbl.setBackground(Color.BLUE);
        
        hinhlbl.add(namelbl);
        hinhlbl.add(pricelbl);
        hinhlbl.add(tonkholbl);
        add(hinhlbl);
        addMouseListener(this);
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

    public String getTonkho() {
        return tonkho;
    }

    public void setTonkho(String tonkho) {
        this.tonkho = tonkho;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public JDialog getDetail() {
        return detail;
    }

    public void setDetail(JDialog detail) {
        this.detail = detail;
    }

    public double thanhTien(){
        return Double.parseDouble(this.price)*sl;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
        System.out.println("cc1");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("cc2");
    }
}
