package girl;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import util.ImageLoader;

public class BasicGirl implements GirlInterface {
	private BufferedImage img;
	private double xPos, yPos;
	
	public BasicGirl(double x, double y) {
		img = ImageLoader.loadImage("assets/girl_dressed_up.PNG");
		xPos = x;
		yPos = y;
	}
	
	@Override
	public void decorate(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		g2.setTransform(at);
	}
}
