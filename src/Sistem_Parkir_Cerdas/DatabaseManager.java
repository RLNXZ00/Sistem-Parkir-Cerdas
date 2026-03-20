package Sistem_Parkir_Cerdas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseManager 
{
    // Deklarasi atribut bertipe objek Connection untuk inisialisasi status koneksi
    private static Connection activeConnection = null; // Inisialisasi atribut bernilai null (koneksi belum aktif)
    
    // Method untuk mendapatkan koneksi database
    public Connection getConnection()
    {
        // Deklarasi dan inisialisasi variabel bertipe String untuk konfigurasi database
        String user = "hr";
        String password = "TLYNWFLYNL";
        
        // Load Driver
        // Exception Handling
        try // Mencoba menjalankan perintah dalam blok
        {
            // Instruksi untuk memuat dan meregistrasi driver JDBC Oracle.
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } 
        catch (ClassNotFoundException ex) // Jika terjadi kesalahan
        {
            // Tampilkan pesan pop-up "Driver tidak ditemukan" dan error yang didapati 
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan." + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Branching untuk melakukan salah satu dari dua koneksi database (server database localhost milik saya dan server database kampus)
        if (activeConnection == null) // Jika koneksi belum aktif (server database localhost), maka:
        {
            // Exception Handling untuk menangani server database localhost
            try // Mencoba menjalankan perintah dalam blok
            {
                // Koneksi ke server database localhost
                activeConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", user, password);
                
                // Panggil setAutoCommit(boolean) untuk melakukan commit secara manual
                activeConnection.setAutoCommit(false); // Inisialisasi false agar commit dilakukan secara manual
            } 
            catch (SQLException ex) // Jika terjadi kesalahan
            {
                // Tampilkan pesan pop-up "Koneksi Gagal." dan error yang didapati 
                JOptionPane.showMessageDialog(null, "Koneksi Gagal. " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                activeConnection = null; // Jika gagal set atribut activeConnection menjadi null untuk menghindari bug
                return null; // Kembalikan null (tidak ada yang dikembalikan)
            }
        } 
        
//        if (activeConnection == null) // Jika koneksi belum aktif (server database kampus), maka:
//        {
//            // Exception Handling untuk menangani server database kampus
//            try // Mencoba menjalankan perintah dalam blok
//            {
//                // Koneksi ke server database kampus
//                activeConnection = DriverManager.getConnection("jdbc:oracle:thin:@172.23.9.183:1521:orcl", user, password);
//                
//                // Panggil setAutoCommit(boolean) untuk melakukan commit secara manual
//                activeConnection.setAutoCommit(false); // Inisialisasi false agar commit dilakukan secara manual
//            } 
//            catch (SQLException ex) // Jika terjadi kesalahan 
//            {
//                // Tampilkan pesan pop-up "Koneksi Gagal." dan error yang didapati  
//                JOptionPane.showMessageDialog(null, "Koneksi Gagal. " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                activeConnection = null; // Jika gagal set atribut activeConnection menjadi null untuk menghindari bug
//                return null; // Kembalikan null (tidak ada yang dikembalikan)
//            }
//        }
        
        // Jika koneksi berhasil / sudah ada, maka:
        if (activeConnection != null) 
        {
            // Tampilkan pesan pop-up "Koneksi Berhasil." 
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil.");
        }
        
        return activeConnection; // Kembalikan atribut activeConnection (koneksi berhasil atau gagal)
    }
    
    // Method getter untuk mendapatkan koneksi yang telah diinisialisasikan atau aktif yang digunakan oleh CRUD
    public static Connection getActiveConnection() 
    {
        return activeConnection; // Kembalikan atribut activeConnection (berisikan koneksi yang telah diinisialisasi)
    }
    
    // Method untuk menutup koneksi
    public static void closeActiveConnection()
    {
        // Jika activeConnection tidak bernilai null, maka:
        if (activeConnection != null) 
        {
            // Exception Handling untuk menangani server database kampus
            try
            {
                // Menutup resource database
                activeConnection.close(); // Menutup koneksi database
                activeConnection = null;  // Set activeConnection menjadi null untuk menonaktifkan koneksi
            } 
            catch (SQLException e) // Jika terjadi kesalahan
            {
                // Tampilkan pesan pop-up "Gagal menutup koneksi database:" dan error yang didapati  
                JOptionPane.showMessageDialog(null, "Gagal menutup koneksi database: " + e.getMessage());
            }
        }
    }
}
