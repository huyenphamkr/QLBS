package GUI;
import BLL.KhachHangBLL;
import BLL.ThongKeBLL;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SachDTO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ThongKeGUI extends javax.swing.JFrame {
    ThongKeBLL dgBLL = new ThongKeBLL();
    DefaultTableModel model;
    public ThongKeGUI() {
        initComponents();
        loadKhachHangVIP();
    }
    public void loadSachConLai(){
        model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Tên Sách");
        model.addColumn("Tác Giả");
        model.addColumn("Thể Loại");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        jTable.setModel(model);
        txttitle.setText("THỐNG KÊ SÁCH TỒN KHO");
        Vector<SachDTO> arr = new Vector<SachDTO>();
        arr = dgBLL.getAllSachConLai();
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
     public void loadSachHet(){
        model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Tên Sách");
        model.addColumn("Tác Giả");
        model.addColumn("Thể Loại");
        model.addColumn("Giá");
        model.addColumn("Số Lượng");
        jTable.setModel(model);
        txttitle.setText("THỐNG KÊ SÁCH BÁN HẾT");
        Vector<SachDTO> arr = new Vector<SachDTO>();
        arr = dgBLL.getAllSachHet();
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
    
    public void loadKhachHangVIP() {
        model = new DefaultTableModel();
        model.addColumn("Mã Khách Hàng");
        model.addColumn("Họ Tên");
        model.addColumn("Địa chỉ");
        model.addColumn("Số Điện Thoại");
        jTable.setModel(model);
        Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
        txttitle.setText("THỐNG KÊ KHÁCH HÀNG VIP");
        arr = dgBLL.getAllKhachHangVIP();
        for (int i = 0; i < arr.size(); i++) {
            KhachHangDTO kh = arr.get(i);
            String makh = kh.getMaKH();
            String hoten = kh.getTenKH();
            String diachi = kh.getDiaChi();
            String sdt = kh.getSdt();
            Object[] row = {makh, hoten, diachi, sdt};
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        txttitle = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        khachhang = new javax.swing.JMenu();
        khachhangvip = new javax.swing.JMenuItem();
        sach = new javax.swing.JMenu();
        scl = new javax.swing.JMenuItem();
        sh = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THỐNG KÊ");
        setBackground(new java.awt.Color(255, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(255, 153, 255));

        jTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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

        txttitle.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        txttitle.setForeground(new java.awt.Color(255, 0, 51));
        txttitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttitle.setText("Danh Sách Độc Giả Trả Sách Trể Ngày Hẹn");
        txttitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/in.png"))); // NOI18N
        jButton2.setText("In");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));

        khachhang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        khachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/khachhang.png"))); // NOI18N
        khachhang.setText("Khách Hàng");
        khachhang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        khachhangvip.setBackground(new java.awt.Color(153, 255, 255));
        khachhangvip.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        khachhangvip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vip.png"))); // NOI18N
        khachhangvip.setText("VIP");
        khachhangvip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachhangvipActionPerformed(evt);
            }
        });
        khachhang.add(khachhangvip);

        jMenuBar1.add(khachhang);

        sach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        sach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N
        sach.setText("Sách");
        sach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        scl.setBackground(new java.awt.Color(153, 255, 255));
        scl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scl.setText("Sách tồn kho");
        scl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sclActionPerformed(evt);
            }
        });
        sach.add(scl);

        sh.setBackground(new java.awt.Color(153, 255, 255));
        sh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sh.setText("Sách bán hết");
        sh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shActionPerformed(evt);
            }
        });
        sach.add(sh);

        jMenuBar1.add(sach);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txttitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void khachhangvipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachhangvipActionPerformed
        loadKhachHangVIP();
    }//GEN-LAST:event_khachhangvipActionPerformed

    private void sclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sclActionPerformed
        loadSachConLai();
    }//GEN-LAST:event_sclActionPerformed

    private void shActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shActionPerformed
        loadSachHet();
    }//GEN-LAST:event_shActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public static void main(String[] args) {
        ThongKeGUI tkgui = new ThongKeGUI();
        tkgui.setVisible(true);
        tkgui.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JMenu khachhang;
    private javax.swing.JMenuItem khachhangvip;
    private javax.swing.JMenu sach;
    private javax.swing.JMenuItem scl;
    private javax.swing.JMenuItem sh;
    private javax.swing.JLabel txttitle;
    // End of variables declaration//GEN-END:variables
}
