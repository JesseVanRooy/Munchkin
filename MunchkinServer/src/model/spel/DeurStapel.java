package model.spel;

import model.spel.Kaart;
import model.spel.kaarten.DeurKaart;
import model.spel.kaarten.deurkaarten.CurseKaart;
import model.spel.kaarten.deurkaarten.KlasseKaart;
import model.spel.kaarten.deurkaarten.MonsterKaart;
import model.spel.kaarten.deurkaarten.RasKaart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jesse on 9/03/2015.
 */
public class DeurStapel {
    public static final String BESTANDSNAAM = "res/bin/deurStapel.predef";
    private Savefile savefile;
    private List<DeurKaart> stapel;

    public DeurStapel(){
        this.stapel = new ArrayList<DeurKaart>();
        vullen();
        schudden();
    }

    private void vullen(){
        savefile = new Savefile(BESTANDSNAAM);
        String inhoud = savefile.leesBestand().replaceAll("\n","");
        String[] kaarten = inhoud.split(";");
        List<String[]> kaartAttributen = new ArrayList<String[]>();
        for(String kaart : kaarten){
            kaartAttributen.add(kaart.split(","));
        }
        for(String[] attributen : kaartAttributen){
            switch (Integer.parseInt(attributen[0])){
                case 0 : this.stapel.add(new CurseKaart(attributen[1]));break;
                case 1 : this.stapel.add(new KlasseKaart(attributen[1]));break;
                case 2 : this.stapel.add(new MonsterKaart(attributen[1]));break;
                case 3 : this.stapel.add(new RasKaart(attributen[1]));break;
            }
        }

    }

    private void schudden(){
        Random random = new Random();
        List<DeurKaart> tempKaarten = new ArrayList<DeurKaart>();
        int loopGrootte = stapel.size();
        for(int i=0; i<loopGrootte;i++){
            DeurKaart kaart = stapel.get(random.nextInt(stapel.size()));
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
