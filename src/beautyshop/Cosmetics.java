package beautyshop;

import util.ImageLoader;

// This is just a part of the background //
public class Cosmetics extends MyObject{

	public Cosmetics(double x, double y,  double s) {
			super(x, y, s);
			img = ImageLoader.loadImage("assets/cosmetics.png");
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
