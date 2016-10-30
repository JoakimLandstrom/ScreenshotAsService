package se.jola.screenshotasservice.exceptions;

public class CaptureAndSaveException extends Exception{

    private static final long serialVersionUID = -3872690437740678225L;
    
    public CaptureAndSaveException(String message){
	super(message);
    }
    
    public CaptureAndSaveException(String message, Exception e){
	super(message, e);
    }

}
