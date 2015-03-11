package controller;

import model.client.ServerConnectie;
import model.client.Speler;
import model.server.ClientConnectie;
import view.client.ClientScherm;

import javax.swing.*;
import java.net.Socket;

/**
 * Created by Jesse on 9/03/2015.
 */
public class ClientController{
    public static final int PORT = 1337;

    private Speler speler;
    private MunchkinController munchkinController;
    private ServerConnectie serverConnectie;
    private boolean isHost;

    private ClientScherm clientScherm;

    public ClientController(MunchkinController munchkinController){
        this.munchkinController = munchkinController;
        this.isHost = false;
        setUpModel();
        setUpView();
    }

    /* --- SETUP --- */

    private void setUpModel(){}

    private void setUpView(){
        this.clientScherm = new ClientScherm(this);
    }

    /* --- SERVER --- */

    public void joinServer(String host){
        this.serverConnectie = new ServerConnectie(host,PORT);
    }

    public void hostServer(){
        this.munchkinController.maakServerAan();
        this.serverConnectie = new ServerConnectie(PORT);
        this.isHost = true;
    }

    /* --- MODEL TO VIEW --- */



    /* --- VIEW TO MODEL --- */
}
