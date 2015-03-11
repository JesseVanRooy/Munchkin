package model.server;

import controller.ClientController;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 9/03/2015.
 */
public class Server {

    private ServerSocket serverSocket;
    private List<ClientConnectie> clientConnecties;

    public Server(){
        try {
            this.serverSocket = new ServerSocket(13337);
            this.clientConnecties = new ArrayList<ClientConnectie>();
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public void join(){
        try {
            this.clientConnecties.add(new ClientConnectie(serverSocket.accept()));
        }catch (IOException i){
            i.printStackTrace();
        }

    }

    private void broadcast(String bericht){
        for(ClientConnectie clientConnectie : clientConnecties){
            clientConnectie.schrijf(bericht);
        }
    }

    private void verzend(String bericht, int index){
        this.clientConnecties.get(index).schrijf(bericht);
    }


}
