/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.SachBLL;
import DTO.SachDTO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 840 G3
 */
public class TimSachGUI extends javax.swing.JFrame {

    SachBLL sBLL = new SachBLL();
    DefaultTableModel model;    
    public TimSachGUI() {
        initComponents();
        loadSachList();
        txtsl.setEnabled(false);
    }
    public void loadSachList() {
        model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Tên Sách");
        model.addColumn("Tác Giả");
        model.addColumn("Thể Loại");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        jTable.setModel(model);
        Vector<SachDTO> arr = new Vector<SachDTO>();
        arr = sBLL.getAllSach();
        for (int i = 0; i < arr.size(); i++) {
            SachDTO s = arr.get(i);
            String mas = s.getMaSach();
            String ten = s.getTenSach();
            String tacgia = s.getTacGia();
            String theloai = s.getTheLoai();
            Double gia = s.getGia();
            int sl = s.getSoLuong();
            Object[] row = {mas, ten, tacgia, theloai, gia,  sl};
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        checkmas = new javax.swing.JCheckBox();
        checksl = new javax.swing.JCheckBox();
        checkten = new javax.swing.JCheckBox();
        txtmas = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtsl = new javax.swing.JTextField();
        soluong = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        tim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TÌM KIẾM SÁCH");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tim.png"))); // NOI18N
        jLabel1.setText("TÌM KIẾM");

        checkmas.setText("Theo mã sách");

        checksl.setText("Theo số lượng (thấp hơn)");

        checkten.setText("Theo tên sách");

        soluong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                soluongStateChanged(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dong.png"))); // NOI18N
        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tim.setBackground(new java.awt.Color(153, 255, 255));
        tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tim.png"))); // NOI18N
        tim.setText("Tìm");
        tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DANH SÁCH SÁCH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtmas, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(soluong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtsl, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtten, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addComponent(checksl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(checkmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkmas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checksl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tim, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void timma (){
    Vector<SachDTO> arr = null;
    if (sBLL.Tim(txtmas.getText())) {
        arr = sBLL.timSach(txtmas.getText());
        model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Tên Sách");
        model.addColumn("Tác Giả");
        model.addColumn("Thể Loại");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        jTable.setModel(model);
        for (int i = 0; i < arr.size(); i++) {
            SachDTO s = arr.get(i);
            String mas = s.getMaSach();
            String ten = s.getTenSach();
            String tacgia = s.getTacGia();
            String theloai = s.getTheLoai();
            Double gia = s.getGia();
            int sl = s.getSoLuong();
            Object[] row = {mas, ten, tacgia, theloai, gia,  sl};
            model.addRow(row);
        }
    }
    else
    {
        JOptionPane.showMessageDialog(this, "Không tồn tại Mã Sách này");
        loadSachList();
     }
}
public void timten (){
    Vector<SachDTO> arr = null;
   // if (sBLL.Tim(txtten.getText())) {
        arr = sBLL.timtenSach(txtten.getText());
        model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Tên Sách");
        model.addColumn("Tác Giả");
        model.addColumn("Thể Loại");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        jTable.setModel(model);
        for (int i = 0; i < arr.size(); i++) {
            SachDTO s = arr.get(i);
            String mas = s.getMaSach();
            String ten = s.getTenSach();
            String tacgia = s.getTacGia();
            String theloai = s.getTheLoai();
            Double gia = s.getGia();
            int sl = s.getSoLuong();
            Object[] row = {mas, ten, tacgia, theloai, gia,  sl};
            model.addRow(row);
        }
    //}
    if(arr==null)
    {
        JOptionPane.showMessageDialog(this, "Không tồn tại tên Sách này");
        loadSachList();
     }
}

public void timsl (){
    Vector<SachDTO> arr = null;
   // if (sBLL.Tim(txtten.getText())) {
        arr = sBLL.timsoluongSach(Integer.parseInt(txtsl.getText()));
        model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Tên Sách");
        model.addColumn("Tác Giả");
        model.addColumn("Thể Loại");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        jTable.setModel(model);
        for (int i = 0; i < arr.size(); i++) {
            SachDTO s = arr.get(i);
            String mas = s.getMaSach();
            String ten = s.getTenSach();
            String tacgia = s.getTacGia();
            String theloai = s.getTheLoai();
            Double gia = s.getGia();
            int sl = s.getSoLuong();
            Object[] row = {mas, ten, tacgia, theloai, gia,  sl};
            model.addRow(row);
        }
    //}
    if(arr==null)
    {
        JOptionPane.showMessageDialog(this, "Không tồn tại tên Sách này");
        loadSachList();
     }
}
    private void timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timActionPerformed
        
        if (checkmas.isSelected() && txtmas.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Mã sách cần tìm không được để trống");
                    return; 
        }
        if (checkmas.isSelected()) {
            try {
                int n = Integer.valueOf(txtmas.getText());
                if (n < 0) {
                    throw new Exception();
                }
                timma();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Mã sách phải là số nguyên > 0");
                return ; 
            }    
        }
        //
        if (checkten.isSelected() && txtten.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Tên sách cần tìm không được để trống");
                    return; 
        }
        if (checkten.isSelected()) {
                timten();
        }
        
        if (checksl.isSelected() && txtsl.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(null, "Tên sách cần tìm không được để trống");
                    return; 
        }
        if (checksl.isSelected()) {
                timsl();
        }
        
    }//GEN-LAST:event_timActionPerformed

    
    
    private void soluongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_soluongStateChanged
        soluong.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int number = soluong.getValue();
                txtsl.setText(String.valueOf(number));
            }
        });
    }//GEN-LAST:event_soluongStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
     
    
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
            java.util.logging.Logger.getLogger(TimSachGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimSachGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimSachGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimSachGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimSachGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkmas;
    private javax.swing.JCheckBox checksl;
    private javax.swing.JCheckBox checkten;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JSlider soluong;
    private javax.swing.JButton tim;
    private javax.swing.JTextField txtmas;
    private javax.swing.JTextField txtsl;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}

