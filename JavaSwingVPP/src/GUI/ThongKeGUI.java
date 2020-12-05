package GUI;

import BUS.HoadonBUS;
import BUS.SanphamBUS;
import BUS.phieunhapBUS;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import static BUS.HoadonBUS.dshd2;
import static BUS.SanphamBUS.dsspSelling;
import DTO.SanphamDTO;
import java.util.ArrayList;
                        

public class ThongKeGUI extends JPanel implements ActionListener,MouseListener{
    private JPanel tongquat,topsp,chart;
    private JLabel tongquatlbl,tongsp,tongthu,tongchi,topsp0,topsp1,topsp2,topsp3,topsp4,
            topsp5,topsp6,topsp7,topsp8,topsp9,topsp10,topsp1l,topsp2l,topsp3l,topsp4l,
            topsp5l,topsp6l,topsp7l,topsp8l,topsp9l,topsp10l,thongkelbl;;
    private Font f = new Font("Arial",Font.BOLD,16);
    private JComboBox loai1,loai2;
    public ThongKeGUI(){
        inits();
    }
    
    public void inits(){
        setSize(945,650);
        setLayout(null);
        //panel tong quat
        tongquat = new JPanel(new FlowLayout(1,5,5));
        tongquat.setBounds(620,0,300,150);
        tongquat.setBorder(new LineBorder(black,3,true));
        
        tongquatlbl = new JLabel("Tổng quát");
        tongquatlbl.setPreferredSize(new Dimension(300,30));
        tongquatlbl.setHorizontalAlignment(JLabel.CENTER);
        tongquatlbl.setFont(f);
        tongquatlbl.setForeground(red);
        tongthu = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png")));
        tongthu.setPreferredSize(new Dimension(290,30));
        tongthu.setFont(f);
        tongthu.setForeground(red);
        tongthu.setHorizontalAlignment(JLabel.LEFT);
        tongchi = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png")));
        tongchi.setPreferredSize(new Dimension(290,30));
        tongchi.setFont(f);
        tongchi.setForeground(red);
        tongchi.setHorizontalAlignment(JLabel.LEFT);
        tongsp = new JLabel(new ImageIcon(this.getClass().getResource("/Icons/moneyicon.png")));
        tongsp.setPreferredSize(new Dimension(290,30));
        tongsp.setFont(f);
        tongsp.setForeground(red);
        tongsp.setHorizontalAlignment(JLabel.LEFT);
        tongquat.add(tongquatlbl);
        tongquat.add(tongthu);
        tongquat.add(tongchi);
        tongquat.add(tongsp);
        
        /*infokhlbl2 = new JLabel("Khách lẻ");
        infokhlbl2.setPreferredSize(new Dimension(280,30));
        infokhlbl2.setFont(f);
        infokhlbl2.setForeground(red);
        infokhlbl2.setHorizontalAlignment(JLabel.CENTER);*/
        //panel ban chay
        topsp = new JPanel(new FlowLayout(1,5,5));
        topsp.setBounds(620,150,325,500);
        topsp.setBorder(new LineBorder(black,3,true));
        
        topsp0 = new JLabel("Những sản phẩm bán chạy");
        topsp0.setPreferredSize(new Dimension(280,30));
        topsp0.setFont(f);
        topsp0.setForeground(red);
        topsp0.setHorizontalAlignment(JLabel.CENTER);
        topsp1 = new JLabel();
        topsp1.setPreferredSize(new Dimension(245,30));
        topsp1.setFont(f);
        topsp1.setForeground(red);
        topsp1.setHorizontalAlignment(JLabel.CENTER);
        topsp1l = new JLabel();
        topsp1l.setPreferredSize(new Dimension(30,30));
        topsp1l.setFont(f);
        topsp1l.setBackground(Color.RED);
        topsp1l.setHorizontalAlignment(JLabel.CENTER);
        topsp2 = new JLabel();
        topsp2.setPreferredSize(new Dimension(245,30));
        topsp2.setFont(f);
        topsp2.setForeground(red);
        topsp2.setHorizontalAlignment(JLabel.CENTER);
        topsp2l = new JLabel();
        topsp2l.setPreferredSize(new Dimension(30,30));
        topsp2l.setFont(f);
        topsp2l.setBackground(Color.RED);
        topsp2l.setHorizontalAlignment(JLabel.CENTER);
        topsp3 = new JLabel();
        topsp3.setPreferredSize(new Dimension(245,30));
        topsp3.setFont(f);
        topsp3.setForeground(red);
        topsp3.setHorizontalAlignment(JLabel.CENTER);
        topsp3l = new JLabel();
        topsp3l.setPreferredSize(new Dimension(30,30));
        topsp3l.setFont(f);
        topsp3l.setBackground(Color.RED);
        topsp3l.setHorizontalAlignment(JLabel.CENTER);
        topsp4 = new JLabel();
        topsp4.setPreferredSize(new Dimension(30,30));
        topsp4.setFont(f);
        topsp4.setBackground(Color.RED);
        topsp4.setHorizontalAlignment(JLabel.CENTER);
        topsp4.setPreferredSize(new Dimension(245,30));
        topsp4.setFont(f);
        topsp1.setForeground(red);
        topsp1.setHorizontalAlignment(JLabel.CENTER);
        topsp4l = new JLabel();
        topsp4l.setPreferredSize(new Dimension(30,30));
        topsp4l.setFont(f);
        topsp4l.setBackground(Color.RED);
        topsp4l.setHorizontalAlignment(JLabel.CENTER);
        topsp5 = new JLabel();
        topsp5.setPreferredSize(new Dimension(245,30));
        topsp5.setFont(f);
        topsp5.setForeground(red);
        topsp5.setHorizontalAlignment(JLabel.CENTER);
        topsp5l = new JLabel();
        topsp5l.setPreferredSize(new Dimension(30,30));
        topsp5l.setFont(f);
        topsp5l.setBackground(Color.RED);
        topsp5l.setHorizontalAlignment(JLabel.CENTER);
        topsp6 = new JLabel();
        topsp6.setPreferredSize(new Dimension(245,30));
        topsp6.setFont(f);
        topsp6.setForeground(red);
        topsp6.setHorizontalAlignment(JLabel.CENTER);
        topsp6l = new JLabel();
        topsp6l.setPreferredSize(new Dimension(30,30));
        topsp6l.setFont(f);
        topsp6l.setBackground(Color.RED);
        topsp6l.setHorizontalAlignment(JLabel.CENTER);
        topsp7 = new JLabel();
        topsp7.setPreferredSize(new Dimension(245,30));
        topsp7.setFont(f);
        topsp7.setForeground(red);
        topsp7.setHorizontalAlignment(JLabel.CENTER);
        topsp7l = new JLabel();
        topsp7l.setPreferredSize(new Dimension(30,30));
        topsp7l.setFont(f);
        topsp7l.setBackground(Color.RED);
        topsp7l.setHorizontalAlignment(JLabel.CENTER);
        topsp8 = new JLabel();
        topsp8.setPreferredSize(new Dimension(245,30));
        topsp8.setFont(f);
        topsp8.setForeground(red);
        topsp8.setHorizontalAlignment(JLabel.CENTER);
        topsp8l = new JLabel();
        topsp8l.setPreferredSize(new Dimension(30,30));
        topsp8l.setFont(f);
        topsp8l.setBackground(Color.RED);
        topsp8l.setHorizontalAlignment(JLabel.CENTER);
        topsp9 = new JLabel();
        topsp9.setPreferredSize(new Dimension(245,30));
        topsp9.setFont(f);
        topsp9.setForeground(red);
        topsp9.setHorizontalAlignment(JLabel.CENTER);
        topsp9l = new JLabel();
        topsp9l.setPreferredSize(new Dimension(30,30));
        topsp9l.setFont(f);
        topsp9l.setBackground(Color.RED);
        topsp9l.setHorizontalAlignment(JLabel.CENTER);
        topsp10 = new JLabel();
        topsp10.setPreferredSize(new Dimension(245,30));
        topsp10.setFont(f);
        topsp10.setForeground(red);
        topsp10.setHorizontalAlignment(JLabel.CENTER);
        topsp10l = new JLabel();
        topsp10l.setPreferredSize(new Dimension(30,30));
        topsp10l.setFont(f);
        topsp10l.setBackground(Color.RED);
        topsp10l.setHorizontalAlignment(JLabel.CENTER);
        
        topsp.add(topsp0);
        topsp.add(topsp1);
        topsp.add(topsp1l);
        topsp.add(topsp2);
        topsp.add(topsp2l);
        topsp.add(topsp3);
        topsp.add(topsp3l);
        topsp.add(topsp4);
        topsp.add(topsp4l);
        topsp.add(topsp5);
        topsp.add(topsp5l);
        topsp.add(topsp6);
        topsp.add(topsp6l);
        topsp.add(topsp7);
        topsp.add(topsp7l);
        topsp.add(topsp8);
        topsp.add(topsp8l);
        topsp.add(topsp9);
        topsp.add(topsp9l);
        topsp.add(topsp10);
        topsp.add(topsp10l);
        
        //panel chart
        //chart = new JPanel(new FlowLayout(0,5,5));
        //chart
        thongkelbl = new JLabel("Thống kê");
        thongkelbl.setBounds(300,30,150,40);
        thongkelbl.setFont( new Font("Arial",Font.BOLD,20));
        thongkelbl.setForeground(Color.RED);
        String[] a ={"7 ngày trước","1 ngày trước","1 tháng trước","Lựa chọn"};
       loai1 = new JComboBox(a);
        loai1.setBounds(450,100,150,40);
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.setValue(20000, "Tiền bán", "4/12");
        data.setValue(180000,  "Tiền bán", "3/12");
        data.setValue(14000,  "Tiền bán", "2/12");
        data.setValue(16252,  "Tiền bán", "1/12");
        data.setValue(162522,  "Tiền bán", "30/11");
        data.setValue(77770,  "Tiền bán", "29/11");
        data.setValue(89000,  "Tiền bán", "28/11");
        
        JFreeChart chart = ChartFactory.createBarChart3D("Thống kê doanh thu",null ,"VND" ,data,PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(black);
        ChartPanel chartp = new ChartPanel(chart,true);
        chartp.setVerticalAxisTrace(true);
        chartp.setDisplayToolTips(true);
        chartp.setBounds(0,150,620,450);
        chartp.updateUI();
        add(chartp);
        add(thongkelbl);
         add(loai1);
        add(tongquat);
        add(topsp);
        loaddata();
    }

    
    public void loaddata(){
        HoadonBUS hdbus = new HoadonBUS();
        phieunhapBUS pnbus = new phieunhapBUS();
        hdbus.docDshoadon();
        pnbus.docPhieunhap();
        tongthu.setText("Tổng thu: "+Integer.toString(hdbus.tongtien()));
        tongchi.setText("Tổng chi: "+Integer.toString(pnbus.tongtien()));
        tongsp.setText("Tổng sp: "+Integer.toString(hdbus.tongsp()));
    }
    
    public void loadsp(){
        SanphamBUS a = new SanphamBUS();
        a.docDsspSelling();
        topsp1.setText(dsspSelling.get(1).tensp);
        topsp1l.setText(Integer.toString(dsspSelling.get(1).soluongdaban));
        topsp2.setText(dsspSelling.get(2).tensp);
        topsp2l.setText(Integer.toString(dsspSelling.get(2).soluongdaban));
        topsp3.setText(dsspSelling.get(3).tensp);
        topsp3l.setText(Integer.toString(dsspSelling.get(3).soluongdaban));
        topsp4.setText(dsspSelling.get(4).tensp);
        topsp4l.setText(Integer.toString(dsspSelling.get(4).soluongdaban));
        topsp5.setText(dsspSelling.get(5).tensp);
        topsp5l.setText(Integer.toString(dsspSelling.get(5).soluongdaban));
        topsp6.setText(dsspSelling.get(6).tensp);
        topsp6l.setText(Integer.toString(dsspSelling.get(6).soluongdaban));
        topsp7.setText(dsspSelling.get(7).tensp);
        topsp7l.setText(Integer.toString(dsspSelling.get(7).soluongdaban));
        topsp8.setText(dsspSelling.get(8).tensp);
        topsp8l.setText(Integer.toString(dsspSelling.get(8).soluongdaban));
        topsp9.setText(dsspSelling.get(9).tensp);
        topsp9l.setText(Integer.toString(dsspSelling.get(9).soluongdaban));
        topsp10.setText(dsspSelling.get(10).tensp);
        topsp10l.setText(Integer.toString(dsspSelling.get(10).soluongdaban));
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
