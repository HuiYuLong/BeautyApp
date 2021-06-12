package girl;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import util.ImageLoader;

public class DressDecorator extends GirlDecorator {
	public DressDecorator(GirlInterface girl, double x, double y, double s) {
		super(girl, x, y, s);
		img = ImageLoader.loadImage("assets/dress_ps.png");
	}
	
	public void decorate(Graphics2D g2) {
		super.decorate(g2);
		decorateWithSmile(g2);
	}

	private void decorateWithSmile(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);
		g2.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
		g2.setTransform(at);
	}
}
