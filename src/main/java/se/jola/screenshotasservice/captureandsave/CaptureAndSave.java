package se.jola.screenshotasservice.captureandsave;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collection;

import se.jola.screenshotasservice.exceptions.CaptureAndSaveException;

public interface CaptureAndSave {

    public Collection<BufferedImage> capture(String... urls) throws CaptureAndSaveException;
    
    void save(Collection<BufferedImage> images, String mapName) throws CaptureAndSaveException;
    
}
