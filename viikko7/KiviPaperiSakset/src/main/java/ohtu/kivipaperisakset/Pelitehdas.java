/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.HashMap;

/**
 *
 * @author iivo
 */
public class Pelitehdas {
    private HashMap<String, Peli> pelit;
    
    public Pelitehdas(IO io) {
        pelit = new HashMap<String, Peli>();
        pelit.put("a", new KPSPelaajaVsPelaaja(io, new Ihminen()));
        pelit.put("b", new KPSTekoaly(io, new Tekoaly()));
        pelit.put("c", new KPSTekoaly(io, new TekoalyParannettu(20)));
    }
    
    public Peli hae (String haku) {
        return pelit.get(haku);
    }
}
