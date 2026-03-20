package Sistem_Parkir_Cerdas;

import java.time.LocalDateTime;

public class Kendaraan 
{
    private String noPlat;
    private String jenis; // Mobil atau Motor
    private LocalDateTime waktuMasuk;

    public Kendaraan(String noPlat, String jenis) 
    {
        this.noPlat = noPlat;
        this.jenis = jenis;
        this.waktuMasuk = LocalDateTime.now();
    }

    // Getter & Setter
    public String getNoPlat()
    {
        return noPlat;
    }

    public String getJenis()
    {
        return jenis;
    }

    public LocalDateTime getWaktuMasuk()
    {
        return waktuMasuk;
    }
}
