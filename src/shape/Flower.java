package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

//Involve with at least one feature using fractals done by recursive functions
public class Flower extends Shape{
	private double radius;
	private Ellipse2D.Double circle;

	public Flower(double x, double y, double r, Color c) {
		super(x, y, 2 * r, 2 * r, c);
		radius = r;
		circle = new Ellipse2D.Double();
	}
	
	private void drawFlowers(Graphics2D g2, double amount) {
		g2.setColor(color);
		circle.setFrame(xPos-radius, yPos-radius, 2 * radius, 2 * radius);
		g2.fill(circle);
		g2.setColor(Color.black);
		g2.draw(circle);
		amount *= 0.9;
		
		if(amount > 1) { // Base case: if all required bubbles are displayed
			AffineTransform at = g2.getTransform();
			g2.rotate(0.9, xPos+amount*2, yPos+amount*2);
			drawFlowers(g2, amount);
			g2.setTransform(at);
		}
		
	}
	
	private void rec_display(Graphics2D g2, double amount) {
		g2.setStroke(new BasicStroke(0));
		
		// draw flowers
		drawFlowers(g2, amount);
	}

	@Override
	public void display(Graphics2D g2) {
		double num = 8;
		// draw branches
		g2.setStroke(new BasicStroke(3));
		g2.setColor(new Color(0,102,0));
		g2.draw(new Line2D.Double(xPos+num*2, yPos, xPos+10, 330)); // Draw the branch itself
		
		rec_display(g2, num);
	}

}
