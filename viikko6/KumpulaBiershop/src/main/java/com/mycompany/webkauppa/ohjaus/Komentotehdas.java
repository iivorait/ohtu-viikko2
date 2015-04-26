/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import com.mycompany.webkauppa.ulkoiset_rajapinnat.PankkiFasaadi;

/**
 *
 * @author iivo
 */
public class Komentotehdas {

    public Komento ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId, Varasto varasto) {
        return new OstoksenLisaysKoriin(ostoskori, tuoteId, varasto);
    }

    public Komento ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId, Varasto varasto) {
        return new OstoksenPoistoKorista(ostoskori, tuoteId, varasto);
    }

    public Komento ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori ostoskori, Varasto varasto, PankkiFasaadi pankki) {
        return new OstoksenSuoritus(nimi, osoite, luottokorttinumero, ostoskori, varasto, pankki);
    }
    
    public OstoksenSuoritus ostoksenSuoritusOlio(String nimi, String osoite, String luottokorttinumero, Ostoskori ostoskori, Varasto varasto, PankkiFasaadi pankki) {
        return new OstoksenSuoritus(nimi, osoite, luottokorttinumero, ostoskori, varasto, pankki);
    }
}
