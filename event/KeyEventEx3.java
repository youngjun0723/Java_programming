package event;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventEx3 extends MFrame implements KeyListener{

	
	
	
	public KeyEventEx3() {
		super(400, 300, new Color(100, 200, 100));
		addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Graphics g = getGraphics(); // Frame에 그림을 그리기 위한 붓
		g.setFont(new Font("Dialog", Font.BOLD, 20));
		g.setColor(Color.white);
		g.clearRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.red);
		g.drawString("code값: "+ e.getKeyCode(), 30, 80);
		g.drawString("문자값: "+ e.getKeyChar(), 30, 110);
	}
	
	
	
	
	@Override // 유니코드 문자가 생성되는 키에만 반응한다.
	public void keyTyped(KeyEvent e) {
		Graphics g = getGraphics(); // Frame에 그림을 그리기 위한 붓
		g.setFont(new Font("Dialog", Font.BOLD, 20));
		
		g.setColor(Color.blue);
		g.drawString("code값: "+ (int)e.getKeyChar(), 30, 150);
		g.drawString("문자값: "+ e.getKeyChar(), 30, 180);
	}
	
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	
	
	public static void main(String[] args) {
		new KeyEventEx3();
	}




}
