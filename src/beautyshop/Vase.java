package beautyshop;

import util.ImageLoader;

// This is just a part of the background //
public class Vase extends MyObject{

	public Vase(double x, double y,  double s) {
			super(x, y, s);
			img = ImageLoader.loadImage("assets/vase.png");
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
