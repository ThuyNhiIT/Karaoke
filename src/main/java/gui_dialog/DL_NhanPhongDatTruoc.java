/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui_dialog;

import connectDB.ConnectDB;
import dao.*;
import entity.*;
import gui.form.Form_Login;
import gui.form.Form_QuanLyDatPhong;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HO MINH HAU
 */
public class DL_NhanPhongDatTruoc extends javax.swing.JDialog {

    private PhongHat_DAO ph_dao;
    private KhachHang_DAO kh_dao;
    private DonDatPhong_DAO ddp_dao;
    private HoaDon_DAO hd_dao;
    private ChiTietHoaDonPhong_Dao cthdp_dao;

    private static String mahdAuto;


    public DL_NhanPhongDatTruoc(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       setInfo();



    }
    public static void setMaHDPublic(String mahd) {
        mahdAuto = mahd;
    }

    public static String getMaHDPublic() {
        return mahdAuto;
    }
    public void setInfo() {
        Form_QuanLyDatPhong ph = new Form_QuanLyDatPhong();
        ph_dao = new PhongHat_DAO();
        String maPhong = ph.getRoomSelected();
        String maKH = ph.getKHSelected();
        String maDDP = ph.getDDPSelected();

        kh_dao = new KhachHang_DAO();
        ddp_dao = new DonDatPhong_DAO();

        // Check if the list is not empty before accessing elements
        ArrayList<DonDatPhong> dsDDP = ddp_dao.timDonDatPhong(maDDP, maKH, maPhong);
        if (!dsDDP.isEmpty()) {
            txtTenKH.setText(kh_dao.findCustomer(maKH).getTenKH());
            txtSDTKH.setText(kh_dao.findCustomer(maKH).getSdt());
            String ngayDat = dsDDP.get(0).getNgayDat().toString();
            String ngayNhan = dsDDP.get(0).getNgayNhan().toString();
            String ngayDatFormat = ngayDat.substring(8, 10) + "/" + ngayDat.substring(5, 7) + "/" + ngayDat.substring(0, 4) + " " + ngayDat.substring(11, 16);
            String ngayNhanFormat = ngayNhan.substring(8, 10) + "/" + ngayNhan.substring(5, 7) + "/" + ngayNhan.substring(0, 4) + " " + ngayNhan.substring(11, 16);
            txtNgayDatPhong.setText(ngayDatFormat);
            txtNgayNhanPhong.setText(ngayNhanFormat);
        } else {
            // Handle the case where the list is empty
            // You may want to show an error message or handle it appropriately
        }
    }

    public HoaDon revertHoaDonFromTextfields() {
        NhanVien nhanVienDangNhap = Form_Login.getNhanVienDangNhap();
        String maHD = phatSinhMaHD();
        setMaHDPublic(maHD); // đừng xóa dòng này . công dụng lấy ra được maHD mới phát sinh
        LocalDate ngayLapHD = LocalDate.now();
        Form_QuanLyDatPhong ph = new Form_QuanLyDatPhong();
        String maKH = ph.getKHSelected();
        String maNV = nhanVienDangNhap.getMaNV();
        double tongTien = 0;
        HoaDon hd = new HoaDon(maHD, ngayLapHD, new KhachHang(maKH), new NhanVien(maNV), tongTien);
        return hd;

    }

    public ChiTietHoaDonPhong revertChiTietHoaDonPhongText() {
        String maHD = getMaHDPublic();
        Form_QuanLyDatPhong ph = new Form_QuanLyDatPhong();
        ph_dao = new PhongHat_DAO();
        String maPhong = ph.getRoomSelected();
        double gia = 0;
        LocalDateTime gioVao = LocalDateTime.now();
        LocalDateTime gioRa = gioVao;
        String maGiamGia = null;

        ChiTietHoaDonPhong cthdp = new ChiTietHoaDonPhong(new HoaDon(maHD), new PhongHat(maPhong), gia, gioVao, gioRa, maGiamGia);
        return cthdp;
    }
    public String phatSinhMaHD() {

        List<HoaDon> khs = hd_dao.getalltbHoaDon();
        String temp = null;
        for (HoaDon hd : khs) {
            temp = hd.getMaHD();
        }
        int count = laySoDuoiHD(temp);

        count++;

        String maVe = String.format("HD%03d", count);

        return maVe;
    }

    public int laySoDuoiHD(String str) {
        if (str == null) {
            return 0;
        } else {
            String numberStr = str.substring(2); // loại bỏ ký tự "HD"
            int number = Integer.parseInt(numberStr); // chuyển đổi chuỗi thành số nguyên
            return number;
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnExit = new gui.swing.Button();
        lblTenKH = new javax.swing.JLabel();
        lblSDTKH = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JLabel();
        txtSDTKH = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNgayDatPhong = new javax.swing.JLabel();
        txtNgayNhanPhong = new javax.swing.JLabel();
        btnNhanPhong = new gui.swing.RadiusButton();
        btnHuyPhong = new gui.swing.RadiusButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setText("Phòng đặt trước");

        btnExit.setBackground(new java.awt.Color(255, 0, 51));
        btnExit.setBorder(null);
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("  X  ");
        btnExit.setEffectColor(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenKH.setText("Khách hàng:");

        lblSDTKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSDTKH.setText("Số điện thoại:");

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenKH.setText("Hồ Minh Hậu");

        txtSDTKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDTKH.setText("0585576500");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ngày và giờ đặt :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày và giờ nhận:");

        txtNgayDatPhong.setText("12/12/2023 13:00:00");

        txtNgayNhanPhong.setText("12/12/2023 13:00:00");

        btnNhanPhong.setBackground(new java.awt.Color(0, 204, 102));
        btnNhanPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanPhong.setText("Nhận phòng");
        btnNhanPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanPhongActionPerformed(evt);
            }
        });

        btnHuyPhong.setBackground(new java.awt.Color(255, 51, 0));
        btnHuyPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyPhong.setText("Hủy phòng");
        btnHuyPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenKH)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSDTKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txtNgayDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnHuyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKH)
                    .addComponent(txtTenKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDTKH)
                    .addComponent(txtSDTKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayDatPhong))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayNhanPhong))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnHuyPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhongActionPerformed

        ddp_dao = new DonDatPhong_DAO();
        Form_QuanLyDatPhong ph = new Form_QuanLyDatPhong();
       String maDDP = ph.getDDPSelected();
        ddp_dao.deleteDonDatPhong(maDDP, ph.getRoomSelected());
        this.dispose();


    }//GEN-LAST:event_btnHuyPhongActionPerformed

    private void btnNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanPhongActionPerformed
        Form_QuanLyDatPhong ph = new Form_QuanLyDatPhong();
        String maDDP = ph.getDDPSelected();
        String maPhong = ph.getRoomSelected();
        String maKH = ph.getKHSelected();
        ddp_dao = new DonDatPhong_DAO();
        ArrayList<DonDatPhong> dsDDP = ddp_dao.timDonDatPhong(maDDP, maKH, maPhong);
       // nếu giờ hiện tại trước giờ nhận phòng thì kiểm tra phòng có trống không
        if (LocalDateTime.now().isBefore(dsDDP.get(0).getNgayNhan())) {
            ph_dao = new PhongHat_DAO();
            if (ph_dao.getPhongHatByMaPhong(maPhong).getTinhTrangPhong().equals("Trong")) {
                // nếu phòng trống thì thêm hóa đơn và chi tiết hóa đơn phòng
                hd_dao = new HoaDon_DAO();
                cthdp_dao = new ChiTietHoaDonPhong_Dao();
                HoaDon hd = revertHoaDonFromTextfields();
                ChiTietHoaDonPhong cthdp = revertChiTietHoaDonPhongText();
                hd_dao.createHoaDon(hd);
                cthdp_dao.createChiTietHoaDonPhong(cthdp);
                // cập nhật lại tình trạng phòng
                ph_dao.updateTinhTrangPhong(maPhong, "Dang su dung");
                ph.openDL_ChonDichVu();
                this.dispose();
                // xóa đơn đặt phòng
                ddp_dao.deleteDonDatPhong(maDDP, maPhong);


                this.dispose();
            } else {
                this.dispose();
                JOptionPane.showMessageDialog(this, "Phòng đang được sử dụng chưa thể nhận phòng");
            }
        } else {
            this.dispose();
            JOptionPane.showMessageDialog(this, "Đã quá giờ nhận phòng");
        }
    }//GEN-LAST:event_btnNhanPhongActionPerformed

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
            java.util.logging.Logger.getLogger(DL_NhanPhongDatTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DL_NhanPhongDatTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DL_NhanPhongDatTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DL_NhanPhongDatTruoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DL_NhanPhongDatTruoc dialog = new DL_NhanPhongDatTruoc(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.Button btnExit;
    private gui.swing.RadiusButton btnHuyPhong;
    private gui.swing.RadiusButton btnNhanPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSDTKH;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel txtNgayDatPhong;
    private javax.swing.JLabel txtNgayNhanPhong;
    private javax.swing.JLabel txtSDTKH;
    private javax.swing.JLabel txtTenKH;
    // End of variables declaration//GEN-END:variables
}
