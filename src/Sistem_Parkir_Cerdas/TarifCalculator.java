package Sistem_Parkir_Cerdas;

import java.time.Duration;
import java.time.LocalDateTime;

public class TarifCalculator 
{
    private final double TARIF_PER_4_JAM = 5000.0;

    public double hitung(LocalDateTime waktuMasuk) 
    {
        LocalDateTime waktuKeluar = LocalDateTime.now();
        long menit = Duration.between(waktuMasuk, waktuKeluar).toMinutes();
        
        // Logika: durasi / 240 menit (4 jam), bulatkan ke atas
        // Misal: 1 menit pun sudah dihitung 1 blok (4 jam pertama)
        double blokWaktu = Math.ceil(menit / 240.0);
        
        if (blokWaktu == 0) blokWaktu = 1; // Minimal bayar 1 blok
        
        return blokWaktu * TARIF_PER_4_JAM;
    }
}
