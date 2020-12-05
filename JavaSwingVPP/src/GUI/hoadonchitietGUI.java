/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietGiamBUS;
import BUS.MonanBUS;
import BUS.chitiethoadonBUS;
import DTO.ChiTietGiamDTO;
import DTO.MonanDTO;
import DTO.chitiethoadonDTO;
import DTO.chitietphieunhapDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author MY PC
 */
public class hoadonchitietGUI extends javax.swing.JPanel 
{
    DefaultTableModel model =new DefaultTableModel();
    JLabel suaBtn;
    public static ArrayList<chitiethoadonDTO> tablechitiethoadon; 
    CheckLoi cl = new CheckLoi();
    
    JFrame j;
    /**
     * Creates new form chitiethoadonGUI
     */
    public hoadonchitietGUI() 
    {
        initComponents();
        setIdhoadon(); 
        FormatTable render = new FormatTable();
        render.formatTablenoIcon(tablecthd1);
        inTable();
        txtidhd.setEditable(false);
        txtidmon.setEditable(false);
        txtsoluong.setEditable(false);
        txtdongia.setEditable(false);
        txtthanhtien.setEditable(false);
        
    }
    public void setIdhoadon()
    {
        txtidhd.setText(chitiethoadonDTO.layIdhoadon);
    }
    public void inTable()//doc du lieu in vao table
    {
        try
        {

            txtidhd.setEditable(true);
        //render();
        chitiethoadonBUS bus = new chitiethoadonBUS();
        bus.docChitiet();
            int rowCount = model.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) 
            {
                model.removeRow(i);
            }
        Vector header = new Vector();
        header.add("ID hóa đơn");
        header.add("ID món");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Thành tiền");

        if (model.getRowCount()==0)
            { 
                model=new DefaultTableModel(header,0);
            } 
        for(chitiethoadonDTO nv : chitiethoadonBUS.dschitiet)
        {
                Vector row = new Vector();
                row.add(nv.getIdhd());
                row.add(nv.getIdmon());
                row.add(nv.getSoluong());
                row.add(nv.getDongia());
                row.add(nv.getThanhtien());                

                
                model.addRow(row);
        }
        //add model to jtable
        tablecthd1.setModel(model);
        
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi đọc chi tiết");
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void hienthi()
    {
        JFrame f = new JFrame();
        f.setSize(850,660);
        f.setLayout(null);
        JPanel p =new hoadonchitietGUI();
        p.setBounds(0, 0, 850, 660);
        f.setLocationRelativeTo(null);
        //j.add(g);
        //j.pack();
        f.add(p);
        f.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablecthd1 = new javax.swing.JTable();
        leftPanel = new javax.swing.JPanel();
        thoigianbatdauLb = new javax.swing.JLabel();
        thoigianketthucLb = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtidmon = new javax.swing.JTextField();
        txtdongia = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JTextField();
        thoigianbatdauLb4 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        txtidhd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 204));

        tablecthd1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID hóa đơn", "ID món", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablecthd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablecthd1.setRowHeight(20);
        tablecthd1.setShowVerticalLines(false);
        tablecthd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecthd1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablecthd1);

        leftPanel.setBackground(new java.awt.Color(0, 255, 204));
        leftPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        thoigianbatdauLb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thoigianbatdauLb.setForeground(new java.awt.Color(255, 102, 0));
        thoigianbatdauLb.setText("Số lượng:");

        thoigianketthucLb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thoigianketthucLb.setForeground(new java.awt.Color(255, 102, 0));
        thoigianketthucLb.setText("Đơn giá:");
        thoigianketthucLb.setPreferredSize(new java.awt.Dimension(124, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("ID món:");

        txtidmon.setBorder(null);
        txtidmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidmonActionPerformed(evt);
            }
        });

        txtdongia.setBorder(null);
        txtdongia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdongiaActionPerformed(evt);
            }
        });

        txtsoluong.setBorder(null);
        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });

        thoigianbatdauLb4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        thoigianbatdauLb4.setForeground(new java.awt.Color(255, 102, 0));
        thoigianbatdauLb4.setText("Thành tiền:");

        txtthanhtien.setBorder(null);
        txtthanhtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthanhtienActionPerformed(evt);
            }
        });

        txtidhd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtidhd.setForeground(new java.awt.Color(255, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Chi tiết hóa đơn:");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtidmon, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                    .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoigianbatdauLb4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoigianketthucLb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoigianbatdauLb, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidhd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidmon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thoigianbatdauLb, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thoigianketthucLb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(thoigianbatdauLb4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablecthd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecthd1MouseClicked
        // TODO add your handling code here:
        try
        {
            int  i=tablecthd1.getSelectedRow();
            if(i>=0)
            {
                txtidhd.setEditable(false);//ko cho dien mã
                chitietphieunhapDTO nv =new chitietphieunhapDTO();
                //ct = ChuongTrinhGiamBUS.dsgiamgia.get(i);    //goi arr bus lay gia trị
                txtidhd.setText((String)tablecthd1.getValueAt(i, 0));
                txtidmon.setText((String)tablecthd1.getValueAt(i, 1));
                txtsoluong.setText(String.valueOf(tablecthd1.getValueAt(i, 2)));
                txtdongia.setText(String.valueOf(tablecthd1.getValueAt(i, 3)));
                txtthanhtien.setText(String.valueOf(tablecthd1.getValueAt(i, 4)));

                //format theo kiểu của jdatechooser

            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_tablecthd1MouseClicked

    private void txtthanhtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthanhtienActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtthanhtienActionPerformed

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluongActionPerformed

    private void txtdongiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdongiaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtdongiaActionPerformed

    private void txtidmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidmonActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtidmonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTable tablecthd1;
    private javax.swing.JLabel thoigianbatdauLb;
    private javax.swing.JLabel thoigianbatdauLb4;
    private javax.swing.JLabel thoigianketthucLb;
    private javax.swing.JTextField txtdongia;
    private javax.swing.JTextField txtidhd;
    private javax.swing.JTextField txtidmon;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txtthanhtien;
    // End of variables declaration//GEN-END:variables
}
