package model.spel.kaarten.treasurekaarten;

import model.spel.kaarten.TreasureKaart;

/**
 * Created by Jesse on 6/03/2015.
 */
public class WapenKaart extends TreasureKaart{

    private int aantalGebruikteHanden;

    public WapenKaart(String naam, int waarde, int aantalGebruikteHanden) {
        super(naam, waarde);
        this.aantalGebruikteHanden = aantalGebruikteHanden;
    }

    public int getAantalGebruikteHanden() {
        return aantalGebruikteHanden;
    }

}
