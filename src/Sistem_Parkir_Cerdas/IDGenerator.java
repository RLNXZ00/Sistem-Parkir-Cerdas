package Sistem_Parkir_Cerdas;

public class IDGenerator 
{
    private static int counter = 1;

    public static String generateID() 
    {
        // Format menjadi 3 digit (001, 002, dst)
        String id = String.format("%03d", counter);
        counter++;
        if (counter > 999) counter = 1; // Reset ke 001
        return id;
    }
}
