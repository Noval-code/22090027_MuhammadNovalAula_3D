/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package concertApp.admin;

import concertApp.admin.HomePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author muhammad noval aula
 */
public class ScheduleAdmin extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    Connection con = connection.koneksiDB.BukaKoneksi();
    private JComboBox<String> SingerCB;

    /**
     * Creates new form tambahDataKonser
     */
    public ScheduleAdmin() {
        initComponents();
        ShowSchedule();
        fillComboBox();

        setLocationRelativeTo(null);
    }

    private void clear() {
        TXT_ScheduleId.setText("");
        CB_Singer.setSelectedItem("");
        TXT_Country.setText("");
        TXT_Date.setText("");
        TXT_Location.setText("");
        TXT_Qty.setText("");

        TXT_ScheduleId.setEditable(true);

    }

    private void ShowSchedule() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM schedule");

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID Jadwal");
            model.addColumn("Musisi");
            model.addColumn("Negara");
            model.addColumn("Tanggal");
            model.addColumn("Lokasi");
            model.addColumn("Kuota");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_jadwal"),
                    rs.getString("nama_musisi"),
                    rs.getString("negara"),
                    rs.getString("tanggal"),
                    rs.getString("lokasi"),
                    rs.getString("kuota")
                };
                model.addRow(data);
                Schedule_Table.setModel(model);

            }

        } catch (Exception e) {
        }

    }

    private void fillComboBox() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT nama_musisi FROM singer");

            SingerCB = new JComboBox<>();

            while (rs.next()) {
                SingerCB.addItem(rs.getString("nama_musisi"));
            }

            CB_Singer.setModel(SingerCB.getModel());

        } catch (SQLException e) {
            e.printStackTrace();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backToMenuBtn = new javax.swing.JLabel();
        Label_Singer = new javax.swing.JLabel();
        Label_ScheduleId = new javax.swing.JLabel();
        Label_Country = new javax.swing.JLabel();
        TXT_ScheduleId = new javax.swing.JTextField();
        CB_Singer = new javax.swing.JComboBox<>();
        TXT_Country = new javax.swing.JTextField();
        Label_Date = new javax.swing.JLabel();
        TXT_Location = new javax.swing.JTextField();
        Label_Date1 = new javax.swing.JLabel();
        Label_Date2 = new javax.swing.JLabel();
        TXT_Date = new javax.swing.JTextField();
        TXT_Qty = new javax.swing.JTextField();
        SaveBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Schedule_Table = new javax.swing.JTable();
        DeleteBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("Jadwal konser");

        backToMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-arrow-back-50.png"))); // NOI18N
        backToMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToMenuBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(backToMenuBtn)
                .addGap(246, 246, 246)
                .addComponent(jLabel1)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backToMenuBtn)
                    .addComponent(jLabel1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        Label_Singer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label_Singer.setText("Nama Musisi   :");

        Label_ScheduleId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label_ScheduleId.setText("Id Jadwal         :");

        Label_Country.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label_Country.setText("Negara             :");

        Label_Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label_Date.setText("Kuota         :");

        Label_Date1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label_Date1.setText("Tanggal         :");

        Label_Date2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Label_Date2.setText("Lokasi         :");

        SaveBtn.setText("Simpan");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setText("Ubah");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Batal");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        Schedule_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Jadwal", "Nama Musisi", "Negara", "Tanggal", "Lokasi", "Kuota"
            }
        ));
        Schedule_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Schedule_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Schedule_Table);

        DeleteBtn.setText("Hapus");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        jTextField1.setPreferredSize(new java.awt.Dimension(75, 30));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(Label_Singer)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Label_Country, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CB_Singer, 0, 250, Short.MAX_VALUE)
                                    .addComponent(TXT_ScheduleId)
                                    .addComponent(TXT_Country))
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Label_Date2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Date1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TXT_Date, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(TXT_Location)
                                .addComponent(TXT_Qty))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(Label_ScheduleId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(773, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_ScheduleId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Date1)
                    .addComponent(TXT_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Singer)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CB_Singer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label_Date2)
                        .addComponent(TXT_Location, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Country)
                            .addComponent(TXT_Country, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Date)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TXT_Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(160, 160, 160)
                    .addComponent(Label_ScheduleId)
                    .addContainerGap(499, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        try {
            // TODO add your handling code here:
            st = con.createStatement();
            String cekData = "SELECT * FROM schedule WHERE id_jadwal = '" + TXT_ScheduleId.getText() + "'";
            rs = st.executeQuery(cekData);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "data sudah ada");
            } else {
                String addData = "INSERT INTO schedule VALUES ('" + TXT_ScheduleId.getText()
                        + "','" + CB_Singer.getSelectedItem()
                        + "','" + TXT_Country.getText()
                        + "','" + TXT_Date.getText()
                        + "','" + TXT_Location.getText()
                        + "','" + TXT_Qty.getText() + "')";
                st.executeUpdate(addData);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan ");

                clear();
                ShowSchedule();
            }
        } catch (Exception ex) {
            Logger.getLogger(ScheduleAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        try {
            // TODO add your handling code here:
            String update = "UPDATE schedule SET nama_musisi = '" + CB_Singer.getSelectedItem()
                    + "',negara = '" + TXT_Country.getText() + "',tanggal = '" + TXT_Date.getText()
                    + "',lokasi = '" + TXT_Location.getText() + "',kuota = '" + TXT_Qty.getText()
                    + "'WHERE id_jadwal = '" + TXT_ScheduleId.getText() + "'";

            st.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "Data berhasil di update ");

            clear();
            ShowSchedule();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        if (TXT_ScheduleId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan di hapus");
        } else {
            int jawab = JOptionPane.showConfirmDialog(null, "Data ini akan dihapus, lanjutkan?", "konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                try {
                    st = con.createStatement();
                    String sql = "DELETE FROM schedule WHERE id_jadwal = '" + TXT_ScheduleId.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "data berhail di hapus");
                    ShowSchedule();
                    clear();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void Schedule_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Schedule_TableMouseClicked
        // TODO add your handling code here:
        TXT_ScheduleId.setText(Schedule_Table.getValueAt(Schedule_Table.getSelectedRow(), 0).toString());
        CB_Singer.setSelectedItem(Schedule_Table.getValueAt(Schedule_Table.getSelectedRow(), 1).toString());
        TXT_Country.setText(Schedule_Table.getValueAt(Schedule_Table.getSelectedRow(), 2).toString());
        TXT_Date.setText(Schedule_Table.getValueAt(Schedule_Table.getSelectedRow(), 3).toString());
        TXT_Location.setText(Schedule_Table.getValueAt(Schedule_Table.getSelectedRow(), 4).toString());
        TXT_Qty.setText(Schedule_Table.getValueAt(Schedule_Table.getSelectedRow(), 5).toString());

        TXT_ScheduleId.setEditable(false);
    }//GEN-LAST:event_Schedule_TableMouseClicked

    private void backToMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToMenuBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new HomePage().setVisible(true);
    }//GEN-LAST:event_backToMenuBtnMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScheduleAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Singer;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JLabel Label_Country;
    private javax.swing.JLabel Label_Date;
    private javax.swing.JLabel Label_Date1;
    private javax.swing.JLabel Label_Date2;
    private javax.swing.JLabel Label_ScheduleId;
    private javax.swing.JLabel Label_Singer;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTable Schedule_Table;
    private javax.swing.JTextField TXT_Country;
    private javax.swing.JTextField TXT_Date;
    private javax.swing.JTextField TXT_Location;
    private javax.swing.JTextField TXT_Qty;
    private javax.swing.JTextField TXT_ScheduleId;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel backToMenuBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
