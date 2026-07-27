package ch06;

class Static2 {
	//non-static field
	int a = 0; // 반드시 객체를 생성해야 이용 가능
	// static field
	static int b = 0; // 클래스 명으로 바로 접근 가능
	
	// 상수 선언은 일반적으로 static final   or   final static
	final static int KOREA = 1;
	
	// non-static method
	void prn1() {
		System.out.println(a+b);
	}
	
	// static method
	static void prn2() {
		// a 필드는 반드시 객체를 생성해야 하지만, prn2() 메소드는 객체 생성 없이 클래스 명으로 사용 가능하기 때문.
		// System.out.println(a+b);
	}
			
}
public class StaticEx2 {

	public static void main(String[] args) {
		Static2 st1 = new Static2();
		Static2 st2 = new Static2();
		st1.a = 10;
		st2.a = 20;
		System.out.println("st1.a : " + st1.a);
		System.out.println("st2.a : " + st2.a);
		st1.b = 100;
		st2.b = 200;
		System.out.println("st1.b : " + st1.b);
		System.out.println("st2.b : " + st2.b);
	}
}
