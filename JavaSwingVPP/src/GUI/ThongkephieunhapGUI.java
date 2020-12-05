/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoadonBUS;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import DTO.MonanDTO;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static BUS.HoadonBUS.dshoadon;
import BUS.phieunhapBUS;
import DTO.HoadonDTO;
import DTO.phieunhapDTO;
import com.toedter.calendar.JTextFieldDateEditor;
import static BUS.phieunhapBUS.dspn1;
/**
 *
 * @author USER
 */
public class ThongkephieunhapGUI extends JPanel implements ActionListener,MouseListener,ItemListener{
    private JTable datatable;
    private JLabel infolbl,searchinfolbl,searchbtn,reloadbtn,ngaylaplbl,hyphenlbl,hyphenlbl1,
            tongtienlbl,infolbl2,idhdlbl,idnvlbl,tongtienlbl2,soldlbl,datelbl,datatablelbl,tongtiendetail,
            idhddetail,idnvdetail,solddetail,datedetail,soldlbl2,solddetail2,idncclbl,idnccdetail,idpnlbl,idpndetail;
    private JTextField idmontxt,tenmontxt,idloaitxt,dongiatxt,searchtxt,ngay1txt,ngay2txt,tien1txt,tien2txt,
            sold1txt,sold2txt,tonkho1txt,tonkho2txt,ngaylap2txt,ngaylap1txt,idncctxt;
    private JPanel infoPanel,tablePanel,searchPanel;
    private Font f = new Font("Arial",Font.BOLD,21);
    private Font f2 = new Font("Arial",Font.PLAIN,18);
    private JComboBox categorycb;
    private JCheckBox promotion;
    private String[] category = {"Tất cả","Theo IDPN","Theo IDNCC","Theo IDNV","Theo ngày lập",
        "Theo tổng tiền"};
    private String[] phieunhapheader = {"IDPN","IDNCC","IDNV","Ngày lập","Tổng tiền"};
    private String[] detailheader = {"IDPN","ID món","Số lượng","Giá nhập","Thành tiền"};
    private JScrollPane jsp;
    private DefaultTableModel datamodel;
    private ArrayList<MonanDTO> dstimkim;
    private int gia1,gia2,tonkho1,tonkho2,sold1,sold2,sl,tongtien,slsp,slnv,slid,slncc;
    private JDateChooser ngaylap1,ngaylap2;
    //private Icon editicon,removeicon;
    //public static String idmon,tenloai,idloai,tenmon,dongia,sldaban,giamgia,tonkho;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<String> dsidnv,dsngaylap,dsidpn,dsncc;
    private static String ngaylap,idnv,ncc;
    private String datemin,datemax,idpn,ngay1,ngay2,idncc;
    private ImageIcon datatableicon,detailicon,idhdicon,idnvicon1,idnvicon2,dateicon,
            soldicon1,tienicon,soldicon2;
    
    public ThongkephieunhapGUI(){
        init();
    }
    
    public void init(){
        setSize(950,650);
        setLayout(null);
        setBackground(new Color(0,255,204));
        //Panel tìm kiếm

        //searchPanel.setBackground(Color.yellow);
        ImageIcon foodinfoicon = new ImageIcon(this.getClass().getResource("/Icons/thongkelbl.png"));

        infolbl = new JLabel("Thống kê phiếu nhập");
        infolbl.setIcon(foodinfoicon);
        infolbl.setFont(new Font("Arial",Font.BOLD,24));
        infolbl.setForeground(new Color(255,51,0));
        infolbl.setBounds(350,10,300,50);
       
        searchPanel = new JPanel(new FlowLayout(1,0,15));
        //searchPanel.setBackground(Color.yellow);
        searchPanel.setBounds(400,50,500,200);
        searchPanel.setBackground(new Color(0,255,204));
       //searchPanel.setBorder(new LineBorder(black,3,true));
        
        ImageIcon infoicon = new ImageIcon(this.getClass().getResource("/Icons/infoicon.png"));
        searchinfolbl = new JLabel("Thông tin tìm kiếm");
        searchinfolbl.setIcon(infoicon);
        searchinfolbl.setForeground(new Color(255,51,0));
        searchinfolbl.setFont(f);
        searchinfolbl.setPreferredSize(new Dimension(400,35));
        searchtxt = new JTextField(18);
        searchtxt.setPreferredSize(new Dimension(200,28));
        searchtxt.setEditable(false);
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
        categorycb = new JComboBox(category);
        categorycb.setPreferredSize(new Dimension(120,28));
        categorycb.addItemListener(this);
        //ngày
        ImageIcon hyphenicon = new ImageIcon(this.getClass().getResource("/Icons/hyphenicon.png"));
        dateicon = new ImageIcon(this.getClass().getResource("/Icons/calendericon.png"));
        ngaylaplbl = new JLabel("Theo ngày lập");
        ngaylaplbl.setIcon(dateicon);
        ngaylaplbl.setPreferredSize(new Dimension(180,30));
        ngaylaplbl.setFont(f2);
        ngaylap1 = new JDateChooser();
        ngaylap1.setForeground(red);
        ngaylap1.setDateFormatString("yyyy-MM-dd");
        ngaylap1.setPreferredSize(new Dimension(100,25));
        ngaylap2 = new JDateChooser();
        ngaylap2.setForeground(red);
        ngaylap2.setDateFormatString("yyyy-MM-dd");
        ngaylap2.setPreferredSize(new Dimension(100,25));
        hyphenlbl = new JLabel(hyphenicon);
        hyphenlbl.setPreferredSize(new Dimension(40,30));
        
        // tiền
        ImageIcon giaicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));
        tongtienlbl = new JLabel("Theo tổng tiền");
        tongtienlbl.setIcon(giaicon);
        tongtienlbl.setPreferredSize(new Dimension(190,35));
        tongtienlbl.setFont(f2);
        tien1txt = new JTextField(8);
        tien1txt.setPreferredSize(new Dimension(40,30));
        tien2txt = new JTextField(8);
        tien2txt.setPreferredSize(new Dimension(40,30));
        hyphenlbl1 = new JLabel(hyphenicon);
        hyphenlbl1.setPreferredSize(new Dimension(40,30));
      
        //search panel
        searchPanel.add(searchinfolbl);
        searchPanel.add(categorycb);
        searchPanel.add(searchtxt);
        searchPanel.add(searchbtn);
        searchPanel.add(reloadbtn);
        searchPanel.add(ngaylaplbl);
        searchPanel.add(ngaylap1);
        searchPanel.add(hyphenlbl);
        searchPanel.add(ngaylap2);
        searchPanel.add(tongtienlbl);
        searchPanel.add(tien1txt);
        searchPanel.add(hyphenlbl1);
        searchPanel.add(tien2txt);
        

        //table list tìm kiếm
        datatableicon = new ImageIcon(this.getClass().getResource("/Icons/datatable.png"));
        
        datatablelbl = new JLabel("Bảng thống kê phiếu nhập");
        datatablelbl.setIcon(datatableicon);
        datatablelbl.setForeground(new Color(255,51,0));
        datatablelbl.setBounds(480,280,330,40);
        datatablelbl.setFont(f);

        DefaultTableModel model = new DefaultTableModel(phieunhapheader,0);
        datatable = new JTable(model);
        datatable.getTableHeader().setOpaque(false);
        datatable.setRowHeight(30);
        jsp = new JScrollPane(datatable);
        //jsp.setViewportView(monantable);
        //searchjsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //searchjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(360,320,570,220);
        //jsp.setBorder(new LineBorder(black,3,true));

        //infoPanel
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(1,10,10));
        infoPanel.setBounds(0,0,360,650);
        //infoPanel.setBorder(new LineBorder(Color.black,3,true));
        
        detailicon = new ImageIcon(this.getClass().getResource("/Icons/detaildata.png"));
        tienicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));
        idnvicon1 = new ImageIcon(this.getClass().getResource("/Icons/usericon.png"));
        idnvicon2 = new ImageIcon(this.getClass().getResource("/Icons/datatable.png"));
        idhdicon = new ImageIcon(this.getClass().getResource("/Icons/idhd.png"));
        soldicon1 = new ImageIcon(this.getClass().getResource("/Icons/soldicon.png"));
        soldicon2 = new ImageIcon(this.getClass().getResource("/Icons/soldicon2.png"));
        tienicon = new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png"));

        infolbl2 = new JLabel("Chi tiết bảng thống kê");
        infolbl2.setPreferredSize(new Dimension(250,40));
        infolbl2.setFont(f2);
        infolbl2.setForeground(new Color(255,51,0));
        infolbl2.setIcon(detailicon);
        idpnlbl = new JLabel("Số phiếu nhập đã lập");
        idpnlbl.setPreferredSize(new Dimension(250,30));
        idpnlbl.setFont(f2);
        idpnlbl.setForeground(new Color(255,153,0));
        idpnlbl.setIcon(idhdicon);
        idpndetail = new JLabel();
        idpndetail.setPreferredSize(new Dimension(250,30));
        idpndetail.setFont(f2);
        idncclbl = new JLabel("Số nhà cung cấp");
        idncclbl.setPreferredSize(new Dimension(250,30));
        idncclbl.setForeground(new Color(255,153,0));
        idncclbl.setFont(f2);
        idncclbl.setIcon(idnvicon1);
        idnccdetail = new JLabel();
        idnccdetail.setPreferredSize(new Dimension(250,30));
        idnccdetail.setFont(f2);
        idnvlbl = new JLabel("Số NV nhập phiếu");
        idnvlbl.setForeground(new Color(255,153,0));
        idnvlbl.setPreferredSize(new Dimension(250,30));
        idnvlbl.setFont(f2);
        idnvlbl.setIcon(idnvicon1);
        idnvdetail = new JLabel();
        idnvdetail.setPreferredSize(new Dimension(250,30));
        idnvdetail.setFont(f2);
        tongtienlbl2 = new JLabel("Tổng tiền");
        tongtienlbl2.setForeground(new Color(255,153,0));
        tongtienlbl2.setPreferredSize(new Dimension(250,30));
        tongtienlbl2.setFont(f2);
        tongtienlbl2.setIcon(tienicon);
        tongtiendetail = new JLabel();
        tongtiendetail.setPreferredSize(new Dimension(250,30));
        tongtiendetail.setFont(f2);
        datelbl = new JLabel("Ngày lập phiếu nhập");
        datelbl.setForeground(new Color(255,153,0));
        datelbl.setPreferredSize(new Dimension(250,30));
        datelbl.setFont(f2);
        datelbl.setIcon(dateicon);
        datedetail = new JLabel();
        datedetail.setPreferredSize(new Dimension(250,30));
        datedetail.setFont(f2);
        soldlbl = new JLabel();
        soldlbl.setPreferredSize(new Dimension(250,30));
        soldlbl.setFont(f2);
        solddetail = new JLabel();
        solddetail.setPreferredSize(new Dimension(250,30));
        solddetail.setFont(f2);
        soldlbl2 = new JLabel();
        soldlbl2.setPreferredSize(new Dimension(250,30));
        soldlbl2.setFont(f2);
        solddetail2 = new JLabel();
        solddetail2.setPreferredSize(new Dimension(250,30));
        solddetail2.setFont(f2);
        
        infoPanel.setBackground(new Color(0,255,204));
        infoPanel.add(infolbl2);
        infoPanel.add(idpnlbl);
        infoPanel.add(idpndetail);
        infoPanel.add(idncclbl);
        infoPanel.add(idnccdetail);
        infoPanel.add(idnvlbl);
        infoPanel.add(idnvdetail);
        infoPanel.add(tongtienlbl2);
        infoPanel.add(tongtiendetail);
        infoPanel.add(datelbl);
        infoPanel.add(datedetail);
        infoPanel.add(soldlbl);
        infoPanel.add(solddetail);
        infoPanel.add(soldlbl2);
        infoPanel.add(solddetail2);
        
        //thêm panel
        add(infolbl);
        add(searchPanel);
        add(datatablelbl);
        add(jsp);
        add(infoPanel);
        loadDsphieunhap();
        System.out.println(dspn1);
        editDate();
    }

    public void loadDsphieunhap(){
        datamodel = new DefaultTableModel(phieunhapheader,0){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        datatable.setModel(datamodel);
        datatable.setSelectionBackground(Color.yellow);
        datatable.addMouseListener(this);
        phieunhapBUS bus = new phieunhapBUS();
        if(dspn1 == null) bus.docPhieunhap();
        phieunhapDTO pn = new phieunhapDTO();
        if(dspn1.size()>0){
            for(int i=0;i<dspn1.size();i++){
                pn = dspn1.get(i);
                if(i == dspn1.size()-1){
                    Object [] data = {pn.getIdpn(),pn.getIdncc(),pn.getIdnv(),pn.getNgaynhap(),pn.getTongtien()};
                    datamodel.addRow(data);
                }else{
                    if(!pn.getIdpn().equals(dspn1.get(i+1).getIdpn())){
                        Object [] data = {pn.getIdpn(),pn.getIdncc(),pn.getIdnv(),pn.getNgaynhap(),pn.getTongtien()};
                        datamodel.addRow(data);
                    }
                }
            }
        loadDetail();
        }
    }
        /*monantable.getColumnModel().getColumn(0).setPreferredWidth(70);
        monantable.getColumnModel().getColumn(1).setPreferredWidth(70);
        monantable.getColumnModel().getColumn(2).setPreferredWidth(150);
        monantable.getColumnModel().getColumn(5).setPreferredWidth(130);
        monantable.getColumnModel().getColumn(7).setPreferredWidth(50);
        monantable.getColumnModel().getColumn(8).setPreferredWidth(50);*/
        
    //}
    public void loadDetailPhieunhap(String idpn){
        ImageIcon detailhd = new ImageIcon(this.getClass().getResource("/Icons/detailhd.png")); 
        datatablelbl.setText("Chi tiết phiếu nhập");
        infolbl2.setText("Thống kê chi tiết");
        idpnlbl.setText("IDPN");
        datatablelbl.setIcon(detailhd);
        datamodel = new DefaultTableModel(detailheader,0){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        datatable.setModel(datamodel);
        for(phieunhapDTO pn : dspn1){
            if(idpn.equals(pn.getIdpn())){
                 Object [] data = {pn.getIdpn(),pn.getIdmon(),pn.getSoluong(),pn.getGianhap(),pn.getThanhtien()};
                    datamodel.addRow(data);
            }
        }
        datatable.removeMouseListener(this);
        datatable.setSelectionBackground(Color.white);
        loadDetailTable();
    }

    public void loadDetail(){
        ArrayList<String> dsidpn = new ArrayList();
        ArrayList<String> dsidnv = new ArrayList();
        ArrayList<String> dsngaylap = new ArrayList();
        ArrayList<String> dsncc = new ArrayList();
        tongtien=0;
        boolean trung;
        for(int i=0;i<datatable.getRowCount();i++){
            dsidpn.add(datatable.getValueAt(i,0).toString());
            String idnv = datatable.getValueAt(i,2).toString();
            String ncc = datatable.getValueAt(i,1).toString();
            if(dsncc.size()==0){ 
                dsncc.add(ncc);
            }else{
                trung = false;
                for(int j=0;j<dsncc.size();j++){
                    if(ncc.equals(dsncc.get(j))){
                        trung = true;
                        break;
                    }
                }
                if(trung == false) dsncc.add(ncc);
            }

           if(dsidnv.size()==0){ 
                dsidnv.add(idnv);
            }else{
                trung = false;
                for(int j=0;j<dsidnv.size();j++){
                    if(idnv.equals(dsidnv.get(j))){
                        trung = true;
                        break;
                    }
                }
                if(trung == false) dsidnv.add(idnv);
            }
            tongtien += Float.parseFloat(datatable.getValueAt(i,4).toString());
            //sl += Integer.parseInt(datatable.getValueAt(i,4).toString());
            dsngaylap.add(datatable.getValueAt(i,3).toString());
        }
        slncc = dsncc.size();
        slnv = dsidnv.size();
        slid = dsidpn.size();
        if(dsidpn.size()==1){
            idpndetail.setText("1 phiếu("+dsidpn.get(0)+")");
        }else{
            String id1 = getIDmin(dsidpn);
            String id2 = getIDmax(dsidpn);
            idpndetail.setText(slid+" phiếu("+id1+" => "+id2+")");
        }
        idnccdetail.setText(Integer.toString(slncc) +" nhà cung cấp");
        idnvdetail.setText(Integer.toString(slnv) +" người");
        tongtiendetail.setText(tongtien+" VND");
        //solddetail.setText(sl+ " Sản phẩm");
        if(dsngaylap.size()==1){
            datedetail.setText(dsngaylap.get(0));
        }else if(dsngaylap.size()>2){
            String date1 = getDatemin(dsngaylap);
            String date2 = getDatemax(dsngaylap);
            datedetail.setText(date1+" => "+ date2);
        }else{
            datedetail.setText(dsngaylap.get(0));
        }
        datatablelbl.setText("Bảng thống kê phiếu nhập");
        infolbl2.setText("Chi tiết bảng thống kê");
        idpnlbl.setText("Số phiếu nhập đã lập");
        idnvlbl.setText("Số NV lập phiếu nhập");
        tongtienlbl2.setText("Tổng tiền");
        idncclbl.setText("Số NV lập phiếu nhập");
        soldlbl.setText("");
        soldlbl2.setText("");
        solddetail.setText("");
        solddetail2.setText("");
        soldlbl2.setIcon(null); 
        soldlbl.setIcon(null); 
    }
    
    public void loadDetailTable(){
        ArrayList<String> dssp = new ArrayList();
        tongtien=0;
        sl=0;
        boolean trung=false;
        for(int i=0;i<datatable.getRowCount();i++){
            idpn = datatable.getValueAt(i,0).toString();
            String sanpham = datatable.getValueAt(i,1).toString();
            if(dssp.size()==0){ 
                dssp.add(sanpham);
            }else{
                for(int j=0;j<dssp.size();j++){
                    if(sanpham.equals(dssp.get(j))){
                        trung=true;
                        break;
                    }
                }
                if(trung== false) dssp.add(sanpham);
            }
            sl += Integer.parseInt(datatable.getValueAt(i,2).toString());
            tongtien += Float.parseFloat(datatable.getValueAt(i,4).toString());
        }
        idncclbl.setText("Nhà cung cấp");
        idnccdetail.setText(ncc);
        slsp = dssp.size();
        idpndetail.setText(idpn);
        idnvlbl.setText("IDNV lập phiếu nhập");
        idnvdetail.setText(idnv);
        tongtienlbl2.setText("Tổng tiền");
        tongtiendetail.setText(Integer.toString(tongtien)+" VND");
        soldlbl.setText("S.Lượng sản phẩm nhập");
        solddetail.setText(Integer.toString(sl)+ " món");
        soldlbl.setIcon(soldicon1);
        datedetail.setText(ngaylap);
        soldlbl2.setText("Số sản phẩm nhập");
        soldlbl2.setIcon(soldicon2);
        solddetail2.setText(Integer.toString(slsp)+" sản phẩm");
    }
    
    public String getIDmax(ArrayList<String> ds){
        String id;
        int max;
        String first = ds.get(0).substring(0,2);
        max = Integer.parseInt(ds.get(0).substring(2));
        for(int i = 0;i<ds.size();i++){
            int idnext = Integer.parseInt(ds.get(i).substring(2));
            if(idnext > max){
                max = idnext;
            }
        }
        id = first + Integer.toString(max);
        return id;
    }
    
    public String getIDmin(ArrayList<String> ds){
        String id;
        int min;
        String first = ds.get(0).substring(0,2);
        min = Integer.parseInt(ds.get(0).substring(2));
        for(int i = 0;i<ds.size();i++){
            int idnext = Integer.parseInt(ds.get(i).substring(2));
            if(idnext < min){
                min = idnext;
            }
        }
        id = first + Integer.toString(min);
        return id;
    }
    
    public String getDatemin(ArrayList<String> ds){
       datemin = ds.get(0);
        for(int i = 0;i<ds.size();i++){
            if(datemin.compareTo(ds.get(i)) > 0)
                datemin = ds.get(i);
        }
        return datemin;
    }
    
    public String getDatemax(ArrayList<String> ds){
        datemax = ds.get(0);
        for(int i = 0;i<ds.size();i++){
            if(datemax.compareTo(ds.get(i)) < 0)
                datemax = ds.get(i);
        }
        return datemax;
    }
    
    public void editDate(){
        ngaylap1txt = (JTextFieldDateEditor) ngaylap1.getDateEditor();
        ngaylap1txt.setEditable(false);
        ngaylap2txt = (JTextFieldDateEditor) ngaylap2.getDateEditor();
        ngaylap2txt.setEditable(false);
    }
    
    public void search(String searchstr,String dateStart,String dateEnd,int gia1,int gia2){
        phieunhapBUS bus = new phieunhapBUS();
        ArrayList<phieunhapDTO> dstimkim = new ArrayList();
        ArrayList<String> dsid = new ArrayList();
        phieunhapDTO pn = new phieunhapDTO();
        dstimkim = bus.search(searchstr,dateStart,dateEnd,gia1,gia2);
        sl=0;
        if(dstimkim.size()==0){
            JOptionPane.showMessageDialog(null,"Không tìm thấy kết quả phù hợp");
        }else{
            datatablelbl.setText("Bảng thống kê phiếu nhập");
            datatablelbl.setIcon(datatableicon);
            datamodel = new DefaultTableModel(phieunhapheader,0){
                public boolean isCellEditable(int row,int col){
                    return false;
                    }
                };
            datatable.setModel(datamodel);
            slid=1;
            String idpn = dstimkim.get(0).getIdpn();
            for(int i=1;i<dstimkim.size()-1;i++){
                if(!idpn.equals(dstimkim.get(i).getIdpn())){
                    slid++;
                }
            }
            if(slid==1){
                pn = dstimkim.get(0);
                Object [] data = {pn.getIdpn(),pn.getIdncc(),pn.getIdnv(),pn.getNgaynhap(),pn.getTongtien()};
                datamodel.addRow(data);
            }else{
                for(int i=0;i<dstimkim.size()-1;i++){
                    pn = dspn1.get(i);
                    if(i == dspn1.size()-1){
                        Object [] data = {pn.getIdpn(),pn.getIdncc(),pn.getIdnv(),pn.getNgaynhap(),pn.getTongtien()};
                        datamodel.addRow(data);
                    }else{
                        if(!pn.getIdpn().equals(dspn1.get(i+1).getIdpn())){
                            Object [] data = {pn.getIdpn(),pn.getIdncc(),pn.getIdnv(),pn.getNgaynhap(),pn.getTongtien()};
                            datamodel.addRow(data);
                        }
                    }
                }
            }
            loadDetail();
        }
    }

    public static void main(String[] args) {
        ThongkephieunhapGUI a = new ThongkephieunhapGUI();
        a.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==categorycb){
            dsidpn = new ArrayList();
            dsidnv = new ArrayList();
            dsncc = new ArrayList();
            phieunhapDTO pn = new phieunhapDTO();
            boolean trung;
            dsidpn.add(dspn1.get(0).getIdpn());
            dsidnv.add(dspn1.get(0).getIdnv());
            dsncc.add(dspn1.get(0).getIdncc());
            for(int i=0;i<dspn1.size();i++){
                trung = false;
                pn = dspn1.get(i);
                for(int j=0;j<dsidpn.size();j++){
                    if(pn.getIdpn().equals(dsidpn.get(j))){
                        trung = true;
                        break;
                    }
                }
                if(trung == false) dsidpn.add(pn.getIdpn());
            } 
            for(int i=0;i<dspn1.size();i++){
                trung = false;
                pn = dspn1.get(i);
                for(int j=0;j<dsidnv.size();j++){
                    if(pn.getIdnv().equals(dsidnv.get(j))){
                        trung = true;
                        break;
                    }
                }
                if(trung == false) dsidnv.add(pn.getIdnv());
            } 
            for(int i=0;i<dspn1.size();i++){
                trung = false;
                pn = dspn1.get(i);
                for(int j=0;j<dsncc.size();j++){
                    if(pn.getIdncc().equals(dsncc.get(j))){
                        trung = true;
                        break;
                    }
                }
                if(trung == false) dsncc.add(pn.getIdncc());
            } 
            JComboBox idpncb = new JComboBox(dsidpn.toArray());
            JComboBox idnvcb = new JComboBox(dsidnv.toArray());
            JComboBox idncccb = new JComboBox(dsncc.toArray());
            if(categorycb.getSelectedIndex()==0){
                ngaylap1.setEnabled(true);
                ngaylap2.setEnabled(true);
                tien1txt.setEditable(true);
                tien2txt.setEditable(true);
                searchtxt.setText("");
                searchtxt.setEditable(false);
                tien1txt.setText("");
                tien2txt.setText("");
            }else if(categorycb.getSelectedIndex()==1){
                int answer = JOptionPane.showConfirmDialog(this,idpncb,null,JOptionPane.DEFAULT_OPTION);
                if(answer == JOptionPane.OK_OPTION){
                    searchtxt.setText(idpncb.getSelectedItem().toString());
                    ngaylap1.setEnabled(false);
                    ngaylap2.setEnabled(false);
                    tien1txt.setEditable(false);
                    tien2txt.setEditable(false);
                    tien2txt.setText("");
                    tien1txt.setText("");
                    ngaylap1.setCalendar(null);
                    ngaylap2.setCalendar(null);
                    searchtxt.setEditable(true);
                }
            }else if(categorycb.getSelectedIndex()==2){
                int answer = JOptionPane.showConfirmDialog(this,idncccb,null,JOptionPane.DEFAULT_OPTION);
                if(answer == JOptionPane.OK_OPTION){
                    searchtxt.setText(idncccb.getSelectedItem().toString());
                    ngaylap1.setEnabled(false);
                    ngaylap2.setEnabled(false);
                    tien1txt.setEditable(false);
                    tien2txt.setEditable(false);
                    tien2txt.setText("");
                    tien1txt.setText("");
                    ngaylap1.setCalendar(null);
                    ngaylap2.setCalendar(null);
                    searchtxt.setEditable(true);
                }    
            }else if(categorycb.getSelectedIndex()==3){
                int answer = JOptionPane.showConfirmDialog(this,idnvcb,null,JOptionPane.DEFAULT_OPTION);
                if(answer == JOptionPane.OK_OPTION){
                    searchtxt.setText(idnvcb.getSelectedItem().toString());
                    tien1txt.setEditable(false);
                    tien2txt.setEditable(false);
                    ngaylap1.setEnabled(false);
                    ngaylap2.setEnabled(false);
                    searchtxt.setEditable(false);
                    tien1txt.setText("");
                    tien2txt.setText("");
                }
            }else if(categorycb.getSelectedIndex()==4){
                ngaylap1.setEnabled(true);
                ngaylap2.setEnabled(true);
                tien1txt.setEditable(false);
                tien2txt.setEditable(false);
                searchtxt.setText("");
                searchtxt.setEditable(false);
                tien1txt.setText("");
                tien2txt.setText("");
            }else if(categorycb.getSelectedIndex()==5){
                ngaylap1.setEnabled(false);
                ngaylap2.setEnabled(false);
                tien1txt.setEditable(true);
                tien2txt.setEditable(true);
                searchtxt.setText("");
                searchtxt.setEditable(false);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==datatable){
            int answer = JOptionPane.showConfirmDialog(null,"Bạn có muốn xem chi tiết phiếu nhập?",null,JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION){
                int i = datatable.getSelectedRow();
                String idpn = datatable.getValueAt(i,0).toString();
                idnv = datatable.getValueAt(i,2).toString();
                ngaylap = datatable.getValueAt(i,3).toString();
                ncc = datatable.getValueAt(i,1).toString();
                loadDetailPhieunhap(idpn);
            }
        }else if(e.getSource()==reloadbtn){
            loadDsphieunhap();
        }else if(e.getSource()==searchbtn){
            String searchstr = searchtxt.getText();
            if(categorycb.getSelectedIndex()==0){
                try{
                    ngay1 = sdf.format(ngaylap1.getDate());
                    ngay2  = sdf.format(ngaylap2.getDate());
                }catch(Exception err){
                    //System.out.println(err);
                }
                try{
                    gia1 = Integer.parseInt(tien1txt.getText());
                    gia2 = Integer.parseInt(tien2txt.getText());
                }catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(null,"Hãy nhập số vào ô đơn giá");
                    return;
                }
                if((ngaylap1.getDate()==null) ||(ngaylap2.getDate()==null)){
                    JOptionPane.showMessageDialog(null,"Không được để ngày trống");
                }else if(gia1 > gia2){
                    JOptionPane.showMessageDialog(null,"Ô giá trước không được lớn hơn ô sau");
                }else if(ngay1.compareTo(ngay2)>0){
                    JOptionPane.showMessageDialog(null,"Ô ngày trước không được lớn hơn ô sau");
                }else{
                    search(searchstr,ngay1,ngay2,gia1,gia2);
                }
            }else if (categorycb.getSelectedIndex()==1){
                if((searchstr.equals("")) || searchstr.length()<3 || (!searchstr.substring(0,2).equals("PN"))){
                    JOptionPane.showMessageDialog(null,"ID phiếu nhập không hợp lệ");
                    JOptionPane.showMessageDialog(null,"ID phiếu nhập có mã bắt đầu là 'PN' ");
                }else{
                    search(searchstr,"","",0,0);
                }
            }else if (categorycb.getSelectedIndex()==2){
                if((searchstr.equals("")) || searchstr.length()<4 || (!searchstr.substring(0,3).equals("NCC"))){
                    JOptionPane.showMessageDialog(null,"ID nhà cung cấp không hợp lệ");
                    JOptionPane.showMessageDialog(null,"ID nhà cung cấp có mã bắt đầu là 'NCC' ");
                }else{
                    search(searchstr,"","",0,0);
                }    
            }else if(categorycb.getSelectedIndex()==3){
                if((searchstr.equals("")) || (searchstr.length()<3) || (!searchstr.substring(0,2).equals("NV"))){
                    JOptionPane.showMessageDialog(null,"ID nhân viên không hợp lệ");
                    JOptionPane.showMessageDialog(null,"ID nhân viên có mã bắt đầu là 'NV'");
                }else{
                    search(searchstr,"","",0,0);
                }
            }else if(categorycb.getSelectedIndex()==4){
                if((ngaylap1.getDate()==null) ||(ngaylap2.getDate()==null)){
                    JOptionPane.showMessageDialog(null,"Ngày không được để trống");
                }else{
                    ngay1 = sdf.format(ngaylap1.getDate());
                    ngay2 = sdf.format(ngaylap2.getDate());
                    gia1=0;gia2=0;
                    search(searchstr,ngay1,ngay2,gia1,gia2);
                }
            }else if(categorycb.getSelectedIndex()==5){
                if((tien1txt.getText().equals("")) || (tien2txt.getText().equals(""))){
                    JOptionPane.showMessageDialog(null,"Ô đơn giá không được để trống");
                }else{
                    try{
                        gia1 = Integer.parseInt(tien1txt.getText());
                        gia2 = Integer.parseInt(tien2txt.getText());
                        if(gia1 > gia2){
                            JOptionPane.showMessageDialog(null,"Ô giá trước không được lớn hơn ô sau");
                        }else if (gia1 < 1000 || gia2 <1000){
                            JOptionPane.showMessageDialog(null,"Ô giá không hợp lệ");
                        }else{
                            search(searchstr,"","",gia1,gia2);
                        }
                    }catch(NumberFormatException err){
                        JOptionPane.showMessageDialog(null,"Hãy nhập số vào ô đơn giá");
                    }
                }
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
        if(e.getSource() == searchbtn){
            ImageIcon searchicon2 = new ImageIcon(this.getClass().getResource("/Icons/searchicon2.png"));
            searchbtn.setIcon(searchicon2);
        }else if(e.getSource() == reloadbtn){
            ImageIcon refreshicon2 = new ImageIcon(this.getClass().getResource("/Icons/refreshicon2.png"));
            reloadbtn.setIcon(refreshicon2);
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
        }
    } 
}
