package model.spel;

import exceptions.VerkeerdeKaartSoortException;
import model.spel.kaarten.treasurekaarten.WapenKaart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 6/03/2015.
 */
public class WapenSet {
    private List<WapenKaart> wapens;
    private int aantalHanden;
    private int aantalGebruikteHanden;


    public WapenSet() {
        this.wapens = new ArrayList<WapenKaart>();
        this.aantalHanden = 2;
        this.aantalGebruikteHanden = 0;
    }

    public void voegHandToe(){
        this.aantalHanden++;
    }

    public void verwijderHand(){
        this.aantalHanden--;
    }

    public void voegWapenKaartToe(Kaart kaart){
        if((kaart.getClass().equals(WapenKaart.class))){
            WapenKaart wapenKaart = (WapenKaart)kaart;
            if((aantalHanden-aantalGebruikteHanden) >= wapenKaart.getAantalGebruikteHanden()){
                aantalGebruikteHanden += wapenKaart.getAantalGebruikteHanden();
                wapens.add(wapenKaart);
            }

        }
        else throw new VerkeerdeKaartSoortException();
    }

    public void verwijderWapenKaart(WapenKaart wapenKaart){
        aantalGebruikteHanden -= wapenKaart.getAantalGebruikteHanden();
        this.wapens.remove(wapenKaart);
    }

    public void verwijderWapenKaart(int index){
        aantalGebruikteHanden -= wapens.get(index).getAantalGebruikteHanden();
        this.wapens.remove(index);
    }
}
