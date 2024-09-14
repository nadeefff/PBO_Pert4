package Pert4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Pert4 {

    Connection koneksi;
    Statement pernyataan;
    PreparedStatement pernyataanSiap = null;

    String driverDB = "org.postgresql.Driver";
    String urlKoneksi = "jdbc:postgresql://localhost:5432/tokobuku_db"; // Replace with your DB
    String penggunaDB = "postgres"; // Replace with your PostgreSQL username
    String sandiDB = "your_password"; // Replace with your PostgreSQL password

    InputStreamReader pembacaAliranInput = new InputStreamReader(System.in);
    BufferedReader pembacaInput = new BufferedReader(pembacaAliranInput);

    // Function to add a new student (Insert)
    public void tambahMahasiswa() {
        try {
            Class.forName(driverDB);
            koneksi = DriverManager.getConnection(urlKoneksi, penggunaDB, sandiDB);
            koneksi.setAutoCommit(false);

            String sqlTambah = "INSERT INTO daftar_mahasiswa VALUES(?,?,?,?)";
            pernyataanSiap = koneksi.prepareStatement(sqlTambah);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN DATA MAHASISWA ");
                System.out.print("ID Mahasiswa : ");
                String idMahasiswa = pembacaInput.readLine().trim();
                System.out.print("Nama Mahasiswa : ");
                String namaMahasiswa = pembacaInput.readLine().trim();
                System.out.print("Jurusan : ");
                String jurusan = pembacaInput.readLine().trim();
                System.out.print("Semester : ");
                String semester = pembacaInput.readLine().trim();

                pernyataanSiap.setLong(1, Long.parseLong(idMahasiswa));
                pernyataanSiap.setString(2, namaMahasiswa);
                pernyataanSiap.setString(3, jurusan);
                pernyataanSiap.setInt(4, Integer.parseInt(semester));
                pernyataanSiap.executeUpdate();

                System.out.print("Apakah Anda ingin memasukkan data mahasiswa lainnya? (iya/tidak): ");
                String pilihan = pembacaInput.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true;
                }
            }

            koneksi.commit();
            pernyataanSiap.close();
            koneksi.close();
            System.out.println("Data berhasil dimasukkan.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert.");
            ex.printStackTrace();
            try {
                if (koneksi != null) {
                    koneksi.rollback();
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }
    }

    // Function to display all student data (Select)
    public void tampilkanDataMahasiswa() {
        try {
            Class.forName(driverDB);
            String sqlSelect = "SELECT * FROM daftar_mahasiswa";
            koneksi = DriverManager.getConnection(urlKoneksi, penggunaDB, sandiDB);
            pernyataan = koneksi.createStatement();

            ResultSet hasil = pernyataan.executeQuery(sqlSelect);
            while (hasil.next()) {
                System.out.println(
                        "ID: " + hasil.getLong("id_mahasiswa") +
                        ", Nama: " + hasil.getString("nama_mahasiswa") +
                        ", Jurusan: " + hasil.getString("jurusan") +
                        ", Semester: " + hasil.getInt("semester"));
            }

            hasil.close();
            pernyataan.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) throws IOException {
        Pert4 aplikasi = new Pert4();
        BufferedReader pembacaInput = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            String pilihan = pembacaInput.readLine().trim();
            switch (pilihan) {
                case "1":
                    aplikasi.tambahMahasiswa();
                    break;
                case "2":
                    aplikasi.tampilkanDataMahasiswa();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
