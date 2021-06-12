package InteractiveObject;

import static util.ImageLoader.loadImage;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import static main.BeautyPanel.W_WIDTH;
import static main.BeautyPanel.W_HEIGHT;
import beautyshop.MyObject;
import shape.Shape;
import shape.ShapeConcreteFactory;
import shape.ShapeFactory;

public class HairDryer extends MyObject{
	
	private boolean produceWind = false;
	ShapeFactory shapeMaker;
	private Shape wind;
	
	public HairDryer(double x, double y, double sca) {
		super(x, y, sca);
		img = loadImage("assets/hairdryer.png");
	}
	
	public void setImg(int HairDryerState) {
		//nothing so far
	}
	
	public void drawButton(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);
		g2.rotate(-0.8);
		
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
		
		if(produceWind == true) {
			wind.display(g2);
		}
	}

	@Override
	public void react() {
		setPos(W_WIDTH / 1.43, W_HEIGHT / 3);

		shapeMaker = new ShapeConcreteFactory();
		wind = shapeMaker.createShape("wind");
		produceWind = true;
	}	
	
	public void restore() {
		super.restore();
		produceWind = false;
	}
}

	
	