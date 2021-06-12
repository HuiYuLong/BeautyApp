package beautyshop;

import util.ImageLoader;

//Create an ending screen that will have a restart button allowing the application to be relaunched.
public class EndButton extends MyObject{

	public EndButton(double x, double y,  double s) {
			super(x, y, s);
			img = ImageLoader.loadImage("assets/end_button.PNG");
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