package se.jola.screenshotasservice.exceptions;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 7040578563648955833L;
    
    public ServiceException(String message){
	super(message);
    }
    
    public ServiceException(String message, Exception e){
	super(message, e);
    }
}
