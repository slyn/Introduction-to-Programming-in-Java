package project3.myexception;

/**
 * This exception class is created for handlig the smaller number than two. This class extends from 
 * exception class. It contains 2 constructor for throwing the exception.
 * 
 * @author Hüsnü
 * @version 1.0
 */
public class MySmallerThanException extends Exception {
    
    /**Constructor without parametric */
    public MySmallerThanException(){}
    
    /**
     * Constructor
     * @param message The text which inform the user about error
     */
    public MySmallerThanException(String message){
        super(message);
    }
}
