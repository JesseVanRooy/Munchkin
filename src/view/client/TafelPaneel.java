package view.client;

import controller.ClientController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jesse on 12/03/2015.
 */
public class TafelPaneel extends JPanel{

    private ClientController clientController;
    private Image image;

    public TafelPaneel(ClientController clientController){
        this.clientController = clientController;
        try {
            this.image = ImageIO.read(new File("res/images/andere/tafelbackground.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(),getHeight(),this);

    }
}
