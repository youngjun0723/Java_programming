package ch06;

import java.awt.Frame;

/*접근 제어자: 클래스, 필드, 메소드
 * 1. private
 * 2. protected
 * 3. public
 * 4. 선언을 안하는 경우: friendly*/

class Access1 {
	public int a;
	protected int b; // 상속 or 같은 package 가능
	private int c;

	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
		if(speed < 0) {
			this.speed = 0;
		}
	}
}

class Access2 extends Frame{
	
	void prn() {
		String str = paramString();
		System.out.println(str);
	}
	
}


public class AccessEx1 {
	public static void main(String[] args) {
		Access1 ac = new  Access1();
		ac.setSpeed(-10);
		System.out.println(ac.getSpeed());
		
		// Math mt = new Math();
		Frame f = new Frame();
		Access2 ac2 = new Access2();
		ac2.prn();
	}
}
