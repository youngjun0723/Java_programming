package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RunnableFrameEx1 extends MFrame implements Runnable{

	Color c;
	int x, y;
	Random r;
	
	public RunnableFrameEx1(Color c, int x, int y) {
		super(300, 300, Color.WHITE);
		this.c = c;
		r = new Random();
		setLocation(x, y); // 창이 뜨는 위치 값
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0; i  < 20; i++) {
				x = r.nextInt(300); // 0 ~ 299 난수
				y = r.nextInt(300); // 0 ~ 299 난수
				Thread.sleep(500); // 0.5초
				repaint(); // update 호출
			}
		} catch (Exception e) {}
	}
	
	@Override // 지정한 좌표만 새롭게 그리는 기능
	public void update(Graphics g) {
		g.clearRect(x, y, 10, 10);
		paint(g);
	}
	
	@Override // 실제 그리기 기능
	public void paint(Graphics g/*붓*/ ) {
		super.paint(g);
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}
	
	public static void main(String[] args) {
		RunnableFrameEx1 f1 = new RunnableFrameEx1(Color.PINK, 100, 100);
		RunnableFrameEx1 f2 = new RunnableFrameEx1(Color.BLACK, 400, 100);
		Thread t1 = new Thread(f1);
		Thread t2 = new Thread(f2);
		t1.start();
		t2.start();
	}
}
