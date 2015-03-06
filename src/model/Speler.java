package model;

import model.kaarten.deurkaarten.KlasseKaart;
import model.kaarten.deurkaarten.RasKaart;
import model.kaarten.treasurekaarten.WapenKaart;

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
}
