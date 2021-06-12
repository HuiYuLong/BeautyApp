package beautyshop;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import girl.GirlDecorator;
import girl.GirlInterface;
import processing.core.PVector;

// An abstract superclass that can be inherited by     //
// objects that can be clicked and interacted by users //
public abstract class MyObject {
	
	protected double xPos;
	protected double yPos;
	protected double scale;
	protected double originX, originY;
	protected int state;
	
	protected BufferedImage img;
	
	public MyObject(double x, double y, double s) {
		xPos = x;
		yPos = y;
		scale = s;
		
		originX = x;
		originY = y;
		state = 0; // Every object has a initial state, and when state = 1 means it's reacting //
	}
	
	public void drawButton(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);

		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);
	}
	
	public boolean clicked(double x, double y){
		boolean clicked = false;
		
		if (x > (xPos - ((double) img.getWidth()) / 2 * scale) && x < (xPos + ((double) img.getWidth())/2*scale) && y > (yPos - ((double) img.getHeight())/2*scale) && y < (yPos + ((double) img.getHeight())/2*scale)) 
			clicked = true;
		
		return clicked;
	}
	
	// if the hairdryer is close to the girl
	public boolean hitHair(GirlDecorator girl) {
		// check if the center of the oven
		if(xPos > girl.getPos().x-100 && xPos < girl.getPos().x+100 &&
		   yPos > girl.getPos().y-360 && yPos < girl.getPos().y+360) {
			return true;
		}
		return false;
	}
	

	public PVector getPos() {
		return new PVector((int) xPos, (int) yPos);
	}
	

	public void setPos(double x, double y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void restore() {
		setPos(originX, originY);
	}
	
	public void react() {
		setImg(1);
	}
	
	protected abstract void setImg(int state);


}
