/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pert4;
/**
 *
 * @author LENOVO
 */
import java.util.Scanner;
// Kelas utama yang mencakup pengecualian kustom, try-catch, dan throws
public class TryCatchException {

    // Pengecualian kustom untuk menangani nama yang terlalu pendek
    public static class NameTooShortException extends Exception {
        public NameTooShortException(String pesan) {
            super(pesan);
        }
    }

    // Metode yang akan melempar pengecualian kustom jika nama terlalu pendek
    public void periksaNama(String nama) throws NameTooShortException {
        if (nama.length() < 3) {
            throw new NameTooShortException("Nama terlalu pendek, harus lebih dari 2 karakter.");
        } else {
            System.out.println("Nama valid: " + nama);
        }
    }

    // Metode utama untuk menjalankan program
    public void jalankanValidasi() {
        Scanner input = new Scanner(System.in);

        try {
            // Meminta input nama dari pengguna
            System.out.print("Masukkan nama: ");
            String nama = input.nextLine();

            // Memvalidasi nama yang dimasukkan
            periksaNama(nama);

        } catch (NameTooShortException e) {
            // Menangani pengecualian jika nama terlalu pendek
            System.out.println("Kesalahan: " + e.getMessage());
        } catch (Exception e) {
            // Menangani pengecualian umum lainnya
            System.out.println("Kesalahan tidak terduga: " + e.getMessage());
        } finally {
            input.close(); // Menutup input scanner
        }
    }

    // Metode main untuk menjalankan program
    public static void main(String[] args) {
        TryCatchException program = new TryCatchException();
        program.jalankanValidasi(); // Memanggil metode untuk menjalankan validasi nama
    }
}
