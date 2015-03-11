package model.client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 11/03/2015.
 */
public class ServerConnectie {
    private Socket socket;
    private PrintStream outputStream;
    private InputStreamReader inputStream;
    private BufferedReader bufferedinput;

    public ServerConnectie(int port){
        this("127.0.0.1",port);
    }

    public ServerConnectie(String host, int port){
        try {
            this.socket = new Socket(host, port);
            this.inputStream = new InputStreamReader(socket.getInputStream());
            this.bufferedinput = new BufferedReader(inputStream);
            this.outputStream = new PrintStream(socket.getOutputStream());
            leesInputStream();
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public List<String> leesInputStream(){
        List<String> inputLijst = new ArrayList<String>();
        String lijn;
        try {
            while ((lijn=bufferedinput.readLine())!=null){
                inputLijst.add(lijn);
            }
        }catch (IOException i){
            i.printStackTrace();
        }
        for(String commando : inputLijst){
            System.out.println(commando);
        }
        return inputLijst;
    }

    public void schrijfOutputStream(String bericht){
        this.outputStream.println(bericht);
    }

    public void schrijfOutputStream(List<String> berichten){
        for(String bericht : berichten){
            this.outputStream.println(bericht);
        }

    }
}
