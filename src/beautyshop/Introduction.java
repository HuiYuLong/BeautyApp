package beautyshop;

import util.ImageLoader;

//Provide appropriate text message to prescribe each of the steps you implemented so far
public class Introduction extends MyObject{

	public Introduction(double x, double y, double s) {
		super(x, y, s);
		img = ImageLoader.loadImage("assets/intro_shampoo.PNG");
	}

	@Override
	public void setImg(int state) {
		// step 1: wash hair by dragging the shampoo
		if(state == 0) {
			img = ImageLoader.loadImage("assets/intro_shampoo.PNG");
		}
		// step 2: open the cabinet
		else if(state == 1) {
			img = ImageLoader.loadImage("assets/intro_opencabinet.PNG");
		}
		// step 3: drag the hairdryer close to the girl
		else if(state == 2) {
			img = ImageLoader.loadImage("assets/intro_hairdryer.PNG");
		}
		// step 4: do make up by dragging the brush
		else if(state == 3) {
			img = ImageLoader.loadImage("assets/intro_brush.PNG");
		}
		// all done:
		else if(state == 4) {
			img = ImageLoader.loadImage("assets/intro_complete.PNG");
		}
		// wait state
		else if(state == 6) {
			img = ImageLoader.loadImage("assets/intro_wait.PNG");
		}
		
		// complete
		if(state == 7) {
			img = ImageLoader.loadImage("assets/intro_complete.PNG");
		}
		
	}

	@Override
	public void react() {
		// TODO Auto-generated method stub
		
	}

}
