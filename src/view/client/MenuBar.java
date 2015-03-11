package view.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Jesse on 11/03/2015.
 */
public class MenuBar extends JMenuBar{

    private JMenu bestandsMenu, serverMenu, helpMenu;
    private JMenuItem saveItem, saveAndQuitItem, joinServerItem, verlaatServerItem, aboutItem, helpItem;

    public MenuBar(){
        super();
        setMenus();
        setMenuItems();
    }

    private void setMenus(){
        this.bestandsMenu = new JMenu("Bestand");
        add(bestandsMenu);

        this.serverMenu = new JMenu("Server");
        add(serverMenu);

        this.helpMenu = new JMenu("Help");
        add(helpMenu);
    }

    private void setMenuItems(){
        this.saveItem = new JMenuItem("Save");
        this.bestandsMenu.add(saveItem);

        this.saveAndQuitItem = new JMenuItem("Save And Quit");
        this.bestandsMenu.add(saveAndQuitItem);

        this.joinServerItem = new JMenuItem("Join Server");
        this.serverMenu.add(joinServerItem);

        this.verlaatServerItem = new JMenuItem("Verlaat Server");
        this.serverMenu.add(verlaatServerItem);

        this.aboutItem = new JMenuItem("About");
        this.helpMenu.add(aboutItem);

        this.helpItem = new JMenuItem("Help");
        this.helpMenu.add(helpItem);
    }
}
