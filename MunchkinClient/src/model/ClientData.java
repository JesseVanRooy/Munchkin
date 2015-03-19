package model;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ClientData {

    private static final String VERSIE = "Munchkin 1.0.0";
    private String naam;

    private ClientLog log;
    private ClientProperties properties;


    public ClientData(String naam){

        this.log = new ClientLog();
        this.naam = naam;
        this.properties = new ClientProperties();
    }

    public String getVersie() {
        return VERSIE;
    }

    public String getNaam() {
        return naam;
    }

    public ClientLog getLog() {
        return log;
    }

    public ClientProperties getProperties() {
        return properties;
    }
}
