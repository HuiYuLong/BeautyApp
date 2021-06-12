package beautyshop;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import InteractiveObject.Brush;
import main.BeautyPanel;
import shape.Shape;
import shape.ShapeConcreteFactory;
import shape.ShapeFactory;
import util.ImageLoader;
import static main.BeautyPanel.W_HEIGHT;
import static main.BeautyPanel.W_WIDTH;

// The BeautyShop class display the background   //
// It also change to start/end scene accrodingly //
public class BeautyShop {
	private BufferedImage img;
	private Vase vase;
	private Cosmetics cosmetics;
	private Closet closet;
	private MyClock clock;
	ShapeFactory shapeMaker;
	// This makes it more flexible to produce a flower //
	private Shape[] flowers = new Shape[2];

	public BeautyShop(String file) {
		img = ImageLoader.loadImage(file);
		// Reference: https://www.clipartmax.com/download/m2H7H7d3b1i8m2Z5_vase-cartoon-clip-art-cartoon-pictures-of-a-vase/
		vase =  new Vase(80, W_HEIGHT / 2.3, 0.06);
		cosmetics = new Cosmetics(W_WIDTH / 8, W_HEIGHT / 1.7, 0.24);
		closet = new Closet(W_WIDTH/1.142, W_HEIGHT / 3.32, 1.15);
		clock = new MyClock(W_WIDTH / 1.82, W_HEIGHT / 8, 0.2);
		
		shapeMaker = new ShapeConcreteFactory();
		flowers[0] = shapeMaker.createShape("red_flower");
		flowers[1] = shapeMaker.createShape("pink_flower");
//		flowers[2] = shapeMaker.createShape("yellow_flower");
	}

	public void drawBeautyShop(Graphics2D g2) {
		AffineTransform at = g2.getTransform();
		g2.translate(-90, 0);
		g2.scale(1, 1);
		g2.drawImage(img, 90, 0, BeautyPanel.W_WIDTH, BeautyPanel.W_HEIGHT, null);
		g2.setTransform(at);

		clock.drawButton(g2);
		vase.drawButton(g2);
		cosmetics.drawButton(g2);
		closet.drawButton(g2);
		for(int i=0; i<flowers.length; ++i) {
			flowers[i].display(g2);
		}
	}
	
	//Create an intro screen, that provides some introduction message about the app 
	//(what it is about and how should you interact with it), 
	//some theme relevant image as cover, and a start button
	public void drawStartScene(Graphics2D g2) {
		BufferedImage start_scene = ImageLoader.loadImage("assets/start_scene.PNG");
		AffineTransform at = g2.getTransform();
		g2.translate(-90, 0);
		g2.scale(1.1, 1.1);
		g2.drawImage(start_scene, 0, 0, BeautyPanel.W_WIDTH, BeautyPanel.W_HEIGHT, null);
		g2.setTransform(at);
	}
	
	public void drawEndScene(Graphics2D g2) {
		BufferedImage start_scene = ImageLoader.loadImage("assets/end_scene.PNG");
		AffineTransform at = g2.getTransform();
		g2.translate(-90, 0);
		g2.scale(1.1, 1.1);
		g2.drawImage(start_scene, 0, 0, BeautyPanel.W_WIDTH, BeautyPanel.W_HEIGHT, null);
		g2.setTransform(at);
	}
	
	public void drawReference(Graphics2D g2) {
		BufferedImage start_scene = ImageLoader.loadImage("assets/reference.PNG");
		AffineTransform at = g2.getTransform();
		g2.translate(-90, 0);
		g2.scale(1.1, 1.1);
		g2.drawImage(start_scene, 0, 0, BeautyPanel.W_WIDTH, BeautyPanel.W_HEIGHT, null);
		g2.setTransform(at);
	}

}
