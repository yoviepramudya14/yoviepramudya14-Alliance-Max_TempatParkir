/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParkingsManagements;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ASUS
 */
public class KendaraanMasuk extends javax.swing.JFrame {
    java.sql.Connection conn = null;
    ResultSet rs = null;
    Statement str;
    
    public void tanggal(){
        Date tgl = new Date();
        SimpleDateFormat s = new SimpleDateFormat("E yyyy.MM.dd");
        txtTanggal.setText(s.format(tgl));
    }
    
    public void time(){
        Date jam = new Date();
        SimpleDateFormat a = new SimpleDateFormat("hh:mm:ss a");
        txtJam.setText(a.format(jam));
    }
    
    private void kosongkan_form(){
        txtTiket.setEditable(true);
        txtTiket.setText(null);
        txtPlat.setText(null);
        cbJenis.setSelectedItem(this);
        txtTanggal.setText(null);
        txtJam.setText(null);
    }
    
    private void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Tiket");
        model.addColumn("No Plat");
        model.addColumn("Jenis");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Jam Masuk");
        
        try{
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Nailul","1234"); //parkir sebagai database dan 1234 adalah paswordnya
           str = (Statement)conn.createStatement();
           rs = str.executeQuery("select * from data");

           while(rs.next()){
               model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});     
            
           }
           tblParkir.setModel(model);

        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public KendaraanMasuk() {
        this.rs = null;
        initComponents();
        tampilkan_data();
        kosongkan_form();
        tanggal();
        time();
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
        jTable1 = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTiket = new javax.swing.JTextField();
        cbJenis = new javax.swing.JComboBox<>();
        txtPlat = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtJam = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        cetakbutton = new javax.swing.JButton();
        tbSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblParkir = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        tbEdit = new javax.swing.JToggleButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel1.setText("Kendaraan Masuk");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel2.setText("No.Tiket");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel3.setText("Plat");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel4.setText("Jenis");

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel5.setText("Tanggal Masuk");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        jLabel6.setText("Jam Masuk");

        txtTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiketActionPerformed(evt);
            }
        });

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilihan...", "Roda 2", "Roda 4", "Roda > 4" }));
        cbJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisActionPerformed(evt);
            }
        });

        txtTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTanggal.setEnabled(false);

        txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJam.setEnabled(false);
        txtJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");

        cetakbutton.setText("Cetak struk");
        cetakbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakbuttonActionPerformed(evt);
            }
        });

        tbSimpan.setText("Simpan");
        tbSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSimpanActionPerformed(evt);
            }
        });

        tblParkir.setModel(new javax.swing.table.DefaultTableModel(
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
        tblParkir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblParkirMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblParkir);

        jButton5.setText("Kembali ke Menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        exitbutton.setText("Exit");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        tbEdit.setText("Edit");
        tbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cetakbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tbSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbJenis, 0, 181, Short.MAX_VALUE)
                            .addComponent(txtPlat)
                            .addComponent(txtTiket))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(221, 221, 221))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbSimpan)
                    .addComponent(cetakbutton)
                    .addComponent(jButton4)
                    .addComponent(tbEdit))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(exitbutton))
                .addContainerGap())
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

    private void tbSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSimpanActionPerformed
        // TODO add your handling code here:
        try{
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Nailul","1234");
           str = (Statement)conn.createStatement();
           java.sql.PreparedStatement pstm = conn.prepareStatement("INSERT INTO data VALUES ('"+txtTiket.getText()+"','"+txtPlat.getText()+"','"+cbJenis.getSelectedItem()+"','"+txtTanggal.getText()+"','"+txtJam.getText()+"')");
           pstm.execute();
           JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil");
           tampilkan_data();
           kosongkan_form();
        
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbSimpanActionPerformed

    private void cetakbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakbuttonActionPerformed
        // TODO add your handling code here:
       TiketMasuk tm = new TiketMasuk();
       tm.setVisible(true);
    }//GEN-LAST:event_cetakbuttonActionPerformed
    private JFrame frame;
    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        // TODO add your handling code here:
        frame = new JFrame ("Exit");
       if (JOptionPane.YES_NO_OPTION!= JOptionPane.showConfirmDialog(frame,"Anda ingin keluar?","parking area management",
               JOptionPane.YES_NO_OPTION)) {
       } else {
           System.exit(0);
       }
    }//GEN-LAST:event_exitbuttonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Home hm = new Home();
        hm.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamActionPerformed

    private void cbJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisActionPerformed

    private void txtTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiketActionPerformed

    private void tbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbEditActionPerformed
        // TODO add your handling code here:
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Nailul","1234");
            str = (Statement)conn.createStatement();
            java.sql.PreparedStatement pstm = conn.prepareStatement("UPDATE data SET no_tiket='"+txtTiket.getText()+"',no_plat='"+txtPlat.getText()+"',jenis='"+cbJenis.getSelectedItem()+"',tgl_masuk='"+txtTanggal.getText()+"',jam_masuk='"+txtJam.getText()+"' WHERE no_tiket= '"+txtTiket.getText()+"'");
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
            
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_tbEditActionPerformed

    private void tblParkirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblParkirMouseClicked
        // TODO add your handling code here:
        int baris = tblParkir.rowAtPoint(evt.getPoint());
        
        String notiket = tblParkir.getValueAt(baris, 0).toString();
        txtTiket.setText(notiket);
        
        String noplat = tblParkir.getValueAt(baris, 1).toString();
        txtPlat.setText(noplat);
        
        String jenis = tblParkir.getValueAt(baris, 2).toString();
        cbJenis.setSelectedItem(jenis);
        
        String tanggal = tblParkir.getValueAt(baris, 3).toString();
        txtTanggal.setText(tanggal);
        
        String jam = tblParkir.getValueAt(baris, 4).toString();
        txtJam.setText(jam);
    }//GEN-LAST:event_tblParkirMouseClicked
    
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
            java.util.logging.Logger.getLogger(KendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KendaraanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KendaraanMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JButton cetakbutton;
    private javax.swing.JButton exitbutton;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton tbEdit;
    private javax.swing.JButton tbSimpan;
    private javax.swing.JTable tblParkir;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtPlat;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTiket;
    // End of variables declaration//GEN-END:variables
 
}
