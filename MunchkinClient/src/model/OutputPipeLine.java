package model;

import exceptions.VerbindingVerstoordException;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Jesse on 14/03/2015.
 */
public class OutputPipeLine {

    private OutputStream outputStream;

    public OutputPipeLine(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void schrijf(byte[] byteArray){
        try {
            outputStream.write(byteArray);
            outputStream.flush();
        } catch (IOException e) {
            throw new VerbindingVerstoordException();
        }
    }
}
