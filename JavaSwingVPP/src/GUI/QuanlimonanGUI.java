/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.MonanBUS;
import DTO.ComboBoxList;
//import static GUI.ThanhtoanGUI.loaimonan;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import static BUS.MonanBUS.dsmonan;
import DTO.MonanDTO;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class QuanlimonanGUI extends JPanel implements ActionListener,MouseListener,ItemListener{
    private JTable monantable;
    private JLabel idmonlbl,tenmonlbl,idloailbl,dongialbl,foodinfolbl,getsearchlbl,searchlbl,
            searchbtn,addbtn,delbtn,editbtn,refreshbtn,trashbtn,reloadbtn,loaibtn,loaimonanlbl,
            tonkholbl,hyphenlbl,gialbl,searchinfolbl,soldlbl,warehouselbl,loaddatabtn;
    private JTextField idmontxt,tenmontxt,idloaitxt,dongiatxt,searchtxt,gia1txt,gia2txt,
            sold1txt,sold2txt,tonkho1txt,tonkho2txt;
    private JPanel infoPanel1,infoPanel2,functionPanel,tablePanel,searchPanel;
    private Font f = new Font("Arial",Font.BOLD,21);
    private Font f2 = new Font("Arial",Font.PLAIN,18);
    private JComboBox loaimonancb;
    private JCheckBox promotion;
    private String[] category = {"Danh mục tìm kiếm","Theo ID sẩn phẩm","Theo ID loại","Theo tên sẩn phẩm",
        "Theo đơn giá"};
    private String[] monanheader = {"ID món","ID loại","Tên sẩn phẩm","Đơn giá","Tồn kho",
        "S.Lượng đã bán","Giảm giá","",""};
    private JScrollPane jsp;
    private DefaultTableModel monanmodel;
    private boolean promotionselected = false;
    private QuanlimonanGUI home;
    private ArrayList<MonanDTO> dstimkim;
    private int gia1,gia2,tonkho1,tonkho2,sold1,sold2;
    private Icon editicon,removeicon;
    public static String idmon,tenloai,idloai,tenmon,dongia,sldaban,giamgia,tonkho;
    CheckLoi cl = new CheckLoi();
    OverallFrame root;
    public QuanlimonanGUI(){
        init();
    }
    
    public void init(){
        setSize(950,650);
        setLayout(null);
        setBackground(new Color(0, 255, 204));
        //Panel tìm kiếm
        infoPanel1 = new JPanel(new FlowLayout(0,0,15));
        infoPanel2 = new JPanel(new FlowLayout(0,0,15));
        //searchPanel.setBackground(Color.yellow);
        ImageIcon foodinfoicon = new ImageIcon(this.getClass().getResource("/Icons/fridge.png"));
        ImageIcon moneyicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));
        infoPanel1.setBounds(100,60,300,100);
        infoPanel1.setBorder(new LineBorder(black,3,true));
        infoPanel2.setBounds(500,60,310,100);
        infoPanel2.setBorder(new LineBorder(black,3,true));
        foodinfolbl = new JLabel("Quản lí sản phẩm");
        foodinfolbl.setIcon(foodinfoicon);
        foodinfolbl.setFont(new Font("Arial",Font.BOLD,24));
        foodinfolbl.setBounds(350,10,300,50);
        /*idmonlbl = new JLabel("ID Món ăn ");
        idmonlbl.setIcon(mealicon);
        idmonlbl.setFont(f2);
        idmonlbl.setPreferredSize(new Dimension(150,30));
        idmontxt = new JTextField(7);
        idmontxt.setFont(f2);
        idmontxt.setPreferredSize(new Dimension(50,30));
        tenmonlbl = new JLabel("Tên món ăn");
        tenmonlbl.setIcon(mealicon);
        tenmonlbl.setFont(f2);
        tenmonlbl.setPreferredSize(new Dimension(150,30));
        tenmontxt = new JTextField(9);
        tenmontxt.setPreferredSize(new Dimension(50,30));
        idloailbl = new JLabel("ID Loại món");
        idloailbl.setIcon(mealicon);
        idloailbl.setFont(f2);
        idloailbl.setPreferredSize(new Dimension(150,30));
        idloaitxt = new JTextField(7);
        idloaitxt.setPreferredSize(new Dimension(50,30));
        ImageIcon extendsionicon1 = new ImageIcon(this.getClass().getResource("/Icons/extendsion1.png"));
        loaddatabtn = new JLabel(extendsionicon1);
        loaddatabtn.setPreferredSize(new Dimension(35,30));
        loaddatabtn.addMouseListener(this);
        dongialbl = new JLabel("Đơn giá");
        dongialbl.setIcon(moneyicon);
        dongialbl.setFont(f2);
        dongialbl.setPreferredSize(new Dimension(150,30));
        dongiatxt = new JTextField(7);
        dongiatxt.setPreferredSize(new Dimension(150,30));
        
        //infopanel left
        infoPanel1.add(idmonlbl);
        infoPanel1.add(idmontxt);
        infoPanel1.add(tenmonlbl);
        infoPanel1.add(tenmontxt);
        //infopanel right
        infoPanel2.add(idloailbl);
        infoPanel2.add(idloaitxt);
        infoPanel2.add(loaddatabtn);
        infoPanel2.add(dongialbl);
        infoPanel2.add(dongiatxt);
       
        
        /*refreshbtn = new JLabel();
        refreshbtn.setIcon(refreshicon1);
        refreshbtn.setBounds(715,280,35,35);*/

                    
        //functionPanel
        
        //search Panel
        searchPanel = new JPanel(new FlowLayout(1,0,10));
        //searchPanel.setBackground(Color.yellow);
        searchPanel.setBounds(0,100,360,470);
        searchPanel.setBorder(new LineBorder(black,3,true));
        
        ImageIcon infoicon = new ImageIcon(this.getClass().getResource("/Icons/infoicon.png"));
        searchinfolbl = new JLabel("Thông tin tìm kiếm");
        searchinfolbl.setIcon(infoicon);
        searchinfolbl.setFont(f);
        searchinfolbl.setPreferredSize(new Dimension(260,35));
        searchtxt = new JTextField(18);
        searchtxt.setPreferredSize(new Dimension(200,28));
        searchbtn = new JLabel();
        searchbtn.setPreferredSize(new Dimension(30,28));
        ImageIcon searchicon1 = new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png"));
        searchbtn.setIcon(searchicon1);
        searchbtn.addMouseListener(this);
        ImageIcon refreshicon1 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon1.png"));
        reloadbtn = new JLabel(refreshicon1);
        reloadbtn.setPreferredSize(new Dimension(30,28));
        reloadbtn.addMouseListener(this);
        //combobox loại
        ImageIcon loaimonanicon = new ImageIcon(this.getClass().getResource("/Icons/foodcategoryicon.png"));
        loaimonanlbl = new JLabel("Loại sản phẩm");
        loaimonanlbl.setIcon(loaimonanicon);
        loaimonanlbl.setPreferredSize(new Dimension(150,35));
        loaimonanlbl.setFont(f2);
        String a[] = {"Bút","Thước","Sách"};
        loaimonancb = new JComboBox(a);
        loaimonancb.setPreferredSize(new Dimension(130,35));
       /* DefaultComboBoxModel loaicbModel = new DefaultComboBoxModel(); 
        ImageIcon thucanicon = new ImageIcon(this.getClass().getResource("/Icons/thucanicon.png"));
        ImageIcon nuocuongicon = new ImageIcon(this.getClass().getResource("/Icons/nuocuongicon.png"));
        ImageIcon tatcaicon = new ImageIcon(this.getClass().getResource("/Icons/tatcaicon.png"));
        Icon[] loaiicons = {tatcaicon,thucanicon,nuocuongicon};
        for(int i=0;i<loaimonan.length;i++){
            loaicbModel.addElement(new ComboBoxList(loaiicons[i],loaimonan[i]));
        }    
        loaimonancb.setModel(loaicbModel);
        loaimonancb.setRenderer(new ComboBoxRender());*/
        //giá
        ImageIcon hyphenicon = new ImageIcon(this.getClass().getResource("/Icons/hyphenicon.png"));
        ImageIcon giaicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));
        gialbl = new JLabel("Theo đơn giá");
        gialbl.setIcon(giaicon);
        gialbl.setPreferredSize(new Dimension(260,35));
        gialbl.setFont(f2);
        gia1txt = new JTextField(9);
        gia2txt = new JTextField(9);
        hyphenlbl = new JLabel(hyphenicon);
        gia1txt.setFont(f2);
        gia2txt.setFont(f2);
        gia1txt.setHorizontalAlignment(JLabel.CENTER);
        gia2txt.setHorizontalAlignment(JLabel.CENTER);
        gia1txt.setPreferredSize(new Dimension(40,35));
        gia2txt.setPreferredSize(new Dimension(40,35));
        hyphenlbl.setPreferredSize(new Dimension(30,35));
        //sl daban
        ImageIcon soldicon = new ImageIcon(this.getClass().getResource("/Icons/soldicon.png"));
        soldlbl = new JLabel("Số lượng đã bán");
        soldlbl.setIcon(soldicon);
        soldlbl.setPreferredSize(new Dimension(260,35));
        soldlbl.setFont(f2);
        sold1txt = new JTextField(9);
        sold2txt = new JTextField(9);
        sold1txt.setFont(f2);
        sold2txt.setFont(f2);
        sold1txt.setHorizontalAlignment(JLabel.CENTER);
        sold2txt.setHorizontalAlignment(JLabel.CENTER);
        sold1txt.setPreferredSize(new Dimension(40,35));
        sold2txt.setPreferredSize(new Dimension(40,35));
        JLabel hyphenlbl2 = new JLabel(hyphenicon);
        hyphenlbl2.setPreferredSize(new Dimension(30,35));
        //sl kho
        ImageIcon warehouseicon = new ImageIcon(this.getClass().getResource("/Icons/warehouseicon.png"));
        tonkholbl = new JLabel("Số lượng trong kho");
        tonkholbl.setIcon(warehouseicon);
        tonkholbl.setPreferredSize(new Dimension(260,35));
        tonkholbl.setFont(f2);
        tonkho1txt = new JTextField(9);
        tonkho2txt = new JTextField(9);
        tonkho1txt.setFont(f2);
        tonkho2txt.setFont(f2);
        tonkho1txt.setHorizontalAlignment(JLabel.CENTER);
        tonkho2txt.setHorizontalAlignment(JLabel.CENTER);
        tonkho1txt.setPreferredSize(new Dimension(40,35));
        tonkho2txt.setPreferredSize(new Dimension(40,35));
        JLabel hyphenlbl3 = new JLabel(hyphenicon);
        hyphenlbl3.setPreferredSize(new Dimension(30,35));
        
        //checkbox
        ImageIcon giamgiaicon1 = new ImageIcon(this.getClass().getResource("/Icons/saleicon3.png"));
        promotion = new JCheckBox(giamgiaicon1);
        promotion.setPreferredSize(new Dimension(30,28));
        promotion.addItemListener(this);
        //search panel
        searchPanel.add(searchinfolbl);
        searchPanel.add(searchtxt);
        searchPanel.add(searchbtn);
        searchPanel.add(reloadbtn);
        searchPanel.add(promotion);
        searchPanel.add(loaimonanlbl);
        searchPanel.add(loaimonancb);
        searchPanel.add(gialbl);
        searchPanel.add(gia1txt);
        searchPanel.add(hyphenlbl);
        searchPanel.add(gia2txt);
        searchPanel.add(soldlbl);
        searchPanel.add(sold1txt);
        searchPanel.add(hyphenlbl2);
        searchPanel.add(sold2txt);
        searchPanel.add(tonkholbl);
        searchPanel.add(tonkho1txt);
        searchPanel.add(hyphenlbl3);
        searchPanel.add(tonkho2txt);

        //table list tìm kiếm
        ImageIcon searchlbl2 = new ImageIcon(this.getClass().getResource("/Icons/searchlbl2.png"));
        JLabel searchlbl1 = new JLabel("Danh sách sản phẩm");
        searchlbl1.setIcon(searchlbl2);
        searchlbl1.setBounds(480,100,300,35);
        searchlbl1.setFont(f);

        DefaultTableModel model = new DefaultTableModel(monanheader,0);
        monantable = new JTable(model);
        monantable.setSelectionBackground(Color.yellow);
        monantable.getTableHeader().setOpaque(false);
        //searchtable.getColumnModel().getColumn(3).setPreferredWidth(30);
        //searchtable.getColumnModel().getColumn(4).setPreferredWidth(15);
        //monantable.getColumnModel().getColumn(5).setPreferredWidth(20);
        /*DefaultTableCellRenderer align = new DefaultTableCellRenderer();
        align.setHorizontalAlignment(JLabel.CENTER);
        searchtable.getColumnModel().getColumn(0).setCellRenderer(align);
        searchtable.getColumnModel().getColumn(2).setCellRenderer(align);
        searchtable.getColumnModel().getColumn(3).setCellRenderer(align);
        searchtable.getColumnModel().getColumn(1).setCellRenderer(align);
        searchtable.addMouseListener(this);*/

        //searchtable.setEnabled(false);
        //searchtable.setRowSelectionAllowed(true)
        monantable.setRowHeight(35);
        jsp = new JScrollPane(monantable);
        //jsp.setViewportView(monantable);
        //searchjsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //searchjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(360,140,570,390);
        jsp.setBorder(new LineBorder(black,3,true));

       //fuinction panel
        functionPanel = new JPanel(new FlowLayout(1,20,0));
        functionPanel.setBounds(550,540,400,40);
        ImageIcon trashicon1 = new ImageIcon(this.getClass().getResource("/Icons/trashicon1.png"));
        trashbtn = new JLabel("Thùng rác");
        trashbtn.setIcon(trashicon1);
        trashbtn.setPreferredSize(new Dimension(100,35));
        trashbtn.addMouseListener(this);
        ImageIcon addicon1= new ImageIcon(this.getClass().getResource("/Icons/addicon1.png"));
        addbtn = new JLabel("Thêm món ăn");
        addbtn.setIcon(addicon1);
        addbtn.setPreferredSize(new Dimension(150,35));
        addbtn.setFont(f2);
        addbtn.addMouseListener(this);

        //functionPanel.add(addbtn);
        functionPanel.add(trashbtn);
        //thêm panel
        add(foodinfolbl);
        add(searchPanel);
        add(searchlbl1);
        add(functionPanel);
        add(jsp);
        loadDsmonan();
    }
    
    public void itemStateChanged(ItemEvent e){
        ImageIcon giamgiaicon2 = new ImageIcon(this.getClass().getResource("/Icons/saleicon4.png"));
        if(promotion.isSelected()){
            promotion.setSelectedIcon(giamgiaicon2);
            promotionselected = true;
        }
    }
    
    public void loadDsmonan(){
        removeicon = new ImageIcon(this.getClass().getResource("/Icons/removeicon.png"));
        editicon = new ImageIcon(this.getClass().getResource("/Icons/editicon.png"));
        monanmodel = new DefaultTableModel(monanheader,0){
            public boolean isCellEditable(int row,int col){
                if(col == 7 || col == 8){
                    return true;
                }else return false;
            }
        };
        monantable.setModel(monanmodel);
        monantable.getColumnModel().getColumn(7).setCellEditor(new EditButtonRender(monantable));
        monantable.getColumnModel().getColumn(7).setCellRenderer(new EditButtonRender(monantable));
        monantable.getColumnModel().getColumn(8).setCellEditor(new RemoveButtonRenderMonan(monantable));
        monantable.getColumnModel().getColumn(8).setCellRenderer(new RemoveButtonRenderMonan(monantable));
        //searchtable.getColumnModel().getColumn(8).setCellEditor(new EditButtonRender(searchtable));
        //searchtable.getColumnModel().getColumn(8).setCellRenderer(new EditButtonRender(searchtable));
        MonanBUS bus = new MonanBUS();
        if(dsmonan == null) bus.docDsmonan();
        for(MonanDTO monan : dsmonan){
            if(monan.trangthai.equals("1")){
                Object [] data = {monan.getIdmon(),monan.getIdloai(),monan.getTenmon(),monan.getDongia(),
                     monan.getTonkho(),monan.getSoluongdaban(),monan.getCogiamgia(),editicon,removeicon};
                if(monan.cogiamgia.equals("1")){
                    data[6] = "Có";
                }else{
                    data[6] = "Không";
                }
                monanmodel.addRow(data);
            }
        }
        monantable.getColumnModel().getColumn(0).setPreferredWidth(70);
        monantable.getColumnModel().getColumn(1).setPreferredWidth(70);
        monantable.getColumnModel().getColumn(2).setPreferredWidth(150);
        monantable.getColumnModel().getColumn(5).setPreferredWidth(130);
        monantable.getColumnModel().getColumn(7).setPreferredWidth(50);
        monantable.getColumnModel().getColumn(8).setPreferredWidth(50);
        
    }
    
    public void themMonan(String idmon,String idloai,String tenmon,String dongia){
        Object[] data = {idmon,idloai,tenmon,dongia,"0","0","Không",editicon,removeicon};
        monanmodel.addRow(data);
    }
    public static void main(String[] args) {
        QuanlimonanGUI a = new QuanlimonanGUI();
        a.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==addbtn){
            Addformdialog a = new Addformdialog(root,true);
            a.setVisible(true);
            if(!a.isVisible()){
                if(!dongia.equals("") && !tenmon.equals("")){
                    themMonan(idmon,idloai,tenmon,dongia);
                }
            }
        }else if(e.getSource()==searchbtn){
            MonanBUS bus = new MonanBUS();
            String dkkm;
            String search = searchtxt.getText();
            String loaimon = ((ComboBoxList)loaimonancb.getSelectedItem()).getName();
            if(promotion.isSelected()){
                dkkm = "1";
            }else{
                dkkm = "0";
            }
            if((gia1txt.getText().equals("")) || (gia2txt.getText().equals(""))
               || (sold1txt.getText().equals("")) || (gia2txt.getText().equals("")) 
               || (tonkho1txt.getText().equals("")) || (tonkho2txt.getText().equals(""))){
                JOptionPane.showConfirmDialog(null,"Vui lòng điền hết thông tin vào các ô trống","Cảnh báo",JOptionPane.WARNING_MESSAGE);
            }else if(cl.kiemtraSophay(gia1txt.getText()) == false || cl.kiemtraSophay(gia2txt.getText()) == false){
                        JOptionPane.showMessageDialog(null,"Vui long nhap so nguyen",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }
                        else if(cl.kiemtraSokitu(gia1txt.getText(), 11) == false || cl.kiemtraSokitu(gia2txt.getText(), 11) == false){
                        JOptionPane.showMessageDialog(null,"Gia khong duoc vuot qua 11 so",
                            "Cảnh báo",JOptionPane.WARNING_MESSAGE);
            }else{
               try{
                    gia1 = Integer.parseInt(gia1txt.getText());
                    gia2 = Integer.parseInt(gia2txt.getText());
                }catch(NumberFormatException err){
                    JOptionPane.showConfirmDialog(null,"Vui lòng nhập số vào đơn giá","Cảnh báo",JOptionPane.WARNING_MESSAGE);
                } 
                try{
                    sold1 = Integer.parseInt(gia1txt.getText());
                    sold2 = Integer.parseInt(gia2txt.getText());
                }catch(NumberFormatException err){
                    JOptionPane.showConfirmDialog(null,"Vui lòng nhập số vào số lượng đã bán","Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }    
                try{
                    tonkho1 = Integer.parseInt(gia1txt.getText());
                    tonkho2 = Integer.parseInt(gia2txt.getText());
                }catch(NumberFormatException err){
                    JOptionPane.showConfirmDialog(null,"Vui lòng nhập số vào số lượng trong kho","Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }  
                if((gia1 > gia2) || (sold1 > sold2) || (tonkho1 > tonkho2)){
                JOptionPane.showMessageDialog(null,"Ô trước phải nhỏ hơn ô sau",
                        "Cảnh báo",JOptionPane.WARNING_MESSAGE);
                }else{
                    dstimkim = bus.search2(search,loaimon,gia1,gia2,sold1,sold2,tonkho1,tonkho2,dkkm);
                    if(dstimkim.size()==0){ 
                        JOptionPane.showMessageDialog(null,"Không tìm thấy kết quả phù hợp");
                    }else{
                        monanmodel = new DefaultTableModel(monanheader,0){
                        public boolean isCellEditable(int row,int col){
                            if(col == 7 || col == 8){
                                return true;
                                }else return false;
                            }
                        };
                        monantable.setModel(monanmodel);
                        monantable.getColumnModel().getColumn(7).setCellEditor(new EditButtonRender(monantable));
                        monantable.getColumnModel().getColumn(7).setCellRenderer(new EditButtonRender(monantable));
                        monantable.getColumnModel().getColumn(8).setCellEditor(new RemoveButtonRenderMonan(monantable));
                        monantable.getColumnModel().getColumn(8).setCellRenderer(new RemoveButtonRenderMonan(monantable));
                        //searchtable.getColumnModel().getColumn(8).setCellEditor(new EditButtonRender(searchtable));
                        //searchtable.getColumnModel().getColumn(8).setCellRenderer(new EditButtonRender(searchtable));
                        if(dsmonan == null) bus.docDsmonan();
                        for(MonanDTO monan : dstimkim){
                            if(monan.trangthai.equals("1")){
                                Object [] data = {monan.getIdmon(),monan.getIdloai(),monan.getTenmon(),monan.getDongia(),
                                     monan.getTonkho(),monan.getSoluongdaban(),monan.getCogiamgia(),editicon,removeicon};
                                if(monan.cogiamgia.equals("1")){
                                    data[6] = "Có";
                                }else{
                                    data[6] = "Không";
                                }
                                monanmodel.addRow(data);
                            }
                        }
                        monantable.getColumnModel().getColumn(0).setPreferredWidth(70);
                        monantable.getColumnModel().getColumn(1).setPreferredWidth(70);
                        monantable.getColumnModel().getColumn(2).setPreferredWidth(150);
                        monantable.getColumnModel().getColumn(5).setPreferredWidth(130);
                        monantable.getColumnModel().getColumn(7).setPreferredWidth(50);
                        monantable.getColumnModel().getColumn(8).setPreferredWidth(50);
                    } 
                }
            }
        }else if(e.getSource()== trashbtn){
            Thungracdialog dialog = new Thungracdialog();
            dialog.setVisible(true);
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
        if(e.getSource() == searchbtn){
            ImageIcon searchicon2 = new ImageIcon(this.getClass().getResource("/Icons/searchicon2.png"));
            searchbtn.setIcon(searchicon2);
        }else if(e.getSource() == reloadbtn){
            ImageIcon refreshicon2 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon2.png"));
            reloadbtn.setIcon(refreshicon2);
        }else if(e.getSource()== addbtn){
            ImageIcon addicon2 = new ImageIcon(this.getClass().getResource("/Icons/addicon2.png"));
            addbtn.setIcon(addicon2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(e.getSource() == searchbtn){
            ImageIcon searchicon1 = new ImageIcon(this.getClass().getResource("/Icons/searchicon1.png"));
            searchbtn.setIcon(searchicon1);
        }else if(e.getSource() == reloadbtn){
            ImageIcon refreshicon1 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon1.png"));
            reloadbtn.setIcon(refreshicon1);
        }else if(e.getSource()== addbtn){
            ImageIcon addicon1 = new ImageIcon(this.getClass().getResource("/Icons/addicon1.png"));
            addbtn.setIcon(addicon1);
        }
    }
}
