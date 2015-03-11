package controller;

import model.server.DeurStapel;
import model.client.Speler;
import model.server.Server;
import model.server.TreasureStapel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 9/03/2015.
 */
public class ServerController{

    private MunchkinController munchkinController;

    private DeurStapel deurStapel;
    private TreasureStapel treasureStapel;
    private Server server;

    public ServerController(MunchkinController munchkinController){
        this.munchkinController = munchkinController;
        this.deurStapel = new DeurStapel();
        this.treasureStapel = new TreasureStapel();
        this.server = new Server();
    }

    public Server getServer() {
        return server;
    }

    private void beurtRol(){}
}
