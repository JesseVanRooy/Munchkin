package model.server;

import exceptions.ServerConnectieVerstoordException;
import model.client.Speler;

import java.io.*;
import java.net.Socket;

/**
 * Created by Jesse on 9/03/2015.
 */
public class ClientConnectie {
    private Socket socket;
    private InputStreamReader input;
    private BufferedReader bufferedInput;
    private PrintStream output;
    private Speler speler;

    public ClientConnectie(Socket socket) throws IOException{
        this.socket = socket;
        this.input = new InputStreamReader(socket.getInputStream());
        this.bufferedInput = new BufferedReader(input);
        this.output = new PrintStream(socket.getOutputStream());
        lees();
    }

    private void lees() throws IOException{
        String input = bufferedInput.readLine();
        if(input != null){
            System.out.println("SERVER : " + input);
            output.println("bericht ontvangen");
        }
    }

    public void getSpelerInformatie(){
        this.schrijf("SPELER.INFORMATIE");
    }

    public void schrijf(String bericht){
        output.println(bericht);
    }

    public void stopCommunicatie() throws IOException{
        socket.shutdownInput();
        socket.shutdownOutput();
    }

    public void sluitAf() throws IOException{
        socket.close();
    }

    public Speler getSpeler() {
        return speler;
    }
}
