package model.client.kaarten;

import model.client.Kaart;

/**
 * Created by Jesse on 6/03/2015.
 */
public abstract class TreasureKaart extends Kaart{

    private int waarde;

    public TreasureKaart(String naam, int waarde){
        super(naam);
        this.waarde = waarde;
    }

    public int getWaarde() {
        return waarde;
    }
}
