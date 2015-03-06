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
    private int level;
    private List<Kaart> rugzak;
    private KlasseKaart klasseKaart;
    private RasKaart rasKaart;
    private ArmorSet armorSet;
    private WapenSet wapenSet;

    public Speler (){
        this(new ArrayList<Kaart>());
    }

    public Speler (List<Kaart> rugzak){
        this.level = 1;
        this.rugzak = rugzak;
        this.armorSet = new ArmorSet();
        this.wapenSet = new WapenSet();

    }

    /* level methodes */

    // OPM : aparte klasse?

    public void gaLevelOmhoog(){
        this.level++;
    }

    public void gaLevelOmlaag(){
        this.level--;
    }

    public void resetLevel(){
        this.level = 1;
    }

    public boolean is10(){
        return this.level==10;
    }

    public int getLevel(){
        return this.level;
    }

    /* rugzak methodes */



    /* klasseKaart methodes */



    /* rasKaart methodes */



    /* armorSet methodes */



    /* wapenSet methodes */
}
