package client.model;

import client.exceptions.GeenVerbindingException;
import client.exceptions.ReedsVerbindingException;
import connectie.ConnectieStream;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ClientData {
    private String versie;
    private String naam;

    private ConnectieStream connectieStream;

    public ClientData(){
        this.versie = "Munchkin Client - 1.0.0";
    }

    public String getVersie() {
        return versie;
    }

    public void verbindMetStream(String ip, int port){
        if(!isVerbonden()){
            this.connectieStream = new ConnectieStream(ip, port);
        }
        else throw new ReedsVerbindingException();
    }

    public void push(String inhoud){
        if(isVerbonden()){
            connectieStream.schrijfOutput(inhoud);
        }
        else throw new GeenVerbindingException();
    }

    public String pull(){
        if(isVerbonden()){
            return connectieStream.leesInput();
        }
        else throw new GeenVerbindingException();
    }

    public boolean isVerbonden(){
        return connectieStream!=null;
    }

}
