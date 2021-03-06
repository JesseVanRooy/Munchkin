package model;

import exceptions.VerbindingVerstoordException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jesse on 14/03/2015.
 */
public class InputPipeLine {

    private InputStream inputStream;

    public InputPipeLine(InputStream inputStream){
            this.inputStream = inputStream;
    }

    public byte[] lees(){

        try {
            byte[] byteArray = new byte[64];
            inputStream.read(byteArray);
            return byteArray;
        } catch (IOException e) {
            throw new VerbindingVerstoordException();
        }
    }
}
