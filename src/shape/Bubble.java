/* Circle class that extends from an
 * abstract class Shape and draws a circle
 * A demo program created for IAT-265 Spring 15
 * Author: Eric Yang
 * Date of creation: Mar 11 2015
 * All rights reserved
 */
package shape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import static util.Util.*;

public class Bubble extends Shape {
	private double radius;
	private Ellipse2D.Double circle;

	public Bubble(double x, double y, double r, Color c) {
		super(x, y, 2 * r, 2 * r, c);
		radius = r;
		circle = new Ellipse2D.Double();
	}

	// Override parent’s move method
	public void move() {
		super.move();
		// This makes bubbles remain a reasonable size //
		if(radius > 15) radius -= 1;
		else {
			radius += random(-1, 1);
		}
	}

	// implement the abstract method as required
	public void display(Graphics2D g2) {
		g2.setColor(color);
		circle.setFrame(xPos-radius, yPos-radius, 2 * radius, 2 * radius);
		g2.fill(circle);
		g2.setColor(Color.black);
		g2.draw(circle);
	}
}
