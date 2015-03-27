package ohtu.verkkokauppa;


public class Kauppa {

    private VarastoInterface varasto;
    private PankkiInterface pankki;
    private Ostoskori ostoskori;
    private ViitegeneraattoriInterface viitegeneraattori;
    private String kaupanTili;
    

    public Kauppa(VarastoInterface varasto, PankkiInterface pankki, ViitegeneraattoriInterface viitegeneraattori) {
        this.varasto = varasto;
        this.pankki = pankki;
        this.viitegeneraattori = viitegeneraattori;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }
    
    public boolean yliSukka(String nimi, String tiliNumero) { //Liian pitkä metodi
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        //väärin sisennetty
        for(int i = 0; i < 4; i++) {
        System.out.println("Moi");
        }
        
        //liikaa sisäkkäisiä if:ejä
        if(viite != 0) {
            if(tiliNumero.equals("10232")) {
                if(summa>500) {
                    System.out.println("Juuh.");
                }
            }
        }
        
        //liikaa sisäkkäisiä for:eja
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.println("Morjenstaa");
            }
        }
        
        //tässä luokassa on jo liikaa if ja for -lausekkeita rikkomaan syklomaattisen koodikompleksisuuden
        
        //ja sitten copypaste:
        System.out.println("Spurdo");
        System.out.println("That");
        System.out.println("Sparde");
        System.out.println("Och");
        System.out.println("Dem");
        System.out.println("Purjo");
        
        System.out.println("Spurdo");
        System.out.println("That");
        System.out.println("Sparde");
        System.out.println("Och");
        System.out.println("Dem");
        System.out.println("Purjo");
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
