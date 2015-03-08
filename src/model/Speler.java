package model;

import exceptions.VerkeerdeKaartSoortException;
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
        this.armorSet = new ArmorSet(this);
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

    public void verwijderKaart(Kaart kaart) {
        this.rugzak.remove(kaart);
    }

    public Kaart getKaart(int index){
        return rugzak.get(index);
    }

    public boolean isVol(){
        return this.rugzak.size()>=5;
    }

    public List<Kaart> getRugzak() {
        return rugzak;
    }

    /* klasseKaart methodes */

    public void setKaartAlsKlasseKaart(Kaart kaart){
        if(kaart.getClass().equals(KlasseKaart.class)){
            this.klasseKaart = (KlasseKaart)kaart;
        }else {
            throw new VerkeerdeKaartSoortException();
        }
    }

    public void setKaartAlsKlasseKaart(int index){
        Kaart kaart = getKaart(index);
        if(kaart.getClass().equals(KlasseKaart.class)){
            this.klasseKaart = (KlasseKaart)kaart;
            this.rugzak.remove(kaart);
        }else {
            throw new VerkeerdeKaartSoortException();
        }
    }

    public KlasseKaart getKlasseKaart(){
        return this.klasseKaart;
    }

    /* rasKaart methodes */

    public void setKaartAlsRasKaart(Kaart kaart){
        if(kaart.getClass().equals(RasKaart.class)){
            this.rasKaart = (RasKaart)kaart;
        }else {
            throw new VerkeerdeKaartSoortException();
        }
    }

    public void setKaartAlsRasKaart(int index){
        Kaart kaart = getKaart(index);
        if(kaart.getClass().equals(RasKaart.class)){
            this.rasKaart = (RasKaart)kaart;
            this.rugzak.remove(kaart);
        }else {
            throw new VerkeerdeKaartSoortException();
        }
    }

    public RasKaart getRasKaart() {
        return rasKaart;
    }

    /* armorSet methodes */

    public ArmorSet getArmorSet() {
        return armorSet;
    }

    /* wapenSet methodes */

    public WapenSet getWapenSet() {
        return wapenSet;
    }
}
