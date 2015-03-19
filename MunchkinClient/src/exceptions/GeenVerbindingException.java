package exceptions;

/**
 * Created by Jesse on 15/03/2015.
 */
public class GeenVerbindingException extends RuntimeException{

    public GeenVerbindingException(){
        System.err.println("geen verbinding");
    }
}
