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
    public static final int PORT = 1337;
    private ServerSocket serverSocket;
    private List<ClientConnectie> clientConnecties;

    public Server(){
        try {
            this.serverSocket = new ServerSocket(PORT);
            this.clientConnecties = new ArrayList<ClientConnectie>();
            startVerbinding();
        }catch (IOException i){
            i.printStackTrace();
        }

    }

    public void startVerbinding(){
        try {
            ClientConnectie clientConnectie = new ClientConnectie(serverSocket.accept());
            this.clientConnecties.add(clientConnectie);
            clientConnectie.getOutputStream().println("CONNECTION.ESTABLISH");
            System.out.println(clientConnectie.getSocket().getInetAddress().toString());
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public void beindigVerbinding(int index){
        ClientConnectie clientConnectie = this.clientConnecties.get(index);
        try {
            clientConnectie.getInputStream().close();
            clientConnectie.getOutputStream().println("CONNECTION.CLOSE");
            clientConnectie.getOutputStream().close();
            clientConnectie.getSocket().close();
        }catch (IOException i){
            i.printStackTrace();
        }

    }

    public ClientConnectie getClientConnectie(int index){
        return clientConnecties.get(index);
    }

    public String[] getConnecties (){
        String[] connecties = new String[clientConnecties.size()];
        for(int i=0;i<connecties.length;i++){
            connecties[i] = clientConnecties.get(i).toString();
        }
        return connecties;
    }

    public void printConnecties(){
        for(ClientConnectie clientConnectie : clientConnecties){
            System.out.println(clientConnectie);
        }
    }
}
