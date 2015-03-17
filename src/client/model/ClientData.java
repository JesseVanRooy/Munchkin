package client.model;

import client.exceptions.GeenVerbindingException;
import client.exceptions.ReedsVerbindingException;
import client.exceptions.VerbindingVerstoordException;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

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
