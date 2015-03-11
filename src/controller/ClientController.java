package controller;

import model.client.Speler;

import javax.swing.*;
import java.net.Socket;

/**
 * Created by Jesse on 9/03/2015.
 */
public class ClientController {

    private Speler speler;
    private MunchkinController munchkinController;
    private Socket serverVerbinding;
    private boolean host;

    public ClientController(MunchkinController munchkinController){
        this.munchkinController = munchkinController;
        setUpModel();
        setUpView();
    }


    private void setUpModel(){
        this.speler = new Speler(JOptionPane.showInputDialog("Geef de naam in : "));
    }

    private void setUpView(){}
}
