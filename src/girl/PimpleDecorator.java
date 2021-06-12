package girl;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class PimpleDecorator extends GirlDecorator {
	int numOfPimples;
	int dir = 1;
	
	public PimpleDecorator(GirlInterface girl, double x, double y, double s, int num) {
		super(girl, x, y, s);
		numOfPimples = num;
		img = ImageLoader.loadImage("assets/pimple.jpg");
	}
	
	public void decorate(Graphics2D g2) {
		super.decorate(g2);
		decorateWithPimple(g2);
	}

	private void decorateWithPimple(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);
		for(int i=0; i<numOfPimples; i++) {
			dir *= -1;
			g2.translate(2000*dir*i, i*900);
			g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		
		}
		g2.setTransform(at);
	}

}
