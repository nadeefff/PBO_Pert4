/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author LENOVO
 */
public class Exception_Nadif extends Exception {
    // Kelas yang merepresentasikan exception yang didefinisikan pengguna
    public Exception_Nadif(String message) {
        // Memanggil konstruktor dari kelas parent Exception
        super(message);
    }

// Kelas utama yang menggunakan Zia
    public static void main(String[] args) {
        try {
            // Melempar objek dari exception yang didefinisikan pengguna
            throw new Exception_Nadif("Ini adalah pesan dari exception Zia");
        } catch (Exception_Nadif ex) {
            System.out.println("Exception ditangkap");

            // Mencetak pesan dari objek Zia
            System.out.println(ex.getMessage());
        }
    }
}
