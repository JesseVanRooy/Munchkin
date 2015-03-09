package controller;

import model.server.DeurStapel;
import model.client.Speler;
import model.server.TreasureStapel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 9/03/2015.
 */
public class ServerController {
    private DeurStapel deurStapel;
    private TreasureStapel treasureStapel;
    private List<Speler> spelers;

    private ServerSocket serverSocket;
    private List<Socket> spelerSockets;

    private MunchkinController munchkinController;

    public ServerController(MunchkinController munchkinController){
        this.munchkinController = munchkinController;
        deurStapel = new DeurStapel();
        treasureStapel = new TreasureStapel();
        spelers = new ArrayList<Speler>();
        spelerSockets = new ArrayList<Socket>();
    }

    private void setUpServerSocket(){
        try {
            serverSocket = new ServerSocket(1337);

        } catch (IOException i){
            i.printStackTrace();
        }

    }

    public void bindSpeler(){

    }

    private void beurtRol(){}
}
