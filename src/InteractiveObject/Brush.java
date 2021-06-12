package InteractiveObject;

import static util.ImageLoader.loadImage;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import beautyshop.MyObject;

public class Brush extends MyObject{
	
	public Brush(double x, double y, double sca) {
		super(x, y, sca);
		img = loadImage("assets/brush.png");
	}
	
	public void setImg(int HairDryerState) {
		//nothing so far
	}
	
	public void drawButton(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);
		g2.rotate(-0.5);
		
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
	}

	@Override
	public void react() {
		// TODO Auto-generated method stub
		
	}
}

	
	