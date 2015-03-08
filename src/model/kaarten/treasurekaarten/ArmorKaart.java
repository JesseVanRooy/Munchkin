package model.kaarten.treasurekaarten;

import model.kaarten.TreasureKaart;

/**
 * Created by Jesse on 6/03/2015.
 */
public class ArmorKaart extends TreasureKaart{

    public enum Type{
        HELM,
        CHESTPLATE,
        PANTS,
        BOOTS
    }

    private Type type;

    public ArmorKaart(String naam, int waarde, Type type) {
        super(naam, waarde);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

}
