package Sistem_Parkir_Cerdas;

public class SlotParkir 
{
    private String idSlot;
    private boolean adaKendaraan;
    private Kendaraan kendaraan;

    public SlotParkir(String idSlot)
    {
        this.idSlot = idSlot;
        this.adaKendaraan = false;
    }

    public void setIdSlot(String idSlot)
    {
        this.idSlot = idSlot;
    }

    public void setAdaKendaraan(Kendaraan kendaraan)
    {
        this.kendaraan = kendaraan;
        this.adaKendaraan = true;
    }
    
    public void kosongkanSlot()
    {
        this.kendaraan = null;
        this.adaKendaraan = false;
    }    

    public String getIdSlot()
    {
        return idSlot;
    }

    public boolean isAdaKendaraan() 
    {
        return adaKendaraan;
    }

    public Kendaraan getKendaraan()
    {
        return kendaraan;
    }
}
