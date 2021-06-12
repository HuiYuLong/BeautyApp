package beautyshop;

import util.ImageLoader;
import static main.BeautyPanel.W_HEIGHT;
import static main.BeautyPanel.W_WIDTH;

public class Closet extends MyObject{
	
	// constructor
	public Closet(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/close-closet.PNG");
	}
	
	protected void setImg(int closetState) {

	    if (closetState == 0)
	        img = ImageLoader.loadImage("assets/close-closet.png");

	}

	@Override
	public void react() {
		// open the closet by setting the state to 1
		setImg(1);
	}
	
}