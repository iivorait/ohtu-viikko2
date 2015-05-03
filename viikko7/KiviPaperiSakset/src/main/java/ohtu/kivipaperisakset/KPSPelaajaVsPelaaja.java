package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Peli {

    private IO io;
    private Vastustaja vastustaja;
    
    public KPSPelaajaVsPelaaja(IO io, Vastustaja vastustaja) {
        super(io, vastustaja);
        this.io = io;
        this.vastustaja = vastustaja;
    }

    @Override
    protected String toisenPelaajanSiirto() {
        io.print("Toisen pelaajan siirto: ");
        String tokanSiirto = vastustaja.annaSiirto();
        return tokanSiirto;
    }

}