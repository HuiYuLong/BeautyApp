package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import processing.core.PApplet;
import util.Util;

//Involve with at least one feature using Perlin noise to generate
public class Wind extends Shape{

	private float xstart;
	private float xnoise;
	private float ynoise;
	private PApplet pa;

	public Wind(float x , float y, int w, int h) {
		super(x, y, w, h, Color.gray);
		
		xstart = Util.random(10);
		xnoise = xstart;
		ynoise = Util.random(10);
		pa = new PApplet();
	}
	
	public void setWidth(int w) {
		sW = w;
	}
	
	public void setHeight(int h) {
		sH = h;
	}

	@Override
	public void display(Graphics2D g2) {
		float noiseFactor;
		AffineTransform at = g2.getTransform();
		g2.translate(xPos, yPos);
		g2.rotate(0.6);

		for(int y=0; y <= sH; y += 10) {
			ynoise += 0.1;
			xnoise = xstart;
			for(int x= 0; x <= sW; x+=10) {
				xnoise+= 0.1;
				// This determines the shape of the steam
				noiseFactor = pa.noise(xnoise,ynoise);

				AffineTransform at1 = g2.getTransform();
				g2.translate(x, y);
				g2.rotate(noiseFactor*Util.radians(540));
				float edgeSize = noiseFactor * 35;
				int grey = (int) (150 + (noiseFactor*105));
				int alph = (int) (80 +(noiseFactor*105));
				g2.setColor(new Color(grey,grey,grey,alph));
				g2.fill(new Ellipse2D.Float(-edgeSize/2, -edgeSize/4, edgeSize, edgeSize/2*noiseFactor));
				g2.setTransform(at1);
			}

		}
		g2.setTransform(at);
	}
}

