package exceptions;

/**
 * Created by Jesse on 15/03/2015.
 */
public class VerbindingVerstoordException extends RuntimeException{
    
    public VerbindingVerstoordException(){
        System.err.println("verbinding verstoord");
    }
}
