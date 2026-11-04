package view;

import dao.BarangDao;
import model.Barang;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class FormBarang extends javax.swing.JFrame {
   private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormBarang.class.getName());


    public FormBarang() {
        initComponents();
        tampilData();
        setLocationRelativeTo(null);
 
    }
    
    private void tampilData() {

    DefaultTableModel model =
            (DefaultTableModel) tblBarang.getModel();

    model.setRowCount(0);

    BarangDao dao = new BarangDao();
    List<Barang> daftar = dao.getAll();

    for (Barang b : daftar) {

        Object[] data = {
            b.getKodeBarang(),
            b.getNamaBarang(),
            b.getKategori(),
            b.getStok()
        };

        model.addRow(data);
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        txtKode = new javax.swing.JTextField();
        cmbKategori = new javax.swing.JComboBox<>();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersihkan = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Pengeloaan Data Barang Laboratorium");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 240, -1));

        jLabel2.setText("Nama Barang :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setText("Kategori :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setText("Stok :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setText("Kode Barang :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 210, -1));
        getContentPane().add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 210, -1));
        getContentPane().add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 210, -1));

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Komputer", "Jaringan", "Alat Ukur" }));
        getContentPane().add(cmbKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 210, -1));

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(this::btnUbahActionPerformed);
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        btnBersihkan.setText("Bersihkan");
        btnBersihkan.addActionListener(this::btnBersihkanActionPerformed);
        getContentPane().add(btnBersihkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Kategori", "Stok"
            }
        ));
        jScrollPane1.setViewportView(tblBarang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 390, -1));

        setBounds(0, 0, 439, 465);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String kode = txtKode.getText().trim();
String nama = txtNama.getText().trim();
String kategori = cmbKategori.getSelectedItem().toString();
String stokText = txtStok.getText().trim();

// Validasi kode dan nama
if (kode.isEmpty() || nama.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Kode dan nama barang tidak boleh kosong!");
    return;
}

// Validasi stok
if (stokText.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Stok tidak boleh kosong!");
    return;
}

int stok;

try {
    stok = Integer.parseInt(stokText);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this,
            "Stok harus berupa angka!");
    return;
}

if (stok < 0) {
    JOptionPane.showMessageDialog(this,
            "Stok tidak boleh kurang dari 0!");
    return;
}

// Membuat objek barang
Barang b = new Barang();

b.setKodeBarang(kode);
b.setNamaBarang(nama);
b.setKategori(kategori);
b.setStok(stok);

// Menyimpan ke database
BarangDao dao = new BarangDao();

if (dao.tambah(b)) {

    JOptionPane.showMessageDialog(this,
            "Data barang berhasil disimpan!");

    tampilData();

    txtKode.setText("");
    txtNama.setText("");
    txtStok.setText("");

} else {

    JOptionPane.showMessageDialog(this,
            "Data barang gagal disimpan!");
}
          
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        String kode = txtKode.getText().trim();
String nama = txtNama.getText().trim();
String kategori = cmbKategori.getSelectedItem().toString();
String stokText = txtStok.getText().trim();

// Validasi kode dan nama
if (kode.isEmpty() || nama.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Kode dan nama barang tidak boleh kosong!");
    return;
}

// Validasi stok
if (stokText.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Stok tidak boleh kosong!");
    return;
}

int stok;

try {
    stok = Integer.parseInt(stokText);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this,
            "Stok harus berupa angka!");
    return;
}

if (stok < 0) {
    JOptionPane.showMessageDialog(this,
            "Stok tidak boleh kurang dari 0!");
    return;
}

// Membuat objek barang
Barang b = new Barang();

b.setKodeBarang(kode);
b.setNamaBarang(nama);
b.setKategori(kategori);
b.setStok(stok);

// Menyimpan ke database
BarangDao dao = new BarangDao();

if (dao.tambah(b)) {

    JOptionPane.showMessageDialog(this,
            "Data barang berhasil disimpan!");

    tampilData();

    txtKode.setText("");
    txtNama.setText("");
    txtStok.setText("");

} else {

    JOptionPane.showMessageDialog(this,
            "Data barang gagal disimpan!");
}
  
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
   
        // Mengambil kode barang
String kode = txtKode.getText().trim();

// Validasi kode barang
if (kode.isEmpty()) {
    JOptionPane.showMessageDialog(this,
            "Pilih data barang yang ingin dihapus!");
    return;
}

// Konfirmasi penghapusan
int konfirmasi = JOptionPane.showConfirmDialog(this,
        "Yakin ingin menghapus data barang ini?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION);

if (konfirmasi == JOptionPane.YES_OPTION) {

    BarangDao dao = new BarangDao();

    if (dao.hapus(kode)) {

        JOptionPane.showMessageDialog(this,
                "Data barang berhasil dihapus!");

        tampilData();

        // Mengosongkan form
        txtKode.setText("");
        txtNama.setText("");
        txtStok.setText("");

    } else {

        JOptionPane.showMessageDialog(this,
                "Data barang gagal dihapus!");
    }
}
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
        // TODO add your handling code here:
        // Mengosongkan semua input
txtKode.setText("");
txtNama.setText("");
txtStok.setText("");

// Mengembalikan pilihan kategori
cmbKategori.setSelectedIndex(0);

// Menghapus pilihan pada tabel
tblBarang.clearSelection();
    }//GEN-LAST:event_btnBersihkanActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormBarang().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
