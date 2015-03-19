package model;


/**
 * Created by Jesse on 14/03/2015.
 */
public class ServerData {
    private static final String VERSIE = "Munchkin 1.0.0";

    private ServerLog log;
    private ServerProperties properties;

    public ServerData(){
        this.log = new ServerLog();
        this.properties = new ServerProperties();
    }

    public String getVersie() {
        return VERSIE;
    }

    public ServerProperties getProperties() {
        return properties;
    }

    public ServerLog getLog() {
        return log;
    }
}
