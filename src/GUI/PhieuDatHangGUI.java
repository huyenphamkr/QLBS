/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BLL.PhieuDatHangBLL;
import DTO.PhieuDatHangDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class PhieuDatHangGUI extends javax.swing.JFrame {
    PhieuDatHangBLL pBLL= new PhieuDatHangBLL();
    DefaultTableModel model;
    public PhieuDatHangGUI() {
        initComponents();
        loadPhieuDatHangList();
    }
    public void loadPhieuDatHangList() {
        model = new DefaultTableModel();
        model.addColumn("Mã Phiếu");
        model.addColumn("Mã Khách Hang");
        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tổng Tiền");
        model.addColumn("Ngày Đặt");
        jTable.setModel(model);
        GetMaNV();
        GetMaKH();
        Vector<PhieuDatHangDTO> arr = new Vector<PhieuDatHangDTO>();
        arr = pBLL.getAllPhieuDatHang();
        for (int i = 0; i < arr.size(); i++) {
            PhieuDatHangDTO p = arr.get(i);
            int maphdh = p.getMaPHDH();
            String makh = p.getMaKH();
            String manv = p.getMaNV();
            Double tongtien = p.getTongTien();
            String ngay = p.getNgayDH();
            Object[] row = {maphdh, makh, manv, tongtien, ngay};
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        txtmap = new javax.swing.JTextField();
        box = new javax.swing.JComboBox<>();
        txttien = new javax.swing.JTextField();
        ngaydat = new com.toedter.calendar.JDateChooser();
        txttim = new javax.swing.JTextField();
        sua = new javax.swing.JButton();
        tim = new javax.swing.JButton();
        export = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        them = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        in = new javax.swing.JButton();
        chitiet1 = new javax.swing.JButton();
        box1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ HÓA ĐƠN");

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 726, 41));

        jLabel2.setText("Mã phiếu ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 100, 30));

        jLabel3.setText("Mã khách hàng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 119, 100, 30));

        jLabel4.setText("Tổng tiền");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 191, 100, 30));

        jLabel5.setText("Mã nhân viên");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 100, 30));

        jLabel6.setText("Ngày đặt hàng");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 227, 100, 30));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 334, 726, 230));
        jPanel1.add(txtmap, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 83, 170, 30));

        box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(box, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 157, 170, 30));
        jPanel1.add(txttien, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 191, 170, 30));
        jPanel1.add(ngaydat, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 227, 170, 30));
        jPanel1.add(txttim, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 83, 210, 30));

        sua.setBackground(new java.awt.Color(153, 255, 255));
        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sua.png"))); // NOI18N
        sua.setText("Sửa");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });
        jPanel1.add(sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 100, 30));

        tim.setBackground(new java.awt.Color(153, 255, 255));
        tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tim.png"))); // NOI18N
        tim.setText("Tìm kiếm");
        tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timActionPerformed(evt);
            }
        });
        jPanel1.add(tim, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 83, 120, 30));

        export.setBackground(new java.awt.Color(153, 255, 255));
        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/xuat.png"))); // NOI18N
        export.setText("Export ");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        jPanel1.add(export, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 197, 100, 30));

        xoa.setBackground(new java.awt.Color(153, 255, 255));
        xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/xoa.png"))); // NOI18N
        xoa.setText("Xóa");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });
        jPanel1.add(xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 100, 30));

        them.setBackground(new java.awt.Color(153, 255, 255));
        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/them.png"))); // NOI18N
        them.setText("Thêm");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });
        jPanel1.add(them, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 110, 30));

        clear.setBackground(new java.awt.Color(153, 255, 255));
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        clear.setText("Làm mới");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 110, 30));

        in.setBackground(new java.awt.Color(153, 255, 255));
        in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/in.png"))); // NOI18N
        in.setText("In");
        in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inActionPerformed(evt);
            }
        });
        jPanel1.add(in, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 197, 100, 30));

        chitiet1.setBackground(new java.awt.Color(153, 255, 255));
        chitiet1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chitiet.png"))); // NOI18N
        chitiet1.setText("Chi tiết");
        chitiet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitiet1ActionPerformed(evt);
            }
        });
        jPanel1.add(chitiet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 197, 110, 30));

        box1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(box1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 120, 170, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Danh sách hóa đơn");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 710, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int i = jTable.getSelectedRow();
        if (i >= 0) {
            Vector<PhieuDatHangDTO> arr = new Vector<PhieuDatHangDTO>();
            arr = pBLL.getAllPhieuDatHang();
            PhieuDatHangDTO d = arr.get(i);
            txtmap.setText(String.valueOf(d.getMaPHDH()));
            txtmap.setEnabled(false);
            box1.setSelectedItem(String.valueOf(jTable.getValueAt(i, 1)));
            box.setSelectedItem(String.valueOf(jTable.getValueAt(i, 2)));
            txttien.setText(String.valueOf(d.getTongTien()));
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,4));
                ngaydat.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(PhieuDatHangGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        String date = d.format(ngaydat.getDate());
        try {
            if (txtmap.getText().trim().equals("") 
                    || date.trim().equals("") 
                    || txttien.getText().trim().equals("")) 
            {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            } 
            else
            {
                PhieuDatHangDTO dh = new PhieuDatHangDTO();
                dh.setMaPHDH(Integer.parseInt(txtmap.getText()));
                dh.setMaKH(String.valueOf(box1.getSelectedItem()));
                dh.setMaNV(String.valueOf(box.getSelectedItem()));
                dh.setNgayDH(date);
                dh.setTongTien(Double.parseDouble(txttien.getText()));
                JOptionPane.showMessageDialog(this, pBLL.themPhieuDatHang(dh));
                loadPhieuDatHangList();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }
    }//GEN-LAST:event_themActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
    String maxoa = JOptionPane.showInputDialog("Nhập mã phiếu cần xóa:");
    int ma = Integer.parseInt(maxoa);
        try {
            if (maxoa.trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã phiếu");
            } else {
                PhieuDatHangDTO nv = new PhieuDatHangDTO();
                JOptionPane.showMessageDialog(this, pBLL.xoaPhieuDatHang(ma));
                loadPhieuDatHangList();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã phiếu không hợp lệ");
        }
    }//GEN-LAST:event_xoaActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        txtmap.setEnabled(true);
        txtmap.setText("");
        txttien.setText("");
        ngaydat.setDate(null);
        txttim.setText("");
        loadPhieuDatHangList();
    }//GEN-LAST:event_clearActionPerformed

    private void inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inActionPerformed
        try {
            boolean print = jTable.print();
            if(!print)
            {
                JOptionPane.showMessageDialog(this, "In thất bại");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "In thất bại");
        }
    }//GEN-LAST:event_inActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        try {
        //tạo một đối tượng của lớp HSSFWorkbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        //gọi phương thức creatSheet() và truyền tên file muốn tạo
        HSSFSheet sheet = workbook.createSheet("Phiếu Đặt Hàng");
        //tạo hàng thứ 0 sử dụng phương thức createRow()
        HSSFRow rowhead = sheet.createRow((short) 0);
        //tạo ô bằng cách sử dụng phương thức createCell()
        //và thiết lập giá trị cho ô bằng cách sử dụng phương thức setCellValue()
        rowhead.createCell(0).setCellValue("Mã Phiếu");
        rowhead.createCell(1).setCellValue("Mã Khách Hàng");
        rowhead.createCell(2).setCellValue("Mã Nhân Viên");
        rowhead.createCell(3).setCellValue("Tổng Tiền");
        rowhead.createCell(4).setCellValue("Ngày Đặt");
        Vector<PhieuDatHangDTO> arr = new Vector<PhieuDatHangDTO>();
        arr = pBLL.getAllPhieuDatHang();
        for (int i = 0; i < arr.size(); i++) {
            PhieuDatHangDTO p = arr.get(i);
            int maphdh = p.getMaPHDH();
            String makh = p.getMaKH();
            String manv = p.getMaNV();
            Double tongtien = p.getTongTien();
            String ngay = p.getNgayDH();
            HSSFRow row = sheet.createRow((short) i+1);
            row.createCell(0).setCellValue(maphdh);
            row.createCell(1).setCellValue(makh);
            row.createCell(2).setCellValue(manv);
            row.createCell(3).setCellValue(tongtien); 
            row.createCell(4).setCellValue(ngay);
        }         
        JFileChooser chooser = new JFileChooser();
        String filename = "";        
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
        try{
     
             filename = file + ".xls";
        } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!"); }
        }
   
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        //đóng stream
        fileOut.close();
        //đóng workbook
        workbook.close();
        //in thông báo tạo thành công
        JOptionPane.showMessageDialog(this, "File Excel đã được tạo thành công.");
    } catch (Exception e) {
      e.printStackTrace();}
    }//GEN-LAST:event_exportActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        try {
            int masua;
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            String date = d.format(ngaydat.getDate());
            if (txtmap.getText().trim().equals("") 
                    || txttien.getText().trim().equals("") 
                    || date.trim().equals("") ) 
            {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn Phiếu");
            } else {
                PhieuDatHangDTO dh = new PhieuDatHangDTO();
                dh.setMaPHDH(Integer.parseInt(txtmap.getText()));
                dh.setMaKH(String.valueOf(box1.getSelectedItem()));
                dh.setMaNV(String.valueOf(box.getSelectedItem()));
                dh.setTongTien(Double.parseDouble(txttien.getText()));
                dh.setNgayDH(date);
                JOptionPane.showMessageDialog(this, pBLL.suaPhieuDatHang(dh));
                loadPhieuDatHangList();

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }
    }//GEN-LAST:event_suaActionPerformed

    private void timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timActionPerformed
        int ma;
        Vector<PhieuDatHangDTO> arr = null;
        try {
            if (txttim.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu cần tìm");
                txtmap.setText("");
                txttien.setText("");
                ngaydat.setDate(null);
                txttim.setText("");
                loadPhieuDatHangList();
            } else {
                ma = Integer.parseInt(txttim.getText());
                if (pBLL.Tim(ma)) {
                    arr = pBLL.timPhieuDatHang(ma);
                    model = new DefaultTableModel();
                    model.addColumn("Mã Phiếu");
                    model.addColumn("Mã Khách Hang");
                    model.addColumn("Mã Nhân Viên");
                    model.addColumn("Tổng Tiền");
                    model.addColumn("Ngày Đặt");
                    jTable.setModel(model);
                    for (int i = 0; i < arr.size(); i++) {
                        PhieuDatHangDTO nv = arr.get(i);
                        String makh = nv.getMaKH();
                        String manv = nv.getMaNV();
                        Double tongtien = nv.getTongTien();
                        String ngay = nv.getNgayDH();
                        Object[] row = {ma, makh, manv, tongtien, ngay};
                        model.addRow(row);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Không tồn tại Mã phiếu này");
                    txtmap.setText("");
                    txttien.setText("");
                    ngaydat.setDate(null);
                    txttim.setText("");
                    loadPhieuDatHangList();
                    }
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex);
        }
    }//GEN-LAST:event_timActionPerformed

    private void chitiet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitiet1ActionPerformed
        CT_PhieuDHGUI ct = new CT_PhieuDHGUI();
        ct.load(Integer.parseInt(txtmap.getText()));
        ct.setVisible(true);
    }//GEN-LAST:event_chitiet1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhieuDatHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuDatHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuDatHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuDatHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuDatHangGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box;
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JButton chitiet1;
    private javax.swing.JButton clear;
    private javax.swing.JButton export;
    private javax.swing.JButton in;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private com.toedter.calendar.JDateChooser ngaydat;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    private javax.swing.JButton tim;
    private javax.swing.JTextField txtmap;
    private javax.swing.JTextField txttien;
    private javax.swing.JTextField txttim;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables
    private void GetMaNV() {
        box.removeAllItems();
        Vector<String> str = pBLL.getAllMaNV();
        for (int i=0; i< str.size(); i++) {
            box.addItem(str.get(i));
        }
    }
    private void GetMaKH() {
        box1.removeAllItems();
        Vector<String> str = pBLL.getAllMaKH();
        for (int i=0; i< str.size(); i++) {
            box1.addItem(str.get(i));
        }
    }
}
