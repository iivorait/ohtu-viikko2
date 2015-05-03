package ohtu.kivipaperisakset;

public class KPSTekoaly extends Peli {

    private IO io;
    private Vastustaja vastustaja;
    
    public KPSTekoaly(IO io, Vastustaja vastustaja) {
        super(io, vastustaja);
        this.io = io;
        this.vastustaja = vastustaja;
    }

    @Override
    protected String toisenPelaajanSiirto() {
        String tokanSiirto = vastustaja.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}