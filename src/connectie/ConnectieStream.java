package connectie;


import client.exceptions.VerbindingVerstoordException;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by Jesse on 14/03/2015.
 */
public class ConnectieStream {

    private String ip;
    private int port;

    private Socket verbinding;

    private InputPipeLine inputPipeLine;
    private OutputPipeLine outputPipeLine;

    public ConnectieStream(String ip, int port) {
        this.ip = ip;
        this.port = port;
        maakConnectie();
    }

    private void maakConnectie(){
        try {
            this.verbinding = new Socket(ip,port);
            this.inputPipeLine = new InputPipeLine(verbinding.getInputStream());
            this.outputPipeLine = new OutputPipeLine(verbinding.getOutputStream());

        }catch (IOException i){
            throw new VerbindingVerstoordException();
        }

    }

    public void schrijfOutput(String inhoud){
        outputPipeLine.schrijf(inhoud.getBytes());
    }

    public String leesInput(){
        ByteBuffer byteBuffer = ByteBuffer.wrap(inputPipeLine.lees());
        return byteBuffer.toString();
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}