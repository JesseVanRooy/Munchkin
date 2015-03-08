package model;

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
    }
}
