package beautyshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

// Reference: https://www.geeksforgeeks.org/localtime-nowclock-method-in-java-with-examples/?ref=rp
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

import util.ImageLoader;

//This is just a part of the background //
public class MyClock extends MyObject{
	String time;
	
	public MyClock(double x, double y,  double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/clock.jpg");
	}

	@Override
	public void setImg(int state) {
		img = ImageLoader.loadImage("assets/clock.jpg");
	}

	@Override
	public void react() {
		// TODO Auto-generated method stub
		
	}
	
	public void drawButton(Graphics2D g2) {
		super.drawButton(g2);
		
		AffineTransform at = g2.getTransform();
		g2.translate(xPos-22, yPos+5);
		time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
		
		g2.setColor(Color.black);
		g2.drawString(time, 0, 0);
		
		g2.setTransform(at);
	}

}

