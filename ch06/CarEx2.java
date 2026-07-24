package ch06;

// Car2 타입은 참조형(reference) + 자바 기본형(8)
class Car2 {
	
	void stop() {
		velocity = 0;
	}
	
	// 기본적으로 속성이 있어야 메소드가 돌아간다. 그래서 아래에 선언을 해도 에러가 안뜬다.
	int velocity;
	
}







public class CarEx2 {
	public static void main(String[] args) {
		// 프로그램은 위에 선언한 변수를 밑에 사용 가능. 하지만 그 반대는 불가능.
		int a = 10;
		int b = a; // call by value
		a = 15;
		System.out.println(a+b); // 25
		
		Car2 c1 = new Car2();
		Car2 c2 = new Car2();
		c1.velocity = 100;
		c2.velocity = 200;
		
		System.out.println(c1);
		System.out.println(c2);
		c1 = c2; // call by reference
	
		System.gc(); // 명시적으로 gc 호출
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.velocity  + c2.velocity );
	
		
		for(int i = 0; i < 10; i++) {
			Car2 c3 = new Car2(); // c3 돌려막기 하는 거임. 객체 10개 생성됨.
			System.out.println(c3);
		}
		System.out.println("*****************************");
		
		
		// 객체를 생성하는 이유는? 필드 및 메소드를 사용하기 위해.
		String str = new String("ertgfdsdsefgdrergtfd");
		System.out.println(str.toUpperCase());
		System.out.println(str.length());
		System.out.println(str.replace('e','x'));
		
		// 객체 생성 없이도 클래스 명으로 메소드 및 필드 사용 가능.
		System.out.println(Integer.toBinaryString(32)); // 10진수 32를 2진수로 return;
		System.out.println(Math.PI);
		
	
	}

}
