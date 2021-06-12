package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.Clock;

import javax.swing.Timer;

import InteractiveObject.Brush;
import InteractiveObject.Cabinet;
import InteractiveObject.HairDryer;
import InteractiveObject.ObjectConcreteFactory;
import InteractiveObject.ObjectFactory;
import InteractiveObject.Shampoo;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import girl.BasicGirl;
import girl.GirlInterface;
import girl.PimpleDecorator;
import girl.SmileDecorator;
import shape.Bubble;
import shape.Flower;
import shape.Wind;
import girl.BlanketDecorator;
import girl.DressDecorator;
import girl.GirlDecorator;
import beautyshop.BeautyShop;
import beautyshop.EndButton;
import beautyshop.Introduction;
import beautyshop.StartButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

import util.ImageLoader;
import util.MinimHelper;

//** ECOs: flowers,wind and bubble involving factory pattern **//
//** clock, 12 states involved in total, background images   **//
//** All images are self created (involve photoshop),        **//
//** Did a lot of adjustments to improve the appearnce,		 **//
//** Additionaly, in order to better handle ECOs, factory    **//
//** and decorator patterns are used                         **//
public class BeautyPanel extends JPanel implements ActionListener {
	private JFrame frame;
	
	public final static int W_WIDTH = 1400;
	public final static int W_HEIGHT = 900;

	// variables for holding mouse position
	private double mouseX;
	private double mouseY;

	// Fields for state and transitions
	private int state = 0;
	private BeautyShop beautyshop;
	//** A case of inclusion polymorphism where the superclass types **//
	//** ArrayList that mixed objects of at least two subclasses     **//
	private ObjectFactory objectMaker;
	private beautyshop.MyObject[] objects = new beautyshop.MyObject[4];
	
	private StartButton startbutton;
	private EndButton endbutton;
	private Introduction introduction;
	private GirlInterface girl;
	private int reactTimer = 100;

	private Timer timer;
	
	private Minim minim;
	// background music & onclick voice
	private AudioPlayer bkmusic, click;

	BeautyPanel(JFrame frame) {
		this.frame = frame;
		
		this.setBackground(Color.white);
		setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));

		objectMaker = new ObjectConcreteFactory();
		beautyshop = new BeautyShop("assets/environment.PNG");
		startbutton = new StartButton(W_WIDTH / 2.8, W_HEIGHT / 1.4, 1.2);
		introduction = new Introduction(W_WIDTH / 5, W_HEIGHT / 13, 1);
		girl = new BasicGirl(W_WIDTH / 1.6, W_HEIGHT / 1.9);
		
		//Major objects must be created using factory pattern
		objects[0] = objectMaker.createObject("hairdryer");
		objects[1] = objectMaker.createObject("shampoo");
		objects[2] = objectMaker.createObject("cabinet");
		objects[3] = objectMaker.createObject("brush");
		endbutton = new EndButton(W_WIDTH / 2, W_HEIGHT / 2, 1.5);
		
		minim = new Minim(new MinimHelper());

		bkmusic = minim.loadFile("cinematic.mp3");
		click = minim.loadFile("tap.mp3");
		
		MyMouseListener ml = new MyMouseListener();
		MyMouseMotionListener mm1 = new MyMouseMotionListener();
		addMouseListener(ml);
		addMouseMotionListener(mm1);

		timer = new Timer(30, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// start scene
		if (state == 0) {
			beautyshop.drawStartScene(g2);
			startbutton.drawButton(g2);
			girl.decorate(g2);
		//** prepare the girl, this should only be called once **//
		} else if (state == 1) {
			girl = new BlanketDecorator(girl, W_WIDTH / 1.54, W_HEIGHT / 1.2, 0.7);
			girl = new PimpleDecorator(girl, W_WIDTH / 1.68, W_HEIGHT / 2.25, 0.014, 4);
			state = 2;
		//** enter the beauty shop, enable the shampoo feature **//
		} else if (state == 2) {
			introduction.setImg(0);
			beautyshop.drawBeautyShop(g2);
			introduction.drawButton(g2);
			girl.decorate(g2);
			
			for(int i=0; i<objects.length; i++) {
				if(i != 0) { // hairdryer should be hidden
					objects[i].drawButton(g2);
				}
			}
		//** wait for washing hair **//
		} else if (state == 3) {
			introduction.setImg(6);
			beautyshop.drawBeautyShop(g2);
			introduction.drawButton(g2);
			girl.decorate(g2);
			
			for(int i=0; i<objects.length; i++) {
				if(i != 0) { // hairdryer should be hidden
					objects[i].drawButton(g2);
				}
			}
		//** this state is only for hairdryer intro **//
		} else if (state == 12) {
			introduction.setImg(1);
			beautyshop.drawBeautyShop(g2);
			introduction.drawButton(g2);
			girl.decorate(g2);
			
			for(int i=0; i<objects.length; i++) {
				if(i != 0) { // hairdryer should be hidden
					objects[i].drawButton(g2);
				}
			}
		//** enable the hairdryer feature **//
		} else if (state == 4) {
			introduction.setImg(1);
			beautyshop.drawBeautyShop(g2);
			introduction.drawButton(g2);
			girl.decorate(g2);
			
			for(int i=0; i<objects.length; i++) {
				objects[i].drawButton(g2);
			}
		//** wait for drying hair **//
		} else if (state == 5) {
			introduction.setImg(6);
			beautyshop.drawBeautyShop(g2);
			introduction.drawButton(g2);
			girl.decorate(g2);
			
			for(int i=0; i<objects.length; i++) {
				objects[i].drawButton(g2);
			}
		//** enable the brush feature **//
		} else if (state == 6) {
			introduction.setImg(3);
			beautyshop.drawBeautyShop(g2);
			introduction.drawButton(g2);
			girl.decorate(g2);
			
			for(int i=0; i<objects.length; i++) {
				if(i != 0) { // hairdryer should be hidden
					objects[i].drawButton(g2);
				}
			}
		//** waiting for makeup **//
		} else if (state == 7) {
			introduction.setImg(6);
			beautyshop.drawBeautyShop(g2);
			introduction.drawButton(g2);
			girl.decorate(g2);
			
			for(int i=0; i<objects.length; i++) {
				if(i != 0) { // hairdryer should be hidden
					objects[i].drawButton(g2);
				}
			}
		} else if (state == 8) {
			introduction.setImg(4);
			// reset the frame
			girl = new BasicGirl(W_WIDTH / 1.6, W_HEIGHT / 1.9);
			state = 9;
		//** trigger the last timer, the game will end after a few seconds **//
		} else if (state == 9) {
			girl = new SmileDecorator(girl, W_WIDTH / 1.645, W_HEIGHT / 1.89, 0.04);
			girl = new DressDecorator(girl, W_WIDTH / 1.617, W_HEIGHT / 1.41, 0.3);
			state = 10;
		} else if (state == 10) {
			beautyshop.drawReference(g2);
		// end game
		} else if (state == 11) {
			beautyshop.drawEndScene(g2);
			endbutton.drawButton(g2);
			girl.decorate(g2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//** counting wash hair time **//
		if(state == 3) {
			reactTimer--;
			if (reactTimer <= 0) {
				objects[1].restore();
				state = 12;
				reactTimer = 100;
			}
		//** counting dry hair time **//
		} else if (state == 5) {
			reactTimer--;
			if (reactTimer <= 0) {
				objects[0].restore();
				//** close the cabinet **//
				objects[2].restore();
				state = 6;
				reactTimer = 100;
			}
		//** counting makeup time **//
		} else if (state == 7) {
			reactTimer--;
			if (reactTimer <= 0) {
				objects[3].restore();
				state = 8;
				reactTimer = 100;
			}
		//** end the game **//
		} else if (state == 10) {
			reactTimer--;
			if (reactTimer <= 0) {
				state = 11;
				reactTimer = 100;
			}
		}
		repaint();
	}

	public class MyMouseListener extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();

			// start scene
			if (state == 0 && startbutton.clicked(mouseX, mouseY)) {
				click.play(0);
				bkmusic.loop();
				state = 1;
			// open the cabinet
			} else if (state == 12 && objects[2].clicked(mouseX, mouseY)) {
				click.play(0);
				state = 4;
				objects[2].react();
			} 
			else if(state == 11 && endbutton.clicked(mouseX, mouseY)) {
				bkmusic.close();
				frame.dispose();
				frame = new BeautyApp("BeautyApp");
				state = 1;
			} 

		}
	}
	
	public class MyMouseMotionListener extends MouseMotionAdapter {
		
		public void mouseDragged(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			
			if(state == 2) {
				// start dragging the shampoo
				// put the object's position to the mouse position
				objects[1].setPos(mouseX, mouseY);
				if(objects[1].hitHair((GirlDecorator) girl)) {
					objects[1].react();
					// this enable the closet feature
					state = 3;
				}
			} else if(state == 4) {
				// start dragging the hairdryer
				// put the object's position to the mouse position
				objects[0].setPos(mouseX, mouseY);
				if(objects[0].hitHair((GirlDecorator) girl)) {
					objects[0].react();
					// this enable the closet feature
					state = 5;
				}
			} else if(state == 6) {
				// start dragging the brush
				// put the object's position to the mouse position
				objects[3].setPos(mouseX, mouseY);
				if(objects[3].hitHair((GirlDecorator) girl)) {
					objects[3].react();
					// this enable the closet feature
					state = 7;
				}
			}
		}
	}

}
