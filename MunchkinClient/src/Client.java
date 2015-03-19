import model.ClientCommandoHandler;
import model.ClientData;
import model.ServerManager;

import javax.swing.*;

/**
 * Created by Jesse on 14/03/2015.
 */
public class Client{
    private ClientData clientData;
    private ClientCommandoHandler commandoHandler;
    private ServerManager serverManager;

    public Client(){
        this.clientData = new ClientData(
                JOptionPane.showInputDialog(null,"Geef je naam in : ","Naam",JOptionPane.QUESTION_MESSAGE)
        );
        clientData.getProperties().updateProperties(this);
        this.commandoHandler = new ClientCommandoHandler();

    }



    public void verbindMetServer(String ip, int port){
        this.serverManager = new ServerManager(ip, port);
    }

    public ClientData getClientData() {
        return clientData;
    }

    public ServerManager getServerManager() {
        return serverManager;
    }

}
