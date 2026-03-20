package Sistem_Parkir_Cerdas;

import java.util.ArrayList;

public class SistemUtama 
{
    private ArrayList<Lantai> listLantai;
    private ArrayList<LogParkir> historiParkir = new ArrayList<>();
    private TarifCalculator calculator = new TarifCalculator();

    public SistemUtama(int jumlahLantai, int slotPerLantai)
    {
        listLantai = new ArrayList<>();
        for (int i = 0; i < jumlahLantai; i++)
        {
            listLantai.add(new Lantai(i, slotPerLantai));
        }
    }

    public void prosesMasuk(String plat, String jenis)
    {
        Kendaraan baru = new Kendaraan(plat, jenis);
        for (Lantai l : listLantai)
        {
            SlotParkir slot = l.cariSlotKosong();
            if (slot != null) 
            {
                slot.setAdaKendaraan(baru);
                System.out.println("Kendaraan Masuk: " + plat + " di " + slot.getIdSlot());
                return;
            }
        }
    }

    public void prosesKeluar(String idSlotCari) 
    {
        for (Lantai l : listLantai)
        {
            for (SlotParkir slot : l.getDaftarSlot())
            {
                if (slot.getIdSlot().equals(idSlotCari) && slot.isAdaKendaraan())
                {
                    Kendaraan k = slot.getKendaraan();
                    
                    // 1. Hitung Biaya
                    double biaya = calculator.hitung(k.getWaktuMasuk());
                    
                    // 2. Generate ID 001-999
                    String idTrans = IDGenerator.generateID();
                    
                    // 3. Simpan ke Log
                    LogParkir log = new LogParkir(idTrans, k.getNoPlat(), slot.getIdSlot(), k.getWaktuMasuk(), biaya);
                    historiParkir.add(log);
                    
                    // 4. Output dan Kosongkan
                    log.cetakLaporan();
                    slot.kosongkanSlot();
                    return;
                }
            }
        }
        
        System.out.println("Slot tidak ditemukan atau sudah kosong.");
    }
}
