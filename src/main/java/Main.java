import java.awt.image.BufferedImage;
import java.util.Collection;

import se.jola.screenshotasservice.captureandsave.CaptureAndSaveImpl;
import se.jola.screenshotasservice.exceptions.CaptureAndSaveException;

public class Main {

    public static void main(String[] args) {
	
	CaptureAndSaveImpl captureAndSaveImpl = new CaptureAndSaveImpl();
	
	try{
	Collection<BufferedImage> images = captureAndSaveImpl.capture("http://www.granditude.com");
	
	captureAndSaveImpl.save(images, "wat");
	}catch (CaptureAndSaveException e) {
	    e.printStackTrace();
	   throw new SecurityException();
	}
	
    }
}
