package shape;

import java.awt.Color;

import static main.BeautyPanel.W_HEIGHT;
import static main.BeautyPanel.W_WIDTH;

public class ShapeConcreteFactory extends ShapeFactory {

	@Override
	public Shape createShape(String type) {
		Shape shape = null;
	
		if (type == "bubble")
			shape =  new Bubble((float) (W_WIDTH / 1.6), (float) (W_HEIGHT / 2.6), 10, new Color(231,254,255));
		else if (type == "wind")
			shape = new Wind((float) (W_WIDTH / 1.62), (float) (W_HEIGHT / 2.8), 80, 20);
		else if(type == "red_flower")
			shape =  new Flower(80, W_HEIGHT / 3.4, 10, Color.red);
		else if(type == "pink_flower")
			shape =  new Flower(60, W_HEIGHT / 3.6, 10, Color.pink);
		else if(type == "yellow_flower")
			shape =  new Flower(90, W_HEIGHT / 3.5, 10, Color.yellow);
		
		return shape;
	}
}
