package InteractiveObject;

import static main.BeautyPanel.W_HEIGHT;
import static main.BeautyPanel.W_WIDTH;
import static util.ImageLoader.loadImage;
import static util.Util.random;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.Timer;

import beautyshop.MyObject;
import shape.Bubble;
import shape.Shape;
import shape.ShapeConcreteFactory;
import shape.ShapeFactory;

public class Shampoo extends MyObject {

	private boolean produceBubbles = false;
	ShapeFactory shapeMaker;
	private Shape[] bubbles = new Shape[20];
	
	public Shampoo(double x, double y, double sca) {
		super(x, y, sca);
		img = loadImage("assets/shampoo.png");
	}
	
	public void setImg(int HairDryerState) {
		//nothing so far
	}
	
	public void drawButton(Graphics2D g2) {
		AffineTransform transform = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.scale(scale, scale);
		if(produceBubbles == true) g2.rotate(-0.9);
		
		g2.drawImage(img, -img.getWidth() / 2, -img.getHeight() / 2, null);

		g2.setTransform(transform);

		if(produceBubbles == true) {
			for (int i = 0; i < bubbles.length; i++) {
				bubbles[i].display(g2);
				bubbles[i].move();
			}
		}
	}

	@Override
	public void react() {
		setPos(W_WIDTH / 1.5, W_HEIGHT / 3.2);
		
		// prepare the bubble
		shapeMaker = new ShapeConcreteFactory();
		for (int i = 0; i < bubbles.length; i++) {
			bubbles[i] = shapeMaker.createShape("bubble");
		}
		produceBubbles = true;
	}
	
	public void restore() {
		super.restore();
		produceBubbles = false;
	}
}

	
	