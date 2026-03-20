package Sistem_Parkir_Cerdas;

import java.util.ArrayList;
import java.util.List;

public class Lantai
{
    private int indexLantai;
    private List<SlotParkir> daftarSlot;

    public Lantai(int index, int jumlahSlot)
    {
        this.indexLantai = index;
        this.daftarSlot = new ArrayList<>();
        
        // Inisialisasi slot secara urut
        for (int i = 1; i <= jumlahSlot; i++)
        {
            daftarSlot.add(new SlotParkir("L" + (index + 1) + "-No" + i));
        }
    }

    public SlotParkir cariSlotKosong() 
    {
        for (SlotParkir slot : daftarSlot)
        {
            if (!slot.isAdaKendaraan())
            {
                return slot; // Ambil yang paling awal (index terkecil)
            }
        }
        return null; // Lantai ini penuh
    }

    public List<SlotParkir> getDaftarSlot()
    {
        return daftarSlot;
    }
}
