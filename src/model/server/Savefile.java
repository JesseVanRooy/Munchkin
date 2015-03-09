package model.server;

import java.io.*;

/**
 * Created by Jesse on 8/03/2015.
 */
public class Savefile {

    private File file;

    public Savefile(String bestandsnaam){
        this.file = new File(bestandsnaam);
    }

    public String leesBestand(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String string;
            while((string=bufferedReader.readLine()) != null){
                stringBuilder.append(string);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException f){
            f.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
        return null;
    }

    public void schrijfBestand(String inhoud){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(inhoud);
            fileWriter.close();
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public void schrijfBestandBij(String inhoud){
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(inhoud);
            fileWriter.close();
        }catch (IOException i){
            i.printStackTrace();
        }
    }
}
