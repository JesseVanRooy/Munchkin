package controller;

import model.server.ClientConnectie;
import view.SplashScreen;

/**
 * Created by Jesse on 6/03/2015.
 */
public class MunchkinController {

    private ClientController clientController;
    private ServerController serverController;

    public MunchkinController(){
        new SplashScreen();
        this.clientController = new ClientController(this);
    }

    public void maakServerAan(){
        this.serverController = new ServerController(this);
    }

    public ClientController getClientController() {
        return clientController;
    }

    public ServerController getServerController() {
        return serverController;
    }
}
