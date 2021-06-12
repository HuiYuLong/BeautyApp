package shape;

import static util.Util.random;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
	protected double xPos, yPos;
	protected double sW, sH;
	protected Color color;

	public Shape(double x, double y, double w, double h, Color c) {
		xPos = x;
		yPos = y;
		sW = w;
		sH = h;
		color = c;
	}

	public void move() {
		xPos += random(-1, 1);
		yPos += random(-1, 1);
	}

	// A generic shape does not really know
	// how to be displayed so declare it as
	// an abstract method
	public abstract void display(Graphics2D g2);
}
