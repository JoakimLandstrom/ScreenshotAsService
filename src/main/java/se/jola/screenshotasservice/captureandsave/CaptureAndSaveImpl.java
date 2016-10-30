package se.jola.screenshotasservice.captureandsave;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import gui.ava.html.image.generator.HtmlImageGenerator;
import se.jola.screenshotasservice.exceptions.CaptureAndSaveException;

public final class CaptureAndSaveImpl implements CaptureAndSave {

    private HtmlImageGenerator imageGenerator;

    @Override
    public Collection<BufferedImage> capture(String... urls) throws CaptureAndSaveException {

	Collection<BufferedImage> images = new ArrayList<>();

	for (String url : urls) {
	    try {
		images.add(captureScreenFromUrl(url));
	    } catch (IOException e) {
		e.printStackTrace();
		throw new CaptureAndSaveException("");
	    }
	}

	return images;
    }

    @Override
    public void save(Collection<BufferedImage> images, String mapName) throws CaptureAndSaveException {

	int imgNumber = 1;

	try {
	    for (BufferedImage image : images) {

		File outputFile = new File("savedImage" + imgNumber + ".png");
		ImageIO.write(image, "png", outputFile);
		imgNumber++;
	    }

	} catch (IOException e) {
	    throw new CaptureAndSaveException("");
	}
    }

    private BufferedImage captureScreenFromUrl(String url) throws IOException {

	imageGenerator = new HtmlImageGenerator();

	imageGenerator.loadHtml(getHTMLFromUrl(url));

	return imageGenerator.getBufferedImage();

    }

    private String getHTMLFromUrl(String stringUrl) throws IOException {

	URL url = new URL(stringUrl);

	HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	connection.setRequestMethod("GET");

	BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

	String line = "";

	StringBuilder builder = new StringBuilder();

	while ((line = reader.readLine()) != null) {
	    builder.append(line);
	}

	reader.close();

	return builder.toString();

    }

}
