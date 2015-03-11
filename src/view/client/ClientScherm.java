package view.client;

import controller.ClientController;
import controller.ServerController;

import javax.swing.*;

/**
 * Created by Jesse on 11/03/2015.
 */
public class ClientScherm extends JFrame {
    private ClientController clientController;

    public ClientScherm(ClientController clientController){
        super("Munchkin Client");
        this.clientController = clientController;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600,960);
        setLocationRelativeTo(null);
        maakComponenten();
        maakLayout();
        behandelEvents();
        setVisible(true);
    }

    private void maakComponenten(){}

    private void maakLayout(){}

    private void behandelEvents(){}
}
