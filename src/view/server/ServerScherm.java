package view.server;

import controller.ServerController;

import javax.swing.*;

/**
 * Created by Jesse on 11/03/2015.
 */
public class ServerScherm extends JFrame {

    private ServerController serverController;

    public ServerScherm(ServerController serverController){
        super("Munchkin Server");
        this.serverController = serverController;
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
