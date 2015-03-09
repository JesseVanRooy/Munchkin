package model.server;

import model.client.Kaart;
import model.client.kaarten.TreasureKaart;
import model.client.kaarten.treasurekaarten.ArmorKaart;
import model.client.kaarten.treasurekaarten.GoUpALevelKaart;
import model.client.kaarten.treasurekaarten.WapenKaart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jesse on 9/03/2015.
 */
public class TreasureStapel {
    public static final String BESTANDSNAAM = "res/bin/treasureStapel.predef";
    private Savefile savefile;
    private List<TreasureKaart> stapel;

    public TreasureStapel(){
        this.stapel = new ArrayList<TreasureKaart>();
        vullen();
        schudden();
    }

    private void vullen(){
        savefile = new Savefile(BESTANDSNAAM);
        String inhoud = savefile.leesBestand().replaceAll("\n", "");
        String[] kaarten = inhoud.split(";");
        List<String[]> kaartAttributen = new ArrayList<String[]>();

        for(String kaart : kaarten){
            kaartAttributen.add(kaart.split(","));
        }

        for(String[] attributen : kaartAttributen){
            switch (Integer.parseInt(attributen[0])){
                case 4 : this.stapel.add(new ArmorKaart(attributen[1],Integer.parseInt(attributen[2]), ArmorKaart.Type.valueOf(attributen[3]))) ;break;
                case 5 : this.stapel.add(new GoUpALevelKaart(attributen[1],Integer.parseInt(attributen[2])));
                case 6 : this.stapel.add(new WapenKaart(attributen[1],Integer.parseInt(attributen[2]),Integer.parseInt(attributen[3]))) ;break;
            }
        }

    }

    private void schudden(){
        Random random = new Random();
        List<TreasureKaart> tempKaarten = new ArrayList<TreasureKaart>();
        int loopGrootte = stapel.size();
        for(int i=0; i<loopGrootte;i++){
            TreasureKaart kaart = stapel.get(random.nextInt(stapel.size()));
            tempKaarten.add(kaart);
            stapel.remove(kaart);
        }
        this.stapel = tempKaarten;
    }

    public Kaart trekVolgendeKaart(){
        Kaart kaart = stapel.get(0);
        stapel.remove(kaart);
        return kaart;
    }

    public void print(){
        for(Kaart kaart : stapel){
            System.out.println(kaart.getNaam());
        }
    }
}
