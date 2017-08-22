/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.unikom.adsi.ekostan;

import id.ac.unikom.adsi.ekostan.dao.PenyewaDAO;
import id.ac.unikom.adsi.ekostan.daoimpl.PenyewaDAOImpl;
import id.ac.unikom.adsi.ekostan.entity.Penyewa;
import id.ac.unikom.adsi.ekostan.export.ExcelExporter;
import id.ac.unikom.adsi.ekostan.tablemodel.PenyewaTM;
import id.ac.unikom.adsi.ekostan.utility.DatabaseConnectivity;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zmart D3viL
 */
public final class FormLaporan extends javax.swing.JDialog {

    public FormLaporan(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        getData();
        tampil_tabel_penyewaan();
        tampil_tabel_kamar();
    }
    
    private DefaultTableModel tabmode;
    
    public void tampil_tabel_penyewaan(){
        Object []baris = {"No. Transaksi","Id Penyewa","Nama Penyewa","No. Kamar","Tanggal Sewa","Harga Sewa"};
        tabmode = new DefaultTableModel(null, baris);
        tablePenyewaan.setModel(tabmode);
        Connection conn = DatabaseConnectivity.getConnection();
        try {
            String sql = "select * from penyewaan order by no_transaksi asc";
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String no_transaksi = hasil.getString("no_transaksi");
                String id_penyewa = hasil.getString("id_penyewa");
                String nama_penyewa = hasil.getString("nama_penyewa");
                String no_kamar = hasil.getString("no_kamar");
                String tanggal_sewa = hasil.getString("tanggal_sewa"); 
                String total_bayar = hasil.getString("total_bayar");
                String[] data = {no_transaksi, id_penyewa, nama_penyewa, no_kamar, tanggal_sewa, total_bayar};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data gagal...","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void tampil_tabel_kamar(){
        Object []baris = {"Nomor Kamar","Harga","Status"};
        tabmode = new DefaultTableModel(null, baris);
        tableKamar.setModel(tabmode);
        Connection conn = DatabaseConnectivity.getConnection();
        try {
            String sql = "select * from kamar order by no_kamar asc";
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String no_kamar = hasil.getString("no_kamar");
                String harga = hasil.getString("harga");
                String status = hasil.getString("status");
                String[] data = {no_kamar,harga,status};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
        private void getData() {
        //set table penyewa
            PenyewaDAO penyewaDAO = new PenyewaDAOImpl();
        ArrayList<Penyewa> listPenyewa = penyewaDAO.getPenyewa();
        PenyewaTM penyewaTM = new PenyewaTM();
        penyewaTM.setArrayPenyewa(listPenyewa);

        tablePenyewa.setModel(penyewaTM);

        //set table kamar
//        PegawaiDAO daoPegawai = new PegawaiDAOImpl();
//        ArrayList<Pegawai> listPegawai = daoPegawai.getPegawai();
//        PegawaiTM tmPegawai = new PegawaiTM();
//        tmPegawai.setArrayPegawai(listPegawai);
//
//        tablePegawai.setModel(tmPegawai);

//        //set table Transaksi
//        PeminjamanDAO daoPeminjaman = new PeminjamanDAOImpl();
//        ArrayList<Peminjaman> listPeminjaman = daoPeminjaman.getPeminjaman(null);
//        PeminjamanTM tmPeminjaman = new PeminjamanTM();
//        tmPeminjaman.setArrayPeminjaman(listPeminjaman);
//
//        tableTransaksi.setModel(tmPeminjaman);
//
//        //set table Transaksi
//        BukuDAO daoBuku = new BukuDAOImpl();
//        ArrayList<Buku> listBuku = daoBuku.getBuku(null);
//        BukuTM tmBuku = new BukuTM();
//        tmBuku.setArrayBuku(listBuku);
//
//        tableBuku.setModel(tmBuku);
//
//        PengembalianDAO daoPengembalian = new PengembalianDAOImpl();
//        ArrayList<Pengembalian> listPengembalian = daoPengembalian.getPengambilan(null);
//        PengembalianTM tmPengembalian = new PengembalianTM();
//        tmPengembalian.setArrayPengembalian(listPengembalian);
//
//        tablePengembalian.setModel(tmPengembalian);

    }
        
    /**
     * Creates new form FormLaporan 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePenyewa = new javax.swing.JTable();
        buttonPenyewa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePenyewaan = new javax.swing.JTable();
        buttonPenyewaan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableKamar = new javax.swing.JTable();
        buttonKamar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablePenyewa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablePenyewa);

        buttonPenyewa.setText("Export Penyewa to Excel");
        buttonPenyewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportMouseClicked(evt);
            }
        });
        buttonPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenyewaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPenyewa)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPenyewa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Penyewa", jPanel1);

        tablePenyewaan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablePenyewaan);

        buttonPenyewaan.setText("Export Penyewaan to Excel");
        buttonPenyewaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPenyewaanexportMouseClikced(evt);
            }
        });
        buttonPenyewaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenyewaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPenyewaan)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buttonPenyewaan))
        );

        jTabbedPane1.addTab("Penyewaan", jPanel2);

        tableKamar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tableKamar);

        buttonKamar.setText("Export Kamar to Excel");
        buttonKamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonKamarexportMouseClikced(evt);
            }
        });
        buttonKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKamarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonKamar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buttonKamar))
        );

        jTabbedPane1.addTab("Kamar", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rekab Data");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKamarexportMouseClikced(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonKamarexportMouseClikced

    }//GEN-LAST:event_buttonKamarexportMouseClikced

    private void buttonPenyewaanexportMouseClikced(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPenyewaanexportMouseClikced

    }//GEN-LAST:event_buttonPenyewaanexportMouseClikced

    private void exportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportMouseClicked
        String timeExport = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        if (evt.getSource() == buttonPenyewa) {
            try {
                ExcelExporter exp = new ExcelExporter();
                exp.exportTable(tablePenyewa, new File("D:/DataPenyewa.xls"), "DATA PENYEWA EKOSTAN", timeExport);
                JOptionPane.showMessageDialog(this, "File Location in D:/DataPenyewa.xls");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Try Again, File Excel Has Opened");
                Logger.getLogger(FormLaporan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exportMouseClicked

    private void buttonPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenyewaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPenyewaActionPerformed

    private void buttonPenyewaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenyewaanActionPerformed
        // TODO add your handling code here:
        String timeExport = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        if (evt.getSource() == buttonPenyewaan) {
            try {
                ExcelExporter exp = new ExcelExporter();
                exp.exportTable(tablePenyewaan, new File("D:/DataPenyewaan.xls"), "DATA PENYEWAAN EKOSTAN", timeExport);
                JOptionPane.showMessageDialog(this, "File Location in D:/DataPenyewaan.xls");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Try Again, File Excel Has Opened");
                Logger.getLogger(FormLaporan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonPenyewaanActionPerformed

    private void buttonKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKamarActionPerformed
        // TODO add your handling code here:
        String timeExport = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        if (evt.getSource() == buttonKamar) {
            try {
                ExcelExporter exp = new ExcelExporter();
                exp.exportTable(tableKamar, new File("D:/DataKamar.xls"), "DATA KAMAR EKOSTAN", timeExport);
                JOptionPane.showMessageDialog(this, "File Location in D:/DataKamar.xls");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Try Again, File Excel Has Opened");
                Logger.getLogger(FormLaporan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonKamarActionPerformed

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
            java.util.logging.Logger.getLogger(FormLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormLaporan dialog = new FormLaporan(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonKamar;
    private javax.swing.JButton buttonPenyewa;
    private javax.swing.JButton buttonPenyewaan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableKamar;
    private javax.swing.JTable tablePenyewa;
    private javax.swing.JTable tablePenyewaan;
    // End of variables declaration//GEN-END:variables
}
