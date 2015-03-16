package client;

import client.model.ClientCommandoHandler;
import client.model.ClientData;
import client.model.ServerManager;

/**
 * Created by Jesse on 14/03/2015.
 */
public class Client {
    private ClientData clientData;
    private ClientCommandoHandler commandoHandler;
    private ServerManager serverManager;

    public Client(){
        this.clientData = new ClientData();
        this.commandoHandler = new ClientCommandoHandler();
    }

    public void verbindMetServer(String ip, int port){
        this.serverManager = new ServerManager(ip, port);
        this.clientData.verbindMetStream(ip, port+1);
    }

    public String getVersie(){
        return clientData.getVersie();
    }

    public ClientData getClientData() {
        return clientData;
    }

    public ServerManager getServerManager() {
        return serverManager;
    }
}
