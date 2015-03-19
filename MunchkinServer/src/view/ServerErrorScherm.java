package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jesse on 19/03/2015.
 */
public class ServerErrorScherm extends JDialog{
    private JTextArea textPane;

    public ServerErrorScherm(){
        super();
        setTitle("Server Error Log");
        setSize(1920/2,1080/2);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(0,0);
        maakComponenten();
        maakLayout();
        behandelEvents();
        setVisible(true);
    }

    private void maakComponenten(){
        this.textPane = new JTextArea();
        this.textPane.setEditable(false);
        this.textPane.setWrapStyleWord(true);
        this.textPane.setLineWrap(true);
    }

    private void maakLayout(){
        setLayout(new BorderLayout());
        add(this.textPane,BorderLayout.CENTER);
    }

    private void behandelEvents(){}

    public void update(String errorStreamInhoud){
        this.textPane.setText("");
        this.textPane.append(errorStreamInhoud);
        this.textPane.updateUI();
    }
}
