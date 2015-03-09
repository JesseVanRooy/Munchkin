package controller;

import model.client.Speler;

/**
 * Created by Jesse on 9/03/2015.
 */
public class ClientController {

    private Speler speler;
    private MunchkinController munchkinController;

    public ClientController(MunchkinController munchkinController){
        this.munchkinController = munchkinController;
        setUpModel();
        setUpView();
    }

    private void setUpModel(){
        this.speler = new Speler();
    }

    private void setUpView(){}
}
