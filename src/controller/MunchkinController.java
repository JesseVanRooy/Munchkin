package controller;

/**
 * Created by Jesse on 6/03/2015.
 */
public class MunchkinController {

    private ClientController clientController;
    private ServerController serverController;

    public MunchkinController(){
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
