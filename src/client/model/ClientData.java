package client.model;

import connectie.ConnectieStream;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ClientData {
    private String versie;

    private ConnectieStream connectieStream;

    public ClientData(){
        this.versie = "Munchkin Client - 1.0.0";
    }

    public String getVersie() {
        return versie;
    }

    public void verbindMetStream(String ip, int port){
        this.connectieStream = new ConnectieStream(ip, port);
        /* TODO : maak methode aan */
    }

    public void push(){
        /* TODO : maak methode aan */
    }

    public String pull(){
        /* TODO : maak methode aan */
        return "";
    }

    public boolean isVerbonden(){
        return connectieStream!=null;
    }

}
