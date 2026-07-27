package ch06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

/*final(마지막): 클래스, 필드, 메소드
 * 1. 클래스: Super 클래스의 역할을 할 수 없는 클래스. 상속이 불가능한 클래스(java.lang.클래스)
 * 2. 변수(필드, 매개변수, 지역변수): 고정된 값. 상수 선언. 필드는 변수명이 대문자로 선언. 
 * 3. 메소드: 부모클래스가 선언한 메소드.. 오버라이딩 불가, 즉 부모클래스가 선언한 그대로 사용
 * */

// class String2 extends String {}

class Final1 {
	final int KIA = 1;
	final int LOTTE = 2;
	final int a = 0; // 상수는 default 초기값 불가능. 반드시 값을 줘야함.
	
	void prn() {
		int a = 1;
		int b = LOTTE; 
		Color c = Color.ORANGE;
		Color c1 = new Color(255, 200, 0);
	}
	
	void prn1(final int a/*매개변수로 입력된 값 그대로 사용*/, int b) {
		// a = 10;
		b = 20;
		final int c = 10;
	}
	
	final void prn2() {
		System.out.println(KIA);
		System.out.println(LOTTE);
	}

class Final2 extends Final1 {
	@Override
	void prn() { 	}
	// @Override // 오버라이딩 불가
	// void prn2() { 	}
	
}

public class FinalEx1 {
	public static void main(String[] args) {
		Frame f = new Frame();
		Button btn = new Button();
		//상수 사용 이유: 오타를 줄이기 위해서
		f.add(btn, BorderLayout.CENTER);
		System.out.println(f.NORMAL);
	}
}
}
