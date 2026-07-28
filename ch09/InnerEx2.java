package ch09;

class Outer2{
	
	int a = 10;//외부클래스 필드
	void prn() {
		System.out.println("a: " + a);
		//System.out.println("b: " + b);
		//내부클래스의 필드와 메소드를 사용하는 방법은 내부클래스 객체 생성 가능
		Inner2 in = new Inner2();
		in.b = 30;
		in.prn2();
	}
	
	//외부클래스 입장에서는 내부클래스를 메소드의 형태로 인식
	//메소드에는 없는 클래스의 많은 기능이 있다. 상속,객체,인터페이스 구현
	class Inner2{
		int b = 20;//내부클래스 필드
		void prn2() {//내부클래스 메소드
			//prn();//외부 클래스는 객체 생성없이 바로 호출. 재귀 호출 때문에 주석
			System.out.println("a + b = " + (a+b));
		}
	}//class Inner2
}//class Outer2

public class InnerEx2 {
	public static void main(String[] args) {
		//제3의 클래스에서 내부 클래스 사용방법. 사용되는 경우는 거의 없음. <- OCJP 단골 문제
		Outer2 out = new Outer2();
		Outer2.Inner2 in = out.new Inner2();
		in.b = 150;
		in.prn2();
	}
}






