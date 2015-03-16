package client.model;

import client.exceptions.GeenVerbindingException;
import client.exceptions.ReedsVerbindingException;
import connectie.SpelStream;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ServerManager {

    private SpelStream spelStream;

    public ServerManager(String ip, int port) {
        if(!isVerbonden()){
            this.spelStream = new SpelStream(ip,port);
        }
        else throw new ReedsVerbindingException();

    }

    public void push(String inhoud){
        if(isVerbonden()){
            spelStream.schrijfOutput(inhoud);
        }
        else throw new GeenVerbindingException();
    }

    public String pull(){
        if(isVerbonden()){
            return spelStream.leesInput();
        }
        else throw new GeenVerbindingException();
    }

    public boolean isVerbonden(){
        return this.spelStream!=null;
    }

}
