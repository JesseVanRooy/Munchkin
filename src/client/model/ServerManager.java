package client.model;

import connectie.SpelStream;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ServerManager {

    private SpelStream spelStream;

    public ServerManager(String ip, int port) {
        this.spelStream = new SpelStream(ip,port);
    }

    public void push(){
        /* TODO : maak methode aan */
    }

    public String pull(){
        /* TODO : maak methode aan */
        return "";
    }

}
