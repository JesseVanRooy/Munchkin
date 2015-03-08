package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 6/03/2015.
 */
public class Stapel {
    public static final String BESTANDSNAAM = "/res/bin/stapel.predef";
    private Savefile savefile;
    private List<Kaart> stapel;

    public Stapel(){
        this.stapel = new ArrayList<Kaart>();
        vullen();
    }

    private void vullen(){
        savefile = new Savefile(BESTANDSNAAM);
        String inhoud = savefile.leesBestand();
        String[] kaarten = inhoud.split(";");
        String[][] kaartAttributen = new String[kaarten.length][];
        for(int i = 0; i<kaarten.length; i++){
            kaartAttributen[i] = kaarten[i].split(",");
        }


    }
}
