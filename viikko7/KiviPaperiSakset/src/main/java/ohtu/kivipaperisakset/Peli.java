/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author iivo
 */
public abstract class Peli {
    private Vastustaja vastustaja;
    private IO io;
    
    public Peli(IO io, Vastustaja vastustaja) {
        this.io = io;
        this.vastustaja = vastustaja;
    }
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        while(true) {
            io.print("Ensimmäisen pelaajan siirto: ");
            String ekanSiirto = io.read();
            
            String tokanSiirto = toisenPelaajanSiirto();
            
            if(!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                break;
            }
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("");
        }
        

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract String toisenPelaajanSiirto();
}
