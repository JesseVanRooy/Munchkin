package model;

import model.kaarten.deurkaarten.KlasseKaart;
import model.kaarten.deurkaarten.RasKaart;
import model.kaarten.treasurekaarten.WapenKaart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 6/03/2015.
 */
public class Speler {
    private Level level;
    private List<Kaart> rugzak;
    private KlasseKaart klasseKaart;
    private RasKaart rasKaart;
    private ArmorSet armorSet;
    private WapenSet wapenSet;

    public Speler (){
        this(new ArrayList<Kaart>());
    }

    public Speler (List<Kaart> rugzak){
        this.level = new Level();
        this.rugzak = rugzak;
        this.armorSet = new ArmorSet();
        this.wapenSet = new WapenSet();

    }

    /* specifieke speler methodes */

    /* level methodes */

    public Level getLevel() {
        return level;
    }

    /* rugzak methodes */

    public void voegKaartToe(Kaart kaart){
        this.rugzak.add(kaart);
    }

    public Kaart getKaart(int index){
        return rugzak.get(index);
    }

    public boolean isVol(){
        return this.rugzak.size()>=5;
    }

    /* klasseKaart methodes */

    public void setKaartAlsKlasseKaart(Kaart kaart){
        if(kaart.getClass().equals(KlasseKaart.class)){

        }
    }

    public KlasseKaart getKlasseKaart(){
        return this.klasseKaart;
    }

    /* rasKaart methodes */



    /* armorSet methodes */



    /* wapenSet methodes */
}
