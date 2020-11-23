
package GUI;

import BUS.HoadonBUS;
import BUS.SanphamBUS;
import DTO.SanphamDTO;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import static BUS.SanphamBUS.dssp;
import static BUS.HoadonBUS.giohang;
import static java.awt.Color.red;
import java.time.LocalDateTime;
//import static GUI.OverallFrame.currentIdnv;

public class BanhangGUI extends JFrame implements ItemListener,MouseListener{
    JPanel searchpanel,functionpanel1,functionpanel2,infopanel,cartpanel,infokh;
    JPanel displaypanel[];
    JTextField searchtxt,tientratxt,maggtxt;
    JPanel displaysp;
    JComboBox loai;
    private Font f = new Font("Arial",Font.BOLD,16);
    private Font f2 = new Font("Arial",Font.BOLD,13);
    private LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private JScrollPane searchjsp,cartjsp;
    //ArrayList<SanphamGUI> displaymangsp;
//JPanel cartpanel[];
    private JLabel magglbl,idhdlbl,giatienlbl,thongbaolbl,cartlbl,infolbl,totallbl1,totallbl2,searchbtn,
            ngaylaplbl,gialbl,goiylbl1,goiylbl2,goiylbl3,goiylbl4,goiylbl5,goiylbl6,goiylbl7,
            checkoutbtn,thanhtienlbl1,thanhtienlbl2,reloadbtn,printbtn,loaddatabtn,nextbtn,prebtn,
            pagelbl,ngaylaptxt,infokhlbl,searchbtnkh,closebtn,
            infokhlbl1,infokhlbl2,tienthualbl1,tienthualbl2,tientralbl,magglbl1,magglbl2,goiylbl;  
    JLabel a = new JLabel();
    public static JTable carttable;
    public static String idhd;
    public static ArrayList<String> category;
    //ArrayList<> mangsp;
    ArrayList<SanphamGUI> mangdisplaysp;
    String[] cartheader = {"IDSP","Tên sản phẩm","Tồn kho","Đơn giá","","Số lượng","","Thành tiền",""};
    
    public BanhangGUI(){
        loadsp();
        inits();
    }
    public void inits(){
        setSize(945,650);
        setLayout(null);
        setBackground(new Color(0, 255, 204));
        //panel gio hang
        //DefaultTableCellEditor cellRender = new DefaultTableCellEditor();
        //cellRender.add(removebtn);
        //searchtable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRender());
        //{public boolean isCellEditable(int row, int column){return false;}}
        DefaultTableModel cartmodel = new DefaultTableModel(cartheader,0);
        carttable = new JTable(cartmodel);
        cartjsp = new JScrollPane(carttable);
        //cartjsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //cartjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        cartjsp.setBounds(0,5,620,300);
        cartjsp.setBorder(new LineBorder(black,3,true));
        add(cartjsp);
        
        //panel thong tin
        infopanel = new JPanel(new FlowLayout(0,5,5));
        infopanel.setBounds(620,0,300,500);
        infopanel.setBorder(new LineBorder(black,3,true));
        
        infokh = new JPanel(new FlowLayout(0,5,5));    
        infokh.setPreferredSize(new Dimension(300,70));
        //infokh.setBounds(620,5,300,300);
        searchbtnkh = new JLabel(new ImageIcon("C:\\Users\\nngia\\Documents\\NetBeansProjects\\QLVPP\\src\\main\\java\\Icons\\searchicon1.png"));
        searchbtnkh.setPreferredSize(new Dimension(40,30));
        infokhlbl1 = new JLabel("Tìm khách hàng...");
        infokhlbl1.setPreferredSize(new Dimension(180,30));
        infokhlbl1.setFont(f);
        infokhlbl2 = new JLabel("Khách lẻ");
        infokhlbl2.setPreferredSize(new Dimension(280,30));
        infokhlbl2.setFont(f);
        infokhlbl2.setHorizontalAlignment(JLabel.CENTER);
        closebtn = new JLabel(new ImageIcon("C:\\Users\\nngia\\Documents\\NetBeansProjects\\QLVPP\\src\\main\\java\\Icons\\searchicon1.png"));
        closebtn.setPreferredSize(new Dimension(40,30));
        thanhtienlbl1 = new JLabel("Tổng thành tiền");
        thanhtienlbl1.setFont(f);
        thanhtienlbl1.setPreferredSize(new Dimension(170,30));
        thanhtienlbl2 = new JLabel("100000");
        thanhtienlbl2.setFont(f);
        thanhtienlbl2.setPreferredSize(new Dimension(110,30));
        thanhtienlbl2.setHorizontalAlignment(JLabel.RIGHT);
        magglbl1 = new JLabel("Mã giảm giá");
        magglbl1.setPreferredSize(new Dimension(170,30));
        magglbl1.setFont(f);
        maggtxt = new JTextField(10);
        maggtxt.setFont(f);
        maggtxt.setPreferredSize(new Dimension(300,30));
        magglbl2 = new JLabel("100000");
        magglbl2.setFont(f);
        magglbl2.setPreferredSize(new Dimension(110,30));
        magglbl2.setHorizontalAlignment(JLabel.RIGHT);
        totallbl1 = new JLabel("Tổng tiền");
        totallbl1.setFont(f);
        totallbl1.setPreferredSize(new Dimension(170,30));
        totallbl2 = new JLabel("100000");
        totallbl2.setFont(f);
        totallbl2.setHorizontalAlignment(JLabel.RIGHT);
        totallbl2.setPreferredSize(new Dimension(110,30));
        tientralbl = new JLabel("Khách trả");
        tientralbl.setFont(f);
        tientralbl.setPreferredSize(new Dimension(150,30));
        tientratxt = new JTextField(9);
        tientratxt.setHorizontalAlignment(JLabel.RIGHT);
        tientratxt.setFont(f);
        tientratxt.setPreferredSize(new Dimension(100,30));
        tienthualbl1 = new JLabel("Tiền thừa");
        tienthualbl1.setFont(f);
        tienthualbl1.setPreferredSize(new Dimension(170,30));
        tienthualbl2 = new JLabel("100000");
        tienthualbl2.setFont(f);
        tienthualbl2.setPreferredSize(new Dimension(110,30));
        tienthualbl2.setHorizontalAlignment(JLabel.RIGHT);
        goiylbl = new JLabel("Gợi ý tiền mặt");
        goiylbl.setFont(f);
        goiylbl.setPreferredSize(new Dimension(300,30));
        goiylbl1 = new JLabel("10000");
        goiylbl1.setFont(f2);
        goiylbl1.setBorder(new LineBorder(blue,1,true));
        goiylbl1.setForeground(Color.blue);
        goiylbl1.setOpaque(true);
        goiylbl1.setHorizontalAlignment(JLabel.CENTER);
        goiylbl1.setPreferredSize(new Dimension(90,40));
        goiylbl2 = new JLabel("20000");
        goiylbl2.setBorder(new LineBorder(blue,1,true));
        goiylbl2.setForeground(Color.blue);
        goiylbl2.setOpaque(true);
        goiylbl2.setHorizontalAlignment(JLabel.CENTER);
        goiylbl2.setPreferredSize(new Dimension(90,40));
        goiylbl3 = new JLabel("50000");
        goiylbl3.setFont(f2);
        goiylbl3.setBorder(new LineBorder(blue,1,true));
        goiylbl3.setForeground(Color.blue);
        goiylbl3.setOpaque(true);
        goiylbl3.setHorizontalAlignment(JLabel.CENTER);
        goiylbl3.setPreferredSize(new Dimension(90,40));
        goiylbl4 = new JLabel("100000");
        goiylbl4.setFont(f2);
        goiylbl4.setBorder(new LineBorder(blue,1,true));
        goiylbl4.setForeground(Color.blue);
        goiylbl4.setOpaque(true);
        goiylbl4.setHorizontalAlignment(JLabel.CENTER);
        goiylbl4.setPreferredSize(new Dimension(90,40));
        goiylbl5 = new JLabel("200000");
        goiylbl5.setFont(f2);
        goiylbl5.setBorder(new LineBorder(blue,1,true));
        goiylbl5.setForeground(Color.blue);
        goiylbl5.setOpaque(true);
        goiylbl5.setHorizontalAlignment(JLabel.CENTER);
        goiylbl5.setPreferredSize(new Dimension(90,40));
        goiylbl6 = new JLabel("500000");
        goiylbl6.setFont(f2);
        goiylbl6.setBorder(new LineBorder(blue,1,true));
        goiylbl6.setForeground(Color.blue);
        goiylbl6.setOpaque(true);
        goiylbl6.setHorizontalAlignment(JLabel.CENTER);
        goiylbl6.setPreferredSize(new Dimension(90,40));
        goiylbl7 = new JLabel("1000000");
        goiylbl7.setFont(f2);
        goiylbl7.setBorder(new LineBorder(blue,1,true));
        goiylbl7.setForeground(Color.blue);
        goiylbl7.setOpaque(true);
        goiylbl7.setHorizontalAlignment(JLabel.CENTER);
        goiylbl7.setPreferredSize(new Dimension(280,40));


        infopanel.add(searchbtnkh);
        infopanel.add(infokhlbl1);
        infopanel.add(closebtn);
        infopanel.add(infokhlbl2);
        infopanel.add(thanhtienlbl1);
        infopanel.add(thanhtienlbl2);
        infopanel.add(magglbl1);
        infopanel.add(magglbl2);
        infopanel.add(maggtxt);
        infopanel.add(totallbl1);
        infopanel.add(totallbl2);
        infopanel.add(tientralbl);
        infopanel.add(tientratxt);
        infopanel.add(tienthualbl1);
        infopanel.add(tienthualbl2);
        infopanel.add(goiylbl);
        infopanel.add(goiylbl1);
        infopanel.add(goiylbl2);
        infopanel.add(goiylbl3);
        infopanel.add(goiylbl4);
        infopanel.add(goiylbl5);
        infopanel.add(goiylbl6);
        infopanel.add(goiylbl7);
        
        
        //panel chuc nang 1
        functionpanel1 = new JPanel(null);
        functionpanel1.setBounds(0,300,600,40);
        functionpanel1.setBorder(new LineBorder(black,3,true));
        ngaylaplbl = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/calendericon.png")));
        ngaylaplbl.setBounds(5,300,30,40);
        ngaylaptxt = new JLabel(dtf.format(date));
        ngaylaptxt.setBounds(37,300,80,40);
        searchtxt = new JTextField(18);
        searchtxt.setBounds(120,305,150,30);
        searchbtn = new JLabel();
        searchbtn.setBounds(340,300,30,40);
        searchbtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png")));
        searchbtn.addMouseListener(this);
        prebtn = new JLabel();
        prebtn.setBounds(370,300,30,40);
        prebtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/pre.png")));
        prebtn.addMouseListener(this);
        nextbtn = new JLabel();
        nextbtn.setBounds(410,300,30,40);
        nextbtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/next.png")));
        nextbtn.addMouseListener(this);
        pagelbl = new JLabel("1");
        pagelbl.setFont(f);
        pagelbl.setBounds(400,300,30,40);
        loai = new JComboBox();
        loai.setBounds(480,300,120,30);
        
        add(ngaylaplbl);
        add(ngaylaptxt);
        add(searchtxt);
        add(searchbtn);
        add(prebtn);
        add(pagelbl);
        add(nextbtn);
        add(loai);
        
        //panel search
        loaddisplaysp(dssp);
        searchpanel = displaysp(0);
        searchpanel.setBounds(0,340,610,270);
        searchpanel.setBorder(new LineBorder(black,3,true));
        
        
        //panel chuc nang 2
        functionpanel2 = new JPanel(null);
        functionpanel2.setBounds(600,310,500,340);
        functionpanel2.setBorder(new LineBorder(black,3,true));
        add(searchpanel);
        add(functionpanel1);
        //add(functionpanel2);
        add(infopanel);
        
    }
    
    
    public JPanel displaysp(int page){
        return displaypanel[page];
    }
    
    public void loaddisplaysp(ArrayList<SanphamDTO> arr){
        mangdisplaysp = new ArrayList<SanphamGUI>();
        int pages=0,i=0,j=0,k;
        if(arr.size() % 8 != 0) pages +=arr.size()/8+1;
        else pages +=arr.size()/8;
        System.out.println(pages);
        displaypanel = new JPanel[pages];
        while(i<pages){
            displaypanel[i] = new JPanel(new FlowLayout(1,5,5));
            System.out.println(i);
            k=0;
            while(j < arr.size()){
                SanphamGUI displaysp = new SanphamGUI(arr.get(j).getIdsp(),arr.get(j).getTensp(),arr.get(j).getTonkho(),
                        arr.get(j).getDongia(),Integer.parseInt(arr.get(j).getCogiamgia()));
                mangdisplaysp.add(displaysp);
                displaypanel[i].add(displaysp);
                k++;j++;
                if(k == 9) break;
            }
            i++;
        }
    }
    
    public void loadsp(){
        SanphamBUS bus = new SanphamBUS();
        if(dssp == null) bus.docDssp();
        System.out.println(dssp.size());
    }

    public void loadIdhd(){
        HoadonBUS bus = new HoadonBUS();
        idhd = bus.loadIdhd();
    }
    public static void main(String[] args) {
        BanhangGUI a = new BanhangGUI();
        a.setVisible(true);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == displaysp){
            System.out.println("cc");
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
