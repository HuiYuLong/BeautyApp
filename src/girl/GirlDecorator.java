package girl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import processing.core.PVector;

public class GirlDecorator implements GirlInterface {
	private GirlInterface baseGirl;
	protected BufferedImage img;
	protected double xPos, yPos;
	protected double scale;
	
	public GirlDecorator(GirlInterface _baseGirl, double x, double y, double s) {
		baseGirl = _baseGirl;
		xPos = x;
		yPos= y;
		scale = s;
	}
	
	@Override
	public void decorate(Graphics2D g2) {
		baseGirl.decorate(g2);
	}
	
	public PVector getPos() {
		return new PVector((int) xPos, (int) yPos);
	}

}
