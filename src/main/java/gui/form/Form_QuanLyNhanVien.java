package gui.form;

import dao.LoaiNV_DAO;
import dao.NhanVien_DAO;
import entity.LoaiNhanVien;
import entity.NhanVien;
import gui.swing.CustomJOptionPane;
import gui.swing.table.PanelActionCellEditor_NhanVien;
import gui.swing.table.PanelActionCellRender_NhanVien;
import gui.swing.table.TableActionEvent_NhanVien;
import gui_dialog.DL_SuaNV;
import gui_dialog.DL_ThemNV;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLyNhanVien extends javax.swing.JPanel {

    private NhanVien_DAO nv_dao;
    private DefaultTableModel dtmNhanVien;
    private LoaiNV_DAO loainv_dao = new LoaiNV_DAO();
//    private DefaultComboBoxModel<LoaiNhanVien>;

    public Form_QuanLyNhanVien() {
        initComponents();
         TableActionEvent_NhanVien event = new TableActionEvent_NhanVien() {
            @Override
            public void Sua(int row) {
                //System.out.println("sua" +row);
                //Viết sự kiên dô đây
                nv_dao = new NhanVien_DAO();
                if (tblDSNV.getSelectedRowCount() > 0) {
           
                int[] selectedRows = tblDSNV.getSelectedRows();
                for (int i = 0; i < selectedRows.length; i++) {
                    int rowIndex = selectedRows[i];
                    String maNV = tblDSNV.getValueAt(rowIndex, 0).toString();
                    String tenNV = tblDSNV.getValueAt(rowIndex, 1).toString();
                    Boolean gioiTinh = Boolean.parseBoolean(tblDSNV.getValueAt(rowIndex, 2).toString());
                    String CCCD = tblDSNV.getValueAt(rowIndex, 3).toString();
                    String SDT = tblDSNV.getValueAt(rowIndex, 4).toString();
                    String diaChi = tblDSNV.getValueAt(rowIndex, 5).toString();
                    String caLam = tblDSNV.getValueAt(rowIndex, 6).toString();
                    String loaiNV = tblDSNV.getValueAt(rowIndex, 7).toString();

                    tblDSNV.setValueAt(tenNV, rowIndex, 1);
                    tblDSNV.setValueAt(gioiTinh, rowIndex, 2);
                    tblDSNV.setValueAt(CCCD, rowIndex, 3);
                    tblDSNV.setValueAt(SDT, rowIndex, 4);
                    tblDSNV.setValueAt(diaChi, rowIndex, 5);
                    tblDSNV.setValueAt(caLam, rowIndex, 6);

                    NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, new LoaiNhanVien(loaiNV));

                    if (nv_dao.editStaff(nv)) {
                        System.out.println("Sửa thành công");
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    } else {
                        System.out.println("Sửa thất bại");
                        JOptionPane.showMessageDialog(null, "Sửa thất bại");
                    }
                }
            }

            clearJTable();
            DocDuLieu();
  
            }
        };
        tblDSNV.getColumnModel().getColumn(8).setCellRenderer(new PanelActionCellRender_NhanVien());
        tblDSNV.getColumnModel().getColumn(8).setCellEditor(new PanelActionCellEditor_NhanVien(event));
        nv_dao = new NhanVien_DAO();
        dtmNhanVien = (DefaultTableModel) tblDSNV.getModel();
        loadTable(nv_dao.getalltbNhanVien());
        loadLoaiNhanVien();
        updateTotalEmployees();
        
        
    }   

    public void loadTable(ArrayList<NhanVien> ds) {
        if (ds == null) {
            clearJTable();
            return;
        }
        clearJTable();
        for (NhanVien nhanVien : ds) {
            dtmNhanVien.addRow(new Object[]{nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.isGioiTinh() ? "Nam" : "Nữ",
                nhanVien.getCCCD(), nhanVien.getSDT(), nhanVien.getDiaChi(), nhanVien.getCaLam(), nhanVien.getLoaiNV().getMaLoai()});
        }
    }

    public void clearJTable() {
        while (tblDSNV.getRowCount() > 0) {
            dtmNhanVien.removeRow(0);
        }
    }

    public void DocDuLieu() {
        List<NhanVien> list = nv_dao.getalltbNhanVien();
        for (NhanVien nv : list) {
            dtmNhanVien.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getCCCD(), nv.getSDT(),
                nv.getDiaChi(), nv.getCaLam(), nv.getLoaiNV().getMaLoai()
            });
        }

    }

    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblDSNV.getModel();
        dtm.getDataVector().removeAllElements();
    }

     /**
     * Load data lên combobox
     * @return 
     */
    private void loadLoaiNhanVien() {
       LoaiNV_DAO loainv_dao = new LoaiNV_DAO();

       List<LoaiNhanVien> loaiNhanViens = loainv_dao.getAllLoaiNhanVien();
       DefaultComboBoxModel<LoaiNhanVien> dataModel = new DefaultComboBoxModel<>(loaiNhanViens.toArray(new LoaiNhanVien[0]));
       cmbLocNV.setModel(dataModel);
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNhanVien = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlTraCuu = new javax.swing.JPanel();
        lblTim = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new gui.swing.RadiusButton();
        btnSua = new gui.swing.RadiusButton();
        btnThem = new gui.swing.RadiusButton();
        btnRefesh = new gui.swing.RadiusButton();
        lblDSNV = new javax.swing.JLabel();
        scr = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        cmbLocNV = new javax.swing.JComboBox<>();
        btnLoc = new gui.swing.RadiusButton();

        pnlNhanVien.setBackground(new java.awt.Color(235, 249, 249));
        pnlNhanVien.setFocusCycleRoot(true);

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTraCuu.setBackground(new java.awt.Color(255, 255, 255));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-find-24.png"))); // NOI18N
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTraCuuLayout = new javax.swing.GroupLayout(pnlTraCuu);
        pnlTraCuu.setLayout(pnlTraCuuLayout);
        pnlTraCuuLayout.setHorizontalGroup(
            pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraCuuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTim)
                .addGap(28, 28, 28)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnlTraCuuLayout.setVerticalGroup(
            pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraCuuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTim)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
            .addGroup(pnlTraCuuLayout.createSequentialGroup()
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnSua.setBackground(new java.awt.Color(235, 249, 249));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-customer-48.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-refresh-48.png"))); // NOI18N
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(pnlTraCuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );

        lblDSNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDSNV.setText("DANH SÁCH NHÂN VIÊN");

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "CCCD", "Số điện thoại", "Địa chỉ", "Ca", "Loại nhân viên", "Hành động"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV.setRowHeight(40);
        tblDSNV.setSelectionBackground(new java.awt.Color(0, 169, 183));
        scr.setViewportView(tblDSNV);
        if (tblDSNV.getColumnModel().getColumnCount() > 0) {
            tblDSNV.getColumnModel().getColumn(6).setPreferredWidth(5);
            tblDSNV.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTong.setText("Tổng số nhân viên:");

        txtTong.setEditable(false);
        txtTong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongActionPerformed(evt);
            }
        });

        btnLoc.setBackground(new java.awt.Color(166, 208, 238));
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-filter-24.png"))); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scr, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(lblDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblTong)
                        .addGap(18, 18, 18)
                        .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(cmbLocNV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(496, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLocNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        nv_dao = new NhanVien_DAO();

        if (tblDSNV.getSelectedRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Xác nhận sửa khách hàng đã chọn?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int[] selectedRows = tblDSNV.getSelectedRows();
                for (int i = 0; i < selectedRows.length; i++) {
                    int rowIndex = selectedRows[i];
                    String maNV = tblDSNV.getValueAt(rowIndex, 0).toString();
                    String tenNV = tblDSNV.getValueAt(rowIndex, 1).toString();
                    Boolean gioiTinh = Boolean.parseBoolean(tblDSNV.getValueAt(rowIndex, 2).toString());
                    String CCCD = tblDSNV.getValueAt(rowIndex, 3).toString();
                    String SDT = tblDSNV.getValueAt(rowIndex, 4).toString();
                    String diaChi = tblDSNV.getValueAt(rowIndex, 5).toString();
                    String caLam = tblDSNV.getValueAt(rowIndex, 6).toString();
                    String loaiNV = tblDSNV.getValueAt(rowIndex, 7).toString();

                    tblDSNV.setValueAt(tenNV, rowIndex, 1);
                    tblDSNV.setValueAt(gioiTinh, rowIndex, 2);
                    tblDSNV.setValueAt(CCCD, rowIndex, 3);
                    tblDSNV.setValueAt(SDT, rowIndex, 4);
                    tblDSNV.setValueAt(diaChi, rowIndex, 5);
                    tblDSNV.setValueAt(caLam, rowIndex, 6);

                    NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, new LoaiNhanVien(loaiNV));

                    if (nv_dao.editStaff(nv)) {
                        System.out.println("Sửa thành công");
                        JOptionPane.showMessageDialog(this, "Sửa thành công");
                    } else {
                        System.out.println("Sửa thất bại");
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
            }

            clearJTable();
            DocDuLieu();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        //Lay loai nhan vien duoc chon tu comboBox
        LoaiNhanVien selectedLoaiNV = (LoaiNhanVien) cmbLocNV.getSelectedItem();
        if(selectedLoaiNV != null){
            //Loc danh sach nhan vien theo loai nhan vien duoc chon
           ArrayList<NhanVien> dsNhanVienLoc = nv_dao.getNVTheoLoai(selectedLoaiNV);
           //Hien thi danh sach nhan vien duoc loc tren table 
           loadTable(dsNhanVienLoc);
            updateTotalEmployees();
        }else{
            //Khong co loai nhan vien duoc chon hien thi full danh sach
            loadTable(nv_dao.getalltbNhanVien());
            updateTotalEmployees();
        }
    }//GEN-LAST:event_btnLocActionPerformed

   
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseClicked

    private void updateTotalEmployees() {
        int totalEmployees = dtmNhanVien.getRowCount();
        txtTong.setText("" + totalEmployees);
    }

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
         String sdtNV = txtTim.getText().trim();
        if (!(sdtNV.length() > 0 && sdtNV.matches("\\d{10}"))) {
            CustomJOptionPane.showMessageDialog("Số điện thoại phải gồm 10 số !!!");
        } else {
            String maTim = txtTim.getText();
            ArrayList<NhanVien> dsNVTim = null;

            for (NhanVien nv : nv_dao.getalltbNhanVien()) {
                if (nv.getSDT().equals(maTim)) {
                    dsNVTim = new ArrayList<NhanVien>();
                    dsNVTim.add(nv);
                }
            }
            if (dsNVTim != null) {
                clearDataOnModel();
                for (NhanVien nv : dsNVTim) {
                    dtmNhanVien.addRow(new Object[]{
                        nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getCCCD(), nv.getSDT(),
                        nv.getDiaChi(), nv.getCaLam(), nv.getLoaiNV().getMaLoai()
                    });
                }
            } else if (dsNVTim == null) {
                CustomJOptionPane.showMessageDialog("Không tìm thấy !!!");
            }
        }
        updateTotalEmployees();

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        new DL_ThemNV().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        clearJTable();// xóa dữ liệu hiện có trong bảng
        loadTable(nv_dao.getalltbNhanVien());// Tải dữ liệu lại
        updateTotalEmployees();
        
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void txtTongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongActionPerformed

//    public void reloadInitialData() {
//        clearJTable();// xóa dữ liệu hiện có trong bảng
//        loadTable(nv_dao.getalltbNhanVien());// Tải dữ liệu lại
//        updateTotalEmployees();
//}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnLoc;
    private gui.swing.RadiusButton btnRefesh;
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JComboBox<LoaiNhanVien> cmbLocNV;
    private javax.swing.JLabel lblDSNV;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTong;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlTraCuu;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDSNV;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
