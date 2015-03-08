package model;

import exceptions.VerkeerdeKaartSoortException;
import model.kaarten.treasurekaarten.ArmorKaart;

import java.util.List;

/**
 * Created by Jesse on 6/03/2015.
 */
public class ArmorSet {
    private ArmorKaart helm, chestPlate, pants, boots;

    private Speler speler;

    public ArmorSet(Speler speler){
        this.speler = speler;
    }

    public void setHelm(Kaart kaart){
        if((kaart.getClass().equals(ArmorKaart.class))){
            ArmorKaart armorKaart = (ArmorKaart)kaart;
            if(armorKaart.getType() == ArmorKaart.Type.HELM){
                if(helm != null){
                    speler.getRugzak().add(this.helm);
                }
                this.helm = armorKaart;
            }
        }
        else throw new VerkeerdeKaartSoortException();
    }

    public void setChestPlate(Kaart kaart){
        if((kaart.getClass().equals(ArmorKaart.class))){
            ArmorKaart armorKaart = (ArmorKaart)kaart;
            if(armorKaart.getType() == ArmorKaart.Type.CHESTPLATE){
                if(chestPlate != null){
                    speler.getRugzak().add(this.chestPlate);
                }
                this.chestPlate = armorKaart;
            }
        }
        else throw new VerkeerdeKaartSoortException();
    }

    public void setPants(Kaart kaart){
        if((kaart.getClass().equals(ArmorKaart.class))){
            ArmorKaart armorKaart = (ArmorKaart)kaart;
            if(armorKaart.getType() == ArmorKaart.Type.PANTS){
                if(pants != null){
                    speler.getRugzak().add(this.pants);
                }
                this.pants = armorKaart;
            }
        }
        else throw new VerkeerdeKaartSoortException();
    }

    public void setBoots(Kaart kaart){
        if((kaart.getClass().equals(ArmorKaart.class))){
            ArmorKaart armorKaart = (ArmorKaart)kaart;
            if(armorKaart.getType() == ArmorKaart.Type.BOOTS){
                if(boots != null){
                    speler.getRugzak().add(this.boots);
                }
                this.boots = armorKaart;
            }
        }
        else throw new VerkeerdeKaartSoortException();
    }

    public ArmorKaart getHelm() {
        return helm;
    }

    public ArmorKaart getChestPlate() {
        return chestPlate;
    }

    public ArmorKaart getPants() {
        return pants;
    }

    public ArmorKaart getBoots() {
        return boots;
    }
}
