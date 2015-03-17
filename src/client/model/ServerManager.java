package client.model;

import client.exceptions.GeenVerbindingException;
import client.exceptions.ReedsVerbindingException;
import client.exceptions.VerbindingVerstoordException;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ServerManager {

    private String ip;
    private int port;

    private Socket verbinding;

    private InputPipeLine inputPipeLine;
    private OutputPipeLine outputPipeLine;

    public ServerManager(String ip, int port) {
        if(!isVerbonden()){
            try {
                this.verbinding = new Socket(ip, port);
                this.inputPipeLine = new InputPipeLine(verbinding.getInputStream());
                this.outputPipeLine = new OutputPipeLine(verbinding.getOutputStream());
            } catch (IOException e) {
                throw new VerbindingVerstoordException();
            }
        }
        else throw new ReedsVerbindingException();

    }

    public void push(String inhoud){
        if(isVerbonden()){
            outputPipeLine.schrijf(inhoud.getBytes());
        }
        else throw new GeenVerbindingException();
    }

    public String pull(){
        if(isVerbonden()){
            StringBuilder inhoud = new StringBuilder();
            byte[] byteArray = inputPipeLine.lees();
            for(byte b : byteArray){
                inhoud.append((char)b);
            }
            return inhoud.toString();
        }
        else throw new GeenVerbindingException();
    }

    public boolean isVerbonden(){
        return this.verbinding!=null;
    }

}
