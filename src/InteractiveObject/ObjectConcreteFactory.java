package InteractiveObject;

import static main.BeautyPanel.*;

import beautyshop.BeautyShop;
import beautyshop.EndButton;
import beautyshop.StartButton;
import beautyshop.MyObject;

// An object factory class that create major objects //
public class ObjectConcreteFactory extends ObjectFactory{

	@Override
	public MyObject createObject(String type) {
		MyObject object = null;
		
//		if(type == "beautyshop")
//			object = new BeautyShop("assets/environment.PNG");
		if(type == "startbutton")
			object = new StartButton(W_WIDTH / 2.8, W_HEIGHT / 1.4, 1.2);
		else if(type == "cabinet")
			object = new Cabinet(W_WIDTH / 2.85, W_HEIGHT / 1.25, 0.975);
		else if(type == "hairdryer")
			object = new HairDryer(W_WIDTH / 2.7, W_HEIGHT / 1.2, 0.6);
		else if(type == "shampoo")
			object = new Shampoo(W_WIDTH / 3.1, W_HEIGHT / 1.8, 0.1);
		else if(type == "brush")
			object = new Brush(W_WIDTH / 8, W_HEIGHT / 1.7, 0.1);
		else if(type == "endbutton")
			object = new EndButton(W_WIDTH / 2, W_HEIGHT / 2, 1.5);
		
		return object;
	}

}
