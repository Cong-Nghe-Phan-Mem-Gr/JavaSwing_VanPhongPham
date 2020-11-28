
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
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
//import static GUI.OverallFrame.currentIdnv;

public class BanhangGUI extends JFrame implements ItemListener,MouseListener{
    JPanel searchpanel,functionpanel1,functionpanel2,infopanel,cartpanel,infokh,pagepanel;
    JPanel displaypanel[];
    JTextField searchtxt,maggtxt;
    public static JTextField tientratxt;
    JPanel displaysp;
    JComboBox loai;
    public static DecimalFormat df = new DecimalFormat(",000");
    private Font f = new Font("Arial",Font.BOLD,16);
    private Font f2 = new Font("Arial",Font.BOLD,13);
    private LocalDateTime date = LocalDateTime.now();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private JScrollPane searchjsp,cartjsp;
    //ArrayList<SanphamGUI> displaymangsp;
//JPanel cartpanel[];
    private JLabel magglbl,idhdlbl,giatienlbl,thongbaolbl,historybtn,infolbl,totallbl1,searchbtn,
            ngaylaplbl,gialbl,goiylbl1,goiylbl2,goiylbl3,goiylbl4,goiylbl5,goiylbl6,goiylbl7,
            checkoutbtn,thanhtienlbl1,reloadbtn,printbtn,loaddatabtn,nextbtn,prebtn,
            pagelbl,ngaylaptxt,infokhlbl,searchbtnkh,tongsl1,closebtn,
            infokhlbl1,infokhlbl2,tienthualbl1,tientralbl,magglbl1,goiylbl;  
    JLabel a = new JLabel();
    public static JLabel thanhtienlbl2,totallbl2,tienthualbl2,tongsl2,magglbl2;
    public static JTable carttable;
    public static String idhd;
    public static ArrayList<String> category;
    int page=0,pagemax;
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
        cartjsp.setBounds(0,0,620,250);
        cartjsp.setBorder(new LineBorder(black,3,true));
        add(cartjsp);
        
        //panel thong tin
        infopanel = new JPanel(new FlowLayout(0,5,5));
        infopanel.setBounds(620,0,300,500);
        infopanel.setBorder(new LineBorder(black,3,true));
        
        infokh = new JPanel(new FlowLayout(0,5,5));    
        infokh.setPreferredSize(new Dimension(300,70));
        //infokh.setBounds(620,5,300,300);
        searchbtnkh = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png")));
        searchbtnkh.setPreferredSize(new Dimension(40,30));
        infokhlbl1 = new JLabel("Tìm khách hàng...");
        infokhlbl1.setPreferredSize(new Dimension(180,30));
        infokhlbl1.setFont(f);
        infokhlbl2 = new JLabel("Khách lẻ");
        infokhlbl2.setPreferredSize(new Dimension(280,30));
        infokhlbl2.setFont(f);
        infokhlbl2.setHorizontalAlignment(JLabel.CENTER);
        closebtn = new JLabel();
        closebtn.setPreferredSize(new Dimension(50,30));
        tongsl1 = new JLabel("Tổng số lượng");
        tongsl1.setFont(f);
        tongsl1.setPreferredSize(new Dimension(170,30));
        tongsl2 = new JLabel("100000");
        tongsl2.setFont(f);
        tongsl2.setPreferredSize(new Dimension(110,30));
        tongsl2.setHorizontalAlignment(JLabel.RIGHT);
        thanhtienlbl1 = new JLabel("Tổng thành tiền");
        thanhtienlbl1.setFont(f);
        thanhtienlbl1.setPreferredSize(new Dimension(170,30));
        thanhtienlbl2 = new JLabel("100000");
        thanhtienlbl2.setFont(f);
        thanhtienlbl2.setPreferredSize(new Dimension(110,30));
        thanhtienlbl2.setHorizontalAlignment(JLabel.RIGHT);
        magglbl1 = new JLabel("Tiền giảm thành viên");
        magglbl1.setPreferredSize(new Dimension(170,30));
        magglbl1.setFont(f);
        maggtxt = new JTextField(10);
        maggtxt.setFont(f);
        maggtxt.setPreferredSize(new Dimension(300,30));
        magglbl2 = new JLabel("1000");
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
        tientratxt.addMouseListener(this);
        tientratxt.addKeyListener(new KeyListener(){
            String input;
            @Override
            public void keyTyped(KeyEvent e) {
               
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode()== 10){
                    try{
                        loadTienthua();
                        tientratxt.setText(df.format(Double.parseDouble(tientratxt.getText())).toString());
                    }catch(Exception ex){
                        tientratxt.setText("");
                        //tientratxt.setFocusable(false);
                        JOptionPane.showMessageDialog(null,"Nhập số tiền khách trả không hợp lệ.Vui lòng thử lại");
                    }
                }
            }
            
        });
        tienthualbl1 = new JLabel("Tiền thừa");
        tienthualbl1.setFont(f);
        tienthualbl1.setPreferredSize(new Dimension(170,30));
        tienthualbl2 = new JLabel("0");
        tienthualbl2.setFont(f);
        tienthualbl2.setPreferredSize(new Dimension(110,30));
        tienthualbl2.setHorizontalAlignment(JLabel.RIGHT);
        goiylbl = new JLabel("Gợi ý mệnh giá");
        goiylbl.setFont(f);
        goiylbl.setPreferredSize(new Dimension(300,30));
        goiylbl1 = new JLabel(df.format(10000));
        goiylbl1.setFont(f2);
        goiylbl1.setBorder(new LineBorder(blue,1,true));
        goiylbl1.setForeground(Color.blue);
        goiylbl1.setOpaque(true);
        goiylbl1.setHorizontalAlignment(JLabel.CENTER);
        goiylbl1.setPreferredSize(new Dimension(90,40));
        goiylbl1.addMouseListener(this);
        goiylbl2 = new JLabel(df.format(20000));
        goiylbl2.setBorder(new LineBorder(blue,1,true));
        goiylbl2.setForeground(Color.blue);
        goiylbl2.setOpaque(true);
        goiylbl2.setHorizontalAlignment(JLabel.CENTER);
        goiylbl2.setPreferredSize(new Dimension(90,40));
        goiylbl2.addMouseListener(this);
        goiylbl3 = new JLabel(df.format(50000));
        goiylbl3.setFont(f2);
        goiylbl3.setBorder(new LineBorder(blue,1,true));
        goiylbl3.setForeground(Color.blue);
        goiylbl3.setOpaque(true);
        goiylbl3.setHorizontalAlignment(JLabel.CENTER);
        goiylbl3.setPreferredSize(new Dimension(90,40));
        goiylbl3.addMouseListener(this);
        goiylbl4 = new JLabel(df.format(100000));
        goiylbl4.setFont(f2);
        goiylbl4.setBorder(new LineBorder(blue,1,true));
        goiylbl4.setForeground(Color.blue);
        goiylbl4.setOpaque(true);
        goiylbl4.setHorizontalAlignment(JLabel.CENTER);
        goiylbl4.setPreferredSize(new Dimension(90,40));
        goiylbl4.addMouseListener(this);
        goiylbl5 = new JLabel(df.format(200000));
        goiylbl5.setFont(f2);
        goiylbl5.setBorder(new LineBorder(blue,1,true));
        goiylbl5.setForeground(Color.blue);
        goiylbl5.setOpaque(true);
        goiylbl5.setHorizontalAlignment(JLabel.CENTER);
        goiylbl5.setPreferredSize(new Dimension(90,40));
        goiylbl5.addMouseListener(this);
        goiylbl6 = new JLabel(df.format(500000));
        goiylbl6.setFont(f2);
        goiylbl6.setBorder(new LineBorder(blue,1,true));
        goiylbl6.setForeground(Color.blue);
        goiylbl6.setOpaque(true);
        goiylbl6.setHorizontalAlignment(JLabel.CENTER);
        goiylbl6.setPreferredSize(new Dimension(90,40));
        goiylbl6.addMouseListener(this);
        goiylbl7 = new JLabel(df.format(50000000));
        goiylbl7.setFont(f2);
        goiylbl7.setBorder(new LineBorder(blue,1,true));
        goiylbl7.setForeground(Color.blue);
        goiylbl7.setOpaque(true);
        goiylbl7.setHorizontalAlignment(JLabel.CENTER);
        goiylbl7.setPreferredSize(new Dimension(280,40));
        goiylbl7.addMouseListener(this);

        infopanel.add(searchbtnkh);
        infopanel.add(infokhlbl1);
        infopanel.add(closebtn);
        infopanel.add(infokhlbl2);
        infopanel.add(tongsl1);
        infopanel.add(tongsl2);
        infopanel.add(thanhtienlbl1);
        infopanel.add(thanhtienlbl2);
        infopanel.add(magglbl1);
        infopanel.add(magglbl2);
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
        functionpanel1.setBounds(0,250,600,40);
        functionpanel1.setBorder(new LineBorder(black,3,true));
        ngaylaplbl = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/calendericon.png")));
        ngaylaplbl.setBounds(5,250,30,40);
        ngaylaptxt = new JLabel(dtf.format(date));
        ngaylaptxt.setBounds(37,250,80,40);
        searchtxt = new JTextField(18);
        searchtxt.setBounds(120,250,150,30);
        searchbtn = new JLabel();
        searchbtn.setBounds(300,250,30,40);
        searchbtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png")));
        searchbtn.addMouseListener(this);
        loai = new JComboBox();
        loai.setBounds(480,250,120,30);
        reloadbtn = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/refreshicon1.png")));
        reloadbtn.setBounds(340,250,30,40);
        reloadbtn.addMouseListener(this);
        
        add(ngaylaplbl);
        add(ngaylaptxt);
        add(searchtxt);
        add(searchbtn);
        add(loai);
        add(reloadbtn);
        
        //panel search
        loaddisplaysp(dssp);
        //searchpanel = new JPanel(new FlowLayout(0,0,0));
        add(displaysp(0));
        //searchpanel.setBounds(0,290,610,270);
        //searchpanel.setBorder(new LineBorder(black,3,true));
        
        
        //panel chuc nang 2
        functionpanel2 = new JPanel(new FlowLayout(1,5,5));
        functionpanel2.setBounds(600,500,300,100);
        functionpanel2.setBorder(new LineBorder(black,3,true));
        historybtn = new JLabel("Xem lịch sử");
        historybtn.setPreferredSize(new Dimension(140,30));
        historybtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/idhd.png")));
        historybtn.setBorder(new LineBorder(green,1,true));
        historybtn.setBounds(700,550,150,45);
        historybtn.setForeground(new Color(255,153,0));
        historybtn.setFont(f);
        historybtn .addMouseListener(this);
        checkoutbtn = new JLabel("Thanh toán");
        checkoutbtn.setForeground(new Color(255,153,0));
        checkoutbtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/checkouticon1.png")));
        checkoutbtn.setBorder(new LineBorder(red,1,true));
        //checkoutbtn.setIcon(checkouticon1);
        checkoutbtn.setPreferredSize(new Dimension(140,30));
        checkoutbtn.setFont(f);
        checkoutbtn.addMouseListener(this);
        functionpanel2.add(checkoutbtn);
        functionpanel2.add(historybtn);
        //panel trang
        pagepanel = new JPanel(new FlowLayout(1,5,5));
        pagepanel.setBounds(200,570,150,40);
        pagepanel.setBorder(new LineBorder(black,1,true));
        prebtn = new JLabel();
        prebtn.setPreferredSize(new Dimension(30,40));
        prebtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/pre.png")));
        prebtn.addMouseListener(this);
        nextbtn = new JLabel();
        nextbtn.setPreferredSize(new Dimension(30,40));
        nextbtn.setIcon(new ImageIcon(this.getClass().getResource("/Icons/next.png")));
        nextbtn.addMouseListener(this);
        pagelbl = new JLabel();
        pagelbl.setText(Integer.toString(page+1));
        pagelbl.setFont(f);
        pagelbl.setPreferredSize(new Dimension(30,40));
        
        pagepanel.add(prebtn);
        pagepanel.add(pagelbl);
        pagepanel.add(nextbtn);
        
        //add panel
       // add(searchpanel);
        add(functionpanel1);
        add(functionpanel2);
        add(infopanel);
        add(pagepanel);
        
    }
    
    public static void loadTienthua(){
        tienthualbl2.setText(df.format(Integer.parseInt(tientratxt.getText())-Integer.parseInt(totallbl2.getText())));
    }
    
    public JPanel displaysp(int page){
        return displaypanel[page];
    }
    
    public void loaddisplaysp(ArrayList<SanphamDTO> arr){
        mangdisplaysp = new ArrayList<SanphamGUI>();
        int page=0,i=0,j=0,k;
        System.out.println(arr.size());
        if(arr.size() % 8 != 0) pagemax +=arr.size()/8+1;
        else pagemax +=arr.size()/8;
        System.out.println(page);
        displaypanel = new JPanel[pagemax];
        while(i<pagemax){
            displaypanel[i] = new JPanel(new FlowLayout(1,5,5));
            displaypanel[i].setBounds(0,290,610,270);
            //displaypanel[i].setPreferredSize(new Dimension(610,270));
            k=0;
            do{
                SanphamGUI displaysp = new SanphamGUI(arr.get(j).getIdsp(),arr.get(j).getTensp(),arr.get(j).getTonkho(),
                        arr.get(j).getDongia(),Integer.parseInt(arr.get(j).getCogiamgia()));
                mangdisplaysp.add(displaysp);
                displaypanel[i].add(displaysp);
                k++;j++;
                if(k == 9) break;
            }while(j != arr.size());
            i++;
        }
    }
    
    public void loadPagepanel(){
        if(pagemax == 1){
            prebtn.setVisible(false);
            nextbtn.setVisible(false);
            pagelbl.setVisible(false);
        }else{
            if(page == 0){
                prebtn.setVisible(false);
                nextbtn.setVisible(true);
            }else if(page == pagemax-1){
                nextbtn.setVisible(false);
                prebtn.setVisible(true);
            }else{
                prebtn.setVisible(true);
                nextbtn.setVisible(true);
                pagelbl.setVisible(true);
            }
        }
    }
    
    public static void loadinfo(int tongsl,int tongtien){
        tongsl2.setText(Integer.toString(tongsl));
        thanhtienlbl2.setText(Integer.toString(tongtien));
        totallbl2.setText(Integer.toString(tongtien-Integer.parseInt(magglbl2.getText())));
        loadTienthua();
        //tienthualbl2.setText(df.format(Integer.parseInt(tientratxt.getText())-tongtien));
        
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
        }else if(e.getSource() == goiylbl1){
            tientratxt.setText(goiylbl1.getText());
        }else if(e.getSource() == goiylbl2){
            tientratxt.setText(goiylbl2.getText());
        }else if(e.getSource() == goiylbl3){
            tientratxt.setText(goiylbl3.getText());
        }else if(e.getSource() == goiylbl4){
            tientratxt.setText(goiylbl4.getText());
        }else if(e.getSource() == goiylbl5){
            tientratxt.setText(goiylbl5.getText());
        }else if(e.getSource() == goiylbl6){
            tientratxt.setText(goiylbl6.getText());
        }else if(e.getSource() == goiylbl7){
            tientratxt.setText(goiylbl7.getText());   
        }else if(e.getSource() == tientratxt){
            tientratxt.setFocusable(true);
        }else if(e.getSource() == goiylbl7){
            tientratxt.setText(goiylbl7.getText());
        }else if(e.getSource() == goiylbl7){
            tientratxt.setText(goiylbl7.getText());
        }else if(e.getSource() == prebtn){
            //page--;
            this.remove(displaysp(page--));
            pagelbl.setText(Integer.toString(page+1));
            this.revalidate();
            this.repaint();
            this.add(displaysp(page));
            loadPagepanel();
            
        }else if(e.getSource() == nextbtn){
            this.remove(displaysp(page++));
            pagelbl.setText(Integer.toString(page+1));
            this.revalidate();
            this.repaint();
            this.add(displaysp(page));
            loadPagepanel();
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
         if(e.getSource() == tientratxt){
            System.out.println("tien tra out");
        }
    }
}
