
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IllegalArgumentException("Kapasiteetti tai kasvatuskoko väärin");
        }

        joukko = new int[kapasiteetti];
       
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == joukko.length) {
                joukko = Arrays.copyOf(joukko, alkioidenLkm + kasvatuskoko);   
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i : joukko) {
            if(i == luku) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int kohta = 0; kohta < alkioidenLkm; kohta++) {
            if (luku == joukko[kohta]) {
                alkioidenLkm--;
                for (int j = kohta; j <= alkioidenLkm; j++) {
                    joukko[j] = joukko[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm; i++) {
                tuotos += joukko[i];
                if(i < alkioidenLkm - 1) {
                    tuotos += ", ";
                }
            }
            tuotos += "}";
            return tuotos;
    }

    public int[] toIntArray() {
        return Arrays.copyOf(joukko, alkioidenLkm);
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();

        for (int i : a.toIntArray()) {
            uusiJoukko.lisaa(i);
        }
        for (int i : b.toIntArray()) {
            uusiJoukko.lisaa(i);
        }
        return uusiJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();

        for (int i : a.toIntArray()) {
            if(b.kuuluu(i)) {
                uusiJoukko.lisaa(i);
            }
        }
        
        return uusiJoukko;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();

        for (int i : a.toIntArray()) {
            uusiJoukko.lisaa(i);
        }
        for (int i : b.toIntArray()) {
            uusiJoukko.poista(i);
        }
        return uusiJoukko;
    }
        
}