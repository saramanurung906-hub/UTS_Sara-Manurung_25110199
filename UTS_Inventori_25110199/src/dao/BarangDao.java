
package dao;

import model.Barang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangDao {

    // 1. Menampilkan semua data barang
    public List<Barang> getAll() {
        List<Barang> daftar = new ArrayList<>();

        String sql = "SELECT * FROM barang";

        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Barang b = new Barang();

                b.setKodeBarang(rs.getString("kode_barang"));
                b.setNamaBarang(rs.getString("nama_barang"));
                b.setKategori(rs.getString("kategori"));
                b.setStok(rs.getInt("stok"));

                daftar.add(b);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }

        return daftar;
    }

    // 2. Menambahkan data barang
    public boolean tambah(Barang b) {
        String sql = "INSERT INTO barang "
                   + "(kode_barang, nama_barang, kategori, stok) "
                   + "VALUES (?, ?, ?, ?)";

        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getKodeBarang());
            ps.setString(2, b.getNamaBarang());
            ps.setString(3, b.getKategori());
            ps.setInt(4, b.getStok());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
            return false;
        }
    }

    // 3. Mengubah data barang
    public boolean ubah(Barang b) {
        String sql = "UPDATE barang SET nama_barang=?, "
                   + "kategori=?, stok=? WHERE kode_barang=?";

        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getNamaBarang());
            ps.setString(2, b.getKategori());
            ps.setInt(3, b.getStok());
            ps.setString(4, b.getKodeBarang());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
            return false;
        }
    }

    // 4. Menghapus data barang
    public boolean hapus(String kodeBarang) {
        String sql = "DELETE FROM barang WHERE kode_barang=?";

        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kodeBarang);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
            return false;
        }
    }
}
