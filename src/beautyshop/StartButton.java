package beautyshop;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import main.BeautyPanel;
import util.ImageLoader;

public class StartButton extends MyObject{

	public StartButton(double x, double y,  double s) {
			super(x, y, s);
			img = ImageLoader.loadImage("assets/start_button.PNG");
		}

	@Override
	public void setImg(int state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void react() {
		// TODO Auto-generated method stub
		
	}

}
