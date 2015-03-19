package model.spel;

/**
 * Created by Jesse on 6/03/2015.
 */
public abstract class Kaart {
    private String naam;

    public Kaart(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

}
