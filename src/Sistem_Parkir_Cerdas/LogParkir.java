package Sistem_Parkir_Cerdas;

import java.time.LocalDateTime;

public class LogParkir
{
    private String idTransaksi; // ID 001-999
    private String plat;
    private String slotAsal;
    private LocalDateTime masuk;
    private LocalDateTime keluar;
    private double biaya;

    public LogParkir(String id, String plat, String slot, LocalDateTime masuk, double biaya)
    {
        this.idTransaksi = id;
        this.plat = plat;
        this.slotAsal = slot;
        this.masuk = masuk;
        this.keluar = LocalDateTime.now();
        this.biaya = biaya;
    }

    public void cetakLaporan()
    {
        System.out.println("=== LOG TRANSAKSI ===");
        System.out.println("ID: " + idTransaksi + " | Plat: " + plat);
        System.out.println("Lokasi: " + slotAsal + " | Biaya: Rp" + biaya);
        System.out.println("=====================");
    }
}
