package client.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jesse on 6/03/2015.
 */
public class SplashScreen extends JDialog{

    private JLabel jLabel;
    private JProgressBar jProgressBar;

    public SplashScreen(){
        super();
        setSize(1600,535);
        setLocationRelativeTo(null);
        setUndecorated(true);
        maakComponenten();
        maakLayout();
        setVisible(true);
        progresLoop();
        dispose();
    }

    private void maakComponenten(){
        this.jLabel = new JLabel(new ImageIcon("res/images/andere/splashscreen.jpg"));
        this.jProgressBar = new JProgressBar(0,3000);
        this.jProgressBar.setBorder(new EmptyBorder(-1,0,0,0));
        this.jProgressBar.setForeground(new Color(61,6,1));
        this.jProgressBar.setBackground(new Color(252,207,148));
    }

    private void maakProgresBar(int value){

        this.jProgressBar.setValue(value);
    }

    private void maakLayout(){
        setLayout(new BorderLayout());
        add(jLabel,BorderLayout.CENTER);
        add(jProgressBar,BorderLayout.SOUTH);
    }

    private void progresLoop(){
        for(int i=0;i<=3000;i+=50){
            maakProgresBar(i);
            maakLayout();
            revalidate();
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
