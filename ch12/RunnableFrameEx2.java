package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RunnableFrameEx2 extends MFrame /* implements Runnable */{

	Color c;
	int x, y;
	Random r;
	
	public RunnableFrameEx2(Color c, int x, int y) {
		super(300, 300, Color.WHITE);
		this.c = c;
		r = new Random();
		setLocation(x, y); 
	}
	
	
	public void run() {
		try {
			for(int i = 0; i  < 20; i++) {
				x = r.nextInt(300); 
				y = r.nextInt(300); 
				Thread.sleep(500); 
				repaint(); 
			}
		} catch (Exception e) {}
	}
	
	public void start() {
		run();
	}
	
	@Override
	public void update(Graphics g) {
		g.clearRect(x, y, 10, 10);
		paint(g);
	}
	
	@Override
	public void paint(Graphics g/*붓*/ ) {
		super.paint(g);
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}
	
	public static void main(String[] args) {
		RunnableFrameEx2 f1 = new RunnableFrameEx2(Color.BLUE, 100, 100);
		RunnableFrameEx2 f2 = new RunnableFrameEx2(Color.BLACK, 400, 100);
		f1.start();
		f2.start();
	}
}
