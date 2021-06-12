package InteractiveObject;

import beautyshop.MyObject;
import static main.BeautyPanel.W_HEIGHT;
import static main.BeautyPanel.W_WIDTH;
import util.ImageLoader;

public class Cabinet extends MyObject{
	
	// constructor
	public Cabinet(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/close-cabinet.png");
	}
	
	protected void setImg(int cabinetState) {

	    if (cabinetState == 0)

	        img = ImageLoader.loadImage("assets/close-cabinet.png");
	    
	    else if (cabinetState == 1)
	    	
	    	img = ImageLoader.loadImage("assets/open-cabinet.png");

	}

	@Override
	public void react() {
		setPos(W_WIDTH / 2.19, W_HEIGHT / 1.166);
		setImg(1);
	}
	
	@Override
	public void restore() {
		super.restore();
		setImg(0);
	}
	
}