package model;


import java.io.*;

/**
 * Created by Jesse on 17/03/2015.
 */
public class ClientLog {

    private static final String OUTPUTBESTANDSNAAM = "res/bin/client/clientOutputLog.log", ERRORBESTANDSNAAM = "res/bin/client/clientErrorLog.log";
    private File outputLogFile, errorLogFile;
    private PrintStream errorStream, outputStream;

    public ClientLog(){
        this.outputLogFile = new File(OUTPUTBESTANDSNAAM);
        this.errorLogFile = new File(ERRORBESTANDSNAAM);
        try {
            this.errorStream = new PrintStream(errorLogFile);
            this.outputStream = new PrintStream(outputLogFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setErr(errorStream);
        System.setOut(outputStream);
    }

    public void close(){
        System.setErr(System.err);
        System.setOut(System.out);
        errorStream.close();
        outputStream.close();
    }

    public String leesOutputLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(outputLogFile));
            String s;
            while ((s=bufferedReader.readLine())!=null){
                stringBuilder.append(s);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String leesErrorLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(errorLogFile));
            String s;
            while ((s=bufferedReader.readLine())!=null){
                stringBuilder.append(s);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i){
            i.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
