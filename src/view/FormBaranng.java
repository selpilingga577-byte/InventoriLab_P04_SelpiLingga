package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;


public class FormBaranng extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final List<Barang> daftarBarang = new ArrayList<Barang>();
    private DefaultTableModel modelTable;
    private DefaultTableModel modelTabel;
    
    public FormBaranng() {
        initComponents();
        siapkanTabel();
        isiDataContoh();
        setLocationRelativeTo(null);
}
    

    private void siapkanTabel() {
    modelTabel = new DefaultTableModel(
            new Object[]{"Kode", "Nama Barang", "Tersedia"}, 0) {
        private static final long serialVersionUID = 1L;
        
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        
        };
    tblBarang.setModel(modelTabel);
    tblBarang.setRowHeight(26);
    tblBarang.getTableHeader().setReorderingAllowed(false);
    
}
    private void isiDataContoh() {
    daftarBarang.add(new Barang("BRG-001", "Keyboard USB", 10));
    daftarBarang.add(new Barang("BRG-002", "Mouse USB", 8));
    perbaruiTabel();
    lblStatus.setText("Siap. Dua data contoh dimuat di memori.");
}
    private void perbaruiTabel() {
    modelTabel.setRowCount(0);
    for (Barang barang : daftarBarang) {
        modelTabel.addRow(new Object[]{
            barang.getKode(),
            barang.getNama(),
            barang.getJumlahTersedia()
        });
    }
}
private void bersihkanInput() {
    txtKode.setText("");
    txtNama.setText("");
    txtJumlah.setText("");
    txtKode.requestFocusInWindow();
}
private void tambahDemo() {
    String kode = txtKode.getText().trim();
    String nama = txtNama.getText().trim();
    String teksJumlah = txtJumlah.getText().trim();

    try {
        if (kode.isEmpty() || nama.isEmpty() || teksJumlah.isEmpty()) {
            throw new IllegalArgumentException(
                    "Kode, nama, dan jumlah wajib diisi.");
        }

        int jumlah = Integer.parseInt(teksJumlah);
        Barang barang = new Barang(kode, nama, jumlah);
        daftarBarang.add(barang);
        perbaruiTabel();
        bersihkanInput();
        lblStatus.setText("Barang " + barang.getNama()
                + " ditambahkan ke daftar sementara.");
    } catch (NumberFormatException e) {
        lblStatus.setText("Jumlah belum valid. Data tidak ditambahkan.");
        JOptionPane.showMessageDialog(this,
                "Jumlah harus bilangan bulat antara 0 dan 2147483647.",
                "Input jumlah", JOptionPane.WARNING_MESSAGE);
        txtJumlah.requestFocusInWindow();
        txtJumlah.selectAll();
        } catch (IllegalArgumentException e) {
        lblStatus.setText("Data tidak ditambahkan: " + e.getMessage());
        JOptionPane.showMessageDialog(this, e.getMessage(),
                "Periksa data barang", JOptionPane.WARNING_MESSAGE);
    }
}
    
    

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        lblKode = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lbllJumlah = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        btnTutup = new javax.swing.JToggleButton();
        lblStatus = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventori Laoratorium - Data Barang");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("INVENTORI LABORATORIUM");

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblInfo.setText("Latihan antarmuka - data tersimpn sementara");

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));

        lblKode.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblKode.setText("Kode Barang");
        lblKode.setToolTipText("");

        lblNama.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblNama.setText("Nama Barang");

        lbllJumlah.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbllJumlah.setText("Jumlah Tersedia");

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBarang);

        btnTambah.setText("Tambah Demo");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnBersihkan.setText("Bersihkan Input");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        lblStatus.setText("Siap.Isi data barang");

        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNama)
                            .addComponent(lblKode)
                            .addComponent(lbllJumlah))
                        .addGap(36, 36, 36)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addComponent(btnBersihkan)
                                .addGap(56, 56, 56)
                                .addComponent(btnTutup))
                            .addComponent(txtKode)
                            .addComponent(txtNama)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblKode))
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbllJumlah))))
                .addGap(51, 51, 51)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnBersihkan)
                    .addComponent(btnTutup))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
bersihkanInput();
lblStatus.setText("Input dibersihkan. Daftar barang tetap.");        // TODO add your handling code here:
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnTutupActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
tambahDemo();        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeActionPerformed

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
            java.util.logging.Logger.getLogger(FormBaranng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBaranng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBaranng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBaranng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBaranng().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JToggleButton btnTutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lbllJumlah;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}