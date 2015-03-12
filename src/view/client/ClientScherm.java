package view.client;

import controller.ClientController;
import controller.ServerController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jesse on 11/03/2015.
 */
public class ClientScherm extends JFrame {
    private ClientController clientController;
    private MenuBar menuBar;
    private TafelPaneel tafelPaneel;

    public ClientScherm(ClientController clientController){
        super("Munchkin Client");
        this.clientController = clientController;
        this.menuBar = new MenuBar();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600,960);
        setPreferredSize(new Dimension(1600, 960));
        try {
            setIconImage(ImageIO.read(new File("res/images/andere/clientLogo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLocationRelativeTo(null);
        setJMenuBar(menuBar);
        maakComponenten();
        maakLayout();
        behandelEvents();
        setVisible(true);
    }

    private void maakComponenten(){
        this.tafelPaneel = new TafelPaneel(clientController);
    }

    private void maakLayout(){
        add(tafelPaneel, BorderLayout.CENTER);
    }

    private void behandelEvents(){}
}
