/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package concertApp.user;

import concertApp.admin.*;
import concertApp.admin.HomeAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ScheduleUser extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    Connection con = connection.koneksiDB.BukaKoneksi();
    

    /**
     * Creates new form tambahDataKonser
     */
    public ScheduleUser() {
        initComponents();
        ShowSchedule();
        

        setLocationRelativeTo(null);
    }

    private void findSchedule() {
        try {
            st = con.createStatement();
            String searchQuery = "SELECT * FROM schedule WHERE id_jadwal LIKE '%" + SearchField.getText()
                    + "%' OR nama_musisi LIKE '%" + SearchField.getText()
                    + "%' OR tanggal LIKE '%" + SearchField.getText()
                    + "%' OR lokasi LIKE '%" + SearchField.getText() + "%'";
            rs = st.executeQuery(searchQuery);

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID Jadwal");
            model.addColumn("Musisi");
            model.addColumn("Tanggal");
            model.addColumn("Lokasi");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] data = {
                    rs.getString("id_jadwal"),
                    rs.getString("nama_musisi"),
                    rs.getString("tanggal"),
                    rs.getString("lokasi")
                };
                model.addRow(data);
                Schedule_Table.setModel(model);

            }

        } catch (Exception e) {
            Logger.getLogger(ScheduleAdmin.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    private void ShowSchedule() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM schedule");

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID Jadwal");
            model.addColumn("Musisi");
            model.addColumn("Kategori");
            model.addColumn("Tanggal");
            model.addColumn("Lokasi");

            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);

            if (rs.next()) {
                do {
                    String currentDate = rs.getString("tanggal");

                    // Assuming currentDate is in the format "dd-MM-yyyy"
                    SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = inputDateFormat.parse(currentDate);

                    // Create a new SimpleDateFormat with Indonesian locale
                    SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String formattedDate = outputDateFormat.format(date);

                    Object[] data = {
                        rs.getString("id_jadwal"),
                        rs.getString("nama_musisi"),
                        rs.getString("kategori"),
                        formattedDate,
                        rs.getString("lokasi")
                    };
                    model.addRow(data);
                } while (rs.next());

                // Set the model to the table outside of the loop
                Schedule_Table.setModel(model);
            }
        } catch (Exception e) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Schedule_Table = new javax.swing.JTable();
        SearchField = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("Jadwal konser");

        backToMenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-arrow-back-60.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        Schedule_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Jadwal", "Nama Musisi", "Tanggal", "Lokasi"
            }
        ));
        jScrollPane1.setViewportView(Schedule_Table);

        SearchField.setPreferredSize(new java.awt.Dimension(75, 30));

        SearchBtn.setBackground(new java.awt.Color(51, 24, 107));
        SearchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        SearchBtn.setText("Cari");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(357, Short.MAX_VALUE))
        );

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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToMenuBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new HomeUser().setVisible(true);
    }//GEN-LAST:event_backToMenuBtnMouseClicked

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here:
        findSchedule();
    }//GEN-LAST:event_SearchBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ScheduleUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScheduleUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Schedule_Table;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel backToMenuBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
