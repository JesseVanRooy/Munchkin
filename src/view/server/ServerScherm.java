package view.server;

import controller.ServerController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jesse on 11/03/2015.
 */
public class ServerScherm extends JFrame {

    private ServerController serverController;

    private JButton jButton;
    private JList jList;

    public ServerScherm(ServerController serverController){
        super("Munchkin Server");
        this.serverController = serverController;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1600,960);
        try {
            setIconImage(ImageIO.read(new File("res/images/andere/serverLogo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLocationRelativeTo(null);
        maakComponenten();
        maakLayout();
        behandelEvents();
        setVisible(true);
    }

    private void maakComponenten(){
        this.jButton = new JButton("Connecties");
        this.jList = new JList(serverController.getServer().getConnecties());
    }

    private void maakLayout(){
        add(jButton, BorderLayout.CENTER);
        add(jList,BorderLayout.LINE_END);
    }

    private void behandelEvents(){
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.getServer().printConnecties();
            }
        });
    }
}
