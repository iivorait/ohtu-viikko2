/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAO;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;

/**
 *
 * @author iivo
 */
public class KorvaaVarastonTietokanta implements Komento {
    private Varasto varasto;

    public KorvaaVarastonTietokanta(Varasto varasto) {
        this.varasto = varasto;
    }
    
    @Override
    public boolean suorita() {
        varasto.setTuoteDAO(TuoteDAO.inMemory());
        return true;
    }
    
}
