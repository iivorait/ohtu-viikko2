package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {

        IO io = new KonsoliIO();
        Pelitehdas pelit = new Pelitehdas(io);
        
        while (true) {
            
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetetaan");

            String vastaus = io.read();
            Peli peli = pelit.hae(vastaus);
            
            if(peli == null) {
                break;
            }
            
            io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();
        }

    }
}
