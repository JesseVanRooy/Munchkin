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
    private PrintStream outputStream;
    private InputStream inputStream;
    private BufferedInputStream bufferedinput;

    public ClientConnectie(Socket socket){
        this.socket = socket;
        try {
            this.inputStream = socket.getInputStream();
            this.bufferedinput = new BufferedInputStream(inputStream);
            this.outputStream = new PrintStream(socket.getOutputStream());
        }catch (IOException i){
            i.printStackTrace();
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public PrintStream getOutputStream() {
        return outputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public BufferedInputStream getBufferedinput() {
        return bufferedinput;
    }
}
