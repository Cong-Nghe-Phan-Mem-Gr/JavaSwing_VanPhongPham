/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ChiTietGiamBUS;
import BUS.MonanBUS;
import BUS.chitietphieunhapBUS;
import DTO.ChiTietGiamDTO;
import DTO.MonanDTO;
import DTO.chitietphieunhapDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Nam
 */
public class ChiTietPhieuNhap extends javax.swing.JPanel {
    DefaultTableModel modelTb1 =new DefaultTableModel();
    DefaultTableModel modelTb2 =new DefaultTableModel();
    public static ArrayList<ChiTietGiamDTO> tablechitiet; 
    CheckLoi cl = new CheckLoi();
    JFrame j;
    
    /**
     * Creates new form ChiTietGiamGUI
     */
    public ChiTietPhieuNhap() {
        initComponents();
        setIdgiam();       
        //test
        FormatTable render = new FormatTable();
        render.formatTablenoIcon(tableChitiet);
        docChitiet();
        
        txtMagiam.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableChitiet = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMagiam = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 255, 204));

        tableChitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã giảm", "ID Món", "Tỉ lệ giảm", ""
            }
        ));
        tableChitiet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableChitiet.setShowHorizontalLines(false);
        tableChitiet.setShowVerticalLines(false);
        tableChitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChitietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableChitiet);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Chi tiết phiếu nhập của mã giảm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Danh sách chi tiết mã giảm");

        txtMagiam.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMagiam.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMagiam, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMagiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableChitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChitietMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableChitietMouseClicked
    
    public void docChitiet()
    {
        chitietphieunhapBUS bus = new chitietphieunhapBUS();
        chitietphieunhapDTO dto = new chitietphieunhapDTO();
        bus.docChitiet(txtMagiam.getText());
        
            int rowCount = modelTb2.getRowCount();//remove all row
            for (int i = rowCount - 1; i >= 0; i--) {
                modelTb2.removeRow(i);
            }
            Vector header = new Vector();
        header.add("Id phiếu nhập");
        header.add("Id Món");
        header.add("Số lượng");
        header.add("Giá nhập");
        header.add("Thành tiền");
        
        if (modelTb2.getRowCount()==0)
            { 
                modelTb2=new DefaultTableModel(header,0);
            } 
        for(chitietphieunhapDTO ct : chitietphieunhapBUS.dschitiet)
        {
            
            Vector row = new Vector();
                row.add(ct.getIdpn());
                row.add(ct.getIdmon());
                row.add(ct.getSoluong());
                row.add(ct.getGianhap());
                row.add(ct.getThanhtien());
                
                
                modelTb2.addRow(row);
        }
        tableChitiet.setModel(modelTb2);
    }
    
    public void setIdgiam()
    {
        txtMagiam.setText(QuanLyPhieuNhap.layidpn);
    }
    
    public void hienthi()
    {
        j = new JFrame();
        j.setSize(950,404);
        j.setLayout(null);
        JPanel p =new ChiTietPhieuNhap();
        p.setBounds(0, 0, 950, 404);
        
        //j.add(g);
        //j.pack();
        j.add(p);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }
    public static void main(String[] args) {
        ChiTietPhieuNhap j = new ChiTietPhieuNhap();
        j.hienthi();
    }
    
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableChitiet;
    private javax.swing.JTextField txtMagiam;
    // End of variables declaration//GEN-END:variables
}
