package model;

import client.Client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by Jesse on 17/03/2015.
 */
public class ClientProperties {

    private Properties properties;
    private OutputStream outputStream;

    public ClientProperties(){
        this.properties = new Properties();
    }

    public void open(){
        try {
            this.outputStream = new FileOutputStream("res/bin/client/client.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            this.outputStream.close();
            this.outputStream = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateProperties(Client client){
        open();
        if(this.outputStream!= null){
            properties.put("Versie",client.getClientData().getVersie());
            properties.put("Naam",client.getClientData().getNaam());
            try {
                properties.store(outputStream,null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    public String getProperty(String naam){
        return properties.get(naam).toString();
    }
}
